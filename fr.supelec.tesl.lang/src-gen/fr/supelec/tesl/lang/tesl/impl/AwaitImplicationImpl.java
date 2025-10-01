/**
 */
package fr.supelec.tesl.lang.tesl.impl;

import fr.supelec.tesl.lang.tesl.AwaitImplication;
import fr.supelec.tesl.lang.tesl.Clock;
import fr.supelec.tesl.lang.tesl.TeslPackage;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EObjectResolvingEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Await Implication</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link fr.supelec.tesl.lang.tesl.impl.AwaitImplicationImpl#getMasters <em>Masters</em>}</li>
 *   <li>{@link fr.supelec.tesl.lang.tesl.impl.AwaitImplicationImpl#isWeak <em>Weak</em>}</li>
 *   <li>{@link fr.supelec.tesl.lang.tesl.impl.AwaitImplicationImpl#isStrong <em>Strong</em>}</li>
 *   <li>{@link fr.supelec.tesl.lang.tesl.impl.AwaitImplicationImpl#getReset <em>Reset</em>}</li>
 *   <li>{@link fr.supelec.tesl.lang.tesl.impl.AwaitImplicationImpl#getTarget <em>Target</em>}</li>
 * </ul>
 *
 * @generated
 */
public class AwaitImplicationImpl extends RelationImpl implements AwaitImplication
{
  /**
   * The cached value of the '{@link #getMasters() <em>Masters</em>}' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getMasters()
   * @generated
   * @ordered
   */
  protected EList<Clock> masters;

  /**
   * The default value of the '{@link #isWeak() <em>Weak</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isWeak()
   * @generated
   * @ordered
   */
  protected static final boolean WEAK_EDEFAULT = false;

  /**
   * The cached value of the '{@link #isWeak() <em>Weak</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isWeak()
   * @generated
   * @ordered
   */
  protected boolean weak = WEAK_EDEFAULT;

  /**
   * The default value of the '{@link #isStrong() <em>Strong</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isStrong()
   * @generated
   * @ordered
   */
  protected static final boolean STRONG_EDEFAULT = false;

  /**
   * The cached value of the '{@link #isStrong() <em>Strong</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isStrong()
   * @generated
   * @ordered
   */
  protected boolean strong = STRONG_EDEFAULT;

  /**
   * The cached value of the '{@link #getReset() <em>Reset</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getReset()
   * @generated
   * @ordered
   */
  protected Clock reset;

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
  protected AwaitImplicationImpl()
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
    return TeslPackage.Literals.AWAIT_IMPLICATION;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EList<Clock> getMasters()
  {
    if (masters == null)
    {
      masters = new EObjectResolvingEList<Clock>(Clock.class, this, TeslPackage.AWAIT_IMPLICATION__MASTERS);
    }
    return masters;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public boolean isWeak()
  {
    return weak;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void setWeak(boolean newWeak)
  {
    boolean oldWeak = weak;
    weak = newWeak;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, TeslPackage.AWAIT_IMPLICATION__WEAK, oldWeak, weak));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public boolean isStrong()
  {
    return strong;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void setStrong(boolean newStrong)
  {
    boolean oldStrong = strong;
    strong = newStrong;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, TeslPackage.AWAIT_IMPLICATION__STRONG, oldStrong, strong));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public Clock getReset()
  {
    if (reset != null && reset.eIsProxy())
    {
      InternalEObject oldReset = (InternalEObject)reset;
      reset = (Clock)eResolveProxy(oldReset);
      if (reset != oldReset)
      {
        if (eNotificationRequired())
          eNotify(new ENotificationImpl(this, Notification.RESOLVE, TeslPackage.AWAIT_IMPLICATION__RESET, oldReset, reset));
      }
    }
    return reset;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Clock basicGetReset()
  {
    return reset;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void setReset(Clock newReset)
  {
    Clock oldReset = reset;
    reset = newReset;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, TeslPackage.AWAIT_IMPLICATION__RESET, oldReset, reset));
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
          eNotify(new ENotificationImpl(this, Notification.RESOLVE, TeslPackage.AWAIT_IMPLICATION__TARGET, oldTarget, target));
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
      eNotify(new ENotificationImpl(this, Notification.SET, TeslPackage.AWAIT_IMPLICATION__TARGET, oldTarget, target));
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
      case TeslPackage.AWAIT_IMPLICATION__MASTERS:
        return getMasters();
      case TeslPackage.AWAIT_IMPLICATION__WEAK:
        return isWeak();
      case TeslPackage.AWAIT_IMPLICATION__STRONG:
        return isStrong();
      case TeslPackage.AWAIT_IMPLICATION__RESET:
        if (resolve) return getReset();
        return basicGetReset();
      case TeslPackage.AWAIT_IMPLICATION__TARGET:
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
  @SuppressWarnings("unchecked")
  @Override
  public void eSet(int featureID, Object newValue)
  {
    switch (featureID)
    {
      case TeslPackage.AWAIT_IMPLICATION__MASTERS:
        getMasters().clear();
        getMasters().addAll((Collection<? extends Clock>)newValue);
        return;
      case TeslPackage.AWAIT_IMPLICATION__WEAK:
        setWeak((Boolean)newValue);
        return;
      case TeslPackage.AWAIT_IMPLICATION__STRONG:
        setStrong((Boolean)newValue);
        return;
      case TeslPackage.AWAIT_IMPLICATION__RESET:
        setReset((Clock)newValue);
        return;
      case TeslPackage.AWAIT_IMPLICATION__TARGET:
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
      case TeslPackage.AWAIT_IMPLICATION__MASTERS:
        getMasters().clear();
        return;
      case TeslPackage.AWAIT_IMPLICATION__WEAK:
        setWeak(WEAK_EDEFAULT);
        return;
      case TeslPackage.AWAIT_IMPLICATION__STRONG:
        setStrong(STRONG_EDEFAULT);
        return;
      case TeslPackage.AWAIT_IMPLICATION__RESET:
        setReset((Clock)null);
        return;
      case TeslPackage.AWAIT_IMPLICATION__TARGET:
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
      case TeslPackage.AWAIT_IMPLICATION__MASTERS:
        return masters != null && !masters.isEmpty();
      case TeslPackage.AWAIT_IMPLICATION__WEAK:
        return weak != WEAK_EDEFAULT;
      case TeslPackage.AWAIT_IMPLICATION__STRONG:
        return strong != STRONG_EDEFAULT;
      case TeslPackage.AWAIT_IMPLICATION__RESET:
        return reset != null;
      case TeslPackage.AWAIT_IMPLICATION__TARGET:
        return target != null;
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
    result.append(" (weak: ");
    result.append(weak);
    result.append(", strong: ");
    result.append(strong);
    result.append(')');
    return result.toString();
  }

} //AwaitImplicationImpl
