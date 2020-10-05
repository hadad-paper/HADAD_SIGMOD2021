// Generated from QBT.g4 by ANTLR 4.7.2

package hadad.base.compiler.model.qbt;

import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link QBTParser}.
 */
public interface QBTListener extends ParseTreeListener {
    /**
     * Enter a parse tree produced by {@link QBTParser#mixedqbt}.
     * 
     * @param ctx
     *            the parse tree
     */
    void enterMixedqbt(QBTParser.MixedqbtContext ctx);

    /**
     * Exit a parse tree produced by {@link QBTParser#mixedqbt}.
     * 
     * @param ctx
     *            the parse tree
     */
    void exitMixedqbt(QBTParser.MixedqbtContext ctx);

    /**
     * Enter a parse tree produced by {@link QBTParser#viewName}.
     * 
     * @param ctx
     *            the parse tree
     */
    void enterViewName(QBTParser.ViewNameContext ctx);

    /**
     * Exit a parse tree produced by {@link QBTParser#viewName}.
     * 
     * @param ctx
     *            the parse tree
     */
    void exitViewName(QBTParser.ViewNameContext ctx);

    /**
     * Enter a parse tree produced by {@link QBTParser#qbtQuery}.
     * 
     * @param ctx
     *            the parse tree
     */
    void enterQbtQuery(QBTParser.QbtQueryContext ctx);

    /**
     * Exit a parse tree produced by {@link QBTParser#qbtQuery}.
     * 
     * @param ctx
     *            the parse tree
     */
    void exitQbtQuery(QBTParser.QbtQueryContext ctx);

    /**
     * Enter a parse tree produced by {@link QBTParser#qbtBlock}.
     * 
     * @param ctx
     *            the parse tree
     */
    void enterQbtBlock(QBTParser.QbtBlockContext ctx);

    /**
     * Exit a parse tree produced by {@link QBTParser#qbtBlock}.
     * 
     * @param ctx
     *            the parse tree
     */
    void exitQbtBlock(QBTParser.QbtBlockContext ctx);

    /**
     * Enter a parse tree produced by {@link QBTParser#qbtForPattern}.
     * 
     * @param ctx
     *            the parse tree
     */
    void enterQbtForPattern(QBTParser.QbtForPatternContext ctx);

    /**
     * Exit a parse tree produced by {@link QBTParser#qbtForPattern}.
     * 
     * @param ctx
     *            the parse tree
     */
    void exitQbtForPattern(QBTParser.QbtForPatternContext ctx);

    /**
     * Enter a parse tree produced by {@link QBTParser#qbtWherePattern}.
     * 
     * @param ctx
     *            the parse tree
     */
    void enterQbtWherePattern(QBTParser.QbtWherePatternContext ctx);

    /**
     * Exit a parse tree produced by {@link QBTParser#qbtWherePattern}.
     * 
     * @param ctx
     *            the parse tree
     */
    void exitQbtWherePattern(QBTParser.QbtWherePatternContext ctx);

    /**
     * Enter a parse tree produced by {@link QBTParser#qbtReturnPattern}.
     * 
     * @param ctx
     *            the parse tree
     */
    void enterQbtReturnPattern(QBTParser.QbtReturnPatternContext ctx);

    /**
     * Exit a parse tree produced by {@link QBTParser#qbtReturnPattern}.
     * 
     * @param ctx
     *            the parse tree
     */
    void exitQbtReturnPattern(QBTParser.QbtReturnPatternContext ctx);

    /**
     * Enter a parse tree produced by {@link QBTParser#qbtPattern}.
     * 
     * @param ctx
     *            the parse tree
     */
    void enterQbtPattern(QBTParser.QbtPatternContext ctx);

    /**
     * Exit a parse tree produced by {@link QBTParser#qbtPattern}.
     * 
     * @param ctx
     *            the parse tree
     */
    void exitQbtPattern(QBTParser.QbtPatternContext ctx);

    /**
     * Enter a parse tree produced by {@link QBTParser#modelPattern}.
     * 
     * @param ctx
     *            the parse tree
     */
    void enterModelPattern(QBTParser.ModelPatternContext ctx);

    /**
     * Exit a parse tree produced by {@link QBTParser#modelPattern}.
     * 
     * @param ctx
     *            the parse tree
     */
    void exitModelPattern(QBTParser.ModelPatternContext ctx);

    /**
     * Enter a parse tree produced by {@link QBTParser#ajPattern}.
     * 
     * @param ctx
     *            the parse tree
     */
    void enterAjPattern(QBTParser.AjPatternContext ctx);

    /**
     * Exit a parse tree produced by {@link QBTParser#ajPattern}.
     * 
     * @param ctx
     *            the parse tree
     */
    void exitAjPattern(QBTParser.AjPatternContext ctx);

    /**
     * Enter a parse tree produced by {@link QBTParser#rkPattern}.
     * 
     * @param ctx
     *            the parse tree
     */
    void enterRkPattern(QBTParser.RkPatternContext ctx);

    /**
     * Exit a parse tree produced by {@link QBTParser#rkPattern}.
     * 
     * @param ctx
     *            the parse tree
     */
    void exitRkPattern(QBTParser.RkPatternContext ctx);

    /**
     * Enter a parse tree produced by {@link QBTParser#prPattern}.
     * 
     * @param ctx
     *            the parse tree
     */
    void enterPrPattern(QBTParser.PrPatternContext ctx);

    /**
     * Exit a parse tree produced by {@link QBTParser#prPattern}.
     * 
     * @param ctx
     *            the parse tree
     */
    void exitPrPattern(QBTParser.PrPatternContext ctx);

    /**
     * Enter a parse tree produced by {@link QBTParser#sppjPattern}.
     * 
     * @param ctx
     *            the parse tree
     */
    void enterSppjPattern(QBTParser.SppjPatternContext ctx);

    /**
     * Exit a parse tree produced by {@link QBTParser#sppjPattern}.
     * 
     * @param ctx
     *            the parse tree
     */
    void exitSppjPattern(QBTParser.SppjPatternContext ctx);

    /**
     * Enter a parse tree produced by {@link QBTParser#pjPattern}.
     * 
     * @param ctx
     *            the parse tree
     */
    void enterPjPattern(QBTParser.PjPatternContext ctx);

    /**
     * Exit a parse tree produced by {@link QBTParser#pjPattern}.
     * 
     * @param ctx
     *            the parse tree
     */
    void exitPjPattern(QBTParser.PjPatternContext ctx);

    /**
     * Enter a parse tree produced by {@link QBTParser#sjPattern}.
     * 
     * @param ctx
     *            the parse tree
     */
    void enterSjPattern(QBTParser.SjPatternContext ctx);

    /**
     * Exit a parse tree produced by {@link QBTParser#sjPattern}.
     * 
     * @param ctx
     *            the parse tree
     */
    void exitSjPattern(QBTParser.SjPatternContext ctx);

    /**
     * Enter a parse tree produced by {@link QBTParser#qbtCondition}.
     * 
     * @param ctx
     *            the parse tree
     */
    void enterQbtCondition(QBTParser.QbtConditionContext ctx);

    /**
     * Exit a parse tree produced by {@link QBTParser#qbtCondition}.
     * 
     * @param ctx
     *            the parse tree
     */
    void exitQbtCondition(QBTParser.QbtConditionContext ctx);

    /**
     * Enter a parse tree produced by {@link QBTParser#qbtAtom}.
     * 
     * @param ctx
     *            the parse tree
     */
    void enterQbtAtom(QBTParser.QbtAtomContext ctx);

    /**
     * Exit a parse tree produced by {@link QBTParser#qbtAtom}.
     * 
     * @param ctx
     *            the parse tree
     */
    void exitQbtAtom(QBTParser.QbtAtomContext ctx);

    /**
     * Enter a parse tree produced by {@link QBTParser#qbtVariable}.
     * 
     * @param ctx
     *            the parse tree
     */
    void enterQbtVariable(QBTParser.QbtVariableContext ctx);

    /**
     * Exit a parse tree produced by {@link QBTParser#qbtVariable}.
     * 
     * @param ctx
     *            the parse tree
     */
    void exitQbtVariable(QBTParser.QbtVariableContext ctx);

    /**
     * Enter a parse tree produced by {@link QBTParser#modelPathExpr}.
     * 
     * @param ctx
     *            the parse tree
     */
    void enterModelPathExpr(QBTParser.ModelPathExprContext ctx);

    /**
     * Exit a parse tree produced by {@link QBTParser#modelPathExpr}.
     * 
     * @param ctx
     *            the parse tree
     */
    void exitModelPathExpr(QBTParser.ModelPathExprContext ctx);

    /**
     * Enter a parse tree produced by {@link QBTParser#constructor}.
     * 
     * @param ctx
     *            the parse tree
     */
    void enterConstructor(QBTParser.ConstructorContext ctx);

    /**
     * Exit a parse tree produced by {@link QBTParser#constructor}.
     * 
     * @param ctx
     *            the parse tree
     */
    void exitConstructor(QBTParser.ConstructorContext ctx);

    /**
     * Enter a parse tree produced by {@link QBTParser#modelConstructor}.
     * 
     * @param ctx
     *            the parse tree
     */
    void enterModelConstructor(QBTParser.ModelConstructorContext ctx);

    /**
     * Exit a parse tree produced by {@link QBTParser#modelConstructor}.
     * 
     * @param ctx
     *            the parse tree
     */
    void exitModelConstructor(QBTParser.ModelConstructorContext ctx);

    /**
     * Enter a parse tree produced by {@link QBTParser#ajConstructor}.
     * 
     * @param ctx
     *            the parse tree
     */
    void enterAjConstructor(QBTParser.AjConstructorContext ctx);

    /**
     * Exit a parse tree produced by {@link QBTParser#ajConstructor}.
     * 
     * @param ctx
     *            the parse tree
     */
    void exitAjConstructor(QBTParser.AjConstructorContext ctx);

    /**
     * Enter a parse tree produced by {@link QBTParser#rkConstructor}.
     * 
     * @param ctx
     *            the parse tree
     */
    void enterRkConstructor(QBTParser.RkConstructorContext ctx);

    /**
     * Exit a parse tree produced by {@link QBTParser#rkConstructor}.
     * 
     * @param ctx
     *            the parse tree
     */
    void exitRkConstructor(QBTParser.RkConstructorContext ctx);

    /**
     * Enter a parse tree produced by {@link QBTParser#sppjConstructor}.
     * 
     * @param ctx
     *            the parse tree
     */
    void enterSppjConstructor(QBTParser.SppjConstructorContext ctx);

    /**
     * Exit a parse tree produced by {@link QBTParser#sppjConstructor}.
     * 
     * @param ctx
     *            the parse tree
     */
    void exitSppjConstructor(QBTParser.SppjConstructorContext ctx);

    /**
     * Enter a parse tree produced by {@link QBTParser#pjConstructor}.
     * 
     * @param ctx
     *            the parse tree
     */
    void enterPjConstructor(QBTParser.PjConstructorContext ctx);

    /**
     * Exit a parse tree produced by {@link QBTParser#pjConstructor}.
     * 
     * @param ctx
     *            the parse tree
     */
    void exitPjConstructor(QBTParser.PjConstructorContext ctx);

    /**
     * Enter a parse tree produced by {@link QBTParser#sjConstructor}.
     * 
     * @param ctx
     *            the parse tree
     */
    void enterSjConstructor(QBTParser.SjConstructorContext ctx);

    /**
     * Exit a parse tree produced by {@link QBTParser#sjConstructor}.
     * 
     * @param ctx
     *            the parse tree
     */
    void exitSjConstructor(QBTParser.SjConstructorContext ctx);

    /**
     * Enter a parse tree produced by {@link QBTParser#prConstructor}.
     * 
     * @param ctx
     *            the parse tree
     */
    void enterPrConstructor(QBTParser.PrConstructorContext ctx);

