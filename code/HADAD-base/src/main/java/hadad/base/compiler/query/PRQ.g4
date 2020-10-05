grammar PRQ;
/*
 * ====================
 * RqQuery
 * ====================
 */
rqQuery
:
 queryName '=' sqlQuery EOF
;
queryName
:
	NAME
;
sqlQuery
:
sfwQueryRQ
;

/*
 * ====================
 * SfwQuery
 * ====================
 */
sfwQueryRQ
:
	selectClauseRQ fromWhereClausesRQ
;
fromWhereClausesRQ
:
   fromClauseRQ whereClauseRQ?
;
/*
 * ====================
 * SelectClause
 * ====================
 */
selectClauseRQ
:
	selectStatementRQ
;

selectStatementRQ
:
	SELECT selectItemRQ (',' selectItemRQ)*
;
selectItemRQ
:
	termRQ
	| NAME
;
/*
 * =====================
 * FromClause
 * =====================
 */
fromClauseRQ
:
	FROM relationBinding
	(
		',' relationBinding
	)*
;
relationBinding
:
	  source AS variableKQ
;
/*
 * =====================
 * relationName
 * =====================
 */
 source
 :
 	relationName
 ;
 relationName
 :
 	NAME
 	
 ;
 /*
 * =====================
 * variable
 * =====================
 */
 variableKQ
 :
 	NAME
 ;
 
/*
 * ====================
 * WhereClause
 * ====================
 */
whereClauseRQ
:
	whereStatementRQ
;

whereStatementRQ
:
	'WHERE' conditionRQ
;
conditionRQ
:
	 equality
	| likeExpression
	| conditionRQ AND conditionRQ
	| '(' conditionRQ ')'
;
termRQ
:
   realtion '.' NAME
   | STRINGRULE
;
equality
:
lefttermRQ  '=' righttermRQ
;
likeExpression
:
	termRQ LIKE STRINGRULE
;
lefttermRQ  
:
	termRQ
;
righttermRQ
:
	termRQ
;
realtion
:
NAME
;
/*
 * ======================
 * Query Keywords
 * ======================
 */
FROM
:
	F R O M
;

SELECT
:
	S E L E C T
;

AS
:
	A S
;
AND
: 
	A N D
;
LIKE
:
	L I K E
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
    :  '"'  (ESCAPE | ~["\\])* '"'
    |  '\'' (ESCAPE | ~['\\])* '\''
    |  '%' (ESCAPE | ~[%\\])* '%'
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