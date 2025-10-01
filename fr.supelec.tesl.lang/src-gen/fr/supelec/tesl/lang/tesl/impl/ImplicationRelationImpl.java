/**
 */
package fr.supelec.tesl.lang.tesl.impl;

import fr.supelec.tesl.lang.tesl.Clock;
import fr.supelec.tesl.lang.tesl.ImplicationQualifier;
import fr.supelec.tesl.lang.tesl.ImplicationRelation;
import fr.supelec.tesl.lang.tesl.TeslPackage;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Implication Relation</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link fr.supelec.tesl.lang.tesl.impl.ImplicationRelationImpl#getSource <em>Source</em>}</li>
 *   <li>{@link fr.supelec.tesl.lang.tesl.impl.ImplicationRelationImpl#getQual <em>Qual</em>}</li>
 *   <li>{@link fr.supelec.tesl.lang.tesl.impl.ImplicationRelationImpl#getTarget <em>Target</em>}</li>
 * </ul>
 *
 * @generated
 */
public class ImplicationRelationImpl extends RelationImpl implements ImplicationRelation
{
  /**
   * The cached value of the '{@link #getSource() <em>Source</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getSource()
   * @generated
   * @ordered
   */
  protected Clock source;

  /**
   * The cached value of the '{@link #getQual() <em>Qual</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getQual()
   * @generated
   * @ordered
   */
  protected ImplicationQualifier qual;

  /**
   * The cached value of the '{@link #getTarget() <em>Target</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getTarget()
   * @generated
   * @ordered
   */
  protected Clock target;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected ImplicationRelationImpl()
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
    return TeslPackage.Literals.IMPLICATION_RELATION;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public Clock getSource()
  {
    if (source != null && source.eIsProxy())
    {
      InternalEObject oldSource = (InternalEObject)source;
      source = (Clock)eResolveProxy(oldSource);
      if (source != oldSource)
      {
        if (eNotificationRequired())
          eNotify(new ENotificationImpl(this, Notification.RESOLVE, TeslPackage.IMPLICATION_RELATION__SOURCE, oldSource, source));
      }
    }
    return source;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Clock basicGetSource()
  {
    return source;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void setSource(Clock newSource)
  {
    Clock oldSource = source;
    source = newSource;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, TeslPackage.IMPLICATION_RELATION__SOURCE, oldSource, source));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public ImplicationQualifier getQual()
  {
    return qual;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetQual(ImplicationQualifier newQual, NotificationChain msgs)
  {
    ImplicationQualifier oldQual = qual;
    qual = newQual;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, TeslPackage.IMPLICATION_RELATION__QUAL, oldQual, newQual);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void setQual(ImplicationQualifier newQual)
  {
    if (newQual != qual)
    {
      NotificationChain msgs = null;
      if (qual != null)
        msgs = ((InternalEObject)qual).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - TeslPackage.IMPLICATION_RELATION__QUAL, null, msgs);
      if (newQual != null)
        msgs = ((InternalEObject)newQual).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - TeslPackage.IMPLICATION_RELATION__QUAL, null, msgs);
      msgs = basicSetQual(newQual, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, TeslPackage.IMPLICATION_RELATION__QUAL, newQual, newQual));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public Clock getTarget()
  {
    if (target != null && target.eIsProxy())
    {
      InternalEObject oldTarget = (InternalEObject)target;
      target = (Clock)eResolveProxy(oldTarget);
      if (target != oldTarget)
      {
        if (eNotificationRequired())
          eNotify(new ENotificationImpl(this, Notification.RESOLVE, TeslPackage.IMPLICATION_RELATION__TARGET, oldTarget, target));
      }
    }
    return target;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Clock basicGetTarget()
  {
    return target;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void setTarget(Clock newTarget)
  {
    Clock oldTarget = target;
    target = newTarget;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, TeslPackage.IMPLICATION_RELATION__TARGET, oldTarget, target));
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
      case TeslPackage.IMPLICATION_RELATION__QUAL:
        return basicSetQual(null, msgs);
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
      case TeslPackage.IMPLICATION_RELATION__SOURCE:
        if (resolve) return getSource();
        return basicGetSource();
      case TeslPackage.IMPLICATION_RELATION__QUAL:
        return getQual();
      case TeslPackage.IMPLICATION_RELATION__TARGET:
        if (resolve) return getTarget();
        return basicGetTarget();
    }
    return super.eGet(featureID, resolve, coreType);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void eSet(int featureID, Object newValue)
  {
    switch (featureID)
    {
      case TeslPackage.IMPLICATION_RELATION__SOURCE:
        setSource((Clock)newValue);
        return;
      case TeslPackage.IMPLICATION_RELATION__QUAL:
        setQual((ImplicationQualifier)newValue);
        return;
      case TeslPackage.IMPLICATION_RELATION__TARGET:
        setTarget((Clock)newValue);
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
      case TeslPackage.IMPLICATION_RELATION__SOURCE:
        setSource((Clock)null);
        return;
      case TeslPackage.IMPLICATION_RELATION__QUAL:
        setQual((ImplicationQualifier)null);
        return;
      case TeslPackage.IMPLICATION_RELATION__TARGET:
        setTarget((Clock)null);
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
      case TeslPackage.IMPLICATION_RELATION__SOURCE:
        return source != null;
      case TeslPackage.IMPLICATION_RELATION__QUAL:
        return qual != null;
      case TeslPackage.IMPLICATION_RELATION__TARGET:
        return target != null;
    }
    return super.eIsSet(featureID);
  }

} //ImplicationRelationImpl
