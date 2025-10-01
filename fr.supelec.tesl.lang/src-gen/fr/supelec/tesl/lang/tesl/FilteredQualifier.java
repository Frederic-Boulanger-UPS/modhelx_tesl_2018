/**
 */
package fr.supelec.tesl.lang.tesl;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Filtered Qualifier</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link fr.supelec.tesl.lang.tesl.FilteredQualifier#getPattern <em>Pattern</em>}</li>
 * </ul>
 *
 * @see fr.supelec.tesl.lang.tesl.TeslPackage#getFilteredQualifier()
 * @model
 * @generated
 */
public interface FilteredQualifier extends ImplicationQualifier
{
  /**
   * Returns the value of the '<em><b>Pattern</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Pattern</em>' containment reference.
   * @see #setPattern(Pattern)
   * @see fr.supelec.tesl.lang.tesl.TeslPackage#getFilteredQualifier_Pattern()
   * @model containment="true"
   * @generated
   */
  Pattern getPattern();

  /**
   * Sets the value of the '{@link fr.supelec.tesl.lang.tesl.FilteredQualifier#getPattern <em>Pattern</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Pattern</em>' containment reference.
   * @see #getPattern()
   * @generated
   */
  void setPattern(Pattern value);

} // FilteredQualifier
