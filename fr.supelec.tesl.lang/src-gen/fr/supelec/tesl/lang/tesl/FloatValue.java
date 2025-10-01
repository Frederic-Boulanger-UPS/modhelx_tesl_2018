/**
 */
package fr.supelec.tesl.lang.tesl;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Float Value</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link fr.supelec.tesl.lang.tesl.FloatValue#getSign <em>Sign</em>}</li>
 *   <li>{@link fr.supelec.tesl.lang.tesl.FloatValue#getValue <em>Value</em>}</li>
 * </ul>
 *
 * @see fr.supelec.tesl.lang.tesl.TeslPackage#getFloatValue()
 * @model
 * @generated
 */
public interface FloatValue extends Value
{
  /**
   * Returns the value of the '<em><b>Sign</b></em>' attribute.
   * The literals are from the enumeration {@link fr.supelec.tesl.lang.tesl.Op}.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Sign</em>' attribute.
   * @see fr.supelec.tesl.lang.tesl.Op
   * @see #setSign(Op)
   * @see fr.supelec.tesl.lang.tesl.TeslPackage#getFloatValue_Sign()
   * @model
   * @generated
   */
  Op getSign();

  /**
   * Sets the value of the '{@link fr.supelec.tesl.lang.tesl.FloatValue#getSign <em>Sign</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Sign</em>' attribute.
   * @see fr.supelec.tesl.lang.tesl.Op
   * @see #getSign()
   * @generated
   */
  void setSign(Op value);

  /**
   * Returns the value of the '<em><b>Value</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Value</em>' attribute.
   * @see #setValue(double)
   * @see fr.supelec.tesl.lang.tesl.TeslPackage#getFloatValue_Value()
   * @model
   * @generated
   */
  double getValue();

  /**
   * Sets the value of the '{@link fr.supelec.tesl.lang.tesl.FloatValue#getValue <em>Value</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Value</em>' attribute.
   * @see #getValue()
   * @generated
   */
  void setValue(double value);

} // FloatValue
