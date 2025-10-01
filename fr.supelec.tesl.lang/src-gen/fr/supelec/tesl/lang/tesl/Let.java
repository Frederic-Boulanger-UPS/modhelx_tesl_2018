/**
 */
package fr.supelec.tesl.lang.tesl;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Let</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link fr.supelec.tesl.lang.tesl.Let#getType <em>Type</em>}</li>
 *   <li>{@link fr.supelec.tesl.lang.tesl.Let#getName <em>Name</em>}</li>
 *   <li>{@link fr.supelec.tesl.lang.tesl.Let#getValue <em>Value</em>}</li>
 * </ul>
 *
 * @see fr.supelec.tesl.lang.tesl.TeslPackage#getLet()
 * @model
 * @generated
 */
public interface Let extends EObject
{
  /**
   * Returns the value of the '<em><b>Type</b></em>' attribute.
   * The literals are from the enumeration {@link fr.supelec.tesl.lang.tesl.ValueType}.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Type</em>' attribute.
   * @see fr.supelec.tesl.lang.tesl.ValueType
   * @see #setType(ValueType)
   * @see fr.supelec.tesl.lang.tesl.TeslPackage#getLet_Type()
   * @model
   * @generated
   */
  ValueType getType();

  /**
   * Sets the value of the '{@link fr.supelec.tesl.lang.tesl.Let#getType <em>Type</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Type</em>' attribute.
   * @see fr.supelec.tesl.lang.tesl.ValueType
   * @see #getType()
   * @generated
   */
  void setType(ValueType value);

  /**
   * Returns the value of the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Name</em>' attribute.
   * @see #setName(String)
   * @see fr.supelec.tesl.lang.tesl.TeslPackage#getLet_Name()
   * @model
   * @generated
   */
  String getName();

  /**
   * Sets the value of the '{@link fr.supelec.tesl.lang.tesl.Let#getName <em>Name</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Name</em>' attribute.
   * @see #getName()
   * @generated
   */
  void setName(String value);

  /**
   * Returns the value of the '<em><b>Value</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Value</em>' containment reference.
   * @see #setValue(Expression)
   * @see fr.supelec.tesl.lang.tesl.TeslPackage#getLet_Value()
   * @model containment="true"
   * @generated
   */
  Expression getValue();

  /**
   * Sets the value of the '{@link fr.supelec.tesl.lang.tesl.Let#getValue <em>Value</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Value</em>' containment reference.
   * @see #getValue()
   * @generated
   */
  void setValue(Expression value);

} // Let
