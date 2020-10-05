grammar SJQLM;

/*
 * ==========================
 * SJQL View Definition 
 * ==========================
 */
sjqlquery
:
	viewName '=' sjQuery EOF
;

/*
 * ==========================
 * View Name
 * ==========================
 */
viewName
:
	NAME
;

/*
 * ==========================
 * SJQL Query
 * ==========================
 */
sjQuery
:
	sjCollectionName '/' QUERY '?q=' sjTextSearch? '&' sjProjectFields
;
/*
 * ==========================
 * Collection Name
 * ==========================
 */
sjCollectionName
:
	NAME
;

/*
 * ==========================
 * Text Search Predicate
 * ========================== 
 */
sjTextSearch
:
	sjLeftTerm ':' sjRightTerm
;

sjLeftTerm
:
	sjTerm
;

sjRightTerm
:
	sjTerm
;

sjTerm
:
	sjFieldName
	| sjConstant
;
/*
 * ==========================
 * Project Fields
 * ==========================
 */
sjProjectFields
:
	'fl=' sjFieldName
	(
		',' sjFieldName
	)*
;

sjRecordConstruct
:
	'{' sjAttribute
	(
		',' sjAttribute
	)* '}'
;

sjAttribute
:
	sjKeyName ':' sjFieldName
;
/*
 * ==========================
 * Field Name
 * ==========================
 */
sjFieldName
:
	NAME
;

sjKeyName
:
	STRING
;

sjConstant
:
	STRING
	| INTEGER
;

QUERY
:
	Q U E R Y
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