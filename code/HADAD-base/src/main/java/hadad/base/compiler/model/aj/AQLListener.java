// Generated from AQL.g4 by ANTLR 4.7.2

package hadad.base.compiler.model.aj;

import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link AQLParser}.
 */
public interface AQLListener extends ParseTreeListener {
    /**
     * Enter a parse tree produced by {@link AQLParser#aqlquery}.
     * 
     * @param ctx
     *            the parse tree
     */
    void enterAqlquery(AQLParser.AqlqueryContext ctx);

    /**
     * Exit a parse tree produced by {@link AQLParser#aqlquery}.
     * 
     * @param ctx
     *            the parse tree
     */
    void exitAqlquery(AQLParser.AqlqueryContext ctx);

    /**
     * Enter a parse tree produced by {@link AQLParser#viewName}.
     * 
     * @param ctx
     *            the parse tree
     */
    void enterViewName(AQLParser.ViewNameContext ctx);

    /**
     * Exit a parse tree produced by {@link AQLParser#viewName}.
     * 
     * @param ctx
     *            the parse tree
     */
    void exitViewName(AQLParser.ViewNameContext ctx);

    /**
     * Enter a parse tree produced by {@link AQLParser#query}.
     * 
     * @param ctx
     *            the parse tree
     */
    void enterQuery(AQLParser.QueryContext ctx);

    /**
     * Exit a parse tree produced by {@link AQLParser#query}.
     * 
     * @param ctx
     *            the parse tree
     */
    void exitQuery(AQLParser.QueryContext ctx);

    /**
     * Enter a parse tree produced by {@link AQLParser#rootFieldName}.
     * 
     * @param ctx
     *            the parse tree
     */
    void enterRootFieldName(AQLParser.RootFieldNameContext ctx);

    /**
     * Exit a parse tree produced by {@link AQLParser#rootFieldName}.
     * 
     * @param ctx
     *            the parse tree
     */
    void exitRootFieldName(AQLParser.RootFieldNameContext ctx);

    /**
     * Enter a parse tree produced by {@link AQLParser#returnClause}.
     * 
     * @param ctx
     *            the parse tree
     */
    void enterReturnClause(AQLParser.ReturnClauseContext ctx);

    /**
     * Exit a parse tree produced by {@link AQLParser#returnClause}.
     * 
     * @param ctx
     *            the parse tree
     */
    void exitReturnClause(AQLParser.ReturnClauseContext ctx);

    /**
     * Enter a parse tree produced by {@link AQLParser#recordConstruct}.
     * 
     * @param ctx
     *            the parse tree
     */
    void enterRecordConstruct(AQLParser.RecordConstructContext ctx);

    /**
     * Exit a parse tree produced by {@link AQLParser#recordConstruct}.
     * 
     * @param ctx
     *            the parse tree
     */
    void exitRecordConstruct(AQLParser.RecordConstructContext ctx);

    /**
     * Enter a parse tree produced by {@link AQLParser#fieldBinding}.
     * 
     * @param ctx
     *            the parse tree
     */
    void enterFieldBinding(AQLParser.FieldBindingContext ctx);

    /**
     * Exit a parse tree produced by {@link AQLParser#fieldBinding}.
     * 
     * @param ctx
     *            the parse tree
     */
    void exitFieldBinding(AQLParser.FieldBindingContext ctx);

    /**
     * Enter a parse tree produced by {@link AQLParser#recordConstructFieldName}.
     * 
     * @param ctx
     *            the parse tree
     */
    void enterRecordConstructFieldName(AQLParser.RecordConstructFieldNameContext ctx);

    /**
     * Exit a parse tree produced by {@link AQLParser#recordConstructFieldName}.
     * 
     * @param ctx
     *            the parse tree
     */
    void exitRecordConstructFieldName(AQLParser.RecordConstructFieldNameContext ctx);

    /**
     * Enter a parse tree produced by {@link AQLParser#fieldName}.
     * 
     * @param ctx
     *            the parse tree
     */
    void enterFieldName(AQLParser.FieldNameContext ctx);