    /**
     * Exit a parse tree produced by {@link QBTParser#prConstructor}.
     * 
     * @param ctx
     *            the parse tree
     */
    void exitPrConstructor(QBTParser.PrConstructorContext ctx);

    /**
     * Enter a parse tree produced by {@link QBTParser#annotation}.
     * 
     * @param ctx
     *            the parse tree
     */
    void enterAnnotation(QBTParser.AnnotationContext ctx);

    /**
     * Exit a parse tree produced by {@link QBTParser#annotation}.
     * 
     * @param ctx
     *            the parse tree
     */
    void exitAnnotation(QBTParser.AnnotationContext ctx);

    /**
     * Enter a parse tree produced by {@link QBTParser#kqlquery}.
     * 
     * @param ctx
     *            the parse tree
     */
    void enterKqlquery(QBTParser.KqlqueryContext ctx);

    /**
     * Exit a parse tree produced by {@link QBTParser#kqlquery}.
     * 
     * @param ctx
     *            the parse tree
     */
    void exitKqlquery(QBTParser.KqlqueryContext ctx);

    /**
     * Enter a parse tree produced by {@link QBTParser#redisKQLQuery}.
     * 
     * @param ctx
     *            the parse tree
     */
    void enterRedisKQLQuery(QBTParser.RedisKQLQueryContext ctx);

    /**
     * Exit a parse tree produced by {@link QBTParser#redisKQLQuery}.
     * 
     * @param ctx
     *            the parse tree
     */
    void exitRedisKQLQuery(QBTParser.RedisKQLQueryContext ctx);

    /**
     * Enter a parse tree produced by {@link QBTParser#sfwQuery}.
     * 
     * @param ctx
     *            the parse tree
     */
    void enterSfwQuery(QBTParser.SfwQueryContext ctx);

    /**
     * Exit a parse tree produced by {@link QBTParser#sfwQuery}.
     * 
     * @param ctx
     *            the parse tree
     */
    void exitSfwQuery(QBTParser.SfwQueryContext ctx);

    /**
     * Enter a parse tree produced by {@link QBTParser#rkSelectClasue}.
     * 
     * @param ctx
     *            the parse tree
     */
    void enterRkSelectClasue(QBTParser.RkSelectClasueContext ctx);

    /**
     * Exit a parse tree produced by {@link QBTParser#rkSelectClasue}.
     * 
     * @param ctx
     *            the parse tree
     */
    void exitRkSelectClasue(QBTParser.RkSelectClasueContext ctx);

    /**
     * Enter a parse tree produced by {@link QBTParser#rkSelectStatement}.
     * 
     * @param ctx
     *            the parse tree
     */
    void enterRkSelectStatement(QBTParser.RkSelectStatementContext ctx);

    /**
     * Exit a parse tree produced by {@link QBTParser#rkSelectStatement}.
     * 
     * @param ctx
     *            the parse tree
     */
    void exitRkSelectStatement(QBTParser.RkSelectStatementContext ctx);

    /**
     * Enter a parse tree produced by {@link QBTParser#rkSelectItem}.
     * 
     * @param ctx
     *            the parse tree
     */
    void enterRkSelectItem(QBTParser.RkSelectItemContext ctx);

    /**
     * Exit a parse tree produced by {@link QBTParser#rkSelectItem}.
     * 
     * @param ctx
     *            the parse tree
     */
    void exitRkSelectItem(QBTParser.RkSelectItemContext ctx);

    /**
     * Enter a parse tree produced by {@link QBTParser#rkReturnVariable}.
     * 
     * @param ctx
     *            the parse tree
     */
    void enterRkReturnVariable(QBTParser.RkReturnVariableContext ctx);

    /**
     * Exit a parse tree produced by {@link QBTParser#rkReturnVariable}.
     * 
     * @param ctx
     *            the parse tree
     */
    void exitRkReturnVariable(QBTParser.RkReturnVariableContext ctx);

    /**
     * Enter a parse tree produced by {@link QBTParser#mapConstructor}.
     * 
     * @param ctx
     *            the parse tree
     */
    void enterMapConstructor(QBTParser.MapConstructorContext ctx);

    /**
     * Exit a parse tree produced by {@link QBTParser#mapConstructor}.
     * 
     * @param ctx
     *            the parse tree
     */
    void exitMapConstructor(QBTParser.MapConstructorContext ctx);

    /**
     * Enter a parse tree produced by {@link QBTParser#rkAttribute}.
     * 
     * @param ctx
     *            the parse tree
     */
    void enterRkAttribute(QBTParser.RkAttributeContext ctx);

    /**
     * Exit a parse tree produced by {@link QBTParser#rkAttribute}.
     * 
     * @param ctx
     *            the parse tree
     */
    void exitRkAttribute(QBTParser.RkAttributeContext ctx);

    /**
     * Enter a parse tree produced by {@link QBTParser#rkAttributeValue}.
     * 
     * @param ctx
     *            the parse tree
     */
    void enterRkAttributeValue(QBTParser.RkAttributeValueContext ctx);

    /**
     * Exit a parse tree produced by {@link QBTParser#rkAttributeValue}.
     * 
     * @param ctx
     *            the parse tree
     */
    void exitRkAttributeValue(QBTParser.RkAttributeValueContext ctx);

    /**
     * Enter a parse tree produced by {@link QBTParser#mapKey}.
     * 
     * @param ctx
     *            the parse tree
     */
    void enterMapKey(QBTParser.MapKeyContext ctx);

    /**
     * Exit a parse tree produced by {@link QBTParser#mapKey}.
     * 
     * @param ctx
     *            the parse tree
     */
    void exitMapKey(QBTParser.MapKeyContext ctx);

    /**
     * Enter a parse tree produced by {@link QBTParser#rkFromClasue}.
     * 
     * @param ctx
     *            the parse tree
     */
    void enterRkFromClasue(QBTParser.RkFromClasueContext ctx);

    /**
     * Exit a parse tree produced by {@link QBTParser#rkFromClasue}.
     * 
     * @param ctx
     *            the parse tree
     */
    void exitRkFromClasue(QBTParser.RkFromClasueContext ctx);

    /**
     * Enter a parse tree produced by {@link QBTParser#varBinding}.
     * 
     * @param ctx
     *            the parse tree
     */
    void enterVarBinding(QBTParser.VarBindingContext ctx);

    /**
     * Exit a parse tree produced by {@link QBTParser#varBinding}.
     * 
     * @param ctx
     *            the parse tree
     */
    void exitVarBinding(QBTParser.VarBindingContext ctx);

    /**
     * Enter a parse tree produced by {@link QBTParser#fromvariableBinding}.
     * 
     * @param ctx
     *            the parse tree
     */
    void enterFromvariableBinding(QBTParser.FromvariableBindingContext ctx);

    /**
     * Exit a parse tree produced by {@link QBTParser#fromvariableBinding}.
     * 
     * @param ctx
     *            the parse tree
     */
    void exitFromvariableBinding(QBTParser.FromvariableBindingContext ctx);

    /**
     * Enter a parse tree produced by {@link QBTParser#rkSource}.
     * 
     * @param ctx
     *            the parse tree
     */
    void enterRkSource(QBTParser.RkSourceContext ctx);

    /**
     * Exit a parse tree produced by {@link QBTParser#rkSource}.
     * 
     * @param ctx
     *            the parse tree
     */
    void exitRkSource(QBTParser.RkSourceContext ctx);

    /**
     * Enter a parse tree produced by the {@code MainMapLookUp}
     * labeled alternative in {@link QBTParser#rkLookUpExpression}.
     * 
     * @param ctx
     *            the parse tree
     */
    void enterMainMapLookUp(QBTParser.MainMapLookUpContext ctx);

    /**
     * Exit a parse tree produced by the {@code MainMapLookUp}
     * labeled alternative in {@link QBTParser#rkLookUpExpression}.
     * 
     * @param ctx
     *            the parse tree
     */
    void exitMainMapLookUp(QBTParser.MainMapLookUpContext ctx);

    /**
     * Enter a parse tree produced by the {@code VariableMapLookUp}
     * labeled alternative in {@link QBTParser#rkLookUpExpression}.
     * 
     * @param ctx
     *            the parse tree
     */
    void enterVariableMapLookUp(QBTParser.VariableMapLookUpContext ctx);

    /**
     * Exit a parse tree produced by the {@code VariableMapLookUp}
     * labeled alternative in {@link QBTParser#rkLookUpExpression}.
     * 
     * @param ctx
     *            the parse tree
     */
    void exitVariableMapLookUp(QBTParser.VariableMapLookUpContext ctx);

    /**
     * Enter a parse tree produced by the {@code KeysMapLookUp}
     * labeled alternative in {@link QBTParser#rkLookUpExpression}.
     * 
     * @param ctx
     *            the parse tree
     */
    void enterKeysMapLookUp(QBTParser.KeysMapLookUpContext ctx);

    /**
     * Exit a parse tree produced by the {@code KeysMapLookUp}
     * labeled alternative in {@link QBTParser#rkLookUpExpression}.
     * 
     * @param ctx
     *            the parse tree
     */
    void exitKeysMapLookUp(QBTParser.KeysMapLookUpContext ctx);

    /**
     * Enter a parse tree produced by {@link QBTParser#mainMap}.
     * 
     * @param ctx
     *            the parse tree
     */
    void enterMainMap(QBTParser.MainMapContext ctx);

    /**
     * Exit a parse tree produced by {@link QBTParser#mainMap}.
     * 
     * @param ctx
     *            the parse tree
     */
    void exitMainMap(QBTParser.MainMapContext ctx);

    /**
     * Enter a parse tree produced by {@link QBTParser#mapVariable}.
     * 
     * @param ctx
     *            the parse tree
     */
    void enterMapVariable(QBTParser.MapVariableContext ctx);

    /**
     * Exit a parse tree produced by {@link QBTParser#mapVariable}.
     * 
     * @param ctx
     *            the parse tree
     */
    void exitMapVariable(QBTParser.MapVariableContext ctx);

    /**
     * Enter a parse tree produced by {@link QBTParser#rkKey}.
     * 
     * @param ctx
     *            the parse tree
     */
    void enterRkKey(QBTParser.RkKeyContext ctx);

    /**
     * Exit a parse tree produced by {@link QBTParser#rkKey}.
     * 
     * @param ctx
     *            the parse tree
     */
    void exitRkKey(QBTParser.RkKeyContext ctx);

    /**
     * Enter a parse tree produced by {@link QBTParser#rkStringKey}.
     * 
     * @param ctx
     *            the parse tree
     */
    void enterRkStringKey(QBTParser.RkStringKeyContext ctx);

    /**
     * Exit a parse tree produced by {@link QBTParser#rkStringKey}.
     * 
     * @param ctx
     *            the parse tree
     */
    void exitRkStringKey(QBTParser.RkStringKeyContext ctx);

    /**
     * Enter a parse tree produced by {@link QBTParser#variableKey}.
     * 
     * @param ctx
     *            the parse tree
     */
    void enterVariableKey(QBTParser.VariableKeyContext ctx);

    /**
     * Exit a parse tree produced by {@link QBTParser#variableKey}.
     * 
     * @param ctx
     *            the parse tree
     */
    void exitVariableKey(QBTParser.VariableKeyContext ctx);

    /**
     * Enter a parse tree produced by {@link QBTParser#keyVariable}.
     * 
     * @param ctx
     *            the parse tree
     */
    void enterKeyVariable(QBTParser.KeyVariableContext ctx);

    /**
     * Exit a parse tree produced by {@link QBTParser#keyVariable}.
     * 
     * @param ctx
     *            the parse tree
     */
    void exitKeyVariable(QBTParser.KeyVariableContext ctx);

    /**
     * Enter a parse tree produced by {@link QBTParser#mapName}.
     * 
     * @param ctx
     *            the parse tree
     */
    void enterMapName(QBTParser.MapNameContext ctx);

