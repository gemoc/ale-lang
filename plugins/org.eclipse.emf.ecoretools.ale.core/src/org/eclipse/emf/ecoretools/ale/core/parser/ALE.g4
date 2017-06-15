/*******************************************************************************
 * Copyright (c) 2017 Inria and Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Inria - initial API and implementation
 *******************************************************************************/
grammar ALE;

import Query;

@header {
/*******************************************************************************
 * Copyright (c) 2017 Inria and Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Inria - initial API and implementation
 *******************************************************************************/
package org.eclipse.emf.ecoretools.ale.core.parser;
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

rAttribute : modifier=('contains' | 'unique')? bounds=rCardinality? opposite=rOpposite? type=rType Ident (':=' rExpression)? ';'
;

rCardinality :
	Integer '..' (Integer | MultOp)
;

rOpposite :
	'opposite 'Ident
;

/*
 * Statements
 */

rStatement : rVarDecl 
		| rAssign
		| rInsert
		| rRemove
		| rForEach
		| rWhile
		| rIf
		| rExpressionStmt
;

rVarDecl : type=rType Ident (':=' rExpression)? ';'
;

rAssign : expression ':=' rExpression ';'
;

rInsert: expression '+=' rExpression ';'
;

rRemove : expression '-=' rExpression ';'
;

rForEach : 'for' '(' Ident  'in' rCollection ')' rBlock
;

rCollection : '[' Integer '..' Integer ']' | rExpression
;

rBlock : '{' (rStatement (rStatement)*)? '}'
;

rIf : 'if' '(' rExpression ')' rBlock ('else' rBlock)?
;

rWhile : 'while' '(' rExpression ')' rBlock
;

rExpressionStmt : rExpression ';'
;

rExpression : rSwitch | expression
;

rType: rQualified | typeLiteral
;

rQualified : Ident ('.'Ident)*
;

rSwitch : 
	'switch' '(' (paramName=Ident ':')? paramVal=rExpression')' '{'
		cases+=rCase+
		'default' ':' other=rExpression
	'}'
;

rCase : guard=rType? ('case' match=rExpression)? ':' value=rExpression
;

STRING :  '"' (.)*? '"'
;
