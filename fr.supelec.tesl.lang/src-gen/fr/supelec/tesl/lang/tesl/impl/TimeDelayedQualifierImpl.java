/**
 */
package fr.supelec.tesl.lang.tesl.impl;

import fr.supelec.tesl.lang.tesl.Clock;
import fr.supelec.tesl.lang.tesl.Expression;
import fr.supelec.tesl.lang.tesl.TeslPackage;
import fr.supelec.tesl.lang.tesl.TimeDelayedQualifier;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Time Delayed Qualifier</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link fr.supelec.tesl.lang.tesl.impl.TimeDelayedQualifierImpl#getDelay <em>Delay</em>}</li>
 *   <li>{@link fr.supelec.tesl.lang.tesl.impl.TimeDelayedQualifierImpl#getClock <em>Clock</em>}</li>
 *   <li>{@link fr.supelec.tesl.lang.tesl.impl.TimeDelayedQualifierImpl#isReset <em>Reset</em>}</li>
 *   <li>{@link fr.supelec.tesl.lang.tesl.impl.TimeDelayedQualifierImpl#isImmReset <em>Imm Reset</em>}</li>
 *   <li>{@link fr.supelec.tesl.lang.tesl.impl.TimeDelayedQualifierImpl#isStrongReset <em>Strong Reset</em>}</li>
 *   <li>{@link fr.supelec.tesl.lang.tesl.impl.TimeDelayedQualifierImpl#getResetClock <em>Reset Clock</em>}</li>
 * </ul>
 *
 * @generated
 */
public class TimeDelayedQualifierImpl extends ImplicationQualifierImpl implements TimeDelayedQualifier
{
  /**
   * The cached value of the '{@link #getDelay() <em>Delay</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getDelay()
   * @generated
   * @ordered
   */
  protected Expression delay;

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
   * The default value of the '{@link #isImmReset() <em>Imm Reset</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isImmReset()
   * @generated
   * @ordered
   */
  protected static final boolean IMM_RESET_EDEFAULT = false;

  /**
   * The cached value of the '{@link #isImmReset() <em>Imm Reset</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isImmReset()
   * @generated
   * @ordered
   */
  protected boolean immReset = IMM_RESET_EDEFAULT;

  /**
   * The default value of the '{@link #isStrongReset() <em>Strong Reset</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isStrongReset()
   * @generated
   * @ordered
   */
  protected static final boolean STRONG_RESET_EDEFAULT = false;

  /**
   * The cached value of the '{@link #isStrongReset() <em>Strong Reset</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isStrongReset()
   * @generated
   * @ordered
   */
  protected boolean strongReset = STRONG_RESET_EDEFAULT;

  /**
   * The cached value of the '{@link #getResetClock() <em>Reset Clock</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getResetClock()
   * @generated
   * @ordered
   */
  protected Clock resetClock;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected TimeDelayedQualifierImpl()
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
    return TeslPackage.Literals.TIME_DELAYED_QUALIFIER;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public Expression getDelay()
  {
    return delay;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetDelay(Expression newDelay, NotificationChain msgs)
  {
    Expression oldDelay = delay;
    delay = newDelay;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, TeslPackage.TIME_DELAYED_QUALIFIER__DELAY, oldDelay, newDelay);
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
  public void setDelay(Expression newDelay)
  {
    if (newDelay != delay)
    {
      NotificationChain msgs = null;
      if (delay != null)
        msgs = ((InternalEObject)delay).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - TeslPackage.TIME_DELAYED_QUALIFIER__DELAY, null, msgs);
      if (newDelay != null)
        msgs = ((InternalEObject)newDelay).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - TeslPackage.TIME_DELAYED_QUALIFIER__DELAY, null, msgs);
      msgs = basicSetDelay(newDelay, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, TeslPackage.TIME_DELAYED_QUALIFIER__DELAY, newDelay, newDelay));
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
          eNotify(new ENotificationImpl(this, Notification.RESOLVE, TeslPackage.TIME_DELAYED_QUALIFIER__CLOCK, oldClock, clock));
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
      eNotify(new ENotificationImpl(this, Notification.SET, TeslPackage.TIME_DELAYED_QUALIFIER__CLOCK, oldClock, clock));
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
      eNotify(new ENotificationImpl(this, Notification.SET, TeslPackage.TIME_DELAYED_QUALIFIER__RESET, oldReset, reset));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public boolean isImmReset()
  {
    return immReset;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void setImmReset(boolean newImmReset)
  {
    boolean oldImmReset = immReset;
    immReset = newImmReset;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, TeslPackage.TIME_DELAYED_QUALIFIER__IMM_RESET, oldImmReset, immReset));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public boolean isStrongReset()
  {
    return strongReset;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void setStrongReset(boolean newStrongReset)
  {
    boolean oldStrongReset = strongReset;
    strongReset = newStrongReset;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, TeslPackage.TIME_DELAYED_QUALIFIER__STRONG_RESET, oldStrongReset, strongReset));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public Clock getResetClock()
  {
    if (resetClock != null && resetClock.eIsProxy())
    {
      InternalEObject oldResetClock = (InternalEObject)resetClock;
      resetClock = (Clock)eResolveProxy(oldResetClock);
      if (resetClock != oldResetClock)
      {
        if (eNotificationRequired())
          eNotify(new ENotificationImpl(this, Notification.RESOLVE, TeslPackage.TIME_DELAYED_QUALIFIER__RESET_CLOCK, oldResetClock, resetClock));
      }
    }
    return resetClock;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Clock basicGetResetClock()
  {
    return resetClock;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void setResetClock(Clock newResetClock)
  {
    Clock oldResetClock = resetClock;
    resetClock = newResetClock;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, TeslPackage.TIME_DELAYED_QUALIFIER__RESET_CLOCK, oldResetClock, resetClock));
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
      case TeslPackage.TIME_DELAYED_QUALIFIER__DELAY:
        return basicSetDelay(null, msgs);
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
      case TeslPackage.TIME_DELAYED_QUALIFIER__DELAY:
        return getDelay();
      case TeslPackage.TIME_DELAYED_QUALIFIER__CLOCK:
        if (resolve) return getClock();
        return basicGetClock();
      case TeslPackage.TIME_DELAYED_QUALIFIER__RESET:
        return isReset();
      case TeslPackage.TIME_DELAYED_QUALIFIER__IMM_RESET:
        return isImmReset();
      case TeslPackage.TIME_DELAYED_QUALIFIER__STRONG_RESET:
        return isStrongReset();
      case TeslPackage.TIME_DELAYED_QUALIFIER__RESET_CLOCK:
        if (resolve) return getResetClock();
        return basicGetResetClock();
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
      case TeslPackage.TIME_DELAYED_QUALIFIER__DELAY:
        setDelay((Expression)newValue);
        return;
      case TeslPackage.TIME_DELAYED_QUALIFIER__CLOCK:
        setClock((Clock)newValue);
        return;
      case TeslPackage.TIME_DELAYED_QUALIFIER__RESET:
        setReset((Boolean)newValue);
        return;
      case TeslPackage.TIME_DELAYED_QUALIFIER__IMM_RESET:
        setImmReset((Boolean)newValue);
        return;
      case TeslPackage.TIME_DELAYED_QUALIFIER__STRONG_RESET:
        setStrongReset((Boolean)newValue);
        return;
      case TeslPackage.TIME_DELAYED_QUALIFIER__RESET_CLOCK:
        setResetClock((Clock)newValue);
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
      case TeslPackage.TIME_DELAYED_QUALIFIER__DELAY:
        setDelay((Expression)null);
        return;
      case TeslPackage.TIME_DELAYED_QUALIFIER__CLOCK:
        setClock((Clock)null);
        return;
      case TeslPackage.TIME_DELAYED_QUALIFIER__RESET:
        setReset(RESET_EDEFAULT);
        return;
      case TeslPackage.TIME_DELAYED_QUALIFIER__IMM_RESET:
        setImmReset(IMM_RESET_EDEFAULT);
        return;
      case TeslPackage.TIME_DELAYED_QUALIFIER__STRONG_RESET:
        setStrongReset(STRONG_RESET_EDEFAULT);
        return;
      case TeslPackage.TIME_DELAYED_QUALIFIER__RESET_CLOCK:
        setResetClock((Clock)null);
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
      case TeslPackage.TIME_DELAYED_QUALIFIER__DELAY:
        return delay != null;
      case TeslPackage.TIME_DELAYED_QUALIFIER__CLOCK:
        return clock != null;
      case TeslPackage.TIME_DELAYED_QUALIFIER__RESET:
        return reset != RESET_EDEFAULT;
      case TeslPackage.TIME_DELAYED_QUALIFIER__IMM_RESET:
        return immReset != IMM_RESET_EDEFAULT;
      case TeslPackage.TIME_DELAYED_QUALIFIER__STRONG_RESET:
        return strongReset != STRONG_RESET_EDEFAULT;
      case TeslPackage.TIME_DELAYED_QUALIFIER__RESET_CLOCK:
        return resetClock != null;
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
    result.append(" (reset: ");
    result.append(reset);
    result.append(", immReset: ");
    result.append(immReset);
    result.append(", strongReset: ");
    result.append(strongReset);
    result.append(')');
    return result.toString();
  }

} //TimeDelayedQualifierImpl
