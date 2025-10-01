/**
 */
package fr.supelec.tesl.lang.tesl;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Trace Pragma</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link fr.supelec.tesl.lang.tesl.TracePragma#getKinds <em>Kinds</em>}</li>
 * </ul>
 *
 * @see fr.supelec.tesl.lang.tesl.TeslPackage#getTracePragma()
 * @model
 * @generated
 */
public interface TracePragma extends Pragma
{
  /**
   * Returns the value of the '<em><b>Kinds</b></em>' attribute list.
   * The list contents are of type {@link java.lang.String}.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Kinds</em>' attribute list.
   * @see fr.supelec.tesl.lang.tesl.TeslPackage#getTracePragma_Kinds()
   * @model unique="false"
   * @generated
   */
  EList<String> getKinds();

} // TracePragma
