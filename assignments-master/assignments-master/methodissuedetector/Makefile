ANTLR4 = java -jar /usr/local/lib/antlr-4.6-complete.jar
SHELL = /bin/bash

run: cleanJava antlr
	javac *.java
	mkdir -p output
	cat input/test.java | java MethodIssueDetector

cleanJava:
	rm -f *.class

cleanAntlr:
	rm -f Java8BaseListener.java Java8Listener.java Java8Lexer.java Java8Parser.java Java8Lexer.tokens Java8.tokens

cleanAll: cleanAntlr cleanJava
	rm -f output/*

antlr:
	test -f Java8Lexer.java && echo "Skipping antlr generation. If you prefer, first run \"make -s cleanAntlr\" first." || ${ANTLR4} Java8.g4