    /**
     * Exit a parse tree produced by {@link QBTParser#mapName}.
     * 
     * @param ctx
     *            the parse tree
     */
    void exitMapName(QBTParser.MapNameContext ctx);

    /**
     * Enter a parse tree produced by {@link QBTParser#rkVariable}.
     * 
     * @param ctx
     *            the parse tree
     */
    void enterRkVariable(QBTParser.RkVariableContext ctx);

    /**
     * Exit a parse tree produced by {@link QBTParser#rkVariable}.
     * 
     * @param ctx
     *            the parse tree
     */
    void exitRkVariable(QBTParser.RkVariableContext ctx);

    /**
     * Enter a parse tree produced by {@link QBTParser#aqlquery}.
     * 
     * @param ctx
     *            the parse tree
     */
    void enterAqlquery(QBTParser.AqlqueryContext ctx);

    /**
     * Exit a parse tree produced by {@link QBTParser#aqlquery}.
     * 
     * @param ctx
     *            the parse tree
     */
    void exitAqlquery(QBTParser.AqlqueryContext ctx);

    /**
     * Enter a parse tree produced by {@link QBTParser#query}.
     * 
     * @param ctx
     *            the parse tree
     */
    void enterQuery(QBTParser.QueryContext ctx);

    /**
     * Exit a parse tree produced by {@link QBTParser#query}.
     * 
     * @param ctx
     *            the parse tree
     */
    void exitQuery(QBTParser.QueryContext ctx);

    /**
     * Enter a parse tree produced by {@link QBTParser#rootFieldName}.
     * 
     * @param ctx
     *            the parse tree
     */
    void enterRootFieldName(QBTParser.RootFieldNameContext ctx);

    /**
     * Exit a parse tree produced by {@link QBTParser#rootFieldName}.
     * 
     * @param ctx
     *            the parse tree
     */
    void exitRootFieldName(QBTParser.RootFieldNameContext ctx);

    /**
     * Enter a parse tree produced by {@link QBTParser#returnClause}.
     * 
     * @param ctx
     *            the parse tree
     */
    void enterReturnClause(QBTParser.ReturnClauseContext ctx);

    /**
     * Exit a parse tree produced by {@link QBTParser#returnClause}.
     * 
     * @param ctx
     *            the parse tree
     */
    void exitReturnClause(QBTParser.ReturnClauseContext ctx);

    /**
     * Enter a parse tree produced by {@link QBTParser#recordConstruct}.
     * 
     * @param ctx
     *            the parse tree
     */
    void enterRecordConstruct(QBTParser.RecordConstructContext ctx);

    /**
     * Exit a parse tree produced by {@link QBTParser#recordConstruct}.
     * 
     * @param ctx
     *            the parse tree
     */
    void exitRecordConstruct(QBTParser.RecordConstructContext ctx);

    /**
     * Enter a parse tree produced by {@link QBTParser#fieldBinding}.
     * 
     * @param ctx
     *            the parse tree
     */
    void enterFieldBinding(QBTParser.FieldBindingContext ctx);

    /**
     * Exit a parse tree produced by {@link QBTParser#fieldBinding}.
     * 
     * @param ctx
     *            the parse tree
     */
    void exitFieldBinding(QBTParser.FieldBindingContext ctx);

    /**
     * Enter a parse tree produced by {@link QBTParser#recordConstructFieldName}.
     * 
     * @param ctx
     *            the parse tree
     */
    void enterRecordConstructFieldName(QBTParser.RecordConstructFieldNameContext ctx);

    /**
     * Exit a parse tree produced by {@link QBTParser#recordConstructFieldName}.
     * 
     * @param ctx
     *            the parse tree
     */
    void exitRecordConstructFieldName(QBTParser.RecordConstructFieldNameContext ctx);

    /**
     * Enter a parse tree produced by {@link QBTParser#fieldName}.
     * 
     * @param ctx
     *            the parse tree
     */
    void enterFieldName(QBTParser.FieldNameContext ctx);

    /**
     * Exit a parse tree produced by {@link QBTParser#fieldName}.
     * 
     * @param ctx
     *            the parse tree
     */
    void exitFieldName(QBTParser.FieldNameContext ctx);

    /**
     * Enter a parse tree produced by {@link QBTParser#fieldValue}.
     * 
     * @param ctx
     *            the parse tree
     */
    void enterFieldValue(QBTParser.FieldValueContext ctx);

    /**
     * Exit a parse tree produced by {@link QBTParser#fieldValue}.
     * 
     * @param ctx
     *            the parse tree
     */
    void exitFieldValue(QBTParser.FieldValueContext ctx);

    /**
     * Enter a parse tree produced by {@link QBTParser#returnVar}.
     * 
     * @param ctx
     *            the parse tree
     */
    void enterReturnVar(QBTParser.ReturnVarContext ctx);

    /**
     * Exit a parse tree produced by {@link QBTParser#returnVar}.
     * 
     * @param ctx
     *            the parse tree
     */
    void exitReturnVar(QBTParser.ReturnVarContext ctx);

    /**
     * Enter a parse tree produced by {@link QBTParser#name}.
     * 
     * @param ctx
     *            the parse tree
     */
    void enterName(QBTParser.NameContext ctx);

    /**
     * Exit a parse tree produced by {@link QBTParser#name}.
     * 
     * @param ctx
     *            the parse tree
     */
    void exitName(QBTParser.NameContext ctx);

    /**
     * Enter a parse tree produced by {@link QBTParser#returnConstant}.
     * 
     * @param ctx
     *            the parse tree
     */
    void enterReturnConstant(QBTParser.ReturnConstantContext ctx);

    /**
     * Exit a parse tree produced by {@link QBTParser#returnConstant}.
     * 
     * @param ctx
     *            the parse tree
     */
    void exitReturnConstant(QBTParser.ReturnConstantContext ctx);

    /**
     * Enter a parse tree produced by {@link QBTParser#returnQuery}.
     * 
     * @param ctx
     *            the parse tree
     */
    void enterReturnQuery(QBTParser.ReturnQueryContext ctx);

    /**
     * Exit a parse tree produced by {@link QBTParser#returnQuery}.
     * 
     * @param ctx
     *            the parse tree
     */
    void exitReturnQuery(QBTParser.ReturnQueryContext ctx);

    /**
     * Enter a parse tree produced by {@link QBTParser#term}.
     * 
     * @param ctx
     *            the parse tree
     */
    void enterTerm(QBTParser.TermContext ctx);

    /**
     * Exit a parse tree produced by {@link QBTParser#term}.
     * 
     * @param ctx
     *            the parse tree
     */
    void exitTerm(QBTParser.TermContext ctx);

    /**
     * Enter a parse tree produced by {@link QBTParser#termVar}.
     * 
     * @param ctx
     *            the parse tree
     */
    void enterTermVar(QBTParser.TermVarContext ctx);

    /**
     * Exit a parse tree produced by {@link QBTParser#termVar}.
     * 
     * @param ctx
     *            the parse tree
     */
    void exitTermVar(QBTParser.TermVarContext ctx);

    /**
     * Enter a parse tree produced by {@link QBTParser#termConstant}.
     * 
     * @param ctx
     *            the parse tree
     */
    void enterTermConstant(QBTParser.TermConstantContext ctx);

    /**
     * Exit a parse tree produced by {@link QBTParser#termConstant}.
     * 
     * @param ctx
     *            the parse tree
     */
    void exitTermConstant(QBTParser.TermConstantContext ctx);

    /**
     * Enter a parse tree produced by {@link QBTParser#termPath}.
     * 
     * @param ctx
     *            the parse tree
     */
    void enterTermPath(QBTParser.TermPathContext ctx);

    /**
     * Exit a parse tree produced by {@link QBTParser#termPath}.
     * 
     * @param ctx
     *            the parse tree
     */
    void exitTermPath(QBTParser.TermPathContext ctx);

    /**
     * Enter a parse tree produced by {@link QBTParser#constant}.
     * 
     * @param ctx
     *            the parse tree
     */
    void enterConstant(QBTParser.ConstantContext ctx);

    /**
     * Exit a parse tree produced by {@link QBTParser#constant}.
     * 
     * @param ctx
     *            the parse tree
     */
    void exitConstant(QBTParser.ConstantContext ctx);

    /**
     * Enter a parse tree produced by {@link QBTParser#number}.
     * 
     * @param ctx
     *            the parse tree
     */
    void enterNumber(QBTParser.NumberContext ctx);

    /**
     * Exit a parse tree produced by {@link QBTParser#number}.
     * 
     * @param ctx
     *            the parse tree
     */
    void exitNumber(QBTParser.NumberContext ctx);

    /**
     * Enter a parse tree produced by {@link QBTParser#path}.
     * 
     * @param ctx
     *            the parse tree
     */
    void enterPath(QBTParser.PathContext ctx);

    /**
     * Exit a parse tree produced by {@link QBTParser#path}.
     * 
     * @param ctx
     *            the parse tree
     */
    void exitPath(QBTParser.PathContext ctx);

    /**
     * Enter a parse tree produced by {@link QBTParser#pathVar}.
     * 
     * @param ctx
     *            the parse tree
     */
    void enterPathVar(QBTParser.PathVarContext ctx);

    /**
     * Exit a parse tree produced by {@link QBTParser#pathVar}.
     * 
     * @param ctx
     *            the parse tree
     */
    void exitPathVar(QBTParser.PathVarContext ctx);

    /**
     * Enter a parse tree produced by {@link QBTParser#var}.
     * 
     * @param ctx
     *            the parse tree
     */
    void enterVar(QBTParser.VarContext ctx);

    /**
     * Exit a parse tree produced by {@link QBTParser#var}.
     * 
     * @param ctx
     *            the parse tree
     */
    void exitVar(QBTParser.VarContext ctx);

    /**
     * Enter a parse tree produced by {@link QBTParser#step}.
     * 
     * @param ctx
     *            the parse tree
     */
    void enterStep(QBTParser.StepContext ctx);

    /**
     * Exit a parse tree produced by {@link QBTParser#step}.
     * 
     * @param ctx
     *            the parse tree
     */
    void exitStep(QBTParser.StepContext ctx);

    /**
     * Enter a parse tree produced by {@link QBTParser#objectStep}.
     * 
     * @param ctx
     *            the parse tree
     */
    void enterObjectStep(QBTParser.ObjectStepContext ctx);

    /**
     * Exit a parse tree produced by {@link QBTParser#objectStep}.
     * 
     * @param ctx
     *            the parse tree
     */
    void exitObjectStep(QBTParser.ObjectStepContext ctx);

    /**
     * Enter a parse tree produced by {@link QBTParser#arrayStep}.
     * 
     * @param ctx
     *            the parse tree
     */
    void enterArrayStep(QBTParser.ArrayStepContext ctx);

    /**
     * Exit a parse tree produced by {@link QBTParser#arrayStep}.
     * 
     * @param ctx
     *            the parse tree
     */
    void exitArrayStep(QBTParser.ArrayStepContext ctx);

    /**
     * Enter a parse tree produced by {@link QBTParser#key}.
     * 
     * @param ctx
     *            the parse tree
     */
    void enterKey(QBTParser.KeyContext ctx);

    /**
     * Exit a parse tree produced by {@link QBTParser#key}.
     * 
     * @param ctx
     *            the parse tree
     */
    void exitKey(QBTParser.KeyContext ctx);

    /**
     * Enter a parse tree produced by {@link QBTParser#index}.
     * 
     * @param ctx
     *            the parse tree
     */
    void enterIndex(QBTParser.IndexContext ctx);

    /**
     * Exit a parse tree produced by {@link QBTParser#index}.
     * 
     * @param ctx
     *            the parse tree
     */
    void exitIndex(QBTParser.IndexContext ctx);