    /**
     * Exit a parse tree produced by {@link AQLParser#fieldName}.
     * 
     * @param ctx
     *            the parse tree
     */
    void exitFieldName(AQLParser.FieldNameContext ctx);

    /**
     * Enter a parse tree produced by {@link AQLParser#fieldValue}.
     * 
     * @param ctx
     *            the parse tree
     */
    void enterFieldValue(AQLParser.FieldValueContext ctx);

    /**
     * Exit a parse tree produced by {@link AQLParser#fieldValue}.
     * 
     * @param ctx
     *            the parse tree
     */
    void exitFieldValue(AQLParser.FieldValueContext ctx);

    /**
     * Enter a parse tree produced by {@link AQLParser#returnVar}.
     * 
     * @param ctx
     *            the parse tree
     */
    void enterReturnVar(AQLParser.ReturnVarContext ctx);

    /**
     * Exit a parse tree produced by {@link AQLParser#returnVar}.
     * 
     * @param ctx
     *            the parse tree
     */
    void exitReturnVar(AQLParser.ReturnVarContext ctx);

    /**
     * Enter a parse tree produced by {@link AQLParser#name}.
     * 
     * @param ctx
     *            the parse tree
     */
    void enterName(AQLParser.NameContext ctx);

    /**
     * Exit a parse tree produced by {@link AQLParser#name}.
     * 
     * @param ctx
     *            the parse tree
     */
    void exitName(AQLParser.NameContext ctx);

    /**
     * Enter a parse tree produced by {@link AQLParser#returnConstant}.
     * 
     * @param ctx
     *            the parse tree
     */
    void enterReturnConstant(AQLParser.ReturnConstantContext ctx);

    /**
     * Exit a parse tree produced by {@link AQLParser#returnConstant}.
     * 
     * @param ctx
     *            the parse tree
     */
    void exitReturnConstant(AQLParser.ReturnConstantContext ctx);

    /**
     * Enter a parse tree produced by {@link AQLParser#returnQuery}.
     * 
     * @param ctx
     *            the parse tree
     */
    void enterReturnQuery(AQLParser.ReturnQueryContext ctx);

    /**
     * Exit a parse tree produced by {@link AQLParser#returnQuery}.
     * 
     * @param ctx
     *            the parse tree
     */
    void exitReturnQuery(AQLParser.ReturnQueryContext ctx);

    /**
     * Enter a parse tree produced by {@link AQLParser#term}.
     * 
     * @param ctx
     *            the parse tree
     */
    void enterTerm(AQLParser.TermContext ctx);

    /**
     * Exit a parse tree produced by {@link AQLParser#term}.
     * 
     * @param ctx
     *            the parse tree
     */
    void exitTerm(AQLParser.TermContext ctx);

    /**
     * Enter a parse tree produced by {@link AQLParser#termVar}.
     * 
     * @param ctx
     *            the parse tree
     */
    void enterTermVar(AQLParser.TermVarContext ctx);

    /**
     * Exit a parse tree produced by {@link AQLParser#termVar}.
     * 
     * @param ctx
     *            the parse tree
     */
    void exitTermVar(AQLParser.TermVarContext ctx);

    /**
     * Enter a parse tree produced by {@link AQLParser#termConstant}.
     * 
     * @param ctx
     *            the parse tree
     */
    void enterTermConstant(AQLParser.TermConstantContext ctx);

    /**
     * Exit a parse tree produced by {@link AQLParser#termConstant}.
     * 
     * @param ctx
     *            the parse tree
     */
    void exitTermConstant(AQLParser.TermConstantContext ctx);

    /**
     * Enter a parse tree produced by {@link AQLParser#termPath}.
     * 
     * @param ctx
     *            the parse tree
     */
    void enterTermPath(AQLParser.TermPathContext ctx);

    /**
     * Exit a parse tree produced by {@link AQLParser#termPath}.
     * 
     * @param ctx
     *            the parse tree
     */
    void exitTermPath(AQLParser.TermPathContext ctx);

