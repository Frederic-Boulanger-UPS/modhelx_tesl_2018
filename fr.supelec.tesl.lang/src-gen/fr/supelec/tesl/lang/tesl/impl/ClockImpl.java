/**
 */
package fr.supelec.tesl.lang.tesl.impl;

import fr.supelec.tesl.lang.tesl.Clock;
import fr.supelec.tesl.lang.tesl.ClockQualifier;
import fr.supelec.tesl.lang.tesl.TeslPackage;
import fr.supelec.tesl.lang.tesl.Type;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Clock</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link fr.supelec.tesl.lang.tesl.impl.ClockImpl#isNongreedy <em>Nongreedy</em>}</li>
 *   <li>{@link fr.supelec.tesl.lang.tesl.impl.ClockImpl#getType <em>Type</em>}</li>
 *   <li>{@link fr.supelec.tesl.lang.tesl.impl.ClockImpl#getName <em>Name</em>}</li>
 *   <li>{@link fr.supelec.tesl.lang.tesl.impl.ClockImpl#getQual <em>Qual</em>}</li>
 * </ul>
 *
 * @generated
 */
public class ClockImpl extends MinimalEObjectImpl.Container implements Clock
{
  /**
   * The default value of the '{@link #isNongreedy() <em>Nongreedy</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isNongreedy()
   * @generated
   * @ordered
   */
  protected static final boolean NONGREEDY_EDEFAULT = false;

  /**
   * The cached value of the '{@link #isNongreedy() <em>Nongreedy</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isNongreedy()
   * @generated
   * @ordered
   */
  protected boolean nongreedy = NONGREEDY_EDEFAULT;

  /**
   * The default value of the '{@link #getType() <em>Type</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getType()
   * @generated
   * @ordered
   */
  protected static final Type TYPE_EDEFAULT = Type.TUNIT;

  /**
   * The cached value of the '{@link #getType() <em>Type</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getType()
   * @generated
   * @ordered
   */
  protected Type type = TYPE_EDEFAULT;

  /**
   * The default value of the '{@link #getName() <em>Name</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getName()
   * @generated
   * @ordered
   */
  protected static final String NAME_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getName() <em>Name</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getName()
   * @generated
   * @ordered
   */
  protected String name = NAME_EDEFAULT;

  /**
   * The cached value of the '{@link #getQual() <em>Qual</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getQual()
   * @generated
   * @ordered
   */
  protected ClockQualifier qual;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected ClockImpl()
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
    return TeslPackage.Literals.CLOCK;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public boolean isNongreedy()
  {
    return nongreedy;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void setNongreedy(boolean newNongreedy)
  {
    boolean oldNongreedy = nongreedy;
    nongreedy = newNongreedy;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, TeslPackage.CLOCK__NONGREEDY, oldNongreedy, nongreedy));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public Type getType()
  {
    return type;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void setType(Type newType)
  {
    Type oldType = type;
    type = newType == null ? TYPE_EDEFAULT : newType;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, TeslPackage.CLOCK__TYPE, oldType, type));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public String getName()
  {
    return name;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void setName(String newName)
  {
    String oldName = name;
    name = newName;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, TeslPackage.CLOCK__NAME, oldName, name));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public ClockQualifier getQual()
  {
    return qual;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetQual(ClockQualifier newQual, NotificationChain msgs)
  {
    ClockQualifier oldQual = qual;
    qual = newQual;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, TeslPackage.CLOCK__QUAL, oldQual, newQual);
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
  public void setQual(ClockQualifier newQual)
  {
    if (newQual != qual)
    {
      NotificationChain msgs = null;
      if (qual != null)
        msgs = ((InternalEObject)qual).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - TeslPackage.CLOCK__QUAL, null, msgs);
      if (newQual != null)
        msgs = ((InternalEObject)newQual).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - TeslPackage.CLOCK__QUAL, null, msgs);
      msgs = basicSetQual(newQual, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, TeslPackage.CLOCK__QUAL, newQual, newQual));
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
      case TeslPackage.CLOCK__QUAL:
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
      case TeslPackage.CLOCK__NONGREEDY:
        return isNongreedy();
      case TeslPackage.CLOCK__TYPE:
        return getType();
      case TeslPackage.CLOCK__NAME:
        return getName();
      case TeslPackage.CLOCK__QUAL:
        return getQual();
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
      case TeslPackage.CLOCK__NONGREEDY:
        setNongreedy((Boolean)newValue);
        return;
      case TeslPackage.CLOCK__TYPE:
        setType((Type)newValue);
        return;
      case TeslPackage.CLOCK__NAME:
        setName((String)newValue);
        return;
      case TeslPackage.CLOCK__QUAL:
        setQual((ClockQualifier)newValue);
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
      case TeslPackage.CLOCK__NONGREEDY:
        setNongreedy(NONGREEDY_EDEFAULT);
        return;
      case TeslPackage.CLOCK__TYPE:
        setType(TYPE_EDEFAULT);
        return;
      case TeslPackage.CLOCK__NAME:
        setName(NAME_EDEFAULT);
        return;
      case TeslPackage.CLOCK__QUAL:
        setQual((ClockQualifier)null);
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
      case TeslPackage.CLOCK__NONGREEDY:
        return nongreedy != NONGREEDY_EDEFAULT;
      case TeslPackage.CLOCK__TYPE:
        return type != TYPE_EDEFAULT;
      case TeslPackage.CLOCK__NAME:
        return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
      case TeslPackage.CLOCK__QUAL:
        return qual != null;
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
    result.append(" (nongreedy: ");
    result.append(nongreedy);
    result.append(", type: ");
    result.append(type);
    result.append(", name: ");
    result.append(name);
    result.append(')');
    return result.toString();
  }

} //ClockImpl
