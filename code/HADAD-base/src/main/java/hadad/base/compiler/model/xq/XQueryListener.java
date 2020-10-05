// Generated from XQuery.g4 by ANTLR 4.5.3

package hadad.base.compiler.model.xq;

import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link XQueryParser}.
 */
public interface XQueryListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link XQueryParser#xquery}.
	 * @param ctx the parse tree
	 */
	void enterXquery(XQueryParser.XqueryContext ctx);
	/**
	 * Exit a parse tree produced by {@link XQueryParser#xquery}.
	 * @param ctx the parse tree
	 */
	void exitXquery(XQueryParser.XqueryContext ctx);
	/**
	 * Enter a parse tree produced by {@link XQueryParser#viewName}.
	 * @param ctx the parse tree
	 */
	void enterViewName(XQueryParser.ViewNameContext ctx);
	/**
	 * Exit a parse tree produced by {@link XQueryParser#viewName}.
	 * @param ctx the parse tree
	 */
	void exitViewName(XQueryParser.ViewNameContext ctx);
	/**
	 * Enter a parse tree produced by {@link XQueryParser#openRootTag}.
	 * @param ctx the parse tree
	 */
	void enterOpenRootTag(XQueryParser.OpenRootTagContext ctx);
	/**
	 * Exit a parse tree produced by {@link XQueryParser#openRootTag}.
	 * @param ctx the parse tree
	 */
	void exitOpenRootTag(XQueryParser.OpenRootTagContext ctx);
	/**
	 * Enter a parse tree produced by {@link XQueryParser#closeRootTag}.
	 * @param ctx the parse tree
	 */
	void enterCloseRootTag(XQueryParser.CloseRootTagContext ctx);
	/**
	 * Exit a parse tree produced by {@link XQueryParser#closeRootTag}.
	 * @param ctx the parse tree
	 */
	void exitCloseRootTag(XQueryParser.CloseRootTagContext ctx);
	/**
	 * Enter a parse tree produced by {@link XQueryParser#construct}.
	 * @param ctx the parse tree
	 */
	void enterConstruct(XQueryParser.ConstructContext ctx);
	/**
	 * Exit a parse tree produced by {@link XQueryParser#construct}.
	 * @param ctx the parse tree
	 */
	void exitConstruct(XQueryParser.ConstructContext ctx);
	/**
	 * Enter a parse tree produced by {@link XQueryParser#constructEmptyTag}.
	 * @param ctx the parse tree
	 */
	void enterConstructEmptyTag(XQueryParser.ConstructEmptyTagContext ctx);
	/**
	 * Exit a parse tree produced by {@link XQueryParser#constructEmptyTag}.
	 * @param ctx the parse tree
	 */
	void exitConstructEmptyTag(XQueryParser.ConstructEmptyTagContext ctx);
	/**
	 * Enter a parse tree produced by {@link XQueryParser#constructString}.
	 * @param ctx the parse tree
	 */
	void enterConstructString(XQueryParser.ConstructStringContext ctx);
	/**
	 * Exit a parse tree produced by {@link XQueryParser#constructString}.
	 * @param ctx the parse tree
	 */
	void exitConstructString(XQueryParser.ConstructStringContext ctx);
	/**
	 * Enter a parse tree produced by {@link XQueryParser#constructVar}.
	 * @param ctx the parse tree
	 */
	void enterConstructVar(XQueryParser.ConstructVarContext ctx);
	/**
	 * Exit a parse tree produced by {@link XQueryParser#constructVar}.
	 * @param ctx the parse tree
	 */
	void exitConstructVar(XQueryParser.ConstructVarContext ctx);
	/**
	 * Enter a parse tree produced by {@link XQueryParser#constructFlwr}.
	 * @param ctx the parse tree
	 */
	void enterConstructFlwr(XQueryParser.ConstructFlwrContext ctx);
	/**
	 * Exit a parse tree produced by {@link XQueryParser#constructFlwr}.
	 * @param ctx the parse tree
	 */
	void exitConstructFlwr(XQueryParser.ConstructFlwrContext ctx);
	/**
	 * Enter a parse tree produced by {@link XQueryParser#constructFlwrTerm}.
	 * @param ctx the parse tree
	 */
	void enterConstructFlwrTerm(XQueryParser.ConstructFlwrTermContext ctx);
	/**
	 * Exit a parse tree produced by {@link XQueryParser#constructFlwrTerm}.
	 * @param ctx the parse tree
	 */
	void exitConstructFlwrTerm(XQueryParser.ConstructFlwrTermContext ctx);
	/**
	 * Enter a parse tree produced by {@link XQueryParser#constructDelimeter}.
	 * @param ctx the parse tree
	 */
	void enterConstructDelimeter(XQueryParser.ConstructDelimeterContext ctx);
	/**
	 * Exit a parse tree produced by {@link XQueryParser#constructDelimeter}.
	 * @param ctx the parse tree
	 */
	void exitConstructDelimeter(XQueryParser.ConstructDelimeterContext ctx);
	/**
	 * Enter a parse tree produced by {@link XQueryParser#constructFlwrOpenTag}.
	 * @param ctx the parse tree
	 */
	void enterConstructFlwrOpenTag(XQueryParser.ConstructFlwrOpenTagContext ctx);
	/**
	 * Exit a parse tree produced by {@link XQueryParser#constructFlwrOpenTag}.
	 * @param ctx the parse tree
	 */
	void exitConstructFlwrOpenTag(XQueryParser.ConstructFlwrOpenTagContext ctx);
	/**
	 * Enter a parse tree produced by {@link XQueryParser#constructFlwrCloseTag}.
	 * @param ctx the parse tree
	 */
	void enterConstructFlwrCloseTag(XQueryParser.ConstructFlwrCloseTagContext ctx);
	/**
	 * Exit a parse tree produced by {@link XQueryParser#constructFlwrCloseTag}.
	 * @param ctx the parse tree
	 */
	void exitConstructFlwrCloseTag(XQueryParser.ConstructFlwrCloseTagContext ctx);
	/**
	 * Enter a parse tree produced by {@link XQueryParser#tag}.
	 * @param ctx the parse tree
	 */
	void enterTag(XQueryParser.TagContext ctx);
	/**
	 * Exit a parse tree produced by {@link XQueryParser#tag}.
	 * @param ctx the parse tree
	 */
	void exitTag(XQueryParser.TagContext ctx);
	/**
	 * Enter a parse tree produced by {@link XQueryParser#mkattr}.
	 * @param ctx the parse tree
	 */
	void enterMkattr(XQueryParser.MkattrContext ctx);
	/**
	 * Exit a parse tree produced by {@link XQueryParser#mkattr}.
	 * @param ctx the parse tree
	 */
	void exitMkattr(XQueryParser.MkattrContext ctx);
	/**
	 * Enter a parse tree produced by {@link XQueryParser#mkattrName}.
	 * @param ctx the parse tree
	 */
	void enterMkattrName(XQueryParser.MkattrNameContext ctx);
	/**
	 * Exit a parse tree produced by {@link XQueryParser#mkattrName}.
	 * @param ctx the parse tree
	 */
	void exitMkattrName(XQueryParser.MkattrNameContext ctx);
	/**
	 * Enter a parse tree produced by {@link XQueryParser#string}.
	 * @param ctx the parse tree
	 */
	void enterString(XQueryParser.StringContext ctx);
	/**
	 * Exit a parse tree produced by {@link XQueryParser#string}.
	 * @param ctx the parse tree
	 */
	void exitString(XQueryParser.StringContext ctx);
	/**
	 * Enter a parse tree produced by {@link XQueryParser#name}.
	 * @param ctx the parse tree
	 */
	void enterName(XQueryParser.NameContext ctx);
	/**
	 * Exit a parse tree produced by {@link XQueryParser#name}.
	 * @param ctx the parse tree
	 */
	void exitName(XQueryParser.NameContext ctx);
	/**
	 * Enter a parse tree produced by {@link XQueryParser#aterm}.
	 * @param ctx the parse tree
	 */
	void enterAterm(XQueryParser.AtermContext ctx);
	/**
	 * Exit a parse tree produced by {@link XQueryParser#aterm}.
	 * @param ctx the parse tree
	 */
	void exitAterm(XQueryParser.AtermContext ctx);
	/**
	 * Enter a parse tree produced by {@link XQueryParser#atermVar}.
	 * @param ctx the parse tree
	 */
	void enterAtermVar(XQueryParser.AtermVarContext ctx);
	/**
	 * Exit a parse tree produced by {@link XQueryParser#atermVar}.
	 * @param ctx the parse tree
	 */
	void exitAtermVar(XQueryParser.AtermVarContext ctx);
	/**
	 * Enter a parse tree produced by {@link XQueryParser#atermString}.
	 * @param ctx the parse tree
	 */
	void enterAtermString(XQueryParser.AtermStringContext ctx);
	/**
	 * Exit a parse tree produced by {@link XQueryParser#atermString}.
	 * @param ctx the parse tree
	 */
	void exitAtermString(XQueryParser.AtermStringContext ctx);
	/**
	 * Enter a parse tree produced by {@link XQueryParser#var}.
	 * @param ctx the parse tree
	 */
	void enterVar(XQueryParser.VarContext ctx);
	/**
	 * Exit a parse tree produced by {@link XQueryParser#var}.
	 * @param ctx the parse tree
	 */
	void exitVar(XQueryParser.VarContext ctx);
	/**
	 * Enter a parse tree produced by {@link XQueryParser#flwr}.
	 * @param ctx the parse tree
	 */
	void enterFlwr(XQueryParser.FlwrContext ctx);
	/**
	 * Exit a parse tree produced by {@link XQueryParser#flwr}.
	 * @param ctx the parse tree
	 */
	void exitFlwr(XQueryParser.FlwrContext ctx);
	/**
	 * Enter a parse tree produced by {@link XQueryParser#flwrFor}.
	 * @param ctx the parse tree
	 */
	void enterFlwrFor(XQueryParser.FlwrForContext ctx);
	/**
	 * Exit a parse tree produced by {@link XQueryParser#flwrFor}.
	 * @param ctx the parse tree
	 */
	void exitFlwrFor(XQueryParser.FlwrForContext ctx);
	/**
	 * Enter a parse tree produced by {@link XQueryParser#flwrWhere}.
	 * @param ctx the parse tree
	 */
	void enterFlwrWhere(XQueryParser.FlwrWhereContext ctx);
	/**
	 * Exit a parse tree produced by {@link XQueryParser#flwrWhere}.
	 * @param ctx the parse tree
	 */
	void exitFlwrWhere(XQueryParser.FlwrWhereContext ctx);
	/**
	 * Enter a parse tree produced by {@link XQueryParser#flwrReturn}.
	 * @param ctx the parse tree
	 */
	void enterFlwrReturn(XQueryParser.FlwrReturnContext ctx);
	/**
	 * Exit a parse tree produced by {@link XQueryParser#flwrReturn}.
	 * @param ctx the parse tree
	 */
	void exitFlwrReturn(XQueryParser.FlwrReturnContext ctx);
	/**
	 * Enter a parse tree produced by {@link XQueryParser#flwrForWhere}.
	 * @param ctx the parse tree
	 */
	void enterFlwrForWhere(XQueryParser.FlwrForWhereContext ctx);
	/**
	 * Exit a parse tree produced by {@link XQueryParser#flwrForWhere}.
	 * @param ctx the parse tree
	 */
	void exitFlwrForWhere(XQueryParser.FlwrForWhereContext ctx);
	/**
	 * Enter a parse tree produced by {@link XQueryParser#flwrForVar}.
	 * @param ctx the parse tree
	 */
	void enterFlwrForVar(XQueryParser.FlwrForVarContext ctx);
	/**
	 * Exit a parse tree produced by {@link XQueryParser#flwrForVar}.
	 * @param ctx the parse tree
	 */
	void exitFlwrForVar(XQueryParser.FlwrForVarContext ctx);
	/**
	 * Enter a parse tree produced by {@link XQueryParser#flwrForP}.
	 * @param ctx the parse tree
	 */
	void enterFlwrForP(XQueryParser.FlwrForPContext ctx);
	/**
	 * Exit a parse tree produced by {@link XQueryParser#flwrForP}.
	 * @param ctx the parse tree
	 */
	void exitFlwrForP(XQueryParser.FlwrForPContext ctx);
	/**
	 * Enter a parse tree produced by {@link XQueryParser#flwrWhereCond}.
	 * @param ctx the parse tree
	 */
	void enterFlwrWhereCond(XQueryParser.FlwrWhereCondContext ctx);
	/**
	 * Exit a parse tree produced by {@link XQueryParser#flwrWhereCond}.
	 * @param ctx the parse tree
	 */
	void exitFlwrWhereCond(XQueryParser.FlwrWhereCondContext ctx);
	/**
	 * Enter a parse tree produced by {@link XQueryParser#flwrWhereCondSome}.
	 * @param ctx the parse tree
	 */
	void enterFlwrWhereCondSome(XQueryParser.FlwrWhereCondSomeContext ctx);
	/**
	 * Exit a parse tree produced by {@link XQueryParser#flwrWhereCondSome}.
	 * @param ctx the parse tree
	 */
	void exitFlwrWhereCondSome(XQueryParser.FlwrWhereCondSomeContext ctx);
	/**
	 * Enter a parse tree produced by {@link XQueryParser#flwrWhereCondVar}.
	 * @param ctx the parse tree
	 */
	void enterFlwrWhereCondVar(XQueryParser.FlwrWhereCondVarContext ctx);
	/**
	 * Exit a parse tree produced by {@link XQueryParser#flwrWhereCondVar}.
	 * @param ctx the parse tree
	 */
	void exitFlwrWhereCondVar(XQueryParser.FlwrWhereCondVarContext ctx);
	/**
	 * Enter a parse tree produced by {@link XQueryParser#flwrWhereCondAp}.
	 * @param ctx the parse tree
	 */
	void enterFlwrWhereCondAp(XQueryParser.FlwrWhereCondApContext ctx);
	/**
	 * Exit a parse tree produced by {@link XQueryParser#flwrWhereCondAp}.
	 * @param ctx the parse tree
	 */
	void exitFlwrWhereCondAp(XQueryParser.FlwrWhereCondApContext ctx);
	/**
	 * Enter a parse tree produced by {@link XQueryParser#flwrWhereCondEquality}.
	 * @param ctx the parse tree
	 */
	void enterFlwrWhereCondEquality(XQueryParser.FlwrWhereCondEqualityContext ctx);
	/**
	 * Exit a parse tree produced by {@link XQueryParser#flwrWhereCondEquality}.
	 * @param ctx the parse tree
	 */
	void exitFlwrWhereCondEquality(XQueryParser.FlwrWhereCondEqualityContext ctx);
	/**
	 * Enter a parse tree produced by {@link XQueryParser#flwrWhereCondEqualityLeftTerm}.
	 * @param ctx the parse tree
	 */
	void enterFlwrWhereCondEqualityLeftTerm(XQueryParser.FlwrWhereCondEqualityLeftTermContext ctx);
	/**
	 * Exit a parse tree produced by {@link XQueryParser#flwrWhereCondEqualityLeftTerm}.
	 * @param ctx the parse tree
	 */
	void exitFlwrWhereCondEqualityLeftTerm(XQueryParser.FlwrWhereCondEqualityLeftTermContext ctx);
	/**
	 * Enter a parse tree produced by {@link XQueryParser#flwrWhereCondEqualityRightTerm}.
	 * @param ctx the parse tree
	 */
	void enterFlwrWhereCondEqualityRightTerm(XQueryParser.FlwrWhereCondEqualityRightTermContext ctx);
	/**
	 * Exit a parse tree produced by {@link XQueryParser#flwrWhereCondEqualityRightTerm}.
	 * @param ctx the parse tree
	 */
	void exitFlwrWhereCondEqualityRightTerm(XQueryParser.FlwrWhereCondEqualityRightTermContext ctx);
	/**
	 * Enter a parse tree produced by {@link XQueryParser#cterm}.
	 * @param ctx the parse tree
	 */
	void enterCterm(XQueryParser.CtermContext ctx);
	/**
	 * Exit a parse tree produced by {@link XQueryParser#cterm}.
	 * @param ctx the parse tree
	 */
	void exitCterm(XQueryParser.CtermContext ctx);
	/**
	 * Enter a parse tree produced by {@link XQueryParser#ctermAp}.
	 * @param ctx the parse tree
	 */
	void enterCtermAp(XQueryParser.CtermApContext ctx);
	/**
	 * Exit a parse tree produced by {@link XQueryParser#ctermAp}.
	 * @param ctx the parse tree
	 */
	void exitCtermAp(XQueryParser.CtermApContext ctx);
	/**
	 * Enter a parse tree produced by {@link XQueryParser#ctermVar}.
	 * @param ctx the parse tree
	 */
	void enterCtermVar(XQueryParser.CtermVarContext ctx);
	/**
	 * Exit a parse tree produced by {@link XQueryParser#ctermVar}.
	 * @param ctx the parse tree
	 */
	void exitCtermVar(XQueryParser.CtermVarContext ctx);
	/**
	 * Enter a parse tree produced by {@link XQueryParser#ctermString}.
	 * @param ctx the parse tree
	 */
	void enterCtermString(XQueryParser.CtermStringContext ctx);
	/**
	 * Exit a parse tree produced by {@link XQueryParser#ctermString}.
	 * @param ctx the parse tree
	 */
	void exitCtermString(XQueryParser.CtermStringContext ctx);
	/**
	 * Enter a parse tree produced by {@link XQueryParser#flwrReturnVar}.
	 * @param ctx the parse tree
	 */
	void enterFlwrReturnVar(XQueryParser.FlwrReturnVarContext ctx);
	/**
	 * Exit a parse tree produced by {@link XQueryParser#flwrReturnVar}.
	 * @param ctx the parse tree
	 */
	void exitFlwrReturnVar(XQueryParser.FlwrReturnVarContext ctx);
	/**
	 * Enter a parse tree produced by {@link XQueryParser#flwrReturnString}.
	 * @param ctx the parse tree
	 */
	void enterFlwrReturnString(XQueryParser.FlwrReturnStringContext ctx);
	/**
	 * Exit a parse tree produced by {@link XQueryParser#flwrReturnString}.
	 * @param ctx the parse tree
	 */
	void exitFlwrReturnString(XQueryParser.FlwrReturnStringContext ctx);
	/**
	 * Enter a parse tree produced by {@link XQueryParser#flwrReturnConstruct}.
	 * @param ctx the parse tree
	 */
	void enterFlwrReturnConstruct(XQueryParser.FlwrReturnConstructContext ctx);
	/**
	 * Exit a parse tree produced by {@link XQueryParser#flwrReturnConstruct}.
	 * @param ctx the parse tree
	 */
	void exitFlwrReturnConstruct(XQueryParser.FlwrReturnConstructContext ctx);
	/**
	 * Enter a parse tree produced by {@link XQueryParser#rp}.
	 * @param ctx the parse tree
	 */
	void enterRp(XQueryParser.RpContext ctx);
	/**
	 * Exit a parse tree produced by {@link XQueryParser#rp}.
	 * @param ctx the parse tree
	 */
	void exitRp(XQueryParser.RpContext ctx);
	/**
	 * Enter a parse tree produced by {@link XQueryParser#child}.
	 * @param ctx the parse tree
	 */
	void enterChild(XQueryParser.ChildContext ctx);
	/**
	 * Exit a parse tree produced by {@link XQueryParser#child}.
	 * @param ctx the parse tree
	 */
	void exitChild(XQueryParser.ChildContext ctx);
	/**
	 * Enter a parse tree produced by {@link XQueryParser#desc}.
	 * @param ctx the parse tree
	 */
	void enterDesc(XQueryParser.DescContext ctx);
	/**
	 * Exit a parse tree produced by {@link XQueryParser#desc}.
	 * @param ctx the parse tree
	 */
	void exitDesc(XQueryParser.DescContext ctx);
	/**
	 * Enter a parse tree produced by {@link XQueryParser#rpTag}.
	 * @param ctx the parse tree
	 */
	void enterRpTag(XQueryParser.RpTagContext ctx);
	/**
	 * Exit a parse tree produced by {@link XQueryParser#rpTag}.
	 * @param ctx the parse tree
	 */
	void exitRpTag(XQueryParser.RpTagContext ctx);
	/**
	 * Enter a parse tree produced by {@link XQueryParser#rpAttr}.
	 * @param ctx the parse tree
	 */
	void enterRpAttr(XQueryParser.RpAttrContext ctx);
	/**
	 * Exit a parse tree produced by {@link XQueryParser#rpAttr}.
	 * @param ctx the parse tree
	 */
	void exitRpAttr(XQueryParser.RpAttrContext ctx);
	/**
	 * Enter a parse tree produced by {@link XQueryParser#rpText}.
	 * @param ctx the parse tree
	 */
	void enterRpText(XQueryParser.RpTextContext ctx);
	/**
	 * Exit a parse tree produced by {@link XQueryParser#rpText}.
	 * @param ctx the parse tree
	 */
	void exitRpText(XQueryParser.RpTextContext ctx);
	/**
	 * Enter a parse tree produced by {@link XQueryParser#rpDot}.
	 * @param ctx the parse tree
	 */
	void enterRpDot(XQueryParser.RpDotContext ctx);
	/**
	 * Exit a parse tree produced by {@link XQueryParser#rpDot}.
	 * @param ctx the parse tree
	 */
	void exitRpDot(XQueryParser.RpDotContext ctx);
	/**
	 * Enter a parse tree produced by {@link XQueryParser#ap}.
	 * @param ctx the parse tree
	 */
	void enterAp(XQueryParser.ApContext ctx);
	/**
	 * Exit a parse tree produced by {@link XQueryParser#ap}.
	 * @param ctx the parse tree
	 */
	void exitAp(XQueryParser.ApContext ctx);
	/**
	 * Enter a parse tree produced by {@link XQueryParser#document}.
	 * @param ctx the parse tree
	 */
	void enterDocument(XQueryParser.DocumentContext ctx);
	/**
	 * Exit a parse tree produced by {@link XQueryParser#document}.
	 * @param ctx the parse tree
	 */
	void exitDocument(XQueryParser.DocumentContext ctx);
	/**
	 * Enter a parse tree produced by {@link XQueryParser#source}.
	 * @param ctx the parse tree
	 */
	void enterSource(XQueryParser.SourceContext ctx);
	/**
	 * Exit a parse tree produced by {@link XQueryParser#source}.
	 * @param ctx the parse tree
	 */
	void exitSource(XQueryParser.SourceContext ctx);
	/**
	 * Enter a parse tree produced by {@link XQueryParser#apAttr}.
	 * @param ctx the parse tree
	 */
	void enterApAttr(XQueryParser.ApAttrContext ctx);
	/**
	 * Exit a parse tree produced by {@link XQueryParser#apAttr}.
	 * @param ctx the parse tree
	 */
	void exitApAttr(XQueryParser.ApAttrContext ctx);
	/**
	 * Enter a parse tree produced by {@link XQueryParser#p}.
	 * @param ctx the parse tree
	 */
	void enterP(XQueryParser.PContext ctx);
	/**
	 * Exit a parse tree produced by {@link XQueryParser#p}.
	 * @param ctx the parse tree
	 */
	void exitP(XQueryParser.PContext ctx);
}