/**
 */
package fr.supelec.tesl.lang.tesl;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Sporadic Qualifier</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link fr.supelec.tesl.lang.tesl.SporadicQualifier#getInstants <em>Instants</em>}</li>
 * </ul>
 *
 * @see fr.supelec.tesl.lang.tesl.TeslPackage#getSporadicQualifier()
 * @model
 * @generated
 */
public interface SporadicQualifier extends ClockQualifier
{
  /**
   * Returns the value of the '<em><b>Instants</b></em>' containment reference list.
   * The list contents are of type {@link fr.supelec.tesl.lang.tesl.Expression}.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Instants</em>' containment reference list.
   * @see fr.supelec.tesl.lang.tesl.TeslPackage#getSporadicQualifier_Instants()
   * @model containment="true"
   * @generated
   */
  EList<Expression> getInstants();

} // SporadicQualifier
