/**
 */
package fr.supelec.tesl.lang.tesl;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Let Value</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link fr.supelec.tesl.lang.tesl.LetValue#getRef <em>Ref</em>}</li>
 * </ul>
 *
 * @see fr.supelec.tesl.lang.tesl.TeslPackage#getLetValue()
 * @model
 * @generated
 */
public interface LetValue extends Value
{
  /**
   * Returns the value of the '<em><b>Ref</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Ref</em>' reference.
   * @see #setRef(Let)
   * @see fr.supelec.tesl.lang.tesl.TeslPackage#getLetValue_Ref()
   * @model
   * @generated
   */
  Let getRef();

  /**
   * Sets the value of the '{@link fr.supelec.tesl.lang.tesl.LetValue#getRef <em>Ref</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Ref</em>' reference.
   * @see #getRef()
   * @generated
   */
  void setRef(Let value);

} // LetValue
