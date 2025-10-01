/**
 */
package fr.supelec.tesl.lang.tesl;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Pattern</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link fr.supelec.tesl.lang.tesl.Pattern#getSkip <em>Skip</em>}</li>
 *   <li>{@link fr.supelec.tesl.lang.tesl.Pattern#getKeep <em>Keep</em>}</li>
 *   <li>{@link fr.supelec.tesl.lang.tesl.Pattern#isRep <em>Rep</em>}</li>
 *   <li>{@link fr.supelec.tesl.lang.tesl.Pattern#getRepskip <em>Repskip</em>}</li>
 *   <li>{@link fr.supelec.tesl.lang.tesl.Pattern#getRepkeep <em>Repkeep</em>}</li>
 * </ul>
 *
 * @see fr.supelec.tesl.lang.tesl.TeslPackage#getPattern()
 * @model
 * @generated
 */
public interface Pattern extends EObject
{
  /**
   * Returns the value of the '<em><b>Skip</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Skip</em>' containment reference.
   * @see #setSkip(Expression)
   * @see fr.supelec.tesl.lang.tesl.TeslPackage#getPattern_Skip()
   * @model containment="true"
   * @generated
   */
  Expression getSkip();

  /**
   * Sets the value of the '{@link fr.supelec.tesl.lang.tesl.Pattern#getSkip <em>Skip</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Skip</em>' containment reference.
   * @see #getSkip()
   * @generated
   */
  void setSkip(Expression value);

  /**
   * Returns the value of the '<em><b>Keep</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Keep</em>' containment reference.
   * @see #setKeep(Expression)
   * @see fr.supelec.tesl.lang.tesl.TeslPackage#getPattern_Keep()
   * @model containment="true"
   * @generated
   */
  Expression getKeep();

  /**
   * Sets the value of the '{@link fr.supelec.tesl.lang.tesl.Pattern#getKeep <em>Keep</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Keep</em>' containment reference.
   * @see #getKeep()
   * @generated
   */
  void setKeep(Expression value);

  /**
   * Returns the value of the '<em><b>Rep</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Rep</em>' attribute.
   * @see #setRep(boolean)
   * @see fr.supelec.tesl.lang.tesl.TeslPackage#getPattern_Rep()
   * @model
   * @generated
   */
  boolean isRep();

  /**
   * Sets the value of the '{@link fr.supelec.tesl.lang.tesl.Pattern#isRep <em>Rep</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Rep</em>' attribute.
   * @see #isRep()
   * @generated
   */
  void setRep(boolean value);

  /**
   * Returns the value of the '<em><b>Repskip</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Repskip</em>' containment reference.
   * @see #setRepskip(Expression)
   * @see fr.supelec.tesl.lang.tesl.TeslPackage#getPattern_Repskip()
   * @model containment="true"
   * @generated
   */
  Expression getRepskip();

  /**
   * Sets the value of the '{@link fr.supelec.tesl.lang.tesl.Pattern#getRepskip <em>Repskip</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Repskip</em>' containment reference.
   * @see #getRepskip()
   * @generated
   */
  void setRepskip(Expression value);

  /**
   * Returns the value of the '<em><b>Repkeep</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Repkeep</em>' containment reference.
   * @see #setRepkeep(Expression)
   * @see fr.supelec.tesl.lang.tesl.TeslPackage#getPattern_Repkeep()
   * @model containment="true"
   * @generated
   */
  Expression getRepkeep();

  /**
   * Sets the value of the '{@link fr.supelec.tesl.lang.tesl.Pattern#getRepkeep <em>Repkeep</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Repkeep</em>' containment reference.
   * @see #getRepkeep()
   * @generated
   */
  void setRepkeep(Expression value);

} // Pattern
