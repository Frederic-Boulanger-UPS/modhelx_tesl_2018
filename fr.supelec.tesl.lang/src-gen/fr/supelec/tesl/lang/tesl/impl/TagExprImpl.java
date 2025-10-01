/**
 */
package fr.supelec.tesl.lang.tesl.impl;

import fr.supelec.tesl.lang.tesl.Clock;
import fr.supelec.tesl.lang.tesl.Expression;
import fr.supelec.tesl.lang.tesl.TagExpr;
import fr.supelec.tesl.lang.tesl.TeslPackage;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Tag Expr</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link fr.supelec.tesl.lang.tesl.impl.TagExprImpl#getClockY <em>Clock Y</em>}</li>
 *   <li>{@link fr.supelec.tesl.lang.tesl.impl.TagExprImpl#getValueA <em>Value A</em>}</li>
 *   <li>{@link fr.supelec.tesl.lang.tesl.impl.TagExprImpl#getClockX <em>Clock X</em>}</li>
 *   <li>{@link fr.supelec.tesl.lang.tesl.impl.TagExprImpl#getValueN <em>Value N</em>}</li>
 *   <li>{@link fr.supelec.tesl.lang.tesl.impl.TagExprImpl#getValueB <em>Value B</em>}</li>
 * </ul>
 *
 * @generated
 */
public class TagExprImpl extends MinimalEObjectImpl.Container implements TagExpr
{
  /**
   * The cached value of the '{@link #getClockY() <em>Clock Y</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getClockY()
   * @generated
   * @ordered
   */
  protected Clock clockY;

  /**
   * The cached value of the '{@link #getValueA() <em>Value A</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getValueA()
   * @generated
   * @ordered
   */
  protected Expression valueA;

  /**
   * The cached value of the '{@link #getClockX() <em>Clock X</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getClockX()
   * @generated
   * @ordered
   */
  protected Clock clockX;

  /**
   * The cached value of the '{@link #getValueN() <em>Value N</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getValueN()
   * @generated
   * @ordered
   */
  protected Expression valueN;

  /**
   * The cached value of the '{@link #getValueB() <em>Value B</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getValueB()
   * @generated
   * @ordered
   */
  protected Expression valueB;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected TagExprImpl()
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
    return TeslPackage.Literals.TAG_EXPR;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public Clock getClockY()
  {
    if (clockY != null && clockY.eIsProxy())
    {
      InternalEObject oldClockY = (InternalEObject)clockY;
      clockY = (Clock)eResolveProxy(oldClockY);
      if (clockY != oldClockY)
      {
        if (eNotificationRequired())
          eNotify(new ENotificationImpl(this, Notification.RESOLVE, TeslPackage.TAG_EXPR__CLOCK_Y, oldClockY, clockY));
      }
    }
    return clockY;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Clock basicGetClockY()
  {
    return clockY;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void setClockY(Clock newClockY)
  {
    Clock oldClockY = clockY;
    clockY = newClockY;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, TeslPackage.TAG_EXPR__CLOCK_Y, oldClockY, clockY));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public Expression getValueA()
  {
    return valueA;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetValueA(Expression newValueA, NotificationChain msgs)
  {
    Expression oldValueA = valueA;
    valueA = newValueA;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, TeslPackage.TAG_EXPR__VALUE_A, oldValueA, newValueA);
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
  public void setValueA(Expression newValueA)
  {
    if (newValueA != valueA)
    {
      NotificationChain msgs = null;
      if (valueA != null)
        msgs = ((InternalEObject)valueA).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - TeslPackage.TAG_EXPR__VALUE_A, null, msgs);
      if (newValueA != null)
        msgs = ((InternalEObject)newValueA).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - TeslPackage.TAG_EXPR__VALUE_A, null, msgs);
      msgs = basicSetValueA(newValueA, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, TeslPackage.TAG_EXPR__VALUE_A, newValueA, newValueA));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public Clock getClockX()
  {
    if (clockX != null && clockX.eIsProxy())
    {
      InternalEObject oldClockX = (InternalEObject)clockX;
      clockX = (Clock)eResolveProxy(oldClockX);
      if (clockX != oldClockX)
      {
        if (eNotificationRequired())
          eNotify(new ENotificationImpl(this, Notification.RESOLVE, TeslPackage.TAG_EXPR__CLOCK_X, oldClockX, clockX));
      }
    }
    return clockX;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Clock basicGetClockX()
  {
    return clockX;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void setClockX(Clock newClockX)
  {
    Clock oldClockX = clockX;
    clockX = newClockX;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, TeslPackage.TAG_EXPR__CLOCK_X, oldClockX, clockX));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public Expression getValueN()
  {
    return valueN;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetValueN(Expression newValueN, NotificationChain msgs)
  {
    Expression oldValueN = valueN;
    valueN = newValueN;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, TeslPackage.TAG_EXPR__VALUE_N, oldValueN, newValueN);
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
  public void setValueN(Expression newValueN)
  {
    if (newValueN != valueN)
    {
      NotificationChain msgs = null;
      if (valueN != null)
        msgs = ((InternalEObject)valueN).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - TeslPackage.TAG_EXPR__VALUE_N, null, msgs);
      if (newValueN != null)
        msgs = ((InternalEObject)newValueN).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - TeslPackage.TAG_EXPR__VALUE_N, null, msgs);
      msgs = basicSetValueN(newValueN, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, TeslPackage.TAG_EXPR__VALUE_N, newValueN, newValueN));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public Expression getValueB()
  {
    return valueB;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetValueB(Expression newValueB, NotificationChain msgs)
  {
    Expression oldValueB = valueB;
    valueB = newValueB;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, TeslPackage.TAG_EXPR__VALUE_B, oldValueB, newValueB);
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
  public void setValueB(Expression newValueB)
  {
    if (newValueB != valueB)
    {
      NotificationChain msgs = null;
      if (valueB != null)
        msgs = ((InternalEObject)valueB).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - TeslPackage.TAG_EXPR__VALUE_B, null, msgs);
      if (newValueB != null)
        msgs = ((InternalEObject)newValueB).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - TeslPackage.TAG_EXPR__VALUE_B, null, msgs);
      msgs = basicSetValueB(newValueB, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, TeslPackage.TAG_EXPR__VALUE_B, newValueB, newValueB));
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
      case TeslPackage.TAG_EXPR__VALUE_A:
        return basicSetValueA(null, msgs);
      case TeslPackage.TAG_EXPR__VALUE_N:
        return basicSetValueN(null, msgs);
      case TeslPackage.TAG_EXPR__VALUE_B:
        return basicSetValueB(null, msgs);
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
      case TeslPackage.TAG_EXPR__CLOCK_Y:
        if (resolve) return getClockY();
        return basicGetClockY();
      case TeslPackage.TAG_EXPR__VALUE_A:
        return getValueA();
      case TeslPackage.TAG_EXPR__CLOCK_X:
        if (resolve) return getClockX();
        return basicGetClockX();
      case TeslPackage.TAG_EXPR__VALUE_N:
        return getValueN();
      case TeslPackage.TAG_EXPR__VALUE_B:
        return getValueB();
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
      case TeslPackage.TAG_EXPR__CLOCK_Y:
        setClockY((Clock)newValue);
        return;
      case TeslPackage.TAG_EXPR__VALUE_A:
        setValueA((Expression)newValue);
        return;
      case TeslPackage.TAG_EXPR__CLOCK_X:
        setClockX((Clock)newValue);
        return;
      case TeslPackage.TAG_EXPR__VALUE_N:
        setValueN((Expression)newValue);
        return;
      case TeslPackage.TAG_EXPR__VALUE_B:
        setValueB((Expression)newValue);
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
      case TeslPackage.TAG_EXPR__CLOCK_Y:
        setClockY((Clock)null);
        return;
      case TeslPackage.TAG_EXPR__VALUE_A:
        setValueA((Expression)null);
        return;
      case TeslPackage.TAG_EXPR__CLOCK_X:
        setClockX((Clock)null);
        return;
      case TeslPackage.TAG_EXPR__VALUE_N:
        setValueN((Expression)null);
        return;
      case TeslPackage.TAG_EXPR__VALUE_B:
        setValueB((Expression)null);
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
      case TeslPackage.TAG_EXPR__CLOCK_Y:
        return clockY != null;
      case TeslPackage.TAG_EXPR__VALUE_A:
        return valueA != null;
      case TeslPackage.TAG_EXPR__CLOCK_X:
        return clockX != null;
      case TeslPackage.TAG_EXPR__VALUE_N:
        return valueN != null;
      case TeslPackage.TAG_EXPR__VALUE_B:
        return valueB != null;
    }
    return super.eIsSet(featureID);
  }

} //TagExprImpl
