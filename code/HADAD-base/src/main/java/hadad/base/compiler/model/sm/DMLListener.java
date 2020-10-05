// Generated from DML.g4 by ANTLR 4.4

package hadad.base.compiler.model.sm;

import org.antlr.v4.runtime.misc.NotNull;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link DMLParser}.
 */
public interface DMLListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by the {@code VarExpression}
	 * labeled alternative in {@link DMLParser#dmlExpression}.
	 * @param ctx the parse tree
	 */
	void enterVarExpression(@NotNull DMLParser.VarExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code VarExpression}
	 * labeled alternative in {@link DMLParser#dmlExpression}.
	 * @param ctx the parse tree
	 */
	void exitVarExpression(@NotNull DMLParser.VarExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ColumnsSumExperssion}
	 * labeled alternative in {@link DMLParser#dmlExpression}.
	 * @param ctx the parse tree
	 */
	void enterColumnsSumExperssion(@NotNull DMLParser.ColumnsSumExperssionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ColumnsSumExperssion}
	 * labeled alternative in {@link DMLParser#dmlExpression}.
	 * @param ctx the parse tree
	 */
	void exitColumnsSumExperssion(@NotNull DMLParser.ColumnsSumExperssionContext ctx);
	/**
	 * Enter a parse tree produced by {@link DMLParser#source}.
	 * @param ctx the parse tree
	 */
	void enterSource(@NotNull DMLParser.SourceContext ctx);
	/**
	 * Exit a parse tree produced by {@link DMLParser#source}.
	 * @param ctx the parse tree
	 */
	void exitSource(@NotNull DMLParser.SourceContext ctx);
	/**
	 * Enter a parse tree produced by the {@code MatrixAddExpression}
	 * labeled alternative in {@link DMLParser#dmlExpression}.
	 * @param ctx the parse tree
	 */
	void enterMatrixAddExpression(@NotNull DMLParser.MatrixAddExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code MatrixAddExpression}
	 * labeled alternative in {@link DMLParser#dmlExpression}.
	 * @param ctx the parse tree
	 */
	void exitMatrixAddExpression(@NotNull DMLParser.MatrixAddExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code MatrixMulElementwiseExpression}
	 * labeled alternative in {@link DMLParser#dmlExpression}.
	 * @param ctx the parse tree
	 */
	void enterMatrixMulElementwiseExpression(@NotNull DMLParser.MatrixMulElementwiseExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code MatrixMulElementwiseExpression}
	 * labeled alternative in {@link DMLParser#dmlExpression}.
	 * @param ctx the parse tree
	 */
	void exitMatrixMulElementwiseExpression(@NotNull DMLParser.MatrixMulElementwiseExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code RowsSumExperssion}
	 * labeled alternative in {@link DMLParser#dmlExpression}.
	 * @param ctx the parse tree
	 */
	void enterRowsSumExperssion(@NotNull DMLParser.RowsSumExperssionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code RowsSumExperssion}
	 * labeled alternative in {@link DMLParser#dmlExpression}.
	 * @param ctx the parse tree
	 */
	void exitRowsSumExperssion(@NotNull DMLParser.RowsSumExperssionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code MatrixDetExpression}
	 * labeled alternative in {@link DMLParser#dmlExpression}.
	 * @param ctx the parse tree
	 */
	void enterMatrixDetExpression(@NotNull DMLParser.MatrixDetExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code MatrixDetExpression}
	 * labeled alternative in {@link DMLParser#dmlExpression}.
	 * @param ctx the parse tree
	 */
	void exitMatrixDetExpression(@NotNull DMLParser.MatrixDetExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ColumnsMaxsExperssion}
	 * labeled alternative in {@link DMLParser#dmlExpression}.
	 * @param ctx the parse tree
	 */
	void enterColumnsMaxsExperssion(@NotNull DMLParser.ColumnsMaxsExperssionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ColumnsMaxsExperssion}
	 * labeled alternative in {@link DMLParser#dmlExpression}.
	 * @param ctx the parse tree
	 */
	void exitColumnsMaxsExperssion(@NotNull DMLParser.ColumnsMaxsExperssionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code AvgExpression}
	 * labeled alternative in {@link DMLParser#dmlExpression}.
	 * @param ctx the parse tree
	 */
	void enterAvgExpression(@NotNull DMLParser.AvgExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code AvgExpression}
	 * labeled alternative in {@link DMLParser#dmlExpression}.
	 * @param ctx the parse tree
	 */
	void exitAvgExpression(@NotNull DMLParser.AvgExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code MeanExpression}
	 * labeled alternative in {@link DMLParser#dmlExpression}.
	 * @param ctx the parse tree
	 */
	void enterMeanExpression(@NotNull DMLParser.MeanExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code MeanExpression}
	 * labeled alternative in {@link DMLParser#dmlExpression}.
	 * @param ctx the parse tree
	 */
	void exitMeanExpression(@NotNull DMLParser.MeanExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code CumSumExperssion}
	 * labeled alternative in {@link DMLParser#dmlExpression}.
	 * @param ctx the parse tree
	 */
	void enterCumSumExperssion(@NotNull DMLParser.CumSumExperssionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code CumSumExperssion}
	 * labeled alternative in {@link DMLParser#dmlExpression}.
	 * @param ctx the parse tree
	 */
	void exitCumSumExperssion(@NotNull DMLParser.CumSumExperssionContext ctx);
	/**
	 * Enter a parse tree produced by {@link DMLParser#viewName}.
	 * @param ctx the parse tree
	 */
	void enterViewName(@NotNull DMLParser.ViewNameContext ctx);
	/**
	 * Exit a parse tree produced by {@link DMLParser#viewName}.
	 * @param ctx the parse tree
	 */
	void exitViewName(@NotNull DMLParser.ViewNameContext ctx);
	/**
	 * Enter a parse tree produced by the {@code MatrixScalarDivision}
	 * labeled alternative in {@link DMLParser#dmlExpression}.
	 * @param ctx the parse tree
	 */
	void enterMatrixScalarDivision(@NotNull DMLParser.MatrixScalarDivisionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code MatrixScalarDivision}
	 * labeled alternative in {@link DMLParser#dmlExpression}.
	 * @param ctx the parse tree
	 */
	void exitMatrixScalarDivision(@NotNull DMLParser.MatrixScalarDivisionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code BooleanAndExpression}
	 * labeled alternative in {@link DMLParser#dmlExpression}.
	 * @param ctx the parse tree
	 */
	void enterBooleanAndExpression(@NotNull DMLParser.BooleanAndExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code BooleanAndExpression}
	 * labeled alternative in {@link DMLParser#dmlExpression}.
	 * @param ctx the parse tree
	 */
	void exitBooleanAndExpression(@NotNull DMLParser.BooleanAndExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code CumMaxExperssion}
	 * labeled alternative in {@link DMLParser#dmlExpression}.
	 * @param ctx the parse tree
	 */
	void enterCumMaxExperssion(@NotNull DMLParser.CumMaxExperssionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code CumMaxExperssion}
	 * labeled alternative in {@link DMLParser#dmlExpression}.
	 * @param ctx the parse tree
	 */
	void exitCumMaxExperssion(@NotNull DMLParser.CumMaxExperssionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ColumnsMinsExperssion}
	 * labeled alternative in {@link DMLParser#dmlExpression}.
	 * @param ctx the parse tree
	 */
	void enterColumnsMinsExperssion(@NotNull DMLParser.ColumnsMinsExperssionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ColumnsMinsExperssion}
	 * labeled alternative in {@link DMLParser#dmlExpression}.
	 * @param ctx the parse tree
	 */
	void exitColumnsMinsExperssion(@NotNull DMLParser.ColumnsMinsExperssionContext ctx);
	/**
	 * Enter a parse tree produced by {@link DMLParser#asMatrix}.
	 * @param ctx the parse tree
	 */
	void enterAsMatrix(@NotNull DMLParser.AsMatrixContext ctx);
	/**
	 * Exit a parse tree produced by {@link DMLParser#asMatrix}.
	 * @param ctx the parse tree
	 */
	void exitAsMatrix(@NotNull DMLParser.AsMatrixContext ctx);
	/**
	 * Enter a parse tree produced by {@link DMLParser#dmlScript}.
	 * @param ctx the parse tree
	 */
	void enterDmlScript(@NotNull DMLParser.DmlScriptContext ctx);
	/**
	 * Exit a parse tree produced by {@link DMLParser#dmlScript}.
	 * @param ctx the parse tree
	 */
	void exitDmlScript(@NotNull DMLParser.DmlScriptContext ctx);
	/**
	 * Enter a parse tree produced by the {@code MatrixIdentifier}
	 * labeled alternative in {@link DMLParser#dmlExpression}.
	 * @param ctx the parse tree
	 */
	void enterMatrixIdentifier(@NotNull DMLParser.MatrixIdentifierContext ctx);
	/**
	 * Exit a parse tree produced by the {@code MatrixIdentifier}
	 * labeled alternative in {@link DMLParser#dmlExpression}.
	 * @param ctx the parse tree
	 */
	void exitMatrixIdentifier(@NotNull DMLParser.MatrixIdentifierContext ctx);
	/**
	 * Enter a parse tree produced by the {@code SDExperssion}
	 * labeled alternative in {@link DMLParser#dmlExpression}.
	 * @param ctx the parse tree
	 */
	void enterSDExperssion(@NotNull DMLParser.SDExperssionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code SDExperssion}
	 * labeled alternative in {@link DMLParser#dmlExpression}.
	 * @param ctx the parse tree
	 */
	void exitSDExperssion(@NotNull DMLParser.SDExperssionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code MatrixInverseExpression}
	 * labeled alternative in {@link DMLParser#dmlExpression}.
	 * @param ctx the parse tree
	 */
	void enterMatrixInverseExpression(@NotNull DMLParser.MatrixInverseExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code MatrixInverseExpression}
	 * labeled alternative in {@link DMLParser#dmlExpression}.
	 * @param ctx the parse tree
	 */
	void exitMatrixInverseExpression(@NotNull DMLParser.MatrixInverseExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code MatrixDiagonalExpression}
	 * labeled alternative in {@link DMLParser#dmlExpression}.
	 * @param ctx the parse tree
	 */
	void enterMatrixDiagonalExpression(@NotNull DMLParser.MatrixDiagonalExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code MatrixDiagonalExpression}
	 * labeled alternative in {@link DMLParser#dmlExpression}.
	 * @param ctx the parse tree
	 */
	void exitMatrixDiagonalExpression(@NotNull DMLParser.MatrixDiagonalExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link DMLParser#numericScalar}.
	 * @param ctx the parse tree
	 */
	void enterNumericScalar(@NotNull DMLParser.NumericScalarContext ctx);
	/**
	 * Exit a parse tree produced by {@link DMLParser#numericScalar}.
	 * @param ctx the parse tree
	 */
	void exitNumericScalar(@NotNull DMLParser.NumericScalarContext ctx);
	/**
	 * Enter a parse tree produced by the {@code MatrixTraceExpression}
	 * labeled alternative in {@link DMLParser#dmlExpression}.
	 * @param ctx the parse tree
	 */
	void enterMatrixTraceExpression(@NotNull DMLParser.MatrixTraceExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code MatrixTraceExpression}
	 * labeled alternative in {@link DMLParser#dmlExpression}.
	 * @param ctx the parse tree
	 */
	void exitMatrixTraceExpression(@NotNull DMLParser.MatrixTraceExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code MatrixPowerExpression}
	 * labeled alternative in {@link DMLParser#dmlExpression}.
	 * @param ctx the parse tree
	 */
	void enterMatrixPowerExpression(@NotNull DMLParser.MatrixPowerExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code MatrixPowerExpression}
	 * labeled alternative in {@link DMLParser#dmlExpression}.
	 * @param ctx the parse tree
	 */
	void exitMatrixPowerExpression(@NotNull DMLParser.MatrixPowerExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link DMLParser#dmlStatemnet}.
	 * @param ctx the parse tree
	 */
	void enterDmlStatemnet(@NotNull DMLParser.DmlStatemnetContext ctx);
	/**
	 * Exit a parse tree produced by {@link DMLParser#dmlStatemnet}.
	 * @param ctx the parse tree
	 */
	void exitDmlStatemnet(@NotNull DMLParser.DmlStatemnetContext ctx);
	/**
	 * Enter a parse tree produced by {@link DMLParser#header}.
	 * @param ctx the parse tree
	 */
	void enterHeader(@NotNull DMLParser.HeaderContext ctx);
	/**
	 * Exit a parse tree produced by {@link DMLParser#header}.
	 * @param ctx the parse tree
	 */
	void exitHeader(@NotNull DMLParser.HeaderContext ctx);
	/**
	 * Enter a parse tree produced by {@link DMLParser#mName}.
	 * @param ctx the parse tree
	 */
	void enterMName(@NotNull DMLParser.MNameContext ctx);
	/**
	 * Exit a parse tree produced by {@link DMLParser#mName}.
	 * @param ctx the parse tree
	 */
	void exitMName(@NotNull DMLParser.MNameContext ctx);
	/**
	 * Enter a parse tree produced by the {@code SumExperssion}
	 * labeled alternative in {@link DMLParser#dmlExpression}.
	 * @param ctx the parse tree
	 */
	void enterSumExperssion(@NotNull DMLParser.SumExperssionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code SumExperssion}
	 * labeled alternative in {@link DMLParser#dmlExpression}.
	 * @param ctx the parse tree
	 */
	void exitSumExperssion(@NotNull DMLParser.SumExperssionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code BooleanOrExpression}
	 * labeled alternative in {@link DMLParser#dmlExpression}.
	 * @param ctx the parse tree
	 */
	void enterBooleanOrExpression(@NotNull DMLParser.BooleanOrExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code BooleanOrExpression}
	 * labeled alternative in {@link DMLParser#dmlExpression}.
	 * @param ctx the parse tree
	 */
	void exitBooleanOrExpression(@NotNull DMLParser.BooleanOrExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code RowsMeansExperssion}
	 * labeled alternative in {@link DMLParser#dmlExpression}.
	 * @param ctx the parse tree
	 */
	void enterRowsMeansExperssion(@NotNull DMLParser.RowsMeansExperssionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code RowsMeansExperssion}
	 * labeled alternative in {@link DMLParser#dmlExpression}.
	 * @param ctx the parse tree
	 */
	void exitRowsMeansExperssion(@NotNull DMLParser.RowsMeansExperssionContext ctx);
	/**
	 * Enter a parse tree produced by {@link DMLParser#matrixName}.
	 * @param ctx the parse tree
	 */
	void enterMatrixName(@NotNull DMLParser.MatrixNameContext ctx);
	/**
	 * Exit a parse tree produced by {@link DMLParser#matrixName}.
	 * @param ctx the parse tree
	 */
	void exitMatrixName(@NotNull DMLParser.MatrixNameContext ctx);
	/**
	 * Enter a parse tree produced by {@link DMLParser#flag}.
	 * @param ctx the parse tree
	 */
	void enterFlag(@NotNull DMLParser.FlagContext ctx);
	/**
	 * Exit a parse tree produced by {@link DMLParser#flag}.
	 * @param ctx the parse tree
	 */
	void exitFlag(@NotNull DMLParser.FlagContext ctx);
	/**
	 * Enter a parse tree produced by the {@code AtomicExpression}
	 * labeled alternative in {@link DMLParser#dmlExpression}.
	 * @param ctx the parse tree
	 */
	void enterAtomicExpression(@NotNull DMLParser.AtomicExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code AtomicExpression}
	 * labeled alternative in {@link DMLParser#dmlExpression}.
	 * @param ctx the parse tree
	 */
	void exitAtomicExpression(@NotNull DMLParser.AtomicExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code CumProdExperssion}
	 * labeled alternative in {@link DMLParser#dmlExpression}.
	 * @param ctx the parse tree
	 */
	void enterCumProdExperssion(@NotNull DMLParser.CumProdExperssionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code CumProdExperssion}
	 * labeled alternative in {@link DMLParser#dmlExpression}.
	 * @param ctx the parse tree
	 */
	void exitCumProdExperssion(@NotNull DMLParser.CumProdExperssionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ColumnsVarExperssion}
	 * labeled alternative in {@link DMLParser#dmlExpression}.
	 * @param ctx the parse tree
	 */
	void enterColumnsVarExperssion(@NotNull DMLParser.ColumnsVarExperssionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ColumnsVarExperssion}
	 * labeled alternative in {@link DMLParser#dmlExpression}.
	 * @param ctx the parse tree
	 */
	void exitColumnsVarExperssion(@NotNull DMLParser.ColumnsVarExperssionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code CumMinExperssion}
	 * labeled alternative in {@link DMLParser#dmlExpression}.
	 * @param ctx the parse tree
	 */
	void enterCumMinExperssion(@NotNull DMLParser.CumMinExperssionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code CumMinExperssion}
	 * labeled alternative in {@link DMLParser#dmlExpression}.
	 * @param ctx the parse tree
	 */
	void exitCumMinExperssion(@NotNull DMLParser.CumMinExperssionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code RowsMaxsExperssion}
	 * labeled alternative in {@link DMLParser#dmlExpression}.
	 * @param ctx the parse tree
	 */
	void enterRowsMaxsExperssion(@NotNull DMLParser.RowsMaxsExperssionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code RowsMaxsExperssion}
	 * labeled alternative in {@link DMLParser#dmlExpression}.
	 * @param ctx the parse tree
	 */
	void exitRowsMaxsExperssion(@NotNull DMLParser.RowsMaxsExperssionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code MatrixMulExpression}
	 * labeled alternative in {@link DMLParser#dmlExpression}.
	 * @param ctx the parse tree
	 */
	void enterMatrixMulExpression(@NotNull DMLParser.MatrixMulExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code MatrixMulExpression}
	 * labeled alternative in {@link DMLParser#dmlExpression}.
	 * @param ctx the parse tree
	 */
	void exitMatrixMulExpression(@NotNull DMLParser.MatrixMulExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code MatrixDivision}
	 * labeled alternative in {@link DMLParser#dmlExpression}.
	 * @param ctx the parse tree
	 */
	void enterMatrixDivision(@NotNull DMLParser.MatrixDivisionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code MatrixDivision}
	 * labeled alternative in {@link DMLParser#dmlExpression}.
	 * @param ctx the parse tree
	 */
	void exitMatrixDivision(@NotNull DMLParser.MatrixDivisionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code RowsVarExperssion}
	 * labeled alternative in {@link DMLParser#dmlExpression}.
	 * @param ctx the parse tree
	 */
	void enterRowsVarExperssion(@NotNull DMLParser.RowsVarExperssionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code RowsVarExperssion}
	 * labeled alternative in {@link DMLParser#dmlExpression}.
	 * @param ctx the parse tree
	 */
	void exitRowsVarExperssion(@NotNull DMLParser.RowsVarExperssionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ColumnsMeansExperssion}
	 * labeled alternative in {@link DMLParser#dmlExpression}.
	 * @param ctx the parse tree
	 */
	void enterColumnsMeansExperssion(@NotNull DMLParser.ColumnsMeansExperssionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ColumnsMeansExperssion}
	 * labeled alternative in {@link DMLParser#dmlExpression}.
	 * @param ctx the parse tree
	 */
	void exitColumnsMeansExperssion(@NotNull DMLParser.ColumnsMeansExperssionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ColumnsSdsExperssion}
	 * labeled alternative in {@link DMLParser#dmlExpression}.
	 * @param ctx the parse tree
	 */
	void enterColumnsSdsExperssion(@NotNull DMLParser.ColumnsSdsExperssionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ColumnsSdsExperssion}
	 * labeled alternative in {@link DMLParser#dmlExpression}.
	 * @param ctx the parse tree
	 */
	void exitColumnsSdsExperssion(@NotNull DMLParser.ColumnsSdsExperssionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code MatrixMulScalarExpression}
	 * labeled alternative in {@link DMLParser#dmlExpression}.
	 * @param ctx the parse tree
	 */
	void enterMatrixMulScalarExpression(@NotNull DMLParser.MatrixMulScalarExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code MatrixMulScalarExpression}
	 * labeled alternative in {@link DMLParser#dmlExpression}.
	 * @param ctx the parse tree
	 */
	void exitMatrixMulScalarExpression(@NotNull DMLParser.MatrixMulScalarExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link DMLParser#dmlMatrixConstruction}.
	 * @param ctx the parse tree
	 */
	void enterDmlMatrixConstruction(@NotNull DMLParser.DmlMatrixConstructionContext ctx);
	/**
	 * Exit a parse tree produced by {@link DMLParser#dmlMatrixConstruction}.
	 * @param ctx the parse tree
	 */
	void exitDmlMatrixConstruction(@NotNull DMLParser.DmlMatrixConstructionContext ctx);
	/**
	 * Enter a parse tree produced by {@link DMLParser#sep}.
	 * @param ctx the parse tree
	 */
	void enterSep(@NotNull DMLParser.SepContext ctx);
	/**
	 * Exit a parse tree produced by {@link DMLParser#sep}.
	 * @param ctx the parse tree
	 */
	void exitSep(@NotNull DMLParser.SepContext ctx);
	/**
	 * Enter a parse tree produced by {@link DMLParser#filePath}.
	 * @param ctx the parse tree
	 */
	void enterFilePath(@NotNull DMLParser.FilePathContext ctx);
	/**
	 * Exit a parse tree produced by {@link DMLParser#filePath}.
	 * @param ctx the parse tree
	 */
	void exitFilePath(@NotNull DMLParser.FilePathContext ctx);
	/**
	 * Enter a parse tree produced by the {@code RowsSdsExperssion}
	 * labeled alternative in {@link DMLParser#dmlExpression}.
	 * @param ctx the parse tree
	 */
	void enterRowsSdsExperssion(@NotNull DMLParser.RowsSdsExperssionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code RowsSdsExperssion}
	 * labeled alternative in {@link DMLParser#dmlExpression}.
	 * @param ctx the parse tree
	 */
	void exitRowsSdsExperssion(@NotNull DMLParser.RowsSdsExperssionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code RowssMinsExperssion}
	 * labeled alternative in {@link DMLParser#dmlExpression}.
	 * @param ctx the parse tree
	 */
	void enterRowssMinsExperssion(@NotNull DMLParser.RowssMinsExperssionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code RowssMinsExperssion}
	 * labeled alternative in {@link DMLParser#dmlExpression}.
	 * @param ctx the parse tree
	 */
	void exitRowssMinsExperssion(@NotNull DMLParser.RowssMinsExperssionContext ctx);
	/**
	 * Enter a parse tree produced by {@link DMLParser#matrixNameExpression}.
	 * @param ctx the parse tree
	 */
	void enterMatrixNameExpression(@NotNull DMLParser.MatrixNameExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link DMLParser#matrixNameExpression}.
	 * @param ctx the parse tree
	 */
	void exitMatrixNameExpression(@NotNull DMLParser.MatrixNameExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link DMLParser#dmlMatrixConstructionMatrixSource}.
	 * @param ctx the parse tree
	 */
	void enterDmlMatrixConstructionMatrixSource(@NotNull DMLParser.DmlMatrixConstructionMatrixSourceContext ctx);
	/**
	 * Exit a parse tree produced by {@link DMLParser#dmlMatrixConstructionMatrixSource}.
	 * @param ctx the parse tree
	 */
	void exitDmlMatrixConstructionMatrixSource(@NotNull DMLParser.DmlMatrixConstructionMatrixSourceContext ctx);
	/**
	 * Enter a parse tree produced by {@link DMLParser#dmlQuery}.
	 * @param ctx the parse tree
	 */
	void enterDmlQuery(@NotNull DMLParser.DmlQueryContext ctx);
	/**
	 * Exit a parse tree produced by {@link DMLParser#dmlQuery}.
	 * @param ctx the parse tree
	 */
	void exitDmlQuery(@NotNull DMLParser.DmlQueryContext ctx);
	/**
	 * Enter a parse tree produced by {@link DMLParser#readMM}.
	 * @param ctx the parse tree
	 */
	void enterReadMM(@NotNull DMLParser.ReadMMContext ctx);
	/**
	 * Exit a parse tree produced by {@link DMLParser#readMM}.
	 * @param ctx the parse tree
	 */
	void exitReadMM(@NotNull DMLParser.ReadMMContext ctx);
	/**
	 * Enter a parse tree produced by the {@code MatrixTransposeExpression}
	 * labeled alternative in {@link DMLParser#dmlExpression}.
	 * @param ctx the parse tree
	 */
	void enterMatrixTransposeExpression(@NotNull DMLParser.MatrixTransposeExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code MatrixTransposeExpression}
	 * labeled alternative in {@link DMLParser#dmlExpression}.
	 * @param ctx the parse tree
	 */
	void exitMatrixTransposeExpression(@NotNull DMLParser.MatrixTransposeExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code MatrixSubExpression}
	 * labeled alternative in {@link DMLParser#dmlExpression}.
	 * @param ctx the parse tree
	 */
	void enterMatrixSubExpression(@NotNull DMLParser.MatrixSubExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code MatrixSubExpression}
	 * labeled alternative in {@link DMLParser#dmlExpression}.
	 * @param ctx the parse tree
	 */
	void exitMatrixSubExpression(@NotNull DMLParser.MatrixSubExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link DMLParser#asTable}.
	 * @param ctx the parse tree
	 */
	void enterAsTable(@NotNull DMLParser.AsTableContext ctx);
	/**
	 * Exit a parse tree produced by {@link DMLParser#asTable}.
	 * @param ctx the parse tree
	 */
	void exitAsTable(@NotNull DMLParser.AsTableContext ctx);
}