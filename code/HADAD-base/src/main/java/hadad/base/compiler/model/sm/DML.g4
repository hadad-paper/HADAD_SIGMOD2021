grammar DML; 
 
@header {
package hadad.base.compiler.model.sm;
}

/*
 * View Declaration
 */
 
 dmlQuery :
 	viewName ':' dmlScript
 ;
/* 
 * ==============
 * DML Script
 * ==============
 */
 dmlScript:
   dmlStatemnet ';' (dmlStatemnet ';')*
 ;

/* 
 * ==============
 * DML Statements
 * ==============
 */
 dmlStatemnet:
  matrixName '=' source 
 ;
 
 /*
  * Source
  */
  source:
  	dmlMatrixConstruction
  	|dmlExpression
  ;
 /*
  * ==============
  * Matrix Construction
  * ==============
  */
  dmlMatrixConstruction
  :
  
  dmlMatrixConstructionMatrixSource
  ;
  dmlMatrixConstructionMatrixSource
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
 * DML LA Expression
 * ==============
 */
dmlExpression
:	
	//Binary Expression
	matrixNameExpression												# MatrixIdentifier
	| left = dmlExpression op = '%*%' right = dmlExpression 			#MatrixMulExpression
	| left = dmlExpression op = '*'   right = dmlExpression 			#MatrixMulElementwiseExpression
	| left = numericScalar op = '*'   right = dmlExpression				#MatrixMulScalarExpression
	| left = dmlExpression op = '+'   right = dmlExpression 			#MatrixAddExpression
	| left = dmlExpression op = '%/%'   right = dmlExpression 			#MatrixDivision
	| left = dmlExpression op = '/'   right = numericScalar 			#MatrixScalarDivision
	| left = dmlExpression op = '-'   right = dmlExpression 			#MatrixSubExpression
	
	//Unary Expression
	| 't(' dmlExpression ')' 											#MatrixTransposeExpression
	| 'trace(' dmlExpression ')'						        		#MatrixTraceExpression
	| 'diag('  dmlExpression ')'										#MatrixDiagonalExpression
	| 'inv('dmlExpression ')'											#MatrixInverseExpression
	|  dmlExpression op='^'												#MatrixPowerExpression
	|	'det(' dmlExpression ')'										#MatrixDetExpression
	
	// Atomic Expression 
	| '(' dmlExpression ')' 											#AtomicExpression
	//LogicalExpression 
	| left = dmlExpression op=('&&' | '&')  right = dmlExpression		#BooleanAndExpression
	| left = dmlExpression op=('||' | '|')  right = dmlExpression		#BooleanOrExpression
	
	//Statistical Built-in Functions
	| 'mean('dmlExpression ')' 											#MeanExpression	
	| 'avg('dmlExpression ')'											#AvgExpression
	| 'var(' dmlExpression ')'											#VarExpression
	| 'sd(' dmlExpression ')'											#SDExperssion
	| 'colSums(' dmlExpression ')'										#ColumnsSumExperssion
	| 'colMeans('dmlExpression ')'										#ColumnsMeansExperssion
	| 'colVars(' dmlExpression ')'										#ColumnsVarExperssion
	| 'colSds('  dmlExpression ')'										#ColumnsSdsExperssion
	| 'colMaxs(' dmlExpression ')'										#ColumnsMaxsExperssion
	| 'colMins(' dmlExpression ')'										#ColumnsMinsExperssion
	| 'rowSums(' dmlExpression ')'										#RowsSumExperssion
	| 'rowMeans('dmlExpression ')'										#RowsMeansExperssion
	| 'rowVars(' dmlExpression ')'										#RowsVarExperssion
	| 'rowSds('  dmlExpression ')'										#RowsSdsExperssion
	| 'rowMaxs(' dmlExpression ')'										#RowsMaxsExperssion
	| 'rowMins(' dmlExpression ')'										#RowssMinsExperssion
	| 'cumsum('	dmlExpression ')'										#CumSumExperssion
	| 'cumprod(' dmlExpression ')'										#CumProdExperssion
	| 'cummin(' dmlExpression ')'										#CumMinExperssion
	| 'cummax(' dmlExpression ')'										#CumMaxExperssion
	| 'sum(' dmlExpression ')'											#SumExperssion
	
	
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



 