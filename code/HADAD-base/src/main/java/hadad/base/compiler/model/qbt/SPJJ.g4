grammar SPJJ;

@header {
package hadad.base.compiler.model.qbt;
}
/*
 * =======================================
 * Query
 * =======================================
 */
sppjqlQuery
:
	viewName '=' sppjQuery EOF
	| '{' sppjRootFieldName ':' sppjQuery '}'
;

viewName
:
	NAME
;
sppjQuery
:
	 sppjFromWhereClause sppjSelectClause
;
sppjRootFieldName
:
	sppjFieldName
;
/*
 * ========================================
 * Select Clause
 * ========================================
 */
sppjSelectClause
:
	sppjSelectStatement
;

sppjSelectStatement
:
	SELECT sppjSelectItem
;

sppjSelectItem
:
	sppjRecordConstruct
	| sppjSelectVar
	| sppjSelectConstant
;

sppjRecordConstruct
:
	 '{' sppjFieldBinding (',' sppjFieldBinding)* '}'
;

sppjFieldBinding
:
	sppjRecordConstructFieldName ':' sppjFieldValue
;

sppjRecordConstructFieldName
:
	key
;

sppjFieldValue
:
	sppjRecordConstruct
	| sppjSelectVar
	| sppjSelectConstant
	| sppjSelectQuery
;

sppjSelectVar
:
	sppjVariable
;

sppjSelectConstant
:
	sppjConstant
;

sppjSelectQuery
:
	sppjQuery
;
/*
 * =======================================
 * From Clause 
 * =======================================
 */
sppjFromWhereClause
:
	sppjFromClause sppjWhereClause?
;

sppjFromClause
:
	FROM sppjBinding
	(
		',' sppjBinding
	)*
;

sppjBinding
:
	sppjFromClauseBindingSource AS sppjFromClauseBindingVar
;
/*
 * =======================================
 * From Binding
 * =======================================
 */
sppjFromClauseBindingSource
:
	sppjSource
;

sppjSource
:
	dataSetName
	| sppjPath 
;

sppjFromClauseBindingVar
:
	sppjVariable
;

sppjWhereClause
:
	WHERE sppjCondition
;

sppjCondition
:
	sppjWhereCondEquality
	| sppjCondition AND sppjCondition
	| '(' sppjCondition ')'
;

sppjWhereCondEquality
:
	sppjWhereCondEqualityLeftTerm '=' sppjWhereCondEqualityRightTerm
;

sppjWhereCondEqualityLeftTerm
:
	sppjCTerm
;

sppjWhereCondEqualityRightTerm
:
	sppjCTerm
;

sppjCTerm
:
	sppjTerm
;

sppjTerm
:
	sppjTermConstant
	| sppjTermVar
	| sppjTermPath
;

sppjTermVar
:
	sppjVariable
;

sppjTermConstant
:
	sppjConstant
;

sppjTermPath
:
	sppjPath
;
/*
 * =======================================
 * PJPathExpr
 * =======================================
 */
sppjPath
:
	sppjPathVar sppjStep+?
;

sppjPathVar
:
	sppjVariable
;

sppjStep
:
	sppjObjStep
;

sppjObjStep
:
	'.' key
;

/*
 * =======================================
 *	Variable
 * =======================================
 */
sppjVariable
:
	NAME
;
/*
 * =======================================
 *	Relation
 * =======================================
 */
dataSetName
:
	NAME
;
/*
 * =======================================
 *	Key
 * =======================================
 */
key
:
	STRING
	| NAME
;
sppjFieldName
:
	STRING
;
sppjConstant
:
	INTEGER
	| STRING
;
/*
 * =======================================
 * Query Keywords
 * =======================================
 */
FROM
:
	F R O M
;

SELECT
:
	S E L E C T
;

WHERE
:
	W H E R E
;

IN
:
	I N
;

MAP
:
	M A P
;

KEYS
:
	K E Y S
;

LIST
:
	L I S T
;

SET
:
	S E T
;

MAIN
:
	M A I N
;

JSONBUILDOBJECT
:
	J S O N B U I L D O B J E C T
;

JSONARRAYELEMENTS
:
	J S O N A R R A Y E L E M E N T S
;

AS
:
	A S
;

AND
:
	A N D
;
/*
 * ===========================
 * String/Integers Primitives
 * ===========================
 */
NAME
:
	[a-zA-Z_] [a-zA-Z_]*
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

INTEGER
:
	'0'
	| [1-9] [0-9]*
;

/*
 * ====================
 *  Skip Whitespace
 * ====================
 */
WHITESPACE
:
	[ \t\n\r]+ -> skip
;
/*
 * ====================
 * Fragments
 * ====================
 */
fragment
A
:
	[aA]
;

fragment
B
:
	[bB]
;

fragment
C
:
	[cC]
;

fragment
D
:
	[dD]
;

fragment
E
:
	[eE]
;

fragment
F
:
	[fF]
;

fragment
G
:
	[gG]
;

fragment
H
:
	[hH]
;

fragment
I
:
	[iI]
;

fragment
J
:
	[jJ]
;

fragment
K
:
	[kK]
;

fragment
L
:
	[lL]
;

fragment
M
:
	[mM]
;

fragment
N
:
	[nN]
;

fragment
O
:
	[oO]
;

fragment
P
:
	[pP]
;

fragment
Q
:
	[qQ]
;

fragment
R
:
	[rR]
;

fragment
S
:
	[sS]
;

fragment
T
:
	[tT]
;

fragment
U
:
	[uU]
;

fragment
V
:
	[vV]
;

fragment
W
:
	[wW]
;

fragment
X
:
	[xX]
;

fragment
Y
:
	[yY]
;

fragment
Z
:
	[zZ]
;