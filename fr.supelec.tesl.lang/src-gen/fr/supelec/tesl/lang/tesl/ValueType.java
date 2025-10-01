/**
 */
package fr.supelec.tesl.lang.tesl;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.common.util.Enumerator;

/**
 * <!-- begin-user-doc -->
 * A representation of the literals of the enumeration '<em><b>Value Type</b></em>',
 * and utility methods for working with them.
 * <!-- end-user-doc -->
 * @see fr.supelec.tesl.lang.tesl.TeslPackage#getValueType()
 * @model
 * @generated
 */
public enum ValueType implements Enumerator
{
  /**
   * The '<em><b>TINT</b></em>' literal object.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #TINT_VALUE
   * @generated
   * @ordered
   */
  TINT(0, "TINT", "int"),

  /**
   * The '<em><b>TDEC</b></em>' literal object.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #TDEC_VALUE
   * @generated
   * @ordered
   */
  TDEC(1, "TDEC", "decimal"),

  /**
   * The '<em><b>TRAT</b></em>' literal object.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #TRAT_VALUE
   * @generated
   * @ordered
   */
  TRAT(2, "TRAT", "rational"),

  /**
   * The '<em><b>TFLOAT</b></em>' literal object.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #TFLOAT_VALUE
   * @generated
   * @ordered
   */
  TFLOAT(3, "TFLOAT", "double");

  /**
   * The '<em><b>TINT</b></em>' literal value.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #TINT
   * @model literal="int"
   * @generated
   * @ordered
   */
  public static final int TINT_VALUE = 0;

  /**
   * The '<em><b>TDEC</b></em>' literal value.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #TDEC
   * @model literal="decimal"
   * @generated
   * @ordered
   */
  public static final int TDEC_VALUE = 1;

  /**
   * The '<em><b>TRAT</b></em>' literal value.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #TRAT
   * @model literal="rational"
   * @generated
   * @ordered
   */
  public static final int TRAT_VALUE = 2;

  /**
   * The '<em><b>TFLOAT</b></em>' literal value.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #TFLOAT
   * @model literal="double"
   * @generated
   * @ordered
   */
  public static final int TFLOAT_VALUE = 3;

  /**
   * An array of all the '<em><b>Value Type</b></em>' enumerators.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private static final ValueType[] VALUES_ARRAY =
    new ValueType[]
    {
      TINT,
      TDEC,
      TRAT,
      TFLOAT,
    };

  /**
   * A public read-only list of all the '<em><b>Value Type</b></em>' enumerators.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public static final List<ValueType> VALUES = Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));

  /**
   * Returns the '<em><b>Value Type</b></em>' literal with the specified literal value.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param literal the literal.
   * @return the matching enumerator or <code>null</code>.
   * @generated
   */
  public static ValueType get(String literal)
  {
    for (int i = 0; i < VALUES_ARRAY.length; ++i)
    {
      ValueType result = VALUES_ARRAY[i];
      if (result.toString().equals(literal))
      {
        return result;
      }
    }
    return null;
  }

  /**
   * Returns the '<em><b>Value Type</b></em>' literal with the specified name.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param name the name.
   * @return the matching enumerator or <code>null</code>.
   * @generated
   */
  public static ValueType getByName(String name)
  {
    for (int i = 0; i < VALUES_ARRAY.length; ++i)
    {
      ValueType result = VALUES_ARRAY[i];
      if (result.getName().equals(name))
      {
        return result;
      }
    }
    return null;
  }

  /**
   * Returns the '<em><b>Value Type</b></em>' literal with the specified integer value.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the integer value.
   * @return the matching enumerator or <code>null</code>.
   * @generated
   */
  public static ValueType get(int value)
  {
    switch (value)
    {
      case TINT_VALUE: return TINT;
      case TDEC_VALUE: return TDEC;
      case TRAT_VALUE: return TRAT;
      case TFLOAT_VALUE: return TFLOAT;
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
  private ValueType(int value, String name, String literal)
  {
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
  public int getValue()
  {
    return value;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public String getName()
  {
    return name;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public String getLiteral()
  {
    return literal;
  }

  /**
   * Returns the literal value of the enumerator, which is its string representation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public String toString()
  {
    return literal;
  }
  
} //ValueType
