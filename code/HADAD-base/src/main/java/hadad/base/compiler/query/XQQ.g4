grammar XQQ;

/* Lexical rules */

ALPHA: [a-zA-Z]+[0-9a-zA-Z]*;
BETA: [0-9a-zA-Z]+;
WS : [ \t\r\n]+ -> skip ; // skip spaces, tabs, newlines

/* Grammar rules */

xquery: queryName '=' (flwr | '<' openRootTag '>' '{' flwr '}' '</' closeRootTag '>');

queryName: NAME;

openRootTag: tag;

closeRootTag: tag;

construct : constructEmptyTag
		  | constructString  
		  | constructVar
		  | constructFlwr;
		  
constructEmptyTag: '<' tag mkattr? '/>' constructDelimeter;

constructString: '<' tag mkattr? '>' constructDelimeter string  '</' tag '>';

constructVar: '<' tag mkattr? '>' constructDelimeter '{' varXQ '}' '</' tag '>' ;

constructFlwr: '<' constructFlwrOpenTag mkattr? '>' constructDelimeter constructFlwrTerm (',' constructFlwrTerm)* '</' constructFlwrCloseTag '>';

constructFlwrTerm: ('{' flwr '}' | construct);

constructDelimeter: ;

constructFlwrOpenTag : tag;

constructFlwrCloseTag : tag;

tag: NAME;

mkattr : '[' mkattrName '=' aterm (',' mkattrName '=' aterm)* ']';

mkattrName: name;

string: STRINGRULE;

name: NAME;

aterm : '{' atermVar '}' | atermString;

atermVar: varXQ;

atermString: string;

varXQ: NAME;

//flwr
flwr :	flwrForWhere
		flwrReturn;
		
flwrFor: 'for ' flwrForVar 'in' flwrForP (','flwrForVar 'in' flwrForP)*;
flwrWhere: 'where' flwrWhereCond;
flwrForWhere : flwrFor flwrWhere?;
flwrReturn: 'return' (flwrReturnVar | flwrReturnString | flwrReturnConstruct);

flwrForVar: varXQ;

flwrForP: p;

flwrWhereCond: flwrWhereCondEquality | '(' flwrWhereCond ')' | flwrWhereCond 'and' flwrWhereCond | flwrWhereCondSome 'satisfies' flwrWhereCond;

flwrWhereCondSome: 'some' flwrWhereCondVar 'in' flwrWhereCondAp (',' flwrWhereCondVar 'in' flwrWhereCondAp)*;

flwrWhereCondVar: varXQ;

flwrWhereCondAp: ap;

flwrWhereCondEquality: flwrWhereCondEqualityLeftTerm '=' flwrWhereCondEqualityRightTerm;

flwrWhereCondEqualityLeftTerm: cterm;

flwrWhereCondEqualityRightTerm: cterm;

cterm: ctermAp | ctermVar | ctermString ;

ctermAp: ap;

ctermVar: varXQ;

ctermString: string;

flwrReturnVar: varXQ;

flwrReturnString: string;

flwrReturnConstruct : construct;

//relative xpath
rp : rpTag | rpAttr | rpText| rp (child|desc) rp ;

child : '/';

desc : '//';

rpTag: tag;

rpAttr : tag '@' name;

rpText: 'text()';

//anchored xpath
ap : document (child|desc) rp | varXQ (child|desc) rp | apAttr;

document: 'document(' sourceXQ ')';

sourceXQ: NAME;
apAttr: varXQ '@' name;

//xpath
p : ap | rp;