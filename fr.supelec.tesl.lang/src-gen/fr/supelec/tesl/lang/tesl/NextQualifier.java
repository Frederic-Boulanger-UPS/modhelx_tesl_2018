/**
 */
package fr.supelec.tesl.lang.tesl;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Next Qualifier</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link fr.supelec.tesl.lang.tesl.NextQualifier#isStrict <em>Strict</em>}</li>
 *   <li>{@link fr.supelec.tesl.lang.tesl.NextQualifier#getClock <em>Clock</em>}</li>
 * </ul>
 *
 * @see fr.supelec.tesl.lang.tesl.TeslPackage#getNextQualifier()
 * @model
 * @generated
 */
public interface NextQualifier extends ImplicationQualifier
{
  /**
   * Returns the value of the '<em><b>Strict</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Strict</em>' attribute.
   * @see #setStrict(boolean)
   * @see fr.supelec.tesl.lang.tesl.TeslPackage#getNextQualifier_Strict()
   * @model
   * @generated
   */
  boolean isStrict();

  /**
   * Sets the value of the '{@link fr.supelec.tesl.lang.tesl.NextQualifier#isStrict <em>Strict</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Strict</em>' attribute.
   * @see #isStrict()
   * @generated
   */
  void setStrict(boolean value);

  /**
   * Returns the value of the '<em><b>Clock</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Clock</em>' reference.
   * @see #setClock(Clock)
   * @see fr.supelec.tesl.lang.tesl.TeslPackage#getNextQualifier_Clock()
   * @model
   * @generated
   */
  Clock getClock();

  /**
   * Sets the value of the '{@link fr.supelec.tesl.lang.tesl.NextQualifier#getClock <em>Clock</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Clock</em>' reference.
   * @see #getClock()
   * @generated
   */
  void setClock(Clock value);

} // NextQualifier
