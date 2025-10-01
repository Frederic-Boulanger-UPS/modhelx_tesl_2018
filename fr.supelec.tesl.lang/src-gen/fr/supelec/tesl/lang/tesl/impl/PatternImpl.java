/**
 */
package fr.supelec.tesl.lang.tesl.impl;

import fr.supelec.tesl.lang.tesl.Expression;
import fr.supelec.tesl.lang.tesl.Pattern;
import fr.supelec.tesl.lang.tesl.TeslPackage;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Pattern</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link fr.supelec.tesl.lang.tesl.impl.PatternImpl#getSkip <em>Skip</em>}</li>
 *   <li>{@link fr.supelec.tesl.lang.tesl.impl.PatternImpl#getKeep <em>Keep</em>}</li>
 *   <li>{@link fr.supelec.tesl.lang.tesl.impl.PatternImpl#isRep <em>Rep</em>}</li>
 *   <li>{@link fr.supelec.tesl.lang.tesl.impl.PatternImpl#getRepskip <em>Repskip</em>}</li>
 *   <li>{@link fr.supelec.tesl.lang.tesl.impl.PatternImpl#getRepkeep <em>Repkeep</em>}</li>
 * </ul>
 *
 * @generated
 */
public class PatternImpl extends MinimalEObjectImpl.Container implements Pattern
{
  /**
   * The cached value of the '{@link #getSkip() <em>Skip</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getSkip()
   * @generated
   * @ordered
   */
  protected Expression skip;

  /**
   * The cached value of the '{@link #getKeep() <em>Keep</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getKeep()
   * @generated
   * @ordered
   */
  protected Expression keep;

  /**
   * The default value of the '{@link #isRep() <em>Rep</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isRep()
   * @generated
   * @ordered
   */
  protected static final boolean REP_EDEFAULT = false;

  /**
   * The cached value of the '{@link #isRep() <em>Rep</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isRep()
   * @generated
   * @ordered
   */
  protected boolean rep = REP_EDEFAULT;

  /**
   * The cached value of the '{@link #getRepskip() <em>Repskip</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getRepskip()
   * @generated
   * @ordered
   */
  protected Expression repskip;

  /**
   * The cached value of the '{@link #getRepkeep() <em>Repkeep</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getRepkeep()
   * @generated
   * @ordered
   */
  protected Expression repkeep;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected PatternImpl()
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
    return TeslPackage.Literals.PATTERN;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public Expression getSkip()
  {
    return skip;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetSkip(Expression newSkip, NotificationChain msgs)
  {
    Expression oldSkip = skip;
    skip = newSkip;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, TeslPackage.PATTERN__SKIP, oldSkip, newSkip);
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
  public void setSkip(Expression newSkip)
  {
    if (newSkip != skip)
    {
      NotificationChain msgs = null;
      if (skip != null)
        msgs = ((InternalEObject)skip).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - TeslPackage.PATTERN__SKIP, null, msgs);
      if (newSkip != null)
        msgs = ((InternalEObject)newSkip).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - TeslPackage.PATTERN__SKIP, null, msgs);
      msgs = basicSetSkip(newSkip, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, TeslPackage.PATTERN__SKIP, newSkip, newSkip));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public Expression getKeep()
  {
    return keep;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetKeep(Expression newKeep, NotificationChain msgs)
  {
    Expression oldKeep = keep;
    keep = newKeep;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, TeslPackage.PATTERN__KEEP, oldKeep, newKeep);
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
  public void setKeep(Expression newKeep)
  {
    if (newKeep != keep)
    {
      NotificationChain msgs = null;
      if (keep != null)
        msgs = ((InternalEObject)keep).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - TeslPackage.PATTERN__KEEP, null, msgs);
      if (newKeep != null)
        msgs = ((InternalEObject)newKeep).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - TeslPackage.PATTERN__KEEP, null, msgs);
      msgs = basicSetKeep(newKeep, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, TeslPackage.PATTERN__KEEP, newKeep, newKeep));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public boolean isRep()
  {
    return rep;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void setRep(boolean newRep)
  {
    boolean oldRep = rep;
    rep = newRep;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, TeslPackage.PATTERN__REP, oldRep, rep));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public Expression getRepskip()
  {
    return repskip;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetRepskip(Expression newRepskip, NotificationChain msgs)
  {
    Expression oldRepskip = repskip;
    repskip = newRepskip;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, TeslPackage.PATTERN__REPSKIP, oldRepskip, newRepskip);
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
  public void setRepskip(Expression newRepskip)
  {
    if (newRepskip != repskip)
    {
      NotificationChain msgs = null;
      if (repskip != null)
        msgs = ((InternalEObject)repskip).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - TeslPackage.PATTERN__REPSKIP, null, msgs);
      if (newRepskip != null)
        msgs = ((InternalEObject)newRepskip).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - TeslPackage.PATTERN__REPSKIP, null, msgs);
      msgs = basicSetRepskip(newRepskip, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, TeslPackage.PATTERN__REPSKIP, newRepskip, newRepskip));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public Expression getRepkeep()
  {
    return repkeep;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetRepkeep(Expression newRepkeep, NotificationChain msgs)
  {
    Expression oldRepkeep = repkeep;
    repkeep = newRepkeep;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, TeslPackage.PATTERN__REPKEEP, oldRepkeep, newRepkeep);
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
  public void setRepkeep(Expression newRepkeep)
  {
    if (newRepkeep != repkeep)
    {
      NotificationChain msgs = null;
      if (repkeep != null)
        msgs = ((InternalEObject)repkeep).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - TeslPackage.PATTERN__REPKEEP, null, msgs);
      if (newRepkeep != null)
        msgs = ((InternalEObject)newRepkeep).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - TeslPackage.PATTERN__REPKEEP, null, msgs);
      msgs = basicSetRepkeep(newRepkeep, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, TeslPackage.PATTERN__REPKEEP, newRepkeep, newRepkeep));
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
      case TeslPackage.PATTERN__SKIP:
        return basicSetSkip(null, msgs);
      case TeslPackage.PATTERN__KEEP:
        return basicSetKeep(null, msgs);
      case TeslPackage.PATTERN__REPSKIP:
        return basicSetRepskip(null, msgs);
      case TeslPackage.PATTERN__REPKEEP:
        return basicSetRepkeep(null, msgs);
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
      case TeslPackage.PATTERN__SKIP:
        return getSkip();
      case TeslPackage.PATTERN__KEEP:
        return getKeep();
      case TeslPackage.PATTERN__REP:
        return isRep();
      case TeslPackage.PATTERN__REPSKIP:
        return getRepskip();
      case TeslPackage.PATTERN__REPKEEP:
        return getRepkeep();
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
      case TeslPackage.PATTERN__SKIP:
        setSkip((Expression)newValue);
        return;
      case TeslPackage.PATTERN__KEEP:
        setKeep((Expression)newValue);
        return;
      case TeslPackage.PATTERN__REP:
        setRep((Boolean)newValue);
        return;
      case TeslPackage.PATTERN__REPSKIP:
        setRepskip((Expression)newValue);
        return;
      case TeslPackage.PATTERN__REPKEEP:
        setRepkeep((Expression)newValue);
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
      case TeslPackage.PATTERN__SKIP:
        setSkip((Expression)null);
        return;
      case TeslPackage.PATTERN__KEEP:
        setKeep((Expression)null);
        return;
      case TeslPackage.PATTERN__REP:
        setRep(REP_EDEFAULT);
        return;
      case TeslPackage.PATTERN__REPSKIP:
        setRepskip((Expression)null);
        return;
      case TeslPackage.PATTERN__REPKEEP:
        setRepkeep((Expression)null);
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
      case TeslPackage.PATTERN__SKIP:
        return skip != null;
      case TeslPackage.PATTERN__KEEP:
        return keep != null;
      case TeslPackage.PATTERN__REP:
        return rep != REP_EDEFAULT;
      case TeslPackage.PATTERN__REPSKIP:
        return repskip != null;
      case TeslPackage.PATTERN__REPKEEP:
        return repkeep != null;
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
    result.append(" (rep: ");
    result.append(rep);
    result.append(')');
    return result.toString();
  }

} //PatternImpl
