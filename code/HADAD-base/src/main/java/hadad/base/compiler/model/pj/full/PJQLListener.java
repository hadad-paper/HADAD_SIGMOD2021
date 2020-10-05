// Generated from PJQL.g4 by ANTLR 4.7.2

package hadad.base.compiler.model.pj.full;

import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link PJQLParser}.
 */
public interface PJQLListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link PJQLParser#pjqlQuery}.
	 * @param ctx the parse tree
	 */
	void enterPjqlQuery(PJQLParser.PjqlQueryContext ctx);
	/**
	 * Exit a parse tree produced by {@link PJQLParser#pjqlQuery}.
	 * @param ctx the parse tree
	 */
	void exitPjqlQuery(PJQLParser.PjqlQueryContext ctx);
	/**
	 * Enter a parse tree produced by {@link PJQLParser#viewName}.
	 * @param ctx the parse tree
	 */
	void enterViewName(PJQLParser.ViewNameContext ctx);
	/**
	 * Exit a parse tree produced by {@link PJQLParser#viewName}.
	 * @param ctx the parse tree
	 */
	void exitViewName(PJQLParser.ViewNameContext ctx);
	/**
	 * Enter a parse tree produced by {@link PJQLParser#pjQuery}.
	 * @param ctx the parse tree
	 */
	void enterPjQuery(PJQLParser.PjQueryContext ctx);
	/**
	 * Exit a parse tree produced by {@link PJQLParser#pjQuery}.
	 * @param ctx the parse tree
	 */
	void exitPjQuery(PJQLParser.PjQueryContext ctx);
	/**
	 * Enter a parse tree produced by {@link PJQLParser#pjSelectClause}.
	 * @param ctx the parse tree
	 */
	void enterPjSelectClause(PJQLParser.PjSelectClauseContext ctx);
	/**
	 * Exit a parse tree produced by {@link PJQLParser#pjSelectClause}.
	 * @param ctx the parse tree
	 */
	void exitPjSelectClause(PJQLParser.PjSelectClauseContext ctx);
	/**
	 * Enter a parse tree produced by {@link PJQLParser#pjSelectStatement}.
	 * @param ctx the parse tree
	 */
	void enterPjSelectStatement(PJQLParser.PjSelectStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link PJQLParser#pjSelectStatement}.
	 * @param ctx the parse tree
	 */
	void exitPjSelectStatement(PJQLParser.PjSelectStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link PJQLParser#pjSelectItem}.
	 * @param ctx the parse tree
	 */
	void enterPjSelectItem(PJQLParser.PjSelectItemContext ctx);
	/**
	 * Exit a parse tree produced by {@link PJQLParser#pjSelectItem}.
	 * @param ctx the parse tree
	 */
	void exitPjSelectItem(PJQLParser.PjSelectItemContext ctx);
	/**
	 * Enter a parse tree produced by {@link PJQLParser#pjPathSelect}.
	 * @param ctx the parse tree
	 */
	void enterPjPathSelect(PJQLParser.PjPathSelectContext ctx);
	/**
	 * Exit a parse tree produced by {@link PJQLParser#pjPathSelect}.
	 * @param ctx the parse tree
	 */
	void exitPjPathSelect(PJQLParser.PjPathSelectContext ctx);
	/**
	 * Enter a parse tree produced by {@link PJQLParser#pjRecordConstruct}.
	 * @param ctx the parse tree
	 */
	void enterPjRecordConstruct(PJQLParser.PjRecordConstructContext ctx);
	/**
	 * Exit a parse tree produced by {@link PJQLParser#pjRecordConstruct}.
	 * @param ctx the parse tree
	 */
	void exitPjRecordConstruct(PJQLParser.PjRecordConstructContext ctx);
	/**
	 * Enter a parse tree produced by {@link PJQLParser#pjFieldBinding}.
	 * @param ctx the parse tree
	 */
	void enterPjFieldBinding(PJQLParser.PjFieldBindingContext ctx);
	/**
	 * Exit a parse tree produced by {@link PJQLParser#pjFieldBinding}.
	 * @param ctx the parse tree
	 */
	void exitPjFieldBinding(PJQLParser.PjFieldBindingContext ctx);
	/**
	 * Enter a parse tree produced by {@link PJQLParser#pjRecordConstructFieldName}.
	 * @param ctx the parse tree
	 */
	void enterPjRecordConstructFieldName(PJQLParser.PjRecordConstructFieldNameContext ctx);
	/**
	 * Exit a parse tree produced by {@link PJQLParser#pjRecordConstructFieldName}.
	 * @param ctx the parse tree
	 */
	void exitPjRecordConstructFieldName(PJQLParser.PjRecordConstructFieldNameContext ctx);
	/**
	 * Enter a parse tree produced by {@link PJQLParser#pjFieldValue}.
	 * @param ctx the parse tree
	 */
	void enterPjFieldValue(PJQLParser.PjFieldValueContext ctx);
	/**
	 * Exit a parse tree produced by {@link PJQLParser#pjFieldValue}.
	 * @param ctx the parse tree
	 */
	void exitPjFieldValue(PJQLParser.PjFieldValueContext ctx);
	/**
	 * Enter a parse tree produced by {@link PJQLParser#pjSelectVar}.
	 * @param ctx the parse tree
	 */
	void enterPjSelectVar(PJQLParser.PjSelectVarContext ctx);
	/**
	 * Exit a parse tree produced by {@link PJQLParser#pjSelectVar}.
	 * @param ctx the parse tree
	 */
	void exitPjSelectVar(PJQLParser.PjSelectVarContext ctx);
	/**
	 * Enter a parse tree produced by {@link PJQLParser#pjSelectConstant}.
	 * @param ctx the parse tree
	 */
	void enterPjSelectConstant(PJQLParser.PjSelectConstantContext ctx);
	/**
	 * Exit a parse tree produced by {@link PJQLParser#pjSelectConstant}.
	 * @param ctx the parse tree
	 */
	void exitPjSelectConstant(PJQLParser.PjSelectConstantContext ctx);
	/**
	 * Enter a parse tree produced by {@link PJQLParser#pjSelectQuery}.
	 * @param ctx the parse tree
	 */
	void enterPjSelectQuery(PJQLParser.PjSelectQueryContext ctx);
	/**
	 * Exit a parse tree produced by {@link PJQLParser#pjSelectQuery}.
	 * @param ctx the parse tree
	 */
	void exitPjSelectQuery(PJQLParser.PjSelectQueryContext ctx);
	/**
	 * Enter a parse tree produced by {@link PJQLParser#pjFromWhereClause}.
	 * @param ctx the parse tree
	 */
	void enterPjFromWhereClause(PJQLParser.PjFromWhereClauseContext ctx);
	/**
	 * Exit a parse tree produced by {@link PJQLParser#pjFromWhereClause}.
	 * @param ctx the parse tree
	 */
	void exitPjFromWhereClause(PJQLParser.PjFromWhereClauseContext ctx);
	/**
	 * Enter a parse tree produced by {@link PJQLParser#pjFromClause}.
	 * @param ctx the parse tree
	 */
	void enterPjFromClause(PJQLParser.PjFromClauseContext ctx);
	/**
	 * Exit a parse tree produced by {@link PJQLParser#pjFromClause}.
	 * @param ctx the parse tree
	 */
	void exitPjFromClause(PJQLParser.PjFromClauseContext ctx);
	/**
	 * Enter a parse tree produced by {@link PJQLParser#pjBinding}.
	 * @param ctx the parse tree
	 */
	void enterPjBinding(PJQLParser.PjBindingContext ctx);
	/**
	 * Exit a parse tree produced by {@link PJQLParser#pjBinding}.
	 * @param ctx the parse tree
	 */
	void exitPjBinding(PJQLParser.PjBindingContext ctx);
	/**
	 * Enter a parse tree produced by {@link PJQLParser#pjFromClauseBindingSource}.
	 * @param ctx the parse tree
	 */
	void enterPjFromClauseBindingSource(PJQLParser.PjFromClauseBindingSourceContext ctx);
	/**
	 * Exit a parse tree produced by {@link PJQLParser#pjFromClauseBindingSource}.
	 * @param ctx the parse tree
	 */
	void exitPjFromClauseBindingSource(PJQLParser.PjFromClauseBindingSourceContext ctx);
	/**
	 * Enter a parse tree produced by {@link PJQLParser#pjSource}.
	 * @param ctx the parse tree
	 */
	void enterPjSource(PJQLParser.PjSourceContext ctx);
	/**
	 * Exit a parse tree produced by {@link PJQLParser#pjSource}.
	 * @param ctx the parse tree
	 */
	void exitPjSource(PJQLParser.PjSourceContext ctx);
	/**
	 * Enter a parse tree produced by {@link PJQLParser#pjFromClauseBindingVar}.
	 * @param ctx the parse tree
	 */
	void enterPjFromClauseBindingVar(PJQLParser.PjFromClauseBindingVarContext ctx);
	/**
	 * Exit a parse tree produced by {@link PJQLParser#pjFromClauseBindingVar}.
	 * @param ctx the parse tree
	 */
	void exitPjFromClauseBindingVar(PJQLParser.PjFromClauseBindingVarContext ctx);
	/**
	 * Enter a parse tree produced by {@link PJQLParser#pjWhereClause}.
	 * @param ctx the parse tree
	 */
	void enterPjWhereClause(PJQLParser.PjWhereClauseContext ctx);
	/**
	 * Exit a parse tree produced by {@link PJQLParser#pjWhereClause}.
	 * @param ctx the parse tree
	 */
	void exitPjWhereClause(PJQLParser.PjWhereClauseContext ctx);
	/**
	 * Enter a parse tree produced by {@link PJQLParser#pjCondition}.
	 * @param ctx the parse tree
	 */
	void enterPjCondition(PJQLParser.PjConditionContext ctx);
	/**
	 * Exit a parse tree produced by {@link PJQLParser#pjCondition}.
	 * @param ctx the parse tree
	 */
	void exitPjCondition(PJQLParser.PjConditionContext ctx);
	/**
	 * Enter a parse tree produced by {@link PJQLParser#pjWhereCondEquality}.
	 * @param ctx the parse tree
	 */
	void enterPjWhereCondEquality(PJQLParser.PjWhereCondEqualityContext ctx);
	/**
	 * Exit a parse tree produced by {@link PJQLParser#pjWhereCondEquality}.
	 * @param ctx the parse tree
	 */
	void exitPjWhereCondEquality(PJQLParser.PjWhereCondEqualityContext ctx);
	/**
	 * Enter a parse tree produced by {@link PJQLParser#pjWhereCondEqualityLeftTerm}.
	 * @param ctx the parse tree
	 */
	void enterPjWhereCondEqualityLeftTerm(PJQLParser.PjWhereCondEqualityLeftTermContext ctx);
	/**
	 * Exit a parse tree produced by {@link PJQLParser#pjWhereCondEqualityLeftTerm}.
	 * @param ctx the parse tree
	 */
	void exitPjWhereCondEqualityLeftTerm(PJQLParser.PjWhereCondEqualityLeftTermContext ctx);
	/**
	 * Enter a parse tree produced by {@link PJQLParser#pjWhereCondEqualityRightTerm}.
	 * @param ctx the parse tree
	 */
	void enterPjWhereCondEqualityRightTerm(PJQLParser.PjWhereCondEqualityRightTermContext ctx);
	/**
	 * Exit a parse tree produced by {@link PJQLParser#pjWhereCondEqualityRightTerm}.
	 * @param ctx the parse tree
	 */
	void exitPjWhereCondEqualityRightTerm(PJQLParser.PjWhereCondEqualityRightTermContext ctx);
	/**
	 * Enter a parse tree produced by {@link PJQLParser#pjCTerm}.
	 * @param ctx the parse tree
	 */
	void enterPjCTerm(PJQLParser.PjCTermContext ctx);
	/**
	 * Exit a parse tree produced by {@link PJQLParser#pjCTerm}.
	 * @param ctx the parse tree
	 */
	void exitPjCTerm(PJQLParser.PjCTermContext ctx);
	/**
	 * Enter a parse tree produced by {@link PJQLParser#pjTerm}.
	 * @param ctx the parse tree
	 */
	void enterPjTerm(PJQLParser.PjTermContext ctx);
	/**
	 * Exit a parse tree produced by {@link PJQLParser#pjTerm}.
	 * @param ctx the parse tree
	 */
	void exitPjTerm(PJQLParser.PjTermContext ctx);
	/**
	 * Enter a parse tree produced by {@link PJQLParser#pjTermVar}.
	 * @param ctx the parse tree
	 */
	void enterPjTermVar(PJQLParser.PjTermVarContext ctx);
	/**
	 * Exit a parse tree produced by {@link PJQLParser#pjTermVar}.
	 * @param ctx the parse tree
	 */
	void exitPjTermVar(PJQLParser.PjTermVarContext ctx);
	/**
	 * Enter a parse tree produced by {@link PJQLParser#pjTermConstant}.
	 * @param ctx the parse tree
	 */
	void enterPjTermConstant(PJQLParser.PjTermConstantContext ctx);
	/**
	 * Exit a parse tree produced by {@link PJQLParser#pjTermConstant}.
	 * @param ctx the parse tree
	 */
	void exitPjTermConstant(PJQLParser.PjTermConstantContext ctx);
	/**
	 * Enter a parse tree produced by {@link PJQLParser#pjTermPath}.
	 * @param ctx the parse tree
	 */
	void enterPjTermPath(PJQLParser.PjTermPathContext ctx);
	/**
	 * Exit a parse tree produced by {@link PJQLParser#pjTermPath}.
	 * @param ctx the parse tree
	 */
	void exitPjTermPath(PJQLParser.PjTermPathContext ctx);
	/**
	 * Enter a parse tree produced by {@link PJQLParser#pjPath}.
	 * @param ctx the parse tree
	 */
	void enterPjPath(PJQLParser.PjPathContext ctx);
	/**
	 * Exit a parse tree produced by {@link PJQLParser#pjPath}.
	 * @param ctx the parse tree
	 */
	void exitPjPath(PJQLParser.PjPathContext ctx);
	/**
	 * Enter a parse tree produced by {@link PJQLParser#pjPathVar}.
	 * @param ctx the parse tree
	 */
	void enterPjPathVar(PJQLParser.PjPathVarContext ctx);
	/**
	 * Exit a parse tree produced by {@link PJQLParser#pjPathVar}.
	 * @param ctx the parse tree
	 */
	void exitPjPathVar(PJQLParser.PjPathVarContext ctx);
	/**
	 * Enter a parse tree produced by {@link PJQLParser#pjStep}.
	 * @param ctx the parse tree
	 */
	void enterPjStep(PJQLParser.PjStepContext ctx);
	/**
	 * Exit a parse tree produced by {@link PJQLParser#pjStep}.
	 * @param ctx the parse tree
	 */
	void exitPjStep(PJQLParser.PjStepContext ctx);
	/**
	 * Enter a parse tree produced by {@link PJQLParser#pjObjStep}.
	 * @param ctx the parse tree
	 */
	void enterPjObjStep(PJQLParser.PjObjStepContext ctx);
	/**
	 * Exit a parse tree produced by {@link PJQLParser#pjObjStep}.
	 * @param ctx the parse tree
	 */
	void exitPjObjStep(PJQLParser.PjObjStepContext ctx);
	/**
	 * Enter a parse tree produced by {@link PJQLParser#pjPathAttr}.
	 * @param ctx the parse tree
	 */
	void enterPjPathAttr(PJQLParser.PjPathAttrContext ctx);
	/**
	 * Exit a parse tree produced by {@link PJQLParser#pjPathAttr}.
	 * @param ctx the parse tree
	 */
	void exitPjPathAttr(PJQLParser.PjPathAttrContext ctx);
	/**
	 * Enter a parse tree produced by {@link PJQLParser#pjVariable}.
	 * @param ctx the parse tree
	 */
	void enterPjVariable(PJQLParser.PjVariableContext ctx);
	/**
	 * Exit a parse tree produced by {@link PJQLParser#pjVariable}.
	 * @param ctx the parse tree
	 */
	void exitPjVariable(PJQLParser.PjVariableContext ctx);
	/**
	 * Enter a parse tree produced by {@link PJQLParser#pjRelation}.
	 * @param ctx the parse tree
	 */
	void enterPjRelation(PJQLParser.PjRelationContext ctx);
	/**
	 * Exit a parse tree produced by {@link PJQLParser#pjRelation}.
	 * @param ctx the parse tree
	 */
	void exitPjRelation(PJQLParser.PjRelationContext ctx);
	/**
	 * Enter a parse tree produced by {@link PJQLParser#pjKey}.
	 * @param ctx the parse tree
	 */
	void enterPjKey(PJQLParser.PjKeyContext ctx);
	/**
	 * Exit a parse tree produced by {@link PJQLParser#pjKey}.
	 * @param ctx the parse tree
	 */
	void exitPjKey(PJQLParser.PjKeyContext ctx);
	/**
	 * Enter a parse tree produced by {@link PJQLParser#pjConstant}.
	 * @param ctx the parse tree
	 */
	void enterPjConstant(PJQLParser.PjConstantContext ctx);
	/**
	 * Exit a parse tree produced by {@link PJQLParser#pjConstant}.
	 * @param ctx the parse tree
	 */
	void exitPjConstant(PJQLParser.PjConstantContext ctx);
	/**
	 * Enter a parse tree produced by {@link PJQLParser#attribute}.
	 * @param ctx the parse tree
	 */
	void enterAttribute(PJQLParser.AttributeContext ctx);
	/**
	 * Exit a parse tree produced by {@link PJQLParser#attribute}.
	 * @param ctx the parse tree
	 */
	void exitAttribute(PJQLParser.AttributeContext ctx);
}