    /**
     * Enter a parse tree produced by {@link QBTParser#forClause}.
     * 
     * @param ctx
     *            the parse tree
     */
    void enterForClause(QBTParser.ForClauseContext ctx);

    /**
     * Exit a parse tree produced by {@link QBTParser#forClause}.
     * 
     * @param ctx
     *            the parse tree
     */
    void exitForClause(QBTParser.ForClauseContext ctx);

    /**
     * Enter a parse tree produced by {@link QBTParser#binding}.
     * 
     * @param ctx
     *            the parse tree
     */
    void enterBinding(QBTParser.BindingContext ctx);

    /**
     * Exit a parse tree produced by {@link QBTParser#binding}.
     * 
     * @param ctx
     *            the parse tree
     */
    void exitBinding(QBTParser.BindingContext ctx);

    /**
     * Enter a parse tree produced by {@link QBTParser#forClauseBindingVar}.
     * 
     * @param ctx
     *            the parse tree
     */
    void enterForClauseBindingVar(QBTParser.ForClauseBindingVarContext ctx);

    /**
     * Exit a parse tree produced by {@link QBTParser#forClauseBindingVar}.
     * 
     * @param ctx
     *            the parse tree
     */
    void exitForClauseBindingVar(QBTParser.ForClauseBindingVarContext ctx);

    /**
     * Enter a parse tree produced by {@link QBTParser#forClauseBindingSource}.
     * 
     * @param ctx
     *            the parse tree
     */
    void enterForClauseBindingSource(QBTParser.ForClauseBindingSourceContext ctx);

    /**
     * Exit a parse tree produced by {@link QBTParser#forClauseBindingSource}.
     * 
     * @param ctx
     *            the parse tree
     */
    void exitForClauseBindingSource(QBTParser.ForClauseBindingSourceContext ctx);

    /**
     * Enter a parse tree produced by {@link QBTParser#source}.
     * 
     * @param ctx
     *            the parse tree
     */
    void enterSource(QBTParser.SourceContext ctx);

    /**
     * Exit a parse tree produced by {@link QBTParser#source}.
     * 
     * @param ctx
     *            the parse tree
     */
    void exitSource(QBTParser.SourceContext ctx);

    /**
     * Enter a parse tree produced by {@link QBTParser#dataSetName}.
     * 
     * @param ctx
     *            the parse tree
     */
    void enterDataSetName(QBTParser.DataSetNameContext ctx);

    /**
     * Exit a parse tree produced by {@link QBTParser#dataSetName}.
     * 
     * @param ctx
     *            the parse tree
     */
    void exitDataSetName(QBTParser.DataSetNameContext ctx);

    /**
     * Enter a parse tree produced by {@link QBTParser#whereClause}.
     * 
     * @param ctx
     *            the parse tree
     */
    void enterWhereClause(QBTParser.WhereClauseContext ctx);

    /**
     * Exit a parse tree produced by {@link QBTParser#whereClause}.
     * 
     * @param ctx
     *            the parse tree
     */
    void exitWhereClause(QBTParser.WhereClauseContext ctx);

    /**
     * Enter a parse tree produced by {@link QBTParser#condition}.
     * 
     * @param ctx
     *            the parse tree
     */
    void enterCondition(QBTParser.ConditionContext ctx);

    /**
     * Exit a parse tree produced by {@link QBTParser#condition}.
     * 
     * @param ctx
     *            the parse tree
     */
    void exitCondition(QBTParser.ConditionContext ctx);

    /**
     * Enter a parse tree produced by {@link QBTParser#whereCondSome}.
     * 
     * @param ctx
     *            the parse tree
     */
    void enterWhereCondSome(QBTParser.WhereCondSomeContext ctx);

    /**
     * Exit a parse tree produced by {@link QBTParser#whereCondSome}.
     * 
     * @param ctx
     *            the parse tree
     */
    void exitWhereCondSome(QBTParser.WhereCondSomeContext ctx);

    /**
     * Enter a parse tree produced by {@link QBTParser#whereCondBinding}.
     * 
     * @param ctx
     *            the parse tree
     */
    void enterWhereCondBinding(QBTParser.WhereCondBindingContext ctx);

    /**
     * Exit a parse tree produced by {@link QBTParser#whereCondBinding}.
     * 
     * @param ctx
     *            the parse tree
     */
    void exitWhereCondBinding(QBTParser.WhereCondBindingContext ctx);

    /**
     * Enter a parse tree produced by {@link QBTParser#whereCondBindingVar}.
     * 
     * @param ctx
     *            the parse tree
     */
    void enterWhereCondBindingVar(QBTParser.WhereCondBindingVarContext ctx);

    /**
     * Exit a parse tree produced by {@link QBTParser#whereCondBindingVar}.
     * 
     * @param ctx
     *            the parse tree
     */
    void exitWhereCondBindingVar(QBTParser.WhereCondBindingVarContext ctx);

    /**
     * Enter a parse tree produced by {@link QBTParser#whereCondBindingSource}.
     * 
     * @param ctx
     *            the parse tree
     */
    void enterWhereCondBindingSource(QBTParser.WhereCondBindingSourceContext ctx);

    /**
     * Exit a parse tree produced by {@link QBTParser#whereCondBindingSource}.
     * 
     * @param ctx
     *            the parse tree
     */
    void exitWhereCondBindingSource(QBTParser.WhereCondBindingSourceContext ctx);

    /**
     * Enter a parse tree produced by {@link QBTParser#whereCondEquality}.
     * 
     * @param ctx
     *            the parse tree
     */
    void enterWhereCondEquality(QBTParser.WhereCondEqualityContext ctx);

    /**
     * Exit a parse tree produced by {@link QBTParser#whereCondEquality}.
     * 
     * @param ctx
     *            the parse tree
     */
    void exitWhereCondEquality(QBTParser.WhereCondEqualityContext ctx);

    /**
     * Enter a parse tree produced by {@link QBTParser#whereCondEqualityLeftTerm}.
     * 
     * @param ctx
     *            the parse tree
     */
    void enterWhereCondEqualityLeftTerm(QBTParser.WhereCondEqualityLeftTermContext ctx);

    /**
     * Exit a parse tree produced by {@link QBTParser#whereCondEqualityLeftTerm}.
     * 
     * @param ctx
     *            the parse tree
     */
    void exitWhereCondEqualityLeftTerm(QBTParser.WhereCondEqualityLeftTermContext ctx);

    /**
     * Enter a parse tree produced by {@link QBTParser#whereCondEqualityRightTerm}.
     * 
     * @param ctx
     *            the parse tree
     */
    void enterWhereCondEqualityRightTerm(QBTParser.WhereCondEqualityRightTermContext ctx);

    /**
     * Exit a parse tree produced by {@link QBTParser#whereCondEqualityRightTerm}.
     * 
     * @param ctx
     *            the parse tree
     */
    void exitWhereCondEqualityRightTerm(QBTParser.WhereCondEqualityRightTermContext ctx);

    /**
     * Enter a parse tree produced by {@link QBTParser#cterm}.
     * 
     * @param ctx
     *            the parse tree
     */
    void enterCterm(QBTParser.CtermContext ctx);

    /**
     * Exit a parse tree produced by {@link QBTParser#cterm}.
     * 
     * @param ctx
     *            the parse tree
     */
    void exitCterm(QBTParser.CtermContext ctx);

    /**
     * Enter a parse tree produced by {@link QBTParser#forWhereClauses}.
     * 
     * @param ctx
     *            the parse tree
     */
    void enterForWhereClauses(QBTParser.ForWhereClausesContext ctx);

    /**
     * Exit a parse tree produced by {@link QBTParser#forWhereClauses}.
     * 
     * @param ctx
     *            the parse tree
     */
    void exitForWhereClauses(QBTParser.ForWhereClausesContext ctx);

    /**
     * Enter a parse tree produced by {@link QBTParser#rqQuery}.
     * 
     * @param ctx
     *            the parse tree
     */
    void enterRqQuery(QBTParser.RqQueryContext ctx);

    /**
     * Exit a parse tree produced by {@link QBTParser#rqQuery}.
     * 
     * @param ctx
     *            the parse tree
     */
    void exitRqQuery(QBTParser.RqQueryContext ctx);

    /**
     * Enter a parse tree produced by {@link QBTParser#prSQuery}.
     * 
     * @param ctx
     *            the parse tree
     */
    void enterPrSQuery(QBTParser.PrSQueryContext ctx);

    /**
     * Exit a parse tree produced by {@link QBTParser#prSQuery}.
     * 
     * @param ctx
     *            the parse tree
     */
    void exitPrSQuery(QBTParser.PrSQueryContext ctx);

    /**
     * Enter a parse tree produced by {@link QBTParser#prSfwQuery}.
     * 
     * @param ctx
     *            the parse tree
     */
    void enterPrSfwQuery(QBTParser.PrSfwQueryContext ctx);

    /**
     * Exit a parse tree produced by {@link QBTParser#prSfwQuery}.
     * 
     * @param ctx
     *            the parse tree
     */
    void exitPrSfwQuery(QBTParser.PrSfwQueryContext ctx);

    /**
     * Enter a parse tree produced by {@link QBTParser#prFromWhereClauses}.
     * 
     * @param ctx
     *            the parse tree
     */
    void enterPrFromWhereClauses(QBTParser.PrFromWhereClausesContext ctx);

    /**
     * Exit a parse tree produced by {@link QBTParser#prFromWhereClauses}.
     * 
     * @param ctx
     *            the parse tree
     */
    void exitPrFromWhereClauses(QBTParser.PrFromWhereClausesContext ctx);

    /**
     * Enter a parse tree produced by {@link QBTParser#prSelectClause}.
     * 
     * @param ctx
     *            the parse tree
     */
    void enterPrSelectClause(QBTParser.PrSelectClauseContext ctx);

    /**
     * Exit a parse tree produced by {@link QBTParser#prSelectClause}.
     * 
     * @param ctx
     *            the parse tree
     */
    void exitPrSelectClause(QBTParser.PrSelectClauseContext ctx);

    /**
     * Enter a parse tree produced by {@link QBTParser#prSelectStatement}.
     * 
     * @param ctx
     *            the parse tree
     */
    void enterPrSelectStatement(QBTParser.PrSelectStatementContext ctx);

    /**
     * Exit a parse tree produced by {@link QBTParser#prSelectStatement}.
     * 
     * @param ctx
     *            the parse tree
     */
    void exitPrSelectStatement(QBTParser.PrSelectStatementContext ctx);

    /**
     * Enter a parse tree produced by {@link QBTParser#prSelectItem}.
     * 
     * @param ctx
     *            the parse tree
     */
    void enterPrSelectItem(QBTParser.PrSelectItemContext ctx);

    /**
     * Exit a parse tree produced by {@link QBTParser#prSelectItem}.
     * 
     * @param ctx
     *            the parse tree
     */
    void exitPrSelectItem(QBTParser.PrSelectItemContext ctx);

    /**
     * Enter a parse tree produced by {@link QBTParser#prFromClause}.
     * 
     * @param ctx
     *            the parse tree
     */
    void enterPrFromClause(QBTParser.PrFromClauseContext ctx);

    /**
     * Exit a parse tree produced by {@link QBTParser#prFromClause}.
     * 
     * @param ctx
     *            the parse tree
     */
    void exitPrFromClause(QBTParser.PrFromClauseContext ctx);

    /**
     * Enter a parse tree produced by {@link QBTParser#prRelationBinding}.
     * 
     * @param ctx
     *            the parse tree
     */
    void enterPrRelationBinding(QBTParser.PrRelationBindingContext ctx);

    /**
     * Exit a parse tree produced by {@link QBTParser#prRelationBinding}.
     * 
     * @param ctx
     *            the parse tree
     */
    void exitPrRelationBinding(QBTParser.PrRelationBindingContext ctx);

