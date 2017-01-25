// Define a grammar called Hello
grammar XtdAQL;

ID : ([a-zA-Z] | '_') ([a-zA-Z] | [0-9] | '_')*;
WS : [ \t\r\n]+ -> skip ; // skip spaces, tabs, newlines
COMMENT : '/*' .*? '*/' -> skip ; // .*? matches anything until the first */
LINECOMMENT : '//' ~[\r\n]* -> skip; //Line comment

/*
 * Structure
 */

rRoot : rImports rClass*
;

rImports : ('import' STRING)*
;

rClass : 'class' ID '{' rAssign* rOperation* '}'
; 

rOperation : 'def' ID '(' rParameters? ')' rBlock
;

rParameters : rVariable (',' rVariable)*
;

rVariable : ID ID
;


/*
 * Statements
 */

rStatement : rAssign #Assign
		| rSet #Set
		| rInsert #Insert
		| rRemove #Remove
		| rPut #Put
		| rForEach #ForEach
		| rWhile #While
		| rIf #If
		| Expression #Exp
;

rAssign : ID '=' Expression
;

rSet : Expression '.' ID '=' Expression
;

rInsert : Expression '.' ID '.' 'add' '(' Expression ')'
;

rRemove : Expression '.' ID '.' 'remove' '(' Expression ')'
;

rPut : Expression '.' ID '.' 'put' '(' Expression ',' Expression ')'
;

rForEach : 'for' '(' ID  'in' Expression ')' rBlock
;

rBlock : '{' (rStatement ';' (rStatement ';')*)? '}'
;

rIf : 'if' '(' Expression ')' rBlock ('else' rBlock)?
;

rWhile : 'while' '(' Expression ')' rBlock
;

Expression :  '[' (.)*? '/]'
;

STRING :  '"' (.)*? '"'
;