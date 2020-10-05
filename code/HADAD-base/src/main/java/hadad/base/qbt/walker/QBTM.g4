grammar QBTM;

import KQLM, AQLM, SQLM, SJQLM, PJQLM, SPPJQLM;

@header {
package hadad.base.qbt.walker;
}

/*
 * ====================
 * Query
 * ====================
 */
mixedqbt
:
	viewName '=' qbtQuery EOF
;

viewName
:
	NAME
;

qbtQuery
:
	qbtBlock
;

/*
 * ============
 * Block
 * ============
 */
qbtBlock
:
	qbtForPattern qbtWherePattern? qbtReturnPattern
;
/*
 * ============
 * For Pattern
 * ============
 */
qbtForPattern
:
	FOR qbtPattern
	(
		',' qbtPattern
	)*
;
/*
 * ============
 * Where Pattern
 * ============
 */
qbtWherePattern
:
	WHERE qbtCondition
;

/*
 * ============
 * Return Pattern
 * ============
 */
qbtReturnPattern
:
	RETURN constructor
;
/*
 * ====================
 * Pattern
 * ====================
 */
qbtPattern
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
	ajPattern
	| rkPattern
	| prPattern
	| sppjPattern
	| pjPattern
	| sjPattern
;

/*
 * ====================
 * AJPattern
 * ====================
 */
ajPattern
:
	forClause whereClause?
;

/*
 * ====================
 * RKPattern
 * ====================
 */
rkPattern
:
	rkFromClasue
;
/*
 * ====================
 * PRPattern
 * ====================
 */
prPattern
:
	prQuery
;
/*
 * ====================
 * SPPJPattern
 * ====================
 */
sppjPattern
:
	sppjQuery
;
/*
 * ====================
 * PJPattern
 * ====================
 */
pjPattern
:
	pjQuery
;
/*
 * ====================
 * SJPattern
 * ====================
 */
sjPattern
:
	sjQuery
;
/*
 * ====================
 * Condition
 * ====================
 */
qbtCondition
:
	qbtAtom
	| '(' qbtCondition ')'
	| qbtCondition AND qbtCondition
;
/*
 * ====================
 * Atom
 * ====================
 */
qbtAtom
:
	qbtTermLeft '=' qbtTermRight
;

qbtTermLeft
:
	qbtTerm
;

qbtTermRight
:
	qbtTerm
;
/*
 * ====================
 * Term
 * ====================
 */
qbtTerm
:
//	qbtConstant
	qbtVariable
	//	| annotation ':' '{' modelPathExpr '}'

;
/*
 * ====================
 * Constant
 * ====================
 */
//qbtConstant
//:
//	stringConstant
//	| numericConstant
//;

qbtVariable
:
	NAME
;
/*
 * ====================
 *	Path Expression
 * ====================
 */
modelPathExpr
:
//ajPathExpr
//| sppjPathExpr
//| pjPathExpr

;

/*
 * =======================
 * Constructor
 * =======================
 */
constructor
:
	annotation ':' '{' modelConstructor '}'
;
/*
 * =======================
 * ModelConstructor
 * =======================
 */
modelConstructor
:
//ajConstructor

	| rkConstructor
	| sppjConstructor
	| prConstructor
	| sjConstructor
;

/*
 * =======================
 * AJConstructor 
 * =======================
 */
ajConstructor
:
	recordConstruct
;
/*
 * =======================
 * RKConstructor
 * =======================
 */
rkConstructor
:
	mapConstructor
;
/**
 * prConstructor
 */
prConstructor
:
	prVariable
	(
		',' prVariable
	)*
;

sjConstructor
:
	sjRecordConstruct
;
///*
// * =======================
// * SPPJConstructor
// * =======================
// */

sppjConstructor
:
	sppjRootRecordConstruct
;

/*
 * =======================
 * Annotation
 * =======================
 */
annotation
:
	AJ
	| RK
	| PR
	| PJ
	| SPPJ
	| SJ
	| TQ
;

/*
 * =======================
 * String Constant 
 * =======================
 */
//stringConstant
//:
//	STRINGRULE
//;
/*
 * =======================
 * Numeric Constant 
 * =======================
 */
//numericConstant
//:
//	INTEGER
//;
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

AJ
:
	A J
;

RK
:
	R K
;

PR
:
	P R
;

SPPJ
:
	S P P J
;

PJ
:
	P J
;

SJ
:
	S J
;

XQ
:
	X Q
;

TQ
:
	T Q
;

AND
:
	A N D
;

FROM
:
	F R O M
;

IN
:
	I N
;

SELECT
:
	S E L E C T
;

VALUE 
:
	 V A L U E
; 

AS
:
	A S
;

LIKE
:
	L I K E
;

QUERY
:
	Q U E R Y
;
USE :
 U S E 
;


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