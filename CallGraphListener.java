
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.*;

import org.antlr.v4.runtime.misc.*;
import java.util.*;


public class CallGraphListener extends Java8BaseListener {

    private Map<String, Set<String>> methodCalls = new HashMap<>();
    private ArrayList <String>declaredMethods = new ArrayList<>();
    private static String packageName ="";
    private static String className="";
    private static String methodName="";
    private static String calledMethodName="";

    
    @Override
    public void enterMethodDeclaration(Java8Parser.MethodDeclarationContext ctx) {
        methodName = packageName+"/"+className+"/"+ctx.methodHeader().methodDeclarator().Identifier().toString();//m kac?
        
        if (!methodCalls.containsKey(methodName)) {
            methodCalls.put(methodName, new HashSet<>());
        }

    }
    @Override
    public void enterClassDeclaration(Java8Parser.ClassDeclarationContext ctx){
        className = ctx.normalClassDeclaration().Identifier().toString();
    }
    @Override
    public void enterPackageDeclaration(Java8Parser.PackageDeclarationContext ctx){
        packageName = ctx.Identifier().toString();
    }
    @Override
    public void enterStatementExpression(Java8Parser.StatementExpressionContext ctx){
        //If child 2 equals to ")" there is no type name therefore the method calls within the same class
        if(!ctx.methodInvocation().getChild(2).toString().equals(")")){
            calledMethodName = packageName+ "/"+ctx.methodInvocation().getChild(0).getText()+"/"+ctx.methodInvocation().getChild(2);
        }//method calls in the same class
        else{
            calledMethodName = packageName+ "/"+className+"/"+ctx.methodInvocation().getChild(0).getText();
        }
        //if methods set already defined
        if (methodCalls.containsKey(methodName)) {
            methodCalls.get(methodName).add(calledMethodName);
        } else {
            Set<String> set = new HashSet<>();
            set.add(calledMethodName);
            methodCalls.put(methodName, set);
        }
    }
        
    public static void main(String[] args) throws Exception {
        int counter =1;
                ANTLRInputStream input = new ANTLRInputStream(System.in);
                Java8Lexer lexer = new Java8Lexer(input);
                CommonTokenStream tokens = new CommonTokenStream(lexer);
                Java8Parser parser = new Java8Parser(tokens);
                ParseTree tree = parser.compilationUnit();
                ParseTreeWalker walker = new ParseTreeWalker();
                CallGraphListener listener = new CallGraphListener();
                // This is where we trigger the walk of the tree using our listener.
                walker.walk(listener, tree);

                StringBuilder buf = new StringBuilder();
                buf.append("digraph G {\n");

                //The methods that declared are listed below
                for (Map.Entry<String, Set<String>> entry : listener.methodCalls.entrySet()) {
                    String callerMethodName = entry.getKey();             
                        buf.append(String.format("    \"%s\"[color = green];\n", callerMethodName));                   
                }
       
                // Generate edges between methods based on method calls
                for (Map.Entry<String, Set<String>> entry : listener.methodCalls.entrySet()) {
                    String callerMethodName = entry.getKey();
                    for (String calleeMethodName : entry.getValue()) {
                        
                        buf.append(String.format("    \"%s\" -> \"%s\";\n", callerMethodName, calleeMethodName));
                    }
                }

                // ..
                buf.append("}");
                System.out.println(buf.toString());
            


                
}


}
