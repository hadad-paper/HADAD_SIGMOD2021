// Generated from KQL.g4 by ANTLR 4.7.2

package hadad.base.compiler.model.rk;

import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link KQLParser}.
 */
public interface KQLListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link KQLParser#kqlquery}.
	 * @param ctx the parse tree
	 */
	void enterKqlquery(KQLParser.KqlqueryContext ctx);
	/**
	 * Exit a parse tree produced by {@link KQLParser#kqlquery}.
	 * @param ctx the parse tree
	 */
	void exitKqlquery(KQLParser.KqlqueryContext ctx);
	/**
	 * Enter a parse tree produced by {@link KQLParser#viewName}.
	 * @param ctx the parse tree
	 */
	void enterViewName(KQLParser.ViewNameContext ctx);
	/**
	 * Exit a parse tree produced by {@link KQLParser#viewName}.
	 * @param ctx the parse tree
	 */
	void exitViewName(KQLParser.ViewNameContext ctx);
	/**
	 * Enter a parse tree produced by {@link KQLParser#redisKQLQuery}.
	 * @param ctx the parse tree
	 */
	void enterRedisKQLQuery(KQLParser.RedisKQLQueryContext ctx);
	/**
	 * Exit a parse tree produced by {@link KQLParser#redisKQLQuery}.
	 * @param ctx the parse tree
	 */
	void exitRedisKQLQuery(KQLParser.RedisKQLQueryContext ctx);
	/**
	 * Enter a parse tree produced by {@link KQLParser#sfwQuery}.
	 * @param ctx the parse tree
	 */
	void enterSfwQuery(KQLParser.SfwQueryContext ctx);
	/**
	 * Exit a parse tree produced by {@link KQLParser#sfwQuery}.
	 * @param ctx the parse tree
	 */
	void exitSfwQuery(KQLParser.SfwQueryContext ctx);
	/**
	 * Enter a parse tree produced by {@link KQLParser#rkSelectClasue}.
	 * @param ctx the parse tree
	 */
	void enterRkSelectClasue(KQLParser.RkSelectClasueContext ctx);
	/**
	 * Exit a parse tree produced by {@link KQLParser#rkSelectClasue}.
	 * @param ctx the parse tree
	 */
	void exitRkSelectClasue(KQLParser.RkSelectClasueContext ctx);
	/**
	 * Enter a parse tree produced by {@link KQLParser#rkSelectStatement}.
	 * @param ctx the parse tree
	 */
	void enterRkSelectStatement(KQLParser.RkSelectStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link KQLParser#rkSelectStatement}.
	 * @param ctx the parse tree
	 */
	void exitRkSelectStatement(KQLParser.RkSelectStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link KQLParser#rkSelectItem}.
	 * @param ctx the parse tree
	 */
	void enterRkSelectItem(KQLParser.RkSelectItemContext ctx);
	/**
	 * Exit a parse tree produced by {@link KQLParser#rkSelectItem}.
	 * @param ctx the parse tree
	 */
	void exitRkSelectItem(KQLParser.RkSelectItemContext ctx);
	/**
	 * Enter a parse tree produced by {@link KQLParser#rkReturnVariable}.
	 * @param ctx the parse tree
	 */
	void enterRkReturnVariable(KQLParser.RkReturnVariableContext ctx);
	/**
	 * Exit a parse tree produced by {@link KQLParser#rkReturnVariable}.
	 * @param ctx the parse tree
	 */
	void exitRkReturnVariable(KQLParser.RkReturnVariableContext ctx);
	/**
	 * Enter a parse tree produced by {@link KQLParser#mapConstructor}.
	 * @param ctx the parse tree
	 */
	void enterMapConstructor(KQLParser.MapConstructorContext ctx);
	/**
	 * Exit a parse tree produced by {@link KQLParser#mapConstructor}.
	 * @param ctx the parse tree
	 */
	void exitMapConstructor(KQLParser.MapConstructorContext ctx);
	/**
	 * Enter a parse tree produced by {@link KQLParser#rkAttribute}.
	 * @param ctx the parse tree
	 */
	void enterRkAttribute(KQLParser.RkAttributeContext ctx);
	/**
	 * Exit a parse tree produced by {@link KQLParser#rkAttribute}.
	 * @param ctx the parse tree
	 */
	void exitRkAttribute(KQLParser.RkAttributeContext ctx);
	/**
	 * Enter a parse tree produced by {@link KQLParser#rkAttributeValue}.
	 * @param ctx the parse tree
	 */
	void enterRkAttributeValue(KQLParser.RkAttributeValueContext ctx);
	/**
	 * Exit a parse tree produced by {@link KQLParser#rkAttributeValue}.
	 * @param ctx the parse tree
	 */
	void exitRkAttributeValue(KQLParser.RkAttributeValueContext ctx);
	/**
	 * Enter a parse tree produced by {@link KQLParser#mapKey}.
	 * @param ctx the parse tree
	 */
	void enterMapKey(KQLParser.MapKeyContext ctx);
	/**
	 * Exit a parse tree produced by {@link KQLParser#mapKey}.
	 * @param ctx the parse tree
	 */
	void exitMapKey(KQLParser.MapKeyContext ctx);
	/**
	 * Enter a parse tree produced by {@link KQLParser#rkFromClasue}.
	 * @param ctx the parse tree
	 */
	void enterRkFromClasue(KQLParser.RkFromClasueContext ctx);
	/**
	 * Exit a parse tree produced by {@link KQLParser#rkFromClasue}.
	 * @param ctx the parse tree
	 */
	void exitRkFromClasue(KQLParser.RkFromClasueContext ctx);
	/**
	 * Enter a parse tree produced by {@link KQLParser#varBinding}.
	 * @param ctx the parse tree
	 */
	void enterVarBinding(KQLParser.VarBindingContext ctx);
	/**
	 * Exit a parse tree produced by {@link KQLParser#varBinding}.
	 * @param ctx the parse tree
	 */
	void exitVarBinding(KQLParser.VarBindingContext ctx);
	/**
	 * Enter a parse tree produced by {@link KQLParser#fromvariableBinding}.
	 * @param ctx the parse tree
	 */
	void enterFromvariableBinding(KQLParser.FromvariableBindingContext ctx);
	/**
	 * Exit a parse tree produced by {@link KQLParser#fromvariableBinding}.
	 * @param ctx the parse tree
	 */
	void exitFromvariableBinding(KQLParser.FromvariableBindingContext ctx);
	/**
	 * Enter a parse tree produced by {@link KQLParser#rkSource}.
	 * @param ctx the parse tree
	 */
	void enterRkSource(KQLParser.RkSourceContext ctx);
	/**
	 * Exit a parse tree produced by {@link KQLParser#rkSource}.
	 * @param ctx the parse tree
	 */
	void exitRkSource(KQLParser.RkSourceContext ctx);
	/**
	 * Enter a parse tree produced by the {@code MainMapLookUp}
	 * labeled alternative in {@link KQLParser#rkLookUpExpression}.
	 * @param ctx the parse tree
	 */
	void enterMainMapLookUp(KQLParser.MainMapLookUpContext ctx);
	/**
	 * Exit a parse tree produced by the {@code MainMapLookUp}
	 * labeled alternative in {@link KQLParser#rkLookUpExpression}.
	 * @param ctx the parse tree
	 */
	void exitMainMapLookUp(KQLParser.MainMapLookUpContext ctx);
	/**
	 * Enter a parse tree produced by the {@code VariableMapLookUp}
	 * labeled alternative in {@link KQLParser#rkLookUpExpression}.
	 * @param ctx the parse tree
	 */
	void enterVariableMapLookUp(KQLParser.VariableMapLookUpContext ctx);
	/**
	 * Exit a parse tree produced by the {@code VariableMapLookUp}
	 * labeled alternative in {@link KQLParser#rkLookUpExpression}.
	 * @param ctx the parse tree
	 */
	void exitVariableMapLookUp(KQLParser.VariableMapLookUpContext ctx);
	/**
	 * Enter a parse tree produced by the {@code KeysMapLookUp}
	 * labeled alternative in {@link KQLParser#rkLookUpExpression}.
	 * @param ctx the parse tree
	 */
	void enterKeysMapLookUp(KQLParser.KeysMapLookUpContext ctx);
	/**
	 * Exit a parse tree produced by the {@code KeysMapLookUp}
	 * labeled alternative in {@link KQLParser#rkLookUpExpression}.
	 * @param ctx the parse tree
	 */
	void exitKeysMapLookUp(KQLParser.KeysMapLookUpContext ctx);
	/**
	 * Enter a parse tree produced by {@link KQLParser#mainMap}.
	 * @param ctx the parse tree
	 */
	void enterMainMap(KQLParser.MainMapContext ctx);
	/**
	 * Exit a parse tree produced by {@link KQLParser#mainMap}.
	 * @param ctx the parse tree
	 */
	void exitMainMap(KQLParser.MainMapContext ctx);
	/**
	 * Enter a parse tree produced by {@link KQLParser#mapVariable}.
	 * @param ctx the parse tree
	 */
	void enterMapVariable(KQLParser.MapVariableContext ctx);
	/**
	 * Exit a parse tree produced by {@link KQLParser#mapVariable}.
	 * @param ctx the parse tree
	 */
	void exitMapVariable(KQLParser.MapVariableContext ctx);
	/**
	 * Enter a parse tree produced by {@link KQLParser#rkKey}.
	 * @param ctx the parse tree
	 */
	void enterRkKey(KQLParser.RkKeyContext ctx);
	/**
	 * Exit a parse tree produced by {@link KQLParser#rkKey}.
	 * @param ctx the parse tree
	 */
	void exitRkKey(KQLParser.RkKeyContext ctx);
	/**
	 * Enter a parse tree produced by {@link KQLParser#rkStringKey}.
	 * @param ctx the parse tree
	 */
	void enterRkStringKey(KQLParser.RkStringKeyContext ctx);
	/**
	 * Exit a parse tree produced by {@link KQLParser#rkStringKey}.
	 * @param ctx the parse tree
	 */
	void exitRkStringKey(KQLParser.RkStringKeyContext ctx);
	/**
	 * Enter a parse tree produced by {@link KQLParser#variableKey}.
	 * @param ctx the parse tree
	 */
	void enterVariableKey(KQLParser.VariableKeyContext ctx);
	/**
	 * Exit a parse tree produced by {@link KQLParser#variableKey}.
	 * @param ctx the parse tree
	 */
	void exitVariableKey(KQLParser.VariableKeyContext ctx);
	/**
	 * Enter a parse tree produced by {@link KQLParser#keyVariable}.
	 * @param ctx the parse tree
	 */
	void enterKeyVariable(KQLParser.KeyVariableContext ctx);
	/**
	 * Exit a parse tree produced by {@link KQLParser#keyVariable}.
	 * @param ctx the parse tree
	 */
	void exitKeyVariable(KQLParser.KeyVariableContext ctx);
	/**
	 * Enter a parse tree produced by {@link KQLParser#mapName}.
	 * @param ctx the parse tree
	 */
	void enterMapName(KQLParser.MapNameContext ctx);
	/**
	 * Exit a parse tree produced by {@link KQLParser#mapName}.
	 * @param ctx the parse tree
	 */
	void exitMapName(KQLParser.MapNameContext ctx);
	/**
	 * Enter a parse tree produced by {@link KQLParser#rkVariable}.
	 * @param ctx the parse tree
	 */
	void enterRkVariable(KQLParser.RkVariableContext ctx);
	/**
	 * Exit a parse tree produced by {@link KQLParser#rkVariable}.
	 * @param ctx the parse tree
	 */
	void exitRkVariable(KQLParser.RkVariableContext ctx);
}