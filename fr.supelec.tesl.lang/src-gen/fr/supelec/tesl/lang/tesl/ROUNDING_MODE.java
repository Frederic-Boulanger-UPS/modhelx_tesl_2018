/**
 */
package fr.supelec.tesl.lang.tesl;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.common.util.Enumerator;

/**
 * <!-- begin-user-doc -->
 * A representation of the literals of the enumeration '<em><b>ROUNDING MODE</b></em>',
 * and utility methods for working with them.
 * <!-- end-user-doc -->
 * @see fr.supelec.tesl.lang.tesl.TeslPackage#getROUNDING_MODE()
 * @model
 * @generated
 */
public enum ROUNDING_MODE implements Enumerator
{
  /**
   * The '<em><b>ROUND UP</b></em>' literal object.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #ROUND_UP_VALUE
   * @generated
   * @ordered
   */
  ROUND_UP(0, "ROUND_UP", "round_up"),

  /**
   * The '<em><b>ROUND DOWN</b></em>' literal object.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #ROUND_DOWN_VALUE
   * @generated
   * @ordered
   */
  ROUND_DOWN(1, "ROUND_DOWN", "round_down"),

  /**
   * The '<em><b>ROUND CEILING</b></em>' literal object.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #ROUND_CEILING_VALUE
   * @generated
   * @ordered
   */
  ROUND_CEILING(2, "ROUND_CEILING", "round_ceil"),

  /**
   * The '<em><b>ROUND FLOOR</b></em>' literal object.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #ROUND_FLOOR_VALUE
   * @generated
   * @ordered
   */
  ROUND_FLOOR(3, "ROUND_FLOOR", "round_floor"),

  /**
   * The '<em><b>ROUND HALF UP</b></em>' literal object.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #ROUND_HALF_UP_VALUE
   * @generated
   * @ordered
   */
  ROUND_HALF_UP(4, "ROUND_HALF_UP", "round_half_up"),

  /**
   * The '<em><b>ROUND HALF DOWN</b></em>' literal object.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #ROUND_HALF_DOWN_VALUE
   * @generated
   * @ordered
   */
  ROUND_HALF_DOWN(5, "ROUND_HALF_DOWN", "round_half_down"),

  /**
   * The '<em><b>ROUND HALF EVEN</b></em>' literal object.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #ROUND_HALF_EVEN_VALUE
   * @generated
   * @ordered
   */
  ROUND_HALF_EVEN(6, "ROUND_HALF_EVEN", "round_half_even");

  /**
   * The '<em><b>ROUND UP</b></em>' literal value.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #ROUND_UP
   * @model literal="round_up"
   * @generated
   * @ordered
   */
  public static final int ROUND_UP_VALUE = 0;

  /**
   * The '<em><b>ROUND DOWN</b></em>' literal value.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #ROUND_DOWN
   * @model literal="round_down"
   * @generated
   * @ordered
   */
  public static final int ROUND_DOWN_VALUE = 1;

  /**
   * The '<em><b>ROUND CEILING</b></em>' literal value.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #ROUND_CEILING
   * @model literal="round_ceil"
   * @generated
   * @ordered
   */
  public static final int ROUND_CEILING_VALUE = 2;

  /**
   * The '<em><b>ROUND FLOOR</b></em>' literal value.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #ROUND_FLOOR
   * @model literal="round_floor"
   * @generated
   * @ordered
   */
  public static final int ROUND_FLOOR_VALUE = 3;

  /**
   * The '<em><b>ROUND HALF UP</b></em>' literal value.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #ROUND_HALF_UP
   * @model literal="round_half_up"
   * @generated
   * @ordered
   */
  public static final int ROUND_HALF_UP_VALUE = 4;

  /**
   * The '<em><b>ROUND HALF DOWN</b></em>' literal value.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #ROUND_HALF_DOWN
   * @model literal="round_half_down"
   * @generated
   * @ordered
   */
  public static final int ROUND_HALF_DOWN_VALUE = 5;

  /**
   * The '<em><b>ROUND HALF EVEN</b></em>' literal value.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #ROUND_HALF_EVEN
   * @model literal="round_half_even"
   * @generated
   * @ordered
   */
  public static final int ROUND_HALF_EVEN_VALUE = 6;

  /**
   * An array of all the '<em><b>ROUNDING MODE</b></em>' enumerators.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private static final ROUNDING_MODE[] VALUES_ARRAY =
    new ROUNDING_MODE[]
    {
      ROUND_UP,
      ROUND_DOWN,
      ROUND_CEILING,
      ROUND_FLOOR,
      ROUND_HALF_UP,
      ROUND_HALF_DOWN,
      ROUND_HALF_EVEN,
    };

  /**
   * A public read-only list of all the '<em><b>ROUNDING MODE</b></em>' enumerators.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public static final List<ROUNDING_MODE> VALUES = Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));

  /**
   * Returns the '<em><b>ROUNDING MODE</b></em>' literal with the specified literal value.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param literal the literal.
   * @return the matching enumerator or <code>null</code>.
   * @generated
   */
  public static ROUNDING_MODE get(String literal)
  {
    for (int i = 0; i < VALUES_ARRAY.length; ++i)
    {
      ROUNDING_MODE result = VALUES_ARRAY[i];
      if (result.toString().equals(literal))
      {
        return result;
      }
    }
    return null;
  }

  /**
   * Returns the '<em><b>ROUNDING MODE</b></em>' literal with the specified name.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param name the name.
   * @return the matching enumerator or <code>null</code>.
   * @generated
   */
  public static ROUNDING_MODE getByName(String name)
  {
    for (int i = 0; i < VALUES_ARRAY.length; ++i)
    {
      ROUNDING_MODE result = VALUES_ARRAY[i];
      if (result.getName().equals(name))
      {
        return result;
      }
    }
    return null;
  }

  /**
   * Returns the '<em><b>ROUNDING MODE</b></em>' literal with the specified integer value.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the integer value.
   * @return the matching enumerator or <code>null</code>.
   * @generated
   */
  public static ROUNDING_MODE get(int value)
  {
    switch (value)
    {
      case ROUND_UP_VALUE: return ROUND_UP;
      case ROUND_DOWN_VALUE: return ROUND_DOWN;
      case ROUND_CEILING_VALUE: return ROUND_CEILING;
      case ROUND_FLOOR_VALUE: return ROUND_FLOOR;
      case ROUND_HALF_UP_VALUE: return ROUND_HALF_UP;
      case ROUND_HALF_DOWN_VALUE: return ROUND_HALF_DOWN;
      case ROUND_HALF_EVEN_VALUE: return ROUND_HALF_EVEN;
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
  private ROUNDING_MODE(int value, String name, String literal)
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
  
} //ROUNDING_MODE
