ANTLR4 = java -jar /usr/local/lib/antlr-4.6-complete.jar
SHELL = /bin/bash

run: cleanJava antlr
	javac *.java
	mkdir -p output
	cat input/$(TEST) | java Compute

cleanJava:
	rm -f *.class

cleanAntlr:
	rm -f ComputationBaseListener.java ComputationListener.java ComputationLexer.java ComputationParser.java ComputationLexer.tokens Computation.tokens

cleanAll: cleanAntlr cleanJava
	rm -f output/*

antlr:
	test -f ComputationLexer.java && echo "Skipping antlr generation. If you prefer, first run \"make -s cleanAntlr\" first." || ${ANTLR4} Computation.g4
