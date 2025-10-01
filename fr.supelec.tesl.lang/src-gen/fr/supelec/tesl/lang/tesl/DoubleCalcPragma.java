/**
 */
package fr.supelec.tesl.lang.tesl;

import java.math.BigInteger;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Double Calc Pragma</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link fr.supelec.tesl.lang.tesl.DoubleCalcPragma#getNum_digits <em>Num digits</em>}</li>
 *   <li>{@link fr.supelec.tesl.lang.tesl.DoubleCalcPragma#isRound <em>Round</em>}</li>
 *   <li>{@link fr.supelec.tesl.lang.tesl.DoubleCalcPragma#getRounding_mode <em>Rounding mode</em>}</li>
 * </ul>
 *
 * @see fr.supelec.tesl.lang.tesl.TeslPackage#getDoubleCalcPragma()
 * @model
 * @generated
 */
public interface DoubleCalcPragma extends Pragma
{
  /**
   * Returns the value of the '<em><b>Num digits</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Num digits</em>' attribute.
   * @see #setNum_digits(BigInteger)
   * @see fr.supelec.tesl.lang.tesl.TeslPackage#getDoubleCalcPragma_Num_digits()
   * @model
   * @generated
   */
  BigInteger getNum_digits();

  /**
   * Sets the value of the '{@link fr.supelec.tesl.lang.tesl.DoubleCalcPragma#getNum_digits <em>Num digits</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Num digits</em>' attribute.
   * @see #getNum_digits()
   * @generated
   */
  void setNum_digits(BigInteger value);

  /**
   * Returns the value of the '<em><b>Round</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Round</em>' attribute.
   * @see #setRound(boolean)
   * @see fr.supelec.tesl.lang.tesl.TeslPackage#getDoubleCalcPragma_Round()
   * @model
   * @generated
   */
  boolean isRound();

  /**
   * Sets the value of the '{@link fr.supelec.tesl.lang.tesl.DoubleCalcPragma#isRound <em>Round</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Round</em>' attribute.
   * @see #isRound()
   * @generated
   */
  void setRound(boolean value);

  /**
   * Returns the value of the '<em><b>Rounding mode</b></em>' attribute.
   * The literals are from the enumeration {@link fr.supelec.tesl.lang.tesl.ROUNDING_MODE}.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Rounding mode</em>' attribute.
   * @see fr.supelec.tesl.lang.tesl.ROUNDING_MODE
   * @see #setRounding_mode(ROUNDING_MODE)
   * @see fr.supelec.tesl.lang.tesl.TeslPackage#getDoubleCalcPragma_Rounding_mode()
   * @model
   * @generated
   */
  ROUNDING_MODE getRounding_mode();

  /**
   * Sets the value of the '{@link fr.supelec.tesl.lang.tesl.DoubleCalcPragma#getRounding_mode <em>Rounding mode</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Rounding mode</em>' attribute.
   * @see fr.supelec.tesl.lang.tesl.ROUNDING_MODE
   * @see #getRounding_mode()
   * @generated
   */
  void setRounding_mode(ROUNDING_MODE value);

} // DoubleCalcPragma
