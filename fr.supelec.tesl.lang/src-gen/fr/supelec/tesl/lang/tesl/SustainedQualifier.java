/**
 */
package fr.supelec.tesl.lang.tesl;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Sustained Qualifier</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link fr.supelec.tesl.lang.tesl.SustainedQualifier#isImmediately <em>Immediately</em>}</li>
 *   <li>{@link fr.supelec.tesl.lang.tesl.SustainedQualifier#getStartClock <em>Start Clock</em>}</li>
 *   <li>{@link fr.supelec.tesl.lang.tesl.SustainedQualifier#getEndClock <em>End Clock</em>}</li>
 *   <li>{@link fr.supelec.tesl.lang.tesl.SustainedQualifier#isWeakly <em>Weakly</em>}</li>
 * </ul>
 *
 * @see fr.supelec.tesl.lang.tesl.TeslPackage#getSustainedQualifier()
 * @model
 * @generated
 */
public interface SustainedQualifier extends ImplicationQualifier
{
  /**
   * Returns the value of the '<em><b>Immediately</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Immediately</em>' attribute.
   * @see #setImmediately(boolean)
   * @see fr.supelec.tesl.lang.tesl.TeslPackage#getSustainedQualifier_Immediately()
   * @model
   * @generated
   */
  boolean isImmediately();

  /**
   * Sets the value of the '{@link fr.supelec.tesl.lang.tesl.SustainedQualifier#isImmediately <em>Immediately</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Immediately</em>' attribute.
   * @see #isImmediately()
   * @generated
   */
  void setImmediately(boolean value);

  /**
   * Returns the value of the '<em><b>Start Clock</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Start Clock</em>' reference.
   * @see #setStartClock(Clock)
   * @see fr.supelec.tesl.lang.tesl.TeslPackage#getSustainedQualifier_StartClock()
   * @model
   * @generated
   */
  Clock getStartClock();

  /**
   * Sets the value of the '{@link fr.supelec.tesl.lang.tesl.SustainedQualifier#getStartClock <em>Start Clock</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Start Clock</em>' reference.
   * @see #getStartClock()
   * @generated
   */
  void setStartClock(Clock value);

  /**
   * Returns the value of the '<em><b>End Clock</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>End Clock</em>' reference.
   * @see #setEndClock(Clock)
   * @see fr.supelec.tesl.lang.tesl.TeslPackage#getSustainedQualifier_EndClock()
   * @model
   * @generated
   */
  Clock getEndClock();

  /**
   * Sets the value of the '{@link fr.supelec.tesl.lang.tesl.SustainedQualifier#getEndClock <em>End Clock</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>End Clock</em>' reference.
   * @see #getEndClock()
   * @generated
   */
  void setEndClock(Clock value);

  /**
   * Returns the value of the '<em><b>Weakly</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Weakly</em>' attribute.
   * @see #setWeakly(boolean)
   * @see fr.supelec.tesl.lang.tesl.TeslPackage#getSustainedQualifier_Weakly()
   * @model
   * @generated
   */
  boolean isWeakly();

  /**
   * Sets the value of the '{@link fr.supelec.tesl.lang.tesl.SustainedQualifier#isWeakly <em>Weakly</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Weakly</em>' attribute.
   * @see #isWeakly()
   * @generated
   */
  void setWeakly(boolean value);

} // SustainedQualifier
