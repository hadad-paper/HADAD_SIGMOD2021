grammar PJQLM;

/*
 * =======================================
 * Query
 * =======================================
 */
pjqlQuery
:
	viewName '=' pjQuery EOF
;

viewName
:
	NAME
;

pjQuery
:
	pjSelectClause  pjFromWhereClause
;
/*
 * ========================================
 * Select Clause
 * ========================================
 */
pjSelectClause
:
	pjSelectStatement
;

pjSelectStatement
:
	SELECT pjSelectItem (',' pjSelectItem )*
;

pjSelectItem
:
	pjRecordConstruct			    #pjRecordConstructLabel
	| pjSelectVar				    #pjSelectVarLabel
	| pjSelectConstant			    #pjSelectConstantLabel
	| pjPathScalar AS pjSelectVar   #pjPathScalarLabel
;

pjRecordConstruct
:
	JSONBUILDOBJECT '(' pjFieldBinding
	(
		',' pjFieldBinding
	)* ')'
;

pjFieldBinding
:
	pjRecordConstructFieldName ',' pjFieldValue
;

pjRecordConstructFieldName
:
	pjKey
;

pjFieldValue
:
	pjRecordConstruct
	| pjSelectVar
	| pjSelectConstant
	| pjSelectQuery
;

pjSelectVar
:
	pjVariable
;

pjPathScalar
: 
		pjPathVar pjObjStepScalar
		| '(' pjPathVar pjObjStepScalar ')' cast   
;
pjSelectConstant
:
	pjConstant
;

pjSelectQuery
:
	pjQuery
;
cast
:
	'::INT '
;
/*
 * =======================================
 * From Clause 
 * =======================================
 */
pjFromWhereClause
:
	pjFromClause pjWhereClause?
;

pjFromClause
:
	FROM pjBinding
	(
		',' pjBinding
	)*
;

pjBinding
:
	pjFromClauseBindingSource AS pjFromClauseBindingVar
;
/*
 * =======================================
 * From Binding
 * =======================================
 */
pjFromClauseBindingSource
:
	pjSource
;

pjSource
:
	pjRelation
	| JSONARRAYELEMENTS '(' pjPath ')'
;

pjFromClauseBindingVar
:
	pjVariable
;

pjWhereClause
:
	WHERE pjCondition
;

pjCondition
:
	pjWhereCondEquality
	| pjCondition AND pjCondition
	| '(' pjCondition ')'
;

pjWhereCondEquality
:
	pjWhereCondEqualityLeftTerm '=' pjWhereCondEqualityRightTerm
;

pjWhereCondEqualityLeftTerm
:
	pjCTerm
;

pjWhereCondEqualityRightTerm
:
	pjCTerm
;

pjCTerm
:
	pjTerm
;

pjTerm
:
	pjTermConstant
	| pjTermVar
	| pjTermPath
;

pjTermVar
:
	pjVariable
;

pjTermConstant
:
	pjConstant
;

pjTermPath
:
	pjPath
;
/*
 * =======================================
 * PJPathExpr
 * =======================================
 */
pjPath
:
	pjPathVar pjStep+?
;

pjPathVar
:
	pjVariable
	| pjPathAttr
;

pjStep
:
	pjObjStep
;

pjObjStep
:
	'->' pjKey
;
pjStepScalar
:
	pjObjStepScalar 
;

pjObjStepScalar
:
	'->>' pjKey
	|'->' pjKey
;

/*
 * =======================================
 * PJPathExpr
 * =======================================
 */
pjPathAttr
:
	pjVariable '.' attribute
;

/*
 * =======================================
 *	Variable
 * =======================================
 */
pjVariable
:
	NAME
;
/*
 * =======================================
 *	Relation
 * =======================================
 */
pjRelation
:
	NAME'.'NAME
	|NAME
;
/*
 * =======================================
 *	Key
 * =======================================
 */
pjKey
:
	STRING
	| NAME
;

pjConstant
:
	INTEGER
	| STRING
;
/*
 * =======================================
 *	attribute
 * =======================================
 */
attribute
:
	NAME
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

SELECTT

:
	S E L E C T T
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
INT
: 	
	I N T
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
	[a-zA-Z_]+ [0-9a-zA-Z_]*
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