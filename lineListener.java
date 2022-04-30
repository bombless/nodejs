// Generated from line.g4 by ANTLR 4.10.1
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link lineParser}.
 */
public interface lineListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link lineParser#prog}.
	 * @param ctx the parse tree
	 */
	void enterProg(lineParser.ProgContext ctx);
	/**
	 * Exit a parse tree produced by {@link lineParser#prog}.
	 * @param ctx the parse tree
	 */
	void exitProg(lineParser.ProgContext ctx);
	/**
	 * Enter a parse tree produced by {@link lineParser#line}.
	 * @param ctx the parse tree
	 */
	void enterLine(lineParser.LineContext ctx);
	/**
	 * Exit a parse tree produced by {@link lineParser#line}.
	 * @param ctx the parse tree
	 */
	void exitLine(lineParser.LineContext ctx);
	/**
	 * Enter a parse tree produced by {@link lineParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterExpr(lineParser.ExprContext ctx);
	/**
	 * Exit a parse tree produced by {@link lineParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitExpr(lineParser.ExprContext ctx);
}