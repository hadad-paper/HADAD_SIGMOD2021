// Generated from SPPJQL.g4 by ANTLR 4.7.2

package hadad.base.compiler.model.sppj;

import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link SPPJQLParser}.
 */
public interface SPPJQLListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link SPPJQLParser#sppjqlQuery}.
	 * @param ctx the parse tree
	 */
	void enterSppjqlQuery(SPPJQLParser.SppjqlQueryContext ctx);
	/**
	 * Exit a parse tree produced by {@link SPPJQLParser#sppjqlQuery}.
	 * @param ctx the parse tree
	 */
	void exitSppjqlQuery(SPPJQLParser.SppjqlQueryContext ctx);
	/**
	 * Enter a parse tree produced by {@link SPPJQLParser#viewName}.
	 * @param ctx the parse tree
	 */
	void enterViewName(SPPJQLParser.ViewNameContext ctx);
	/**
	 * Exit a parse tree produced by {@link SPPJQLParser#viewName}.
	 * @param ctx the parse tree
	 */
	void exitViewName(SPPJQLParser.ViewNameContext ctx);
	/**
	 * Enter a parse tree produced by {@link SPPJQLParser#sppjQuery}.
	 * @param ctx the parse tree
	 */
	void enterSppjQuery(SPPJQLParser.SppjQueryContext ctx);
	/**
	 * Exit a parse tree produced by {@link SPPJQLParser#sppjQuery}.
	 * @param ctx the parse tree
	 */
	void exitSppjQuery(SPPJQLParser.SppjQueryContext ctx);
	/**
	 * Enter a parse tree produced by {@link SPPJQLParser#sppjRootFieldName}.
	 * @param ctx the parse tree
	 */
	void enterSppjRootFieldName(SPPJQLParser.SppjRootFieldNameContext ctx);
	/**
	 * Exit a parse tree produced by {@link SPPJQLParser#sppjRootFieldName}.
	 * @param ctx the parse tree
	 */
	void exitSppjRootFieldName(SPPJQLParser.SppjRootFieldNameContext ctx);
	/**
	 * Enter a parse tree produced by {@link SPPJQLParser#sppjSelectClause}.
	 * @param ctx the parse tree
	 */
	void enterSppjSelectClause(SPPJQLParser.SppjSelectClauseContext ctx);
	/**
	 * Exit a parse tree produced by {@link SPPJQLParser#sppjSelectClause}.
	 * @param ctx the parse tree
	 */
	void exitSppjSelectClause(SPPJQLParser.SppjSelectClauseContext ctx);
	/**
	 * Enter a parse tree produced by {@link SPPJQLParser#sppjSelectStatement}.
	 * @param ctx the parse tree
	 */
	void enterSppjSelectStatement(SPPJQLParser.SppjSelectStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link SPPJQLParser#sppjSelectStatement}.
	 * @param ctx the parse tree
	 */
	void exitSppjSelectStatement(SPPJQLParser.SppjSelectStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link SPPJQLParser#sppjSelectItem}.
	 * @param ctx the parse tree
	 */
	void enterSppjSelectItem(SPPJQLParser.SppjSelectItemContext ctx);
	/**
	 * Exit a parse tree produced by {@link SPPJQLParser#sppjSelectItem}.
	 * @param ctx the parse tree
	 */
	void exitSppjSelectItem(SPPJQLParser.SppjSelectItemContext ctx);
	/**
	 * Enter a parse tree produced by {@link SPPJQLParser#sppjRecordConstruct}.
	 * @param ctx the parse tree
	 */
	void enterSppjRecordConstruct(SPPJQLParser.SppjRecordConstructContext ctx);
	/**
	 * Exit a parse tree produced by {@link SPPJQLParser#sppjRecordConstruct}.
	 * @param ctx the parse tree
	 */
	void exitSppjRecordConstruct(SPPJQLParser.SppjRecordConstructContext ctx);
	/**
	 * Enter a parse tree produced by {@link SPPJQLParser#sppjFieldBinding}.
	 * @param ctx the parse tree
	 */
	void enterSppjFieldBinding(SPPJQLParser.SppjFieldBindingContext ctx);
	/**
	 * Exit a parse tree produced by {@link SPPJQLParser#sppjFieldBinding}.
	 * @param ctx the parse tree
	 */
	void exitSppjFieldBinding(SPPJQLParser.SppjFieldBindingContext ctx);
	/**
	 * Enter a parse tree produced by {@link SPPJQLParser#sppjRecordConstructFieldName}.
	 * @param ctx the parse tree
	 */
	void enterSppjRecordConstructFieldName(SPPJQLParser.SppjRecordConstructFieldNameContext ctx);
	/**
	 * Exit a parse tree produced by {@link SPPJQLParser#sppjRecordConstructFieldName}.
	 * @param ctx the parse tree
	 */
	void exitSppjRecordConstructFieldName(SPPJQLParser.SppjRecordConstructFieldNameContext ctx);
	/**
	 * Enter a parse tree produced by {@link SPPJQLParser#sppjFieldValue}.
	 * @param ctx the parse tree
	 */
	void enterSppjFieldValue(SPPJQLParser.SppjFieldValueContext ctx);
	/**
	 * Exit a parse tree produced by {@link SPPJQLParser#sppjFieldValue}.
	 * @param ctx the parse tree
	 */
	void exitSppjFieldValue(SPPJQLParser.SppjFieldValueContext ctx);
	/**
	 * Enter a parse tree produced by {@link SPPJQLParser#sppjSelectVar}.
	 * @param ctx the parse tree
	 */
	void enterSppjSelectVar(SPPJQLParser.SppjSelectVarContext ctx);
	/**
	 * Exit a parse tree produced by {@link SPPJQLParser#sppjSelectVar}.
	 * @param ctx the parse tree
	 */
	void exitSppjSelectVar(SPPJQLParser.SppjSelectVarContext ctx);
	/**
	 * Enter a parse tree produced by {@link SPPJQLParser#sppjSelectConstant}.
	 * @param ctx the parse tree
	 */
	void enterSppjSelectConstant(SPPJQLParser.SppjSelectConstantContext ctx);
	/**
	 * Exit a parse tree produced by {@link SPPJQLParser#sppjSelectConstant}.
	 * @param ctx the parse tree
	 */
	void exitSppjSelectConstant(SPPJQLParser.SppjSelectConstantContext ctx);
	/**
	 * Enter a parse tree produced by {@link SPPJQLParser#sppjSelectQuery}.
	 * @param ctx the parse tree
	 */
	void enterSppjSelectQuery(SPPJQLParser.SppjSelectQueryContext ctx);
	/**
	 * Exit a parse tree produced by {@link SPPJQLParser#sppjSelectQuery}.
	 * @param ctx the parse tree
	 */
	void exitSppjSelectQuery(SPPJQLParser.SppjSelectQueryContext ctx);
	/**
	 * Enter a parse tree produced by {@link SPPJQLParser#sppjFromWhereClause}.
	 * @param ctx the parse tree
	 */
	void enterSppjFromWhereClause(SPPJQLParser.SppjFromWhereClauseContext ctx);
	/**
	 * Exit a parse tree produced by {@link SPPJQLParser#sppjFromWhereClause}.
	 * @param ctx the parse tree
	 */
	void exitSppjFromWhereClause(SPPJQLParser.SppjFromWhereClauseContext ctx);
	/**
	 * Enter a parse tree produced by {@link SPPJQLParser#sppjFromClause}.
	 * @param ctx the parse tree
	 */
	void enterSppjFromClause(SPPJQLParser.SppjFromClauseContext ctx);
	/**
	 * Exit a parse tree produced by {@link SPPJQLParser#sppjFromClause}.
	 * @param ctx the parse tree
	 */
	void exitSppjFromClause(SPPJQLParser.SppjFromClauseContext ctx);
	/**
	 * Enter a parse tree produced by {@link SPPJQLParser#sppjBinding}.
	 * @param ctx the parse tree
	 */
	void enterSppjBinding(SPPJQLParser.SppjBindingContext ctx);
	/**
	 * Exit a parse tree produced by {@link SPPJQLParser#sppjBinding}.
	 * @param ctx the parse tree
	 */
	void exitSppjBinding(SPPJQLParser.SppjBindingContext ctx);
	/**
	 * Enter a parse tree produced by {@link SPPJQLParser#sppjFromClauseBindingSource}.
	 * @param ctx the parse tree
	 */
	void enterSppjFromClauseBindingSource(SPPJQLParser.SppjFromClauseBindingSourceContext ctx);
	/**
	 * Exit a parse tree produced by {@link SPPJQLParser#sppjFromClauseBindingSource}.
	 * @param ctx the parse tree
	 */
	void exitSppjFromClauseBindingSource(SPPJQLParser.SppjFromClauseBindingSourceContext ctx);
	/**
	 * Enter a parse tree produced by {@link SPPJQLParser#sppjSource}.
	 * @param ctx the parse tree
	 */
	void enterSppjSource(SPPJQLParser.SppjSourceContext ctx);
	/**
	 * Exit a parse tree produced by {@link SPPJQLParser#sppjSource}.
	 * @param ctx the parse tree
	 */
	void exitSppjSource(SPPJQLParser.SppjSourceContext ctx);
	/**
	 * Enter a parse tree produced by {@link SPPJQLParser#sppjFromClauseBindingVar}.
	 * @param ctx the parse tree
	 */
	void enterSppjFromClauseBindingVar(SPPJQLParser.SppjFromClauseBindingVarContext ctx);
	/**
	 * Exit a parse tree produced by {@link SPPJQLParser#sppjFromClauseBindingVar}.
	 * @param ctx the parse tree
	 */
	void exitSppjFromClauseBindingVar(SPPJQLParser.SppjFromClauseBindingVarContext ctx);
	/**
	 * Enter a parse tree produced by {@link SPPJQLParser#sppjWhereClause}.
	 * @param ctx the parse tree
	 */
	void enterSppjWhereClause(SPPJQLParser.SppjWhereClauseContext ctx);
	/**
	 * Exit a parse tree produced by {@link SPPJQLParser#sppjWhereClause}.
	 * @param ctx the parse tree
	 */
	void exitSppjWhereClause(SPPJQLParser.SppjWhereClauseContext ctx);
	/**
	 * Enter a parse tree produced by {@link SPPJQLParser#sppjCondition}.
	 * @param ctx the parse tree
	 */
	void enterSppjCondition(SPPJQLParser.SppjConditionContext ctx);
	/**
	 * Exit a parse tree produced by {@link SPPJQLParser#sppjCondition}.
	 * @param ctx the parse tree
	 */
	void exitSppjCondition(SPPJQLParser.SppjConditionContext ctx);
	/**
	 * Enter a parse tree produced by {@link SPPJQLParser#sppjWhereCondEquality}.
	 * @param ctx the parse tree
	 */
	void enterSppjWhereCondEquality(SPPJQLParser.SppjWhereCondEqualityContext ctx);
	/**
	 * Exit a parse tree produced by {@link SPPJQLParser#sppjWhereCondEquality}.
	 * @param ctx the parse tree
	 */
	void exitSppjWhereCondEquality(SPPJQLParser.SppjWhereCondEqualityContext ctx);
	/**
	 * Enter a parse tree produced by {@link SPPJQLParser#sppjWhereCondEqualityLeftTerm}.
	 * @param ctx the parse tree
	 */
	void enterSppjWhereCondEqualityLeftTerm(SPPJQLParser.SppjWhereCondEqualityLeftTermContext ctx);
	/**
	 * Exit a parse tree produced by {@link SPPJQLParser#sppjWhereCondEqualityLeftTerm}.
	 * @param ctx the parse tree
	 */
	void exitSppjWhereCondEqualityLeftTerm(SPPJQLParser.SppjWhereCondEqualityLeftTermContext ctx);
	/**
	 * Enter a parse tree produced by {@link SPPJQLParser#sppjWhereCondEqualityRightTerm}.
	 * @param ctx the parse tree
	 */
	void enterSppjWhereCondEqualityRightTerm(SPPJQLParser.SppjWhereCondEqualityRightTermContext ctx);
	/**
	 * Exit a parse tree produced by {@link SPPJQLParser#sppjWhereCondEqualityRightTerm}.
	 * @param ctx the parse tree
	 */
	void exitSppjWhereCondEqualityRightTerm(SPPJQLParser.SppjWhereCondEqualityRightTermContext ctx);
	/**
	 * Enter a parse tree produced by {@link SPPJQLParser#sppjCTerm}.
	 * @param ctx the parse tree
	 */
	void enterSppjCTerm(SPPJQLParser.SppjCTermContext ctx);
	/**
	 * Exit a parse tree produced by {@link SPPJQLParser#sppjCTerm}.
	 * @param ctx the parse tree
	 */
	void exitSppjCTerm(SPPJQLParser.SppjCTermContext ctx);
	/**
	 * Enter a parse tree produced by {@link SPPJQLParser#sppjTerm}.
	 * @param ctx the parse tree
	 */
	void enterSppjTerm(SPPJQLParser.SppjTermContext ctx);
	/**
	 * Exit a parse tree produced by {@link SPPJQLParser#sppjTerm}.
	 * @param ctx the parse tree
	 */
	void exitSppjTerm(SPPJQLParser.SppjTermContext ctx);
	/**
	 * Enter a parse tree produced by {@link SPPJQLParser#sppjTermVar}.
	 * @param ctx the parse tree
	 */
	void enterSppjTermVar(SPPJQLParser.SppjTermVarContext ctx);
	/**
	 * Exit a parse tree produced by {@link SPPJQLParser#sppjTermVar}.
	 * @param ctx the parse tree
	 */
	void exitSppjTermVar(SPPJQLParser.SppjTermVarContext ctx);
	/**
	 * Enter a parse tree produced by {@link SPPJQLParser#sppjTermConstant}.
	 * @param ctx the parse tree
	 */
	void enterSppjTermConstant(SPPJQLParser.SppjTermConstantContext ctx);
	/**
	 * Exit a parse tree produced by {@link SPPJQLParser#sppjTermConstant}.
	 * @param ctx the parse tree
	 */
	void exitSppjTermConstant(SPPJQLParser.SppjTermConstantContext ctx);
	/**
	 * Enter a parse tree produced by {@link SPPJQLParser#sppjTermPath}.
	 * @param ctx the parse tree
	 */
	void enterSppjTermPath(SPPJQLParser.SppjTermPathContext ctx);
	/**
	 * Exit a parse tree produced by {@link SPPJQLParser#sppjTermPath}.
	 * @param ctx the parse tree
	 */
	void exitSppjTermPath(SPPJQLParser.SppjTermPathContext ctx);
	/**
	 * Enter a parse tree produced by {@link SPPJQLParser#sppjPath}.
	 * @param ctx the parse tree
	 */
	void enterSppjPath(SPPJQLParser.SppjPathContext ctx);
	/**
	 * Exit a parse tree produced by {@link SPPJQLParser#sppjPath}.
	 * @param ctx the parse tree
	 */
	void exitSppjPath(SPPJQLParser.SppjPathContext ctx);
	/**
	 * Enter a parse tree produced by {@link SPPJQLParser#sppjPathVar}.
	 * @param ctx the parse tree
	 */
	void enterSppjPathVar(SPPJQLParser.SppjPathVarContext ctx);
	/**
	 * Exit a parse tree produced by {@link SPPJQLParser#sppjPathVar}.
	 * @param ctx the parse tree
	 */
	void exitSppjPathVar(SPPJQLParser.SppjPathVarContext ctx);
	/**
	 * Enter a parse tree produced by {@link SPPJQLParser#sppjStep}.
	 * @param ctx the parse tree
	 */
	void enterSppjStep(SPPJQLParser.SppjStepContext ctx);
	/**
	 * Exit a parse tree produced by {@link SPPJQLParser#sppjStep}.
	 * @param ctx the parse tree
	 */
	void exitSppjStep(SPPJQLParser.SppjStepContext ctx);
	/**
	 * Enter a parse tree produced by {@link SPPJQLParser#sppjObjStep}.
	 * @param ctx the parse tree
	 */
	void enterSppjObjStep(SPPJQLParser.SppjObjStepContext ctx);
	/**
	 * Exit a parse tree produced by {@link SPPJQLParser#sppjObjStep}.
	 * @param ctx the parse tree
	 */
	void exitSppjObjStep(SPPJQLParser.SppjObjStepContext ctx);
	/**
	 * Enter a parse tree produced by {@link SPPJQLParser#sppjVariable}.
	 * @param ctx the parse tree
	 */
	void enterSppjVariable(SPPJQLParser.SppjVariableContext ctx);
	/**
	 * Exit a parse tree produced by {@link SPPJQLParser#sppjVariable}.
	 * @param ctx the parse tree
	 */
	void exitSppjVariable(SPPJQLParser.SppjVariableContext ctx);
	/**
	 * Enter a parse tree produced by {@link SPPJQLParser#dataSetName}.
	 * @param ctx the parse tree
	 */
	void enterDataSetName(SPPJQLParser.DataSetNameContext ctx);
	/**
	 * Exit a parse tree produced by {@link SPPJQLParser#dataSetName}.
	 * @param ctx the parse tree
	 */
	void exitDataSetName(SPPJQLParser.DataSetNameContext ctx);
	/**
	 * Enter a parse tree produced by {@link SPPJQLParser#key}.
	 * @param ctx the parse tree
	 */
	void enterKey(SPPJQLParser.KeyContext ctx);
	/**
	 * Exit a parse tree produced by {@link SPPJQLParser#key}.
	 * @param ctx the parse tree
	 */
	void exitKey(SPPJQLParser.KeyContext ctx);
	/**
	 * Enter a parse tree produced by {@link SPPJQLParser#sppjFieldName}.
	 * @param ctx the parse tree
	 */
	void enterSppjFieldName(SPPJQLParser.SppjFieldNameContext ctx);
	/**
	 * Exit a parse tree produced by {@link SPPJQLParser#sppjFieldName}.
	 * @param ctx the parse tree
	 */
	void exitSppjFieldName(SPPJQLParser.SppjFieldNameContext ctx);
	/**
	 * Enter a parse tree produced by {@link SPPJQLParser#sppjConstant}.
	 * @param ctx the parse tree
	 */
	void enterSppjConstant(SPPJQLParser.SppjConstantContext ctx);
	/**
	 * Exit a parse tree produced by {@link SPPJQLParser#sppjConstant}.
	 * @param ctx the parse tree
	 */
	void exitSppjConstant(SPPJQLParser.SppjConstantContext ctx);
}