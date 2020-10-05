grammar AJ;

@header {
package hadad.base.compiler.model.qbt;
}

/* Lexical rules */
NAME
:
	[a-zA-Z_]+ [0-9a-zA-Z_]*
;

BETA
:
	[0-9]+
;

WS
:
	[ \t\r\n]+ -> skip
; // skip spaces, tabs, newlines

/* Grammar rules */

// Queries/Views

aqlquery
:
	viewName '='
	(
		query
		| '{' rootFieldName ':' query '}'
	)
;

viewName
:
	NAME
;

query
:
	forWhereClauses returnClause
;

rootFieldName
:
	fieldName
;

// RETURN

returnClause
:
	'return'
	(
		recordConstruct
		| returnVar
		| returnConstant
	)
; // | arrayConstruct

// arrayConstruct: '[' fieldValue ']';

recordConstruct
:
	'{' fieldBinding
	(
		',' fieldBinding
	)* '}'
;

fieldBinding
:
	recordConstructFieldName ':' fieldValue
;

recordConstructFieldName
:
	fieldName
;

fieldName
:
	STRING
;

fieldValue
:
	recordConstruct
	| returnVar
	| returnConstant
	| returnQuery
;

returnVar
:
	var
	| name '.' NAME
;

name
:
	NAME
;

returnConstant
:
	constant
;

returnQuery
:
	query
;

term
:
	termConstant
	| termVar
	| termPath
;

termVar
:
	var
	| name '.' NAME
;

termConstant
:
	constant
;

termPath
:
	path
;

constant
:
	number
	| STRING
;

number
:
	BETA
;

STRING
:
	'"'
	(
		ESCAPE
		| ~["\\]
	)* '"'
	| '\''
	(
		ESCAPE
		| ~['\\]
	)* '\''
;

fragment
ESCAPE
:
	'\\'
	(
		['"\\/bfnrt]
		| UNICODE
	)
;

fragment
UNICODE
:
	'u' HEX HEX HEX HEX
;

fragment
HEX
:
	[0-9a-fA-F]
;
// PATH EXPRESSIONS

path
:
	pathVar step+
;

pathVar
:
	var
;

var
:
	NAME
;

step
:
	objectStep
	| arrayStep
;

objectStep
:
	'.' key
;

arrayStep
:
	'[' index ']'
;

key
:
	NAME
;

index
:
	number
;

// FOR

forClause
:
	'for' binding
	(
		',' binding
	)*
;

binding
:
	forClauseBindingVar 'in' forClauseBindingSource
;

forClauseBindingVar
:
	var
;

forClauseBindingSource
:
	source
;

source
:
	'dataset' dataSetName
	| path
;

dataSetName
:
	NAME
;

// WHERE (purely conjunctive so far)

whereClause
:
	'where' condition
;

condition
:
	whereCondEquality
	//			| non_path_term '=' non_path_term

	| condition 'and' condition
	| 'some' whereCondSome 'satisfies' condition
	| '(' condition ')'
;

whereCondSome
:
	whereCondBinding
	(
		',' whereCondBinding
	)*
;

whereCondBinding
:
	whereCondBindingVar 'in' whereCondBindingSource
;

whereCondBindingVar
:
	var
;

whereCondBindingSource
:
	source
;

whereCondEquality
:
	whereCondEqualityLeftTerm '=' whereCondEqualityRightTerm
;

whereCondEqualityLeftTerm
:
	cterm
;

whereCondEqualityRightTerm
:
	cterm
;

cterm
:
	term
;

forWhereClauses
:
	forClause whereClause?
;

// non_path_term: constant | var;
