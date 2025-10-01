/**
 */
package fr.supelec.tesl.lang.tesl;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Await Implication</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link fr.supelec.tesl.lang.tesl.AwaitImplication#getMasters <em>Masters</em>}</li>
 *   <li>{@link fr.supelec.tesl.lang.tesl.AwaitImplication#isWeak <em>Weak</em>}</li>
 *   <li>{@link fr.supelec.tesl.lang.tesl.AwaitImplication#isStrong <em>Strong</em>}</li>
 *   <li>{@link fr.supelec.tesl.lang.tesl.AwaitImplication#getReset <em>Reset</em>}</li>
 *   <li>{@link fr.supelec.tesl.lang.tesl.AwaitImplication#getTarget <em>Target</em>}</li>
 * </ul>
 *
 * @see fr.supelec.tesl.lang.tesl.TeslPackage#getAwaitImplication()
 * @model
 * @generated
 */
public interface AwaitImplication extends Relation
{
  /**
   * Returns the value of the '<em><b>Masters</b></em>' reference list.
   * The list contents are of type {@link fr.supelec.tesl.lang.tesl.Clock}.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Masters</em>' reference list.
   * @see fr.supelec.tesl.lang.tesl.TeslPackage#getAwaitImplication_Masters()
   * @model
   * @generated
   */
  EList<Clock> getMasters();

  /**
   * Returns the value of the '<em><b>Weak</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Weak</em>' attribute.
   * @see #setWeak(boolean)
   * @see fr.supelec.tesl.lang.tesl.TeslPackage#getAwaitImplication_Weak()
   * @model
   * @generated
   */
  boolean isWeak();

  /**
   * Sets the value of the '{@link fr.supelec.tesl.lang.tesl.AwaitImplication#isWeak <em>Weak</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Weak</em>' attribute.
   * @see #isWeak()
   * @generated
   */
  void setWeak(boolean value);

  /**
   * Returns the value of the '<em><b>Strong</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Strong</em>' attribute.
   * @see #setStrong(boolean)
   * @see fr.supelec.tesl.lang.tesl.TeslPackage#getAwaitImplication_Strong()
   * @model
   * @generated
   */
  boolean isStrong();

  /**
   * Sets the value of the '{@link fr.supelec.tesl.lang.tesl.AwaitImplication#isStrong <em>Strong</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Strong</em>' attribute.
   * @see #isStrong()
   * @generated
   */
  void setStrong(boolean value);

  /**
   * Returns the value of the '<em><b>Reset</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Reset</em>' reference.
   * @see #setReset(Clock)
   * @see fr.supelec.tesl.lang.tesl.TeslPackage#getAwaitImplication_Reset()
   * @model
   * @generated
   */
  Clock getReset();

  /**
   * Sets the value of the '{@link fr.supelec.tesl.lang.tesl.AwaitImplication#getReset <em>Reset</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Reset</em>' reference.
   * @see #getReset()
   * @generated
   */
  void setReset(Clock value);

  /**
   * Returns the value of the '<em><b>Target</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Target</em>' reference.
   * @see #setTarget(Clock)
   * @see fr.supelec.tesl.lang.tesl.TeslPackage#getAwaitImplication_Target()
   * @model
   * @generated
   */
  Clock getTarget();

  /**
   * Sets the value of the '{@link fr.supelec.tesl.lang.tesl.AwaitImplication#getTarget <em>Target</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Target</em>' reference.
   * @see #getTarget()
   * @generated
   */
  void setTarget(Clock value);

} // AwaitImplication
