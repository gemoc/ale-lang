// Define a grammar called Hello
grammar XtdAQL;

import Query;

//ID : ([a-zA-Z] | '_') ([a-zA-Z] | [0-9] | '_')*;
//WS : [ \t\r\n]+ -> skip ; // skip spaces, tabs, newlines
COMMENT : '/*' .*? '*/' -> skip ; // .*? matches anything until the first */
LINECOMMENT : '//' ~[\r\n]* -> skip; //Line comment

/*
 * Structure
 */

rRoot : rImports rClass*
;

rImports : ('import' STRING)*
;

rClass : 'class' Ident '{' rAttribute* rOperation* '}'
; 

rOperation : 'def' Ident '(' rParameters? ')' rBlock
;

rParameters : rVariable (',' rVariable)*
;

rVariable : Ident Ident
;

rAttribute : Ident (':=' expression)? ';'
;

/*
 * Statements
 */

rStatement : rAssign
//		| rSet #Set
//		| rInsert #Insert
//		| rRemove #Remove
//		| rPut #Put
		| rForEach
		| rWhile
		| rIf
		| rExpression
;

//rAssign : ID ':=' expression ';'
//;
//
rAssign : expression ':=' expression ';'
;
//
//rInsert : expression '.' ID '.' 'add' '(' expression ')'
//;
//
//rRemove : expression '.' ID '.' 'remove' '(' expression ')'
//;
//
//rPut : expression '.' ID '.' 'put' '(' expression ',' expression ')'
//;

rForEach : 'for' '(' Ident  'in' expression ')' rBlock
;

rBlock : '{' (rStatement (rStatement)*)? '}'
;

rIf : 'if' '(' expression ')' rBlock ('else' rBlock)?
;

rWhile : 'while' '(' expression ')' rBlock
;

rExpression : expression ';'
;

//Expression :  '[' (.)*? '/]'
//;

STRING :  '"' (.)*? '"'
;
