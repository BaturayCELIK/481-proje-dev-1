grammar Computation;

formula : formula operation element | 
          '(' formula ')' operation element |
          element;

element : NUMBER | VARIABLE ;
operation : MULT | ADD ;
NUMBER : [1-9][0-9]* ;
VARIABLE : 'var' ;
MULT : 'x' ;
ADD : '+' ;
WS : [ \r\n\t]+ -> skip ;

