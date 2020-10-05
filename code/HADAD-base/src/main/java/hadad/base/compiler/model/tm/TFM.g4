grammar TFM; 

@header {
package hadad.base.compiler.model.tm;
}

/*
 * ==============
 * View Declaration
 * ==============
 */
 
 tfmQuery :
 	viewName ':' importstatement tfmScript
 ;
 /*
  * ==============
  * Temp import statement
  * ==============
  */
  importstatement:
 	'import tensorflow as' ID  
 ;
/* 
 * ==============
 * TF Script
 * ==============
 */
 tfmScript:
   tfmStatemnet (tfmStatemnet)*
 ;

/* 
 * ==============
 * TF Statements 
 * ==============
 */
 tfmStatemnet:
  matrixName '=' source 
  | withStatement
  | sesionRun
 ;
 
 /*
  * Source
  */
  source:
  	tfmMatrixConstruction
  	|tfmExpression
  	|tfGraphInit

  ;
 /*
  * ==============
  * Matrix Construction
  * ==============
  */
  tfmMatrixConstruction
  :
  
  tfmMatrixConstructionMatrixSource
  ;
  tfmMatrixConstructionMatrixSource
  :
  	 load
  ;
  sesionRun
  :
  	ID '.' 'run' '(' ID (','  ID '=' keyVal) * ')'
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
 tfGraphInit
 :
  ID '.' ('Graph()'|'global_variables_initializer()'|'placeholder') ('('ID ',' ID '=' val ')')?
 ;
 
 val
 :
 
 	shape
 
 ;
 shape
 :
  ID '.' ID
 ;
 keyVal
 :
  '{' pair (',' pair)* '}'
 ;
 pair
 :
  ID ':' ID
 ;
withStatement
:
 with gName '.' ('as_default()' | 'Session()' ) (as sess)? ':'

;
with
:
 ID
;
gName
:
ID
;
as
:
 ID
;

sess
:
ID
;
/*
 * ==============
 * TF LA Expression
 * ==============
 */
tfmExpression
:	
	//Binary Expression
	matrixNameExpression												 						#MatrixIdentifier
	| 'tf.matmul(' left=tfmExpression	op=','	 right=tfmExpression ')' 						#MatrixMulExpression
	| 'tf.math.matmul(' left=tfmExpression	op=','	 right=tfmExpression ')' 					#MatrixMulElementwiseExpression
	| 'tf.math.scalar_mul(' left = numericScalar op = ','   right = tfmExpression ')'			#MatrixMulScalarExpression
	| 'tf.add(' left = tfmExpression op = ','   right = tfmExpression 	')'						#MatrixAddExpression
	| 'tf.divide('left = tfmExpression op = ','   right = tfmExpression ')'						#MatrixDivision
	
	//Unary Expression
	| 'tf.transpose(' tfmExpression ')' 														#MatrixTransposeExpression
	| 'tf.linalg.trace(' tfmExpression ')'						        						#MatrixTraceExpression
	| 'tf.linalg.diag('  tfmExpression ')'														#MatrixDiagonalExpression
	| 'tf.linalg.adjoint('tfmExpression')'														#MatrixAdjointExpression
	| 'tf.linalg.det('tfmExpression')'															#MatrixDetExpression
	| 'tf.linalg.inv('tfmExpression')'															#MatrixInvExpression
	| 'tf.linalg.matrix_rank('tfmExpression')'													#MatrixRankExpression
	| 'tf.norm('tfmExpression')'																#MatrixNormExpression
	
	//Statistical Built-in Functions
	| 'tf.reduce_mean('tfmExpression ')' 														#MeanExpression	
	| 'tf.reduce_sum(' tfmExpression op=',' op='axis=0' ')'										#ColumnsSumExperssion
	| 'tf.reduce_sum(' tfmExpression op=',' op='axis=1' ')'										#RowsSumExperssion
	| 'tf.reduce_sum(' tfmExpression ')'														#SumExperssion
	//| 'avg('dmlExpression ')'																	#AvgExpression
//	| 'var(' dmlExpression ')'																	#VarExpression
//	| 'sd(' dmlExpression ')'																	#SDExperssion
//	| 'colSums(' dmlExpression ')'																#ColumnsSumExperssion
//	| 'colMeans('dmlExpression ')'																#ColumnsMeansExperssion
//	| 'colVars(' dmlExpression ')'																#ColumnsVarExperssion
//	| 'colSds('  dmlExpression ')'																#ColumnsSdsExperssion
//	| 'colMaxs(' dmlExpression ')'																#ColumnsMaxsExperssion
//	| 'colMins(' dmlExpression ')'																#ColumnsMinsExperssion
//	| 'rowSums(' dmlExpression ')'																#RowsSumExperssion
//	| 'rowMeans('dmlExpression ')'																#RowsMeansExperssion
//	| 'rowVars(' dmlExpression ')'																#RowsVarExperssion
//	| 'rowSds('  dmlExpression ')'																#RowsSdsExperssion
//	| 'rowMaxs(' dmlExpression ')'																#RowsMaxsExperssion
//	| 'rowMins(' dmlExpression ')'																#RowssMinsExperssion
//	| 'cumsum('	dmlExpression ')'																#CumSumExperssion
//	| 'cumprod(' dmlExpression ')'																#CumProdExperssion
//	| 'cummin(' dmlExpression ')'																#CumMinExperssion
//	| 'cummax(' dmlExpression ')'																#CumMaxExperssion
	//TODO: Add other statistical
	
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



 