/**
 */
package fr.supelec.tesl.lang.tesl;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Delayed Qualifier</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link fr.supelec.tesl.lang.tesl.DelayedQualifier#isImmediately <em>Immediately</em>}</li>
 *   <li>{@link fr.supelec.tesl.lang.tesl.DelayedQualifier#getCount <em>Count</em>}</li>
 *   <li>{@link fr.supelec.tesl.lang.tesl.DelayedQualifier#isReset <em>Reset</em>}</li>
 *   <li>{@link fr.supelec.tesl.lang.tesl.DelayedQualifier#getClock <em>Clock</em>}</li>
 * </ul>
 *
 * @see fr.supelec.tesl.lang.tesl.TeslPackage#getDelayedQualifier()
 * @model
 * @generated
 */
public interface DelayedQualifier extends ImplicationQualifier
{
  /**
   * Returns the value of the '<em><b>Immediately</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Immediately</em>' attribute.
   * @see #setImmediately(boolean)
   * @see fr.supelec.tesl.lang.tesl.TeslPackage#getDelayedQualifier_Immediately()
   * @model
   * @generated
   */
  boolean isImmediately();

  /**
   * Sets the value of the '{@link fr.supelec.tesl.lang.tesl.DelayedQualifier#isImmediately <em>Immediately</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Immediately</em>' attribute.
   * @see #isImmediately()
   * @generated
   */
  void setImmediately(boolean value);

  /**
   * Returns the value of the '<em><b>Count</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Count</em>' containment reference.
   * @see #setCount(Expression)
   * @see fr.supelec.tesl.lang.tesl.TeslPackage#getDelayedQualifier_Count()
   * @model containment="true"
   * @generated
   */
  Expression getCount();

  /**
   * Sets the value of the '{@link fr.supelec.tesl.lang.tesl.DelayedQualifier#getCount <em>Count</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Count</em>' containment reference.
   * @see #getCount()
   * @generated
   */
  void setCount(Expression value);

  /**
   * Returns the value of the '<em><b>Reset</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Reset</em>' attribute.
   * @see #setReset(boolean)
   * @see fr.supelec.tesl.lang.tesl.TeslPackage#getDelayedQualifier_Reset()
   * @model
   * @generated
   */
  boolean isReset();

  /**
   * Sets the value of the '{@link fr.supelec.tesl.lang.tesl.DelayedQualifier#isReset <em>Reset</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Reset</em>' attribute.
   * @see #isReset()
   * @generated
   */
  void setReset(boolean value);

  /**
   * Returns the value of the '<em><b>Clock</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Clock</em>' reference.
   * @see #setClock(Clock)
   * @see fr.supelec.tesl.lang.tesl.TeslPackage#getDelayedQualifier_Clock()
   * @model
   * @generated
   */
  Clock getClock();

  /**
   * Sets the value of the '{@link fr.supelec.tesl.lang.tesl.DelayedQualifier#getClock <em>Clock</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Clock</em>' reference.
   * @see #getClock()
   * @generated
   */
  void setClock(Clock value);

} // DelayedQualifier
