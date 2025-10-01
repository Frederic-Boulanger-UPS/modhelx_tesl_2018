/**
 */
package fr.supelec.tesl.lang.tesl;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Stop Pragma</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link fr.supelec.tesl.lang.tesl.StopPragma#getClock <em>Clock</em>}</li>
 * </ul>
 *
 * @see fr.supelec.tesl.lang.tesl.TeslPackage#getStopPragma()
 * @model
 * @generated
 */
public interface StopPragma extends Pragma
{
  /**
   * Returns the value of the '<em><b>Clock</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Clock</em>' reference.
   * @see #setClock(Clock)
   * @see fr.supelec.tesl.lang.tesl.TeslPackage#getStopPragma_Clock()
   * @model
   * @generated
   */
  Clock getClock();

  /**
   * Sets the value of the '{@link fr.supelec.tesl.lang.tesl.StopPragma#getClock <em>Clock</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Clock</em>' reference.
   * @see #getClock()
   * @generated
   */
  void setClock(Clock value);

} // StopPragma
