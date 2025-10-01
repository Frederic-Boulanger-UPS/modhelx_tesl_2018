/**
 */
package fr.supelec.tesl.lang.tesl;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Every Qualifier</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link fr.supelec.tesl.lang.tesl.EveryQualifier#getPeriod <em>Period</em>}</li>
 *   <li>{@link fr.supelec.tesl.lang.tesl.EveryQualifier#isOff <em>Off</em>}</li>
 *   <li>{@link fr.supelec.tesl.lang.tesl.EveryQualifier#getOffset <em>Offset</em>}</li>
 * </ul>
 *
 * @see fr.supelec.tesl.lang.tesl.TeslPackage#getEveryQualifier()
 * @model
 * @generated
 */
public interface EveryQualifier extends ImplicationQualifier
{
  /**
   * Returns the value of the '<em><b>Period</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Period</em>' containment reference.
   * @see #setPeriod(Expression)
   * @see fr.supelec.tesl.lang.tesl.TeslPackage#getEveryQualifier_Period()
   * @model containment="true"
   * @generated
   */
  Expression getPeriod();

  /**
   * Sets the value of the '{@link fr.supelec.tesl.lang.tesl.EveryQualifier#getPeriod <em>Period</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Period</em>' containment reference.
   * @see #getPeriod()
   * @generated
   */
  void setPeriod(Expression value);

  /**
   * Returns the value of the '<em><b>Off</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Off</em>' attribute.
   * @see #setOff(boolean)
   * @see fr.supelec.tesl.lang.tesl.TeslPackage#getEveryQualifier_Off()
   * @model
   * @generated
   */
  boolean isOff();

  /**
   * Sets the value of the '{@link fr.supelec.tesl.lang.tesl.EveryQualifier#isOff <em>Off</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Off</em>' attribute.
   * @see #isOff()
   * @generated
   */
  void setOff(boolean value);

  /**
   * Returns the value of the '<em><b>Offset</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Offset</em>' containment reference.
   * @see #setOffset(Expression)
   * @see fr.supelec.tesl.lang.tesl.TeslPackage#getEveryQualifier_Offset()
   * @model containment="true"
   * @generated
   */
  Expression getOffset();

  /**
   * Sets the value of the '{@link fr.supelec.tesl.lang.tesl.EveryQualifier#getOffset <em>Offset</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Offset</em>' containment reference.
   * @see #getOffset()
   * @generated
   */
  void setOffset(Expression value);

} // EveryQualifier
