grammar RKQ;
/*
 * ====================
 * Query
 * ====================
 */
kqlquery
:
 queryName '=' redisKQLQuery EOF
;
queryName
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
	selectClasue fromClasue
;
/*
 * ====================
 * select
 * ====================
 */
selectClasue
:
	selectStatement
;

selectStatement
:
	SELECT selectItemKQL
;
selectItemKQL
:
	returnVariableKQL
;
returnVariableKQL
:
variableKQL
;
/*
 * ====================
 * from
 * ====================
 */
fromClasue
:
	FROM varBinding
	(
		',' varBinding
	)*
;
varBinding
:
	fromvariableBinding IN sourceKQL
;
/*
 * ====================
 * fromvariableBinding
 * ====================
 */
 fromvariableBinding
 :
 	variableKQL
 	
 ;
 /*
 * ====================
 * fromvariableBinding
 * ====================
 */
 sourceKQL
 :
 	lookUpExpression
 ;
/*
 * ====================
 * Map Expression
 * ====================
 */
lookUpExpression
:
	'MAIN1' '[' keyKQL ']' ('[' keyKQL ']')*        	 #MainMapLookUp
	|mapVariable '[' keyKQL ']' ('[' keyKQL ']')*      #VariableMapLookUp
	|KEYS         '[' keyVariable ']' 			 #KeysMapLookUp
;
mapVariable
:
	NAME
;
keyKQL
:
	stringKey
	|variableKey
;
stringKey
:
	STRINGRULE
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
	|variableKQL
;
mainMap
:
	MAIN
;
/*
 * ====================
 *	variable
 * ====================
 */
variableKQL
:
	NAME
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
/*
 * ===========================
 * String/Integers Primitives
 * ===========================
 */

STRINGRULE
    :  '"' (ESCAPE | ~["\\])* '"'
    |  '\'' (ESCAPE | ~['\\])* '\''
    ;

fragment ESCAPE
    : '\\' (['"\\/bfnrt] | UNICODE)
    ;
    
fragment UNICODE
    : 'u' HEX HEX HEX HEX
    ;

fragment HEX
    : [0-9a-fA-F]
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