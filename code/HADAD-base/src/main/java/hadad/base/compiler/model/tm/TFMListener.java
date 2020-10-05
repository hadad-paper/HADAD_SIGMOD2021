// Generated from TFM.g4 by ANTLR 4.4

package hadad.base.compiler.model.tm;

import org.antlr.v4.runtime.misc.NotNull;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link TFMParser}.
 */
public interface TFMListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link TFMParser#gName}.
	 * @param ctx the parse tree
	 */
	void enterGName(@NotNull TFMParser.GNameContext ctx);
	/**
	 * Exit a parse tree produced by {@link TFMParser#gName}.
	 * @param ctx the parse tree
	 */
	void exitGName(@NotNull TFMParser.GNameContext ctx);
	/**
	 * Enter a parse tree produced by {@link TFMParser#matrixName}.
	 * @param ctx the parse tree
	 */
	void enterMatrixName(@NotNull TFMParser.MatrixNameContext ctx);
	/**
	 * Exit a parse tree produced by {@link TFMParser#matrixName}.
	 * @param ctx the parse tree
	 */
	void exitMatrixName(@NotNull TFMParser.MatrixNameContext ctx);
	/**
	 * Enter a parse tree produced by the {@code MatrixAdjointExpression}
	 * labeled alternative in {@link TFMParser#tfmExpression}.
	 * @param ctx the parse tree
	 */
	void enterMatrixAdjointExpression(@NotNull TFMParser.MatrixAdjointExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code MatrixAdjointExpression}
	 * labeled alternative in {@link TFMParser#tfmExpression}.
	 * @param ctx the parse tree
	 */
	void exitMatrixAdjointExpression(@NotNull TFMParser.MatrixAdjointExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link TFMParser#tfmMatrixConstructionMatrixSource}.
	 * @param ctx the parse tree
	 */
	void enterTfmMatrixConstructionMatrixSource(@NotNull TFMParser.TfmMatrixConstructionMatrixSourceContext ctx);
	/**
	 * Exit a parse tree produced by {@link TFMParser#tfmMatrixConstructionMatrixSource}.
	 * @param ctx the parse tree
	 */
	void exitTfmMatrixConstructionMatrixSource(@NotNull TFMParser.TfmMatrixConstructionMatrixSourceContext ctx);
	/**
	 * Enter a parse tree produced by {@link TFMParser#sess}.
	 * @param ctx the parse tree
	 */
	void enterSess(@NotNull TFMParser.SessContext ctx);
	/**
	 * Exit a parse tree produced by {@link TFMParser#sess}.
	 * @param ctx the parse tree
	 */
	void exitSess(@NotNull TFMParser.SessContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ColumnsSumExperssion}
	 * labeled alternative in {@link TFMParser#tfmExpression}.
	 * @param ctx the parse tree
	 */
	void enterColumnsSumExperssion(@NotNull TFMParser.ColumnsSumExperssionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ColumnsSumExperssion}
	 * labeled alternative in {@link TFMParser#tfmExpression}.
	 * @param ctx the parse tree
	 */
	void exitColumnsSumExperssion(@NotNull TFMParser.ColumnsSumExperssionContext ctx);
	/**
	 * Enter a parse tree produced by {@link TFMParser#source}.
	 * @param ctx the parse tree
	 */
	void enterSource(@NotNull TFMParser.SourceContext ctx);
	/**
	 * Exit a parse tree produced by {@link TFMParser#source}.
	 * @param ctx the parse tree
	 */
	void exitSource(@NotNull TFMParser.SourceContext ctx);
	/**
	 * Enter a parse tree produced by the {@code MatrixAddExpression}
	 * labeled alternative in {@link TFMParser#tfmExpression}.
	 * @param ctx the parse tree
	 */
	void enterMatrixAddExpression(@NotNull TFMParser.MatrixAddExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code MatrixAddExpression}
	 * labeled alternative in {@link TFMParser#tfmExpression}.
	 * @param ctx the parse tree
	 */
	void exitMatrixAddExpression(@NotNull TFMParser.MatrixAddExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code MatrixMulElementwiseExpression}
	 * labeled alternative in {@link TFMParser#tfmExpression}.
	 * @param ctx the parse tree
	 */
	void enterMatrixMulElementwiseExpression(@NotNull TFMParser.MatrixMulElementwiseExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code MatrixMulElementwiseExpression}
	 * labeled alternative in {@link TFMParser#tfmExpression}.
	 * @param ctx the parse tree
	 */
	void exitMatrixMulElementwiseExpression(@NotNull TFMParser.MatrixMulElementwiseExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code RowsSumExperssion}
	 * labeled alternative in {@link TFMParser#tfmExpression}.
	 * @param ctx the parse tree
	 */
	void enterRowsSumExperssion(@NotNull TFMParser.RowsSumExperssionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code RowsSumExperssion}
	 * labeled alternative in {@link TFMParser#tfmExpression}.
	 * @param ctx the parse tree
	 */
	void exitRowsSumExperssion(@NotNull TFMParser.RowsSumExperssionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code MatrixDetExpression}
	 * labeled alternative in {@link TFMParser#tfmExpression}.
	 * @param ctx the parse tree
	 */
	void enterMatrixDetExpression(@NotNull TFMParser.MatrixDetExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code MatrixDetExpression}
	 * labeled alternative in {@link TFMParser#tfmExpression}.
	 * @param ctx the parse tree
	 */
	void exitMatrixDetExpression(@NotNull TFMParser.MatrixDetExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code MatrixMulExpression}
	 * labeled alternative in {@link TFMParser#tfmExpression}.
	 * @param ctx the parse tree
	 */
	void enterMatrixMulExpression(@NotNull TFMParser.MatrixMulExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code MatrixMulExpression}
	 * labeled alternative in {@link TFMParser#tfmExpression}.
	 * @param ctx the parse tree
	 */
	void exitMatrixMulExpression(@NotNull TFMParser.MatrixMulExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code MatrixDivision}
	 * labeled alternative in {@link TFMParser#tfmExpression}.
	 * @param ctx the parse tree
	 */
	void enterMatrixDivision(@NotNull TFMParser.MatrixDivisionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code MatrixDivision}
	 * labeled alternative in {@link TFMParser#tfmExpression}.
	 * @param ctx the parse tree
	 */
	void exitMatrixDivision(@NotNull TFMParser.MatrixDivisionContext ctx);
	/**
	 * Enter a parse tree produced by {@link TFMParser#load}.
	 * @param ctx the parse tree
	 */
	void enterLoad(@NotNull TFMParser.LoadContext ctx);
	/**
	 * Exit a parse tree produced by {@link TFMParser#load}.
	 * @param ctx the parse tree
	 */
	void exitLoad(@NotNull TFMParser.LoadContext ctx);
	/**
	 * Enter a parse tree produced by the {@code MeanExpression}
	 * labeled alternative in {@link TFMParser#tfmExpression}.
	 * @param ctx the parse tree
	 */
	void enterMeanExpression(@NotNull TFMParser.MeanExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code MeanExpression}
	 * labeled alternative in {@link TFMParser#tfmExpression}.
	 * @param ctx the parse tree
	 */
	void exitMeanExpression(@NotNull TFMParser.MeanExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link TFMParser#viewName}.
	 * @param ctx the parse tree
	 */
	void enterViewName(@NotNull TFMParser.ViewNameContext ctx);
	/**
	 * Exit a parse tree produced by {@link TFMParser#viewName}.
	 * @param ctx the parse tree
	 */
	void exitViewName(@NotNull TFMParser.ViewNameContext ctx);
	/**
	 * Enter a parse tree produced by {@link TFMParser#tfmMatrixConstruction}.
	 * @param ctx the parse tree
	 */
	void enterTfmMatrixConstruction(@NotNull TFMParser.TfmMatrixConstructionContext ctx);
	/**
	 * Exit a parse tree produced by {@link TFMParser#tfmMatrixConstruction}.
	 * @param ctx the parse tree
	 */
	void exitTfmMatrixConstruction(@NotNull TFMParser.TfmMatrixConstructionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code MatrixMulScalarExpression}
	 * labeled alternative in {@link TFMParser#tfmExpression}.
	 * @param ctx the parse tree
	 */
	void enterMatrixMulScalarExpression(@NotNull TFMParser.MatrixMulScalarExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code MatrixMulScalarExpression}
	 * labeled alternative in {@link TFMParser#tfmExpression}.
	 * @param ctx the parse tree
	 */
	void exitMatrixMulScalarExpression(@NotNull TFMParser.MatrixMulScalarExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code MatrixInvExpression}
	 * labeled alternative in {@link TFMParser#tfmExpression}.
	 * @param ctx the parse tree
	 */
	void enterMatrixInvExpression(@NotNull TFMParser.MatrixInvExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code MatrixInvExpression}
	 * labeled alternative in {@link TFMParser#tfmExpression}.
	 * @param ctx the parse tree
	 */
	void exitMatrixInvExpression(@NotNull TFMParser.MatrixInvExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link TFMParser#keyVal}.
	 * @param ctx the parse tree
	 */
	void enterKeyVal(@NotNull TFMParser.KeyValContext ctx);
	/**
	 * Exit a parse tree produced by {@link TFMParser#keyVal}.
	 * @param ctx the parse tree
	 */
	void exitKeyVal(@NotNull TFMParser.KeyValContext ctx);
	/**
	 * Enter a parse tree produced by {@link TFMParser#sep}.
	 * @param ctx the parse tree
	 */
	void enterSep(@NotNull TFMParser.SepContext ctx);
	/**
	 * Exit a parse tree produced by {@link TFMParser#sep}.
	 * @param ctx the parse tree
	 */
	void exitSep(@NotNull TFMParser.SepContext ctx);
	/**
	 * Enter a parse tree produced by {@link TFMParser#val}.
	 * @param ctx the parse tree
	 */
	void enterVal(@NotNull TFMParser.ValContext ctx);
	/**
	 * Exit a parse tree produced by {@link TFMParser#val}.
	 * @param ctx the parse tree
	 */
	void exitVal(@NotNull TFMParser.ValContext ctx);
	/**
	 * Enter a parse tree produced by the {@code MatrixNormExpression}
	 * labeled alternative in {@link TFMParser#tfmExpression}.
	 * @param ctx the parse tree
	 */
	void enterMatrixNormExpression(@NotNull TFMParser.MatrixNormExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code MatrixNormExpression}
	 * labeled alternative in {@link TFMParser#tfmExpression}.
	 * @param ctx the parse tree
	 */
	void exitMatrixNormExpression(@NotNull TFMParser.MatrixNormExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link TFMParser#shape}.
	 * @param ctx the parse tree
	 */
	void enterShape(@NotNull TFMParser.ShapeContext ctx);
	/**
	 * Exit a parse tree produced by {@link TFMParser#shape}.
	 * @param ctx the parse tree
	 */
	void exitShape(@NotNull TFMParser.ShapeContext ctx);
	/**
	 * Enter a parse tree produced by {@link TFMParser#filePath}.
	 * @param ctx the parse tree
	 */
	void enterFilePath(@NotNull TFMParser.FilePathContext ctx);
	/**
	 * Exit a parse tree produced by {@link TFMParser#filePath}.
	 * @param ctx the parse tree
	 */
	void exitFilePath(@NotNull TFMParser.FilePathContext ctx);
	/**
	 * Enter a parse tree produced by {@link TFMParser#tfmScript}.
	 * @param ctx the parse tree
	 */
	void enterTfmScript(@NotNull TFMParser.TfmScriptContext ctx);
	/**
	 * Exit a parse tree produced by {@link TFMParser#tfmScript}.
	 * @param ctx the parse tree
	 */
	void exitTfmScript(@NotNull TFMParser.TfmScriptContext ctx);
	/**
	 * Enter a parse tree produced by {@link TFMParser#tfmStatemnet}.
	 * @param ctx the parse tree
	 */
	void enterTfmStatemnet(@NotNull TFMParser.TfmStatemnetContext ctx);
	/**
	 * Exit a parse tree produced by {@link TFMParser#tfmStatemnet}.
	 * @param ctx the parse tree
	 */
	void exitTfmStatemnet(@NotNull TFMParser.TfmStatemnetContext ctx);
	/**
	 * Enter a parse tree produced by {@link TFMParser#withStatement}.
	 * @param ctx the parse tree
	 */
	void enterWithStatement(@NotNull TFMParser.WithStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link TFMParser#withStatement}.
	 * @param ctx the parse tree
	 */
	void exitWithStatement(@NotNull TFMParser.WithStatementContext ctx);
	/**
	 * Enter a parse tree produced by the {@code MatrixIdentifier}
	 * labeled alternative in {@link TFMParser#tfmExpression}.
	 * @param ctx the parse tree
	 */
	void enterMatrixIdentifier(@NotNull TFMParser.MatrixIdentifierContext ctx);
	/**
	 * Exit a parse tree produced by the {@code MatrixIdentifier}
	 * labeled alternative in {@link TFMParser#tfmExpression}.
	 * @param ctx the parse tree
	 */
	void exitMatrixIdentifier(@NotNull TFMParser.MatrixIdentifierContext ctx);
	/**
	 * Enter a parse tree produced by {@link TFMParser#matrixNameExpression}.
	 * @param ctx the parse tree
	 */
	void enterMatrixNameExpression(@NotNull TFMParser.MatrixNameExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link TFMParser#matrixNameExpression}.
	 * @param ctx the parse tree
	 */
	void exitMatrixNameExpression(@NotNull TFMParser.MatrixNameExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link TFMParser#pair}.
	 * @param ctx the parse tree
	 */
	void enterPair(@NotNull TFMParser.PairContext ctx);
	/**
	 * Exit a parse tree produced by {@link TFMParser#pair}.
	 * @param ctx the parse tree
	 */
	void exitPair(@NotNull TFMParser.PairContext ctx);
	/**
	 * Enter a parse tree produced by the {@code MatrixDiagonalExpression}
	 * labeled alternative in {@link TFMParser#tfmExpression}.
	 * @param ctx the parse tree
	 */
	void enterMatrixDiagonalExpression(@NotNull TFMParser.MatrixDiagonalExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code MatrixDiagonalExpression}
	 * labeled alternative in {@link TFMParser#tfmExpression}.
	 * @param ctx the parse tree
	 */
	void exitMatrixDiagonalExpression(@NotNull TFMParser.MatrixDiagonalExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link TFMParser#numericScalar}.
	 * @param ctx the parse tree
	 */
	void enterNumericScalar(@NotNull TFMParser.NumericScalarContext ctx);
	/**
	 * Exit a parse tree produced by {@link TFMParser#numericScalar}.
	 * @param ctx the parse tree
	 */
	void exitNumericScalar(@NotNull TFMParser.NumericScalarContext ctx);
	/**
	 * Enter a parse tree produced by {@link TFMParser#tfGraphInit}.
	 * @param ctx the parse tree
	 */
	void enterTfGraphInit(@NotNull TFMParser.TfGraphInitContext ctx);
	/**
	 * Exit a parse tree produced by {@link TFMParser#tfGraphInit}.
	 * @param ctx the parse tree
	 */
	void exitTfGraphInit(@NotNull TFMParser.TfGraphInitContext ctx);
	/**
	 * Enter a parse tree produced by {@link TFMParser#with}.
	 * @param ctx the parse tree
	 */
	void enterWith(@NotNull TFMParser.WithContext ctx);
	/**
	 * Exit a parse tree produced by {@link TFMParser#with}.
	 * @param ctx the parse tree
	 */
	void exitWith(@NotNull TFMParser.WithContext ctx);
	/**
	 * Enter a parse tree produced by {@link TFMParser#as}.
	 * @param ctx the parse tree
	 */
	void enterAs(@NotNull TFMParser.AsContext ctx);
	/**
	 * Exit a parse tree produced by {@link TFMParser#as}.
	 * @param ctx the parse tree
	 */
	void exitAs(@NotNull TFMParser.AsContext ctx);
	/**
	 * Enter a parse tree produced by the {@code MatrixTraceExpression}
	 * labeled alternative in {@link TFMParser#tfmExpression}.
	 * @param ctx the parse tree
	 */
	void enterMatrixTraceExpression(@NotNull TFMParser.MatrixTraceExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code MatrixTraceExpression}
	 * labeled alternative in {@link TFMParser#tfmExpression}.
	 * @param ctx the parse tree
	 */
	void exitMatrixTraceExpression(@NotNull TFMParser.MatrixTraceExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code MatrixTransposeExpression}
	 * labeled alternative in {@link TFMParser#tfmExpression}.
	 * @param ctx the parse tree
	 */
	void enterMatrixTransposeExpression(@NotNull TFMParser.MatrixTransposeExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code MatrixTransposeExpression}
	 * labeled alternative in {@link TFMParser#tfmExpression}.
	 * @param ctx the parse tree
	 */
	void exitMatrixTransposeExpression(@NotNull TFMParser.MatrixTransposeExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link TFMParser#importstatement}.
	 * @param ctx the parse tree
	 */
	void enterImportstatement(@NotNull TFMParser.ImportstatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link TFMParser#importstatement}.
	 * @param ctx the parse tree
	 */
	void exitImportstatement(@NotNull TFMParser.ImportstatementContext ctx);
	/**
	 * Enter a parse tree produced by the {@code MatrixRankExpression}
	 * labeled alternative in {@link TFMParser#tfmExpression}.
	 * @param ctx the parse tree
	 */
	void enterMatrixRankExpression(@NotNull TFMParser.MatrixRankExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code MatrixRankExpression}
	 * labeled alternative in {@link TFMParser#tfmExpression}.
	 * @param ctx the parse tree
	 */
	void exitMatrixRankExpression(@NotNull TFMParser.MatrixRankExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link TFMParser#sesionRun}.
	 * @param ctx the parse tree
	 */
	void enterSesionRun(@NotNull TFMParser.SesionRunContext ctx);
	/**
	 * Exit a parse tree produced by {@link TFMParser#sesionRun}.
	 * @param ctx the parse tree
	 */
	void exitSesionRun(@NotNull TFMParser.SesionRunContext ctx);
	/**
	 * Enter a parse tree produced by {@link TFMParser#mName}.
	 * @param ctx the parse tree
	 */
	void enterMName(@NotNull TFMParser.MNameContext ctx);
	/**
	 * Exit a parse tree produced by {@link TFMParser#mName}.
	 * @param ctx the parse tree
	 */
	void exitMName(@NotNull TFMParser.MNameContext ctx);
	/**
	 * Enter a parse tree produced by {@link TFMParser#tfmQuery}.
	 * @param ctx the parse tree
	 */
	void enterTfmQuery(@NotNull TFMParser.TfmQueryContext ctx);
	/**
	 * Exit a parse tree produced by {@link TFMParser#tfmQuery}.
	 * @param ctx the parse tree
	 */
	void exitTfmQuery(@NotNull TFMParser.TfmQueryContext ctx);
	/**
	 * Enter a parse tree produced by the {@code SumExperssion}
	 * labeled alternative in {@link TFMParser#tfmExpression}.
	 * @param ctx the parse tree
	 */
	void enterSumExperssion(@NotNull TFMParser.SumExperssionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code SumExperssion}
	 * labeled alternative in {@link TFMParser#tfmExpression}.
	 * @param ctx the parse tree
	 */
	void exitSumExperssion(@NotNull TFMParser.SumExperssionContext ctx);
}