    /**
     * Enter a parse tree produced by {@link QBTParser#prSource}.
     * 
     * @param ctx
     *            the parse tree
     */
    void enterPrSource(QBTParser.PrSourceContext ctx);

    /**
     * Exit a parse tree produced by {@link QBTParser#prSource}.
     * 
     * @param ctx
     *            the parse tree
     */
    void exitPrSource(QBTParser.PrSourceContext ctx);

    /**
     * Enter a parse tree produced by {@link QBTParser#prRelationName}.
     * 
     * @param ctx
     *            the parse tree
     */
    void enterPrRelationName(QBTParser.PrRelationNameContext ctx);

    /**
     * Exit a parse tree produced by {@link QBTParser#prRelationName}.
     * 
     * @param ctx
     *            the parse tree
     */
    void exitPrRelationName(QBTParser.PrRelationNameContext ctx);

    /**
     * Enter a parse tree produced by {@link QBTParser#prVariable}.
     * 
     * @param ctx
     *            the parse tree
     */
    void enterPrVariable(QBTParser.PrVariableContext ctx);

    /**
     * Exit a parse tree produced by {@link QBTParser#prVariable}.
     * 
     * @param ctx
     *            the parse tree
     */
    void exitPrVariable(QBTParser.PrVariableContext ctx);

    /**
     * Enter a parse tree produced by {@link QBTParser#prWhereClause}.
     * 
     * @param ctx
     *            the parse tree
     */
    void enterPrWhereClause(QBTParser.PrWhereClauseContext ctx);

    /**
     * Exit a parse tree produced by {@link QBTParser#prWhereClause}.
     * 
     * @param ctx
     *            the parse tree
     */
    void exitPrWhereClause(QBTParser.PrWhereClauseContext ctx);

    /**
     * Enter a parse tree produced by {@link QBTParser#prWhereStatement}.
     * 
     * @param ctx
     *            the parse tree
     */
    void enterPrWhereStatement(QBTParser.PrWhereStatementContext ctx);

    /**
     * Exit a parse tree produced by {@link QBTParser#prWhereStatement}.
     * 
     * @param ctx
     *            the parse tree
     */
    void exitPrWhereStatement(QBTParser.PrWhereStatementContext ctx);

    /**
     * Enter a parse tree produced by {@link QBTParser#prCondition}.
     * 
     * @param ctx
     *            the parse tree
     */
    void enterPrCondition(QBTParser.PrConditionContext ctx);

    /**
     * Exit a parse tree produced by {@link QBTParser#prCondition}.
     * 
     * @param ctx
     *            the parse tree
     */
    void exitPrCondition(QBTParser.PrConditionContext ctx);

    /**
     * Enter a parse tree produced by {@link QBTParser#prTerm}.
     * 
     * @param ctx
     *            the parse tree
     */
    void enterPrTerm(QBTParser.PrTermContext ctx);

    /**
     * Exit a parse tree produced by {@link QBTParser#prTerm}.
     * 
     * @param ctx
     *            the parse tree
     */
    void exitPrTerm(QBTParser.PrTermContext ctx);

    /**
     * Enter a parse tree produced by {@link QBTParser#prEquality}.
     * 
     * @param ctx
     *            the parse tree
     */
    void enterPrEquality(QBTParser.PrEqualityContext ctx);

    /**
     * Exit a parse tree produced by {@link QBTParser#prEquality}.
     * 
     * @param ctx
     *            the parse tree
     */
    void exitPrEquality(QBTParser.PrEqualityContext ctx);

    /**
     * Enter a parse tree produced by {@link QBTParser#prLikeExpression}.
     * 
     * @param ctx
     *            the parse tree
     */
    void enterPrLikeExpression(QBTParser.PrLikeExpressionContext ctx);

    /**
     * Exit a parse tree produced by {@link QBTParser#prLikeExpression}.
     * 
     * @param ctx
     *            the parse tree
     */
    void exitPrLikeExpression(QBTParser.PrLikeExpressionContext ctx);

    /**
     * Enter a parse tree produced by {@link QBTParser#prLeftterm}.
     * 
     * @param ctx
     *            the parse tree
     */
    void enterPrLeftterm(QBTParser.PrLefttermContext ctx);

    /**
     * Exit a parse tree produced by {@link QBTParser#prLeftterm}.
     * 
     * @param ctx
     *            the parse tree
     */
    void exitPrLeftterm(QBTParser.PrLefttermContext ctx);

    /**
     * Enter a parse tree produced by {@link QBTParser#prRightterm}.
     * 
     * @param ctx
     *            the parse tree
     */
    void enterPrRightterm(QBTParser.PrRighttermContext ctx);

    /**
     * Exit a parse tree produced by {@link QBTParser#prRightterm}.
     * 
     * @param ctx
     *            the parse tree
     */
    void exitPrRightterm(QBTParser.PrRighttermContext ctx);

    /**
     * Enter a parse tree produced by {@link QBTParser#realtion}.
     * 
     * @param ctx
     *            the parse tree
     */
    void enterRealtion(QBTParser.RealtionContext ctx);

    /**
     * Exit a parse tree produced by {@link QBTParser#realtion}.
     * 
     * @param ctx
     *            the parse tree
     */
    void exitRealtion(QBTParser.RealtionContext ctx);

    /**
     * Enter a parse tree produced by {@link QBTParser#sjqlquery}.
     * 
     * @param ctx
     *            the parse tree
     */
    void enterSjqlquery(QBTParser.SjqlqueryContext ctx);

    /**
     * Exit a parse tree produced by {@link QBTParser#sjqlquery}.
     * 
     * @param ctx
     *            the parse tree
     */
    void exitSjqlquery(QBTParser.SjqlqueryContext ctx);

    /**
     * Enter a parse tree produced by {@link QBTParser#sjQuery}.
     * 
     * @param ctx
     *            the parse tree
     */
    void enterSjQuery(QBTParser.SjQueryContext ctx);

    /**
     * Exit a parse tree produced by {@link QBTParser#sjQuery}.
     * 
     * @param ctx
     *            the parse tree
     */
    void exitSjQuery(QBTParser.SjQueryContext ctx);

    /**
     * Enter a parse tree produced by {@link QBTParser#sjCollectionName}.
     * 
     * @param ctx
     *            the parse tree
     */
    void enterSjCollectionName(QBTParser.SjCollectionNameContext ctx);

    /**
     * Exit a parse tree produced by {@link QBTParser#sjCollectionName}.
     * 
     * @param ctx
     *            the parse tree
     */
    void exitSjCollectionName(QBTParser.SjCollectionNameContext ctx);

    /**
     * Enter a parse tree produced by {@link QBTParser#sjTextSearch}.
     * 
     * @param ctx
     *            the parse tree
     */
    void enterSjTextSearch(QBTParser.SjTextSearchContext ctx);

    /**
     * Exit a parse tree produced by {@link QBTParser#sjTextSearch}.
     * 
     * @param ctx
     *            the parse tree
     */
    void exitSjTextSearch(QBTParser.SjTextSearchContext ctx);

    /**
     * Enter a parse tree produced by {@link QBTParser#sjLeftTerm}.
     * 
     * @param ctx
     *            the parse tree
     */
    void enterSjLeftTerm(QBTParser.SjLeftTermContext ctx);

    /**
     * Exit a parse tree produced by {@link QBTParser#sjLeftTerm}.
     * 
     * @param ctx
     *            the parse tree
     */
    void exitSjLeftTerm(QBTParser.SjLeftTermContext ctx);

    /**
     * Enter a parse tree produced by {@link QBTParser#sjRightTerm}.
     * 
     * @param ctx
     *            the parse tree
     */
    void enterSjRightTerm(QBTParser.SjRightTermContext ctx);

    /**
     * Exit a parse tree produced by {@link QBTParser#sjRightTerm}.
     * 
     * @param ctx
     *            the parse tree
     */
    void exitSjRightTerm(QBTParser.SjRightTermContext ctx);

    /**
     * Enter a parse tree produced by {@link QBTParser#sjTerm}.
     * 
     * @param ctx
     *            the parse tree
     */
    void enterSjTerm(QBTParser.SjTermContext ctx);

    /**
     * Exit a parse tree produced by {@link QBTParser#sjTerm}.
     * 
     * @param ctx
     *            the parse tree
     */
    void exitSjTerm(QBTParser.SjTermContext ctx);

    /**
     * Enter a parse tree produced by {@link QBTParser#sjProjectFields}.
     * 
     * @param ctx
     *            the parse tree
     */
    void enterSjProjectFields(QBTParser.SjProjectFieldsContext ctx);

    /**
     * Exit a parse tree produced by {@link QBTParser#sjProjectFields}.
     * 
     * @param ctx
     *            the parse tree
     */
    void exitSjProjectFields(QBTParser.SjProjectFieldsContext ctx);

    /**
     * Enter a parse tree produced by {@link QBTParser#sjRecordConstruct}.
     * 
     * @param ctx
     *            the parse tree
     */
    void enterSjRecordConstruct(QBTParser.SjRecordConstructContext ctx);

    /**
     * Exit a parse tree produced by {@link QBTParser#sjRecordConstruct}.
     * 
     * @param ctx
     *            the parse tree
     */
    void exitSjRecordConstruct(QBTParser.SjRecordConstructContext ctx);

    /**
     * Enter a parse tree produced by {@link QBTParser#sjFieldBinding}.
     * 
     * @param ctx
     *            the parse tree
     */
    void enterSjFieldBinding(QBTParser.SjFieldBindingContext ctx);

    /**
     * Exit a parse tree produced by {@link QBTParser#sjFieldBinding}.
     * 
     * @param ctx
     *            the parse tree
     */
    void exitSjFieldBinding(QBTParser.SjFieldBindingContext ctx);

    /**
     * Enter a parse tree produced by {@link QBTParser#sjRecordConstructFieldName}.
     * 
     * @param ctx
     *            the parse tree
     */
    void enterSjRecordConstructFieldName(QBTParser.SjRecordConstructFieldNameContext ctx);

    /**
     * Exit a parse tree produced by {@link QBTParser#sjRecordConstructFieldName}.
     * 
     * @param ctx
     *            the parse tree
     */
    void exitSjRecordConstructFieldName(QBTParser.SjRecordConstructFieldNameContext ctx);

    /**
     * Enter a parse tree produced by {@link QBTParser#sjKeyName}.
     * 
     * @param ctx
     *            the parse tree
     */
    void enterSjKeyName(QBTParser.SjKeyNameContext ctx);

    /**
     * Exit a parse tree produced by {@link QBTParser#sjKeyName}.
     * 
     * @param ctx
     *            the parse tree
     */
    void exitSjKeyName(QBTParser.SjKeyNameContext ctx);

    /**
     * Enter a parse tree produced by {@link QBTParser#sjFieldValue}.
     * 
     * @param ctx
     *            the parse tree
     */
    void enterSjFieldValue(QBTParser.SjFieldValueContext ctx);

    /**
     * Exit a parse tree produced by {@link QBTParser#sjFieldValue}.
     * 
     * @param ctx
     *            the parse tree
     */
    void exitSjFieldValue(QBTParser.SjFieldValueContext ctx);

    /**
     * Enter a parse tree produced by {@link QBTParser#sjFieldName}.
     * 
     * @param ctx
     *            the parse tree
     */
    void enterSjFieldName(QBTParser.SjFieldNameContext ctx);

    /**
     * Exit a parse tree produced by {@link QBTParser#sjFieldName}.
     * 
     * @param ctx
     *            the parse tree
     */
    void exitSjFieldName(QBTParser.SjFieldNameContext ctx);

    /**
     * Enter a parse tree produced by {@link QBTParser#sjVar}.
     * 
     * @param ctx
     *            the parse tree
     */
    void enterSjVar(QBTParser.SjVarContext ctx);

    /**
     * Exit a parse tree produced by {@link QBTParser#sjVar}.
     * 
     * @param ctx
     *            the parse tree
     */
    void exitSjVar(QBTParser.SjVarContext ctx);

