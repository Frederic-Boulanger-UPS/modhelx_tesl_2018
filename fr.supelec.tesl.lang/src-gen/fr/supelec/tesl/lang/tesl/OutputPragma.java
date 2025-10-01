/**
 */
package fr.supelec.tesl.lang.tesl;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Output Pragma</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link fr.supelec.tesl.lang.tesl.OutputPragma#getType <em>Type</em>}</li>
 *   <li>{@link fr.supelec.tesl.lang.tesl.OutputPragma#isSelection <em>Selection</em>}</li>
 *   <li>{@link fr.supelec.tesl.lang.tesl.OutputPragma#getSelectedClocks <em>Selected Clocks</em>}</li>
 *   <li>{@link fr.supelec.tesl.lang.tesl.OutputPragma#isWindow <em>Window</em>}</li>
 *   <li>{@link fr.supelec.tesl.lang.tesl.OutputPragma#getFrom <em>From</em>}</li>
 *   <li>{@link fr.supelec.tesl.lang.tesl.OutputPragma#getTo <em>To</em>}</li>
 *   <li>{@link fr.supelec.tesl.lang.tesl.OutputPragma#getLabelif <em>Labelif</em>}</li>
 *   <li>{@link fr.supelec.tesl.lang.tesl.OutputPragma#isXscaled <em>Xscaled</em>}</li>
 *   <li>{@link fr.supelec.tesl.lang.tesl.OutputPragma#getXscale <em>Xscale</em>}</li>
 *   <li>{@link fr.supelec.tesl.lang.tesl.OutputPragma#getBorder <em>Border</em>}</li>
 *   <li>{@link fr.supelec.tesl.lang.tesl.OutputPragma#getCss <em>Css</em>}</li>
 *   <li>{@link fr.supelec.tesl.lang.tesl.OutputPragma#isNodefcss <em>Nodefcss</em>}</li>
 *   <li>{@link fr.supelec.tesl.lang.tesl.OutputPragma#getJvs <em>Jvs</em>}</li>
 *   <li>{@link fr.supelec.tesl.lang.tesl.OutputPragma#isStandalone <em>Standalone</em>}</li>
 *   <li>{@link fr.supelec.tesl.lang.tesl.OutputPragma#isOverwrite <em>Overwrite</em>}</li>
 * </ul>
 *
 * @see fr.supelec.tesl.lang.tesl.TeslPackage#getOutputPragma()
 * @model
 * @generated
 */
public interface OutputPragma extends Pragma
{
  /**
   * Returns the value of the '<em><b>Type</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Type</em>' attribute.
   * @see #setType(String)
   * @see fr.supelec.tesl.lang.tesl.TeslPackage#getOutputPragma_Type()
   * @model
   * @generated
   */
  String getType();

  /**
   * Sets the value of the '{@link fr.supelec.tesl.lang.tesl.OutputPragma#getType <em>Type</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Type</em>' attribute.
   * @see #getType()
   * @generated
   */
  void setType(String value);

  /**
   * Returns the value of the '<em><b>Selection</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Selection</em>' attribute.
   * @see #setSelection(boolean)
   * @see fr.supelec.tesl.lang.tesl.TeslPackage#getOutputPragma_Selection()
   * @model
   * @generated
   */
  boolean isSelection();

  /**
   * Sets the value of the '{@link fr.supelec.tesl.lang.tesl.OutputPragma#isSelection <em>Selection</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Selection</em>' attribute.
   * @see #isSelection()
   * @generated
   */
  void setSelection(boolean value);

  /**
   * Returns the value of the '<em><b>Selected Clocks</b></em>' containment reference list.
   * The list contents are of type {@link fr.supelec.tesl.lang.tesl.ClockItem}.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Selected Clocks</em>' containment reference list.
   * @see fr.supelec.tesl.lang.tesl.TeslPackage#getOutputPragma_SelectedClocks()
   * @model containment="true"
   * @generated
   */
  EList<ClockItem> getSelectedClocks();

  /**
   * Returns the value of the '<em><b>Window</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Window</em>' attribute.
   * @see #setWindow(boolean)
   * @see fr.supelec.tesl.lang.tesl.TeslPackage#getOutputPragma_Window()
   * @model
   * @generated
   */
  boolean isWindow();

  /**
   * Sets the value of the '{@link fr.supelec.tesl.lang.tesl.OutputPragma#isWindow <em>Window</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Window</em>' attribute.
   * @see #isWindow()
   * @generated
   */
  void setWindow(boolean value);

  /**
   * Returns the value of the '<em><b>From</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>From</em>' containment reference.
   * @see #setFrom(Expression)
   * @see fr.supelec.tesl.lang.tesl.TeslPackage#getOutputPragma_From()
   * @model containment="true"
   * @generated
   */
  Expression getFrom();

  /**
   * Sets the value of the '{@link fr.supelec.tesl.lang.tesl.OutputPragma#getFrom <em>From</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>From</em>' containment reference.
   * @see #getFrom()
   * @generated
   */
  void setFrom(Expression value);

  /**
   * Returns the value of the '<em><b>To</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>To</em>' containment reference.
   * @see #setTo(Expression)
   * @see fr.supelec.tesl.lang.tesl.TeslPackage#getOutputPragma_To()
   * @model containment="true"
   * @generated
   */
  Expression getTo();

  /**
   * Sets the value of the '{@link fr.supelec.tesl.lang.tesl.OutputPragma#getTo <em>To</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>To</em>' containment reference.
   * @see #getTo()
   * @generated
   */
  void setTo(Expression value);

  /**
   * Returns the value of the '<em><b>Labelif</b></em>' reference list.
   * The list contents are of type {@link fr.supelec.tesl.lang.tesl.Clock}.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Labelif</em>' reference list.
   * @see fr.supelec.tesl.lang.tesl.TeslPackage#getOutputPragma_Labelif()
   * @model
   * @generated
   */
  EList<Clock> getLabelif();

  /**
   * Returns the value of the '<em><b>Xscaled</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Xscaled</em>' attribute.
   * @see #setXscaled(boolean)
   * @see fr.supelec.tesl.lang.tesl.TeslPackage#getOutputPragma_Xscaled()
   * @model
   * @generated
   */
  boolean isXscaled();

  /**
   * Sets the value of the '{@link fr.supelec.tesl.lang.tesl.OutputPragma#isXscaled <em>Xscaled</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Xscaled</em>' attribute.
   * @see #isXscaled()
   * @generated
   */
  void setXscaled(boolean value);

  /**
   * Returns the value of the '<em><b>Xscale</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Xscale</em>' containment reference.
   * @see #setXscale(Expression)
   * @see fr.supelec.tesl.lang.tesl.TeslPackage#getOutputPragma_Xscale()
   * @model containment="true"
   * @generated
   */
  Expression getXscale();

  /**
   * Sets the value of the '{@link fr.supelec.tesl.lang.tesl.OutputPragma#getXscale <em>Xscale</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Xscale</em>' containment reference.
   * @see #getXscale()
   * @generated
   */
  void setXscale(Expression value);

  /**
   * Returns the value of the '<em><b>Border</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Border</em>' attribute.
   * @see #setBorder(String)
   * @see fr.supelec.tesl.lang.tesl.TeslPackage#getOutputPragma_Border()
   * @model
   * @generated
   */
  String getBorder();

  /**
   * Sets the value of the '{@link fr.supelec.tesl.lang.tesl.OutputPragma#getBorder <em>Border</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Border</em>' attribute.
   * @see #getBorder()
   * @generated
   */
  void setBorder(String value);

  /**
   * Returns the value of the '<em><b>Css</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Css</em>' attribute.
   * @see #setCss(String)
   * @see fr.supelec.tesl.lang.tesl.TeslPackage#getOutputPragma_Css()
   * @model
   * @generated
   */
  String getCss();

  /**
   * Sets the value of the '{@link fr.supelec.tesl.lang.tesl.OutputPragma#getCss <em>Css</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Css</em>' attribute.
   * @see #getCss()
   * @generated
   */
  void setCss(String value);

  /**
   * Returns the value of the '<em><b>Nodefcss</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Nodefcss</em>' attribute.
   * @see #setNodefcss(boolean)
   * @see fr.supelec.tesl.lang.tesl.TeslPackage#getOutputPragma_Nodefcss()
   * @model
   * @generated
   */
  boolean isNodefcss();

  /**
   * Sets the value of the '{@link fr.supelec.tesl.lang.tesl.OutputPragma#isNodefcss <em>Nodefcss</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Nodefcss</em>' attribute.
   * @see #isNodefcss()
   * @generated
   */
  void setNodefcss(boolean value);

  /**
   * Returns the value of the '<em><b>Jvs</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Jvs</em>' attribute.
   * @see #setJvs(String)
   * @see fr.supelec.tesl.lang.tesl.TeslPackage#getOutputPragma_Jvs()
   * @model
   * @generated
   */
  String getJvs();

  /**
   * Sets the value of the '{@link fr.supelec.tesl.lang.tesl.OutputPragma#getJvs <em>Jvs</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Jvs</em>' attribute.
   * @see #getJvs()
   * @generated
   */
  void setJvs(String value);

  /**
   * Returns the value of the '<em><b>Standalone</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Standalone</em>' attribute.
   * @see #setStandalone(boolean)
   * @see fr.supelec.tesl.lang.tesl.TeslPackage#getOutputPragma_Standalone()
   * @model
   * @generated
   */
  boolean isStandalone();

  /**
   * Sets the value of the '{@link fr.supelec.tesl.lang.tesl.OutputPragma#isStandalone <em>Standalone</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Standalone</em>' attribute.
   * @see #isStandalone()
   * @generated
   */
  void setStandalone(boolean value);

  /**
   * Returns the value of the '<em><b>Overwrite</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Overwrite</em>' attribute.
   * @see #setOverwrite(boolean)
   * @see fr.supelec.tesl.lang.tesl.TeslPackage#getOutputPragma_Overwrite()
   * @model
   * @generated
   */
  boolean isOverwrite();

  /**
   * Sets the value of the '{@link fr.supelec.tesl.lang.tesl.OutputPragma#isOverwrite <em>Overwrite</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Overwrite</em>' attribute.
   * @see #isOverwrite()
   * @generated
   */
  void setOverwrite(boolean value);

} // OutputPragma
