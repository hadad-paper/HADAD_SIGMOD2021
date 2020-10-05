// Generated from QBTM.g4 by ANTLR 4.7.2

package hadad.base.qbt.walker;

import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link QBTMParser}.
 */
public interface QBTMListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link QBTMParser#mixedqbt}.
	 * @param ctx the parse tree
	 */
	void enterMixedqbt(QBTMParser.MixedqbtContext ctx);
	/**
	 * Exit a parse tree produced by {@link QBTMParser#mixedqbt}.
	 * @param ctx the parse tree
	 */
	void exitMixedqbt(QBTMParser.MixedqbtContext ctx);
	/**
	 * Enter a parse tree produced by {@link QBTMParser#viewName}.
	 * @param ctx the parse tree
	 */
	void enterViewName(QBTMParser.ViewNameContext ctx);
	/**
	 * Exit a parse tree produced by {@link QBTMParser#viewName}.
	 * @param ctx the parse tree
	 */
	void exitViewName(QBTMParser.ViewNameContext ctx);
	/**
	 * Enter a parse tree produced by {@link QBTMParser#qbtQuery}.
	 * @param ctx the parse tree
	 */
	void enterQbtQuery(QBTMParser.QbtQueryContext ctx);
	/**
	 * Exit a parse tree produced by {@link QBTMParser#qbtQuery}.
	 * @param ctx the parse tree
	 */
	void exitQbtQuery(QBTMParser.QbtQueryContext ctx);
	/**
	 * Enter a parse tree produced by {@link QBTMParser#qbtBlock}.
	 * @param ctx the parse tree
	 */
	void enterQbtBlock(QBTMParser.QbtBlockContext ctx);
	/**
	 * Exit a parse tree produced by {@link QBTMParser#qbtBlock}.
	 * @param ctx the parse tree
	 */
	void exitQbtBlock(QBTMParser.QbtBlockContext ctx);
	/**
	 * Enter a parse tree produced by {@link QBTMParser#qbtForPattern}.
	 * @param ctx the parse tree
	 */
	void enterQbtForPattern(QBTMParser.QbtForPatternContext ctx);
	/**
	 * Exit a parse tree produced by {@link QBTMParser#qbtForPattern}.
	 * @param ctx the parse tree
	 */
	void exitQbtForPattern(QBTMParser.QbtForPatternContext ctx);
	/**
	 * Enter a parse tree produced by {@link QBTMParser#qbtWherePattern}.
	 * @param ctx the parse tree
	 */
	void enterQbtWherePattern(QBTMParser.QbtWherePatternContext ctx);
	/**
	 * Exit a parse tree produced by {@link QBTMParser#qbtWherePattern}.
	 * @param ctx the parse tree
	 */
	void exitQbtWherePattern(QBTMParser.QbtWherePatternContext ctx);
	/**
	 * Enter a parse tree produced by {@link QBTMParser#qbtReturnPattern}.
	 * @param ctx the parse tree
	 */
	void enterQbtReturnPattern(QBTMParser.QbtReturnPatternContext ctx);
	/**
	 * Exit a parse tree produced by {@link QBTMParser#qbtReturnPattern}.
	 * @param ctx the parse tree
	 */
	void exitQbtReturnPattern(QBTMParser.QbtReturnPatternContext ctx);
	/**
	 * Enter a parse tree produced by {@link QBTMParser#qbtPattern}.
	 * @param ctx the parse tree
	 */
	void enterQbtPattern(QBTMParser.QbtPatternContext ctx);
	/**
	 * Exit a parse tree produced by {@link QBTMParser#qbtPattern}.
	 * @param ctx the parse tree
	 */
	void exitQbtPattern(QBTMParser.QbtPatternContext ctx);
	/**
	 * Enter a parse tree produced by {@link QBTMParser#modelPattern}.
	 * @param ctx the parse tree
	 */
	void enterModelPattern(QBTMParser.ModelPatternContext ctx);
	/**
	 * Exit a parse tree produced by {@link QBTMParser#modelPattern}.
	 * @param ctx the parse tree
	 */
	void exitModelPattern(QBTMParser.ModelPatternContext ctx);
	/**
	 * Enter a parse tree produced by {@link QBTMParser#ajPattern}.
	 * @param ctx the parse tree
	 */
	void enterAjPattern(QBTMParser.AjPatternContext ctx);
	/**
	 * Exit a parse tree produced by {@link QBTMParser#ajPattern}.
	 * @param ctx the parse tree
	 */
	void exitAjPattern(QBTMParser.AjPatternContext ctx);
	/**
	 * Enter a parse tree produced by {@link QBTMParser#rkPattern}.
	 * @param ctx the parse tree
	 */
	void enterRkPattern(QBTMParser.RkPatternContext ctx);
	/**
	 * Exit a parse tree produced by {@link QBTMParser#rkPattern}.
	 * @param ctx the parse tree
	 */
	void exitRkPattern(QBTMParser.RkPatternContext ctx);
	/**
	 * Enter a parse tree produced by {@link QBTMParser#prPattern}.
	 * @param ctx the parse tree
	 */
	void enterPrPattern(QBTMParser.PrPatternContext ctx);
	/**
	 * Exit a parse tree produced by {@link QBTMParser#prPattern}.
	 * @param ctx the parse tree
	 */
	void exitPrPattern(QBTMParser.PrPatternContext ctx);
	/**
	 * Enter a parse tree produced by {@link QBTMParser#sppjPattern}.
	 * @param ctx the parse tree
	 */
	void enterSppjPattern(QBTMParser.SppjPatternContext ctx);
	/**
	 * Exit a parse tree produced by {@link QBTMParser#sppjPattern}.
	 * @param ctx the parse tree
	 */
	void exitSppjPattern(QBTMParser.SppjPatternContext ctx);
	/**
	 * Enter a parse tree produced by {@link QBTMParser#pjPattern}.
	 * @param ctx the parse tree
	 */
	void enterPjPattern(QBTMParser.PjPatternContext ctx);
	/**
	 * Exit a parse tree produced by {@link QBTMParser#pjPattern}.
	 * @param ctx the parse tree
	 */
	void exitPjPattern(QBTMParser.PjPatternContext ctx);
	/**
	 * Enter a parse tree produced by {@link QBTMParser#sjPattern}.
	 * @param ctx the parse tree
	 */
	void enterSjPattern(QBTMParser.SjPatternContext ctx);
	/**
	 * Exit a parse tree produced by {@link QBTMParser#sjPattern}.
	 * @param ctx the parse tree
	 */
	void exitSjPattern(QBTMParser.SjPatternContext ctx);
	/**
	 * Enter a parse tree produced by {@link QBTMParser#qbtCondition}.
	 * @param ctx the parse tree
	 */
	void enterQbtCondition(QBTMParser.QbtConditionContext ctx);
	/**
	 * Exit a parse tree produced by {@link QBTMParser#qbtCondition}.
	 * @param ctx the parse tree
	 */
	void exitQbtCondition(QBTMParser.QbtConditionContext ctx);
	/**
	 * Enter a parse tree produced by {@link QBTMParser#qbtAtom}.
	 * @param ctx the parse tree
	 */
	void enterQbtAtom(QBTMParser.QbtAtomContext ctx);
	/**
	 * Exit a parse tree produced by {@link QBTMParser#qbtAtom}.
	 * @param ctx the parse tree
	 */
	void exitQbtAtom(QBTMParser.QbtAtomContext ctx);
	/**
	 * Enter a parse tree produced by {@link QBTMParser#qbtTermLeft}.
	 * @param ctx the parse tree
	 */
	void enterQbtTermLeft(QBTMParser.QbtTermLeftContext ctx);
	/**
	 * Exit a parse tree produced by {@link QBTMParser#qbtTermLeft}.
	 * @param ctx the parse tree
	 */
	void exitQbtTermLeft(QBTMParser.QbtTermLeftContext ctx);
	/**
	 * Enter a parse tree produced by {@link QBTMParser#qbtTermRight}.
	 * @param ctx the parse tree
	 */
	void enterQbtTermRight(QBTMParser.QbtTermRightContext ctx);
	/**
	 * Exit a parse tree produced by {@link QBTMParser#qbtTermRight}.
	 * @param ctx the parse tree
	 */
	void exitQbtTermRight(QBTMParser.QbtTermRightContext ctx);
	/**
	 * Enter a parse tree produced by {@link QBTMParser#qbtTerm}.
	 * @param ctx the parse tree
	 */
	void enterQbtTerm(QBTMParser.QbtTermContext ctx);
	/**
	 * Exit a parse tree produced by {@link QBTMParser#qbtTerm}.
	 * @param ctx the parse tree
	 */
	void exitQbtTerm(QBTMParser.QbtTermContext ctx);
	/**
	 * Enter a parse tree produced by {@link QBTMParser#qbtVariable}.
	 * @param ctx the parse tree
	 */
	void enterQbtVariable(QBTMParser.QbtVariableContext ctx);
	/**
	 * Exit a parse tree produced by {@link QBTMParser#qbtVariable}.
	 * @param ctx the parse tree
	 */
	void exitQbtVariable(QBTMParser.QbtVariableContext ctx);
	/**
	 * Enter a parse tree produced by {@link QBTMParser#modelPathExpr}.
	 * @param ctx the parse tree
	 */
	void enterModelPathExpr(QBTMParser.ModelPathExprContext ctx);
	/**
	 * Exit a parse tree produced by {@link QBTMParser#modelPathExpr}.
	 * @param ctx the parse tree
	 */
	void exitModelPathExpr(QBTMParser.ModelPathExprContext ctx);
	/**
	 * Enter a parse tree produced by {@link QBTMParser#constructor}.
	 * @param ctx the parse tree
	 */
	void enterConstructor(QBTMParser.ConstructorContext ctx);
	/**
	 * Exit a parse tree produced by {@link QBTMParser#constructor}.
	 * @param ctx the parse tree
	 */
	void exitConstructor(QBTMParser.ConstructorContext ctx);
	/**
	 * Enter a parse tree produced by {@link QBTMParser#modelConstructor}.
	 * @param ctx the parse tree
	 */
	void enterModelConstructor(QBTMParser.ModelConstructorContext ctx);
	/**
	 * Exit a parse tree produced by {@link QBTMParser#modelConstructor}.
	 * @param ctx the parse tree
	 */
	void exitModelConstructor(QBTMParser.ModelConstructorContext ctx);
	/**
	 * Enter a parse tree produced by {@link QBTMParser#ajConstructor}.
	 * @param ctx the parse tree
	 */
	void enterAjConstructor(QBTMParser.AjConstructorContext ctx);
	/**
	 * Exit a parse tree produced by {@link QBTMParser#ajConstructor}.
	 * @param ctx the parse tree
	 */
	void exitAjConstructor(QBTMParser.AjConstructorContext ctx);
	/**
	 * Enter a parse tree produced by {@link QBTMParser#rkConstructor}.
	 * @param ctx the parse tree
	 */
	void enterRkConstructor(QBTMParser.RkConstructorContext ctx);
	/**
	 * Exit a parse tree produced by {@link QBTMParser#rkConstructor}.
	 * @param ctx the parse tree
	 */
	void exitRkConstructor(QBTMParser.RkConstructorContext ctx);
	/**
	 * Enter a parse tree produced by {@link QBTMParser#prConstructor}.
	 * @param ctx the parse tree
	 */
	void enterPrConstructor(QBTMParser.PrConstructorContext ctx);
	/**
	 * Exit a parse tree produced by {@link QBTMParser#prConstructor}.
	 * @param ctx the parse tree
	 */
	void exitPrConstructor(QBTMParser.PrConstructorContext ctx);
	/**
	 * Enter a parse tree produced by {@link QBTMParser#sjConstructor}.
	 * @param ctx the parse tree
	 */
	void enterSjConstructor(QBTMParser.SjConstructorContext ctx);
	/**
	 * Exit a parse tree produced by {@link QBTMParser#sjConstructor}.
	 * @param ctx the parse tree
	 */
	void exitSjConstructor(QBTMParser.SjConstructorContext ctx);
	/**
	 * Enter a parse tree produced by {@link QBTMParser#sppjConstructor}.
	 * @param ctx the parse tree
	 */
	void enterSppjConstructor(QBTMParser.SppjConstructorContext ctx);
	/**
	 * Exit a parse tree produced by {@link QBTMParser#sppjConstructor}.
	 * @param ctx the parse tree
	 */
	void exitSppjConstructor(QBTMParser.SppjConstructorContext ctx);
	/**
	 * Enter a parse tree produced by {@link QBTMParser#annotation}.
	 * @param ctx the parse tree
	 */
	void enterAnnotation(QBTMParser.AnnotationContext ctx);
	/**
	 * Exit a parse tree produced by {@link QBTMParser#annotation}.
	 * @param ctx the parse tree
	 */
	void exitAnnotation(QBTMParser.AnnotationContext ctx);
	/**
	 * Enter a parse tree produced by {@link QBTMParser#kqlquery}.
	 * @param ctx the parse tree
	 */
	void enterKqlquery(QBTMParser.KqlqueryContext ctx);
	/**
	 * Exit a parse tree produced by {@link QBTMParser#kqlquery}.
	 * @param ctx the parse tree
	 */
	void exitKqlquery(QBTMParser.KqlqueryContext ctx);
	/**
	 * Enter a parse tree produced by {@link QBTMParser#redisKQLQuery}.
	 * @param ctx the parse tree
	 */
	void enterRedisKQLQuery(QBTMParser.RedisKQLQueryContext ctx);
	/**
	 * Exit a parse tree produced by {@link QBTMParser#redisKQLQuery}.
	 * @param ctx the parse tree
	 */
	void exitRedisKQLQuery(QBTMParser.RedisKQLQueryContext ctx);
	/**
	 * Enter a parse tree produced by {@link QBTMParser#sfwQuery}.
	 * @param ctx the parse tree
	 */
	void enterSfwQuery(QBTMParser.SfwQueryContext ctx);
	/**
	 * Exit a parse tree produced by {@link QBTMParser#sfwQuery}.
	 * @param ctx the parse tree
	 */
	void exitSfwQuery(QBTMParser.SfwQueryContext ctx);
	/**
	 * Enter a parse tree produced by {@link QBTMParser#rkSelectClasue}.
	 * @param ctx the parse tree
	 */
	void enterRkSelectClasue(QBTMParser.RkSelectClasueContext ctx);
	/**
	 * Exit a parse tree produced by {@link QBTMParser#rkSelectClasue}.
	 * @param ctx the parse tree
	 */
	void exitRkSelectClasue(QBTMParser.RkSelectClasueContext ctx);
	/**
	 * Enter a parse tree produced by {@link QBTMParser#rkSelectStatement}.
	 * @param ctx the parse tree
	 */
	void enterRkSelectStatement(QBTMParser.RkSelectStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link QBTMParser#rkSelectStatement}.
	 * @param ctx the parse tree
	 */
	void exitRkSelectStatement(QBTMParser.RkSelectStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link QBTMParser#rkSelectItem}.
	 * @param ctx the parse tree
	 */
	void enterRkSelectItem(QBTMParser.RkSelectItemContext ctx);
	/**
	 * Exit a parse tree produced by {@link QBTMParser#rkSelectItem}.
	 * @param ctx the parse tree
	 */
	void exitRkSelectItem(QBTMParser.RkSelectItemContext ctx);
	/**
	 * Enter a parse tree produced by {@link QBTMParser#rkReturnVariable}.
	 * @param ctx the parse tree
	 */
	void enterRkReturnVariable(QBTMParser.RkReturnVariableContext ctx);
	/**
	 * Exit a parse tree produced by {@link QBTMParser#rkReturnVariable}.
	 * @param ctx the parse tree
	 */
	void exitRkReturnVariable(QBTMParser.RkReturnVariableContext ctx);
	/**
	 * Enter a parse tree produced by {@link QBTMParser#mapConstructor}.
	 * @param ctx the parse tree
	 */
	void enterMapConstructor(QBTMParser.MapConstructorContext ctx);
	/**
	 * Exit a parse tree produced by {@link QBTMParser#mapConstructor}.
	 * @param ctx the parse tree
	 */
	void exitMapConstructor(QBTMParser.MapConstructorContext ctx);
	/**
	 * Enter a parse tree produced by {@link QBTMParser#rkAttribute}.
	 * @param ctx the parse tree
	 */
	void enterRkAttribute(QBTMParser.RkAttributeContext ctx);
	/**
	 * Exit a parse tree produced by {@link QBTMParser#rkAttribute}.
	 * @param ctx the parse tree
	 */
	void exitRkAttribute(QBTMParser.RkAttributeContext ctx);
	/**
	 * Enter a parse tree produced by {@link QBTMParser#rkAttributeValue}.
	 * @param ctx the parse tree
	 */
	void enterRkAttributeValue(QBTMParser.RkAttributeValueContext ctx);
	/**
	 * Exit a parse tree produced by {@link QBTMParser#rkAttributeValue}.
	 * @param ctx the parse tree
	 */
	void exitRkAttributeValue(QBTMParser.RkAttributeValueContext ctx);
	/**
	 * Enter a parse tree produced by {@link QBTMParser#mapKey}.
	 * @param ctx the parse tree
	 */
	void enterMapKey(QBTMParser.MapKeyContext ctx);
	/**
	 * Exit a parse tree produced by {@link QBTMParser#mapKey}.
	 * @param ctx the parse tree
	 */
	void exitMapKey(QBTMParser.MapKeyContext ctx);
	/**
	 * Enter a parse tree produced by {@link QBTMParser#rkFromClasue}.
	 * @param ctx the parse tree
	 */
	void enterRkFromClasue(QBTMParser.RkFromClasueContext ctx);
	/**
	 * Exit a parse tree produced by {@link QBTMParser#rkFromClasue}.
	 * @param ctx the parse tree
	 */
	void exitRkFromClasue(QBTMParser.RkFromClasueContext ctx);
	/**
	 * Enter a parse tree produced by {@link QBTMParser#varBinding}.
	 * @param ctx the parse tree
	 */
	void enterVarBinding(QBTMParser.VarBindingContext ctx);
	/**
	 * Exit a parse tree produced by {@link QBTMParser#varBinding}.
	 * @param ctx the parse tree
	 */
	void exitVarBinding(QBTMParser.VarBindingContext ctx);
	/**
	 * Enter a parse tree produced by {@link QBTMParser#fromvariableBinding}.
	 * @param ctx the parse tree
	 */
	void enterFromvariableBinding(QBTMParser.FromvariableBindingContext ctx);
	/**
	 * Exit a parse tree produced by {@link QBTMParser#fromvariableBinding}.
	 * @param ctx the parse tree
	 */
	void exitFromvariableBinding(QBTMParser.FromvariableBindingContext ctx);
	/**
	 * Enter a parse tree produced by {@link QBTMParser#rkSource}.
	 * @param ctx the parse tree
	 */
	void enterRkSource(QBTMParser.RkSourceContext ctx);
	/**
	 * Exit a parse tree produced by {@link QBTMParser#rkSource}.
	 * @param ctx the parse tree
	 */
	void exitRkSource(QBTMParser.RkSourceContext ctx);
	/**
	 * Enter a parse tree produced by the {@code MainMapLookUp}
	 * labeled alternative in {@link QBTMParser#rkLookUpExpression}.
	 * @param ctx the parse tree
	 */
	void enterMainMapLookUp(QBTMParser.MainMapLookUpContext ctx);
	/**
	 * Exit a parse tree produced by the {@code MainMapLookUp}
	 * labeled alternative in {@link QBTMParser#rkLookUpExpression}.
	 * @param ctx the parse tree
	 */
	void exitMainMapLookUp(QBTMParser.MainMapLookUpContext ctx);
	/**
	 * Enter a parse tree produced by the {@code VariableMapLookUp}
	 * labeled alternative in {@link QBTMParser#rkLookUpExpression}.
	 * @param ctx the parse tree
	 */
	void enterVariableMapLookUp(QBTMParser.VariableMapLookUpContext ctx);
	/**
	 * Exit a parse tree produced by the {@code VariableMapLookUp}
	 * labeled alternative in {@link QBTMParser#rkLookUpExpression}.
	 * @param ctx the parse tree
	 */
	void exitVariableMapLookUp(QBTMParser.VariableMapLookUpContext ctx);
	/**
	 * Enter a parse tree produced by the {@code KeysMapLookUp}
	 * labeled alternative in {@link QBTMParser#rkLookUpExpression}.
	 * @param ctx the parse tree
	 */
	void enterKeysMapLookUp(QBTMParser.KeysMapLookUpContext ctx);
	/**
	 * Exit a parse tree produced by the {@code KeysMapLookUp}
	 * labeled alternative in {@link QBTMParser#rkLookUpExpression}.
	 * @param ctx the parse tree
	 */
	void exitKeysMapLookUp(QBTMParser.KeysMapLookUpContext ctx);
	/**
	 * Enter a parse tree produced by {@link QBTMParser#mainMap}.
	 * @param ctx the parse tree
	 */
	void enterMainMap(QBTMParser.MainMapContext ctx);
	/**
	 * Exit a parse tree produced by {@link QBTMParser#mainMap}.
	 * @param ctx the parse tree
	 */
	void exitMainMap(QBTMParser.MainMapContext ctx);
	/**
	 * Enter a parse tree produced by {@link QBTMParser#mapVariable}.
	 * @param ctx the parse tree
	 */
	void enterMapVariable(QBTMParser.MapVariableContext ctx);
	/**
	 * Exit a parse tree produced by {@link QBTMParser#mapVariable}.
	 * @param ctx the parse tree
	 */
	void exitMapVariable(QBTMParser.MapVariableContext ctx);
	/**
	 * Enter a parse tree produced by {@link QBTMParser#rkKey}.
	 * @param ctx the parse tree
	 */
	void enterRkKey(QBTMParser.RkKeyContext ctx);
	/**
	 * Exit a parse tree produced by {@link QBTMParser#rkKey}.
	 * @param ctx the parse tree
	 */
	void exitRkKey(QBTMParser.RkKeyContext ctx);
	/**
	 * Enter a parse tree produced by {@link QBTMParser#rkStringKey}.
	 * @param ctx the parse tree
	 */
	void enterRkStringKey(QBTMParser.RkStringKeyContext ctx);
	/**
	 * Exit a parse tree produced by {@link QBTMParser#rkStringKey}.
	 * @param ctx the parse tree
	 */
	void exitRkStringKey(QBTMParser.RkStringKeyContext ctx);
	/**
	 * Enter a parse tree produced by {@link QBTMParser#variableKey}.
	 * @param ctx the parse tree
	 */
	void enterVariableKey(QBTMParser.VariableKeyContext ctx);
	/**
	 * Exit a parse tree produced by {@link QBTMParser#variableKey}.
	 * @param ctx the parse tree
	 */
	void exitVariableKey(QBTMParser.VariableKeyContext ctx);
	/**
	 * Enter a parse tree produced by {@link QBTMParser#keyVariable}.
	 * @param ctx the parse tree
	 */
	void enterKeyVariable(QBTMParser.KeyVariableContext ctx);
	/**
	 * Exit a parse tree produced by {@link QBTMParser#keyVariable}.
	 * @param ctx the parse tree
	 */
	void exitKeyVariable(QBTMParser.KeyVariableContext ctx);
	/**
	 * Enter a parse tree produced by {@link QBTMParser#mapName}.
	 * @param ctx the parse tree
	 */
	void enterMapName(QBTMParser.MapNameContext ctx);
	/**
	 * Exit a parse tree produced by {@link QBTMParser#mapName}.
	 * @param ctx the parse tree
	 */
	void exitMapName(QBTMParser.MapNameContext ctx);
	/**
	 * Enter a parse tree produced by {@link QBTMParser#rkVariable}.
	 * @param ctx the parse tree
	 */
	void enterRkVariable(QBTMParser.RkVariableContext ctx);
	/**
	 * Exit a parse tree produced by {@link QBTMParser#rkVariable}.
	 * @param ctx the parse tree
	 */
	void exitRkVariable(QBTMParser.RkVariableContext ctx);
	/**
	 * Enter a parse tree produced by {@link QBTMParser#aqlquery}.
	 * @param ctx the parse tree
	 */
	void enterAqlquery(QBTMParser.AqlqueryContext ctx);
	/**
	 * Exit a parse tree produced by {@link QBTMParser#aqlquery}.
	 * @param ctx the parse tree
	 */
	void exitAqlquery(QBTMParser.AqlqueryContext ctx);
	/**
	 * Enter a parse tree produced by {@link QBTMParser#query}.
	 * @param ctx the parse tree
	 */
	void enterQuery(QBTMParser.QueryContext ctx);
	/**
	 * Exit a parse tree produced by {@link QBTMParser#query}.
	 * @param ctx the parse tree
	 */
	void exitQuery(QBTMParser.QueryContext ctx);
	/**
	 * Enter a parse tree produced by {@link QBTMParser#rootFieldName}.
	 * @param ctx the parse tree
	 */
	void enterRootFieldName(QBTMParser.RootFieldNameContext ctx);
	/**
	 * Exit a parse tree produced by {@link QBTMParser#rootFieldName}.
	 * @param ctx the parse tree
	 */
	void exitRootFieldName(QBTMParser.RootFieldNameContext ctx);
	/**
	 * Enter a parse tree produced by {@link QBTMParser#returnClause}.
	 * @param ctx the parse tree
	 */
	void enterReturnClause(QBTMParser.ReturnClauseContext ctx);
	/**
	 * Exit a parse tree produced by {@link QBTMParser#returnClause}.
	 * @param ctx the parse tree
	 */
	void exitReturnClause(QBTMParser.ReturnClauseContext ctx);
	/**
	 * Enter a parse tree produced by {@link QBTMParser#recordConstruct}.
	 * @param ctx the parse tree
	 */
	void enterRecordConstruct(QBTMParser.RecordConstructContext ctx);
	/**
	 * Exit a parse tree produced by {@link QBTMParser#recordConstruct}.
	 * @param ctx the parse tree
	 */
	void exitRecordConstruct(QBTMParser.RecordConstructContext ctx);
	/**
	 * Enter a parse tree produced by {@link QBTMParser#fieldBinding}.
	 * @param ctx the parse tree
	 */
	void enterFieldBinding(QBTMParser.FieldBindingContext ctx);
	/**
	 * Exit a parse tree produced by {@link QBTMParser#fieldBinding}.
	 * @param ctx the parse tree
	 */
	void exitFieldBinding(QBTMParser.FieldBindingContext ctx);
	/**
	 * Enter a parse tree produced by {@link QBTMParser#recordConstructFieldName}.
	 * @param ctx the parse tree
	 */
	void enterRecordConstructFieldName(QBTMParser.RecordConstructFieldNameContext ctx);
	/**
	 * Exit a parse tree produced by {@link QBTMParser#recordConstructFieldName}.
	 * @param ctx the parse tree
	 */
	void exitRecordConstructFieldName(QBTMParser.RecordConstructFieldNameContext ctx);
	/**
	 * Enter a parse tree produced by {@link QBTMParser#fieldName}.
	 * @param ctx the parse tree
	 */
	void enterFieldName(QBTMParser.FieldNameContext ctx);
	/**
	 * Exit a parse tree produced by {@link QBTMParser#fieldName}.
	 * @param ctx the parse tree
	 */
	void exitFieldName(QBTMParser.FieldNameContext ctx);
	/**
	 * Enter a parse tree produced by {@link QBTMParser#fieldValue}.
	 * @param ctx the parse tree
	 */
	void enterFieldValue(QBTMParser.FieldValueContext ctx);
	/**
	 * Exit a parse tree produced by {@link QBTMParser#fieldValue}.
	 * @param ctx the parse tree
	 */
	void exitFieldValue(QBTMParser.FieldValueContext ctx);
	/**
	 * Enter a parse tree produced by {@link QBTMParser#returnVar}.
	 * @param ctx the parse tree
	 */
	void enterReturnVar(QBTMParser.ReturnVarContext ctx);
	/**
	 * Exit a parse tree produced by {@link QBTMParser#returnVar}.
	 * @param ctx the parse tree
	 */
	void exitReturnVar(QBTMParser.ReturnVarContext ctx);
	/**
	 * Enter a parse tree produced by {@link QBTMParser#name}.
	 * @param ctx the parse tree
	 */
	void enterName(QBTMParser.NameContext ctx);
	/**
	 * Exit a parse tree produced by {@link QBTMParser#name}.
	 * @param ctx the parse tree
	 */
	void exitName(QBTMParser.NameContext ctx);
	/**
	 * Enter a parse tree produced by {@link QBTMParser#returnConstant}.
	 * @param ctx the parse tree
	 */
	void enterReturnConstant(QBTMParser.ReturnConstantContext ctx);
	/**
	 * Exit a parse tree produced by {@link QBTMParser#returnConstant}.
	 * @param ctx the parse tree
	 */
	void exitReturnConstant(QBTMParser.ReturnConstantContext ctx);
	/**
	 * Enter a parse tree produced by {@link QBTMParser#returnQuery}.
	 * @param ctx the parse tree
	 */
	void enterReturnQuery(QBTMParser.ReturnQueryContext ctx);
	/**
	 * Exit a parse tree produced by {@link QBTMParser#returnQuery}.
	 * @param ctx the parse tree
	 */
	void exitReturnQuery(QBTMParser.ReturnQueryContext ctx);
	/**
	 * Enter a parse tree produced by {@link QBTMParser#term}.
	 * @param ctx the parse tree
	 */
	void enterTerm(QBTMParser.TermContext ctx);
	/**
	 * Exit a parse tree produced by {@link QBTMParser#term}.
	 * @param ctx the parse tree
	 */
	void exitTerm(QBTMParser.TermContext ctx);
	/**
	 * Enter a parse tree produced by {@link QBTMParser#termVar}.
	 * @param ctx the parse tree
	 */
	void enterTermVar(QBTMParser.TermVarContext ctx);
	/**
	 * Exit a parse tree produced by {@link QBTMParser#termVar}.
	 * @param ctx the parse tree
	 */
	void exitTermVar(QBTMParser.TermVarContext ctx);
	/**
	 * Enter a parse tree produced by {@link QBTMParser#termConstant}.
	 * @param ctx the parse tree
	 */
	void enterTermConstant(QBTMParser.TermConstantContext ctx);
	/**
	 * Exit a parse tree produced by {@link QBTMParser#termConstant}.
	 * @param ctx the parse tree
	 */
	void exitTermConstant(QBTMParser.TermConstantContext ctx);
	/**
	 * Enter a parse tree produced by {@link QBTMParser#termPath}.
	 * @param ctx the parse tree
	 */
	void enterTermPath(QBTMParser.TermPathContext ctx);
	/**
	 * Exit a parse tree produced by {@link QBTMParser#termPath}.
	 * @param ctx the parse tree
	 */
	void exitTermPath(QBTMParser.TermPathContext ctx);
	/**
	 * Enter a parse tree produced by {@link QBTMParser#constant}.
	 * @param ctx the parse tree
	 */
	void enterConstant(QBTMParser.ConstantContext ctx);
	/**
	 * Exit a parse tree produced by {@link QBTMParser#constant}.
	 * @param ctx the parse tree
	 */
	void exitConstant(QBTMParser.ConstantContext ctx);
	/**
	 * Enter a parse tree produced by {@link QBTMParser#number}.
	 * @param ctx the parse tree
	 */
	void enterNumber(QBTMParser.NumberContext ctx);
	/**
	 * Exit a parse tree produced by {@link QBTMParser#number}.
	 * @param ctx the parse tree
	 */
	void exitNumber(QBTMParser.NumberContext ctx);
	/**
	 * Enter a parse tree produced by {@link QBTMParser#path}.
	 * @param ctx the parse tree
	 */
	void enterPath(QBTMParser.PathContext ctx);
	/**
	 * Exit a parse tree produced by {@link QBTMParser#path}.
	 * @param ctx the parse tree
	 */
	void exitPath(QBTMParser.PathContext ctx);
	/**
	 * Enter a parse tree produced by {@link QBTMParser#pathVar}.
	 * @param ctx the parse tree
	 */
	void enterPathVar(QBTMParser.PathVarContext ctx);
	/**
	 * Exit a parse tree produced by {@link QBTMParser#pathVar}.
	 * @param ctx the parse tree
	 */
	void exitPathVar(QBTMParser.PathVarContext ctx);
	/**
	 * Enter a parse tree produced by {@link QBTMParser#var}.
	 * @param ctx the parse tree
	 */
	void enterVar(QBTMParser.VarContext ctx);
	/**
	 * Exit a parse tree produced by {@link QBTMParser#var}.
	 * @param ctx the parse tree
	 */
	void exitVar(QBTMParser.VarContext ctx);
	/**
	 * Enter a parse tree produced by {@link QBTMParser#step}.
	 * @param ctx the parse tree
	 */
	void enterStep(QBTMParser.StepContext ctx);
	/**
	 * Exit a parse tree produced by {@link QBTMParser#step}.
	 * @param ctx the parse tree
	 */
	void exitStep(QBTMParser.StepContext ctx);
	/**
	 * Enter a parse tree produced by {@link QBTMParser#objectStep}.
	 * @param ctx the parse tree
	 */
	void enterObjectStep(QBTMParser.ObjectStepContext ctx);
	/**
	 * Exit a parse tree produced by {@link QBTMParser#objectStep}.
	 * @param ctx the parse tree
	 */
	void exitObjectStep(QBTMParser.ObjectStepContext ctx);
	/**
	 * Enter a parse tree produced by {@link QBTMParser#arrayStep}.
	 * @param ctx the parse tree
	 */
	void enterArrayStep(QBTMParser.ArrayStepContext ctx);
	/**
	 * Exit a parse tree produced by {@link QBTMParser#arrayStep}.
	 * @param ctx the parse tree
	 */
	void exitArrayStep(QBTMParser.ArrayStepContext ctx);
	/**
	 * Enter a parse tree produced by {@link QBTMParser#key}.
	 * @param ctx the parse tree
	 */
	void enterKey(QBTMParser.KeyContext ctx);
	/**
	 * Exit a parse tree produced by {@link QBTMParser#key}.
	 * @param ctx the parse tree
	 */
	void exitKey(QBTMParser.KeyContext ctx);
	/**
	 * Enter a parse tree produced by {@link QBTMParser#index}.
	 * @param ctx the parse tree
	 */
	void enterIndex(QBTMParser.IndexContext ctx);
	/**
	 * Exit a parse tree produced by {@link QBTMParser#index}.
	 * @param ctx the parse tree
	 */
	void exitIndex(QBTMParser.IndexContext ctx);
	/**
	 * Enter a parse tree produced by {@link QBTMParser#forClause}.
	 * @param ctx the parse tree
	 */
	void enterForClause(QBTMParser.ForClauseContext ctx);
	/**
	 * Exit a parse tree produced by {@link QBTMParser#forClause}.
	 * @param ctx the parse tree
	 */
	void exitForClause(QBTMParser.ForClauseContext ctx);
	/**
	 * Enter a parse tree produced by {@link QBTMParser#binding}.
	 * @param ctx the parse tree
	 */
	void enterBinding(QBTMParser.BindingContext ctx);
	/**
	 * Exit a parse tree produced by {@link QBTMParser#binding}.
	 * @param ctx the parse tree
	 */
	void exitBinding(QBTMParser.BindingContext ctx);
	/**
	 * Enter a parse tree produced by {@link QBTMParser#forClauseBindingVar}.
	 * @param ctx the parse tree
	 */
	void enterForClauseBindingVar(QBTMParser.ForClauseBindingVarContext ctx);
	/**
	 * Exit a parse tree produced by {@link QBTMParser#forClauseBindingVar}.
	 * @param ctx the parse tree
	 */
	void exitForClauseBindingVar(QBTMParser.ForClauseBindingVarContext ctx);
	/**
	 * Enter a parse tree produced by {@link QBTMParser#forClauseBindingSource}.
	 * @param ctx the parse tree
	 */
	void enterForClauseBindingSource(QBTMParser.ForClauseBindingSourceContext ctx);
	/**
	 * Exit a parse tree produced by {@link QBTMParser#forClauseBindingSource}.
	 * @param ctx the parse tree
	 */
	void exitForClauseBindingSource(QBTMParser.ForClauseBindingSourceContext ctx);
	/**
	 * Enter a parse tree produced by {@link QBTMParser#source}.
	 * @param ctx the parse tree
	 */
	void enterSource(QBTMParser.SourceContext ctx);
	/**
	 * Exit a parse tree produced by {@link QBTMParser#source}.
	 * @param ctx the parse tree
	 */
	void exitSource(QBTMParser.SourceContext ctx);
	/**
	 * Enter a parse tree produced by {@link QBTMParser#dataSetName}.
	 * @param ctx the parse tree
	 */
	void enterDataSetName(QBTMParser.DataSetNameContext ctx);
	/**
	 * Exit a parse tree produced by {@link QBTMParser#dataSetName}.
	 * @param ctx the parse tree
	 */
	void exitDataSetName(QBTMParser.DataSetNameContext ctx);
	/**
	 * Enter a parse tree produced by {@link QBTMParser#whereClause}.
	 * @param ctx the parse tree
	 */
	void enterWhereClause(QBTMParser.WhereClauseContext ctx);
	/**
	 * Exit a parse tree produced by {@link QBTMParser#whereClause}.
	 * @param ctx the parse tree
	 */
	void exitWhereClause(QBTMParser.WhereClauseContext ctx);
	/**
	 * Enter a parse tree produced by {@link QBTMParser#condition}.
	 * @param ctx the parse tree
	 */
	void enterCondition(QBTMParser.ConditionContext ctx);
	/**
	 * Exit a parse tree produced by {@link QBTMParser#condition}.
	 * @param ctx the parse tree
	 */
	void exitCondition(QBTMParser.ConditionContext ctx);
	/**
	 * Enter a parse tree produced by {@link QBTMParser#whereCondSome}.
	 * @param ctx the parse tree
	 */
	void enterWhereCondSome(QBTMParser.WhereCondSomeContext ctx);
	/**
	 * Exit a parse tree produced by {@link QBTMParser#whereCondSome}.
	 * @param ctx the parse tree
	 */
	void exitWhereCondSome(QBTMParser.WhereCondSomeContext ctx);
	/**
	 * Enter a parse tree produced by {@link QBTMParser#whereCondBinding}.
	 * @param ctx the parse tree
	 */
	void enterWhereCondBinding(QBTMParser.WhereCondBindingContext ctx);
	/**
	 * Exit a parse tree produced by {@link QBTMParser#whereCondBinding}.
	 * @param ctx the parse tree
	 */
	void exitWhereCondBinding(QBTMParser.WhereCondBindingContext ctx);
	/**
	 * Enter a parse tree produced by {@link QBTMParser#whereCondBindingVar}.
	 * @param ctx the parse tree
	 */
	void enterWhereCondBindingVar(QBTMParser.WhereCondBindingVarContext ctx);
	/**
	 * Exit a parse tree produced by {@link QBTMParser#whereCondBindingVar}.
	 * @param ctx the parse tree
	 */
	void exitWhereCondBindingVar(QBTMParser.WhereCondBindingVarContext ctx);
	/**
	 * Enter a parse tree produced by {@link QBTMParser#whereCondBindingSource}.
	 * @param ctx the parse tree
	 */
	void enterWhereCondBindingSource(QBTMParser.WhereCondBindingSourceContext ctx);
	/**
	 * Exit a parse tree produced by {@link QBTMParser#whereCondBindingSource}.
	 * @param ctx the parse tree
	 */
	void exitWhereCondBindingSource(QBTMParser.WhereCondBindingSourceContext ctx);
	/**
	 * Enter a parse tree produced by {@link QBTMParser#whereCondEquality}.
	 * @param ctx the parse tree
	 */
	void enterWhereCondEquality(QBTMParser.WhereCondEqualityContext ctx);
	/**
	 * Exit a parse tree produced by {@link QBTMParser#whereCondEquality}.
	 * @param ctx the parse tree
	 */
	void exitWhereCondEquality(QBTMParser.WhereCondEqualityContext ctx);
	/**
	 * Enter a parse tree produced by {@link QBTMParser#whereCondEqualityLeftTerm}.
	 * @param ctx the parse tree
	 */
	void enterWhereCondEqualityLeftTerm(QBTMParser.WhereCondEqualityLeftTermContext ctx);
	/**
	 * Exit a parse tree produced by {@link QBTMParser#whereCondEqualityLeftTerm}.
	 * @param ctx the parse tree
	 */
	void exitWhereCondEqualityLeftTerm(QBTMParser.WhereCondEqualityLeftTermContext ctx);
	/**
	 * Enter a parse tree produced by {@link QBTMParser#whereCondEqualityRightTerm}.
	 * @param ctx the parse tree
	 */
	void enterWhereCondEqualityRightTerm(QBTMParser.WhereCondEqualityRightTermContext ctx);
	/**
	 * Exit a parse tree produced by {@link QBTMParser#whereCondEqualityRightTerm}.
	 * @param ctx the parse tree
	 */
	void exitWhereCondEqualityRightTerm(QBTMParser.WhereCondEqualityRightTermContext ctx);
	/**
	 * Enter a parse tree produced by {@link QBTMParser#cterm}.
	 * @param ctx the parse tree
	 */
	void enterCterm(QBTMParser.CtermContext ctx);
	/**
	 * Exit a parse tree produced by {@link QBTMParser#cterm}.
	 * @param ctx the parse tree
	 */
	void exitCterm(QBTMParser.CtermContext ctx);
	/**
	 * Enter a parse tree produced by {@link QBTMParser#forWhereClauses}.
	 * @param ctx the parse tree
	 */
	void enterForWhereClauses(QBTMParser.ForWhereClausesContext ctx);
	/**
	 * Exit a parse tree produced by {@link QBTMParser#forWhereClauses}.
	 * @param ctx the parse tree
	 */
	void exitForWhereClauses(QBTMParser.ForWhereClausesContext ctx);
	/**
	 * Enter a parse tree produced by {@link QBTMParser#rqQuery}.
	 * @param ctx the parse tree
	 */
	void enterRqQuery(QBTMParser.RqQueryContext ctx);
	/**
	 * Exit a parse tree produced by {@link QBTMParser#rqQuery}.
	 * @param ctx the parse tree
	 */
	void exitRqQuery(QBTMParser.RqQueryContext ctx);
	/**
	 * Enter a parse tree produced by {@link QBTMParser#prQuery}.
	 * @param ctx the parse tree
	 */
	void enterPrQuery(QBTMParser.PrQueryContext ctx);
	/**
	 * Exit a parse tree produced by {@link QBTMParser#prQuery}.
	 * @param ctx the parse tree
	 */
	void exitPrQuery(QBTMParser.PrQueryContext ctx);
	/**
	 * Enter a parse tree produced by {@link QBTMParser#prSfwQuery}.
	 * @param ctx the parse tree
	 */
	void enterPrSfwQuery(QBTMParser.PrSfwQueryContext ctx);
	/**
	 * Exit a parse tree produced by {@link QBTMParser#prSfwQuery}.
	 * @param ctx the parse tree
	 */
	void exitPrSfwQuery(QBTMParser.PrSfwQueryContext ctx);
	/**
	 * Enter a parse tree produced by {@link QBTMParser#prFromWhereClauses}.
	 * @param ctx the parse tree
	 */
	void enterPrFromWhereClauses(QBTMParser.PrFromWhereClausesContext ctx);
	/**
	 * Exit a parse tree produced by {@link QBTMParser#prFromWhereClauses}.
	 * @param ctx the parse tree
	 */
	void exitPrFromWhereClauses(QBTMParser.PrFromWhereClausesContext ctx);
	/**
	 * Enter a parse tree produced by {@link QBTMParser#prSelectClause}.
	 * @param ctx the parse tree
	 */
	void enterPrSelectClause(QBTMParser.PrSelectClauseContext ctx);
	/**
	 * Exit a parse tree produced by {@link QBTMParser#prSelectClause}.
	 * @param ctx the parse tree
	 */
	void exitPrSelectClause(QBTMParser.PrSelectClauseContext ctx);
	/**
	 * Enter a parse tree produced by {@link QBTMParser#prSelectStatement}.
	 * @param ctx the parse tree
	 */
	void enterPrSelectStatement(QBTMParser.PrSelectStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link QBTMParser#prSelectStatement}.
	 * @param ctx the parse tree
	 */
	void exitPrSelectStatement(QBTMParser.PrSelectStatementContext ctx);
	/**
	 * Enter a parse tree produced by the {@code prSelectPathLabel}
	 * labeled alternative in {@link QBTMParser#prSelectItem}.
	 * @param ctx the parse tree
	 */
	void enterPrSelectPathLabel(QBTMParser.PrSelectPathLabelContext ctx);
	/**
	 * Exit a parse tree produced by the {@code prSelectPathLabel}
	 * labeled alternative in {@link QBTMParser#prSelectItem}.
	 * @param ctx the parse tree
	 */
	void exitPrSelectPathLabel(QBTMParser.PrSelectPathLabelContext ctx);
	/**
	 * Enter a parse tree produced by the {@code prName}
	 * labeled alternative in {@link QBTMParser#prSelectItem}.
	 * @param ctx the parse tree
	 */
	void enterPrName(QBTMParser.PrNameContext ctx);
	/**
	 * Exit a parse tree produced by the {@code prName}
	 * labeled alternative in {@link QBTMParser#prSelectItem}.
	 * @param ctx the parse tree
	 */
	void exitPrName(QBTMParser.PrNameContext ctx);
	/**
	 * Enter a parse tree produced by {@link QBTMParser#prSelectVar}.
	 * @param ctx the parse tree
	 */
	void enterPrSelectVar(QBTMParser.PrSelectVarContext ctx);
	/**
	 * Exit a parse tree produced by {@link QBTMParser#prSelectVar}.
	 * @param ctx the parse tree
	 */
	void exitPrSelectVar(QBTMParser.PrSelectVarContext ctx);
	/**
	 * Enter a parse tree produced by {@link QBTMParser#prFromClause}.
	 * @param ctx the parse tree
	 */
	void enterPrFromClause(QBTMParser.PrFromClauseContext ctx);
	/**
	 * Exit a parse tree produced by {@link QBTMParser#prFromClause}.
	 * @param ctx the parse tree
	 */
	void exitPrFromClause(QBTMParser.PrFromClauseContext ctx);
	/**
	 * Enter a parse tree produced by {@link QBTMParser#prRelationBinding}.
	 * @param ctx the parse tree
	 */
	void enterPrRelationBinding(QBTMParser.PrRelationBindingContext ctx);
	/**
	 * Exit a parse tree produced by {@link QBTMParser#prRelationBinding}.
	 * @param ctx the parse tree
	 */
	void exitPrRelationBinding(QBTMParser.PrRelationBindingContext ctx);
	/**
	 * Enter a parse tree produced by {@link QBTMParser#prSource}.
	 * @param ctx the parse tree
	 */
	void enterPrSource(QBTMParser.PrSourceContext ctx);
	/**
	 * Exit a parse tree produced by {@link QBTMParser#prSource}.
	 * @param ctx the parse tree
	 */
	void exitPrSource(QBTMParser.PrSourceContext ctx);
	/**
	 * Enter a parse tree produced by {@link QBTMParser#prRelationName}.
	 * @param ctx the parse tree
	 */
	void enterPrRelationName(QBTMParser.PrRelationNameContext ctx);
	/**
	 * Exit a parse tree produced by {@link QBTMParser#prRelationName}.
	 * @param ctx the parse tree
	 */
	void exitPrRelationName(QBTMParser.PrRelationNameContext ctx);
	/**
	 * Enter a parse tree produced by {@link QBTMParser#prVariable}.
	 * @param ctx the parse tree
	 */
	void enterPrVariable(QBTMParser.PrVariableContext ctx);
	/**
	 * Exit a parse tree produced by {@link QBTMParser#prVariable}.
	 * @param ctx the parse tree
	 */
	void exitPrVariable(QBTMParser.PrVariableContext ctx);
	/**
	 * Enter a parse tree produced by {@link QBTMParser#prWhereClause}.
	 * @param ctx the parse tree
	 */
	void enterPrWhereClause(QBTMParser.PrWhereClauseContext ctx);
	/**
	 * Exit a parse tree produced by {@link QBTMParser#prWhereClause}.
	 * @param ctx the parse tree
	 */
	void exitPrWhereClause(QBTMParser.PrWhereClauseContext ctx);
	/**
	 * Enter a parse tree produced by {@link QBTMParser#prWhereStatement}.
	 * @param ctx the parse tree
	 */
	void enterPrWhereStatement(QBTMParser.PrWhereStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link QBTMParser#prWhereStatement}.
	 * @param ctx the parse tree
	 */
	void exitPrWhereStatement(QBTMParser.PrWhereStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link QBTMParser#prCondition}.
	 * @param ctx the parse tree
	 */
	void enterPrCondition(QBTMParser.PrConditionContext ctx);
	/**
	 * Exit a parse tree produced by {@link QBTMParser#prCondition}.
	 * @param ctx the parse tree
	 */
	void exitPrCondition(QBTMParser.PrConditionContext ctx);
	/**
	 * Enter a parse tree produced by {@link QBTMParser#prTerm}.
	 * @param ctx the parse tree
	 */
	void enterPrTerm(QBTMParser.PrTermContext ctx);
	/**
	 * Exit a parse tree produced by {@link QBTMParser#prTerm}.
	 * @param ctx the parse tree
	 */
	void exitPrTerm(QBTMParser.PrTermContext ctx);
	/**
	 * Enter a parse tree produced by {@link QBTMParser#prEquality}.
	 * @param ctx the parse tree
	 */
	void enterPrEquality(QBTMParser.PrEqualityContext ctx);
	/**
	 * Exit a parse tree produced by {@link QBTMParser#prEquality}.
	 * @param ctx the parse tree
	 */
	void exitPrEquality(QBTMParser.PrEqualityContext ctx);
	/**
	 * Enter a parse tree produced by {@link QBTMParser#prLikeExpression}.
	 * @param ctx the parse tree
	 */
	void enterPrLikeExpression(QBTMParser.PrLikeExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link QBTMParser#prLikeExpression}.
	 * @param ctx the parse tree
	 */
	void exitPrLikeExpression(QBTMParser.PrLikeExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link QBTMParser#prLeftterm}.
	 * @param ctx the parse tree
	 */
	void enterPrLeftterm(QBTMParser.PrLefttermContext ctx);
	/**
	 * Exit a parse tree produced by {@link QBTMParser#prLeftterm}.
	 * @param ctx the parse tree
	 */
	void exitPrLeftterm(QBTMParser.PrLefttermContext ctx);
	/**
	 * Enter a parse tree produced by {@link QBTMParser#prRightterm}.
	 * @param ctx the parse tree
	 */
	void enterPrRightterm(QBTMParser.PrRighttermContext ctx);
	/**
	 * Exit a parse tree produced by {@link QBTMParser#prRightterm}.
	 * @param ctx the parse tree
	 */
	void exitPrRightterm(QBTMParser.PrRighttermContext ctx);
	/**
	 * Enter a parse tree produced by {@link QBTMParser#realtion}.
	 * @param ctx the parse tree
	 */
	void enterRealtion(QBTMParser.RealtionContext ctx);
	/**
	 * Exit a parse tree produced by {@link QBTMParser#realtion}.
	 * @param ctx the parse tree
	 */
	void exitRealtion(QBTMParser.RealtionContext ctx);
	/**
	 * Enter a parse tree produced by {@link QBTMParser#sjqlquery}.
	 * @param ctx the parse tree
	 */
	void enterSjqlquery(QBTMParser.SjqlqueryContext ctx);
	/**
	 * Exit a parse tree produced by {@link QBTMParser#sjqlquery}.
	 * @param ctx the parse tree
	 */
	void exitSjqlquery(QBTMParser.SjqlqueryContext ctx);
	/**
	 * Enter a parse tree produced by {@link QBTMParser#sjQuery}.
	 * @param ctx the parse tree
	 */
	void enterSjQuery(QBTMParser.SjQueryContext ctx);
	/**
	 * Exit a parse tree produced by {@link QBTMParser#sjQuery}.
	 * @param ctx the parse tree
	 */
	void exitSjQuery(QBTMParser.SjQueryContext ctx);
	/**
	 * Enter a parse tree produced by {@link QBTMParser#sjCollectionName}.
	 * @param ctx the parse tree
	 */
	void enterSjCollectionName(QBTMParser.SjCollectionNameContext ctx);
	/**
	 * Exit a parse tree produced by {@link QBTMParser#sjCollectionName}.
	 * @param ctx the parse tree
	 */
	void exitSjCollectionName(QBTMParser.SjCollectionNameContext ctx);
	/**
	 * Enter a parse tree produced by {@link QBTMParser#sjTextSearch}.
	 * @param ctx the parse tree
	 */
	void enterSjTextSearch(QBTMParser.SjTextSearchContext ctx);
	/**
	 * Exit a parse tree produced by {@link QBTMParser#sjTextSearch}.
	 * @param ctx the parse tree
	 */
	void exitSjTextSearch(QBTMParser.SjTextSearchContext ctx);
	/**
	 * Enter a parse tree produced by {@link QBTMParser#sjLeftTerm}.
	 * @param ctx the parse tree
	 */
	void enterSjLeftTerm(QBTMParser.SjLeftTermContext ctx);
	/**
	 * Exit a parse tree produced by {@link QBTMParser#sjLeftTerm}.
	 * @param ctx the parse tree
	 */
	void exitSjLeftTerm(QBTMParser.SjLeftTermContext ctx);
	/**
	 * Enter a parse tree produced by {@link QBTMParser#sjRightTerm}.
	 * @param ctx the parse tree
	 */
	void enterSjRightTerm(QBTMParser.SjRightTermContext ctx);
	/**
	 * Exit a parse tree produced by {@link QBTMParser#sjRightTerm}.
	 * @param ctx the parse tree
	 */
	void exitSjRightTerm(QBTMParser.SjRightTermContext ctx);
	/**
	 * Enter a parse tree produced by {@link QBTMParser#sjTerm}.
	 * @param ctx the parse tree
	 */
	void enterSjTerm(QBTMParser.SjTermContext ctx);
	/**
	 * Exit a parse tree produced by {@link QBTMParser#sjTerm}.
	 * @param ctx the parse tree
	 */
	void exitSjTerm(QBTMParser.SjTermContext ctx);
	/**
	 * Enter a parse tree produced by {@link QBTMParser#sjProjectFields}.
	 * @param ctx the parse tree
	 */
	void enterSjProjectFields(QBTMParser.SjProjectFieldsContext ctx);
	/**
	 * Exit a parse tree produced by {@link QBTMParser#sjProjectFields}.
	 * @param ctx the parse tree
	 */
	void exitSjProjectFields(QBTMParser.SjProjectFieldsContext ctx);
	/**
	 * Enter a parse tree produced by {@link QBTMParser#sjRecordConstruct}.
	 * @param ctx the parse tree
	 */
	void enterSjRecordConstruct(QBTMParser.SjRecordConstructContext ctx);
	/**
	 * Exit a parse tree produced by {@link QBTMParser#sjRecordConstruct}.
	 * @param ctx the parse tree
	 */
	void exitSjRecordConstruct(QBTMParser.SjRecordConstructContext ctx);
	/**
	 * Enter a parse tree produced by {@link QBTMParser#sjAttribute}.
	 * @param ctx the parse tree
	 */
	void enterSjAttribute(QBTMParser.SjAttributeContext ctx);
	/**
	 * Exit a parse tree produced by {@link QBTMParser#sjAttribute}.
	 * @param ctx the parse tree
	 */
	void exitSjAttribute(QBTMParser.SjAttributeContext ctx);
	/**
	 * Enter a parse tree produced by {@link QBTMParser#sjFieldName}.
	 * @param ctx the parse tree
	 */
	void enterSjFieldName(QBTMParser.SjFieldNameContext ctx);
	/**
	 * Exit a parse tree produced by {@link QBTMParser#sjFieldName}.
	 * @param ctx the parse tree
	 */
	void exitSjFieldName(QBTMParser.SjFieldNameContext ctx);
	/**
	 * Enter a parse tree produced by {@link QBTMParser#sjKeyName}.
	 * @param ctx the parse tree
	 */
	void enterSjKeyName(QBTMParser.SjKeyNameContext ctx);
	/**
	 * Exit a parse tree produced by {@link QBTMParser#sjKeyName}.
	 * @param ctx the parse tree
	 */
	void exitSjKeyName(QBTMParser.SjKeyNameContext ctx);
	/**
	 * Enter a parse tree produced by {@link QBTMParser#sjConstant}.
	 * @param ctx the parse tree
	 */
	void enterSjConstant(QBTMParser.SjConstantContext ctx);
	/**
	 * Exit a parse tree produced by {@link QBTMParser#sjConstant}.
	 * @param ctx the parse tree
	 */
	void exitSjConstant(QBTMParser.SjConstantContext ctx);
	/**
	 * Enter a parse tree produced by {@link QBTMParser#pjqlQuery}.
	 * @param ctx the parse tree
	 */
	void enterPjqlQuery(QBTMParser.PjqlQueryContext ctx);
	/**
	 * Exit a parse tree produced by {@link QBTMParser#pjqlQuery}.
	 * @param ctx the parse tree
	 */
	void exitPjqlQuery(QBTMParser.PjqlQueryContext ctx);
	/**
	 * Enter a parse tree produced by {@link QBTMParser#pjQuery}.
	 * @param ctx the parse tree
	 */
	void enterPjQuery(QBTMParser.PjQueryContext ctx);
	/**
	 * Exit a parse tree produced by {@link QBTMParser#pjQuery}.
	 * @param ctx the parse tree
	 */
	void exitPjQuery(QBTMParser.PjQueryContext ctx);
	/**
	 * Enter a parse tree produced by {@link QBTMParser#pjSelectClause}.
	 * @param ctx the parse tree
	 */
	void enterPjSelectClause(QBTMParser.PjSelectClauseContext ctx);
	/**
	 * Exit a parse tree produced by {@link QBTMParser#pjSelectClause}.
	 * @param ctx the parse tree
	 */
	void exitPjSelectClause(QBTMParser.PjSelectClauseContext ctx);
	/**
	 * Enter a parse tree produced by {@link QBTMParser#pjSelectStatement}.
	 * @param ctx the parse tree
	 */
	void enterPjSelectStatement(QBTMParser.PjSelectStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link QBTMParser#pjSelectStatement}.
	 * @param ctx the parse tree
	 */
	void exitPjSelectStatement(QBTMParser.PjSelectStatementContext ctx);
	/**
	 * Enter a parse tree produced by the {@code pjRecordConstructLabel}
	 * labeled alternative in {@link QBTMParser#pjSelectItem}.
	 * @param ctx the parse tree
	 */
	void enterPjRecordConstructLabel(QBTMParser.PjRecordConstructLabelContext ctx);
	/**
	 * Exit a parse tree produced by the {@code pjRecordConstructLabel}
	 * labeled alternative in {@link QBTMParser#pjSelectItem}.
	 * @param ctx the parse tree
	 */
	void exitPjRecordConstructLabel(QBTMParser.PjRecordConstructLabelContext ctx);
	/**
	 * Enter a parse tree produced by the {@code pjSelectVarLabel}
	 * labeled alternative in {@link QBTMParser#pjSelectItem}.
	 * @param ctx the parse tree
	 */
	void enterPjSelectVarLabel(QBTMParser.PjSelectVarLabelContext ctx);
	/**
	 * Exit a parse tree produced by the {@code pjSelectVarLabel}
	 * labeled alternative in {@link QBTMParser#pjSelectItem}.
	 * @param ctx the parse tree
	 */
	void exitPjSelectVarLabel(QBTMParser.PjSelectVarLabelContext ctx);
	/**
	 * Enter a parse tree produced by the {@code pjSelectConstantLabel}
	 * labeled alternative in {@link QBTMParser#pjSelectItem}.
	 * @param ctx the parse tree
	 */
	void enterPjSelectConstantLabel(QBTMParser.PjSelectConstantLabelContext ctx);
	/**
	 * Exit a parse tree produced by the {@code pjSelectConstantLabel}
	 * labeled alternative in {@link QBTMParser#pjSelectItem}.
	 * @param ctx the parse tree
	 */
	void exitPjSelectConstantLabel(QBTMParser.PjSelectConstantLabelContext ctx);
	/**
	 * Enter a parse tree produced by the {@code pjPathScalarLabel}
	 * labeled alternative in {@link QBTMParser#pjSelectItem}.
	 * @param ctx the parse tree
	 */
	void enterPjPathScalarLabel(QBTMParser.PjPathScalarLabelContext ctx);
	/**
	 * Exit a parse tree produced by the {@code pjPathScalarLabel}
	 * labeled alternative in {@link QBTMParser#pjSelectItem}.
	 * @param ctx the parse tree
	 */
	void exitPjPathScalarLabel(QBTMParser.PjPathScalarLabelContext ctx);
	/**
	 * Enter a parse tree produced by {@link QBTMParser#pjRecordConstruct}.
	 * @param ctx the parse tree
	 */
	void enterPjRecordConstruct(QBTMParser.PjRecordConstructContext ctx);
	/**
	 * Exit a parse tree produced by {@link QBTMParser#pjRecordConstruct}.
	 * @param ctx the parse tree
	 */
	void exitPjRecordConstruct(QBTMParser.PjRecordConstructContext ctx);
	/**
	 * Enter a parse tree produced by {@link QBTMParser#pjFieldBinding}.
	 * @param ctx the parse tree
	 */
	void enterPjFieldBinding(QBTMParser.PjFieldBindingContext ctx);
	/**
	 * Exit a parse tree produced by {@link QBTMParser#pjFieldBinding}.
	 * @param ctx the parse tree
	 */
	void exitPjFieldBinding(QBTMParser.PjFieldBindingContext ctx);
	/**
	 * Enter a parse tree produced by {@link QBTMParser#pjRecordConstructFieldName}.
	 * @param ctx the parse tree
	 */
	void enterPjRecordConstructFieldName(QBTMParser.PjRecordConstructFieldNameContext ctx);
	/**
	 * Exit a parse tree produced by {@link QBTMParser#pjRecordConstructFieldName}.
	 * @param ctx the parse tree
	 */
	void exitPjRecordConstructFieldName(QBTMParser.PjRecordConstructFieldNameContext ctx);
	/**
	 * Enter a parse tree produced by {@link QBTMParser#pjFieldValue}.
	 * @param ctx the parse tree
	 */
	void enterPjFieldValue(QBTMParser.PjFieldValueContext ctx);
	/**
	 * Exit a parse tree produced by {@link QBTMParser#pjFieldValue}.
	 * @param ctx the parse tree
	 */
	void exitPjFieldValue(QBTMParser.PjFieldValueContext ctx);
	/**
	 * Enter a parse tree produced by {@link QBTMParser#pjSelectVar}.
	 * @param ctx the parse tree
	 */
	void enterPjSelectVar(QBTMParser.PjSelectVarContext ctx);
	/**
	 * Exit a parse tree produced by {@link QBTMParser#pjSelectVar}.
	 * @param ctx the parse tree
	 */
	void exitPjSelectVar(QBTMParser.PjSelectVarContext ctx);
	/**
	 * Enter a parse tree produced by {@link QBTMParser#pjPathScalar}.
	 * @param ctx the parse tree
	 */
	void enterPjPathScalar(QBTMParser.PjPathScalarContext ctx);
	/**
	 * Exit a parse tree produced by {@link QBTMParser#pjPathScalar}.
	 * @param ctx the parse tree
	 */
	void exitPjPathScalar(QBTMParser.PjPathScalarContext ctx);
	/**
	 * Enter a parse tree produced by {@link QBTMParser#pjSelectConstant}.
	 * @param ctx the parse tree
	 */
	void enterPjSelectConstant(QBTMParser.PjSelectConstantContext ctx);
	/**
	 * Exit a parse tree produced by {@link QBTMParser#pjSelectConstant}.
	 * @param ctx the parse tree
	 */
	void exitPjSelectConstant(QBTMParser.PjSelectConstantContext ctx);
	/**
	 * Enter a parse tree produced by {@link QBTMParser#pjSelectQuery}.
	 * @param ctx the parse tree
	 */
	void enterPjSelectQuery(QBTMParser.PjSelectQueryContext ctx);
	/**
	 * Exit a parse tree produced by {@link QBTMParser#pjSelectQuery}.
	 * @param ctx the parse tree
	 */
	void exitPjSelectQuery(QBTMParser.PjSelectQueryContext ctx);
	/**
	 * Enter a parse tree produced by {@link QBTMParser#cast}.
	 * @param ctx the parse tree
	 */
	void enterCast(QBTMParser.CastContext ctx);
	/**
	 * Exit a parse tree produced by {@link QBTMParser#cast}.
	 * @param ctx the parse tree
	 */
	void exitCast(QBTMParser.CastContext ctx);
	/**
	 * Enter a parse tree produced by {@link QBTMParser#pjFromWhereClause}.
	 * @param ctx the parse tree
	 */
	void enterPjFromWhereClause(QBTMParser.PjFromWhereClauseContext ctx);
	/**
	 * Exit a parse tree produced by {@link QBTMParser#pjFromWhereClause}.
	 * @param ctx the parse tree
	 */
	void exitPjFromWhereClause(QBTMParser.PjFromWhereClauseContext ctx);
	/**
	 * Enter a parse tree produced by {@link QBTMParser#pjFromClause}.
	 * @param ctx the parse tree
	 */
	void enterPjFromClause(QBTMParser.PjFromClauseContext ctx);
	/**
	 * Exit a parse tree produced by {@link QBTMParser#pjFromClause}.
	 * @param ctx the parse tree
	 */
	void exitPjFromClause(QBTMParser.PjFromClauseContext ctx);
	/**
	 * Enter a parse tree produced by {@link QBTMParser#pjBinding}.
	 * @param ctx the parse tree
	 */
	void enterPjBinding(QBTMParser.PjBindingContext ctx);
	/**
	 * Exit a parse tree produced by {@link QBTMParser#pjBinding}.
	 * @param ctx the parse tree
	 */
	void exitPjBinding(QBTMParser.PjBindingContext ctx);
	/**
	 * Enter a parse tree produced by {@link QBTMParser#pjFromClauseBindingSource}.
	 * @param ctx the parse tree
	 */
	void enterPjFromClauseBindingSource(QBTMParser.PjFromClauseBindingSourceContext ctx);
	/**
	 * Exit a parse tree produced by {@link QBTMParser#pjFromClauseBindingSource}.
	 * @param ctx the parse tree
	 */
	void exitPjFromClauseBindingSource(QBTMParser.PjFromClauseBindingSourceContext ctx);
	/**
	 * Enter a parse tree produced by {@link QBTMParser#pjSource}.
	 * @param ctx the parse tree
	 */
	void enterPjSource(QBTMParser.PjSourceContext ctx);
	/**
	 * Exit a parse tree produced by {@link QBTMParser#pjSource}.
	 * @param ctx the parse tree
	 */
	void exitPjSource(QBTMParser.PjSourceContext ctx);
	/**
	 * Enter a parse tree produced by {@link QBTMParser#pjFromClauseBindingVar}.
	 * @param ctx the parse tree
	 */
	void enterPjFromClauseBindingVar(QBTMParser.PjFromClauseBindingVarContext ctx);
	/**
	 * Exit a parse tree produced by {@link QBTMParser#pjFromClauseBindingVar}.
	 * @param ctx the parse tree
	 */
	void exitPjFromClauseBindingVar(QBTMParser.PjFromClauseBindingVarContext ctx);
	/**
	 * Enter a parse tree produced by {@link QBTMParser#pjWhereClause}.
	 * @param ctx the parse tree
	 */
	void enterPjWhereClause(QBTMParser.PjWhereClauseContext ctx);
	/**
	 * Exit a parse tree produced by {@link QBTMParser#pjWhereClause}.
	 * @param ctx the parse tree
	 */
	void exitPjWhereClause(QBTMParser.PjWhereClauseContext ctx);
	/**
	 * Enter a parse tree produced by {@link QBTMParser#pjCondition}.
	 * @param ctx the parse tree
	 */
	void enterPjCondition(QBTMParser.PjConditionContext ctx);
	/**
	 * Exit a parse tree produced by {@link QBTMParser#pjCondition}.
	 * @param ctx the parse tree
	 */
	void exitPjCondition(QBTMParser.PjConditionContext ctx);
	/**
	 * Enter a parse tree produced by {@link QBTMParser#pjWhereCondEquality}.
	 * @param ctx the parse tree
	 */
	void enterPjWhereCondEquality(QBTMParser.PjWhereCondEqualityContext ctx);
	/**
	 * Exit a parse tree produced by {@link QBTMParser#pjWhereCondEquality}.
	 * @param ctx the parse tree
	 */
	void exitPjWhereCondEquality(QBTMParser.PjWhereCondEqualityContext ctx);
	/**
	 * Enter a parse tree produced by {@link QBTMParser#pjWhereCondEqualityLeftTerm}.
	 * @param ctx the parse tree
	 */
	void enterPjWhereCondEqualityLeftTerm(QBTMParser.PjWhereCondEqualityLeftTermContext ctx);
	/**
	 * Exit a parse tree produced by {@link QBTMParser#pjWhereCondEqualityLeftTerm}.
	 * @param ctx the parse tree
	 */
	void exitPjWhereCondEqualityLeftTerm(QBTMParser.PjWhereCondEqualityLeftTermContext ctx);
	/**
	 * Enter a parse tree produced by {@link QBTMParser#pjWhereCondEqualityRightTerm}.
	 * @param ctx the parse tree
	 */
	void enterPjWhereCondEqualityRightTerm(QBTMParser.PjWhereCondEqualityRightTermContext ctx);
	/**
	 * Exit a parse tree produced by {@link QBTMParser#pjWhereCondEqualityRightTerm}.
	 * @param ctx the parse tree
	 */
	void exitPjWhereCondEqualityRightTerm(QBTMParser.PjWhereCondEqualityRightTermContext ctx);
	/**
	 * Enter a parse tree produced by {@link QBTMParser#pjCTerm}.
	 * @param ctx the parse tree
	 */
	void enterPjCTerm(QBTMParser.PjCTermContext ctx);
	/**
	 * Exit a parse tree produced by {@link QBTMParser#pjCTerm}.
	 * @param ctx the parse tree
	 */
	void exitPjCTerm(QBTMParser.PjCTermContext ctx);
	/**
	 * Enter a parse tree produced by {@link QBTMParser#pjTerm}.
	 * @param ctx the parse tree
	 */
	void enterPjTerm(QBTMParser.PjTermContext ctx);
	/**
	 * Exit a parse tree produced by {@link QBTMParser#pjTerm}.
	 * @param ctx the parse tree
	 */
	void exitPjTerm(QBTMParser.PjTermContext ctx);
	/**
	 * Enter a parse tree produced by {@link QBTMParser#pjTermVar}.
	 * @param ctx the parse tree
	 */
	void enterPjTermVar(QBTMParser.PjTermVarContext ctx);
	/**
	 * Exit a parse tree produced by {@link QBTMParser#pjTermVar}.
	 * @param ctx the parse tree
	 */
	void exitPjTermVar(QBTMParser.PjTermVarContext ctx);
	/**
	 * Enter a parse tree produced by {@link QBTMParser#pjTermConstant}.
	 * @param ctx the parse tree
	 */
	void enterPjTermConstant(QBTMParser.PjTermConstantContext ctx);
	/**
	 * Exit a parse tree produced by {@link QBTMParser#pjTermConstant}.
	 * @param ctx the parse tree
	 */
	void exitPjTermConstant(QBTMParser.PjTermConstantContext ctx);
	/**
	 * Enter a parse tree produced by {@link QBTMParser#pjTermPath}.
	 * @param ctx the parse tree
	 */
	void enterPjTermPath(QBTMParser.PjTermPathContext ctx);
	/**
	 * Exit a parse tree produced by {@link QBTMParser#pjTermPath}.
	 * @param ctx the parse tree
	 */
	void exitPjTermPath(QBTMParser.PjTermPathContext ctx);
	/**
	 * Enter a parse tree produced by {@link QBTMParser#pjPath}.
	 * @param ctx the parse tree
	 */
	void enterPjPath(QBTMParser.PjPathContext ctx);
	/**
	 * Exit a parse tree produced by {@link QBTMParser#pjPath}.
	 * @param ctx the parse tree
	 */
	void exitPjPath(QBTMParser.PjPathContext ctx);
	/**
	 * Enter a parse tree produced by {@link QBTMParser#pjPathVar}.
	 * @param ctx the parse tree
	 */
	void enterPjPathVar(QBTMParser.PjPathVarContext ctx);
	/**
	 * Exit a parse tree produced by {@link QBTMParser#pjPathVar}.
	 * @param ctx the parse tree
	 */
	void exitPjPathVar(QBTMParser.PjPathVarContext ctx);
	/**
	 * Enter a parse tree produced by {@link QBTMParser#pjStep}.
	 * @param ctx the parse tree
	 */
	void enterPjStep(QBTMParser.PjStepContext ctx);
	/**
	 * Exit a parse tree produced by {@link QBTMParser#pjStep}.
	 * @param ctx the parse tree
	 */
	void exitPjStep(QBTMParser.PjStepContext ctx);
	/**
	 * Enter a parse tree produced by {@link QBTMParser#pjObjStep}.
	 * @param ctx the parse tree
	 */
	void enterPjObjStep(QBTMParser.PjObjStepContext ctx);
	/**
	 * Exit a parse tree produced by {@link QBTMParser#pjObjStep}.
	 * @param ctx the parse tree
	 */
	void exitPjObjStep(QBTMParser.PjObjStepContext ctx);
	/**
	 * Enter a parse tree produced by {@link QBTMParser#pjStepScalar}.
	 * @param ctx the parse tree
	 */
	void enterPjStepScalar(QBTMParser.PjStepScalarContext ctx);
	/**
	 * Exit a parse tree produced by {@link QBTMParser#pjStepScalar}.
	 * @param ctx the parse tree
	 */
	void exitPjStepScalar(QBTMParser.PjStepScalarContext ctx);
	/**
	 * Enter a parse tree produced by {@link QBTMParser#pjObjStepScalar}.
	 * @param ctx the parse tree
	 */
	void enterPjObjStepScalar(QBTMParser.PjObjStepScalarContext ctx);
	/**
	 * Exit a parse tree produced by {@link QBTMParser#pjObjStepScalar}.
	 * @param ctx the parse tree
	 */
	void exitPjObjStepScalar(QBTMParser.PjObjStepScalarContext ctx);
	/**
	 * Enter a parse tree produced by {@link QBTMParser#pjPathAttr}.
	 * @param ctx the parse tree
	 */
	void enterPjPathAttr(QBTMParser.PjPathAttrContext ctx);
	/**
	 * Exit a parse tree produced by {@link QBTMParser#pjPathAttr}.
	 * @param ctx the parse tree
	 */
	void exitPjPathAttr(QBTMParser.PjPathAttrContext ctx);
	/**
	 * Enter a parse tree produced by {@link QBTMParser#pjVariable}.
	 * @param ctx the parse tree
	 */
	void enterPjVariable(QBTMParser.PjVariableContext ctx);
	/**
	 * Exit a parse tree produced by {@link QBTMParser#pjVariable}.
	 * @param ctx the parse tree
	 */
	void exitPjVariable(QBTMParser.PjVariableContext ctx);
	/**
	 * Enter a parse tree produced by {@link QBTMParser#pjRelation}.
	 * @param ctx the parse tree
	 */
	void enterPjRelation(QBTMParser.PjRelationContext ctx);
	/**
	 * Exit a parse tree produced by {@link QBTMParser#pjRelation}.
	 * @param ctx the parse tree
	 */
	void exitPjRelation(QBTMParser.PjRelationContext ctx);
	/**
	 * Enter a parse tree produced by {@link QBTMParser#pjKey}.
	 * @param ctx the parse tree
	 */
	void enterPjKey(QBTMParser.PjKeyContext ctx);
	/**
	 * Exit a parse tree produced by {@link QBTMParser#pjKey}.
	 * @param ctx the parse tree
	 */
	void exitPjKey(QBTMParser.PjKeyContext ctx);
	/**
	 * Enter a parse tree produced by {@link QBTMParser#pjConstant}.
	 * @param ctx the parse tree
	 */
	void enterPjConstant(QBTMParser.PjConstantContext ctx);
	/**
	 * Exit a parse tree produced by {@link QBTMParser#pjConstant}.
	 * @param ctx the parse tree
	 */
	void exitPjConstant(QBTMParser.PjConstantContext ctx);
	/**
	 * Enter a parse tree produced by {@link QBTMParser#attribute}.
	 * @param ctx the parse tree
	 */
	void enterAttribute(QBTMParser.AttributeContext ctx);
	/**
	 * Exit a parse tree produced by {@link QBTMParser#attribute}.
	 * @param ctx the parse tree
	 */
	void exitAttribute(QBTMParser.AttributeContext ctx);
	/**
	 * Enter a parse tree produced by {@link QBTMParser#sppjqlQuery}.
	 * @param ctx the parse tree
	 */
	void enterSppjqlQuery(QBTMParser.SppjqlQueryContext ctx);
	/**
	 * Exit a parse tree produced by {@link QBTMParser#sppjqlQuery}.
	 * @param ctx the parse tree
	 */
	void exitSppjqlQuery(QBTMParser.SppjqlQueryContext ctx);
	/**
	 * Enter a parse tree produced by {@link QBTMParser#sppjQuery}.
	 * @param ctx the parse tree
	 */
	void enterSppjQuery(QBTMParser.SppjQueryContext ctx);
	/**
	 * Exit a parse tree produced by {@link QBTMParser#sppjQuery}.
	 * @param ctx the parse tree
	 */
	void exitSppjQuery(QBTMParser.SppjQueryContext ctx);
	/**
	 * Enter a parse tree produced by {@link QBTMParser#sppjRootFieldName}.
	 * @param ctx the parse tree
	 */
	void enterSppjRootFieldName(QBTMParser.SppjRootFieldNameContext ctx);
	/**
	 * Exit a parse tree produced by {@link QBTMParser#sppjRootFieldName}.
	 * @param ctx the parse tree
	 */
	void exitSppjRootFieldName(QBTMParser.SppjRootFieldNameContext ctx);
	/**
	 * Enter a parse tree produced by {@link QBTMParser#sppjSelectClause}.
	 * @param ctx the parse tree
	 */
	void enterSppjSelectClause(QBTMParser.SppjSelectClauseContext ctx);
	/**
	 * Exit a parse tree produced by {@link QBTMParser#sppjSelectClause}.
	 * @param ctx the parse tree
	 */
	void exitSppjSelectClause(QBTMParser.SppjSelectClauseContext ctx);
	/**
	 * Enter a parse tree produced by {@link QBTMParser#sppjSelectStatement}.
	 * @param ctx the parse tree
	 */
	void enterSppjSelectStatement(QBTMParser.SppjSelectStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link QBTMParser#sppjSelectStatement}.
	 * @param ctx the parse tree
	 */
	void exitSppjSelectStatement(QBTMParser.SppjSelectStatementContext ctx);
	/**
	 * Enter a parse tree produced by the {@code sppjRecordConstructLabel}
	 * labeled alternative in {@link QBTMParser#sppjSelectItem}.
	 * @param ctx the parse tree
	 */
	void enterSppjRecordConstructLabel(QBTMParser.SppjRecordConstructLabelContext ctx);
	/**
	 * Exit a parse tree produced by the {@code sppjRecordConstructLabel}
	 * labeled alternative in {@link QBTMParser#sppjSelectItem}.
	 * @param ctx the parse tree
	 */
	void exitSppjRecordConstructLabel(QBTMParser.SppjRecordConstructLabelContext ctx);
	/**
	 * Enter a parse tree produced by the {@code sppjSelectVarLabeL}
	 * labeled alternative in {@link QBTMParser#sppjSelectItem}.
	 * @param ctx the parse tree
	 */
	void enterSppjSelectVarLabeL(QBTMParser.SppjSelectVarLabeLContext ctx);
	/**
	 * Exit a parse tree produced by the {@code sppjSelectVarLabeL}
	 * labeled alternative in {@link QBTMParser#sppjSelectItem}.
	 * @param ctx the parse tree
	 */
	void exitSppjSelectVarLabeL(QBTMParser.SppjSelectVarLabeLContext ctx);
	/**
	 * Enter a parse tree produced by the {@code sppjSelectConstantLabel}
	 * labeled alternative in {@link QBTMParser#sppjSelectItem}.
	 * @param ctx the parse tree
	 */
	void enterSppjSelectConstantLabel(QBTMParser.SppjSelectConstantLabelContext ctx);
	/**
	 * Exit a parse tree produced by the {@code sppjSelectConstantLabel}
	 * labeled alternative in {@link QBTMParser#sppjSelectItem}.
	 * @param ctx the parse tree
	 */
	void exitSppjSelectConstantLabel(QBTMParser.SppjSelectConstantLabelContext ctx);
	/**
	 * Enter a parse tree produced by the {@code sppjSelectPathLabel}
	 * labeled alternative in {@link QBTMParser#sppjSelectItem}.
	 * @param ctx the parse tree
	 */
	void enterSppjSelectPathLabel(QBTMParser.SppjSelectPathLabelContext ctx);
	/**
	 * Exit a parse tree produced by the {@code sppjSelectPathLabel}
	 * labeled alternative in {@link QBTMParser#sppjSelectItem}.
	 * @param ctx the parse tree
	 */
	void exitSppjSelectPathLabel(QBTMParser.SppjSelectPathLabelContext ctx);
	/**
	 * Enter a parse tree produced by {@link QBTMParser#sppjRootRecordConstruct}.
	 * @param ctx the parse tree
	 */
	void enterSppjRootRecordConstruct(QBTMParser.SppjRootRecordConstructContext ctx);
	/**
	 * Exit a parse tree produced by {@link QBTMParser#sppjRootRecordConstruct}.
	 * @param ctx the parse tree
	 */
	void exitSppjRootRecordConstruct(QBTMParser.SppjRootRecordConstructContext ctx);
	/**
	 * Enter a parse tree produced by {@link QBTMParser#sppjRecordConstruct}.
	 * @param ctx the parse tree
	 */
	void enterSppjRecordConstruct(QBTMParser.SppjRecordConstructContext ctx);
	/**
	 * Exit a parse tree produced by {@link QBTMParser#sppjRecordConstruct}.
	 * @param ctx the parse tree
	 */
	void exitSppjRecordConstruct(QBTMParser.SppjRecordConstructContext ctx);
	/**
	 * Enter a parse tree produced by {@link QBTMParser#sppjFieldBinding}.
	 * @param ctx the parse tree
	 */
	void enterSppjFieldBinding(QBTMParser.SppjFieldBindingContext ctx);
	/**
	 * Exit a parse tree produced by {@link QBTMParser#sppjFieldBinding}.
	 * @param ctx the parse tree
	 */
	void exitSppjFieldBinding(QBTMParser.SppjFieldBindingContext ctx);
	/**
	 * Enter a parse tree produced by {@link QBTMParser#sppjRecordConstructFieldName}.
	 * @param ctx the parse tree
	 */
	void enterSppjRecordConstructFieldName(QBTMParser.SppjRecordConstructFieldNameContext ctx);
	/**
	 * Exit a parse tree produced by {@link QBTMParser#sppjRecordConstructFieldName}.
	 * @param ctx the parse tree
	 */
	void exitSppjRecordConstructFieldName(QBTMParser.SppjRecordConstructFieldNameContext ctx);
	/**
	 * Enter a parse tree produced by {@link QBTMParser#sppjFieldValue}.
	 * @param ctx the parse tree
	 */
	void enterSppjFieldValue(QBTMParser.SppjFieldValueContext ctx);
	/**
	 * Exit a parse tree produced by {@link QBTMParser#sppjFieldValue}.
	 * @param ctx the parse tree
	 */
	void exitSppjFieldValue(QBTMParser.SppjFieldValueContext ctx);
	/**
	 * Enter a parse tree produced by {@link QBTMParser#sppjSelectVar}.
	 * @param ctx the parse tree
	 */
	void enterSppjSelectVar(QBTMParser.SppjSelectVarContext ctx);
	/**
	 * Exit a parse tree produced by {@link QBTMParser#sppjSelectVar}.
	 * @param ctx the parse tree
	 */
	void exitSppjSelectVar(QBTMParser.SppjSelectVarContext ctx);
	/**
	 * Enter a parse tree produced by {@link QBTMParser#sppjSelectConstant}.
	 * @param ctx the parse tree
	 */
	void enterSppjSelectConstant(QBTMParser.SppjSelectConstantContext ctx);
	/**
	 * Exit a parse tree produced by {@link QBTMParser#sppjSelectConstant}.
	 * @param ctx the parse tree
	 */
	void exitSppjSelectConstant(QBTMParser.SppjSelectConstantContext ctx);
	/**
	 * Enter a parse tree produced by {@link QBTMParser#sppjSelectQuery}.
	 * @param ctx the parse tree
	 */
	void enterSppjSelectQuery(QBTMParser.SppjSelectQueryContext ctx);
	/**
	 * Exit a parse tree produced by {@link QBTMParser#sppjSelectQuery}.
	 * @param ctx the parse tree
	 */
	void exitSppjSelectQuery(QBTMParser.SppjSelectQueryContext ctx);
	/**
	 * Enter a parse tree produced by {@link QBTMParser#sppjFromWhereClause}.
	 * @param ctx the parse tree
	 */
	void enterSppjFromWhereClause(QBTMParser.SppjFromWhereClauseContext ctx);
	/**
	 * Exit a parse tree produced by {@link QBTMParser#sppjFromWhereClause}.
	 * @param ctx the parse tree
	 */
	void exitSppjFromWhereClause(QBTMParser.SppjFromWhereClauseContext ctx);
	/**
	 * Enter a parse tree produced by {@link QBTMParser#sppjFromClause}.
	 * @param ctx the parse tree
	 */
	void enterSppjFromClause(QBTMParser.SppjFromClauseContext ctx);
	/**
	 * Exit a parse tree produced by {@link QBTMParser#sppjFromClause}.
	 * @param ctx the parse tree
	 */
	void exitSppjFromClause(QBTMParser.SppjFromClauseContext ctx);
	/**
	 * Enter a parse tree produced by {@link QBTMParser#sppjBinding}.
	 * @param ctx the parse tree
	 */
	void enterSppjBinding(QBTMParser.SppjBindingContext ctx);
	/**
	 * Exit a parse tree produced by {@link QBTMParser#sppjBinding}.
	 * @param ctx the parse tree
	 */
	void exitSppjBinding(QBTMParser.SppjBindingContext ctx);
	/**
	 * Enter a parse tree produced by {@link QBTMParser#sppjFromClauseBindingSource}.
	 * @param ctx the parse tree
	 */
	void enterSppjFromClauseBindingSource(QBTMParser.SppjFromClauseBindingSourceContext ctx);
	/**
	 * Exit a parse tree produced by {@link QBTMParser#sppjFromClauseBindingSource}.
	 * @param ctx the parse tree
	 */
	void exitSppjFromClauseBindingSource(QBTMParser.SppjFromClauseBindingSourceContext ctx);
	/**
	 * Enter a parse tree produced by {@link QBTMParser#sppjSource}.
	 * @param ctx the parse tree
	 */
	void enterSppjSource(QBTMParser.SppjSourceContext ctx);
	/**
	 * Exit a parse tree produced by {@link QBTMParser#sppjSource}.
	 * @param ctx the parse tree
	 */
	void exitSppjSource(QBTMParser.SppjSourceContext ctx);
	/**
	 * Enter a parse tree produced by {@link QBTMParser#sppjFromClauseBindingVar}.
	 * @param ctx the parse tree
	 */
	void enterSppjFromClauseBindingVar(QBTMParser.SppjFromClauseBindingVarContext ctx);
	/**
	 * Exit a parse tree produced by {@link QBTMParser#sppjFromClauseBindingVar}.
	 * @param ctx the parse tree
	 */
	void exitSppjFromClauseBindingVar(QBTMParser.SppjFromClauseBindingVarContext ctx);
	/**
	 * Enter a parse tree produced by {@link QBTMParser#sppjWhereClause}.
	 * @param ctx the parse tree
	 */
	void enterSppjWhereClause(QBTMParser.SppjWhereClauseContext ctx);
	/**
	 * Exit a parse tree produced by {@link QBTMParser#sppjWhereClause}.
	 * @param ctx the parse tree
	 */
	void exitSppjWhereClause(QBTMParser.SppjWhereClauseContext ctx);
	/**
	 * Enter a parse tree produced by {@link QBTMParser#sppjCondition}.
	 * @param ctx the parse tree
	 */
	void enterSppjCondition(QBTMParser.SppjConditionContext ctx);
	/**
	 * Exit a parse tree produced by {@link QBTMParser#sppjCondition}.
	 * @param ctx the parse tree
	 */
	void exitSppjCondition(QBTMParser.SppjConditionContext ctx);
	/**
	 * Enter a parse tree produced by {@link QBTMParser#sppjWhereCondEquality}.
	 * @param ctx the parse tree
	 */
	void enterSppjWhereCondEquality(QBTMParser.SppjWhereCondEqualityContext ctx);
	/**
	 * Exit a parse tree produced by {@link QBTMParser#sppjWhereCondEquality}.
	 * @param ctx the parse tree
	 */
	void exitSppjWhereCondEquality(QBTMParser.SppjWhereCondEqualityContext ctx);
	/**
	 * Enter a parse tree produced by {@link QBTMParser#sppjWhereCondEqualityLeftTerm}.
	 * @param ctx the parse tree
	 */
	void enterSppjWhereCondEqualityLeftTerm(QBTMParser.SppjWhereCondEqualityLeftTermContext ctx);
	/**
	 * Exit a parse tree produced by {@link QBTMParser#sppjWhereCondEqualityLeftTerm}.
	 * @param ctx the parse tree
	 */
	void exitSppjWhereCondEqualityLeftTerm(QBTMParser.SppjWhereCondEqualityLeftTermContext ctx);
	/**
	 * Enter a parse tree produced by {@link QBTMParser#sppjWhereCondEqualityRightTerm}.
	 * @param ctx the parse tree
	 */
	void enterSppjWhereCondEqualityRightTerm(QBTMParser.SppjWhereCondEqualityRightTermContext ctx);
	/**
	 * Exit a parse tree produced by {@link QBTMParser#sppjWhereCondEqualityRightTerm}.
	 * @param ctx the parse tree
	 */
	void exitSppjWhereCondEqualityRightTerm(QBTMParser.SppjWhereCondEqualityRightTermContext ctx);
	/**
	 * Enter a parse tree produced by {@link QBTMParser#sppjCTerm}.
	 * @param ctx the parse tree
	 */
	void enterSppjCTerm(QBTMParser.SppjCTermContext ctx);
	/**
	 * Exit a parse tree produced by {@link QBTMParser#sppjCTerm}.
	 * @param ctx the parse tree
	 */
	void exitSppjCTerm(QBTMParser.SppjCTermContext ctx);
	/**
	 * Enter a parse tree produced by {@link QBTMParser#sppjTerm}.
	 * @param ctx the parse tree
	 */
	void enterSppjTerm(QBTMParser.SppjTermContext ctx);
	/**
	 * Exit a parse tree produced by {@link QBTMParser#sppjTerm}.
	 * @param ctx the parse tree
	 */
	void exitSppjTerm(QBTMParser.SppjTermContext ctx);
	/**
	 * Enter a parse tree produced by {@link QBTMParser#sppjTermVar}.
	 * @param ctx the parse tree
	 */
	void enterSppjTermVar(QBTMParser.SppjTermVarContext ctx);
	/**
	 * Exit a parse tree produced by {@link QBTMParser#sppjTermVar}.
	 * @param ctx the parse tree
	 */
	void exitSppjTermVar(QBTMParser.SppjTermVarContext ctx);
	/**
	 * Enter a parse tree produced by {@link QBTMParser#sppjTermConstant}.
	 * @param ctx the parse tree
	 */
	void enterSppjTermConstant(QBTMParser.SppjTermConstantContext ctx);
	/**
	 * Exit a parse tree produced by {@link QBTMParser#sppjTermConstant}.
	 * @param ctx the parse tree
	 */
	void exitSppjTermConstant(QBTMParser.SppjTermConstantContext ctx);
	/**
	 * Enter a parse tree produced by {@link QBTMParser#sppjTermPath}.
	 * @param ctx the parse tree
	 */
	void enterSppjTermPath(QBTMParser.SppjTermPathContext ctx);
	/**
	 * Exit a parse tree produced by {@link QBTMParser#sppjTermPath}.
	 * @param ctx the parse tree
	 */
	void exitSppjTermPath(QBTMParser.SppjTermPathContext ctx);
	/**
	 * Enter a parse tree produced by {@link QBTMParser#sppjPath}.
	 * @param ctx the parse tree
	 */
	void enterSppjPath(QBTMParser.SppjPathContext ctx);
	/**
	 * Exit a parse tree produced by {@link QBTMParser#sppjPath}.
	 * @param ctx the parse tree
	 */
	void exitSppjPath(QBTMParser.SppjPathContext ctx);
	/**
	 * Enter a parse tree produced by {@link QBTMParser#sppjPathVar}.
	 * @param ctx the parse tree
	 */
	void enterSppjPathVar(QBTMParser.SppjPathVarContext ctx);
	/**
	 * Exit a parse tree produced by {@link QBTMParser#sppjPathVar}.
	 * @param ctx the parse tree
	 */
	void exitSppjPathVar(QBTMParser.SppjPathVarContext ctx);
	/**
	 * Enter a parse tree produced by {@link QBTMParser#sppjStep}.
	 * @param ctx the parse tree
	 */
	void enterSppjStep(QBTMParser.SppjStepContext ctx);
	/**
	 * Exit a parse tree produced by {@link QBTMParser#sppjStep}.
	 * @param ctx the parse tree
	 */
	void exitSppjStep(QBTMParser.SppjStepContext ctx);
	/**
	 * Enter a parse tree produced by {@link QBTMParser#sppjObjStep}.
	 * @param ctx the parse tree
	 */
	void enterSppjObjStep(QBTMParser.SppjObjStepContext ctx);
	/**
	 * Exit a parse tree produced by {@link QBTMParser#sppjObjStep}.
	 * @param ctx the parse tree
	 */
	void exitSppjObjStep(QBTMParser.SppjObjStepContext ctx);
	/**
	 * Enter a parse tree produced by {@link QBTMParser#sppjVariable}.
	 * @param ctx the parse tree
	 */
	void enterSppjVariable(QBTMParser.SppjVariableContext ctx);
	/**
	 * Exit a parse tree produced by {@link QBTMParser#sppjVariable}.
	 * @param ctx the parse tree
	 */
	void exitSppjVariable(QBTMParser.SppjVariableContext ctx);
	/**
	 * Enter a parse tree produced by {@link QBTMParser#sppjFieldName}.
	 * @param ctx the parse tree
	 */
	void enterSppjFieldName(QBTMParser.SppjFieldNameContext ctx);
	/**
	 * Exit a parse tree produced by {@link QBTMParser#sppjFieldName}.
	 * @param ctx the parse tree
	 */
	void exitSppjFieldName(QBTMParser.SppjFieldNameContext ctx);
	/**
	 * Enter a parse tree produced by {@link QBTMParser#sppjConstant}.
	 * @param ctx the parse tree
	 */
	void enterSppjConstant(QBTMParser.SppjConstantContext ctx);
	/**
	 * Exit a parse tree produced by {@link QBTMParser#sppjConstant}.
	 * @param ctx the parse tree
	 */
	void exitSppjConstant(QBTMParser.SppjConstantContext ctx);
}