/**
 */
package fr.supelec.tesl.lang.tesl.impl;

import fr.supelec.tesl.lang.tesl.Expression;
import fr.supelec.tesl.lang.tesl.PeriodicQualifier;
import fr.supelec.tesl.lang.tesl.TeslPackage;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Periodic Qualifier</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link fr.supelec.tesl.lang.tesl.impl.PeriodicQualifierImpl#getPeriod <em>Period</em>}</li>
 *   <li>{@link fr.supelec.tesl.lang.tesl.impl.PeriodicQualifierImpl#getOffset <em>Offset</em>}</li>
 * </ul>
 *
 * @generated
 */
public class PeriodicQualifierImpl extends ClockQualifierImpl implements PeriodicQualifier
{
  /**
   * The cached value of the '{@link #getPeriod() <em>Period</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getPeriod()
   * @generated
   * @ordered
   */
  protected Expression period;

  /**
   * The cached value of the '{@link #getOffset() <em>Offset</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getOffset()
   * @generated
   * @ordered
   */
  protected Expression offset;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected PeriodicQualifierImpl()
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
    return TeslPackage.Literals.PERIODIC_QUALIFIER;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public Expression getPeriod()
  {
    return period;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetPeriod(Expression newPeriod, NotificationChain msgs)
  {
    Expression oldPeriod = period;
    period = newPeriod;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, TeslPackage.PERIODIC_QUALIFIER__PERIOD, oldPeriod, newPeriod);
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
  public void setPeriod(Expression newPeriod)
  {
    if (newPeriod != period)
    {
      NotificationChain msgs = null;
      if (period != null)
        msgs = ((InternalEObject)period).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - TeslPackage.PERIODIC_QUALIFIER__PERIOD, null, msgs);
      if (newPeriod != null)
        msgs = ((InternalEObject)newPeriod).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - TeslPackage.PERIODIC_QUALIFIER__PERIOD, null, msgs);
      msgs = basicSetPeriod(newPeriod, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, TeslPackage.PERIODIC_QUALIFIER__PERIOD, newPeriod, newPeriod));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public Expression getOffset()
  {
    return offset;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetOffset(Expression newOffset, NotificationChain msgs)
  {
    Expression oldOffset = offset;
    offset = newOffset;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, TeslPackage.PERIODIC_QUALIFIER__OFFSET, oldOffset, newOffset);
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
  public void setOffset(Expression newOffset)
  {
    if (newOffset != offset)
    {
      NotificationChain msgs = null;
      if (offset != null)
        msgs = ((InternalEObject)offset).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - TeslPackage.PERIODIC_QUALIFIER__OFFSET, null, msgs);
      if (newOffset != null)
        msgs = ((InternalEObject)newOffset).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - TeslPackage.PERIODIC_QUALIFIER__OFFSET, null, msgs);
      msgs = basicSetOffset(newOffset, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, TeslPackage.PERIODIC_QUALIFIER__OFFSET, newOffset, newOffset));
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
      case TeslPackage.PERIODIC_QUALIFIER__PERIOD:
        return basicSetPeriod(null, msgs);
      case TeslPackage.PERIODIC_QUALIFIER__OFFSET:
        return basicSetOffset(null, msgs);
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
      case TeslPackage.PERIODIC_QUALIFIER__PERIOD:
        return getPeriod();
      case TeslPackage.PERIODIC_QUALIFIER__OFFSET:
        return getOffset();
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
      case TeslPackage.PERIODIC_QUALIFIER__PERIOD:
        setPeriod((Expression)newValue);
        return;
      case TeslPackage.PERIODIC_QUALIFIER__OFFSET:
        setOffset((Expression)newValue);
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
      case TeslPackage.PERIODIC_QUALIFIER__PERIOD:
        setPeriod((Expression)null);
        return;
      case TeslPackage.PERIODIC_QUALIFIER__OFFSET:
        setOffset((Expression)null);
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
      case TeslPackage.PERIODIC_QUALIFIER__PERIOD:
        return period != null;
      case TeslPackage.PERIODIC_QUALIFIER__OFFSET:
        return offset != null;
    }
    return super.eIsSet(featureID);
  }

} //PeriodicQualifierImpl
