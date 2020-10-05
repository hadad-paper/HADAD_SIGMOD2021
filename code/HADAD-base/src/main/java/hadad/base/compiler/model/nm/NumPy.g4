grammar NumPy; 
 
@header {
package hadad.base.compiler.model.nm;
}

/*
 * ==========================
 * View Declaration
 * ==========================
 */
 
 numPyQuery :
 	viewName ':' importstatement  numPyScript
 ;
 /*
  * ==========================
  * Temp import statement
  * ==========================
  */
  importstatement:
 	'import numpy as' ID  
 ;
/* 
 * ==========================
 * NumPy Script
 * ==========================
 */
 numPyScript:
    numPyStatemnet ( numPyStatemnet)*
 ;

/* 
 * ==========================
 * NumPy Statements 
 * ==========================
 */
 numPyStatemnet:
  matrixName '=' source 
 ;
 
 /*
  * ==========================
  * Source
  * ==========================
  */
  source:
  	numPyMatrixConstruction
  	|numPyExpression
  ;
 /*
  * ==========================
  * Matrix Construction
  * ==========================
  */
  numPyMatrixConstruction
  :
  
  numPyMatrixConstructionMatrixSource
  ;
  numPyMatrixConstructionMatrixSource
  :
  	 load
  ;
  load
  :
   ID '(' mName ',' sep '=' STRING ')'
  ;
  mName
:
	STRING
;

sep
:
	ID
;
/*
 * ==========================
 * NumPy Expression
 * ==========================
 */
numPyExpression
:	
	//Binary Expression
	matrixNameExpression												 								#MatrixIdentifier
	| ID'.matmul(' left=numPyExpression		op=','	 right=numPyExpression ')' 							#MatrixMulExpression
	| ID'.multiply(' left=numPyExpression	op=','	 right=numPyExpression ')' 							#MatrixMulElementwiseExpression
	| ID'.multiply(' left = numericScalar 	op = ','   right = numPyExpression ')'						#MatrixMulScalarExpression
	| ID'.add(' left = numPyExpression 		op = ','   right = numPyExpression 	')'						#MatrixAddExpression
	| ID'.divide('left = numPyExpression 	op = ','   right = numPyExpression ')'						#MatrixDivision
	| ID'.divide('left = numPyExpression 	op = ','   right = numericScalar ')'						#MatrixScalarDivision
	| ID'.subtract(' numPyExpression 		op = ','   right = numPyExpression')' 						#MatrixSubExpression
	
	//Unary Expression
	| ID'.transpose(' numPyExpression ')' 																#MatrixTransposeExpression
	| ID'.trace(' numPyExpression ')'						        									#MatrixTraceExpression
	| ID'.diag('  numPyExpression ')'																	#MatrixDiagonalExpression
	| ID'.power('numPyExpression op=','	numericScalar ')'											    #MatrixPowerExpression
	//| 'tf.linalg.adjoint('tfmExpression')'															#MatrixAdjointExpression
	| ID'.linalg.det('numPyExpression')'																#MatrixDetExpression
	| ID'.linalg.inv('numPyExpression')'																#MatrixInvExpression
	| ID'.linalg.matrix_rank('numPyExpression')'														#MatrixRankExpression
	| ID'.linalg.norm('numPyExpression')'																#MatrixNormExpression
	
	//Statistical Built-in Functions
	| ID'.mean('numPyExpression ')' 																	#MeanExpression	
	| ID'.avg('numPyExpression ')'																		#AvgExpression
	| ID'.var(' numPyExpression ')'																		#VarExpression
	| ID'.sd(' numPyExpression ')'																		#SDExperssion
	| ID'.sum('numPyExpression ')'																		#SumExperssion
	| ID'.amax('numPyExpression ')'																		#MaxExperssion
	| ID'.amin('numPyExpression ')'																		#MinExperssion
	| ID'.mean('numPyExpression op=',' op='axis=0' ')'													#ColumnsMeansExperssion
	| ID'.var(' numPyExpression op=',' op='axis=0' ')'													#ColumnsVarExperssion
	| ID'.sd('  numPyExpression op=',' op='axis=0' ')'													#ColumnsSdsExperssion
	| ID'.sum(' numPyExpression op=',' op='axis=0' ')'													#ColumnsSumExperssion
	| ID'.amax(' numPyExpression op=',' op='axis=0' ')'													#ColumnsMaxExperssion
	| ID'.amin(' numPyExpression op=',' op='axis=0' ')'													#ColumnsMinExperssion
	| ID'.mean('numPyExpression op=',' op='axis=1' ')'													#RowsMeansExperssion
	| ID'.var(' numPyExpression op=',' op='axis=1' ')'													#RowsVarExperssion
	| ID'.sd('  numPyExpression op=',' op='axis=1' ')'													#RowsSdsExperssion
	| ID'.sum(' numPyExpression op=',' op='axis=1' ')'													#RowsSumExperssion
	| ID'.amax(' numPyExpression op=',' op='axis=1' ')'													#RowsMaxExperssion
	| ID'.amin(' numPyExpression op=',' op='axis=1' ')'													#RowsMinExperssion
	;

/*
 * View Name
 */
 viewName:
 	ID
 ;
/*
 * ==============
 * Matrix Name
 * ==============
 */
matrixName
:
	ID
;

/*
 * Matrix name expression
 */
 matrixNameExpression
 :
 	ID
 ;
/* ==============
 * Variable (Matrix) Name
 * ==============
 */
 
/*
 * ==============
 * Numeric Scalar
 * ==============
 */
 numericScalar:
 	INT
 ;
 /*
  * File Path 
  */
  filePath:
   STRING
  ;
/*
 * ================
 * Primitives
 * ================
 */
ID
:
	[a-zA-Z_0-9] [a-zA-Z_0-9]*
;


WHITESPACE
:
	[ \t\n\r]+ -> skip
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

INT
:
	'0'
	| [1-9] [0-9]*
;



/*
 * =========
 * Key Words
 * =========
 */
MATRIX :

 M A T R I X
;


ROWS
:
R O W S
;

COLS
:
C O L S
;

READ
:
  R E A D
; 

fragment
EXP
:
	(
		'E'
		| 'e'
	)
	(
		'+'
		| '-'
	)? INT
;
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



 