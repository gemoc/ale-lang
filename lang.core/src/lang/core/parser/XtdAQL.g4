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

rRoot : 
	'behavior' rQualified ';'
 	rImport*
 	rService*
 	rClass*
;

rImport : 'import' rQualified 'as' Ident ';'
;

rService : 'use' Ident ('.' Ident)* ';'
;

rClass : 'class' Ident ('extends' rQualified (',' rQualified)* )? '{' rAttribute* rOperation* '}'
; 

rOperation : (rTag)* ('def' | 'override') (Ident|'String') Ident '(' rParameters? ')' rBlock
;

rTag : '@'Ident
; 

rParameters : rVariable (',' rVariable)*
;

rVariable : (Ident|'String') Ident
;

rAttribute : (Ident|'String') Ident (':=' expression)? ';'
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

rVarDecl : (Ident|'String') Ident (':=' expression)? ';'
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

rQualified : Ident ('.'Ident)*
;

STRING :  '"' (.)*? '"'
;
