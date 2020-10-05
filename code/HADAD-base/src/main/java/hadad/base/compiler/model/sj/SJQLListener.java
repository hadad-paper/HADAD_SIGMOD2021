// Generated from SJQL.g4 by ANTLR 4.4

package hadad.base.compiler.model.sj;

import org.antlr.v4.runtime.misc.NotNull;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link SJQLParser}.
 */
public interface SJQLListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link SJQLParser#sjRightTerm}.
	 * @param ctx the parse tree
	 */
	void enterSjRightTerm(@NotNull SJQLParser.SjRightTermContext ctx);
	/**
	 * Exit a parse tree produced by {@link SJQLParser#sjRightTerm}.
	 * @param ctx the parse tree
	 */
	void exitSjRightTerm(@NotNull SJQLParser.SjRightTermContext ctx);
	/**
	 * Enter a parse tree produced by {@link SJQLParser#sjqlquery}.
	 * @param ctx the parse tree
	 */
	void enterSjqlquery(@NotNull SJQLParser.SjqlqueryContext ctx);
	/**
	 * Exit a parse tree produced by {@link SJQLParser#sjqlquery}.
	 * @param ctx the parse tree
	 */
	void exitSjqlquery(@NotNull SJQLParser.SjqlqueryContext ctx);
	/**
	 * Enter a parse tree produced by {@link SJQLParser#sjFieldValue}.
	 * @param ctx the parse tree
	 */
	void enterSjFieldValue(@NotNull SJQLParser.SjFieldValueContext ctx);
	/**
	 * Exit a parse tree produced by {@link SJQLParser#sjFieldValue}.
	 * @param ctx the parse tree
	 */
	void exitSjFieldValue(@NotNull SJQLParser.SjFieldValueContext ctx);
	/**
	 * Enter a parse tree produced by {@link SJQLParser#sjKeyName}.
	 * @param ctx the parse tree
	 */
	void enterSjKeyName(@NotNull SJQLParser.SjKeyNameContext ctx);
	/**
	 * Exit a parse tree produced by {@link SJQLParser#sjKeyName}.
	 * @param ctx the parse tree
	 */
	void exitSjKeyName(@NotNull SJQLParser.SjKeyNameContext ctx);
	/**
	 * Enter a parse tree produced by {@link SJQLParser#sjRecordConstruct}.
	 * @param ctx the parse tree
	 */
	void enterSjRecordConstruct(@NotNull SJQLParser.SjRecordConstructContext ctx);
	/**
	 * Exit a parse tree produced by {@link SJQLParser#sjRecordConstruct}.
	 * @param ctx the parse tree
	 */
	void exitSjRecordConstruct(@NotNull SJQLParser.SjRecordConstructContext ctx);
	/**
	 * Enter a parse tree produced by {@link SJQLParser#sjQuery}.
	 * @param ctx the parse tree
	 */
	void enterSjQuery(@NotNull SJQLParser.SjQueryContext ctx);
	/**
	 * Exit a parse tree produced by {@link SJQLParser#sjQuery}.
	 * @param ctx the parse tree
	 */
	void exitSjQuery(@NotNull SJQLParser.SjQueryContext ctx);
	/**
	 * Enter a parse tree produced by {@link SJQLParser#sjProjectFields}.
	 * @param ctx the parse tree
	 */
	void enterSjProjectFields(@NotNull SJQLParser.SjProjectFieldsContext ctx);
	/**
	 * Exit a parse tree produced by {@link SJQLParser#sjProjectFields}.
	 * @param ctx the parse tree
	 */
	void exitSjProjectFields(@NotNull SJQLParser.SjProjectFieldsContext ctx);
	/**
	 * Enter a parse tree produced by {@link SJQLParser#sjCollectionName}.
	 * @param ctx the parse tree
	 */
	void enterSjCollectionName(@NotNull SJQLParser.SjCollectionNameContext ctx);
	/**
	 * Exit a parse tree produced by {@link SJQLParser#sjCollectionName}.
	 * @param ctx the parse tree
	 */
	void exitSjCollectionName(@NotNull SJQLParser.SjCollectionNameContext ctx);
	/**
	 * Enter a parse tree produced by {@link SJQLParser#sjConstant}.
	 * @param ctx the parse tree
	 */
	void enterSjConstant(@NotNull SJQLParser.SjConstantContext ctx);
	/**
	 * Exit a parse tree produced by {@link SJQLParser#sjConstant}.
	 * @param ctx the parse tree
	 */
	void exitSjConstant(@NotNull SJQLParser.SjConstantContext ctx);
	/**
	 * Enter a parse tree produced by {@link SJQLParser#sjLeftTerm}.
	 * @param ctx the parse tree
	 */
	void enterSjLeftTerm(@NotNull SJQLParser.SjLeftTermContext ctx);
	/**
	 * Exit a parse tree produced by {@link SJQLParser#sjLeftTerm}.
	 * @param ctx the parse tree
	 */
	void exitSjLeftTerm(@NotNull SJQLParser.SjLeftTermContext ctx);
	/**
	 * Enter a parse tree produced by {@link SJQLParser#sjFieldName}.
	 * @param ctx the parse tree
	 */
	void enterSjFieldName(@NotNull SJQLParser.SjFieldNameContext ctx);
	/**
	 * Exit a parse tree produced by {@link SJQLParser#sjFieldName}.
	 * @param ctx the parse tree
	 */
	void exitSjFieldName(@NotNull SJQLParser.SjFieldNameContext ctx);
	/**
	 * Enter a parse tree produced by {@link SJQLParser#viewName}.
	 * @param ctx the parse tree
	 */
	void enterViewName(@NotNull SJQLParser.ViewNameContext ctx);
	/**
	 * Exit a parse tree produced by {@link SJQLParser#viewName}.
	 * @param ctx the parse tree
	 */
	void exitViewName(@NotNull SJQLParser.ViewNameContext ctx);
	/**
	 * Enter a parse tree produced by {@link SJQLParser#sjFieldBinding}.
	 * @param ctx the parse tree
	 */
	void enterSjFieldBinding(@NotNull SJQLParser.SjFieldBindingContext ctx);
	/**
	 * Exit a parse tree produced by {@link SJQLParser#sjFieldBinding}.
	 * @param ctx the parse tree
	 */
	void exitSjFieldBinding(@NotNull SJQLParser.SjFieldBindingContext ctx);
	/**
	 * Enter a parse tree produced by {@link SJQLParser#sjVar}.
	 * @param ctx the parse tree
	 */
	void enterSjVar(@NotNull SJQLParser.SjVarContext ctx);
	/**
	 * Exit a parse tree produced by {@link SJQLParser#sjVar}.
	 * @param ctx the parse tree
	 */
	void exitSjVar(@NotNull SJQLParser.SjVarContext ctx);
	/**
	 * Enter a parse tree produced by {@link SJQLParser#sjTerm}.
	 * @param ctx the parse tree
	 */
	void enterSjTerm(@NotNull SJQLParser.SjTermContext ctx);
	/**
	 * Exit a parse tree produced by {@link SJQLParser#sjTerm}.
	 * @param ctx the parse tree
	 */
	void exitSjTerm(@NotNull SJQLParser.SjTermContext ctx);
	/**
	 * Enter a parse tree produced by {@link SJQLParser#sjTextSearch}.
	 * @param ctx the parse tree
	 */
	void enterSjTextSearch(@NotNull SJQLParser.SjTextSearchContext ctx);
	/**
	 * Exit a parse tree produced by {@link SJQLParser#sjTextSearch}.
	 * @param ctx the parse tree
	 */
	void exitSjTextSearch(@NotNull SJQLParser.SjTextSearchContext ctx);
	/**
	 * Enter a parse tree produced by {@link SJQLParser#sjRecordConstructFieldName}.
	 * @param ctx the parse tree
	 */
	void enterSjRecordConstructFieldName(@NotNull SJQLParser.SjRecordConstructFieldNameContext ctx);
	/**
	 * Exit a parse tree produced by {@link SJQLParser#sjRecordConstructFieldName}.
	 * @param ctx the parse tree
	 */
	void exitSjRecordConstructFieldName(@NotNull SJQLParser.SjRecordConstructFieldNameContext ctx);
}