/**
 */
package fr.supelec.tesl.lang.tesl;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Clock</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link fr.supelec.tesl.lang.tesl.Clock#isNongreedy <em>Nongreedy</em>}</li>
 *   <li>{@link fr.supelec.tesl.lang.tesl.Clock#getType <em>Type</em>}</li>
 *   <li>{@link fr.supelec.tesl.lang.tesl.Clock#getName <em>Name</em>}</li>
 *   <li>{@link fr.supelec.tesl.lang.tesl.Clock#getQual <em>Qual</em>}</li>
 * </ul>
 *
 * @see fr.supelec.tesl.lang.tesl.TeslPackage#getClock()
 * @model
 * @generated
 */
public interface Clock extends EObject
{
  /**
   * Returns the value of the '<em><b>Nongreedy</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Nongreedy</em>' attribute.
   * @see #setNongreedy(boolean)
   * @see fr.supelec.tesl.lang.tesl.TeslPackage#getClock_Nongreedy()
   * @model
   * @generated
   */
  boolean isNongreedy();

  /**
   * Sets the value of the '{@link fr.supelec.tesl.lang.tesl.Clock#isNongreedy <em>Nongreedy</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Nongreedy</em>' attribute.
   * @see #isNongreedy()
   * @generated
   */
  void setNongreedy(boolean value);

  /**
   * Returns the value of the '<em><b>Type</b></em>' attribute.
   * The literals are from the enumeration {@link fr.supelec.tesl.lang.tesl.Type}.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Type</em>' attribute.
   * @see fr.supelec.tesl.lang.tesl.Type
   * @see #setType(Type)
   * @see fr.supelec.tesl.lang.tesl.TeslPackage#getClock_Type()
   * @model
   * @generated
   */
  Type getType();

  /**
   * Sets the value of the '{@link fr.supelec.tesl.lang.tesl.Clock#getType <em>Type</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Type</em>' attribute.
   * @see fr.supelec.tesl.lang.tesl.Type
   * @see #getType()
   * @generated
   */
  void setType(Type value);

  /**
   * Returns the value of the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Name</em>' attribute.
   * @see #setName(String)
   * @see fr.supelec.tesl.lang.tesl.TeslPackage#getClock_Name()
   * @model
   * @generated
   */
  String getName();

  /**
   * Sets the value of the '{@link fr.supelec.tesl.lang.tesl.Clock#getName <em>Name</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Name</em>' attribute.
   * @see #getName()
   * @generated
   */
  void setName(String value);

  /**
   * Returns the value of the '<em><b>Qual</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Qual</em>' containment reference.
   * @see #setQual(ClockQualifier)
   * @see fr.supelec.tesl.lang.tesl.TeslPackage#getClock_Qual()
   * @model containment="true"
   * @generated
   */
  ClockQualifier getQual();

  /**
   * Sets the value of the '{@link fr.supelec.tesl.lang.tesl.Clock#getQual <em>Qual</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Qual</em>' containment reference.
   * @see #getQual()
   * @generated
   */
  void setQual(ClockQualifier value);

} // Clock