    /**
     * Enter a parse tree produced by {@link AQLParser#constant}.
     * 
     * @param ctx
     *            the parse tree
     */
    void enterConstant(AQLParser.ConstantContext ctx);

    /**
     * Exit a parse tree produced by {@link AQLParser#constant}.
     * 
     * @param ctx
     *            the parse tree
     */
    void exitConstant(AQLParser.ConstantContext ctx);

    /**
     * Enter a parse tree produced by {@link AQLParser#number}.
     * 
     * @param ctx
     *            the parse tree
     */
    void enterNumber(AQLParser.NumberContext ctx);

    /**
     * Exit a parse tree produced by {@link AQLParser#number}.
     * 
     * @param ctx
     *            the parse tree
     */
    void exitNumber(AQLParser.NumberContext ctx);

    /**
     * Enter a parse tree produced by {@link AQLParser#path}.
     * 
     * @param ctx
     *            the parse tree
     */
    void enterPath(AQLParser.PathContext ctx);

    /**
     * Exit a parse tree produced by {@link AQLParser#path}.
     * 
     * @param ctx
     *            the parse tree
     */
    void exitPath(AQLParser.PathContext ctx);

    /**
     * Enter a parse tree produced by {@link AQLParser#pathVar}.
     * 
     * @param ctx
     *            the parse tree
     */
    void enterPathVar(AQLParser.PathVarContext ctx);

    /**
     * Exit a parse tree produced by {@link AQLParser#pathVar}.
     * 
     * @param ctx
     *            the parse tree
     */
    void exitPathVar(AQLParser.PathVarContext ctx);

    /**
     * Enter a parse tree produced by {@link AQLParser#var}.
     * 
     * @param ctx
     *            the parse tree
     */
    void enterVar(AQLParser.VarContext ctx);

    /**
     * Exit a parse tree produced by {@link AQLParser#var}.
     * 
     * @param ctx
     *            the parse tree
     */
    void exitVar(AQLParser.VarContext ctx);

    /**
     * Enter a parse tree produced by {@link AQLParser#step}.
     * 
     * @param ctx
     *            the parse tree
     */
    void enterStep(AQLParser.StepContext ctx);

    /**
     * Exit a parse tree produced by {@link AQLParser#step}.
     * 
     * @param ctx
     *            the parse tree
     */
    void exitStep(AQLParser.StepContext ctx);

    /**
     * Enter a parse tree produced by {@link AQLParser#objectStep}.
     * 
     * @param ctx
     *            the parse tree
     */
    void enterObjectStep(AQLParser.ObjectStepContext ctx);

    /**
     * Exit a parse tree produced by {@link AQLParser#objectStep}.
     * 
     * @param ctx
     *            the parse tree
     */
    void exitObjectStep(AQLParser.ObjectStepContext ctx);

    /**
     * Enter a parse tree produced by {@link AQLParser#arrayStep}.
     * 
     * @param ctx
     *            the parse tree
     */
    void enterArrayStep(AQLParser.ArrayStepContext ctx);

    /**
     * Exit a parse tree produced by {@link AQLParser#arrayStep}.
     * 
     * @param ctx
     *            the parse tree
     */
    void exitArrayStep(AQLParser.ArrayStepContext ctx);

    /**
     * Enter a parse tree produced by {@link AQLParser#key}.
     * 
     * @param ctx
     *            the parse tree
     */
    void enterKey(AQLParser.KeyContext ctx);

    /**
     * Exit a parse tree produced by {@link AQLParser#key}.
     * 
     * @param ctx
     *            the parse tree
     */
    void exitKey(AQLParser.KeyContext ctx);

    /**
     * Enter a parse tree produced by {@link AQLParser#index}.
     * 
     * @param ctx
     *            the parse tree
     */
    void enterIndex(AQLParser.IndexContext ctx);

    /**
     * Exit a parse tree produced by {@link AQLParser#index}.
     * 
     * @param ctx
     *            the parse tree
     */
    void exitIndex(AQLParser.IndexContext ctx);

