grammar QBT;

import RQ, AJ, PR, SJ, PJ, SPJJ;

@header {
package hadad.base.compiler.model.qbt;
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
	prSQuery
;
/*
 * ====================
 * SPPJPattern
 * ====================
 */
sppjPattern
:
	sppjFromWhereClause
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
//qbtTerm '=' qbtTerm

;
/*
 * ====================
 * Term
 * ====================
 */
//qbtTerm
//:
//	qbtConstant
//	| qbtVariable
//	| annotation ':' '{' modelPathExpr '}'
//;
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
	ajConstructor
	| rkConstructor
	| sppjConstructor
	| pjConstructor
	| sjConstructor
	| prConstructor
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

/*
 * =======================
 * Sppj Constructor
 * =======================
 */
sppjConstructor
:
	sppjRecordConstruct
;

/*
 * =======================
 * PJ Constructor
 * =======================
 */
pjConstructor
:
	pjRecordConstruct
;

/*
 * =======================
 * SJ Constructor
 * =======================
 */
sjConstructor
:
	sjRecordConstruct
;
/*
 * =======================
 * PR Constructor
 * =======================
 */
prConstructor
:
	prSelectStatement
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

JSONBUILDOBJECT
:
	J S O N B U I L D O B J E C T
;

JSONARRAYELEMENTS
:
	J S O N A R R A Y E L E M E N T S
;

SOLRJSONBUILDOBJECT
:
	S O L R J S O N B U I L D O B J E C T
;
/*
 * ===========================
 * String/Integers Primitives
 * ===========================
 */
//mainMap
//:
//	MAIN INTEGER
//;

NAME
:
	[a-zA-Z_0-9] [a-zA-Z_0-9]*
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