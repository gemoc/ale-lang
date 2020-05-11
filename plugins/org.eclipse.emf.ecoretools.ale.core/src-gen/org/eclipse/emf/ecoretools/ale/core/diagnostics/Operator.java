/**
 */
package org.eclipse.emf.ecoretools.ale.core.diagnostics;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.common.util.Enumerator;

/**
 * <!-- begin-user-doc -->
 * A representation of the literals of the enumeration '<em><b>Operator</b></em>',
 * and utility methods for working with them.
 * <!-- end-user-doc -->
 * @see org.eclipse.emf.ecoretools.ale.core.diagnostics.DiagnosticsPackage#getOperator()
 * @model
 * @generated
 */
public enum Operator implements Enumerator {
	/**
	 * The '<em><b>SUBSTRACTION</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #SUBSTRACTION_VALUE
	 * @generated
	 * @ordered
	 */
	SUBSTRACTION(0, "SUBSTRACTION", "SUBSTRACTION"), /**
	 * The '<em><b>ADDITION</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #ADDITION_VALUE
	 * @generated
	 * @ordered
	 */
	ADDITION(1, "ADDITION", "ADDITION"), /**
	 * The '<em><b>LOWER THAN</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #LOWER_THAN_VALUE
	 * @generated
	 * @ordered
	 */
	LOWER_THAN(2, "LOWER_THAN", "LOWER_THAN"), /**
	 * The '<em><b>GREATER THAN</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #GREATER_THAN_VALUE
	 * @generated
	 * @ordered
	 */
	GREATER_THAN(3, "GREATER_THAN", "GREATER_THAN"), /**
	 * The '<em><b>EQUAL</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #EQUAL_VALUE
	 * @generated
	 * @ordered
	 */
	EQUAL(4, "EQUAL", "EQUAL"), /**
	 * The '<em><b>DOT</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #DOT_VALUE
	 * @generated
	 * @ordered
	 */
	DOT(5, "DOT", "DOT"), /**
	 * The '<em><b>LOWER OR EQUAL</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #LOWER_OR_EQUAL_VALUE
	 * @generated
	 * @ordered
	 */
	LOWER_OR_EQUAL(6, "LOWER_OR_EQUAL", "LOWER_OR_EQUAL"), /**
	 * The '<em><b>GREATER OR EQUAL</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #GREATER_OR_EQUAL_VALUE
	 * @generated
	 * @ordered
	 */
	GREATER_OR_EQUAL(7, "GREATER_OR_EQUAL", "GREATER_OR_EQUAL"), /**
	 * The '<em><b>ASSIGNMENT</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #ASSIGNMENT_VALUE
	 * @generated
	 * @ordered
	 */
	ASSIGNMENT(8, "ASSIGNMENT", "ASSIGNMENT"), /**
	 * The '<em><b>ADDITION ASSIGNMENT</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #ADDITION_ASSIGNMENT_VALUE
	 * @generated
	 * @ordered
	 */
	ADDITION_ASSIGNMENT(9, "ADDITION_ASSIGNMENT", "ADDITION_ASSIGNMENT"), /**
	 * The '<em><b>SUBSTRACTION ASSIGNMENT</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #SUBSTRACTION_ASSIGNMENT_VALUE
	 * @generated
	 * @ordered
	 */
	SUBSTRACTION_ASSIGNMENT(10, "SUBSTRACTION_ASSIGNMENT", "SUBSTRACTION_ASSIGNMENT");

	/**
	 * The '<em><b>SUBSTRACTION</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #SUBSTRACTION
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int SUBSTRACTION_VALUE = 0;

	/**
	 * The '<em><b>ADDITION</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #ADDITION
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int ADDITION_VALUE = 1;

	/**
	 * The '<em><b>LOWER THAN</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #LOWER_THAN
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int LOWER_THAN_VALUE = 2;

	/**
	 * The '<em><b>GREATER THAN</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #GREATER_THAN
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int GREATER_THAN_VALUE = 3;

	/**
	 * The '<em><b>EQUAL</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #EQUAL
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int EQUAL_VALUE = 4;

	/**
	 * The '<em><b>DOT</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #DOT
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int DOT_VALUE = 5;

	/**
	 * The '<em><b>LOWER OR EQUAL</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #LOWER_OR_EQUAL
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int LOWER_OR_EQUAL_VALUE = 6;

	/**
	 * The '<em><b>GREATER OR EQUAL</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #GREATER_OR_EQUAL
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int GREATER_OR_EQUAL_VALUE = 7;

	/**
	 * The '<em><b>ASSIGNMENT</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #ASSIGNMENT
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int ASSIGNMENT_VALUE = 8;

	/**
	 * The '<em><b>ADDITION ASSIGNMENT</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #ADDITION_ASSIGNMENT
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int ADDITION_ASSIGNMENT_VALUE = 9;

	/**
	 * The '<em><b>SUBSTRACTION ASSIGNMENT</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #SUBSTRACTION_ASSIGNMENT
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int SUBSTRACTION_ASSIGNMENT_VALUE = 10;

	/**
	 * An array of all the '<em><b>Operator</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static final Operator[] VALUES_ARRAY =
		new Operator[] {
			SUBSTRACTION,
			ADDITION,
			LOWER_THAN,
			GREATER_THAN,
			EQUAL,
			DOT,
			LOWER_OR_EQUAL,
			GREATER_OR_EQUAL,
			ASSIGNMENT,
			ADDITION_ASSIGNMENT,
			SUBSTRACTION_ASSIGNMENT,
		};

	/**
	 * A public read-only list of all the '<em><b>Operator</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final List<Operator> VALUES = Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));

	/**
	 * Returns the '<em><b>Operator</b></em>' literal with the specified literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param literal the literal.
	 * @return the matching enumerator or <code>null</code>.
	 * @generated
	 */
	public static Operator get(String literal) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			Operator result = VALUES_ARRAY[i];
			if (result.toString().equals(literal)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Operator</b></em>' literal with the specified name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param name the name.
	 * @return the matching enumerator or <code>null</code>.
	 * @generated
	 */
	public static Operator getByName(String name) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			Operator result = VALUES_ARRAY[i];
			if (result.getName().equals(name)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Operator</b></em>' literal with the specified integer value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the integer value.
	 * @return the matching enumerator or <code>null</code>.
	 * @generated
	 */
	public static Operator get(int value) {
		switch (value) {
			case SUBSTRACTION_VALUE: return SUBSTRACTION;
			case ADDITION_VALUE: return ADDITION;
			case LOWER_THAN_VALUE: return LOWER_THAN;
			case GREATER_THAN_VALUE: return GREATER_THAN;
			case EQUAL_VALUE: return EQUAL;
			case DOT_VALUE: return DOT;
			case LOWER_OR_EQUAL_VALUE: return LOWER_OR_EQUAL;
			case GREATER_OR_EQUAL_VALUE: return GREATER_OR_EQUAL;
			case ASSIGNMENT_VALUE: return ASSIGNMENT;
			case ADDITION_ASSIGNMENT_VALUE: return ADDITION_ASSIGNMENT;
			case SUBSTRACTION_ASSIGNMENT_VALUE: return SUBSTRACTION_ASSIGNMENT;
		}
		return null;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private final int value;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private final String name;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private final String literal;

	/**
	 * Only this class can construct instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private Operator(int value, String name, String literal) {
		this.value = value;
		this.name = name;
		this.literal = literal;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public int getValue() {
	  return value;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getName() {
	  return name;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getLiteral() {
	  return literal;
	}

	/**
	 * Returns the literal value of the enumerator, which is its string representation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		return literal;
	}
	
} //Operator