    /**
     * Enter a parse tree produced by {@link QBTParser#sjConstant}.
     * 
     * @param ctx
     *            the parse tree
     */
    void enterSjConstant(QBTParser.SjConstantContext ctx);

    /**
     * Exit a parse tree produced by {@link QBTParser#sjConstant}.
     * 
     * @param ctx
     *            the parse tree
     */
    void exitSjConstant(QBTParser.SjConstantContext ctx);

    /**
     * Enter a parse tree produced by {@link QBTParser#pjqlQuery}.
     * 
     * @param ctx
     *            the parse tree
     */
    void enterPjqlQuery(QBTParser.PjqlQueryContext ctx);

    /**
     * Exit a parse tree produced by {@link QBTParser#pjqlQuery}.
     * 
     * @param ctx
     *            the parse tree
     */
    void exitPjqlQuery(QBTParser.PjqlQueryContext ctx);

    /**
     * Enter a parse tree produced by {@link QBTParser#pjQuery}.
     * 
     * @param ctx
     *            the parse tree
     */
    void enterPjQuery(QBTParser.PjQueryContext ctx);

    /**
     * Exit a parse tree produced by {@link QBTParser#pjQuery}.
     * 
     * @param ctx
     *            the parse tree
     */
    void exitPjQuery(QBTParser.PjQueryContext ctx);

    /**
     * Enter a parse tree produced by {@link QBTParser#pjSelectClause}.
     * 
     * @param ctx
     *            the parse tree
     */
    void enterPjSelectClause(QBTParser.PjSelectClauseContext ctx);

    /**
     * Exit a parse tree produced by {@link QBTParser#pjSelectClause}.
     * 
     * @param ctx
     *            the parse tree
     */
    void exitPjSelectClause(QBTParser.PjSelectClauseContext ctx);

    /**
     * Enter a parse tree produced by {@link QBTParser#pjSelectStatement}.
     * 
     * @param ctx
     *            the parse tree
     */
    void enterPjSelectStatement(QBTParser.PjSelectStatementContext ctx);

    /**
     * Exit a parse tree produced by {@link QBTParser#pjSelectStatement}.
     * 
     * @param ctx
     *            the parse tree
     */
    void exitPjSelectStatement(QBTParser.PjSelectStatementContext ctx);

    /**
     * Enter a parse tree produced by {@link QBTParser#pjSelectItem}.
     * 
     * @param ctx
     *            the parse tree
     */
    void enterPjSelectItem(QBTParser.PjSelectItemContext ctx);

    /**
     * Exit a parse tree produced by {@link QBTParser#pjSelectItem}.
     * 
     * @param ctx
     *            the parse tree
     */
    void exitPjSelectItem(QBTParser.PjSelectItemContext ctx);

    /**
     * Enter a parse tree produced by {@link QBTParser#pjPathSelect}.
     * 
     * @param ctx
     *            the parse tree
     */
    void enterPjPathSelect(QBTParser.PjPathSelectContext ctx);

    /**
     * Exit a parse tree produced by {@link QBTParser#pjPathSelect}.
     * 
     * @param ctx
     *            the parse tree
     */
    void exitPjPathSelect(QBTParser.PjPathSelectContext ctx);

    /**
     * Enter a parse tree produced by {@link QBTParser#pjRecordConstruct}.
     * 
     * @param ctx
     *            the parse tree
     */
    void enterPjRecordConstruct(QBTParser.PjRecordConstructContext ctx);

    /**
     * Exit a parse tree produced by {@link QBTParser#pjRecordConstruct}.
     * 
     * @param ctx
     *            the parse tree
     */
    void exitPjRecordConstruct(QBTParser.PjRecordConstructContext ctx);

    /**
     * Enter a parse tree produced by {@link QBTParser#pjFieldBinding}.
     * 
     * @param ctx
     *            the parse tree
     */
    void enterPjFieldBinding(QBTParser.PjFieldBindingContext ctx);

    /**
     * Exit a parse tree produced by {@link QBTParser#pjFieldBinding}.
     * 
     * @param ctx
     *            the parse tree
     */
    void exitPjFieldBinding(QBTParser.PjFieldBindingContext ctx);

    /**
     * Enter a parse tree produced by {@link QBTParser#pjRecordConstructFieldName}.
     * 
     * @param ctx
     *            the parse tree
     */
    void enterPjRecordConstructFieldName(QBTParser.PjRecordConstructFieldNameContext ctx);

    /**
     * Exit a parse tree produced by {@link QBTParser#pjRecordConstructFieldName}.
     * 
     * @param ctx
     *            the parse tree
     */
    void exitPjRecordConstructFieldName(QBTParser.PjRecordConstructFieldNameContext ctx);

    /**
     * Enter a parse tree produced by {@link QBTParser#pjFieldValue}.
     * 
     * @param ctx
     *            the parse tree
     */
    void enterPjFieldValue(QBTParser.PjFieldValueContext ctx);

    /**
     * Exit a parse tree produced by {@link QBTParser#pjFieldValue}.
     * 
     * @param ctx
     *            the parse tree
     */
    void exitPjFieldValue(QBTParser.PjFieldValueContext ctx);

    /**
     * Enter a parse tree produced by {@link QBTParser#pjSelectVar}.
     * 
     * @param ctx
     *            the parse tree
     */
    void enterPjSelectVar(QBTParser.PjSelectVarContext ctx);

    /**
     * Exit a parse tree produced by {@link QBTParser#pjSelectVar}.
     * 
     * @param ctx
     *            the parse tree
     */
    void exitPjSelectVar(QBTParser.PjSelectVarContext ctx);

    /**
     * Enter a parse tree produced by {@link QBTParser#pjSelectConstant}.
     * 
     * @param ctx
     *            the parse tree
     */
    void enterPjSelectConstant(QBTParser.PjSelectConstantContext ctx);

    /**
     * Exit a parse tree produced by {@link QBTParser#pjSelectConstant}.
     * 
     * @param ctx
     *            the parse tree
     */
    void exitPjSelectConstant(QBTParser.PjSelectConstantContext ctx);

    /**
     * Enter a parse tree produced by {@link QBTParser#pjSelectQuery}.
     * 
     * @param ctx
     *            the parse tree
     */
    void enterPjSelectQuery(QBTParser.PjSelectQueryContext ctx);

    /**
     * Exit a parse tree produced by {@link QBTParser#pjSelectQuery}.
     * 
     * @param ctx
     *            the parse tree
     */
    void exitPjSelectQuery(QBTParser.PjSelectQueryContext ctx);

    /**
     * Enter a parse tree produced by {@link QBTParser#pjFromWhereClause}.
     * 
     * @param ctx
     *            the parse tree
     */
    void enterPjFromWhereClause(QBTParser.PjFromWhereClauseContext ctx);

    /**
     * Exit a parse tree produced by {@link QBTParser#pjFromWhereClause}.
     * 
     * @param ctx
     *            the parse tree
     */
    void exitPjFromWhereClause(QBTParser.PjFromWhereClauseContext ctx);

    /**
     * Enter a parse tree produced by {@link QBTParser#pjFromClause}.
     * 
     * @param ctx
     *            the parse tree
     */
    void enterPjFromClause(QBTParser.PjFromClauseContext ctx);

    /**
     * Exit a parse tree produced by {@link QBTParser#pjFromClause}.
     * 
     * @param ctx
     *            the parse tree
     */
    void exitPjFromClause(QBTParser.PjFromClauseContext ctx);

    /**
     * Enter a parse tree produced by {@link QBTParser#pjBinding}.
     * 
     * @param ctx
     *            the parse tree
     */
    void enterPjBinding(QBTParser.PjBindingContext ctx);

    /**
     * Exit a parse tree produced by {@link QBTParser#pjBinding}.
     * 
     * @param ctx
     *            the parse tree
     */
    void exitPjBinding(QBTParser.PjBindingContext ctx);

    /**
     * Enter a parse tree produced by {@link QBTParser#pjFromClauseBindingSource}.
     * 
     * @param ctx
     *            the parse tree
     */
    void enterPjFromClauseBindingSource(QBTParser.PjFromClauseBindingSourceContext ctx);

    /**
     * Exit a parse tree produced by {@link QBTParser#pjFromClauseBindingSource}.
     * 
     * @param ctx
     *            the parse tree
     */
    void exitPjFromClauseBindingSource(QBTParser.PjFromClauseBindingSourceContext ctx);

    /**
     * Enter a parse tree produced by {@link QBTParser#pjSource}.
     * 
     * @param ctx
     *            the parse tree
     */
    void enterPjSource(QBTParser.PjSourceContext ctx);

    /**
     * Exit a parse tree produced by {@link QBTParser#pjSource}.
     * 
     * @param ctx
     *            the parse tree
     */
    void exitPjSource(QBTParser.PjSourceContext ctx);

    /**
     * Enter a parse tree produced by {@link QBTParser#pjFromClauseBindingVar}.
     * 
     * @param ctx
     *            the parse tree
     */
    void enterPjFromClauseBindingVar(QBTParser.PjFromClauseBindingVarContext ctx);

    /**
     * Exit a parse tree produced by {@link QBTParser#pjFromClauseBindingVar}.
     * 
     * @param ctx
     *            the parse tree
     */
    void exitPjFromClauseBindingVar(QBTParser.PjFromClauseBindingVarContext ctx);

    /**
     * Enter a parse tree produced by {@link QBTParser#pjWhereClause}.
     * 
     * @param ctx
     *            the parse tree
     */
    void enterPjWhereClause(QBTParser.PjWhereClauseContext ctx);

    /**
     * Exit a parse tree produced by {@link QBTParser#pjWhereClause}.
     * 
     * @param ctx
     *            the parse tree
     */
    void exitPjWhereClause(QBTParser.PjWhereClauseContext ctx);

    /**
     * Enter a parse tree produced by {@link QBTParser#pjCondition}.
     * 
     * @param ctx
     *            the parse tree
     */
    void enterPjCondition(QBTParser.PjConditionContext ctx);

    /**
     * Exit a parse tree produced by {@link QBTParser#pjCondition}.
     * 
     * @param ctx
     *            the parse tree
     */
    void exitPjCondition(QBTParser.PjConditionContext ctx);

    /**
     * Enter a parse tree produced by {@link QBTParser#pjWhereCondEquality}.
     * 
     * @param ctx
     *            the parse tree
     */
    void enterPjWhereCondEquality(QBTParser.PjWhereCondEqualityContext ctx);

    /**
     * Exit a parse tree produced by {@link QBTParser#pjWhereCondEquality}.
     * 
     * @param ctx
     *            the parse tree
     */
    void exitPjWhereCondEquality(QBTParser.PjWhereCondEqualityContext ctx);

    /**
     * Enter a parse tree produced by {@link QBTParser#pjWhereCondEqualityLeftTerm}.
     * 
     * @param ctx
     *            the parse tree
     */
    void enterPjWhereCondEqualityLeftTerm(QBTParser.PjWhereCondEqualityLeftTermContext ctx);

    /**
     * Exit a parse tree produced by {@link QBTParser#pjWhereCondEqualityLeftTerm}.
     * 
     * @param ctx
     *            the parse tree
     */
    void exitPjWhereCondEqualityLeftTerm(QBTParser.PjWhereCondEqualityLeftTermContext ctx);

    /**
     * Enter a parse tree produced by {@link QBTParser#pjWhereCondEqualityRightTerm}.
     * 
     * @param ctx
     *            the parse tree
     */
    void enterPjWhereCondEqualityRightTerm(QBTParser.PjWhereCondEqualityRightTermContext ctx);

    /**
     * Exit a parse tree produced by {@link QBTParser#pjWhereCondEqualityRightTerm}.
     * 
     * @param ctx
     *            the parse tree
     */
    void exitPjWhereCondEqualityRightTerm(QBTParser.PjWhereCondEqualityRightTermContext ctx);

