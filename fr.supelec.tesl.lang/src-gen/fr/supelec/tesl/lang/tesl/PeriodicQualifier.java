/**
 */
package fr.supelec.tesl.lang.tesl;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Periodic Qualifier</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link fr.supelec.tesl.lang.tesl.PeriodicQualifier#getPeriod <em>Period</em>}</li>
 *   <li>{@link fr.supelec.tesl.lang.tesl.PeriodicQualifier#getOffset <em>Offset</em>}</li>
 * </ul>
 *
 * @see fr.supelec.tesl.lang.tesl.TeslPackage#getPeriodicQualifier()
 * @model
 * @generated
 */
public interface PeriodicQualifier extends ClockQualifier
{
  /**
   * Returns the value of the '<em><b>Period</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Period</em>' containment reference.
   * @see #setPeriod(Expression)
   * @see fr.supelec.tesl.lang.tesl.TeslPackage#getPeriodicQualifier_Period()
   * @model containment="true"
   * @generated
   */
  Expression getPeriod();

  /**
   * Sets the value of the '{@link fr.supelec.tesl.lang.tesl.PeriodicQualifier#getPeriod <em>Period</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Period</em>' containment reference.
   * @see #getPeriod()
   * @generated
   */
  void setPeriod(Expression value);

  /**
   * Returns the value of the '<em><b>Offset</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Offset</em>' containment reference.
   * @see #setOffset(Expression)
   * @see fr.supelec.tesl.lang.tesl.TeslPackage#getPeriodicQualifier_Offset()
   * @model containment="true"
   * @generated
   */
  Expression getOffset();

  /**
   * Sets the value of the '{@link fr.supelec.tesl.lang.tesl.PeriodicQualifier#getOffset <em>Offset</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Offset</em>' containment reference.
   * @see #getOffset()
   * @generated
   */
  void setOffset(Expression value);

} // PeriodicQualifier
