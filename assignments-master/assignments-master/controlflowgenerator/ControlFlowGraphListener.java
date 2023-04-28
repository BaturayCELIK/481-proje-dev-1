import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.*;
import org.antlr.v4.runtime.misc.*;
import java.util.*;
import java.io.*;

public class ControlFlowGraphListener extends Java8BaseListener {
	TokenStream mTokenStream;
	StringBuilder mStringBuilder;

	public static void main(String[] args) throws Exception {
		run(System.in);
	}

	public static String run(InputStream inputStream) throws Exception {
		ANTLRInputStream input = new ANTLRInputStream(inputStream);
		Java8Lexer lexer = new Java8Lexer(input);
		CommonTokenStream tokens = new CommonTokenStream(lexer);
		Java8Parser parser = new Java8Parser(tokens);
		ParseTree tree = parser.compilationUnit();
		ParseTreeWalker walker = new ParseTreeWalker();

		TokenStream tokenStream = parser.getTokenStream();
		StringBuilder buf = new StringBuilder();
		buf.append("digraph G {\n");
		ControlFlowGraphListener listener =
			new ControlFlowGraphListener(tokenStream, buf);
		walker.walk(listener, tree);
		buf.append("}");

		System.out.println(buf.toString());
		return buf.toString();
	}

	public ControlFlowGraphListener(
		TokenStream tokenStream, StringBuilder builder) {
		mTokenStream = tokenStream;
		mStringBuilder = builder;
	}


	@Override public void enterBlockStatement(Java8Parser.BlockStatementContext ctx) {
		//
	}
}
