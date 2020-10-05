grammar SQL;
@header {
package hadad.base.compiler.model.pr;
}
/*
 * ====================
 * RqQuery
 * ====================
 */
rqQuery
:
 viewName '=' prQuery EOF
;
viewName
:
	NAME
;
prQuery
:
prSfwQuery
;

/*
 * ====================
 * SfwQuery
 * ====================
 */
prSfwQuery
:
	prSelectClause prFromWhereClauses 
;
prFromWhereClauses
:
   prFromClause prWhereClause?
;
/*
 * ====================
 * SelectClause
 * ====================
 */
prSelectClause
:
	SELECT prSelectStatement
;

prSelectStatement
:
	prSelectItem (',' prSelectItem)*
;
prSelectItem
:
	prTerm
	| NAME
;
/*
 * =====================
 * FromClause
 * =====================
 */
prFromClause
:
	FROM prRelationBinding
	(
		',' prRelationBinding
	)*
;
prRelationBinding
:
	  prSource AS prVariable
;
/*
 * =====================
 * relationName
 * =====================
 */
 prSource
 :
 	prRelationName
 ;
 prRelationName
 :
 	NAME
 	
 ;
 /*
 * =====================
 * variable
 * =====================
 */
 prVariable
 :
 	NAME
 ;
 
/*
 * ====================
 * WhereClause
 * ====================
 */
prWhereClause
:
	prWhereStatement
;

prWhereStatement
:
	WHERE prCondition
;
prCondition
:
	 prEquality
	| prLikeExpression
	| prCondition AND prCondition
	| '(' prCondition ')'
;
prTerm
:
   realtion '.' NAME
   | NAME
   | STRING
;
prEquality
:
prLeftterm  '=' prRightterm
;
prLikeExpression
:
	prTerm LIKE STRING
;
prLeftterm  
:
	prTerm
;
prRightterm
:
	prTerm
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

WHERE
:
	W H E R E
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
	[a-zA-Z_0-9] [a-zA-Z_0-9]*
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