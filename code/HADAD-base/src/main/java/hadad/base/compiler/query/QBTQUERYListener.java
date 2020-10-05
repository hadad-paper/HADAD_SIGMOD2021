// Generated from QBTQUERY.g4 by ANTLR 4.5

package hadad.base.compiler.query;

import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link QBTQUERYParser}.
 */
public interface QBTQUERYListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link QBTQUERYParser#mixedqbt}.
	 * @param ctx the parse tree
	 */
	void enterMixedqbt(QBTQUERYParser.MixedqbtContext ctx);
	/**
	 * Exit a parse tree produced by {@link QBTQUERYParser#mixedqbt}.
	 * @param ctx the parse tree
	 */
	void exitMixedqbt(QBTQUERYParser.MixedqbtContext ctx);
	/**
	 * Enter a parse tree produced by {@link QBTQUERYParser#queryName}.
	 * @param ctx the parse tree
	 */
	void enterQueryName(QBTQUERYParser.QueryNameContext ctx);
	/**
	 * Exit a parse tree produced by {@link QBTQUERYParser#queryName}.
	 * @param ctx the parse tree
	 */
	void exitQueryName(QBTQUERYParser.QueryNameContext ctx);
	/**
	 * Enter a parse tree produced by {@link QBTQUERYParser#mixedQBTQuery}.
	 * @param ctx the parse tree
	 */
	void enterMixedQBTQuery(QBTQUERYParser.MixedQBTQueryContext ctx);
	/**
	 * Exit a parse tree produced by {@link QBTQUERYParser#mixedQBTQuery}.
	 * @param ctx the parse tree
	 */
	void exitMixedQBTQuery(QBTQUERYParser.MixedQBTQueryContext ctx);
	/**
	 * Enter a parse tree produced by {@link QBTQUERYParser#block}.
	 * @param ctx the parse tree
	 */
	void enterBlock(QBTQUERYParser.BlockContext ctx);
	/**
	 * Exit a parse tree produced by {@link QBTQUERYParser#block}.
	 * @param ctx the parse tree
	 */
	void exitBlock(QBTQUERYParser.BlockContext ctx);
	/**
	 * Enter a parse tree produced by {@link QBTQUERYParser#forPattern}.
	 * @param ctx the parse tree
	 */
	void enterForPattern(QBTQUERYParser.ForPatternContext ctx);
	/**
	 * Exit a parse tree produced by {@link QBTQUERYParser#forPattern}.
	 * @param ctx the parse tree
	 */
	void exitForPattern(QBTQUERYParser.ForPatternContext ctx);
	/**
	 * Enter a parse tree produced by {@link QBTQUERYParser#wherePattern}.
	 * @param ctx the parse tree
	 */
	void enterWherePattern(QBTQUERYParser.WherePatternContext ctx);
	/**
	 * Exit a parse tree produced by {@link QBTQUERYParser#wherePattern}.
	 * @param ctx the parse tree
	 */
	void exitWherePattern(QBTQUERYParser.WherePatternContext ctx);
	/**
	 * Enter a parse tree produced by {@link QBTQUERYParser#returnPattern}.
	 * @param ctx the parse tree
	 */
	void enterReturnPattern(QBTQUERYParser.ReturnPatternContext ctx);
	/**
	 * Exit a parse tree produced by {@link QBTQUERYParser#returnPattern}.
	 * @param ctx the parse tree
	 */
	void exitReturnPattern(QBTQUERYParser.ReturnPatternContext ctx);
	/**
	 * Enter a parse tree produced by {@link QBTQUERYParser#pattern}.
	 * @param ctx the parse tree
	 */
	void enterPattern(QBTQUERYParser.PatternContext ctx);
	/**
	 * Exit a parse tree produced by {@link QBTQUERYParser#pattern}.
	 * @param ctx the parse tree
	 */
	void exitPattern(QBTQUERYParser.PatternContext ctx);
	/**
	 * Enter a parse tree produced by {@link QBTQUERYParser#modelPattern}.
	 * @param ctx the parse tree
	 */
	void enterModelPattern(QBTQUERYParser.ModelPatternContext ctx);
	/**
	 * Exit a parse tree produced by {@link QBTQUERYParser#modelPattern}.
	 * @param ctx the parse tree
	 */
	void exitModelPattern(QBTQUERYParser.ModelPatternContext ctx);
	/**
	 * Enter a parse tree produced by {@link QBTQUERYParser#jqPattern}.
	 * @param ctx the parse tree
	 */
	void enterJqPattern(QBTQUERYParser.JqPatternContext ctx);
	/**
	 * Exit a parse tree produced by {@link QBTQUERYParser#jqPattern}.
	 * @param ctx the parse tree
	 */
	void exitJqPattern(QBTQUERYParser.JqPatternContext ctx);
	/**
	 * Enter a parse tree produced by {@link QBTQUERYParser#kqPattern}.
	 * @param ctx the parse tree
	 */
	void enterKqPattern(QBTQUERYParser.KqPatternContext ctx);
	/**
	 * Exit a parse tree produced by {@link QBTQUERYParser#kqPattern}.
	 * @param ctx the parse tree
	 */
	void exitKqPattern(QBTQUERYParser.KqPatternContext ctx);
	/**
	 * Enter a parse tree produced by {@link QBTQUERYParser#xqPattern}.
	 * @param ctx the parse tree
	 */
	void enterXqPattern(QBTQUERYParser.XqPatternContext ctx);
	/**
	 * Exit a parse tree produced by {@link QBTQUERYParser#xqPattern}.
	 * @param ctx the parse tree
	 */
	void exitXqPattern(QBTQUERYParser.XqPatternContext ctx);
	/**
	 * Enter a parse tree produced by {@link QBTQUERYParser#rqPattern}.
	 * @param ctx the parse tree
	 */
	void enterRqPattern(QBTQUERYParser.RqPatternContext ctx);
	/**
	 * Exit a parse tree produced by {@link QBTQUERYParser#rqPattern}.
	 * @param ctx the parse tree
	 */
	void exitRqPattern(QBTQUERYParser.RqPatternContext ctx);
	/**
	 * Enter a parse tree produced by {@link QBTQUERYParser#mixedcondition}.
	 * @param ctx the parse tree
	 */
	void enterMixedcondition(QBTQUERYParser.MixedconditionContext ctx);
	/**
	 * Exit a parse tree produced by {@link QBTQUERYParser#mixedcondition}.
	 * @param ctx the parse tree
	 */
	void exitMixedcondition(QBTQUERYParser.MixedconditionContext ctx);
	/**
	 * Enter a parse tree produced by {@link QBTQUERYParser#atom}.
	 * @param ctx the parse tree
	 */
	void enterAtom(QBTQUERYParser.AtomContext ctx);
	/**
	 * Exit a parse tree produced by {@link QBTQUERYParser#atom}.
	 * @param ctx the parse tree
	 */
	void exitAtom(QBTQUERYParser.AtomContext ctx);
	/**
	 * Enter a parse tree produced by {@link QBTQUERYParser#termmixed}.
	 * @param ctx the parse tree
	 */
	void enterTermmixed(QBTQUERYParser.TermmixedContext ctx);
	/**
	 * Exit a parse tree produced by {@link QBTQUERYParser#termmixed}.
	 * @param ctx the parse tree
	 */
	void exitTermmixed(QBTQUERYParser.TermmixedContext ctx);
	/**
	 * Enter a parse tree produced by {@link QBTQUERYParser#constant}.
	 * @param ctx the parse tree
	 */
	void enterConstant(QBTQUERYParser.ConstantContext ctx);
	/**
	 * Exit a parse tree produced by {@link QBTQUERYParser#constant}.
	 * @param ctx the parse tree
	 */
	void exitConstant(QBTQUERYParser.ConstantContext ctx);
	/**
	 * Enter a parse tree produced by {@link QBTQUERYParser#pathExpr}.
	 * @param ctx the parse tree
	 */
	void enterPathExpr(QBTQUERYParser.PathExprContext ctx);
	/**
	 * Exit a parse tree produced by {@link QBTQUERYParser#pathExpr}.
	 * @param ctx the parse tree
	 */
	void exitPathExpr(QBTQUERYParser.PathExprContext ctx);
	/**
	 * Enter a parse tree produced by {@link QBTQUERYParser#constructor}.
	 * @param ctx the parse tree
	 */
	void enterConstructor(QBTQUERYParser.ConstructorContext ctx);
	/**
	 * Exit a parse tree produced by {@link QBTQUERYParser#constructor}.
	 * @param ctx the parse tree
	 */
	void exitConstructor(QBTQUERYParser.ConstructorContext ctx);
	/**
	 * Enter a parse tree produced by {@link QBTQUERYParser#modelConstructor}.
	 * @param ctx the parse tree
	 */
	void enterModelConstructor(QBTQUERYParser.ModelConstructorContext ctx);
	/**
	 * Exit a parse tree produced by {@link QBTQUERYParser#modelConstructor}.
	 * @param ctx the parse tree
	 */
	void exitModelConstructor(QBTQUERYParser.ModelConstructorContext ctx);
	/**
	 * Enter a parse tree produced by {@link QBTQUERYParser#jqConstructor}.
	 * @param ctx the parse tree
	 */
	void enterJqConstructor(QBTQUERYParser.JqConstructorContext ctx);
	/**
	 * Exit a parse tree produced by {@link QBTQUERYParser#jqConstructor}.
	 * @param ctx the parse tree
	 */
	void exitJqConstructor(QBTQUERYParser.JqConstructorContext ctx);
	/**
	 * Enter a parse tree produced by {@link QBTQUERYParser#kqConstructor}.
	 * @param ctx the parse tree
	 */
	void enterKqConstructor(QBTQUERYParser.KqConstructorContext ctx);
	/**
	 * Exit a parse tree produced by {@link QBTQUERYParser#kqConstructor}.
	 * @param ctx the parse tree
	 */
	void exitKqConstructor(QBTQUERYParser.KqConstructorContext ctx);
	/**
	 * Enter a parse tree produced by {@link QBTQUERYParser#xqConstructor}.
	 * @param ctx the parse tree
	 */
	void enterXqConstructor(QBTQUERYParser.XqConstructorContext ctx);
	/**
	 * Exit a parse tree produced by {@link QBTQUERYParser#xqConstructor}.
	 * @param ctx the parse tree
	 */
	void exitXqConstructor(QBTQUERYParser.XqConstructorContext ctx);
	/**
	 * Enter a parse tree produced by {@link QBTQUERYParser#annotation}.
	 * @param ctx the parse tree
	 */
	void enterAnnotation(QBTQUERYParser.AnnotationContext ctx);
	/**
	 * Exit a parse tree produced by {@link QBTQUERYParser#annotation}.
	 * @param ctx the parse tree
	 */
	void exitAnnotation(QBTQUERYParser.AnnotationContext ctx);
	/**
	 * Enter a parse tree produced by {@link QBTQUERYParser#stringConstant}.
	 * @param ctx the parse tree
	 */
	void enterStringConstant(QBTQUERYParser.StringConstantContext ctx);
	/**
	 * Exit a parse tree produced by {@link QBTQUERYParser#stringConstant}.
	 * @param ctx the parse tree
	 */
	void exitStringConstant(QBTQUERYParser.StringConstantContext ctx);
	/**
	 * Enter a parse tree produced by {@link QBTQUERYParser#numericConstant}.
	 * @param ctx the parse tree
	 */
	void enterNumericConstant(QBTQUERYParser.NumericConstantContext ctx);
	/**
	 * Exit a parse tree produced by {@link QBTQUERYParser#numericConstant}.
	 * @param ctx the parse tree
	 */
	void exitNumericConstant(QBTQUERYParser.NumericConstantContext ctx);
	/**
	 * Enter a parse tree produced by {@link QBTQUERYParser#mainMap}.
	 * @param ctx the parse tree
	 */
	void enterMainMap(QBTQUERYParser.MainMapContext ctx);
	/**
	 * Exit a parse tree produced by {@link QBTQUERYParser#mainMap}.
	 * @param ctx the parse tree
	 */
	void exitMainMap(QBTQUERYParser.MainMapContext ctx);
	/**
	 * Enter a parse tree produced by {@link QBTQUERYParser#kqlquery}.
	 * @param ctx the parse tree
	 */
	void enterKqlquery(QBTQUERYParser.KqlqueryContext ctx);
	/**
	 * Exit a parse tree produced by {@link QBTQUERYParser#kqlquery}.
	 * @param ctx the parse tree
	 */
	void exitKqlquery(QBTQUERYParser.KqlqueryContext ctx);
	/**
	 * Enter a parse tree produced by {@link QBTQUERYParser#redisKQLQuery}.
	 * @param ctx the parse tree
	 */
	void enterRedisKQLQuery(QBTQUERYParser.RedisKQLQueryContext ctx);
	/**
	 * Exit a parse tree produced by {@link QBTQUERYParser#redisKQLQuery}.
	 * @param ctx the parse tree
	 */
	void exitRedisKQLQuery(QBTQUERYParser.RedisKQLQueryContext ctx);
	/**
	 * Enter a parse tree produced by {@link QBTQUERYParser#sfwQuery}.
	 * @param ctx the parse tree
	 */
	void enterSfwQuery(QBTQUERYParser.SfwQueryContext ctx);
	/**
	 * Exit a parse tree produced by {@link QBTQUERYParser#sfwQuery}.
	 * @param ctx the parse tree
	 */
	void exitSfwQuery(QBTQUERYParser.SfwQueryContext ctx);
	/**
	 * Enter a parse tree produced by {@link QBTQUERYParser#selectClasue}.
	 * @param ctx the parse tree
	 */
	void enterSelectClasue(QBTQUERYParser.SelectClasueContext ctx);
	/**
	 * Exit a parse tree produced by {@link QBTQUERYParser#selectClasue}.
	 * @param ctx the parse tree
	 */
	void exitSelectClasue(QBTQUERYParser.SelectClasueContext ctx);
	/**
	 * Enter a parse tree produced by {@link QBTQUERYParser#selectStatement}.
	 * @param ctx the parse tree
	 */
	void enterSelectStatement(QBTQUERYParser.SelectStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link QBTQUERYParser#selectStatement}.
	 * @param ctx the parse tree
	 */
	void exitSelectStatement(QBTQUERYParser.SelectStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link QBTQUERYParser#selectItemKQL}.
	 * @param ctx the parse tree
	 */
	void enterSelectItemKQL(QBTQUERYParser.SelectItemKQLContext ctx);
	/**
	 * Exit a parse tree produced by {@link QBTQUERYParser#selectItemKQL}.
	 * @param ctx the parse tree
	 */
	void exitSelectItemKQL(QBTQUERYParser.SelectItemKQLContext ctx);
	/**
	 * Enter a parse tree produced by {@link QBTQUERYParser#returnVariableKQL}.
	 * @param ctx the parse tree
	 */
	void enterReturnVariableKQL(QBTQUERYParser.ReturnVariableKQLContext ctx);
	/**
	 * Exit a parse tree produced by {@link QBTQUERYParser#returnVariableKQL}.
	 * @param ctx the parse tree
	 */
	void exitReturnVariableKQL(QBTQUERYParser.ReturnVariableKQLContext ctx);
	/**
	 * Enter a parse tree produced by {@link QBTQUERYParser#fromClasue}.
	 * @param ctx the parse tree
	 */
	void enterFromClasue(QBTQUERYParser.FromClasueContext ctx);
	/**
	 * Exit a parse tree produced by {@link QBTQUERYParser#fromClasue}.
	 * @param ctx the parse tree
	 */
	void exitFromClasue(QBTQUERYParser.FromClasueContext ctx);
	/**
	 * Enter a parse tree produced by {@link QBTQUERYParser#varBinding}.
	 * @param ctx the parse tree
	 */
	void enterVarBinding(QBTQUERYParser.VarBindingContext ctx);
	/**
	 * Exit a parse tree produced by {@link QBTQUERYParser#varBinding}.
	 * @param ctx the parse tree
	 */
	void exitVarBinding(QBTQUERYParser.VarBindingContext ctx);
	/**
	 * Enter a parse tree produced by {@link QBTQUERYParser#fromvariableBinding}.
	 * @param ctx the parse tree
	 */
	void enterFromvariableBinding(QBTQUERYParser.FromvariableBindingContext ctx);
	/**
	 * Exit a parse tree produced by {@link QBTQUERYParser#fromvariableBinding}.
	 * @param ctx the parse tree
	 */
	void exitFromvariableBinding(QBTQUERYParser.FromvariableBindingContext ctx);
	/**
	 * Enter a parse tree produced by {@link QBTQUERYParser#sourceKQL}.
	 * @param ctx the parse tree
	 */
	void enterSourceKQL(QBTQUERYParser.SourceKQLContext ctx);
	/**
	 * Exit a parse tree produced by {@link QBTQUERYParser#sourceKQL}.
	 * @param ctx the parse tree
	 */
	void exitSourceKQL(QBTQUERYParser.SourceKQLContext ctx);
	/**
	 * Enter a parse tree produced by the {@code MainMapLookUp}
	 * labeled alternative in {@link QBTQUERYParser#lookUpExpression}.
	 * @param ctx the parse tree
	 */
	void enterMainMapLookUp(QBTQUERYParser.MainMapLookUpContext ctx);
	/**
	 * Exit a parse tree produced by the {@code MainMapLookUp}
	 * labeled alternative in {@link QBTQUERYParser#lookUpExpression}.
	 * @param ctx the parse tree
	 */
	void exitMainMapLookUp(QBTQUERYParser.MainMapLookUpContext ctx);
	/**
	 * Enter a parse tree produced by the {@code VariableMapLookUp}
	 * labeled alternative in {@link QBTQUERYParser#lookUpExpression}.
	 * @param ctx the parse tree
	 */
	void enterVariableMapLookUp(QBTQUERYParser.VariableMapLookUpContext ctx);
	/**
	 * Exit a parse tree produced by the {@code VariableMapLookUp}
	 * labeled alternative in {@link QBTQUERYParser#lookUpExpression}.
	 * @param ctx the parse tree
	 */
	void exitVariableMapLookUp(QBTQUERYParser.VariableMapLookUpContext ctx);
	/**
	 * Enter a parse tree produced by the {@code KeysMapLookUp}
	 * labeled alternative in {@link QBTQUERYParser#lookUpExpression}.
	 * @param ctx the parse tree
	 */
	void enterKeysMapLookUp(QBTQUERYParser.KeysMapLookUpContext ctx);
	/**
	 * Exit a parse tree produced by the {@code KeysMapLookUp}
	 * labeled alternative in {@link QBTQUERYParser#lookUpExpression}.
	 * @param ctx the parse tree
	 */
	void exitKeysMapLookUp(QBTQUERYParser.KeysMapLookUpContext ctx);
	/**
	 * Enter a parse tree produced by {@link QBTQUERYParser#mapVariable}.
	 * @param ctx the parse tree
	 */
	void enterMapVariable(QBTQUERYParser.MapVariableContext ctx);
	/**
	 * Exit a parse tree produced by {@link QBTQUERYParser#mapVariable}.
	 * @param ctx the parse tree
	 */
	void exitMapVariable(QBTQUERYParser.MapVariableContext ctx);
	/**
	 * Enter a parse tree produced by {@link QBTQUERYParser#keyKQL}.
	 * @param ctx the parse tree
	 */
	void enterKeyKQL(QBTQUERYParser.KeyKQLContext ctx);
	/**
	 * Exit a parse tree produced by {@link QBTQUERYParser#keyKQL}.
	 * @param ctx the parse tree
	 */
	void exitKeyKQL(QBTQUERYParser.KeyKQLContext ctx);
	/**
	 * Enter a parse tree produced by {@link QBTQUERYParser#stringKey}.
	 * @param ctx the parse tree
	 */
	void enterStringKey(QBTQUERYParser.StringKeyContext ctx);
	/**
	 * Exit a parse tree produced by {@link QBTQUERYParser#stringKey}.
	 * @param ctx the parse tree
	 */
	void exitStringKey(QBTQUERYParser.StringKeyContext ctx);
	/**
	 * Enter a parse tree produced by {@link QBTQUERYParser#variableKey}.
	 * @param ctx the parse tree
	 */
	void enterVariableKey(QBTQUERYParser.VariableKeyContext ctx);
	/**
	 * Exit a parse tree produced by {@link QBTQUERYParser#variableKey}.
	 * @param ctx the parse tree
	 */
	void exitVariableKey(QBTQUERYParser.VariableKeyContext ctx);
	/**
	 * Enter a parse tree produced by {@link QBTQUERYParser#keyVariable}.
	 * @param ctx the parse tree
	 */
	void enterKeyVariable(QBTQUERYParser.KeyVariableContext ctx);
	/**
	 * Exit a parse tree produced by {@link QBTQUERYParser#keyVariable}.
	 * @param ctx the parse tree
	 */
	void exitKeyVariable(QBTQUERYParser.KeyVariableContext ctx);
	/**
	 * Enter a parse tree produced by {@link QBTQUERYParser#mapName}.
	 * @param ctx the parse tree
	 */
	void enterMapName(QBTQUERYParser.MapNameContext ctx);
	/**
	 * Exit a parse tree produced by {@link QBTQUERYParser#mapName}.
	 * @param ctx the parse tree
	 */
	void exitMapName(QBTQUERYParser.MapNameContext ctx);
	/**
	 * Enter a parse tree produced by {@link QBTQUERYParser#variableKQL}.
	 * @param ctx the parse tree
	 */
	void enterVariableKQL(QBTQUERYParser.VariableKQLContext ctx);
	/**
	 * Exit a parse tree produced by {@link QBTQUERYParser#variableKQL}.
	 * @param ctx the parse tree
	 */
	void exitVariableKQL(QBTQUERYParser.VariableKQLContext ctx);
	/**
	 * Enter a parse tree produced by {@link QBTQUERYParser#aqlquery}.
	 * @param ctx the parse tree
	 */
	void enterAqlquery(QBTQUERYParser.AqlqueryContext ctx);
	/**
	 * Exit a parse tree produced by {@link QBTQUERYParser#aqlquery}.
	 * @param ctx the parse tree
	 */
	void exitAqlquery(QBTQUERYParser.AqlqueryContext ctx);
	/**
	 * Enter a parse tree produced by {@link QBTQUERYParser#queryAQL}.
	 * @param ctx the parse tree
	 */
	void enterQueryAQL(QBTQUERYParser.QueryAQLContext ctx);
	/**
	 * Exit a parse tree produced by {@link QBTQUERYParser#queryAQL}.
	 * @param ctx the parse tree
	 */
	void exitQueryAQL(QBTQUERYParser.QueryAQLContext ctx);
	/**
	 * Enter a parse tree produced by {@link QBTQUERYParser#rootFieldName}.
	 * @param ctx the parse tree
	 */
	void enterRootFieldName(QBTQUERYParser.RootFieldNameContext ctx);
	/**
	 * Exit a parse tree produced by {@link QBTQUERYParser#rootFieldName}.
	 * @param ctx the parse tree
	 */
	void exitRootFieldName(QBTQUERYParser.RootFieldNameContext ctx);
	/**
	 * Enter a parse tree produced by {@link QBTQUERYParser#returnClause}.
	 * @param ctx the parse tree
	 */
	void enterReturnClause(QBTQUERYParser.ReturnClauseContext ctx);
	/**
	 * Exit a parse tree produced by {@link QBTQUERYParser#returnClause}.
	 * @param ctx the parse tree
	 */
	void exitReturnClause(QBTQUERYParser.ReturnClauseContext ctx);
	/**
	 * Enter a parse tree produced by {@link QBTQUERYParser#recordConstruct}.
	 * @param ctx the parse tree
	 */
	void enterRecordConstruct(QBTQUERYParser.RecordConstructContext ctx);
	/**
	 * Exit a parse tree produced by {@link QBTQUERYParser#recordConstruct}.
	 * @param ctx the parse tree
	 */
	void exitRecordConstruct(QBTQUERYParser.RecordConstructContext ctx);
	/**
	 * Enter a parse tree produced by {@link QBTQUERYParser#fieldBinding}.
	 * @param ctx the parse tree
	 */
	void enterFieldBinding(QBTQUERYParser.FieldBindingContext ctx);
	/**
	 * Exit a parse tree produced by {@link QBTQUERYParser#fieldBinding}.
	 * @param ctx the parse tree
	 */
	void exitFieldBinding(QBTQUERYParser.FieldBindingContext ctx);
	/**
	 * Enter a parse tree produced by {@link QBTQUERYParser#recordConstructFieldName}.
	 * @param ctx the parse tree
	 */
	void enterRecordConstructFieldName(QBTQUERYParser.RecordConstructFieldNameContext ctx);
	/**
	 * Exit a parse tree produced by {@link QBTQUERYParser#recordConstructFieldName}.
	 * @param ctx the parse tree
	 */
	void exitRecordConstructFieldName(QBTQUERYParser.RecordConstructFieldNameContext ctx);
	/**
	 * Enter a parse tree produced by {@link QBTQUERYParser#fieldName}.
	 * @param ctx the parse tree
	 */
	void enterFieldName(QBTQUERYParser.FieldNameContext ctx);
	/**
	 * Exit a parse tree produced by {@link QBTQUERYParser#fieldName}.
	 * @param ctx the parse tree
	 */
	void exitFieldName(QBTQUERYParser.FieldNameContext ctx);
	/**
	 * Enter a parse tree produced by {@link QBTQUERYParser#fieldValue}.
	 * @param ctx the parse tree
	 */
	void enterFieldValue(QBTQUERYParser.FieldValueContext ctx);
	/**
	 * Exit a parse tree produced by {@link QBTQUERYParser#fieldValue}.
	 * @param ctx the parse tree
	 */
	void exitFieldValue(QBTQUERYParser.FieldValueContext ctx);
	/**
	 * Enter a parse tree produced by {@link QBTQUERYParser#returnVar}.
	 * @param ctx the parse tree
	 */
	void enterReturnVar(QBTQUERYParser.ReturnVarContext ctx);
	/**
	 * Exit a parse tree produced by {@link QBTQUERYParser#returnVar}.
	 * @param ctx the parse tree
	 */
	void exitReturnVar(QBTQUERYParser.ReturnVarContext ctx);
	/**
	 * Enter a parse tree produced by {@link QBTQUERYParser#varRQ}.
	 * @param ctx the parse tree
	 */
	void enterVarRQ(QBTQUERYParser.VarRQContext ctx);
	/**
	 * Exit a parse tree produced by {@link QBTQUERYParser#varRQ}.
	 * @param ctx the parse tree
	 */
	void exitVarRQ(QBTQUERYParser.VarRQContext ctx);
	/**
	 * Enter a parse tree produced by {@link QBTQUERYParser#name}.
	 * @param ctx the parse tree
	 */
	void enterName(QBTQUERYParser.NameContext ctx);
	/**
	 * Exit a parse tree produced by {@link QBTQUERYParser#name}.
	 * @param ctx the parse tree
	 */
	void exitName(QBTQUERYParser.NameContext ctx);
	/**
	 * Enter a parse tree produced by {@link QBTQUERYParser#returnConstant}.
	 * @param ctx the parse tree
	 */
	void enterReturnConstant(QBTQUERYParser.ReturnConstantContext ctx);
	/**
	 * Exit a parse tree produced by {@link QBTQUERYParser#returnConstant}.
	 * @param ctx the parse tree
	 */
	void exitReturnConstant(QBTQUERYParser.ReturnConstantContext ctx);
	/**
	 * Enter a parse tree produced by {@link QBTQUERYParser#returnQuery}.
	 * @param ctx the parse tree
	 */
	void enterReturnQuery(QBTQUERYParser.ReturnQueryContext ctx);
	/**
	 * Exit a parse tree produced by {@link QBTQUERYParser#returnQuery}.
	 * @param ctx the parse tree
	 */
	void exitReturnQuery(QBTQUERYParser.ReturnQueryContext ctx);
	/**
	 * Enter a parse tree produced by {@link QBTQUERYParser#term}.
	 * @param ctx the parse tree
	 */
	void enterTerm(QBTQUERYParser.TermContext ctx);
	/**
	 * Exit a parse tree produced by {@link QBTQUERYParser#term}.
	 * @param ctx the parse tree
	 */
	void exitTerm(QBTQUERYParser.TermContext ctx);
	/**
	 * Enter a parse tree produced by {@link QBTQUERYParser#termVar}.
	 * @param ctx the parse tree
	 */
	void enterTermVar(QBTQUERYParser.TermVarContext ctx);
	/**
	 * Exit a parse tree produced by {@link QBTQUERYParser#termVar}.
	 * @param ctx the parse tree
	 */
	void exitTermVar(QBTQUERYParser.TermVarContext ctx);
	/**
	 * Enter a parse tree produced by {@link QBTQUERYParser#termConstant}.
	 * @param ctx the parse tree
	 */
	void enterTermConstant(QBTQUERYParser.TermConstantContext ctx);
	/**
	 * Exit a parse tree produced by {@link QBTQUERYParser#termConstant}.
	 * @param ctx the parse tree
	 */
	void exitTermConstant(QBTQUERYParser.TermConstantContext ctx);
	/**
	 * Enter a parse tree produced by {@link QBTQUERYParser#termPath}.
	 * @param ctx the parse tree
	 */
	void enterTermPath(QBTQUERYParser.TermPathContext ctx);
	/**
	 * Exit a parse tree produced by {@link QBTQUERYParser#termPath}.
	 * @param ctx the parse tree
	 */
	void exitTermPath(QBTQUERYParser.TermPathContext ctx);
	/**
	 * Enter a parse tree produced by {@link QBTQUERYParser#number}.
	 * @param ctx the parse tree
	 */
	void enterNumber(QBTQUERYParser.NumberContext ctx);
	/**
	 * Exit a parse tree produced by {@link QBTQUERYParser#number}.
	 * @param ctx the parse tree
	 */
	void exitNumber(QBTQUERYParser.NumberContext ctx);
	/**
	 * Enter a parse tree produced by {@link QBTQUERYParser#string}.
	 * @param ctx the parse tree
	 */
	void enterString(QBTQUERYParser.StringContext ctx);
	/**
	 * Exit a parse tree produced by {@link QBTQUERYParser#string}.
	 * @param ctx the parse tree
	 */
	void exitString(QBTQUERYParser.StringContext ctx);
	/**
	 * Enter a parse tree produced by {@link QBTQUERYParser#path}.
	 * @param ctx the parse tree
	 */
	void enterPath(QBTQUERYParser.PathContext ctx);
	/**
	 * Exit a parse tree produced by {@link QBTQUERYParser#path}.
	 * @param ctx the parse tree
	 */
	void exitPath(QBTQUERYParser.PathContext ctx);
	/**
	 * Enter a parse tree produced by {@link QBTQUERYParser#pathVar}.
	 * @param ctx the parse tree
	 */
	void enterPathVar(QBTQUERYParser.PathVarContext ctx);
	/**
	 * Exit a parse tree produced by {@link QBTQUERYParser#pathVar}.
	 * @param ctx the parse tree
	 */
	void exitPathVar(QBTQUERYParser.PathVarContext ctx);
	/**
	 * Enter a parse tree produced by {@link QBTQUERYParser#varAQL}.
	 * @param ctx the parse tree
	 */
	void enterVarAQL(QBTQUERYParser.VarAQLContext ctx);
	/**
	 * Exit a parse tree produced by {@link QBTQUERYParser#varAQL}.
	 * @param ctx the parse tree
	 */
	void exitVarAQL(QBTQUERYParser.VarAQLContext ctx);
	/**
	 * Enter a parse tree produced by {@link QBTQUERYParser#step}.
	 * @param ctx the parse tree
	 */
	void enterStep(QBTQUERYParser.StepContext ctx);
	/**
	 * Exit a parse tree produced by {@link QBTQUERYParser#step}.
	 * @param ctx the parse tree
	 */
	void exitStep(QBTQUERYParser.StepContext ctx);
	/**
	 * Enter a parse tree produced by {@link QBTQUERYParser#objectStep}.
	 * @param ctx the parse tree
	 */
	void enterObjectStep(QBTQUERYParser.ObjectStepContext ctx);
	/**
	 * Exit a parse tree produced by {@link QBTQUERYParser#objectStep}.
	 * @param ctx the parse tree
	 */
	void exitObjectStep(QBTQUERYParser.ObjectStepContext ctx);
	/**
	 * Enter a parse tree produced by {@link QBTQUERYParser#arrayStep}.
	 * @param ctx the parse tree
	 */
	void enterArrayStep(QBTQUERYParser.ArrayStepContext ctx);
	/**
	 * Exit a parse tree produced by {@link QBTQUERYParser#arrayStep}.
	 * @param ctx the parse tree
	 */
	void exitArrayStep(QBTQUERYParser.ArrayStepContext ctx);
	/**
	 * Enter a parse tree produced by {@link QBTQUERYParser#keyAQL}.
	 * @param ctx the parse tree
	 */
	void enterKeyAQL(QBTQUERYParser.KeyAQLContext ctx);
	/**
	 * Exit a parse tree produced by {@link QBTQUERYParser#keyAQL}.
	 * @param ctx the parse tree
	 */
	void exitKeyAQL(QBTQUERYParser.KeyAQLContext ctx);
	/**
	 * Enter a parse tree produced by {@link QBTQUERYParser#index}.
	 * @param ctx the parse tree
	 */
	void enterIndex(QBTQUERYParser.IndexContext ctx);
	/**
	 * Exit a parse tree produced by {@link QBTQUERYParser#index}.
	 * @param ctx the parse tree
	 */
	void exitIndex(QBTQUERYParser.IndexContext ctx);
	/**
	 * Enter a parse tree produced by {@link QBTQUERYParser#forClause}.
	 * @param ctx the parse tree
	 */
	void enterForClause(QBTQUERYParser.ForClauseContext ctx);
	/**
	 * Exit a parse tree produced by {@link QBTQUERYParser#forClause}.
	 * @param ctx the parse tree
	 */
	void exitForClause(QBTQUERYParser.ForClauseContext ctx);
	/**
	 * Enter a parse tree produced by {@link QBTQUERYParser#formixed}.
	 * @param ctx the parse tree
	 */
	void enterFormixed(QBTQUERYParser.FormixedContext ctx);
	/**
	 * Exit a parse tree produced by {@link QBTQUERYParser#formixed}.
	 * @param ctx the parse tree
	 */
	void exitFormixed(QBTQUERYParser.FormixedContext ctx);
	/**
	 * Enter a parse tree produced by {@link QBTQUERYParser#binding}.
	 * @param ctx the parse tree
	 */
	void enterBinding(QBTQUERYParser.BindingContext ctx);
	/**
	 * Exit a parse tree produced by {@link QBTQUERYParser#binding}.
	 * @param ctx the parse tree
	 */
	void exitBinding(QBTQUERYParser.BindingContext ctx);
	/**
	 * Enter a parse tree produced by {@link QBTQUERYParser#forClauseBindingVar}.
	 * @param ctx the parse tree
	 */
	void enterForClauseBindingVar(QBTQUERYParser.ForClauseBindingVarContext ctx);
	/**
	 * Exit a parse tree produced by {@link QBTQUERYParser#forClauseBindingVar}.
	 * @param ctx the parse tree
	 */
	void exitForClauseBindingVar(QBTQUERYParser.ForClauseBindingVarContext ctx);
	/**
	 * Enter a parse tree produced by {@link QBTQUERYParser#forClauseBindingSource}.
	 * @param ctx the parse tree
	 */
	void enterForClauseBindingSource(QBTQUERYParser.ForClauseBindingSourceContext ctx);
	/**
	 * Exit a parse tree produced by {@link QBTQUERYParser#forClauseBindingSource}.
	 * @param ctx the parse tree
	 */
	void exitForClauseBindingSource(QBTQUERYParser.ForClauseBindingSourceContext ctx);
	/**
	 * Enter a parse tree produced by {@link QBTQUERYParser#sourceAQL}.
	 * @param ctx the parse tree
	 */
	void enterSourceAQL(QBTQUERYParser.SourceAQLContext ctx);
	/**
	 * Exit a parse tree produced by {@link QBTQUERYParser#sourceAQL}.
	 * @param ctx the parse tree
	 */
	void exitSourceAQL(QBTQUERYParser.SourceAQLContext ctx);
	/**
	 * Enter a parse tree produced by {@link QBTQUERYParser#dataSetName}.
	 * @param ctx the parse tree
	 */
	void enterDataSetName(QBTQUERYParser.DataSetNameContext ctx);
	/**
	 * Exit a parse tree produced by {@link QBTQUERYParser#dataSetName}.
	 * @param ctx the parse tree
	 */
	void exitDataSetName(QBTQUERYParser.DataSetNameContext ctx);
	/**
	 * Enter a parse tree produced by {@link QBTQUERYParser#whereClause}.
	 * @param ctx the parse tree
	 */
	void enterWhereClause(QBTQUERYParser.WhereClauseContext ctx);
	/**
	 * Exit a parse tree produced by {@link QBTQUERYParser#whereClause}.
	 * @param ctx the parse tree
	 */
	void exitWhereClause(QBTQUERYParser.WhereClauseContext ctx);
	/**
	 * Enter a parse tree produced by {@link QBTQUERYParser#condition}.
	 * @param ctx the parse tree
	 */
	void enterCondition(QBTQUERYParser.ConditionContext ctx);
	/**
	 * Exit a parse tree produced by {@link QBTQUERYParser#condition}.
	 * @param ctx the parse tree
	 */
	void exitCondition(QBTQUERYParser.ConditionContext ctx);
	/**
	 * Enter a parse tree produced by {@link QBTQUERYParser#whereCondSome}.
	 * @param ctx the parse tree
	 */
	void enterWhereCondSome(QBTQUERYParser.WhereCondSomeContext ctx);
	/**
	 * Exit a parse tree produced by {@link QBTQUERYParser#whereCondSome}.
	 * @param ctx the parse tree
	 */
	void exitWhereCondSome(QBTQUERYParser.WhereCondSomeContext ctx);
	/**
	 * Enter a parse tree produced by {@link QBTQUERYParser#whereCondBinding}.
	 * @param ctx the parse tree
	 */
	void enterWhereCondBinding(QBTQUERYParser.WhereCondBindingContext ctx);
	/**
	 * Exit a parse tree produced by {@link QBTQUERYParser#whereCondBinding}.
	 * @param ctx the parse tree
	 */
	void exitWhereCondBinding(QBTQUERYParser.WhereCondBindingContext ctx);
	/**
	 * Enter a parse tree produced by {@link QBTQUERYParser#whereCondBindingVar}.
	 * @param ctx the parse tree
	 */
	void enterWhereCondBindingVar(QBTQUERYParser.WhereCondBindingVarContext ctx);
	/**
	 * Exit a parse tree produced by {@link QBTQUERYParser#whereCondBindingVar}.
	 * @param ctx the parse tree
	 */
	void exitWhereCondBindingVar(QBTQUERYParser.WhereCondBindingVarContext ctx);
	/**
	 * Enter a parse tree produced by {@link QBTQUERYParser#whereCondBindingSource}.
	 * @param ctx the parse tree
	 */
	void enterWhereCondBindingSource(QBTQUERYParser.WhereCondBindingSourceContext ctx);
	/**
	 * Exit a parse tree produced by {@link QBTQUERYParser#whereCondBindingSource}.
	 * @param ctx the parse tree
	 */
	void exitWhereCondBindingSource(QBTQUERYParser.WhereCondBindingSourceContext ctx);
	/**
	 * Enter a parse tree produced by {@link QBTQUERYParser#whereCondEquality}.
	 * @param ctx the parse tree
	 */
	void enterWhereCondEquality(QBTQUERYParser.WhereCondEqualityContext ctx);
	/**
	 * Exit a parse tree produced by {@link QBTQUERYParser#whereCondEquality}.
	 * @param ctx the parse tree
	 */
	void exitWhereCondEquality(QBTQUERYParser.WhereCondEqualityContext ctx);
	/**
	 * Enter a parse tree produced by {@link QBTQUERYParser#whereCondEqualityLeftTerm}.
	 * @param ctx the parse tree
	 */
	void enterWhereCondEqualityLeftTerm(QBTQUERYParser.WhereCondEqualityLeftTermContext ctx);
	/**
	 * Exit a parse tree produced by {@link QBTQUERYParser#whereCondEqualityLeftTerm}.
	 * @param ctx the parse tree
	 */
	void exitWhereCondEqualityLeftTerm(QBTQUERYParser.WhereCondEqualityLeftTermContext ctx);
	/**
	 * Enter a parse tree produced by {@link QBTQUERYParser#whereCondEqualityRightTerm}.
	 * @param ctx the parse tree
	 */
	void enterWhereCondEqualityRightTerm(QBTQUERYParser.WhereCondEqualityRightTermContext ctx);
	/**
	 * Exit a parse tree produced by {@link QBTQUERYParser#whereCondEqualityRightTerm}.
	 * @param ctx the parse tree
	 */
	void exitWhereCondEqualityRightTerm(QBTQUERYParser.WhereCondEqualityRightTermContext ctx);
	/**
	 * Enter a parse tree produced by {@link QBTQUERYParser#cterm}.
	 * @param ctx the parse tree
	 */
	void enterCterm(QBTQUERYParser.CtermContext ctx);
	/**
	 * Exit a parse tree produced by {@link QBTQUERYParser#cterm}.
	 * @param ctx the parse tree
	 */
	void exitCterm(QBTQUERYParser.CtermContext ctx);
	/**
	 * Enter a parse tree produced by {@link QBTQUERYParser#xquery}.
	 * @param ctx the parse tree
	 */
	void enterXquery(QBTQUERYParser.XqueryContext ctx);
	/**
	 * Exit a parse tree produced by {@link QBTQUERYParser#xquery}.
	 * @param ctx the parse tree
	 */
	void exitXquery(QBTQUERYParser.XqueryContext ctx);
	/**
	 * Enter a parse tree produced by {@link QBTQUERYParser#openRootTag}.
	 * @param ctx the parse tree
	 */
	void enterOpenRootTag(QBTQUERYParser.OpenRootTagContext ctx);
	/**
	 * Exit a parse tree produced by {@link QBTQUERYParser#openRootTag}.
	 * @param ctx the parse tree
	 */
	void exitOpenRootTag(QBTQUERYParser.OpenRootTagContext ctx);
	/**
	 * Enter a parse tree produced by {@link QBTQUERYParser#closeRootTag}.
	 * @param ctx the parse tree
	 */
	void enterCloseRootTag(QBTQUERYParser.CloseRootTagContext ctx);
	/**
	 * Exit a parse tree produced by {@link QBTQUERYParser#closeRootTag}.
	 * @param ctx the parse tree
	 */
	void exitCloseRootTag(QBTQUERYParser.CloseRootTagContext ctx);
	/**
	 * Enter a parse tree produced by {@link QBTQUERYParser#construct}.
	 * @param ctx the parse tree
	 */
	void enterConstruct(QBTQUERYParser.ConstructContext ctx);
	/**
	 * Exit a parse tree produced by {@link QBTQUERYParser#construct}.
	 * @param ctx the parse tree
	 */
	void exitConstruct(QBTQUERYParser.ConstructContext ctx);
	/**
	 * Enter a parse tree produced by {@link QBTQUERYParser#constructEmptyTag}.
	 * @param ctx the parse tree
	 */
	void enterConstructEmptyTag(QBTQUERYParser.ConstructEmptyTagContext ctx);
	/**
	 * Exit a parse tree produced by {@link QBTQUERYParser#constructEmptyTag}.
	 * @param ctx the parse tree
	 */
	void exitConstructEmptyTag(QBTQUERYParser.ConstructEmptyTagContext ctx);
	/**
	 * Enter a parse tree produced by {@link QBTQUERYParser#constructString}.
	 * @param ctx the parse tree
	 */
	void enterConstructString(QBTQUERYParser.ConstructStringContext ctx);
	/**
	 * Exit a parse tree produced by {@link QBTQUERYParser#constructString}.
	 * @param ctx the parse tree
	 */
	void exitConstructString(QBTQUERYParser.ConstructStringContext ctx);
	/**
	 * Enter a parse tree produced by {@link QBTQUERYParser#constructVar}.
	 * @param ctx the parse tree
	 */
	void enterConstructVar(QBTQUERYParser.ConstructVarContext ctx);
	/**
	 * Exit a parse tree produced by {@link QBTQUERYParser#constructVar}.
	 * @param ctx the parse tree
	 */
	void exitConstructVar(QBTQUERYParser.ConstructVarContext ctx);
	/**
	 * Enter a parse tree produced by {@link QBTQUERYParser#constructFlwr}.
	 * @param ctx the parse tree
	 */
	void enterConstructFlwr(QBTQUERYParser.ConstructFlwrContext ctx);
	/**
	 * Exit a parse tree produced by {@link QBTQUERYParser#constructFlwr}.
	 * @param ctx the parse tree
	 */
	void exitConstructFlwr(QBTQUERYParser.ConstructFlwrContext ctx);
	/**
	 * Enter a parse tree produced by {@link QBTQUERYParser#constructFlwrTerm}.
	 * @param ctx the parse tree
	 */
	void enterConstructFlwrTerm(QBTQUERYParser.ConstructFlwrTermContext ctx);
	/**
	 * Exit a parse tree produced by {@link QBTQUERYParser#constructFlwrTerm}.
	 * @param ctx the parse tree
	 */
	void exitConstructFlwrTerm(QBTQUERYParser.ConstructFlwrTermContext ctx);
	/**
	 * Enter a parse tree produced by {@link QBTQUERYParser#constructDelimeter}.
	 * @param ctx the parse tree
	 */
	void enterConstructDelimeter(QBTQUERYParser.ConstructDelimeterContext ctx);
	/**
	 * Exit a parse tree produced by {@link QBTQUERYParser#constructDelimeter}.
	 * @param ctx the parse tree
	 */
	void exitConstructDelimeter(QBTQUERYParser.ConstructDelimeterContext ctx);
	/**
	 * Enter a parse tree produced by {@link QBTQUERYParser#constructFlwrOpenTag}.
	 * @param ctx the parse tree
	 */
	void enterConstructFlwrOpenTag(QBTQUERYParser.ConstructFlwrOpenTagContext ctx);
	/**
	 * Exit a parse tree produced by {@link QBTQUERYParser#constructFlwrOpenTag}.
	 * @param ctx the parse tree
	 */
	void exitConstructFlwrOpenTag(QBTQUERYParser.ConstructFlwrOpenTagContext ctx);
	/**
	 * Enter a parse tree produced by {@link QBTQUERYParser#constructFlwrCloseTag}.
	 * @param ctx the parse tree
	 */
	void enterConstructFlwrCloseTag(QBTQUERYParser.ConstructFlwrCloseTagContext ctx);
	/**
	 * Exit a parse tree produced by {@link QBTQUERYParser#constructFlwrCloseTag}.
	 * @param ctx the parse tree
	 */
	void exitConstructFlwrCloseTag(QBTQUERYParser.ConstructFlwrCloseTagContext ctx);
	/**
	 * Enter a parse tree produced by {@link QBTQUERYParser#tag}.
	 * @param ctx the parse tree
	 */
	void enterTag(QBTQUERYParser.TagContext ctx);
	/**
	 * Exit a parse tree produced by {@link QBTQUERYParser#tag}.
	 * @param ctx the parse tree
	 */
	void exitTag(QBTQUERYParser.TagContext ctx);
	/**
	 * Enter a parse tree produced by {@link QBTQUERYParser#mkattr}.
	 * @param ctx the parse tree
	 */
	void enterMkattr(QBTQUERYParser.MkattrContext ctx);
	/**
	 * Exit a parse tree produced by {@link QBTQUERYParser#mkattr}.
	 * @param ctx the parse tree
	 */
	void exitMkattr(QBTQUERYParser.MkattrContext ctx);
	/**
	 * Enter a parse tree produced by {@link QBTQUERYParser#mkattrName}.
	 * @param ctx the parse tree
	 */
	void enterMkattrName(QBTQUERYParser.MkattrNameContext ctx);
	/**
	 * Exit a parse tree produced by {@link QBTQUERYParser#mkattrName}.
	 * @param ctx the parse tree
	 */
	void exitMkattrName(QBTQUERYParser.MkattrNameContext ctx);
	/**
	 * Enter a parse tree produced by {@link QBTQUERYParser#aterm}.
	 * @param ctx the parse tree
	 */
	void enterAterm(QBTQUERYParser.AtermContext ctx);
	/**
	 * Exit a parse tree produced by {@link QBTQUERYParser#aterm}.
	 * @param ctx the parse tree
	 */
	void exitAterm(QBTQUERYParser.AtermContext ctx);
	/**
	 * Enter a parse tree produced by {@link QBTQUERYParser#atermVar}.
	 * @param ctx the parse tree
	 */
	void enterAtermVar(QBTQUERYParser.AtermVarContext ctx);
	/**
	 * Exit a parse tree produced by {@link QBTQUERYParser#atermVar}.
	 * @param ctx the parse tree
	 */
	void exitAtermVar(QBTQUERYParser.AtermVarContext ctx);
	/**
	 * Enter a parse tree produced by {@link QBTQUERYParser#atermString}.
	 * @param ctx the parse tree
	 */
	void enterAtermString(QBTQUERYParser.AtermStringContext ctx);
	/**
	 * Exit a parse tree produced by {@link QBTQUERYParser#atermString}.
	 * @param ctx the parse tree
	 */
	void exitAtermString(QBTQUERYParser.AtermStringContext ctx);
	/**
	 * Enter a parse tree produced by {@link QBTQUERYParser#varXQ}.
	 * @param ctx the parse tree
	 */
	void enterVarXQ(QBTQUERYParser.VarXQContext ctx);
	/**
	 * Exit a parse tree produced by {@link QBTQUERYParser#varXQ}.
	 * @param ctx the parse tree
	 */
	void exitVarXQ(QBTQUERYParser.VarXQContext ctx);
	/**
	 * Enter a parse tree produced by {@link QBTQUERYParser#flwr}.
	 * @param ctx the parse tree
	 */
	void enterFlwr(QBTQUERYParser.FlwrContext ctx);
	/**
	 * Exit a parse tree produced by {@link QBTQUERYParser#flwr}.
	 * @param ctx the parse tree
	 */
	void exitFlwr(QBTQUERYParser.FlwrContext ctx);
	/**
	 * Enter a parse tree produced by {@link QBTQUERYParser#flwrFor}.
	 * @param ctx the parse tree
	 */
	void enterFlwrFor(QBTQUERYParser.FlwrForContext ctx);
	/**
	 * Exit a parse tree produced by {@link QBTQUERYParser#flwrFor}.
	 * @param ctx the parse tree
	 */
	void exitFlwrFor(QBTQUERYParser.FlwrForContext ctx);
	/**
	 * Enter a parse tree produced by {@link QBTQUERYParser#flwrWhere}.
	 * @param ctx the parse tree
	 */
	void enterFlwrWhere(QBTQUERYParser.FlwrWhereContext ctx);
	/**
	 * Exit a parse tree produced by {@link QBTQUERYParser#flwrWhere}.
	 * @param ctx the parse tree
	 */
	void exitFlwrWhere(QBTQUERYParser.FlwrWhereContext ctx);
	/**
	 * Enter a parse tree produced by {@link QBTQUERYParser#flwrForWhere}.
	 * @param ctx the parse tree
	 */
	void enterFlwrForWhere(QBTQUERYParser.FlwrForWhereContext ctx);
	/**
	 * Exit a parse tree produced by {@link QBTQUERYParser#flwrForWhere}.
	 * @param ctx the parse tree
	 */
	void exitFlwrForWhere(QBTQUERYParser.FlwrForWhereContext ctx);
	/**
	 * Enter a parse tree produced by {@link QBTQUERYParser#flwrReturn}.
	 * @param ctx the parse tree
	 */
	void enterFlwrReturn(QBTQUERYParser.FlwrReturnContext ctx);
	/**
	 * Exit a parse tree produced by {@link QBTQUERYParser#flwrReturn}.
	 * @param ctx the parse tree
	 */
	void exitFlwrReturn(QBTQUERYParser.FlwrReturnContext ctx);
	/**
	 * Enter a parse tree produced by {@link QBTQUERYParser#flwrForVar}.
	 * @param ctx the parse tree
	 */
	void enterFlwrForVar(QBTQUERYParser.FlwrForVarContext ctx);
	/**
	 * Exit a parse tree produced by {@link QBTQUERYParser#flwrForVar}.
	 * @param ctx the parse tree
	 */
	void exitFlwrForVar(QBTQUERYParser.FlwrForVarContext ctx);
	/**
	 * Enter a parse tree produced by {@link QBTQUERYParser#flwrForP}.
	 * @param ctx the parse tree
	 */
	void enterFlwrForP(QBTQUERYParser.FlwrForPContext ctx);
	/**
	 * Exit a parse tree produced by {@link QBTQUERYParser#flwrForP}.
	 * @param ctx the parse tree
	 */
	void exitFlwrForP(QBTQUERYParser.FlwrForPContext ctx);
	/**
	 * Enter a parse tree produced by {@link QBTQUERYParser#flwrWhereCond}.
	 * @param ctx the parse tree
	 */
	void enterFlwrWhereCond(QBTQUERYParser.FlwrWhereCondContext ctx);
	/**
	 * Exit a parse tree produced by {@link QBTQUERYParser#flwrWhereCond}.
	 * @param ctx the parse tree
	 */
	void exitFlwrWhereCond(QBTQUERYParser.FlwrWhereCondContext ctx);
	/**
	 * Enter a parse tree produced by {@link QBTQUERYParser#flwrWhereCondSome}.
	 * @param ctx the parse tree
	 */
	void enterFlwrWhereCondSome(QBTQUERYParser.FlwrWhereCondSomeContext ctx);
	/**
	 * Exit a parse tree produced by {@link QBTQUERYParser#flwrWhereCondSome}.
	 * @param ctx the parse tree
	 */
	void exitFlwrWhereCondSome(QBTQUERYParser.FlwrWhereCondSomeContext ctx);
	/**
	 * Enter a parse tree produced by {@link QBTQUERYParser#flwrWhereCondVar}.
	 * @param ctx the parse tree
	 */
	void enterFlwrWhereCondVar(QBTQUERYParser.FlwrWhereCondVarContext ctx);
	/**
	 * Exit a parse tree produced by {@link QBTQUERYParser#flwrWhereCondVar}.
	 * @param ctx the parse tree
	 */
	void exitFlwrWhereCondVar(QBTQUERYParser.FlwrWhereCondVarContext ctx);
	/**
	 * Enter a parse tree produced by {@link QBTQUERYParser#flwrWhereCondAp}.
	 * @param ctx the parse tree
	 */
	void enterFlwrWhereCondAp(QBTQUERYParser.FlwrWhereCondApContext ctx);
	/**
	 * Exit a parse tree produced by {@link QBTQUERYParser#flwrWhereCondAp}.
	 * @param ctx the parse tree
	 */
	void exitFlwrWhereCondAp(QBTQUERYParser.FlwrWhereCondApContext ctx);
	/**
	 * Enter a parse tree produced by {@link QBTQUERYParser#flwrWhereCondEquality}.
	 * @param ctx the parse tree
	 */
	void enterFlwrWhereCondEquality(QBTQUERYParser.FlwrWhereCondEqualityContext ctx);
	/**
	 * Exit a parse tree produced by {@link QBTQUERYParser#flwrWhereCondEquality}.
	 * @param ctx the parse tree
	 */
	void exitFlwrWhereCondEquality(QBTQUERYParser.FlwrWhereCondEqualityContext ctx);
	/**
	 * Enter a parse tree produced by {@link QBTQUERYParser#flwrWhereCondEqualityLeftTerm}.
	 * @param ctx the parse tree
	 */
	void enterFlwrWhereCondEqualityLeftTerm(QBTQUERYParser.FlwrWhereCondEqualityLeftTermContext ctx);
	/**
	 * Exit a parse tree produced by {@link QBTQUERYParser#flwrWhereCondEqualityLeftTerm}.
	 * @param ctx the parse tree
	 */
	void exitFlwrWhereCondEqualityLeftTerm(QBTQUERYParser.FlwrWhereCondEqualityLeftTermContext ctx);
	/**
	 * Enter a parse tree produced by {@link QBTQUERYParser#flwrWhereCondEqualityRightTerm}.
	 * @param ctx the parse tree
	 */
	void enterFlwrWhereCondEqualityRightTerm(QBTQUERYParser.FlwrWhereCondEqualityRightTermContext ctx);
	/**
	 * Exit a parse tree produced by {@link QBTQUERYParser#flwrWhereCondEqualityRightTerm}.
	 * @param ctx the parse tree
	 */
	void exitFlwrWhereCondEqualityRightTerm(QBTQUERYParser.FlwrWhereCondEqualityRightTermContext ctx);
	/**
	 * Enter a parse tree produced by {@link QBTQUERYParser#ctermAp}.
	 * @param ctx the parse tree
	 */
	void enterCtermAp(QBTQUERYParser.CtermApContext ctx);
	/**
	 * Exit a parse tree produced by {@link QBTQUERYParser#ctermAp}.
	 * @param ctx the parse tree
	 */
	void exitCtermAp(QBTQUERYParser.CtermApContext ctx);
	/**
	 * Enter a parse tree produced by {@link QBTQUERYParser#ctermVar}.
	 * @param ctx the parse tree
	 */
	void enterCtermVar(QBTQUERYParser.CtermVarContext ctx);
	/**
	 * Exit a parse tree produced by {@link QBTQUERYParser#ctermVar}.
	 * @param ctx the parse tree
	 */
	void exitCtermVar(QBTQUERYParser.CtermVarContext ctx);
	/**
	 * Enter a parse tree produced by {@link QBTQUERYParser#ctermString}.
	 * @param ctx the parse tree
	 */
	void enterCtermString(QBTQUERYParser.CtermStringContext ctx);
	/**
	 * Exit a parse tree produced by {@link QBTQUERYParser#ctermString}.
	 * @param ctx the parse tree
	 */
	void exitCtermString(QBTQUERYParser.CtermStringContext ctx);
	/**
	 * Enter a parse tree produced by {@link QBTQUERYParser#flwrReturnVar}.
	 * @param ctx the parse tree
	 */
	void enterFlwrReturnVar(QBTQUERYParser.FlwrReturnVarContext ctx);
	/**
	 * Exit a parse tree produced by {@link QBTQUERYParser#flwrReturnVar}.
	 * @param ctx the parse tree
	 */
	void exitFlwrReturnVar(QBTQUERYParser.FlwrReturnVarContext ctx);
	/**
	 * Enter a parse tree produced by {@link QBTQUERYParser#flwrReturnString}.
	 * @param ctx the parse tree
	 */
	void enterFlwrReturnString(QBTQUERYParser.FlwrReturnStringContext ctx);
	/**
	 * Exit a parse tree produced by {@link QBTQUERYParser#flwrReturnString}.
	 * @param ctx the parse tree
	 */
	void exitFlwrReturnString(QBTQUERYParser.FlwrReturnStringContext ctx);
	/**
	 * Enter a parse tree produced by {@link QBTQUERYParser#flwrReturnConstruct}.
	 * @param ctx the parse tree
	 */
	void enterFlwrReturnConstruct(QBTQUERYParser.FlwrReturnConstructContext ctx);
	/**
	 * Exit a parse tree produced by {@link QBTQUERYParser#flwrReturnConstruct}.
	 * @param ctx the parse tree
	 */
	void exitFlwrReturnConstruct(QBTQUERYParser.FlwrReturnConstructContext ctx);
	/**
	 * Enter a parse tree produced by {@link QBTQUERYParser#rp}.
	 * @param ctx the parse tree
	 */
	void enterRp(QBTQUERYParser.RpContext ctx);
	/**
	 * Exit a parse tree produced by {@link QBTQUERYParser#rp}.
	 * @param ctx the parse tree
	 */
	void exitRp(QBTQUERYParser.RpContext ctx);
	/**
	 * Enter a parse tree produced by {@link QBTQUERYParser#child}.
	 * @param ctx the parse tree
	 */
	void enterChild(QBTQUERYParser.ChildContext ctx);
	/**
	 * Exit a parse tree produced by {@link QBTQUERYParser#child}.
	 * @param ctx the parse tree
	 */
	void exitChild(QBTQUERYParser.ChildContext ctx);
	/**
	 * Enter a parse tree produced by {@link QBTQUERYParser#desc}.
	 * @param ctx the parse tree
	 */
	void enterDesc(QBTQUERYParser.DescContext ctx);
	/**
	 * Exit a parse tree produced by {@link QBTQUERYParser#desc}.
	 * @param ctx the parse tree
	 */
	void exitDesc(QBTQUERYParser.DescContext ctx);
	/**
	 * Enter a parse tree produced by {@link QBTQUERYParser#rpTag}.
	 * @param ctx the parse tree
	 */
	void enterRpTag(QBTQUERYParser.RpTagContext ctx);
	/**
	 * Exit a parse tree produced by {@link QBTQUERYParser#rpTag}.
	 * @param ctx the parse tree
	 */
	void exitRpTag(QBTQUERYParser.RpTagContext ctx);
	/**
	 * Enter a parse tree produced by {@link QBTQUERYParser#rpAttr}.
	 * @param ctx the parse tree
	 */
	void enterRpAttr(QBTQUERYParser.RpAttrContext ctx);
	/**
	 * Exit a parse tree produced by {@link QBTQUERYParser#rpAttr}.
	 * @param ctx the parse tree
	 */
	void exitRpAttr(QBTQUERYParser.RpAttrContext ctx);
	/**
	 * Enter a parse tree produced by {@link QBTQUERYParser#rpText}.
	 * @param ctx the parse tree
	 */
	void enterRpText(QBTQUERYParser.RpTextContext ctx);
	/**
	 * Exit a parse tree produced by {@link QBTQUERYParser#rpText}.
	 * @param ctx the parse tree
	 */
	void exitRpText(QBTQUERYParser.RpTextContext ctx);
	/**
	 * Enter a parse tree produced by {@link QBTQUERYParser#ap}.
	 * @param ctx the parse tree
	 */
	void enterAp(QBTQUERYParser.ApContext ctx);
	/**
	 * Exit a parse tree produced by {@link QBTQUERYParser#ap}.
	 * @param ctx the parse tree
	 */
	void exitAp(QBTQUERYParser.ApContext ctx);
	/**
	 * Enter a parse tree produced by {@link QBTQUERYParser#document}.
	 * @param ctx the parse tree
	 */
	void enterDocument(QBTQUERYParser.DocumentContext ctx);
	/**
	 * Exit a parse tree produced by {@link QBTQUERYParser#document}.
	 * @param ctx the parse tree
	 */
	void exitDocument(QBTQUERYParser.DocumentContext ctx);
	/**
	 * Enter a parse tree produced by {@link QBTQUERYParser#sourceXQ}.
	 * @param ctx the parse tree
	 */
	void enterSourceXQ(QBTQUERYParser.SourceXQContext ctx);
	/**
	 * Exit a parse tree produced by {@link QBTQUERYParser#sourceXQ}.
	 * @param ctx the parse tree
	 */
	void exitSourceXQ(QBTQUERYParser.SourceXQContext ctx);
	/**
	 * Enter a parse tree produced by {@link QBTQUERYParser#apAttr}.
	 * @param ctx the parse tree
	 */
	void enterApAttr(QBTQUERYParser.ApAttrContext ctx);
	/**
	 * Exit a parse tree produced by {@link QBTQUERYParser#apAttr}.
	 * @param ctx the parse tree
	 */
	void exitApAttr(QBTQUERYParser.ApAttrContext ctx);
	/**
	 * Enter a parse tree produced by {@link QBTQUERYParser#p}.
	 * @param ctx the parse tree
	 */
	void enterP(QBTQUERYParser.PContext ctx);
	/**
	 * Exit a parse tree produced by {@link QBTQUERYParser#p}.
	 * @param ctx the parse tree
	 */
	void exitP(QBTQUERYParser.PContext ctx);
	/**
	 * Enter a parse tree produced by {@link QBTQUERYParser#rqQuery}.
	 * @param ctx the parse tree
	 */
	void enterRqQuery(QBTQUERYParser.RqQueryContext ctx);
	/**
	 * Exit a parse tree produced by {@link QBTQUERYParser#rqQuery}.
	 * @param ctx the parse tree
	 */
	void exitRqQuery(QBTQUERYParser.RqQueryContext ctx);
	/**
	 * Enter a parse tree produced by {@link QBTQUERYParser#sqlQuery}.
	 * @param ctx the parse tree
	 */
	void enterSqlQuery(QBTQUERYParser.SqlQueryContext ctx);
	/**
	 * Exit a parse tree produced by {@link QBTQUERYParser#sqlQuery}.
	 * @param ctx the parse tree
	 */
	void exitSqlQuery(QBTQUERYParser.SqlQueryContext ctx);
	/**
	 * Enter a parse tree produced by {@link QBTQUERYParser#sfwQueryRQ}.
	 * @param ctx the parse tree
	 */
	void enterSfwQueryRQ(QBTQUERYParser.SfwQueryRQContext ctx);
	/**
	 * Exit a parse tree produced by {@link QBTQUERYParser#sfwQueryRQ}.
	 * @param ctx the parse tree
	 */
	void exitSfwQueryRQ(QBTQUERYParser.SfwQueryRQContext ctx);
	/**
	 * Enter a parse tree produced by {@link QBTQUERYParser#fromWhereClausesRQ}.
	 * @param ctx the parse tree
	 */
	void enterFromWhereClausesRQ(QBTQUERYParser.FromWhereClausesRQContext ctx);
	/**
	 * Exit a parse tree produced by {@link QBTQUERYParser#fromWhereClausesRQ}.
	 * @param ctx the parse tree
	 */
	void exitFromWhereClausesRQ(QBTQUERYParser.FromWhereClausesRQContext ctx);
	/**
	 * Enter a parse tree produced by {@link QBTQUERYParser#selectClauseRQ}.
	 * @param ctx the parse tree
	 */
	void enterSelectClauseRQ(QBTQUERYParser.SelectClauseRQContext ctx);
	/**
	 * Exit a parse tree produced by {@link QBTQUERYParser#selectClauseRQ}.
	 * @param ctx the parse tree
	 */
	void exitSelectClauseRQ(QBTQUERYParser.SelectClauseRQContext ctx);
	/**
	 * Enter a parse tree produced by {@link QBTQUERYParser#selectStatementRQ}.
	 * @param ctx the parse tree
	 */
	void enterSelectStatementRQ(QBTQUERYParser.SelectStatementRQContext ctx);
	/**
	 * Exit a parse tree produced by {@link QBTQUERYParser#selectStatementRQ}.
	 * @param ctx the parse tree
	 */
	void exitSelectStatementRQ(QBTQUERYParser.SelectStatementRQContext ctx);
	/**
	 * Enter a parse tree produced by {@link QBTQUERYParser#selectItemRQ}.
	 * @param ctx the parse tree
	 */
	void enterSelectItemRQ(QBTQUERYParser.SelectItemRQContext ctx);
	/**
	 * Exit a parse tree produced by {@link QBTQUERYParser#selectItemRQ}.
	 * @param ctx the parse tree
	 */
	void exitSelectItemRQ(QBTQUERYParser.SelectItemRQContext ctx);
	/**
	 * Enter a parse tree produced by {@link QBTQUERYParser#fromClauseRQ}.
	 * @param ctx the parse tree
	 */
	void enterFromClauseRQ(QBTQUERYParser.FromClauseRQContext ctx);
	/**
	 * Exit a parse tree produced by {@link QBTQUERYParser#fromClauseRQ}.
	 * @param ctx the parse tree
	 */
	void exitFromClauseRQ(QBTQUERYParser.FromClauseRQContext ctx);
	/**
	 * Enter a parse tree produced by {@link QBTQUERYParser#relationBinding}.
	 * @param ctx the parse tree
	 */
	void enterRelationBinding(QBTQUERYParser.RelationBindingContext ctx);
	/**
	 * Exit a parse tree produced by {@link QBTQUERYParser#relationBinding}.
	 * @param ctx the parse tree
	 */
	void exitRelationBinding(QBTQUERYParser.RelationBindingContext ctx);
	/**
	 * Enter a parse tree produced by {@link QBTQUERYParser#source}.
	 * @param ctx the parse tree
	 */
	void enterSource(QBTQUERYParser.SourceContext ctx);
	/**
	 * Exit a parse tree produced by {@link QBTQUERYParser#source}.
	 * @param ctx the parse tree
	 */
	void exitSource(QBTQUERYParser.SourceContext ctx);
	/**
	 * Enter a parse tree produced by {@link QBTQUERYParser#relationName}.
	 * @param ctx the parse tree
	 */
	void enterRelationName(QBTQUERYParser.RelationNameContext ctx);
	/**
	 * Exit a parse tree produced by {@link QBTQUERYParser#relationName}.
	 * @param ctx the parse tree
	 */
	void exitRelationName(QBTQUERYParser.RelationNameContext ctx);
	/**
	 * Enter a parse tree produced by {@link QBTQUERYParser#variableKQ}.
	 * @param ctx the parse tree
	 */
	void enterVariableKQ(QBTQUERYParser.VariableKQContext ctx);
	/**
	 * Exit a parse tree produced by {@link QBTQUERYParser#variableKQ}.
	 * @param ctx the parse tree
	 */
	void exitVariableKQ(QBTQUERYParser.VariableKQContext ctx);
	/**
	 * Enter a parse tree produced by {@link QBTQUERYParser#whereClauseRQ}.
	 * @param ctx the parse tree
	 */
	void enterWhereClauseRQ(QBTQUERYParser.WhereClauseRQContext ctx);
	/**
	 * Exit a parse tree produced by {@link QBTQUERYParser#whereClauseRQ}.
	 * @param ctx the parse tree
	 */
	void exitWhereClauseRQ(QBTQUERYParser.WhereClauseRQContext ctx);
	/**
	 * Enter a parse tree produced by {@link QBTQUERYParser#whereStatementRQ}.
	 * @param ctx the parse tree
	 */
	void enterWhereStatementRQ(QBTQUERYParser.WhereStatementRQContext ctx);
	/**
	 * Exit a parse tree produced by {@link QBTQUERYParser#whereStatementRQ}.
	 * @param ctx the parse tree
	 */
	void exitWhereStatementRQ(QBTQUERYParser.WhereStatementRQContext ctx);
	/**
	 * Enter a parse tree produced by {@link QBTQUERYParser#conditionRQ}.
	 * @param ctx the parse tree
	 */
	void enterConditionRQ(QBTQUERYParser.ConditionRQContext ctx);
	/**
	 * Exit a parse tree produced by {@link QBTQUERYParser#conditionRQ}.
	 * @param ctx the parse tree
	 */
	void exitConditionRQ(QBTQUERYParser.ConditionRQContext ctx);
	/**
	 * Enter a parse tree produced by {@link QBTQUERYParser#termRQ}.
	 * @param ctx the parse tree
	 */
	void enterTermRQ(QBTQUERYParser.TermRQContext ctx);
	/**
	 * Exit a parse tree produced by {@link QBTQUERYParser#termRQ}.
	 * @param ctx the parse tree
	 */
	void exitTermRQ(QBTQUERYParser.TermRQContext ctx);
	/**
	 * Enter a parse tree produced by {@link QBTQUERYParser#equality}.
	 * @param ctx the parse tree
	 */
	void enterEquality(QBTQUERYParser.EqualityContext ctx);
	/**
	 * Exit a parse tree produced by {@link QBTQUERYParser#equality}.
	 * @param ctx the parse tree
	 */
	void exitEquality(QBTQUERYParser.EqualityContext ctx);
	/**
	 * Enter a parse tree produced by {@link QBTQUERYParser#likeExpression}.
	 * @param ctx the parse tree
	 */
	void enterLikeExpression(QBTQUERYParser.LikeExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link QBTQUERYParser#likeExpression}.
	 * @param ctx the parse tree
	 */
	void exitLikeExpression(QBTQUERYParser.LikeExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link QBTQUERYParser#lefttermRQ}.
	 * @param ctx the parse tree
	 */
	void enterLefttermRQ(QBTQUERYParser.LefttermRQContext ctx);
	/**
	 * Exit a parse tree produced by {@link QBTQUERYParser#lefttermRQ}.
	 * @param ctx the parse tree
	 */
	void exitLefttermRQ(QBTQUERYParser.LefttermRQContext ctx);
	/**
	 * Enter a parse tree produced by {@link QBTQUERYParser#righttermRQ}.
	 * @param ctx the parse tree
	 */
	void enterRighttermRQ(QBTQUERYParser.RighttermRQContext ctx);
	/**
	 * Exit a parse tree produced by {@link QBTQUERYParser#righttermRQ}.
	 * @param ctx the parse tree
	 */
	void exitRighttermRQ(QBTQUERYParser.RighttermRQContext ctx);
	/**
	 * Enter a parse tree produced by {@link QBTQUERYParser#realtion}.
	 * @param ctx the parse tree
	 */
	void enterRealtion(QBTQUERYParser.RealtionContext ctx);
	/**
	 * Exit a parse tree produced by {@link QBTQUERYParser#realtion}.
	 * @param ctx the parse tree
	 */
	void exitRealtion(QBTQUERYParser.RealtionContext ctx);
}