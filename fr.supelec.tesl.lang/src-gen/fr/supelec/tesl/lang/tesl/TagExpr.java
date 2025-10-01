/**
 */
package fr.supelec.tesl.lang.tesl;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Tag Expr</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link fr.supelec.tesl.lang.tesl.TagExpr#getClockY <em>Clock Y</em>}</li>
 *   <li>{@link fr.supelec.tesl.lang.tesl.TagExpr#getValueA <em>Value A</em>}</li>
 *   <li>{@link fr.supelec.tesl.lang.tesl.TagExpr#getClockX <em>Clock X</em>}</li>
 *   <li>{@link fr.supelec.tesl.lang.tesl.TagExpr#getValueN <em>Value N</em>}</li>
 *   <li>{@link fr.supelec.tesl.lang.tesl.TagExpr#getValueB <em>Value B</em>}</li>
 * </ul>
 *
 * @see fr.supelec.tesl.lang.tesl.TeslPackage#getTagExpr()
 * @model
 * @generated
 */
public interface TagExpr extends EObject
{
  /**
   * Returns the value of the '<em><b>Clock Y</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Clock Y</em>' reference.
   * @see #setClockY(Clock)
   * @see fr.supelec.tesl.lang.tesl.TeslPackage#getTagExpr_ClockY()
   * @model
   * @generated
   */
  Clock getClockY();

  /**
   * Sets the value of the '{@link fr.supelec.tesl.lang.tesl.TagExpr#getClockY <em>Clock Y</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Clock Y</em>' reference.
   * @see #getClockY()
   * @generated
   */
  void setClockY(Clock value);

  /**
   * Returns the value of the '<em><b>Value A</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Value A</em>' containment reference.
   * @see #setValueA(Expression)
   * @see fr.supelec.tesl.lang.tesl.TeslPackage#getTagExpr_ValueA()
   * @model containment="true"
   * @generated
   */
  Expression getValueA();

  /**
   * Sets the value of the '{@link fr.supelec.tesl.lang.tesl.TagExpr#getValueA <em>Value A</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Value A</em>' containment reference.
   * @see #getValueA()
   * @generated
   */
  void setValueA(Expression value);

  /**
   * Returns the value of the '<em><b>Clock X</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Clock X</em>' reference.
   * @see #setClockX(Clock)
   * @see fr.supelec.tesl.lang.tesl.TeslPackage#getTagExpr_ClockX()
   * @model
   * @generated
   */
  Clock getClockX();

  /**
   * Sets the value of the '{@link fr.supelec.tesl.lang.tesl.TagExpr#getClockX <em>Clock X</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Clock X</em>' reference.
   * @see #getClockX()
   * @generated
   */
  void setClockX(Clock value);

  /**
   * Returns the value of the '<em><b>Value N</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Value N</em>' containment reference.
   * @see #setValueN(Expression)
   * @see fr.supelec.tesl.lang.tesl.TeslPackage#getTagExpr_ValueN()
   * @model containment="true"
   * @generated
   */
  Expression getValueN();

  /**
   * Sets the value of the '{@link fr.supelec.tesl.lang.tesl.TagExpr#getValueN <em>Value N</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Value N</em>' containment reference.
   * @see #getValueN()
   * @generated
   */
  void setValueN(Expression value);

  /**
   * Returns the value of the '<em><b>Value B</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Value B</em>' containment reference.
   * @see #setValueB(Expression)
   * @see fr.supelec.tesl.lang.tesl.TeslPackage#getTagExpr_ValueB()
   * @model containment="true"
   * @generated
   */
  Expression getValueB();

  /**
   * Sets the value of the '{@link fr.supelec.tesl.lang.tesl.TagExpr#getValueB <em>Value B</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Value B</em>' containment reference.
   * @see #getValueB()
   * @generated
   */
  void setValueB(Expression value);

} // TagExpr
