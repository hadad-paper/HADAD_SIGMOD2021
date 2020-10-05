// Generated from NumPy.g4 by ANTLR 4.4

package hadad.base.compiler.model.nm;

import org.antlr.v4.runtime.misc.NotNull;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link NumPyParser}.
 */
public interface NumPyListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by the {@code ColumnsMaxExperssion}
	 * labeled alternative in {@link NumPyParser#numPyExpression}.
	 * @param ctx the parse tree
	 */
	void enterColumnsMaxExperssion(@NotNull NumPyParser.ColumnsMaxExperssionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ColumnsMaxExperssion}
	 * labeled alternative in {@link NumPyParser#numPyExpression}.
	 * @param ctx the parse tree
	 */
	void exitColumnsMaxExperssion(@NotNull NumPyParser.ColumnsMaxExperssionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code VarExpression}
	 * labeled alternative in {@link NumPyParser#numPyExpression}.
	 * @param ctx the parse tree
	 */
	void enterVarExpression(@NotNull NumPyParser.VarExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code VarExpression}
	 * labeled alternative in {@link NumPyParser#numPyExpression}.
	 * @param ctx the parse tree
	 */
	void exitVarExpression(@NotNull NumPyParser.VarExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ColumnsSumExperssion}
	 * labeled alternative in {@link NumPyParser#numPyExpression}.
	 * @param ctx the parse tree
	 */
	void enterColumnsSumExperssion(@NotNull NumPyParser.ColumnsSumExperssionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ColumnsSumExperssion}
	 * labeled alternative in {@link NumPyParser#numPyExpression}.
	 * @param ctx the parse tree
	 */
	void exitColumnsSumExperssion(@NotNull NumPyParser.ColumnsSumExperssionContext ctx);
	/**
	 * Enter a parse tree produced by {@link NumPyParser#source}.
	 * @param ctx the parse tree
	 */
	void enterSource(@NotNull NumPyParser.SourceContext ctx);
	/**
	 * Exit a parse tree produced by {@link NumPyParser#source}.
	 * @param ctx the parse tree
	 */
	void exitSource(@NotNull NumPyParser.SourceContext ctx);
	/**
	 * Enter a parse tree produced by the {@code MatrixAddExpression}
	 * labeled alternative in {@link NumPyParser#numPyExpression}.
	 * @param ctx the parse tree
	 */
	void enterMatrixAddExpression(@NotNull NumPyParser.MatrixAddExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code MatrixAddExpression}
	 * labeled alternative in {@link NumPyParser#numPyExpression}.
	 * @param ctx the parse tree
	 */
	void exitMatrixAddExpression(@NotNull NumPyParser.MatrixAddExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code MatrixMulElementwiseExpression}
	 * labeled alternative in {@link NumPyParser#numPyExpression}.
	 * @param ctx the parse tree
	 */
	void enterMatrixMulElementwiseExpression(@NotNull NumPyParser.MatrixMulElementwiseExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code MatrixMulElementwiseExpression}
	 * labeled alternative in {@link NumPyParser#numPyExpression}.
	 * @param ctx the parse tree
	 */
	void exitMatrixMulElementwiseExpression(@NotNull NumPyParser.MatrixMulElementwiseExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code RowsSumExperssion}
	 * labeled alternative in {@link NumPyParser#numPyExpression}.
	 * @param ctx the parse tree
	 */
	void enterRowsSumExperssion(@NotNull NumPyParser.RowsSumExperssionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code RowsSumExperssion}
	 * labeled alternative in {@link NumPyParser#numPyExpression}.
	 * @param ctx the parse tree
	 */
	void exitRowsSumExperssion(@NotNull NumPyParser.RowsSumExperssionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code MatrixDetExpression}
	 * labeled alternative in {@link NumPyParser#numPyExpression}.
	 * @param ctx the parse tree
	 */
	void enterMatrixDetExpression(@NotNull NumPyParser.MatrixDetExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code MatrixDetExpression}
	 * labeled alternative in {@link NumPyParser#numPyExpression}.
	 * @param ctx the parse tree
	 */
	void exitMatrixDetExpression(@NotNull NumPyParser.MatrixDetExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code AvgExpression}
	 * labeled alternative in {@link NumPyParser#numPyExpression}.
	 * @param ctx the parse tree
	 */
	void enterAvgExpression(@NotNull NumPyParser.AvgExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code AvgExpression}
	 * labeled alternative in {@link NumPyParser#numPyExpression}.
	 * @param ctx the parse tree
	 */
	void exitAvgExpression(@NotNull NumPyParser.AvgExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code MeanExpression}
	 * labeled alternative in {@link NumPyParser#numPyExpression}.
	 * @param ctx the parse tree
	 */
	void enterMeanExpression(@NotNull NumPyParser.MeanExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code MeanExpression}
	 * labeled alternative in {@link NumPyParser#numPyExpression}.
	 * @param ctx the parse tree
	 */
	void exitMeanExpression(@NotNull NumPyParser.MeanExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link NumPyParser#viewName}.
	 * @param ctx the parse tree
	 */
	void enterViewName(@NotNull NumPyParser.ViewNameContext ctx);
	/**
	 * Exit a parse tree produced by {@link NumPyParser#viewName}.
	 * @param ctx the parse tree
	 */
	void exitViewName(@NotNull NumPyParser.ViewNameContext ctx);
	/**
	 * Enter a parse tree produced by {@link NumPyParser#numPyQuery}.
	 * @param ctx the parse tree
	 */
	void enterNumPyQuery(@NotNull NumPyParser.NumPyQueryContext ctx);
	/**
	 * Exit a parse tree produced by {@link NumPyParser#numPyQuery}.
	 * @param ctx the parse tree
	 */
	void exitNumPyQuery(@NotNull NumPyParser.NumPyQueryContext ctx);
	/**
	 * Enter a parse tree produced by the {@code MatrixScalarDivision}
	 * labeled alternative in {@link NumPyParser#numPyExpression}.
	 * @param ctx the parse tree
	 */
	void enterMatrixScalarDivision(@NotNull NumPyParser.MatrixScalarDivisionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code MatrixScalarDivision}
	 * labeled alternative in {@link NumPyParser#numPyExpression}.
	 * @param ctx the parse tree
	 */
	void exitMatrixScalarDivision(@NotNull NumPyParser.MatrixScalarDivisionContext ctx);
	/**
	 * Enter a parse tree produced by {@link NumPyParser#numPyStatemnet}.
	 * @param ctx the parse tree
	 */
	void enterNumPyStatemnet(@NotNull NumPyParser.NumPyStatemnetContext ctx);
	/**
	 * Exit a parse tree produced by {@link NumPyParser#numPyStatemnet}.
	 * @param ctx the parse tree
	 */
	void exitNumPyStatemnet(@NotNull NumPyParser.NumPyStatemnetContext ctx);
	/**
	 * Enter a parse tree produced by {@link NumPyParser#numPyScript}.
	 * @param ctx the parse tree
	 */
	void enterNumPyScript(@NotNull NumPyParser.NumPyScriptContext ctx);
	/**
	 * Exit a parse tree produced by {@link NumPyParser#numPyScript}.
	 * @param ctx the parse tree
	 */
	void exitNumPyScript(@NotNull NumPyParser.NumPyScriptContext ctx);
	/**
	 * Enter a parse tree produced by {@link NumPyParser#numPyMatrixConstructionMatrixSource}.
	 * @param ctx the parse tree
	 */
	void enterNumPyMatrixConstructionMatrixSource(@NotNull NumPyParser.NumPyMatrixConstructionMatrixSourceContext ctx);
	/**
	 * Exit a parse tree produced by {@link NumPyParser#numPyMatrixConstructionMatrixSource}.
	 * @param ctx the parse tree
	 */
	void exitNumPyMatrixConstructionMatrixSource(@NotNull NumPyParser.NumPyMatrixConstructionMatrixSourceContext ctx);
	/**
	 * Enter a parse tree produced by {@link NumPyParser#numPyMatrixConstruction}.
	 * @param ctx the parse tree
	 */
	void enterNumPyMatrixConstruction(@NotNull NumPyParser.NumPyMatrixConstructionContext ctx);
	/**
	 * Exit a parse tree produced by {@link NumPyParser#numPyMatrixConstruction}.
	 * @param ctx the parse tree
	 */
	void exitNumPyMatrixConstruction(@NotNull NumPyParser.NumPyMatrixConstructionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code MatrixIdentifier}
	 * labeled alternative in {@link NumPyParser#numPyExpression}.
	 * @param ctx the parse tree
	 */
	void enterMatrixIdentifier(@NotNull NumPyParser.MatrixIdentifierContext ctx);
	/**
	 * Exit a parse tree produced by the {@code MatrixIdentifier}
	 * labeled alternative in {@link NumPyParser#numPyExpression}.
	 * @param ctx the parse tree
	 */
	void exitMatrixIdentifier(@NotNull NumPyParser.MatrixIdentifierContext ctx);
	/**
	 * Enter a parse tree produced by the {@code SDExperssion}
	 * labeled alternative in {@link NumPyParser#numPyExpression}.
	 * @param ctx the parse tree
	 */
	void enterSDExperssion(@NotNull NumPyParser.SDExperssionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code SDExperssion}
	 * labeled alternative in {@link NumPyParser#numPyExpression}.
	 * @param ctx the parse tree
	 */
	void exitSDExperssion(@NotNull NumPyParser.SDExperssionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code MatrixDiagonalExpression}
	 * labeled alternative in {@link NumPyParser#numPyExpression}.
	 * @param ctx the parse tree
	 */
	void enterMatrixDiagonalExpression(@NotNull NumPyParser.MatrixDiagonalExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code MatrixDiagonalExpression}
	 * labeled alternative in {@link NumPyParser#numPyExpression}.
	 * @param ctx the parse tree
	 */
	void exitMatrixDiagonalExpression(@NotNull NumPyParser.MatrixDiagonalExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link NumPyParser#numericScalar}.
	 * @param ctx the parse tree
	 */
	void enterNumericScalar(@NotNull NumPyParser.NumericScalarContext ctx);
	/**
	 * Exit a parse tree produced by {@link NumPyParser#numericScalar}.
	 * @param ctx the parse tree
	 */
	void exitNumericScalar(@NotNull NumPyParser.NumericScalarContext ctx);
	/**
	 * Enter a parse tree produced by the {@code MatrixTraceExpression}
	 * labeled alternative in {@link NumPyParser#numPyExpression}.
	 * @param ctx the parse tree
	 */
	void enterMatrixTraceExpression(@NotNull NumPyParser.MatrixTraceExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code MatrixTraceExpression}
	 * labeled alternative in {@link NumPyParser#numPyExpression}.
	 * @param ctx the parse tree
	 */
	void exitMatrixTraceExpression(@NotNull NumPyParser.MatrixTraceExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code MatrixPowerExpression}
	 * labeled alternative in {@link NumPyParser#numPyExpression}.
	 * @param ctx the parse tree
	 */
	void enterMatrixPowerExpression(@NotNull NumPyParser.MatrixPowerExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code MatrixPowerExpression}
	 * labeled alternative in {@link NumPyParser#numPyExpression}.
	 * @param ctx the parse tree
	 */
	void exitMatrixPowerExpression(@NotNull NumPyParser.MatrixPowerExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code MatrixRankExpression}
	 * labeled alternative in {@link NumPyParser#numPyExpression}.
	 * @param ctx the parse tree
	 */
	void enterMatrixRankExpression(@NotNull NumPyParser.MatrixRankExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code MatrixRankExpression}
	 * labeled alternative in {@link NumPyParser#numPyExpression}.
	 * @param ctx the parse tree
	 */
	void exitMatrixRankExpression(@NotNull NumPyParser.MatrixRankExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link NumPyParser#mName}.
	 * @param ctx the parse tree
	 */
	void enterMName(@NotNull NumPyParser.MNameContext ctx);
	/**
	 * Exit a parse tree produced by {@link NumPyParser#mName}.
	 * @param ctx the parse tree
	 */
	void exitMName(@NotNull NumPyParser.MNameContext ctx);
	/**
	 * Enter a parse tree produced by the {@code SumExperssion}
	 * labeled alternative in {@link NumPyParser#numPyExpression}.
	 * @param ctx the parse tree
	 */
	void enterSumExperssion(@NotNull NumPyParser.SumExperssionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code SumExperssion}
	 * labeled alternative in {@link NumPyParser#numPyExpression}.
	 * @param ctx the parse tree
	 */
	void exitSumExperssion(@NotNull NumPyParser.SumExperssionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code RowsMeansExperssion}
	 * labeled alternative in {@link NumPyParser#numPyExpression}.
	 * @param ctx the parse tree
	 */
	void enterRowsMeansExperssion(@NotNull NumPyParser.RowsMeansExperssionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code RowsMeansExperssion}
	 * labeled alternative in {@link NumPyParser#numPyExpression}.
	 * @param ctx the parse tree
	 */
	void exitRowsMeansExperssion(@NotNull NumPyParser.RowsMeansExperssionContext ctx);
	/**
	 * Enter a parse tree produced by {@link NumPyParser#matrixName}.
	 * @param ctx the parse tree
	 */
	void enterMatrixName(@NotNull NumPyParser.MatrixNameContext ctx);
	/**
	 * Exit a parse tree produced by {@link NumPyParser#matrixName}.
	 * @param ctx the parse tree
	 */
	void exitMatrixName(@NotNull NumPyParser.MatrixNameContext ctx);
	/**
	 * Enter a parse tree produced by the {@code RowsMinExperssion}
	 * labeled alternative in {@link NumPyParser#numPyExpression}.
	 * @param ctx the parse tree
	 */
	void enterRowsMinExperssion(@NotNull NumPyParser.RowsMinExperssionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code RowsMinExperssion}
	 * labeled alternative in {@link NumPyParser#numPyExpression}.
	 * @param ctx the parse tree
	 */
	void exitRowsMinExperssion(@NotNull NumPyParser.RowsMinExperssionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ColumnsVarExperssion}
	 * labeled alternative in {@link NumPyParser#numPyExpression}.
	 * @param ctx the parse tree
	 */
	void enterColumnsVarExperssion(@NotNull NumPyParser.ColumnsVarExperssionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ColumnsVarExperssion}
	 * labeled alternative in {@link NumPyParser#numPyExpression}.
	 * @param ctx the parse tree
	 */
	void exitColumnsVarExperssion(@NotNull NumPyParser.ColumnsVarExperssionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code MatrixMulExpression}
	 * labeled alternative in {@link NumPyParser#numPyExpression}.
	 * @param ctx the parse tree
	 */
	void enterMatrixMulExpression(@NotNull NumPyParser.MatrixMulExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code MatrixMulExpression}
	 * labeled alternative in {@link NumPyParser#numPyExpression}.
	 * @param ctx the parse tree
	 */
	void exitMatrixMulExpression(@NotNull NumPyParser.MatrixMulExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code MatrixDivision}
	 * labeled alternative in {@link NumPyParser#numPyExpression}.
	 * @param ctx the parse tree
	 */
	void enterMatrixDivision(@NotNull NumPyParser.MatrixDivisionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code MatrixDivision}
	 * labeled alternative in {@link NumPyParser#numPyExpression}.
	 * @param ctx the parse tree
	 */
	void exitMatrixDivision(@NotNull NumPyParser.MatrixDivisionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code RowsVarExperssion}
	 * labeled alternative in {@link NumPyParser#numPyExpression}.
	 * @param ctx the parse tree
	 */
	void enterRowsVarExperssion(@NotNull NumPyParser.RowsVarExperssionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code RowsVarExperssion}
	 * labeled alternative in {@link NumPyParser#numPyExpression}.
	 * @param ctx the parse tree
	 */
	void exitRowsVarExperssion(@NotNull NumPyParser.RowsVarExperssionContext ctx);
	/**
	 * Enter a parse tree produced by {@link NumPyParser#load}.
	 * @param ctx the parse tree
	 */
	void enterLoad(@NotNull NumPyParser.LoadContext ctx);
	/**
	 * Exit a parse tree produced by {@link NumPyParser#load}.
	 * @param ctx the parse tree
	 */
	void exitLoad(@NotNull NumPyParser.LoadContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ColumnsMeansExperssion}
	 * labeled alternative in {@link NumPyParser#numPyExpression}.
	 * @param ctx the parse tree
	 */
	void enterColumnsMeansExperssion(@NotNull NumPyParser.ColumnsMeansExperssionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ColumnsMeansExperssion}
	 * labeled alternative in {@link NumPyParser#numPyExpression}.
	 * @param ctx the parse tree
	 */
	void exitColumnsMeansExperssion(@NotNull NumPyParser.ColumnsMeansExperssionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ColumnsSdsExperssion}
	 * labeled alternative in {@link NumPyParser#numPyExpression}.
	 * @param ctx the parse tree
	 */
	void enterColumnsSdsExperssion(@NotNull NumPyParser.ColumnsSdsExperssionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ColumnsSdsExperssion}
	 * labeled alternative in {@link NumPyParser#numPyExpression}.
	 * @param ctx the parse tree
	 */
	void exitColumnsSdsExperssion(@NotNull NumPyParser.ColumnsSdsExperssionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ColumnsMinExperssion}
	 * labeled alternative in {@link NumPyParser#numPyExpression}.
	 * @param ctx the parse tree
	 */
	void enterColumnsMinExperssion(@NotNull NumPyParser.ColumnsMinExperssionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ColumnsMinExperssion}
	 * labeled alternative in {@link NumPyParser#numPyExpression}.
	 * @param ctx the parse tree
	 */
	void exitColumnsMinExperssion(@NotNull NumPyParser.ColumnsMinExperssionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code MatrixMulScalarExpression}
	 * labeled alternative in {@link NumPyParser#numPyExpression}.
	 * @param ctx the parse tree
	 */
	void enterMatrixMulScalarExpression(@NotNull NumPyParser.MatrixMulScalarExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code MatrixMulScalarExpression}
	 * labeled alternative in {@link NumPyParser#numPyExpression}.
	 * @param ctx the parse tree
	 */
	void exitMatrixMulScalarExpression(@NotNull NumPyParser.MatrixMulScalarExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code MatrixInvExpression}
	 * labeled alternative in {@link NumPyParser#numPyExpression}.
	 * @param ctx the parse tree
	 */
	void enterMatrixInvExpression(@NotNull NumPyParser.MatrixInvExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code MatrixInvExpression}
	 * labeled alternative in {@link NumPyParser#numPyExpression}.
	 * @param ctx the parse tree
	 */
	void exitMatrixInvExpression(@NotNull NumPyParser.MatrixInvExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link NumPyParser#sep}.
	 * @param ctx the parse tree
	 */
	void enterSep(@NotNull NumPyParser.SepContext ctx);
	/**
	 * Exit a parse tree produced by {@link NumPyParser#sep}.
	 * @param ctx the parse tree
	 */
	void exitSep(@NotNull NumPyParser.SepContext ctx);
	/**
	 * Enter a parse tree produced by the {@code MatrixNormExpression}
	 * labeled alternative in {@link NumPyParser#numPyExpression}.
	 * @param ctx the parse tree
	 */
	void enterMatrixNormExpression(@NotNull NumPyParser.MatrixNormExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code MatrixNormExpression}
	 * labeled alternative in {@link NumPyParser#numPyExpression}.
	 * @param ctx the parse tree
	 */
	void exitMatrixNormExpression(@NotNull NumPyParser.MatrixNormExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code MinExperssion}
	 * labeled alternative in {@link NumPyParser#numPyExpression}.
	 * @param ctx the parse tree
	 */
	void enterMinExperssion(@NotNull NumPyParser.MinExperssionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code MinExperssion}
	 * labeled alternative in {@link NumPyParser#numPyExpression}.
	 * @param ctx the parse tree
	 */
	void exitMinExperssion(@NotNull NumPyParser.MinExperssionContext ctx);
	/**
	 * Enter a parse tree produced by {@link NumPyParser#filePath}.
	 * @param ctx the parse tree
	 */
	void enterFilePath(@NotNull NumPyParser.FilePathContext ctx);
	/**
	 * Exit a parse tree produced by {@link NumPyParser#filePath}.
	 * @param ctx the parse tree
	 */
	void exitFilePath(@NotNull NumPyParser.FilePathContext ctx);
	/**
	 * Enter a parse tree produced by the {@code RowsSdsExperssion}
	 * labeled alternative in {@link NumPyParser#numPyExpression}.
	 * @param ctx the parse tree
	 */
	void enterRowsSdsExperssion(@NotNull NumPyParser.RowsSdsExperssionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code RowsSdsExperssion}
	 * labeled alternative in {@link NumPyParser#numPyExpression}.
	 * @param ctx the parse tree
	 */
	void exitRowsSdsExperssion(@NotNull NumPyParser.RowsSdsExperssionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code RowsMaxExperssion}
	 * labeled alternative in {@link NumPyParser#numPyExpression}.
	 * @param ctx the parse tree
	 */
	void enterRowsMaxExperssion(@NotNull NumPyParser.RowsMaxExperssionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code RowsMaxExperssion}
	 * labeled alternative in {@link NumPyParser#numPyExpression}.
	 * @param ctx the parse tree
	 */
	void exitRowsMaxExperssion(@NotNull NumPyParser.RowsMaxExperssionContext ctx);
	/**
	 * Enter a parse tree produced by {@link NumPyParser#matrixNameExpression}.
	 * @param ctx the parse tree
	 */
	void enterMatrixNameExpression(@NotNull NumPyParser.MatrixNameExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link NumPyParser#matrixNameExpression}.
	 * @param ctx the parse tree
	 */
	void exitMatrixNameExpression(@NotNull NumPyParser.MatrixNameExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code MatrixTransposeExpression}
	 * labeled alternative in {@link NumPyParser#numPyExpression}.
	 * @param ctx the parse tree
	 */
	void enterMatrixTransposeExpression(@NotNull NumPyParser.MatrixTransposeExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code MatrixTransposeExpression}
	 * labeled alternative in {@link NumPyParser#numPyExpression}.
	 * @param ctx the parse tree
	 */
	void exitMatrixTransposeExpression(@NotNull NumPyParser.MatrixTransposeExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code MaxExperssion}
	 * labeled alternative in {@link NumPyParser#numPyExpression}.
	 * @param ctx the parse tree
	 */
	void enterMaxExperssion(@NotNull NumPyParser.MaxExperssionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code MaxExperssion}
	 * labeled alternative in {@link NumPyParser#numPyExpression}.
	 * @param ctx the parse tree
	 */
	void exitMaxExperssion(@NotNull NumPyParser.MaxExperssionContext ctx);
	/**
	 * Enter a parse tree produced by {@link NumPyParser#importstatement}.
	 * @param ctx the parse tree
	 */
	void enterImportstatement(@NotNull NumPyParser.ImportstatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link NumPyParser#importstatement}.
	 * @param ctx the parse tree
	 */
	void exitImportstatement(@NotNull NumPyParser.ImportstatementContext ctx);
	/**
	 * Enter a parse tree produced by the {@code MatrixSubExpression}
	 * labeled alternative in {@link NumPyParser#numPyExpression}.
	 * @param ctx the parse tree
	 */
	void enterMatrixSubExpression(@NotNull NumPyParser.MatrixSubExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code MatrixSubExpression}
	 * labeled alternative in {@link NumPyParser#numPyExpression}.
	 * @param ctx the parse tree
	 */
	void exitMatrixSubExpression(@NotNull NumPyParser.MatrixSubExpressionContext ctx);
}