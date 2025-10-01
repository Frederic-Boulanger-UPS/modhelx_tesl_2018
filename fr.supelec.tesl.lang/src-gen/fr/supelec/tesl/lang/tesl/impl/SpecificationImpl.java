/**
 */
package fr.supelec.tesl.lang.tesl.impl;

import fr.supelec.tesl.lang.tesl.Clock;
import fr.supelec.tesl.lang.tesl.Let;
import fr.supelec.tesl.lang.tesl.Pragma;
import fr.supelec.tesl.lang.tesl.Relation;
import fr.supelec.tesl.lang.tesl.Specification;
import fr.supelec.tesl.lang.tesl.TeslPackage;

import java.util.Collection;

import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Specification</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link fr.supelec.tesl.lang.tesl.impl.SpecificationImpl#getDecl <em>Decl</em>}</li>
 *   <li>{@link fr.supelec.tesl.lang.tesl.impl.SpecificationImpl#getRel <em>Rel</em>}</li>
 *   <li>{@link fr.supelec.tesl.lang.tesl.impl.SpecificationImpl#getLet <em>Let</em>}</li>
 *   <li>{@link fr.supelec.tesl.lang.tesl.impl.SpecificationImpl#getPragmas <em>Pragmas</em>}</li>
 * </ul>
 *
 * @generated
 */
public class SpecificationImpl extends MinimalEObjectImpl.Container implements Specification
{
  /**
   * The cached value of the '{@link #getDecl() <em>Decl</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getDecl()
   * @generated
   * @ordered
   */
  protected EList<Clock> decl;

  /**
   * The cached value of the '{@link #getRel() <em>Rel</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getRel()
   * @generated
   * @ordered
   */
  protected EList<Relation> rel;

  /**
   * The cached value of the '{@link #getLet() <em>Let</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getLet()
   * @generated
   * @ordered
   */
  protected EList<Let> let;

  /**
   * The cached value of the '{@link #getPragmas() <em>Pragmas</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getPragmas()
   * @generated
   * @ordered
   */
  protected EList<Pragma> pragmas;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected SpecificationImpl()
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
    return TeslPackage.Literals.SPECIFICATION;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EList<Clock> getDecl()
  {
    if (decl == null)
    {
      decl = new EObjectContainmentEList<Clock>(Clock.class, this, TeslPackage.SPECIFICATION__DECL);
    }
    return decl;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EList<Relation> getRel()
  {
    if (rel == null)
    {
      rel = new EObjectContainmentEList<Relation>(Relation.class, this, TeslPackage.SPECIFICATION__REL);
    }
    return rel;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EList<Let> getLet()
  {
    if (let == null)
    {
      let = new EObjectContainmentEList<Let>(Let.class, this, TeslPackage.SPECIFICATION__LET);
    }
    return let;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EList<Pragma> getPragmas()
  {
    if (pragmas == null)
    {
      pragmas = new EObjectContainmentEList<Pragma>(Pragma.class, this, TeslPackage.SPECIFICATION__PRAGMAS);
    }
    return pragmas;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs)
  {
    switch (featureID)
    {
      case TeslPackage.SPECIFICATION__DECL:
        return ((InternalEList<?>)getDecl()).basicRemove(otherEnd, msgs);
      case TeslPackage.SPECIFICATION__REL:
        return ((InternalEList<?>)getRel()).basicRemove(otherEnd, msgs);
      case TeslPackage.SPECIFICATION__LET:
        return ((InternalEList<?>)getLet()).basicRemove(otherEnd, msgs);
      case TeslPackage.SPECIFICATION__PRAGMAS:
        return ((InternalEList<?>)getPragmas()).basicRemove(otherEnd, msgs);
    }
    return super.eInverseRemove(otherEnd, featureID, msgs);
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
      case TeslPackage.SPECIFICATION__DECL:
        return getDecl();
      case TeslPackage.SPECIFICATION__REL:
        return getRel();
      case TeslPackage.SPECIFICATION__LET:
        return getLet();
      case TeslPackage.SPECIFICATION__PRAGMAS:
        return getPragmas();
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
      case TeslPackage.SPECIFICATION__DECL:
        getDecl().clear();
        getDecl().addAll((Collection<? extends Clock>)newValue);
        return;
      case TeslPackage.SPECIFICATION__REL:
        getRel().clear();
        getRel().addAll((Collection<? extends Relation>)newValue);
        return;
      case TeslPackage.SPECIFICATION__LET:
        getLet().clear();
        getLet().addAll((Collection<? extends Let>)newValue);
        return;
      case TeslPackage.SPECIFICATION__PRAGMAS:
        getPragmas().clear();
        getPragmas().addAll((Collection<? extends Pragma>)newValue);
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
      case TeslPackage.SPECIFICATION__DECL:
        getDecl().clear();
        return;
      case TeslPackage.SPECIFICATION__REL:
        getRel().clear();
        return;
      case TeslPackage.SPECIFICATION__LET:
        getLet().clear();
        return;
      case TeslPackage.SPECIFICATION__PRAGMAS:
        getPragmas().clear();
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
      case TeslPackage.SPECIFICATION__DECL:
        return decl != null && !decl.isEmpty();
      case TeslPackage.SPECIFICATION__REL:
        return rel != null && !rel.isEmpty();
      case TeslPackage.SPECIFICATION__LET:
        return let != null && !let.isEmpty();
      case TeslPackage.SPECIFICATION__PRAGMAS:
        return pragmas != null && !pragmas.isEmpty();
    }
    return super.eIsSet(featureID);
  }

} //SpecificationImpl
