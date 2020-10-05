grammar XQuery;

@header {
package hadad.base.compiler.model.xq;
}

/* Lexical rules */

ALPHA: [a-zA-Z]+[0-9a-zA-Z]*;
BETA: [0-9a-zA-Z]+;
WS : [ \t\r\n]+ -> skip ; // skip spaces, tabs, newlines

/* Grammar rules */

xquery: viewName '=' (flwr | '<' openRootTag '>' '{' flwr '}' '</' closeRootTag '>');

viewName: ALPHA;

openRootTag: tag;

closeRootTag: tag;

construct : constructEmptyTag
		  | constructString  
		  | constructVar
		  | constructFlwr;
		  
constructEmptyTag: '<' tag mkattr? '/>' constructDelimeter;

constructString: '<' tag mkattr? '>' constructDelimeter string  '</' tag '>';

constructVar: '<' tag mkattr? '>' constructDelimeter '{' var '}' '</' tag '>' ;

constructFlwr: '<' constructFlwrOpenTag mkattr? '>' constructDelimeter constructFlwrTerm (',' constructFlwrTerm)* '</' constructFlwrCloseTag '>';

constructFlwrTerm: ('{' flwr '}' | construct);

constructDelimeter: ;

constructFlwrOpenTag : tag;

constructFlwrCloseTag : tag;

tag: ALPHA;

mkattr : '[' mkattrName '=' aterm (',' mkattrName '=' aterm)* ']';

mkattrName: name;

string:  '"' ALPHA '"';

name: ALPHA;

aterm : '{' atermVar '}' | atermString;

atermVar: var;

atermString: string;

var: '$'ALPHA;

//flwr
flwr :	flwrForWhere
		flwrReturn;
		
flwrFor: 'for' flwrForVar 'in' flwrForP (',' flwrForVar 'in' flwrForP)*;

flwrWhere: 'where' flwrWhereCond;

flwrReturn: 'return' (flwrReturnVar | flwrReturnString | flwrReturnConstruct);
flwrForWhere : flwrFor flwrWhere?;
flwrForVar: var;

flwrForP: p;

flwrWhereCond: flwrWhereCondEquality | '(' flwrWhereCond ')' | flwrWhereCond 'and' flwrWhereCond | flwrWhereCondSome 'satisfies' flwrWhereCond;

flwrWhereCondSome: 'some' flwrWhereCondVar 'in' flwrWhereCondAp (',' flwrWhereCondVar 'in' flwrWhereCondAp)*;

flwrWhereCondVar: var;

flwrWhereCondAp: ap;

flwrWhereCondEquality: flwrWhereCondEqualityLeftTerm '=' flwrWhereCondEqualityRightTerm;

flwrWhereCondEqualityLeftTerm: cterm;

flwrWhereCondEqualityRightTerm: cterm;

cterm: ctermAp | ctermVar | ctermString ;

ctermAp: ap;

ctermVar: var;

ctermString: string;

flwrReturnVar: var;

flwrReturnString: string;

flwrReturnConstruct : construct;

//relative xpath
rp : rpTag | rpAttr | rpText | rpDot | rp (child|desc) rp ;

child : '/';

desc : '//';

rpTag: tag;

rpAttr : tag '@' name;

rpText: 'text()';

rpDot: '.';

//anchored xpath
ap : document (child|desc) rp | var (child|desc) rp | apAttr;

document: 'document(' source ')';

source: ALPHA;

apAttr: var '@' name;

//xpath
p : ap | rp;