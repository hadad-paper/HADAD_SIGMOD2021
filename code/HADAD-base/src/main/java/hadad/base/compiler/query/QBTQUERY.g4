grammar QBTQUERY;
import RKQ,AJQ,XQQ,PRQ;
@header {
package hadad.base.compiler.query;
}

/*
 * ====================
 * Query
 * ====================
 */
mixedqbt
:
 queryName '=' mixedQBTQuery EOF
;
queryName
:
	NAME
;
mixedQBTQuery
:
	block
;

/*
 * ============
 * Block
 * ============
 */
block
:
	forPattern wherePattern? returnPattern?
;
/*
 * ============
 * For Pattern
 * ============
 */
forPattern
:
	FOR pattern ( ',' pattern)*
;
/*
 * ============
 * Where Pattern
 * ============
 */
wherePattern
:
	'WHERE' mixedcondition
;

/*
 * ============
 * Return Pattern
 * ============
 */
returnPattern
:
	RETURN constructor
;
/*
 * ====================
 * Pattern
 * ====================
 */
pattern
:
	annotation ':' '{' modelPattern '}'
;

/*
 * ====================
 * ModelPattern
 * ====================
 */
 modelPattern
 :
	 jqPattern
	 |kqPattern
	 |xqPattern
	 |rqPattern
 ;
 
/*
 * ====================
 * JQPattern
 * ====================
 */
 
 jqPattern
 :
 formixed whereClause?
 ;
 
 /*
 * ====================
 * KQPattern
 * ====================
 */
 
 kqPattern
 :
 	fromClasue
 ;
/*
 * ====================
 * XQPattern
 * ====================
 */
 
 xqPattern
 :
 	flwrForWhere
 ;
 /*
 * ====================
 * RqPattern
 * ====================
 */
 
 rqPattern
 :
 	sqlQuery
 ;
 /*
 * ====================
 * Condition
 * ====================
 */
mixedcondition
:
	atom
	|'(' mixedcondition ')'
	| mixedcondition AND mixedcondition
;
/*
 * ====================
 * Atom
 * ====================
 */
 atom
 :
 	termmixed '=' termmixed
	
 ;
 /*
 * ====================
 * Term
 * ====================
 */
 termmixed
 :
 	constant
 	//|variablemixed
 	|annotation ':' '{' pathExpr '}'
 ;
/*
 * ====================
 * Constant
 * ====================
 */
constant
:
	stringConstant
	|numericConstant
;
/*
 * ====================
 *	Path Expression
 * ====================
 */
pathExpr
:
	path				   //AQL Syntax
	|lookUpExpression      //KQL Syntax
;

/*
 * =======================
 * Constructor
 * =======================
 */

 constructor
 :
 	annotation ':'  '{' modelConstructor  '}'  
 ;
 /*
 * =======================
 * ModelConstructor
 * =======================
 */
 modelConstructor
 :
	 jqConstructor
	 |kqConstructor
	 |xqConstructor
 ;
 
 /*
 * =======================
 * JQConstructor
 * =======================
 */
 

 jqConstructor
 :
 	recordConstruct
 ;
 /*
 * =======================
 * KQConstructor
 * =======================
 */

 kqConstructor
 :
 	selectItemKQL
 ;
 /*
 * =======================
 * XQConstructor
 * =======================
 */
 xqConstructor
 :
 	flwrReturnConstruct
 ;
/*
 * =======================
 * Annotation
 * =======================
 */
  annotation
  :
    JQ
    |KQ
    |RQ
    |XQ
    |TQ
  ;

/*
 * =======================
 * String Constant 
 * =======================
 */ 
  stringConstant
  :
  	STRINGRULE
  ;
 /*
 * =======================
 * Numeric Constant 
 * =======================
 */ 
  numericConstant
  :
  	INTEGER
  ;
/*
 * =======================
 * KeyWords
 * =======================
 */

FOR
:
	F O R
;

WHERE 
:
	W H E R E
;

RETURN
:
	R E T U R N
;
JQ
:
	J Q
;
KQ
: 	K Q

;
RQ
:
	R Q
;
XQ
:
	X Q
;
TQ
:	T Q
;

AND 
:
	A N D
;
MAIN
:
 M A I N
;

IN
:
	I N
;

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
LIKE
:	L I K E
;
/*
 * ===========================
 * String/Integers Primitives
 * ===========================
 */
mainMap
:
MAIN INTEGER

;
NAME
:
	'$'? [a-zA-Z_] [a-zA-Z_]* 
;
STRINGRULE
    :  '"' (ESCAPE | ~["\\])* '"'
    |  '\'' (ESCAPE | ~['\\])* '\''
    |  '%' (ESCAPE | ~['\\])* '%'
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