/**
 */
package fr.supelec.tesl.lang.tesl;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Implication Relation</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link fr.supelec.tesl.lang.tesl.ImplicationRelation#getSource <em>Source</em>}</li>
 *   <li>{@link fr.supelec.tesl.lang.tesl.ImplicationRelation#getQual <em>Qual</em>}</li>
 *   <li>{@link fr.supelec.tesl.lang.tesl.ImplicationRelation#getTarget <em>Target</em>}</li>
 * </ul>
 *
 * @see fr.supelec.tesl.lang.tesl.TeslPackage#getImplicationRelation()
 * @model
 * @generated
 */
public interface ImplicationRelation extends Relation
{
  /**
   * Returns the value of the '<em><b>Source</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Source</em>' reference.
   * @see #setSource(Clock)
   * @see fr.supelec.tesl.lang.tesl.TeslPackage#getImplicationRelation_Source()
   * @model
   * @generated
   */
  Clock getSource();

  /**
   * Sets the value of the '{@link fr.supelec.tesl.lang.tesl.ImplicationRelation#getSource <em>Source</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Source</em>' reference.
   * @see #getSource()
   * @generated
   */
  void setSource(Clock value);

  /**
   * Returns the value of the '<em><b>Qual</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Qual</em>' containment reference.
   * @see #setQual(ImplicationQualifier)
   * @see fr.supelec.tesl.lang.tesl.TeslPackage#getImplicationRelation_Qual()
   * @model containment="true"
   * @generated
   */
  ImplicationQualifier getQual();

  /**
   * Sets the value of the '{@link fr.supelec.tesl.lang.tesl.ImplicationRelation#getQual <em>Qual</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Qual</em>' containment reference.
   * @see #getQual()
   * @generated
   */
  void setQual(ImplicationQualifier value);

  /**
   * Returns the value of the '<em><b>Target</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Target</em>' reference.
   * @see #setTarget(Clock)
   * @see fr.supelec.tesl.lang.tesl.TeslPackage#getImplicationRelation_Target()
   * @model
   * @generated
   */
  Clock getTarget();

  /**
   * Sets the value of the '{@link fr.supelec.tesl.lang.tesl.ImplicationRelation#getTarget <em>Target</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Target</em>' reference.
   * @see #getTarget()
   * @generated
   */
  void setTarget(Clock value);

} // ImplicationRelation
