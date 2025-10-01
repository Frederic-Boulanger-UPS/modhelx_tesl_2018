/**
 */
package fr.supelec.tesl.lang.tesl;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Time Delayed Qualifier</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link fr.supelec.tesl.lang.tesl.TimeDelayedQualifier#getDelay <em>Delay</em>}</li>
 *   <li>{@link fr.supelec.tesl.lang.tesl.TimeDelayedQualifier#getClock <em>Clock</em>}</li>
 *   <li>{@link fr.supelec.tesl.lang.tesl.TimeDelayedQualifier#isReset <em>Reset</em>}</li>
 *   <li>{@link fr.supelec.tesl.lang.tesl.TimeDelayedQualifier#isImmReset <em>Imm Reset</em>}</li>
 *   <li>{@link fr.supelec.tesl.lang.tesl.TimeDelayedQualifier#isStrongReset <em>Strong Reset</em>}</li>
 *   <li>{@link fr.supelec.tesl.lang.tesl.TimeDelayedQualifier#getResetClock <em>Reset Clock</em>}</li>
 * </ul>
 *
 * @see fr.supelec.tesl.lang.tesl.TeslPackage#getTimeDelayedQualifier()
 * @model
 * @generated
 */
public interface TimeDelayedQualifier extends ImplicationQualifier
{
  /**
   * Returns the value of the '<em><b>Delay</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Delay</em>' containment reference.
   * @see #setDelay(Expression)
   * @see fr.supelec.tesl.lang.tesl.TeslPackage#getTimeDelayedQualifier_Delay()
   * @model containment="true"
   * @generated
   */
  Expression getDelay();

  /**
   * Sets the value of the '{@link fr.supelec.tesl.lang.tesl.TimeDelayedQualifier#getDelay <em>Delay</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Delay</em>' containment reference.
   * @see #getDelay()
   * @generated
   */
  void setDelay(Expression value);

  /**
   * Returns the value of the '<em><b>Clock</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Clock</em>' reference.
   * @see #setClock(Clock)
   * @see fr.supelec.tesl.lang.tesl.TeslPackage#getTimeDelayedQualifier_Clock()
   * @model
   * @generated
   */
  Clock getClock();

  /**
   * Sets the value of the '{@link fr.supelec.tesl.lang.tesl.TimeDelayedQualifier#getClock <em>Clock</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Clock</em>' reference.
   * @see #getClock()
   * @generated
   */
  void setClock(Clock value);

  /**
   * Returns the value of the '<em><b>Reset</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Reset</em>' attribute.
   * @see #setReset(boolean)
   * @see fr.supelec.tesl.lang.tesl.TeslPackage#getTimeDelayedQualifier_Reset()
   * @model
   * @generated
   */
  boolean isReset();

  /**
   * Sets the value of the '{@link fr.supelec.tesl.lang.tesl.TimeDelayedQualifier#isReset <em>Reset</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Reset</em>' attribute.
   * @see #isReset()
   * @generated
   */
  void setReset(boolean value);

  /**
   * Returns the value of the '<em><b>Imm Reset</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Imm Reset</em>' attribute.
   * @see #setImmReset(boolean)
   * @see fr.supelec.tesl.lang.tesl.TeslPackage#getTimeDelayedQualifier_ImmReset()
   * @model
   * @generated
   */
  boolean isImmReset();

  /**
   * Sets the value of the '{@link fr.supelec.tesl.lang.tesl.TimeDelayedQualifier#isImmReset <em>Imm Reset</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Imm Reset</em>' attribute.
   * @see #isImmReset()
   * @generated
   */
  void setImmReset(boolean value);

  /**
   * Returns the value of the '<em><b>Strong Reset</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Strong Reset</em>' attribute.
   * @see #setStrongReset(boolean)
   * @see fr.supelec.tesl.lang.tesl.TeslPackage#getTimeDelayedQualifier_StrongReset()
   * @model
   * @generated
   */
  boolean isStrongReset();

  /**
   * Sets the value of the '{@link fr.supelec.tesl.lang.tesl.TimeDelayedQualifier#isStrongReset <em>Strong Reset</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Strong Reset</em>' attribute.
   * @see #isStrongReset()
   * @generated
   */
  void setStrongReset(boolean value);

  /**
   * Returns the value of the '<em><b>Reset Clock</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Reset Clock</em>' reference.
   * @see #setResetClock(Clock)
   * @see fr.supelec.tesl.lang.tesl.TeslPackage#getTimeDelayedQualifier_ResetClock()
   * @model
   * @generated
   */
  Clock getResetClock();

  /**
   * Sets the value of the '{@link fr.supelec.tesl.lang.tesl.TimeDelayedQualifier#getResetClock <em>Reset Clock</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Reset Clock</em>' reference.
   * @see #getResetClock()
   * @generated
   */
  void setResetClock(Clock value);

} // TimeDelayedQualifier
