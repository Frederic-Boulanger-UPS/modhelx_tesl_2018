/**
 */
package fr.supelec.tesl.lang.tesl.impl;

import fr.supelec.tesl.lang.tesl.Clock;
import fr.supelec.tesl.lang.tesl.DelayedQualifier;
import fr.supelec.tesl.lang.tesl.Expression;
import fr.supelec.tesl.lang.tesl.TeslPackage;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Delayed Qualifier</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link fr.supelec.tesl.lang.tesl.impl.DelayedQualifierImpl#isImmediately <em>Immediately</em>}</li>
 *   <li>{@link fr.supelec.tesl.lang.tesl.impl.DelayedQualifierImpl#getCount <em>Count</em>}</li>
 *   <li>{@link fr.supelec.tesl.lang.tesl.impl.DelayedQualifierImpl#isReset <em>Reset</em>}</li>
 *   <li>{@link fr.supelec.tesl.lang.tesl.impl.DelayedQualifierImpl#getClock <em>Clock</em>}</li>
 * </ul>
 *
 * @generated
 */
public class DelayedQualifierImpl extends ImplicationQualifierImpl implements DelayedQualifier
{
  /**
   * The default value of the '{@link #isImmediately() <em>Immediately</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isImmediately()
   * @generated
   * @ordered
   */
  protected static final boolean IMMEDIATELY_EDEFAULT = false;

  /**
   * The cached value of the '{@link #isImmediately() <em>Immediately</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isImmediately()
   * @generated
   * @ordered
   */
  protected boolean immediately = IMMEDIATELY_EDEFAULT;

  /**
   * The cached value of the '{@link #getCount() <em>Count</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getCount()
   * @generated
   * @ordered
   */
  protected Expression count;

  /**
   * The default value of the '{@link #isReset() <em>Reset</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isReset()
   * @generated
   * @ordered
   */
  protected static final boolean RESET_EDEFAULT = false;

  /**
   * The cached value of the '{@link #isReset() <em>Reset</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isReset()
   * @generated
   * @ordered
   */
  protected boolean reset = RESET_EDEFAULT;

  /**
   * The cached value of the '{@link #getClock() <em>Clock</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getClock()
   * @generated
   * @ordered
   */
  protected Clock clock;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected DelayedQualifierImpl()
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
    return TeslPackage.Literals.DELAYED_QUALIFIER;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public boolean isImmediately()
  {
    return immediately;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void setImmediately(boolean newImmediately)
  {
    boolean oldImmediately = immediately;
    immediately = newImmediately;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, TeslPackage.DELAYED_QUALIFIER__IMMEDIATELY, oldImmediately, immediately));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public Expression getCount()
  {
    return count;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetCount(Expression newCount, NotificationChain msgs)
  {
    Expression oldCount = count;
    count = newCount;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, TeslPackage.DELAYED_QUALIFIER__COUNT, oldCount, newCount);
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
  public void setCount(Expression newCount)
  {
    if (newCount != count)
    {
      NotificationChain msgs = null;
      if (count != null)
        msgs = ((InternalEObject)count).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - TeslPackage.DELAYED_QUALIFIER__COUNT, null, msgs);
      if (newCount != null)
        msgs = ((InternalEObject)newCount).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - TeslPackage.DELAYED_QUALIFIER__COUNT, null, msgs);
      msgs = basicSetCount(newCount, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, TeslPackage.DELAYED_QUALIFIER__COUNT, newCount, newCount));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public boolean isReset()
  {
    return reset;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void setReset(boolean newReset)
  {
    boolean oldReset = reset;
    reset = newReset;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, TeslPackage.DELAYED_QUALIFIER__RESET, oldReset, reset));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public Clock getClock()
  {
    if (clock != null && clock.eIsProxy())
    {
      InternalEObject oldClock = (InternalEObject)clock;
      clock = (Clock)eResolveProxy(oldClock);
      if (clock != oldClock)
      {
        if (eNotificationRequired())
          eNotify(new ENotificationImpl(this, Notification.RESOLVE, TeslPackage.DELAYED_QUALIFIER__CLOCK, oldClock, clock));
      }
    }
    return clock;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Clock basicGetClock()
  {
    return clock;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void setClock(Clock newClock)
  {
    Clock oldClock = clock;
    clock = newClock;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, TeslPackage.DELAYED_QUALIFIER__CLOCK, oldClock, clock));
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
      case TeslPackage.DELAYED_QUALIFIER__COUNT:
        return basicSetCount(null, msgs);
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
      case TeslPackage.DELAYED_QUALIFIER__IMMEDIATELY:
        return isImmediately();
      case TeslPackage.DELAYED_QUALIFIER__COUNT:
        return getCount();
      case TeslPackage.DELAYED_QUALIFIER__RESET:
        return isReset();
      case TeslPackage.DELAYED_QUALIFIER__CLOCK:
        if (resolve) return getClock();
        return basicGetClock();
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
      case TeslPackage.DELAYED_QUALIFIER__IMMEDIATELY:
        setImmediately((Boolean)newValue);
        return;
      case TeslPackage.DELAYED_QUALIFIER__COUNT:
        setCount((Expression)newValue);
        return;
      case TeslPackage.DELAYED_QUALIFIER__RESET:
        setReset((Boolean)newValue);
        return;
      case TeslPackage.DELAYED_QUALIFIER__CLOCK:
        setClock((Clock)newValue);
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
      case TeslPackage.DELAYED_QUALIFIER__IMMEDIATELY:
        setImmediately(IMMEDIATELY_EDEFAULT);
        return;
      case TeslPackage.DELAYED_QUALIFIER__COUNT:
        setCount((Expression)null);
        return;
      case TeslPackage.DELAYED_QUALIFIER__RESET:
        setReset(RESET_EDEFAULT);
        return;
      case TeslPackage.DELAYED_QUALIFIER__CLOCK:
        setClock((Clock)null);
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
      case TeslPackage.DELAYED_QUALIFIER__IMMEDIATELY:
        return immediately != IMMEDIATELY_EDEFAULT;
      case TeslPackage.DELAYED_QUALIFIER__COUNT:
        return count != null;
      case TeslPackage.DELAYED_QUALIFIER__RESET:
        return reset != RESET_EDEFAULT;
      case TeslPackage.DELAYED_QUALIFIER__CLOCK:
        return clock != null;
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
    result.append(" (immediately: ");
    result.append(immediately);
    result.append(", reset: ");
    result.append(reset);
    result.append(')');
    return result.toString();
  }

} //DelayedQualifierImpl
