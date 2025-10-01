/**
 */
package fr.supelec.tesl.lang.tesl.impl;

import fr.supelec.tesl.lang.tesl.Clock;
import fr.supelec.tesl.lang.tesl.SustainedQualifier;
import fr.supelec.tesl.lang.tesl.TeslPackage;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Sustained Qualifier</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link fr.supelec.tesl.lang.tesl.impl.SustainedQualifierImpl#isImmediately <em>Immediately</em>}</li>
 *   <li>{@link fr.supelec.tesl.lang.tesl.impl.SustainedQualifierImpl#getStartClock <em>Start Clock</em>}</li>
 *   <li>{@link fr.supelec.tesl.lang.tesl.impl.SustainedQualifierImpl#getEndClock <em>End Clock</em>}</li>
 *   <li>{@link fr.supelec.tesl.lang.tesl.impl.SustainedQualifierImpl#isWeakly <em>Weakly</em>}</li>
 * </ul>
 *
 * @generated
 */
public class SustainedQualifierImpl extends ImplicationQualifierImpl implements SustainedQualifier
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
   * The cached value of the '{@link #getStartClock() <em>Start Clock</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getStartClock()
   * @generated
   * @ordered
   */
  protected Clock startClock;

  /**
   * The cached value of the '{@link #getEndClock() <em>End Clock</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getEndClock()
   * @generated
   * @ordered
   */
  protected Clock endClock;

  /**
   * The default value of the '{@link #isWeakly() <em>Weakly</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isWeakly()
   * @generated
   * @ordered
   */
  protected static final boolean WEAKLY_EDEFAULT = false;

  /**
   * The cached value of the '{@link #isWeakly() <em>Weakly</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isWeakly()
   * @generated
   * @ordered
   */
  protected boolean weakly = WEAKLY_EDEFAULT;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected SustainedQualifierImpl()
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
    return TeslPackage.Literals.SUSTAINED_QUALIFIER;
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
      eNotify(new ENotificationImpl(this, Notification.SET, TeslPackage.SUSTAINED_QUALIFIER__IMMEDIATELY, oldImmediately, immediately));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public Clock getStartClock()
  {
    if (startClock != null && startClock.eIsProxy())
    {
      InternalEObject oldStartClock = (InternalEObject)startClock;
      startClock = (Clock)eResolveProxy(oldStartClock);
      if (startClock != oldStartClock)
      {
        if (eNotificationRequired())
          eNotify(new ENotificationImpl(this, Notification.RESOLVE, TeslPackage.SUSTAINED_QUALIFIER__START_CLOCK, oldStartClock, startClock));
      }
    }
    return startClock;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Clock basicGetStartClock()
  {
    return startClock;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void setStartClock(Clock newStartClock)
  {
    Clock oldStartClock = startClock;
    startClock = newStartClock;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, TeslPackage.SUSTAINED_QUALIFIER__START_CLOCK, oldStartClock, startClock));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public Clock getEndClock()
  {
    if (endClock != null && endClock.eIsProxy())
    {
      InternalEObject oldEndClock = (InternalEObject)endClock;
      endClock = (Clock)eResolveProxy(oldEndClock);
      if (endClock != oldEndClock)
      {
        if (eNotificationRequired())
          eNotify(new ENotificationImpl(this, Notification.RESOLVE, TeslPackage.SUSTAINED_QUALIFIER__END_CLOCK, oldEndClock, endClock));
      }
    }
    return endClock;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Clock basicGetEndClock()
  {
    return endClock;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void setEndClock(Clock newEndClock)
  {
    Clock oldEndClock = endClock;
    endClock = newEndClock;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, TeslPackage.SUSTAINED_QUALIFIER__END_CLOCK, oldEndClock, endClock));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public boolean isWeakly()
  {
    return weakly;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void setWeakly(boolean newWeakly)
  {
    boolean oldWeakly = weakly;
    weakly = newWeakly;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, TeslPackage.SUSTAINED_QUALIFIER__WEAKLY, oldWeakly, weakly));
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
      case TeslPackage.SUSTAINED_QUALIFIER__IMMEDIATELY:
        return isImmediately();
      case TeslPackage.SUSTAINED_QUALIFIER__START_CLOCK:
        if (resolve) return getStartClock();
        return basicGetStartClock();
      case TeslPackage.SUSTAINED_QUALIFIER__END_CLOCK:
        if (resolve) return getEndClock();
        return basicGetEndClock();
      case TeslPackage.SUSTAINED_QUALIFIER__WEAKLY:
        return isWeakly();
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
      case TeslPackage.SUSTAINED_QUALIFIER__IMMEDIATELY:
        setImmediately((Boolean)newValue);
        return;
      case TeslPackage.SUSTAINED_QUALIFIER__START_CLOCK:
        setStartClock((Clock)newValue);
        return;
      case TeslPackage.SUSTAINED_QUALIFIER__END_CLOCK:
        setEndClock((Clock)newValue);
        return;
      case TeslPackage.SUSTAINED_QUALIFIER__WEAKLY:
        setWeakly((Boolean)newValue);
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
      case TeslPackage.SUSTAINED_QUALIFIER__IMMEDIATELY:
        setImmediately(IMMEDIATELY_EDEFAULT);
        return;
      case TeslPackage.SUSTAINED_QUALIFIER__START_CLOCK:
        setStartClock((Clock)null);
        return;
      case TeslPackage.SUSTAINED_QUALIFIER__END_CLOCK:
        setEndClock((Clock)null);
        return;
      case TeslPackage.SUSTAINED_QUALIFIER__WEAKLY:
        setWeakly(WEAKLY_EDEFAULT);
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
      case TeslPackage.SUSTAINED_QUALIFIER__IMMEDIATELY:
        return immediately != IMMEDIATELY_EDEFAULT;
      case TeslPackage.SUSTAINED_QUALIFIER__START_CLOCK:
        return startClock != null;
      case TeslPackage.SUSTAINED_QUALIFIER__END_CLOCK:
        return endClock != null;
      case TeslPackage.SUSTAINED_QUALIFIER__WEAKLY:
        return weakly != WEAKLY_EDEFAULT;
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
    result.append(", weakly: ");
    result.append(weakly);
    result.append(')');
    return result.toString();
  }

} //SustainedQualifierImpl
