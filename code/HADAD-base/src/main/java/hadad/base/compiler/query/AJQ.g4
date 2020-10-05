grammar AJQ;

/* Lexical rules */

NAME: [a-zA-Z]+[0-9a-zA-Z]*;
BETA: [0-9]+;
WS : [ \t\r\n]+ -> skip ; // skip spaces, tabs, newlines

/* Grammar rules */

// Queries/Views

aqlquery: queryName '=' (queryAQL | '{' rootFieldName ':' queryAQL '}');

queryName: NAME;

queryAQL: forClause whereClause? returnClause;

rootFieldName: fieldName;

// RETURN

returnClause: 'return' (recordConstruct | returnVar | returnConstant);// | arrayConstruct

// arrayConstruct: '[' fieldValue ']';

recordConstruct: '{' fieldBinding (',' fieldBinding)* '}';

fieldBinding: recordConstructFieldName ':' fieldValue;

recordConstructFieldName: fieldName;

fieldName: string;

fieldValue: recordConstruct | returnVar | returnConstant | returnQuery;

returnVar: varAQL | varRQ;
varRQ : name '.' NAME;
name : NAME;
returnConstant: constant;

returnQuery: queryAQL;

term: termConstant | termVar | termPath;

termVar: varAQL;

termConstant: constant;

termPath: path;

constant: number | string;

number:  BETA;

string: STRINGRULE;

// PATH EXPRESSIONS

path: pathVar step+;

pathVar: varAQL;

varAQL: NAME;

step: objectStep | arrayStep;

objectStep: '.' keyAQL;

arrayStep: '[' index ']';

keyAQL: NAME;

index: number;

// FOR
forClause: 'for ' binding (',' binding)*;
formixed : forClauseBindingVar 'in' forClauseBindingSource (','forClauseBindingVar 'in' forClauseBindingSource)*;
binding: forClauseBindingVar 'in' forClauseBindingSource;

forClauseBindingVar: varAQL;

forClauseBindingSource: sourceAQL;

sourceAQL: 'dataset' dataSetName | path;
//path: pathVar step+;
dataSetName: NAME;

// WHERE (purely conjunctive so far)
whereClause: 'where' condition;

condition	: whereCondEquality
//			| non_path_term '=' non_path_term
            | condition 'and' condition
            | 'some' whereCondSome 'satisfies' condition
            | '(' condition ')';

whereCondSome: whereCondBinding (',' whereCondBinding)*;

whereCondBinding: whereCondBindingVar 'in' whereCondBindingSource;

whereCondBindingVar: varAQL;

whereCondBindingSource: sourceAQL;

whereCondEquality: whereCondEqualityLeftTerm '=' whereCondEqualityRightTerm;

whereCondEqualityLeftTerm: cterm;

whereCondEqualityRightTerm: cterm;

cterm: term;

//non_path_term: constant | varAQL;