    /**
     * Enter a parse tree produced by {@link QBTParser#pjCTerm}.
     * 
     * @param ctx
     *            the parse tree
     */
    void enterPjCTerm(QBTParser.PjCTermContext ctx);

    /**
     * Exit a parse tree produced by {@link QBTParser#pjCTerm}.
     * 
     * @param ctx
     *            the parse tree
     */
    void exitPjCTerm(QBTParser.PjCTermContext ctx);

    /**
     * Enter a parse tree produced by {@link QBTParser#pjTerm}.
     * 
     * @param ctx
     *            the parse tree
     */
    void enterPjTerm(QBTParser.PjTermContext ctx);

    /**
     * Exit a parse tree produced by {@link QBTParser#pjTerm}.
     * 
     * @param ctx
     *            the parse tree
     */
    void exitPjTerm(QBTParser.PjTermContext ctx);

    /**
     * Enter a parse tree produced by {@link QBTParser#pjTermVar}.
     * 
     * @param ctx
     *            the parse tree
     */
    void enterPjTermVar(QBTParser.PjTermVarContext ctx);

    /**
     * Exit a parse tree produced by {@link QBTParser#pjTermVar}.
     * 
     * @param ctx
     *            the parse tree
     */
    void exitPjTermVar(QBTParser.PjTermVarContext ctx);

    /**
     * Enter a parse tree produced by {@link QBTParser#pjTermConstant}.
     * 
     * @param ctx
     *            the parse tree
     */
    void enterPjTermConstant(QBTParser.PjTermConstantContext ctx);

    /**
     * Exit a parse tree produced by {@link QBTParser#pjTermConstant}.
     * 
     * @param ctx
     *            the parse tree
     */
    void exitPjTermConstant(QBTParser.PjTermConstantContext ctx);

    /**
     * Enter a parse tree produced by {@link QBTParser#pjTermPath}.
     * 
     * @param ctx
     *            the parse tree
     */
    void enterPjTermPath(QBTParser.PjTermPathContext ctx);

    /**
     * Exit a parse tree produced by {@link QBTParser#pjTermPath}.
     * 
     * @param ctx
     *            the parse tree
     */
    void exitPjTermPath(QBTParser.PjTermPathContext ctx);

    /**
     * Enter a parse tree produced by {@link QBTParser#pjPath}.
     * 
     * @param ctx
     *            the parse tree
     */
    void enterPjPath(QBTParser.PjPathContext ctx);

    /**
     * Exit a parse tree produced by {@link QBTParser#pjPath}.
     * 
     * @param ctx
     *            the parse tree
     */
    void exitPjPath(QBTParser.PjPathContext ctx);

    /**
     * Enter a parse tree produced by {@link QBTParser#pjPathVar}.
     * 
     * @param ctx
     *            the parse tree
     */
    void enterPjPathVar(QBTParser.PjPathVarContext ctx);

    /**
     * Exit a parse tree produced by {@link QBTParser#pjPathVar}.
     * 
     * @param ctx
     *            the parse tree
     */
    void exitPjPathVar(QBTParser.PjPathVarContext ctx);

    /**
     * Enter a parse tree produced by {@link QBTParser#pjStep}.
     * 
     * @param ctx
     *            the parse tree
     */
    void enterPjStep(QBTParser.PjStepContext ctx);

    /**
     * Exit a parse tree produced by {@link QBTParser#pjStep}.
     * 
     * @param ctx
     *            the parse tree
     */
    void exitPjStep(QBTParser.PjStepContext ctx);

    /**
     * Enter a parse tree produced by {@link QBTParser#pjObjStep}.
     * 
     * @param ctx
     *            the parse tree
     */
    void enterPjObjStep(QBTParser.PjObjStepContext ctx);

    /**
     * Exit a parse tree produced by {@link QBTParser#pjObjStep}.
     * 
     * @param ctx
     *            the parse tree
     */
    void exitPjObjStep(QBTParser.PjObjStepContext ctx);

    /**
     * Enter a parse tree produced by {@link QBTParser#pjPathAttr}.
     * 
     * @param ctx
     *            the parse tree
     */
    void enterPjPathAttr(QBTParser.PjPathAttrContext ctx);

    /**
     * Exit a parse tree produced by {@link QBTParser#pjPathAttr}.
     * 
     * @param ctx
     *            the parse tree
     */
    void exitPjPathAttr(QBTParser.PjPathAttrContext ctx);

    /**
     * Enter a parse tree produced by {@link QBTParser#pjVariable}.
     * 
     * @param ctx
     *            the parse tree
     */
    void enterPjVariable(QBTParser.PjVariableContext ctx);

    /**
     * Exit a parse tree produced by {@link QBTParser#pjVariable}.
     * 
     * @param ctx
     *            the parse tree
     */
    void exitPjVariable(QBTParser.PjVariableContext ctx);

    /**
     * Enter a parse tree produced by {@link QBTParser#pjRelation}.
     * 
     * @param ctx
     *            the parse tree
     */
    void enterPjRelation(QBTParser.PjRelationContext ctx);

    /**
     * Exit a parse tree produced by {@link QBTParser#pjRelation}.
     * 
     * @param ctx
     *            the parse tree
     */
    void exitPjRelation(QBTParser.PjRelationContext ctx);

    /**
     * Enter a parse tree produced by {@link QBTParser#pjKey}.
     * 
     * @param ctx
     *            the parse tree
     */
    void enterPjKey(QBTParser.PjKeyContext ctx);

    /**
     * Exit a parse tree produced by {@link QBTParser#pjKey}.
     * 
     * @param ctx
     *            the parse tree
     */
    void exitPjKey(QBTParser.PjKeyContext ctx);

    /**
     * Enter a parse tree produced by {@link QBTParser#pjConstant}.
     * 
     * @param ctx
     *            the parse tree
     */
    void enterPjConstant(QBTParser.PjConstantContext ctx);

    /**
     * Exit a parse tree produced by {@link QBTParser#pjConstant}.
     * 
     * @param ctx
     *            the parse tree
     */
    void exitPjConstant(QBTParser.PjConstantContext ctx);

    /**
     * Enter a parse tree produced by {@link QBTParser#attribute}.
     * 
     * @param ctx
     *            the parse tree
     */
    void enterAttribute(QBTParser.AttributeContext ctx);

    /**
     * Exit a parse tree produced by {@link QBTParser#attribute}.
     * 
     * @param ctx
     *            the parse tree
     */
    void exitAttribute(QBTParser.AttributeContext ctx);

    /**
     * Enter a parse tree produced by {@link QBTParser#sppjqlQuery}.
     * 
     * @param ctx
     *            the parse tree
     */
    void enterSppjqlQuery(QBTParser.SppjqlQueryContext ctx);

    /**
     * Exit a parse tree produced by {@link QBTParser#sppjqlQuery}.
     * 
     * @param ctx
     *            the parse tree
     */
    void exitSppjqlQuery(QBTParser.SppjqlQueryContext ctx);

    /**
     * Enter a parse tree produced by {@link QBTParser#sppjQuery}.
     * 
     * @param ctx
     *            the parse tree
     */
    void enterSppjQuery(QBTParser.SppjQueryContext ctx);

    /**
     * Exit a parse tree produced by {@link QBTParser#sppjQuery}.
     * 
     * @param ctx
     *            the parse tree
     */
    void exitSppjQuery(QBTParser.SppjQueryContext ctx);

    /**
     * Enter a parse tree produced by {@link QBTParser#sppjRootFieldName}.
     * 
     * @param ctx
     *            the parse tree
     */
    void enterSppjRootFieldName(QBTParser.SppjRootFieldNameContext ctx);

    /**
     * Exit a parse tree produced by {@link QBTParser#sppjRootFieldName}.
     * 
     * @param ctx
     *            the parse tree
     */
    void exitSppjRootFieldName(QBTParser.SppjRootFieldNameContext ctx);

    /**
     * Enter a parse tree produced by {@link QBTParser#sppjSelectClause}.
     * 
     * @param ctx
     *            the parse tree
     */
    void enterSppjSelectClause(QBTParser.SppjSelectClauseContext ctx);

    /**
     * Exit a parse tree produced by {@link QBTParser#sppjSelectClause}.
     * 
     * @param ctx
     *            the parse tree
     */
    void exitSppjSelectClause(QBTParser.SppjSelectClauseContext ctx);

    /**
     * Enter a parse tree produced by {@link QBTParser#sppjSelectStatement}.
     * 
     * @param ctx
     *            the parse tree
     */
    void enterSppjSelectStatement(QBTParser.SppjSelectStatementContext ctx);

    /**
     * Exit a parse tree produced by {@link QBTParser#sppjSelectStatement}.
     * 
     * @param ctx
     *            the parse tree
     */
    void exitSppjSelectStatement(QBTParser.SppjSelectStatementContext ctx);

    /**
     * Enter a parse tree produced by {@link QBTParser#sppjSelectItem}.
     * 
     * @param ctx
     *            the parse tree
     */
    void enterSppjSelectItem(QBTParser.SppjSelectItemContext ctx);

    /**
     * Exit a parse tree produced by {@link QBTParser#sppjSelectItem}.
     * 
     * @param ctx
     *            the parse tree
     */
    void exitSppjSelectItem(QBTParser.SppjSelectItemContext ctx);

    /**
     * Enter a parse tree produced by {@link QBTParser#sppjRecordConstruct}.
     * 
     * @param ctx
     *            the parse tree
     */
    void enterSppjRecordConstruct(QBTParser.SppjRecordConstructContext ctx);

    /**
     * Exit a parse tree produced by {@link QBTParser#sppjRecordConstruct}.
     * 
     * @param ctx
     *            the parse tree
     */
    void exitSppjRecordConstruct(QBTParser.SppjRecordConstructContext ctx);

    /**
     * Enter a parse tree produced by {@link QBTParser#sppjFieldBinding}.
     * 
     * @param ctx
     *            the parse tree
     */
    void enterSppjFieldBinding(QBTParser.SppjFieldBindingContext ctx);

    /**
     * Exit a parse tree produced by {@link QBTParser#sppjFieldBinding}.
     * 
     * @param ctx
     *            the parse tree
     */
    void exitSppjFieldBinding(QBTParser.SppjFieldBindingContext ctx);

    /**
     * Enter a parse tree produced by {@link QBTParser#sppjRecordConstructFieldName}.
     * 
     * @param ctx
     *            the parse tree
     */
    void enterSppjRecordConstructFieldName(QBTParser.SppjRecordConstructFieldNameContext ctx);

    /**
     * Exit a parse tree produced by {@link QBTParser#sppjRecordConstructFieldName}.
     * 
     * @param ctx
     *            the parse tree
     */
    void exitSppjRecordConstructFieldName(QBTParser.SppjRecordConstructFieldNameContext ctx);

    /**
     * Enter a parse tree produced by {@link QBTParser#sppjFieldValue}.
     * 
     * @param ctx
     *            the parse tree
     */
    void enterSppjFieldValue(QBTParser.SppjFieldValueContext ctx);

    /**
     * Exit a parse tree produced by {@link QBTParser#sppjFieldValue}.
     * 
     * @param ctx
     *            the parse tree
     */
    void exitSppjFieldValue(QBTParser.SppjFieldValueContext ctx);

    /**
     * Enter a parse tree produced by {@link QBTParser#sppjSelectVar}.
     * 
     * @param ctx
     *            the parse tree
     */
    void enterSppjSelectVar(QBTParser.SppjSelectVarContext ctx);

    /**
     * Exit a parse tree produced by {@link QBTParser#sppjSelectVar}.
     * 
     * @param ctx
     *            the parse tree
     */
    void exitSppjSelectVar(QBTParser.SppjSelectVarContext ctx);

