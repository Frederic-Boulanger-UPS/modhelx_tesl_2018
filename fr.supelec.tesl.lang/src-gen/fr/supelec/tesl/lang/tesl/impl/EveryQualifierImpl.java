/**
 */
package fr.supelec.tesl.lang.tesl.impl;

import fr.supelec.tesl.lang.tesl.EveryQualifier;
import fr.supelec.tesl.lang.tesl.Expression;
import fr.supelec.tesl.lang.tesl.TeslPackage;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Every Qualifier</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link fr.supelec.tesl.lang.tesl.impl.EveryQualifierImpl#getPeriod <em>Period</em>}</li>
 *   <li>{@link fr.supelec.tesl.lang.tesl.impl.EveryQualifierImpl#isOff <em>Off</em>}</li>
 *   <li>{@link fr.supelec.tesl.lang.tesl.impl.EveryQualifierImpl#getOffset <em>Offset</em>}</li>
 * </ul>
 *
 * @generated
 */
public class EveryQualifierImpl extends ImplicationQualifierImpl implements EveryQualifier
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
   * The default value of the '{@link #isOff() <em>Off</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isOff()
   * @generated
   * @ordered
   */
  protected static final boolean OFF_EDEFAULT = false;

  /**
   * The cached value of the '{@link #isOff() <em>Off</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isOff()
   * @generated
   * @ordered
   */
  protected boolean off = OFF_EDEFAULT;

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
  protected EveryQualifierImpl()
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
    return TeslPackage.Literals.EVERY_QUALIFIER;
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
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, TeslPackage.EVERY_QUALIFIER__PERIOD, oldPeriod, newPeriod);
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
        msgs = ((InternalEObject)period).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - TeslPackage.EVERY_QUALIFIER__PERIOD, null, msgs);
      if (newPeriod != null)
        msgs = ((InternalEObject)newPeriod).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - TeslPackage.EVERY_QUALIFIER__PERIOD, null, msgs);
      msgs = basicSetPeriod(newPeriod, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, TeslPackage.EVERY_QUALIFIER__PERIOD, newPeriod, newPeriod));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public boolean isOff()
  {
    return off;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void setOff(boolean newOff)
  {
    boolean oldOff = off;
    off = newOff;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, TeslPackage.EVERY_QUALIFIER__OFF, oldOff, off));
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
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, TeslPackage.EVERY_QUALIFIER__OFFSET, oldOffset, newOffset);
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
        msgs = ((InternalEObject)offset).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - TeslPackage.EVERY_QUALIFIER__OFFSET, null, msgs);
      if (newOffset != null)
        msgs = ((InternalEObject)newOffset).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - TeslPackage.EVERY_QUALIFIER__OFFSET, null, msgs);
      msgs = basicSetOffset(newOffset, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, TeslPackage.EVERY_QUALIFIER__OFFSET, newOffset, newOffset));
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
      case TeslPackage.EVERY_QUALIFIER__PERIOD:
        return basicSetPeriod(null, msgs);
      case TeslPackage.EVERY_QUALIFIER__OFFSET:
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
      case TeslPackage.EVERY_QUALIFIER__PERIOD:
        return getPeriod();
      case TeslPackage.EVERY_QUALIFIER__OFF:
        return isOff();
      case TeslPackage.EVERY_QUALIFIER__OFFSET:
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
      case TeslPackage.EVERY_QUALIFIER__PERIOD:
        setPeriod((Expression)newValue);
        return;
      case TeslPackage.EVERY_QUALIFIER__OFF:
        setOff((Boolean)newValue);
        return;
      case TeslPackage.EVERY_QUALIFIER__OFFSET:
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
      case TeslPackage.EVERY_QUALIFIER__PERIOD:
        setPeriod((Expression)null);
        return;
      case TeslPackage.EVERY_QUALIFIER__OFF:
        setOff(OFF_EDEFAULT);
        return;
      case TeslPackage.EVERY_QUALIFIER__OFFSET:
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
      case TeslPackage.EVERY_QUALIFIER__PERIOD:
        return period != null;
      case TeslPackage.EVERY_QUALIFIER__OFF:
        return off != OFF_EDEFAULT;
      case TeslPackage.EVERY_QUALIFIER__OFFSET:
        return offset != null;
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
    result.append(" (off: ");
    result.append(off);
    result.append(')');
    return result.toString();
  }

} //EveryQualifierImpl
