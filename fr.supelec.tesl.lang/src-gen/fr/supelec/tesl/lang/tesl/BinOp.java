/**
 */
package fr.supelec.tesl.lang.tesl;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Bin Op</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link fr.supelec.tesl.lang.tesl.BinOp#getLeft <em>Left</em>}</li>
 *   <li>{@link fr.supelec.tesl.lang.tesl.BinOp#getOp <em>Op</em>}</li>
 *   <li>{@link fr.supelec.tesl.lang.tesl.BinOp#getRight <em>Right</em>}</li>
 * </ul>
 *
 * @see fr.supelec.tesl.lang.tesl.TeslPackage#getBinOp()
 * @model
 * @generated
 */
public interface BinOp extends Expression
{
  /**
   * Returns the value of the '<em><b>Left</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Left</em>' containment reference.
   * @see #setLeft(Expression)
   * @see fr.supelec.tesl.lang.tesl.TeslPackage#getBinOp_Left()
   * @model containment="true"
   * @generated
   */
  Expression getLeft();

  /**
   * Sets the value of the '{@link fr.supelec.tesl.lang.tesl.BinOp#getLeft <em>Left</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Left</em>' containment reference.
   * @see #getLeft()
   * @generated
   */
  void setLeft(Expression value);

  /**
   * Returns the value of the '<em><b>Op</b></em>' attribute.
   * The literals are from the enumeration {@link fr.supelec.tesl.lang.tesl.Op}.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Op</em>' attribute.
   * @see fr.supelec.tesl.lang.tesl.Op
   * @see #setOp(Op)
   * @see fr.supelec.tesl.lang.tesl.TeslPackage#getBinOp_Op()
   * @model
   * @generated
   */
  Op getOp();

  /**
   * Sets the value of the '{@link fr.supelec.tesl.lang.tesl.BinOp#getOp <em>Op</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Op</em>' attribute.
   * @see fr.supelec.tesl.lang.tesl.Op
   * @see #getOp()
   * @generated
   */
  void setOp(Op value);

  /**
   * Returns the value of the '<em><b>Right</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Right</em>' containment reference.
   * @see #setRight(Expression)
   * @see fr.supelec.tesl.lang.tesl.TeslPackage#getBinOp_Right()
   * @model containment="true"
   * @generated
   */
  Expression getRight();

  /**
   * Sets the value of the '{@link fr.supelec.tesl.lang.tesl.BinOp#getRight <em>Right</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Right</em>' containment reference.
   * @see #getRight()
   * @generated
   */
  void setRight(Expression value);

} // BinOp