    /**
     * Enter a parse tree produced by {@link QBTParser#sppjSelectConstant}.
     * 
     * @param ctx
     *            the parse tree
     */
    void enterSppjSelectConstant(QBTParser.SppjSelectConstantContext ctx);

    /**
     * Exit a parse tree produced by {@link QBTParser#sppjSelectConstant}.
     * 
     * @param ctx
     *            the parse tree
     */
    void exitSppjSelectConstant(QBTParser.SppjSelectConstantContext ctx);

    /**
     * Enter a parse tree produced by {@link QBTParser#sppjSelectQuery}.
     * 
     * @param ctx
     *            the parse tree
     */
    void enterSppjSelectQuery(QBTParser.SppjSelectQueryContext ctx);

    /**
     * Exit a parse tree produced by {@link QBTParser#sppjSelectQuery}.
     * 
     * @param ctx
     *            the parse tree
     */
    void exitSppjSelectQuery(QBTParser.SppjSelectQueryContext ctx);

    /**
     * Enter a parse tree produced by {@link QBTParser#sppjFromWhereClause}.
     * 
     * @param ctx
     *            the parse tree
     */
    void enterSppjFromWhereClause(QBTParser.SppjFromWhereClauseContext ctx);

    /**
     * Exit a parse tree produced by {@link QBTParser#sppjFromWhereClause}.
     * 
     * @param ctx
     *            the parse tree
     */
    void exitSppjFromWhereClause(QBTParser.SppjFromWhereClauseContext ctx);

    /**
     * Enter a parse tree produced by {@link QBTParser#sppjFromClause}.
     * 
     * @param ctx
     *            the parse tree
     */
    void enterSppjFromClause(QBTParser.SppjFromClauseContext ctx);

    /**
     * Exit a parse tree produced by {@link QBTParser#sppjFromClause}.
     * 
     * @param ctx
     *            the parse tree
     */
    void exitSppjFromClause(QBTParser.SppjFromClauseContext ctx);

    /**
     * Enter a parse tree produced by {@link QBTParser#sppjBinding}.
     * 
     * @param ctx
     *            the parse tree
     */
    void enterSppjBinding(QBTParser.SppjBindingContext ctx);

    /**
     * Exit a parse tree produced by {@link QBTParser#sppjBinding}.
     * 
     * @param ctx
     *            the parse tree
     */
    void exitSppjBinding(QBTParser.SppjBindingContext ctx);

    /**
     * Enter a parse tree produced by {@link QBTParser#sppjFromClauseBindingSource}.
     * 
     * @param ctx
     *            the parse tree
     */
    void enterSppjFromClauseBindingSource(QBTParser.SppjFromClauseBindingSourceContext ctx);

    /**
     * Exit a parse tree produced by {@link QBTParser#sppjFromClauseBindingSource}.
     * 
     * @param ctx
     *            the parse tree
     */
    void exitSppjFromClauseBindingSource(QBTParser.SppjFromClauseBindingSourceContext ctx);

    /**
     * Enter a parse tree produced by {@link QBTParser#sppjSource}.
     * 
     * @param ctx
     *            the parse tree
     */
    void enterSppjSource(QBTParser.SppjSourceContext ctx);

    /**
     * Exit a parse tree produced by {@link QBTParser#sppjSource}.
     * 
     * @param ctx
     *            the parse tree
     */
    void exitSppjSource(QBTParser.SppjSourceContext ctx);

    /**
     * Enter a parse tree produced by {@link QBTParser#sppjFromClauseBindingVar}.
     * 
     * @param ctx
     *            the parse tree
     */
    void enterSppjFromClauseBindingVar(QBTParser.SppjFromClauseBindingVarContext ctx);

    /**
     * Exit a parse tree produced by {@link QBTParser#sppjFromClauseBindingVar}.
     * 
     * @param ctx
     *            the parse tree
     */
    void exitSppjFromClauseBindingVar(QBTParser.SppjFromClauseBindingVarContext ctx);

    /**
     * Enter a parse tree produced by {@link QBTParser#sppjWhereClause}.
     * 
     * @param ctx
     *            the parse tree
     */
    void enterSppjWhereClause(QBTParser.SppjWhereClauseContext ctx);

    /**
     * Exit a parse tree produced by {@link QBTParser#sppjWhereClause}.
     * 
     * @param ctx
     *            the parse tree
     */
    void exitSppjWhereClause(QBTParser.SppjWhereClauseContext ctx);

    /**
     * Enter a parse tree produced by {@link QBTParser#sppjCondition}.
     * 
     * @param ctx
     *            the parse tree
     */
    void enterSppjCondition(QBTParser.SppjConditionContext ctx);

    /**
     * Exit a parse tree produced by {@link QBTParser#sppjCondition}.
     * 
     * @param ctx
     *            the parse tree
     */
    void exitSppjCondition(QBTParser.SppjConditionContext ctx);

    /**
     * Enter a parse tree produced by {@link QBTParser#sppjWhereCondEquality}.
     * 
     * @param ctx
     *            the parse tree
     */
    void enterSppjWhereCondEquality(QBTParser.SppjWhereCondEqualityContext ctx);

    /**
     * Exit a parse tree produced by {@link QBTParser#sppjWhereCondEquality}.
     * 
     * @param ctx
     *            the parse tree
     */
    void exitSppjWhereCondEquality(QBTParser.SppjWhereCondEqualityContext ctx);

    /**
     * Enter a parse tree produced by {@link QBTParser#sppjWhereCondEqualityLeftTerm}.
     * 
     * @param ctx
     *            the parse tree
     */
    void enterSppjWhereCondEqualityLeftTerm(QBTParser.SppjWhereCondEqualityLeftTermContext ctx);

    /**
     * Exit a parse tree produced by {@link QBTParser#sppjWhereCondEqualityLeftTerm}.
     * 
     * @param ctx
     *            the parse tree
     */
    void exitSppjWhereCondEqualityLeftTerm(QBTParser.SppjWhereCondEqualityLeftTermContext ctx);

    /**
     * Enter a parse tree produced by {@link QBTParser#sppjWhereCondEqualityRightTerm}.
     * 
     * @param ctx
     *            the parse tree
     */
    void enterSppjWhereCondEqualityRightTerm(QBTParser.SppjWhereCondEqualityRightTermContext ctx);

    /**
     * Exit a parse tree produced by {@link QBTParser#sppjWhereCondEqualityRightTerm}.
     * 
     * @param ctx
     *            the parse tree
     */
    void exitSppjWhereCondEqualityRightTerm(QBTParser.SppjWhereCondEqualityRightTermContext ctx);

    /**
     * Enter a parse tree produced by {@link QBTParser#sppjCTerm}.
     * 
     * @param ctx
     *            the parse tree
     */
    void enterSppjCTerm(QBTParser.SppjCTermContext ctx);

    /**
     * Exit a parse tree produced by {@link QBTParser#sppjCTerm}.
     * 
     * @param ctx
     *            the parse tree
     */
    void exitSppjCTerm(QBTParser.SppjCTermContext ctx);

    /**
     * Enter a parse tree produced by {@link QBTParser#sppjTerm}.
     * 
     * @param ctx
     *            the parse tree
     */
    void enterSppjTerm(QBTParser.SppjTermContext ctx);

    /**
     * Exit a parse tree produced by {@link QBTParser#sppjTerm}.
     * 
     * @param ctx
     *            the parse tree
     */
    void exitSppjTerm(QBTParser.SppjTermContext ctx);

    /**
     * Enter a parse tree produced by {@link QBTParser#sppjTermVar}.
     * 
     * @param ctx
     *            the parse tree
     */
    void enterSppjTermVar(QBTParser.SppjTermVarContext ctx);

    /**
     * Exit a parse tree produced by {@link QBTParser#sppjTermVar}.
     * 
     * @param ctx
     *            the parse tree
     */
    void exitSppjTermVar(QBTParser.SppjTermVarContext ctx);

    /**
     * Enter a parse tree produced by {@link QBTParser#sppjTermConstant}.
     * 
     * @param ctx
     *            the parse tree
     */
    void enterSppjTermConstant(QBTParser.SppjTermConstantContext ctx);

    /**
     * Exit a parse tree produced by {@link QBTParser#sppjTermConstant}.
     * 
     * @param ctx
     *            the parse tree
     */
    void exitSppjTermConstant(QBTParser.SppjTermConstantContext ctx);

    /**
     * Enter a parse tree produced by {@link QBTParser#sppjTermPath}.
     * 
     * @param ctx
     *            the parse tree
     */
    void enterSppjTermPath(QBTParser.SppjTermPathContext ctx);

    /**
     * Exit a parse tree produced by {@link QBTParser#sppjTermPath}.
     * 
     * @param ctx
     *            the parse tree
     */
    void exitSppjTermPath(QBTParser.SppjTermPathContext ctx);

    /**
     * Enter a parse tree produced by {@link QBTParser#sppjPath}.
     * 
     * @param ctx
     *            the parse tree
     */
    void enterSppjPath(QBTParser.SppjPathContext ctx);

    /**
     * Exit a parse tree produced by {@link QBTParser#sppjPath}.
     * 
     * @param ctx
     *            the parse tree
     */
    void exitSppjPath(QBTParser.SppjPathContext ctx);

    /**
     * Enter a parse tree produced by {@link QBTParser#sppjPathVar}.
     * 
     * @param ctx
     *            the parse tree
     */
    void enterSppjPathVar(QBTParser.SppjPathVarContext ctx);

    /**
     * Exit a parse tree produced by {@link QBTParser#sppjPathVar}.
     * 
     * @param ctx
     *            the parse tree
     */
    void exitSppjPathVar(QBTParser.SppjPathVarContext ctx);

    /**
     * Enter a parse tree produced by {@link QBTParser#sppjStep}.
     * 
     * @param ctx
     *            the parse tree
     */
    void enterSppjStep(QBTParser.SppjStepContext ctx);

    /**
     * Exit a parse tree produced by {@link QBTParser#sppjStep}.
     * 
     * @param ctx
     *            the parse tree
     */
    void exitSppjStep(QBTParser.SppjStepContext ctx);

    /**
     * Enter a parse tree produced by {@link QBTParser#sppjObjStep}.
     * 
     * @param ctx
     *            the parse tree
     */
    void enterSppjObjStep(QBTParser.SppjObjStepContext ctx);

    /**
     * Exit a parse tree produced by {@link QBTParser#sppjObjStep}.
     * 
     * @param ctx
     *            the parse tree
     */
    void exitSppjObjStep(QBTParser.SppjObjStepContext ctx);

    /**
     * Enter a parse tree produced by {@link QBTParser#sppjVariable}.
     * 
     * @param ctx
     *            the parse tree
     */
    void enterSppjVariable(QBTParser.SppjVariableContext ctx);

    /**
     * Exit a parse tree produced by {@link QBTParser#sppjVariable}.
     * 
     * @param ctx
     *            the parse tree
     */
    void exitSppjVariable(QBTParser.SppjVariableContext ctx);

    /**
     * Enter a parse tree produced by {@link QBTParser#sppjFieldName}.
     * 
     * @param ctx
     *            the parse tree
     */
    void enterSppjFieldName(QBTParser.SppjFieldNameContext ctx);

    /**
     * Exit a parse tree produced by {@link QBTParser#sppjFieldName}.
     * 
     * @param ctx
     *            the parse tree
     */
    void exitSppjFieldName(QBTParser.SppjFieldNameContext ctx);

    /**
     * Enter a parse tree produced by {@link QBTParser#sppjConstant}.
     * 
     * @param ctx
     *            the parse tree
     */
    void enterSppjConstant(QBTParser.SppjConstantContext ctx);

    /**
     * Exit a parse tree produced by {@link QBTParser#sppjConstant}.
     * 
     * @param ctx
     *            the parse tree
     */
    void exitSppjConstant(QBTParser.SppjConstantContext ctx);
}