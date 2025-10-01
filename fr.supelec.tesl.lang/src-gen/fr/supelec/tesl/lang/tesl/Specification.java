/**
 */
package fr.supelec.tesl.lang.tesl;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Specification</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link fr.supelec.tesl.lang.tesl.Specification#getDecl <em>Decl</em>}</li>
 *   <li>{@link fr.supelec.tesl.lang.tesl.Specification#getRel <em>Rel</em>}</li>
 *   <li>{@link fr.supelec.tesl.lang.tesl.Specification#getLet <em>Let</em>}</li>
 *   <li>{@link fr.supelec.tesl.lang.tesl.Specification#getPragmas <em>Pragmas</em>}</li>
 * </ul>
 *
 * @see fr.supelec.tesl.lang.tesl.TeslPackage#getSpecification()
 * @model
 * @generated
 */
public interface Specification extends EObject
{
  /**
   * Returns the value of the '<em><b>Decl</b></em>' containment reference list.
   * The list contents are of type {@link fr.supelec.tesl.lang.tesl.Clock}.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Decl</em>' containment reference list.
   * @see fr.supelec.tesl.lang.tesl.TeslPackage#getSpecification_Decl()
   * @model containment="true"
   * @generated
   */
  EList<Clock> getDecl();

  /**
   * Returns the value of the '<em><b>Rel</b></em>' containment reference list.
   * The list contents are of type {@link fr.supelec.tesl.lang.tesl.Relation}.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Rel</em>' containment reference list.
   * @see fr.supelec.tesl.lang.tesl.TeslPackage#getSpecification_Rel()
   * @model containment="true"
   * @generated
   */
  EList<Relation> getRel();

  /**
   * Returns the value of the '<em><b>Let</b></em>' containment reference list.
   * The list contents are of type {@link fr.supelec.tesl.lang.tesl.Let}.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Let</em>' containment reference list.
   * @see fr.supelec.tesl.lang.tesl.TeslPackage#getSpecification_Let()
   * @model containment="true"
   * @generated
   */
  EList<Let> getLet();

  /**
   * Returns the value of the '<em><b>Pragmas</b></em>' containment reference list.
   * The list contents are of type {@link fr.supelec.tesl.lang.tesl.Pragma}.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Pragmas</em>' containment reference list.
   * @see fr.supelec.tesl.lang.tesl.TeslPackage#getSpecification_Pragmas()
   * @model containment="true"
   * @generated
   */
  EList<Pragma> getPragmas();

} // Specification
