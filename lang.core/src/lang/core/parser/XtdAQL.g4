// Define a grammar called Hello
grammar XtdAQL;

import Query;

@header {
	package lang.core.parser;
}

//ID : ([a-zA-Z] | '_') ([a-zA-Z] | [0-9] | '_')*;
//WS : [ \t\r\n]+ -> skip ; // skip spaces, tabs, newlines
COMMENT : '/*' .*? '*/' -> skip ; // .*? matches anything until the first */
LINECOMMENT : '//' ~[\r\n]* -> skip; //Line comment

/*
 * Structure
 */

rRoot : rImport* rService* rClass*
;

rImport : 'import' Ident ('.' Ident)* ';'
;

rService : 'use' Ident ('.' Ident)* ';'
;

rClass : 'class' Ident '{' rAttribute* rOperation* '}'
; 

rOperation : (rTag)* ('def' | 'override') Ident '(' rParameters? ')' rBlock
;

rTag : '@'Ident
; 

rParameters : rVariable (',' rVariable)*
;

rVariable : Ident Ident
;

rAttribute : Ident Ident (':=' expression)? ';'
;

/*
 * Statements
 */

rStatement : rVarDecl 
		| rAssign
		| rForEach
		| rWhile
		| rIf
		| rExpression
;

rVarDecl : Ident Ident (':=' expression) ';'
;

rAssign : expression ':=' expression ';'
;

rForEach : 'for' '(' Ident  'in' rCollection ')' rBlock
;

rCollection : '[' Integer '..' Integer ']' | expression
;

rBlock : '{' (rStatement (rStatement)*)? '}'
;

rIf : 'if' '(' expression ')' rBlock ('else' rBlock)?
;

rWhile : 'while' '(' expression ')' rBlock
;

rExpression : expression ';'
;

STRING :  '"' (.)*? '"'
;
