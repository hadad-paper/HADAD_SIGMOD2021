grammar TQL;
@header {
package hadad.base.compiler.model.tq;
}

/*
 * =================================
 * Query
 * =================================
 */
tqlquery
:
 viewName '=' query EOF
;
viewName
:
	NAME
;
query
:
	sfwQuery
;

/*
 * =================================
 * sfwQuery
 * =================================
 */
sfwQuery
:
	selectClause fromClause
;
/*
 * =================================
 * Select Clause
 * =================================
 */
selectClause
:
	selectStatement
;

selectStatement
:
	SELECT selectItem (',' selectItem)*
;
selectItem
:
	returnVariable
;
returnVariable
:
	variable
;
/*
 * =================================
 * From Clause
 * =================================
 */
fromClause
:
	FROM varBinding
	(
		',' varBinding
	)*
;
varBinding
:
	columnvariableBinding IN source
;
/*
 * =================================
 * ColumnvariableBinding
 * =================================
 */
 columnvariableBinding
 :
 	variable
 	
 ;
 /*
 * =================================
 * Source
 * =================================
 */
 source
 :
 	filename
 	|columnLookUp
 ;
/*
 * =================================
 * ColumnLookUp
 * =================================
 */
columnLookUp
:

	columnVar         '[' INTEGER ']' 
;

columnVar
:
	NAME
;
key
:
	stringKey
;
stringKey
:
	STRING
;
filename
:
	FILE '(' NAME ')'
;
/*
 * =================================
 *	variable
 * =================================
 */
variable
:
	NAME
;
/*
 * =================================
 *  Query Keywords
 * =================================
 */
FROM
:
	F R O M
;

SELECT
:
	S E L E C T
;

IN
:
	I N
;
FILE 
:
	F I L E
;
/*
 * =================================
 *  Primitives
 * =================================
 */

NAME
:
	[a-zA-Z_] [a-zA-Z_]*
;
STRING
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