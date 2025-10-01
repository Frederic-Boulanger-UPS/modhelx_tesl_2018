/**
 */
package fr.supelec.tesl.lang.tesl;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Tag Relation</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link fr.supelec.tesl.lang.tesl.TagRelation#getExpr <em>Expr</em>}</li>
 * </ul>
 *
 * @see fr.supelec.tesl.lang.tesl.TeslPackage#getTagRelation()
 * @model
 * @generated
 */
public interface TagRelation extends Relation
{
  /**
   * Returns the value of the '<em><b>Expr</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Expr</em>' containment reference.
   * @see #setExpr(TagExpr)
   * @see fr.supelec.tesl.lang.tesl.TeslPackage#getTagRelation_Expr()
   * @model containment="true"
   * @generated
   */
  TagExpr getExpr();

  /**
   * Sets the value of the '{@link fr.supelec.tesl.lang.tesl.TagRelation#getExpr <em>Expr</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Expr</em>' containment reference.
   * @see #getExpr()
   * @generated
   */
  void setExpr(TagExpr value);

} // TagRelation
