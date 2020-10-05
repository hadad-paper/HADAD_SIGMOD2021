grammar RQ;

@header {
package hadad.base.compiler.model.qbt;
}

/*
 * ====================
 * Query
 * ====================
 */
kqlquery
:
	viewName '=' redisKQLQuery EOF
;

viewName
:
	NAME
;

redisKQLQuery
:
	sfwQuery
;

/*
 * =======================================
 * Select From Where Query  
 * TODISCUSS:WHERE Clause
 * =======================================
 */
sfwQuery
:
	rkSelectClasue rkFromClasue
;
/*
 * ====================
 * select
 * ====================
 */
rkSelectClasue
:
	rkSelectStatement
;

rkSelectStatement
:
	SELECT rkSelectItem
;

rkSelectItem
:
	rkReturnVariable
	| mapConstructor
;

rkReturnVariable
:
	rkVariable
;

mapConstructor
:
	mapKey '-' '>' '{' rkAttribute
	(
		',' rkAttribute
	)* '}'
;

rkAttribute
:
	rkStringKey ':' rkAttributeValue
;

rkAttributeValue
:
	rkReturnVariable
;

mapKey
:
	NAME
	| NAME '.' NAME
	| STRING
;
/*
 * ====================
 * from
 * ====================
 */
rkFromClasue
:
	FROM varBinding
	(
		',' varBinding
	)*
;

varBinding
:
	fromvariableBinding IN rkSource
;
/*
 * ====================
 * fromvariableBinding
 * ====================
 */
fromvariableBinding
:
	rkVariable
;
/*
 * ====================
 * fromvariableBinding
 * ====================
 */
rkSource
:
	rkLookUpExpression
;
/*
 * ====================
 * Map Expression
 * ====================
 */
rkLookUpExpression
:
	mainMap '[' rkKey ']'
	(
		'[' rkKey ']'
	)* # MainMapLookUp
	| mapVariable '[' rkKey ']'
	(
		'[' rkKey ']'
	)* # VariableMapLookUp
	| KEYS '[' keyVariable ']' # KeysMapLookUp
;

mainMap
:
	MAIN
;

mapVariable
:
	NAME
;

rkKey
:
	rkStringKey
	| variableKey
;

rkStringKey
:
	STRING
;

variableKey
:
	NAME
	| NAME '.' NAME
;

keyVariable
:
	NAME
;

mapName
:
	mainMap
	| rkVariable
;
/*
 * ====================
 *	variable
 * ====================
 */
rkVariable
:
	NAME
	| NAME '.' NAME
;
/*
 * =======================
 * XRedis Query Keywords
 * =======================
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