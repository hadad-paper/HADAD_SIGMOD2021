grammar R; 
 
@header {
package hadad.base.compiler.model.rm;
}

/*
 * ===============
 * View Declaration
 * ===============
 */
 
 rQuery :
 	viewName ':' rScript
 ;
/* 
 * ==============
 * R Script
 * ==============
 */
 rScript:
   rStatemnet ';' (rStatemnet ';')*
 ;

/* 
 * ==============
 * R Statements
 * ==============
 */
 rStatemnet:
  matrixName '<-' source 
 ;
 	
 /*
  * ==============
  * Source
  * ==============
  */
  source:
  	rMatrixConstruction
  	|rExpression
  ;
 /*
  * ==============
  * Matrix Construction
  * ==============
  */
  rMatrixConstruction
  :
  
  rMatrixConstructionMatrixSource
  ;
  rMatrixConstructionMatrixSource
  :
     asMatrix '(' asTable '(' mName ',' header '=' flag ',' sep '=' STRING ')' ')'
     |  asMatrix '(' readMM '(' mName ')'')'
  	 
  ;
  asMatrix:
   ID '.' ID
  ;
  asTable
  :
   ID '.' ID
  ;
  mName
  :
  STRING	
  ;
  header
  :
  ID
  ;
  flag:
   'FALSE'
   |'TRUE'
  ;
 sep:
 ID
 ;
 readMM
 :
  ID
 ;
  
/*
 * ==============
 * R LA Expression
 * ==============
 */
rExpression
:	
	//Binary Expression
	matrixNameExpression												# MatrixIdentifier
	| left = rExpression op = '%*%' right = rExpression 				#MatrixMulExpression
	| left = rExpression op = '*'   right = rExpression 				#MatrixMulElementwiseExpression
	| left = numericScalar op = '*'   right = rExpression				#MatrixMulScalarExpression
	| left = rExpression op = '+'   right = rExpression 				#MatrixAddExpression
	| left = rExpression op = '%/%'   right = rExpression 				#MatrixDivision
	| left = rExpression op = '/'   right = numericScalar 				#MatrixScalarDivision
	| left = rExpression op = '-'   right = rExpression 				#MatrixSubExpression
	
	//Unary Expression
	| 't(' rExpression ')' 												#MatrixTransposeExpression
	| 'trace(' rExpression ')'						        			#MatrixTraceExpression
	| 'diag('  rExpression ')'											#MatrixDiagonalExpression
	|  rExpression op='^'												#MatrixPowerExpression
	|  'solve('rExpression ')'											#MatrixInverseExpression
	|	'det(' rExpression ')'											#MatrixDetExpression
	
	// Atomic Expression 
	| '(' rExpression ')' 												#AtomicExpression
	//LogicalExpression 
	| left = rExpression op=('&&' | '&')  right = rExpression			#BooleanAndExpression
	| left = rExpression op=('||' | '|')  right = rExpression			#BooleanOrExpression
	
	//Statistical Built-in Functions
	| 'mean('rExpression ')' 											#MeanExpression	
	| 'avg('rExpression ')'												#AvgExpression
	| 'var(' rExpression ')'											#VarExpression
	| 'sd(' rExpression ')'												#SDExperssion
	| 'colSums(' rExpression ')'										#ColumnsSumExperssion
	| 'colMeans('rExpression ')'										#ColumnsMeansExperssion
	| 'colVars(' rExpression ')'										#ColumnsVarExperssion
	| 'colSds('  rExpression ')'										#ColumnsSdsExperssion
	| 'colMaxs(' rExpression ')'										#ColumnsMaxsExperssion
	| 'colMins(' rExpression ')'										#ColumnsMinsExperssion
	| 'rowSums(' rExpression ')'										#RowsSumExperssion
	| 'rowMeans('rExpression ')'										#RowsMeansExperssion
	| 'rowVars(' rExpression ')'										#RowsVarExperssion
	| 'rowSds('  rExpression ')'										#RowsSdsExperssion
	| 'rowMaxs(' rExpression ')'										#RowsMaxsExperssion
	| 'rowMins(' rExpression ')'										#RowssMinsExperssion
	| 'cumsum('	rExpression ')'											#CumSumExperssion
	| 'cumprod(' rExpression ')'										#CumProdExperssion
	| 'cummin(' rExpression ')'											#CumMinExperssion
	| 'cummax(' rExpression ')'											#CumMaxExperssion
	| 'sum(' rExpression ')'											#SumExperssion
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

//ID
//:
//	STRING
//;

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

FALSE
:
 F A L S E
;

TRUE
:
 T R U E
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



 