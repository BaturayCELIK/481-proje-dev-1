import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.*;
import org.antlr.v4.runtime.misc.*;
import java.util.*;
import java.io.*;

public class MethodIssueDetector extends Java8BaseListener {

	public static void main(String[] args) throws Exception {
		run(System.in);
	}

	public static void run(InputStream inputStream) throws Exception {
		ANTLRInputStream input = new ANTLRInputStream(inputStream);
		Java8Lexer lexer = new Java8Lexer(input);
		CommonTokenStream tokens = new CommonTokenStream(lexer);
		Java8Parser parser = new Java8Parser(tokens);
		ParseTree tree = parser.compilationUnit();
		ParseTreeWalker walker = new ParseTreeWalker();
		MethodIssueDetector listener = new MethodIssueDetector();
		walker.walk(listener, tree);


		System.out.println("Never called");
		// Output.

		System.out.println();

		System.out.println("Called but not declared");
		// Output.
	}
}