    /**
     * Enter a parse tree produced by {@link AQLParser#forClause}.
     * 
     * @param ctx
     *            the parse tree
     */
    void enterForClause(AQLParser.ForClauseContext ctx);

    /**
     * Exit a parse tree produced by {@link AQLParser#forClause}.
     * 
     * @param ctx
     *            the parse tree
     */
    void exitForClause(AQLParser.ForClauseContext ctx);

    /**
     * Enter a parse tree produced by {@link AQLParser#binding}.
     * 
     * @param ctx
     *            the parse tree
     */
    void enterBinding(AQLParser.BindingContext ctx);

    /**
     * Exit a parse tree produced by {@link AQLParser#binding}.
     * 
     * @param ctx
     *            the parse tree
     */
    void exitBinding(AQLParser.BindingContext ctx);

    /**
     * Enter a parse tree produced by {@link AQLParser#forClauseBindingVar}.
     * 
     * @param ctx
     *            the parse tree
     */
    void enterForClauseBindingVar(AQLParser.ForClauseBindingVarContext ctx);

    /**
     * Exit a parse tree produced by {@link AQLParser#forClauseBindingVar}.
     * 
     * @param ctx
     *            the parse tree
     */
    void exitForClauseBindingVar(AQLParser.ForClauseBindingVarContext ctx);

    /**
     * Enter a parse tree produced by {@link AQLParser#forClauseBindingSource}.
     * 
     * @param ctx
     *            the parse tree
     */
    void enterForClauseBindingSource(AQLParser.ForClauseBindingSourceContext ctx);

    /**
     * Exit a parse tree produced by {@link AQLParser#forClauseBindingSource}.
     * 
     * @param ctx
     *            the parse tree
     */
    void exitForClauseBindingSource(AQLParser.ForClauseBindingSourceContext ctx);

    /**
     * Enter a parse tree produced by {@link AQLParser#source}.
     * 
     * @param ctx
     *            the parse tree
     */
    void enterSource(AQLParser.SourceContext ctx);

    /**
     * Exit a parse tree produced by {@link AQLParser#source}.
     * 
     * @param ctx
     *            the parse tree
     */
    void exitSource(AQLParser.SourceContext ctx);

    /**
     * Enter a parse tree produced by {@link AQLParser#dataSetName}.
     * 
     * @param ctx
     *            the parse tree
     */
    void enterDataSetName(AQLParser.DataSetNameContext ctx);

    /**
     * Exit a parse tree produced by {@link AQLParser#dataSetName}.
     * 
     * @param ctx
     *            the parse tree
     */
    void exitDataSetName(AQLParser.DataSetNameContext ctx);

    /**
     * Enter a parse tree produced by {@link AQLParser#whereClause}.
     * 
     * @param ctx
     *            the parse tree
     */
    void enterWhereClause(AQLParser.WhereClauseContext ctx);

    /**
     * Exit a parse tree produced by {@link AQLParser#whereClause}.
     * 
     * @param ctx
     *            the parse tree
     */
    void exitWhereClause(AQLParser.WhereClauseContext ctx);

    /**
     * Enter a parse tree produced by {@link AQLParser#condition}.
     * 
     * @param ctx
     *            the parse tree
     */
    void enterCondition(AQLParser.ConditionContext ctx);

    /**
     * Exit a parse tree produced by {@link AQLParser#condition}.
     * 
     * @param ctx
     *            the parse tree
     */
    void exitCondition(AQLParser.ConditionContext ctx);

    /**
     * Enter a parse tree produced by {@link AQLParser#whereCondSome}.
     * 
     * @param ctx
     *            the parse tree
     */
    void enterWhereCondSome(AQLParser.WhereCondSomeContext ctx);

    /**
     * Exit a parse tree produced by {@link AQLParser#whereCondSome}.
     * 
     * @param ctx
     *            the parse tree
     */
    void exitWhereCondSome(AQLParser.WhereCondSomeContext ctx);

