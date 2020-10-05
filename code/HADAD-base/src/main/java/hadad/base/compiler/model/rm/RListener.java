// Generated from R.g4 by ANTLR 4.4

package hadad.base.compiler.model.rm;

import org.antlr.v4.runtime.misc.NotNull;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link RParser}.
 */
public interface RListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by the {@code VarExpression}
	 * labeled alternative in {@link RParser#rExpression}.
	 * @param ctx the parse tree
	 */
	void enterVarExpression(@NotNull RParser.VarExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code VarExpression}
	 * labeled alternative in {@link RParser#rExpression}.
	 * @param ctx the parse tree
	 */
	void exitVarExpression(@NotNull RParser.VarExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ColumnsSumExperssion}
	 * labeled alternative in {@link RParser#rExpression}.
	 * @param ctx the parse tree
	 */
	void enterColumnsSumExperssion(@NotNull RParser.ColumnsSumExperssionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ColumnsSumExperssion}
	 * labeled alternative in {@link RParser#rExpression}.
	 * @param ctx the parse tree
	 */
	void exitColumnsSumExperssion(@NotNull RParser.ColumnsSumExperssionContext ctx);
	/**
	 * Enter a parse tree produced by {@link RParser#source}.
	 * @param ctx the parse tree
	 */
	void enterSource(@NotNull RParser.SourceContext ctx);
	/**
	 * Exit a parse tree produced by {@link RParser#source}.
	 * @param ctx the parse tree
	 */
	void exitSource(@NotNull RParser.SourceContext ctx);
	/**
	 * Enter a parse tree produced by {@link RParser#rScript}.
	 * @param ctx the parse tree
	 */
	void enterRScript(@NotNull RParser.RScriptContext ctx);
	/**
	 * Exit a parse tree produced by {@link RParser#rScript}.
	 * @param ctx the parse tree
	 */
	void exitRScript(@NotNull RParser.RScriptContext ctx);
	/**
	 * Enter a parse tree produced by the {@code MatrixAddExpression}
	 * labeled alternative in {@link RParser#rExpression}.
	 * @param ctx the parse tree
	 */
	void enterMatrixAddExpression(@NotNull RParser.MatrixAddExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code MatrixAddExpression}
	 * labeled alternative in {@link RParser#rExpression}.
	 * @param ctx the parse tree
	 */
	void exitMatrixAddExpression(@NotNull RParser.MatrixAddExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code MatrixMulElementwiseExpression}
	 * labeled alternative in {@link RParser#rExpression}.
	 * @param ctx the parse tree
	 */
	void enterMatrixMulElementwiseExpression(@NotNull RParser.MatrixMulElementwiseExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code MatrixMulElementwiseExpression}
	 * labeled alternative in {@link RParser#rExpression}.
	 * @param ctx the parse tree
	 */
	void exitMatrixMulElementwiseExpression(@NotNull RParser.MatrixMulElementwiseExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code RowsSumExperssion}
	 * labeled alternative in {@link RParser#rExpression}.
	 * @param ctx the parse tree
	 */
	void enterRowsSumExperssion(@NotNull RParser.RowsSumExperssionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code RowsSumExperssion}
	 * labeled alternative in {@link RParser#rExpression}.
	 * @param ctx the parse tree
	 */
	void exitRowsSumExperssion(@NotNull RParser.RowsSumExperssionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code MatrixDetExpression}
	 * labeled alternative in {@link RParser#rExpression}.
	 * @param ctx the parse tree
	 */
	void enterMatrixDetExpression(@NotNull RParser.MatrixDetExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code MatrixDetExpression}
	 * labeled alternative in {@link RParser#rExpression}.
	 * @param ctx the parse tree
	 */
	void exitMatrixDetExpression(@NotNull RParser.MatrixDetExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ColumnsMaxsExperssion}
	 * labeled alternative in {@link RParser#rExpression}.
	 * @param ctx the parse tree
	 */
	void enterColumnsMaxsExperssion(@NotNull RParser.ColumnsMaxsExperssionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ColumnsMaxsExperssion}
	 * labeled alternative in {@link RParser#rExpression}.
	 * @param ctx the parse tree
	 */
	void exitColumnsMaxsExperssion(@NotNull RParser.ColumnsMaxsExperssionContext ctx);
	/**
	 * Enter a parse tree produced by {@link RParser#rStatemnet}.
	 * @param ctx the parse tree
	 */
	void enterRStatemnet(@NotNull RParser.RStatemnetContext ctx);
	/**
	 * Exit a parse tree produced by {@link RParser#rStatemnet}.
	 * @param ctx the parse tree
	 */
	void exitRStatemnet(@NotNull RParser.RStatemnetContext ctx);
	/**
	 * Enter a parse tree produced by the {@code AvgExpression}
	 * labeled alternative in {@link RParser#rExpression}.
	 * @param ctx the parse tree
	 */
	void enterAvgExpression(@NotNull RParser.AvgExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code AvgExpression}
	 * labeled alternative in {@link RParser#rExpression}.
	 * @param ctx the parse tree
	 */
	void exitAvgExpression(@NotNull RParser.AvgExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code MeanExpression}
	 * labeled alternative in {@link RParser#rExpression}.
	 * @param ctx the parse tree
	 */
	void enterMeanExpression(@NotNull RParser.MeanExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code MeanExpression}
	 * labeled alternative in {@link RParser#rExpression}.
	 * @param ctx the parse tree
	 */
	void exitMeanExpression(@NotNull RParser.MeanExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code CumSumExperssion}
	 * labeled alternative in {@link RParser#rExpression}.
	 * @param ctx the parse tree
	 */
	void enterCumSumExperssion(@NotNull RParser.CumSumExperssionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code CumSumExperssion}
	 * labeled alternative in {@link RParser#rExpression}.
	 * @param ctx the parse tree
	 */
	void exitCumSumExperssion(@NotNull RParser.CumSumExperssionContext ctx);
	/**
	 * Enter a parse tree produced by {@link RParser#viewName}.
	 * @param ctx the parse tree
	 */
	void enterViewName(@NotNull RParser.ViewNameContext ctx);
	/**
	 * Exit a parse tree produced by {@link RParser#viewName}.
	 * @param ctx the parse tree
	 */
	void exitViewName(@NotNull RParser.ViewNameContext ctx);
	/**
	 * Enter a parse tree produced by the {@code MatrixScalarDivision}
	 * labeled alternative in {@link RParser#rExpression}.
	 * @param ctx the parse tree
	 */
	void enterMatrixScalarDivision(@NotNull RParser.MatrixScalarDivisionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code MatrixScalarDivision}
	 * labeled alternative in {@link RParser#rExpression}.
	 * @param ctx the parse tree
	 */
	void exitMatrixScalarDivision(@NotNull RParser.MatrixScalarDivisionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code BooleanAndExpression}
	 * labeled alternative in {@link RParser#rExpression}.
	 * @param ctx the parse tree
	 */
	void enterBooleanAndExpression(@NotNull RParser.BooleanAndExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code BooleanAndExpression}
	 * labeled alternative in {@link RParser#rExpression}.
	 * @param ctx the parse tree
	 */
	void exitBooleanAndExpression(@NotNull RParser.BooleanAndExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code CumMaxExperssion}
	 * labeled alternative in {@link RParser#rExpression}.
	 * @param ctx the parse tree
	 */
	void enterCumMaxExperssion(@NotNull RParser.CumMaxExperssionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code CumMaxExperssion}
	 * labeled alternative in {@link RParser#rExpression}.
	 * @param ctx the parse tree
	 */
	void exitCumMaxExperssion(@NotNull RParser.CumMaxExperssionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ColumnsMinsExperssion}
	 * labeled alternative in {@link RParser#rExpression}.
	 * @param ctx the parse tree
	 */
	void enterColumnsMinsExperssion(@NotNull RParser.ColumnsMinsExperssionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ColumnsMinsExperssion}
	 * labeled alternative in {@link RParser#rExpression}.
	 * @param ctx the parse tree
	 */
	void exitColumnsMinsExperssion(@NotNull RParser.ColumnsMinsExperssionContext ctx);
	/**
	 * Enter a parse tree produced by {@link RParser#asMatrix}.
	 * @param ctx the parse tree
	 */
	void enterAsMatrix(@NotNull RParser.AsMatrixContext ctx);
	/**
	 * Exit a parse tree produced by {@link RParser#asMatrix}.
	 * @param ctx the parse tree
	 */
	void exitAsMatrix(@NotNull RParser.AsMatrixContext ctx);
	/**
	 * Enter a parse tree produced by the {@code MatrixIdentifier}
	 * labeled alternative in {@link RParser#rExpression}.
	 * @param ctx the parse tree
	 */
	void enterMatrixIdentifier(@NotNull RParser.MatrixIdentifierContext ctx);
	/**
	 * Exit a parse tree produced by the {@code MatrixIdentifier}
	 * labeled alternative in {@link RParser#rExpression}.
	 * @param ctx the parse tree
	 */
	void exitMatrixIdentifier(@NotNull RParser.MatrixIdentifierContext ctx);
	/**
	 * Enter a parse tree produced by the {@code SDExperssion}
	 * labeled alternative in {@link RParser#rExpression}.
	 * @param ctx the parse tree
	 */
	void enterSDExperssion(@NotNull RParser.SDExperssionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code SDExperssion}
	 * labeled alternative in {@link RParser#rExpression}.
	 * @param ctx the parse tree
	 */
	void exitSDExperssion(@NotNull RParser.SDExperssionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code MatrixInverseExpression}
	 * labeled alternative in {@link RParser#rExpression}.
	 * @param ctx the parse tree
	 */
	void enterMatrixInverseExpression(@NotNull RParser.MatrixInverseExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code MatrixInverseExpression}
	 * labeled alternative in {@link RParser#rExpression}.
	 * @param ctx the parse tree
	 */
	void exitMatrixInverseExpression(@NotNull RParser.MatrixInverseExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code MatrixDiagonalExpression}
	 * labeled alternative in {@link RParser#rExpression}.
	 * @param ctx the parse tree
	 */
	void enterMatrixDiagonalExpression(@NotNull RParser.MatrixDiagonalExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code MatrixDiagonalExpression}
	 * labeled alternative in {@link RParser#rExpression}.
	 * @param ctx the parse tree
	 */
	void exitMatrixDiagonalExpression(@NotNull RParser.MatrixDiagonalExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link RParser#numericScalar}.
	 * @param ctx the parse tree
	 */
	void enterNumericScalar(@NotNull RParser.NumericScalarContext ctx);
	/**
	 * Exit a parse tree produced by {@link RParser#numericScalar}.
	 * @param ctx the parse tree
	 */
	void exitNumericScalar(@NotNull RParser.NumericScalarContext ctx);
	/**
	 * Enter a parse tree produced by the {@code MatrixTraceExpression}
	 * labeled alternative in {@link RParser#rExpression}.
	 * @param ctx the parse tree
	 */
	void enterMatrixTraceExpression(@NotNull RParser.MatrixTraceExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code MatrixTraceExpression}
	 * labeled alternative in {@link RParser#rExpression}.
	 * @param ctx the parse tree
	 */
	void exitMatrixTraceExpression(@NotNull RParser.MatrixTraceExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code MatrixPowerExpression}
	 * labeled alternative in {@link RParser#rExpression}.
	 * @param ctx the parse tree
	 */
	void enterMatrixPowerExpression(@NotNull RParser.MatrixPowerExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code MatrixPowerExpression}
	 * labeled alternative in {@link RParser#rExpression}.
	 * @param ctx the parse tree
	 */
	void exitMatrixPowerExpression(@NotNull RParser.MatrixPowerExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link RParser#header}.
	 * @param ctx the parse tree
	 */
	void enterHeader(@NotNull RParser.HeaderContext ctx);
	/**
	 * Exit a parse tree produced by {@link RParser#header}.
	 * @param ctx the parse tree
	 */
	void exitHeader(@NotNull RParser.HeaderContext ctx);
	/**
	 * Enter a parse tree produced by {@link RParser#mName}.
	 * @param ctx the parse tree
	 */
	void enterMName(@NotNull RParser.MNameContext ctx);
	/**
	 * Exit a parse tree produced by {@link RParser#mName}.
	 * @param ctx the parse tree
	 */
	void exitMName(@NotNull RParser.MNameContext ctx);
	/**
	 * Enter a parse tree produced by the {@code SumExperssion}
	 * labeled alternative in {@link RParser#rExpression}.
	 * @param ctx the parse tree
	 */
	void enterSumExperssion(@NotNull RParser.SumExperssionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code SumExperssion}
	 * labeled alternative in {@link RParser#rExpression}.
	 * @param ctx the parse tree
	 */
	void exitSumExperssion(@NotNull RParser.SumExperssionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code BooleanOrExpression}
	 * labeled alternative in {@link RParser#rExpression}.
	 * @param ctx the parse tree
	 */
	void enterBooleanOrExpression(@NotNull RParser.BooleanOrExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code BooleanOrExpression}
	 * labeled alternative in {@link RParser#rExpression}.
	 * @param ctx the parse tree
	 */
	void exitBooleanOrExpression(@NotNull RParser.BooleanOrExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code RowsMeansExperssion}
	 * labeled alternative in {@link RParser#rExpression}.
	 * @param ctx the parse tree
	 */
	void enterRowsMeansExperssion(@NotNull RParser.RowsMeansExperssionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code RowsMeansExperssion}
	 * labeled alternative in {@link RParser#rExpression}.
	 * @param ctx the parse tree
	 */
	void exitRowsMeansExperssion(@NotNull RParser.RowsMeansExperssionContext ctx);
	/**
	 * Enter a parse tree produced by {@link RParser#rQuery}.
	 * @param ctx the parse tree
	 */
	void enterRQuery(@NotNull RParser.RQueryContext ctx);
	/**
	 * Exit a parse tree produced by {@link RParser#rQuery}.
	 * @param ctx the parse tree
	 */
	void exitRQuery(@NotNull RParser.RQueryContext ctx);
	/**
	 * Enter a parse tree produced by {@link RParser#matrixName}.
	 * @param ctx the parse tree
	 */
	void enterMatrixName(@NotNull RParser.MatrixNameContext ctx);
	/**
	 * Exit a parse tree produced by {@link RParser#matrixName}.
	 * @param ctx the parse tree
	 */
	void exitMatrixName(@NotNull RParser.MatrixNameContext ctx);
	/**
	 * Enter a parse tree produced by {@link RParser#flag}.
	 * @param ctx the parse tree
	 */
	void enterFlag(@NotNull RParser.FlagContext ctx);
	/**
	 * Exit a parse tree produced by {@link RParser#flag}.
	 * @param ctx the parse tree
	 */
	void exitFlag(@NotNull RParser.FlagContext ctx);
	/**
	 * Enter a parse tree produced by the {@code AtomicExpression}
	 * labeled alternative in {@link RParser#rExpression}.
	 * @param ctx the parse tree
	 */
	void enterAtomicExpression(@NotNull RParser.AtomicExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code AtomicExpression}
	 * labeled alternative in {@link RParser#rExpression}.
	 * @param ctx the parse tree
	 */
	void exitAtomicExpression(@NotNull RParser.AtomicExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code CumProdExperssion}
	 * labeled alternative in {@link RParser#rExpression}.
	 * @param ctx the parse tree
	 */
	void enterCumProdExperssion(@NotNull RParser.CumProdExperssionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code CumProdExperssion}
	 * labeled alternative in {@link RParser#rExpression}.
	 * @param ctx the parse tree
	 */
	void exitCumProdExperssion(@NotNull RParser.CumProdExperssionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ColumnsVarExperssion}
	 * labeled alternative in {@link RParser#rExpression}.
	 * @param ctx the parse tree
	 */
	void enterColumnsVarExperssion(@NotNull RParser.ColumnsVarExperssionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ColumnsVarExperssion}
	 * labeled alternative in {@link RParser#rExpression}.
	 * @param ctx the parse tree
	 */
	void exitColumnsVarExperssion(@NotNull RParser.ColumnsVarExperssionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code CumMinExperssion}
	 * labeled alternative in {@link RParser#rExpression}.
	 * @param ctx the parse tree
	 */
	void enterCumMinExperssion(@NotNull RParser.CumMinExperssionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code CumMinExperssion}
	 * labeled alternative in {@link RParser#rExpression}.
	 * @param ctx the parse tree
	 */
	void exitCumMinExperssion(@NotNull RParser.CumMinExperssionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code RowsMaxsExperssion}
	 * labeled alternative in {@link RParser#rExpression}.
	 * @param ctx the parse tree
	 */
	void enterRowsMaxsExperssion(@NotNull RParser.RowsMaxsExperssionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code RowsMaxsExperssion}
	 * labeled alternative in {@link RParser#rExpression}.
	 * @param ctx the parse tree
	 */
	void exitRowsMaxsExperssion(@NotNull RParser.RowsMaxsExperssionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code MatrixMulExpression}
	 * labeled alternative in {@link RParser#rExpression}.
	 * @param ctx the parse tree
	 */
	void enterMatrixMulExpression(@NotNull RParser.MatrixMulExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code MatrixMulExpression}
	 * labeled alternative in {@link RParser#rExpression}.
	 * @param ctx the parse tree
	 */
	void exitMatrixMulExpression(@NotNull RParser.MatrixMulExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code MatrixDivision}
	 * labeled alternative in {@link RParser#rExpression}.
	 * @param ctx the parse tree
	 */
	void enterMatrixDivision(@NotNull RParser.MatrixDivisionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code MatrixDivision}
	 * labeled alternative in {@link RParser#rExpression}.
	 * @param ctx the parse tree
	 */
	void exitMatrixDivision(@NotNull RParser.MatrixDivisionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code RowsVarExperssion}
	 * labeled alternative in {@link RParser#rExpression}.
	 * @param ctx the parse tree
	 */
	void enterRowsVarExperssion(@NotNull RParser.RowsVarExperssionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code RowsVarExperssion}
	 * labeled alternative in {@link RParser#rExpression}.
	 * @param ctx the parse tree
	 */
	void exitRowsVarExperssion(@NotNull RParser.RowsVarExperssionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ColumnsMeansExperssion}
	 * labeled alternative in {@link RParser#rExpression}.
	 * @param ctx the parse tree
	 */
	void enterColumnsMeansExperssion(@NotNull RParser.ColumnsMeansExperssionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ColumnsMeansExperssion}
	 * labeled alternative in {@link RParser#rExpression}.
	 * @param ctx the parse tree
	 */
	void exitColumnsMeansExperssion(@NotNull RParser.ColumnsMeansExperssionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ColumnsSdsExperssion}
	 * labeled alternative in {@link RParser#rExpression}.
	 * @param ctx the parse tree
	 */
	void enterColumnsSdsExperssion(@NotNull RParser.ColumnsSdsExperssionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ColumnsSdsExperssion}
	 * labeled alternative in {@link RParser#rExpression}.
	 * @param ctx the parse tree
	 */
	void exitColumnsSdsExperssion(@NotNull RParser.ColumnsSdsExperssionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code MatrixMulScalarExpression}
	 * labeled alternative in {@link RParser#rExpression}.
	 * @param ctx the parse tree
	 */
	void enterMatrixMulScalarExpression(@NotNull RParser.MatrixMulScalarExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code MatrixMulScalarExpression}
	 * labeled alternative in {@link RParser#rExpression}.
	 * @param ctx the parse tree
	 */
	void exitMatrixMulScalarExpression(@NotNull RParser.MatrixMulScalarExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link RParser#sep}.
	 * @param ctx the parse tree
	 */
	void enterSep(@NotNull RParser.SepContext ctx);
	/**
	 * Exit a parse tree produced by {@link RParser#sep}.
	 * @param ctx the parse tree
	 */
	void exitSep(@NotNull RParser.SepContext ctx);
	/**
	 * Enter a parse tree produced by {@link RParser#rMatrixConstructionMatrixSource}.
	 * @param ctx the parse tree
	 */
	void enterRMatrixConstructionMatrixSource(@NotNull RParser.RMatrixConstructionMatrixSourceContext ctx);
	/**
	 * Exit a parse tree produced by {@link RParser#rMatrixConstructionMatrixSource}.
	 * @param ctx the parse tree
	 */
	void exitRMatrixConstructionMatrixSource(@NotNull RParser.RMatrixConstructionMatrixSourceContext ctx);
	/**
	 * Enter a parse tree produced by {@link RParser#rMatrixConstruction}.
	 * @param ctx the parse tree
	 */
	void enterRMatrixConstruction(@NotNull RParser.RMatrixConstructionContext ctx);
	/**
	 * Exit a parse tree produced by {@link RParser#rMatrixConstruction}.
	 * @param ctx the parse tree
	 */
	void exitRMatrixConstruction(@NotNull RParser.RMatrixConstructionContext ctx);
	/**
	 * Enter a parse tree produced by {@link RParser#filePath}.
	 * @param ctx the parse tree
	 */
	void enterFilePath(@NotNull RParser.FilePathContext ctx);
	/**
	 * Exit a parse tree produced by {@link RParser#filePath}.
	 * @param ctx the parse tree
	 */
	void exitFilePath(@NotNull RParser.FilePathContext ctx);
	/**
	 * Enter a parse tree produced by the {@code RowsSdsExperssion}
	 * labeled alternative in {@link RParser#rExpression}.
	 * @param ctx the parse tree
	 */
	void enterRowsSdsExperssion(@NotNull RParser.RowsSdsExperssionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code RowsSdsExperssion}
	 * labeled alternative in {@link RParser#rExpression}.
	 * @param ctx the parse tree
	 */
	void exitRowsSdsExperssion(@NotNull RParser.RowsSdsExperssionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code RowssMinsExperssion}
	 * labeled alternative in {@link RParser#rExpression}.
	 * @param ctx the parse tree
	 */
	void enterRowssMinsExperssion(@NotNull RParser.RowssMinsExperssionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code RowssMinsExperssion}
	 * labeled alternative in {@link RParser#rExpression}.
	 * @param ctx the parse tree
	 */
	void exitRowssMinsExperssion(@NotNull RParser.RowssMinsExperssionContext ctx);
	/**
	 * Enter a parse tree produced by {@link RParser#matrixNameExpression}.
	 * @param ctx the parse tree
	 */
	void enterMatrixNameExpression(@NotNull RParser.MatrixNameExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link RParser#matrixNameExpression}.
	 * @param ctx the parse tree
	 */
	void exitMatrixNameExpression(@NotNull RParser.MatrixNameExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link RParser#readMM}.
	 * @param ctx the parse tree
	 */
	void enterReadMM(@NotNull RParser.ReadMMContext ctx);
	/**
	 * Exit a parse tree produced by {@link RParser#readMM}.
	 * @param ctx the parse tree
	 */
	void exitReadMM(@NotNull RParser.ReadMMContext ctx);
	/**
	 * Enter a parse tree produced by the {@code MatrixTransposeExpression}
	 * labeled alternative in {@link RParser#rExpression}.
	 * @param ctx the parse tree
	 */
	void enterMatrixTransposeExpression(@NotNull RParser.MatrixTransposeExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code MatrixTransposeExpression}
	 * labeled alternative in {@link RParser#rExpression}.
	 * @param ctx the parse tree
	 */
	void exitMatrixTransposeExpression(@NotNull RParser.MatrixTransposeExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code MatrixSubExpression}
	 * labeled alternative in {@link RParser#rExpression}.
	 * @param ctx the parse tree
	 */
	void enterMatrixSubExpression(@NotNull RParser.MatrixSubExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code MatrixSubExpression}
	 * labeled alternative in {@link RParser#rExpression}.
	 * @param ctx the parse tree
	 */
	void exitMatrixSubExpression(@NotNull RParser.MatrixSubExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link RParser#asTable}.
	 * @param ctx the parse tree
	 */
	void enterAsTable(@NotNull RParser.AsTableContext ctx);
	/**
	 * Exit a parse tree produced by {@link RParser#asTable}.
	 * @param ctx the parse tree
	 */
	void exitAsTable(@NotNull RParser.AsTableContext ctx);
}