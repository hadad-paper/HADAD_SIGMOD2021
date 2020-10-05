// Generated from SQL.g4 by ANTLR 4.7.2

package hadad.base.compiler.model.pr;

import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link SQLParser}.
 */
public interface SQLListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link SQLParser#rqQuery}.
	 * @param ctx the parse tree
	 */
	void enterRqQuery(SQLParser.RqQueryContext ctx);
	/**
	 * Exit a parse tree produced by {@link SQLParser#rqQuery}.
	 * @param ctx the parse tree
	 */
	void exitRqQuery(SQLParser.RqQueryContext ctx);
	/**
	 * Enter a parse tree produced by {@link SQLParser#viewName}.
	 * @param ctx the parse tree
	 */
	void enterViewName(SQLParser.ViewNameContext ctx);
	/**
	 * Exit a parse tree produced by {@link SQLParser#viewName}.
	 * @param ctx the parse tree
	 */
	void exitViewName(SQLParser.ViewNameContext ctx);
	/**
	 * Enter a parse tree produced by {@link SQLParser#prQuery}.
	 * @param ctx the parse tree
	 */
	void enterPrQuery(SQLParser.PrQueryContext ctx);
	/**
	 * Exit a parse tree produced by {@link SQLParser#prQuery}.
	 * @param ctx the parse tree
	 */
	void exitPrQuery(SQLParser.PrQueryContext ctx);
	/**
	 * Enter a parse tree produced by {@link SQLParser#prSfwQuery}.
	 * @param ctx the parse tree
	 */
	void enterPrSfwQuery(SQLParser.PrSfwQueryContext ctx);
	/**
	 * Exit a parse tree produced by {@link SQLParser#prSfwQuery}.
	 * @param ctx the parse tree
	 */
	void exitPrSfwQuery(SQLParser.PrSfwQueryContext ctx);
	/**
	 * Enter a parse tree produced by {@link SQLParser#prFromWhereClauses}.
	 * @param ctx the parse tree
	 */
	void enterPrFromWhereClauses(SQLParser.PrFromWhereClausesContext ctx);
	/**
	 * Exit a parse tree produced by {@link SQLParser#prFromWhereClauses}.
	 * @param ctx the parse tree
	 */
	void exitPrFromWhereClauses(SQLParser.PrFromWhereClausesContext ctx);
	/**
	 * Enter a parse tree produced by {@link SQLParser#prSelectClause}.
	 * @param ctx the parse tree
	 */
	void enterPrSelectClause(SQLParser.PrSelectClauseContext ctx);
	/**
	 * Exit a parse tree produced by {@link SQLParser#prSelectClause}.
	 * @param ctx the parse tree
	 */
	void exitPrSelectClause(SQLParser.PrSelectClauseContext ctx);
	/**
	 * Enter a parse tree produced by {@link SQLParser#prSelectStatement}.
	 * @param ctx the parse tree
	 */
	void enterPrSelectStatement(SQLParser.PrSelectStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link SQLParser#prSelectStatement}.
	 * @param ctx the parse tree
	 */
	void exitPrSelectStatement(SQLParser.PrSelectStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link SQLParser#prSelectItem}.
	 * @param ctx the parse tree
	 */
	void enterPrSelectItem(SQLParser.PrSelectItemContext ctx);
	/**
	 * Exit a parse tree produced by {@link SQLParser#prSelectItem}.
	 * @param ctx the parse tree
	 */
	void exitPrSelectItem(SQLParser.PrSelectItemContext ctx);
	/**
	 * Enter a parse tree produced by {@link SQLParser#prFromClause}.
	 * @param ctx the parse tree
	 */
	void enterPrFromClause(SQLParser.PrFromClauseContext ctx);
	/**
	 * Exit a parse tree produced by {@link SQLParser#prFromClause}.
	 * @param ctx the parse tree
	 */
	void exitPrFromClause(SQLParser.PrFromClauseContext ctx);
	/**
	 * Enter a parse tree produced by {@link SQLParser#prRelationBinding}.
	 * @param ctx the parse tree
	 */
	void enterPrRelationBinding(SQLParser.PrRelationBindingContext ctx);
	/**
	 * Exit a parse tree produced by {@link SQLParser#prRelationBinding}.
	 * @param ctx the parse tree
	 */
	void exitPrRelationBinding(SQLParser.PrRelationBindingContext ctx);
	/**
	 * Enter a parse tree produced by {@link SQLParser#prSource}.
	 * @param ctx the parse tree
	 */
	void enterPrSource(SQLParser.PrSourceContext ctx);
	/**
	 * Exit a parse tree produced by {@link SQLParser#prSource}.
	 * @param ctx the parse tree
	 */
	void exitPrSource(SQLParser.PrSourceContext ctx);
	/**
	 * Enter a parse tree produced by {@link SQLParser#prRelationName}.
	 * @param ctx the parse tree
	 */
	void enterPrRelationName(SQLParser.PrRelationNameContext ctx);
	/**
	 * Exit a parse tree produced by {@link SQLParser#prRelationName}.
	 * @param ctx the parse tree
	 */
	void exitPrRelationName(SQLParser.PrRelationNameContext ctx);
	/**
	 * Enter a parse tree produced by {@link SQLParser#prVariable}.
	 * @param ctx the parse tree
	 */
	void enterPrVariable(SQLParser.PrVariableContext ctx);
	/**
	 * Exit a parse tree produced by {@link SQLParser#prVariable}.
	 * @param ctx the parse tree
	 */
	void exitPrVariable(SQLParser.PrVariableContext ctx);
	/**
	 * Enter a parse tree produced by {@link SQLParser#prWhereClause}.
	 * @param ctx the parse tree
	 */
	void enterPrWhereClause(SQLParser.PrWhereClauseContext ctx);
	/**
	 * Exit a parse tree produced by {@link SQLParser#prWhereClause}.
	 * @param ctx the parse tree
	 */
	void exitPrWhereClause(SQLParser.PrWhereClauseContext ctx);
	/**
	 * Enter a parse tree produced by {@link SQLParser#prWhereStatement}.
	 * @param ctx the parse tree
	 */
	void enterPrWhereStatement(SQLParser.PrWhereStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link SQLParser#prWhereStatement}.
	 * @param ctx the parse tree
	 */
	void exitPrWhereStatement(SQLParser.PrWhereStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link SQLParser#prCondition}.
	 * @param ctx the parse tree
	 */
	void enterPrCondition(SQLParser.PrConditionContext ctx);
	/**
	 * Exit a parse tree produced by {@link SQLParser#prCondition}.
	 * @param ctx the parse tree
	 */
	void exitPrCondition(SQLParser.PrConditionContext ctx);
	/**
	 * Enter a parse tree produced by {@link SQLParser#prTerm}.
	 * @param ctx the parse tree
	 */
	void enterPrTerm(SQLParser.PrTermContext ctx);
	/**
	 * Exit a parse tree produced by {@link SQLParser#prTerm}.
	 * @param ctx the parse tree
	 */
	void exitPrTerm(SQLParser.PrTermContext ctx);
	/**
	 * Enter a parse tree produced by {@link SQLParser#prEquality}.
	 * @param ctx the parse tree
	 */
	void enterPrEquality(SQLParser.PrEqualityContext ctx);
	/**
	 * Exit a parse tree produced by {@link SQLParser#prEquality}.
	 * @param ctx the parse tree
	 */
	void exitPrEquality(SQLParser.PrEqualityContext ctx);
	/**
	 * Enter a parse tree produced by {@link SQLParser#prLikeExpression}.
	 * @param ctx the parse tree
	 */
	void enterPrLikeExpression(SQLParser.PrLikeExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link SQLParser#prLikeExpression}.
	 * @param ctx the parse tree
	 */
	void exitPrLikeExpression(SQLParser.PrLikeExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link SQLParser#prLeftterm}.
	 * @param ctx the parse tree
	 */
	void enterPrLeftterm(SQLParser.PrLefttermContext ctx);
	/**
	 * Exit a parse tree produced by {@link SQLParser#prLeftterm}.
	 * @param ctx the parse tree
	 */
	void exitPrLeftterm(SQLParser.PrLefttermContext ctx);
	/**
	 * Enter a parse tree produced by {@link SQLParser#prRightterm}.
	 * @param ctx the parse tree
	 */
	void enterPrRightterm(SQLParser.PrRighttermContext ctx);
	/**
	 * Exit a parse tree produced by {@link SQLParser#prRightterm}.
	 * @param ctx the parse tree
	 */
	void exitPrRightterm(SQLParser.PrRighttermContext ctx);
	/**
	 * Enter a parse tree produced by {@link SQLParser#realtion}.
	 * @param ctx the parse tree
	 */
	void enterRealtion(SQLParser.RealtionContext ctx);
	/**
	 * Exit a parse tree produced by {@link SQLParser#realtion}.
	 * @param ctx the parse tree
	 */
	void exitRealtion(SQLParser.RealtionContext ctx);
}