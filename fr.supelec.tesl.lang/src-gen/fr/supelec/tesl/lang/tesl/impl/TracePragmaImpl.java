/**
 */
package fr.supelec.tesl.lang.tesl.impl;

import fr.supelec.tesl.lang.tesl.TeslPackage;
import fr.supelec.tesl.lang.tesl.TracePragma;

import java.util.Collection;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.util.EDataTypeEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Trace Pragma</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link fr.supelec.tesl.lang.tesl.impl.TracePragmaImpl#getKinds <em>Kinds</em>}</li>
 * </ul>
 *
 * @generated
 */
public class TracePragmaImpl extends PragmaImpl implements TracePragma
{
  /**
   * The cached value of the '{@link #getKinds() <em>Kinds</em>}' attribute list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getKinds()
   * @generated
   * @ordered
   */
  protected EList<String> kinds;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected TracePragmaImpl()
  {
    super();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  protected EClass eStaticClass()
  {
    return TeslPackage.Literals.TRACE_PRAGMA;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EList<String> getKinds()
  {
    if (kinds == null)
    {
      kinds = new EDataTypeEList<String>(String.class, this, TeslPackage.TRACE_PRAGMA__KINDS);
    }
    return kinds;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public Object eGet(int featureID, boolean resolve, boolean coreType)
  {
    switch (featureID)
    {
      case TeslPackage.TRACE_PRAGMA__KINDS:
        return getKinds();
    }
    return super.eGet(featureID, resolve, coreType);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @SuppressWarnings("unchecked")
  @Override
  public void eSet(int featureID, Object newValue)
  {
    switch (featureID)
    {
      case TeslPackage.TRACE_PRAGMA__KINDS:
        getKinds().clear();
        getKinds().addAll((Collection<? extends String>)newValue);
        return;
    }
    super.eSet(featureID, newValue);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void eUnset(int featureID)
  {
    switch (featureID)
    {
      case TeslPackage.TRACE_PRAGMA__KINDS:
        getKinds().clear();
        return;
    }
    super.eUnset(featureID);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public boolean eIsSet(int featureID)
  {
    switch (featureID)
    {
      case TeslPackage.TRACE_PRAGMA__KINDS:
        return kinds != null && !kinds.isEmpty();
    }
    return super.eIsSet(featureID);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public String toString()
  {
    if (eIsProxy()) return super.toString();

    StringBuilder result = new StringBuilder(super.toString());
    result.append(" (kinds: ");
    result.append(kinds);
    result.append(')');
    return result.toString();
  }

} //TracePragmaImpl
