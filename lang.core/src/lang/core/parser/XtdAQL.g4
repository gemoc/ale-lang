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

rClass : rOpenClass | rNewClass
;

rOpenClass : 'open' 'class' name=rQualified ('extends' rQualified (',' rQualified)* )? '{' rAttribute* rOperation* '}'
;

rNewClass : 'class' name=Ident '{' rAttribute* rOperation* '}'
; 

rOperation : (rTag)* ('def' | 'override') type=rType name=Ident '(' rParameters? ')' rBlock
;

rTag : '@'Ident
; 

rParameters : rVariable (',' rVariable)*
;

rVariable : type=rType Ident
;

rAttribute : type=rType Ident (':=' expression)? ';'
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

rVarDecl : type=rType Ident (':=' expression)? ';'
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

rType: rQualified | typeLiteral
;

rQualified : Ident ('.'Ident)*
;

STRING :  '"' (.)*? '"'
;