    /**
     * Enter a parse tree produced by {@link AQLParser#whereCondBinding}.
     * 
     * @param ctx
     *            the parse tree
     */
    void enterWhereCondBinding(AQLParser.WhereCondBindingContext ctx);

    /**
     * Exit a parse tree produced by {@link AQLParser#whereCondBinding}.
     * 
     * @param ctx
     *            the parse tree
     */
    void exitWhereCondBinding(AQLParser.WhereCondBindingContext ctx);

    /**
     * Enter a parse tree produced by {@link AQLParser#whereCondBindingVar}.
     * 
     * @param ctx
     *            the parse tree
     */
    void enterWhereCondBindingVar(AQLParser.WhereCondBindingVarContext ctx);

    /**
     * Exit a parse tree produced by {@link AQLParser#whereCondBindingVar}.
     * 
     * @param ctx
     *            the parse tree
     */
    void exitWhereCondBindingVar(AQLParser.WhereCondBindingVarContext ctx);

    /**
     * Enter a parse tree produced by {@link AQLParser#whereCondBindingSource}.
     * 
     * @param ctx
     *            the parse tree
     */
    void enterWhereCondBindingSource(AQLParser.WhereCondBindingSourceContext ctx);

    /**
     * Exit a parse tree produced by {@link AQLParser#whereCondBindingSource}.
     * 
     * @param ctx
     *            the parse tree
     */
    void exitWhereCondBindingSource(AQLParser.WhereCondBindingSourceContext ctx);

    /**
     * Enter a parse tree produced by {@link AQLParser#whereCondEquality}.
     * 
     * @param ctx
     *            the parse tree
     */
    void enterWhereCondEquality(AQLParser.WhereCondEqualityContext ctx);

    /**
     * Exit a parse tree produced by {@link AQLParser#whereCondEquality}.
     * 
     * @param ctx
     *            the parse tree
     */
    void exitWhereCondEquality(AQLParser.WhereCondEqualityContext ctx);

    /**
     * Enter a parse tree produced by {@link AQLParser#whereCondEqualityLeftTerm}.
     * 
     * @param ctx
     *            the parse tree
     */
    void enterWhereCondEqualityLeftTerm(AQLParser.WhereCondEqualityLeftTermContext ctx);

    /**
     * Exit a parse tree produced by {@link AQLParser#whereCondEqualityLeftTerm}.
     * 
     * @param ctx
     *            the parse tree
     */
    void exitWhereCondEqualityLeftTerm(AQLParser.WhereCondEqualityLeftTermContext ctx);

    /**
     * Enter a parse tree produced by {@link AQLParser#whereCondEqualityRightTerm}.
     * 
     * @param ctx
     *            the parse tree
     */
    void enterWhereCondEqualityRightTerm(AQLParser.WhereCondEqualityRightTermContext ctx);

    /**
     * Exit a parse tree produced by {@link AQLParser#whereCondEqualityRightTerm}.
     * 
     * @param ctx
     *            the parse tree
     */
    void exitWhereCondEqualityRightTerm(AQLParser.WhereCondEqualityRightTermContext ctx);

    /**
     * Enter a parse tree produced by {@link AQLParser#cterm}.
     * 
     * @param ctx
     *            the parse tree
     */
    void enterCterm(AQLParser.CtermContext ctx);

    /**
     * Exit a parse tree produced by {@link AQLParser#cterm}.
     * 
     * @param ctx
     *            the parse tree
     */
    void exitCterm(AQLParser.CtermContext ctx);

    /**
     * Enter a parse tree produced by {@link AQLParser#forWhereClauses}.
     * 
     * @param ctx
     *            the parse tree
     */
    void enterForWhereClauses(AQLParser.ForWhereClausesContext ctx);

    /**
     * Exit a parse tree produced by {@link AQLParser#forWhereClauses}.
     * 
     * @param ctx
     *            the parse tree
     */
    void exitForWhereClauses(AQLParser.ForWhereClausesContext ctx);
}