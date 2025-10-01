/**
 */
package fr.supelec.tesl.lang.tesl.impl;

import fr.supelec.tesl.lang.tesl.DoubleCalcPragma;
import fr.supelec.tesl.lang.tesl.ROUNDING_MODE;
import fr.supelec.tesl.lang.tesl.TeslPackage;

import java.math.BigInteger;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Double Calc Pragma</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link fr.supelec.tesl.lang.tesl.impl.DoubleCalcPragmaImpl#getNum_digits <em>Num digits</em>}</li>
 *   <li>{@link fr.supelec.tesl.lang.tesl.impl.DoubleCalcPragmaImpl#isRound <em>Round</em>}</li>
 *   <li>{@link fr.supelec.tesl.lang.tesl.impl.DoubleCalcPragmaImpl#getRounding_mode <em>Rounding mode</em>}</li>
 * </ul>
 *
 * @generated
 */
public class DoubleCalcPragmaImpl extends PragmaImpl implements DoubleCalcPragma
{
  /**
   * The default value of the '{@link #getNum_digits() <em>Num digits</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getNum_digits()
   * @generated
   * @ordered
   */
  protected static final BigInteger NUM_DIGITS_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getNum_digits() <em>Num digits</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getNum_digits()
   * @generated
   * @ordered
   */
  protected BigInteger num_digits = NUM_DIGITS_EDEFAULT;

  /**
   * The default value of the '{@link #isRound() <em>Round</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isRound()
   * @generated
   * @ordered
   */
  protected static final boolean ROUND_EDEFAULT = false;

  /**
   * The cached value of the '{@link #isRound() <em>Round</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isRound()
   * @generated
   * @ordered
   */
  protected boolean round = ROUND_EDEFAULT;

  /**
   * The default value of the '{@link #getRounding_mode() <em>Rounding mode</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getRounding_mode()
   * @generated
   * @ordered
   */
  protected static final ROUNDING_MODE ROUNDING_MODE_EDEFAULT = ROUNDING_MODE.ROUND_UP;

  /**
   * The cached value of the '{@link #getRounding_mode() <em>Rounding mode</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getRounding_mode()
   * @generated
   * @ordered
   */
  protected ROUNDING_MODE rounding_mode = ROUNDING_MODE_EDEFAULT;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected DoubleCalcPragmaImpl()
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
    return TeslPackage.Literals.DOUBLE_CALC_PRAGMA;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public BigInteger getNum_digits()
  {
    return num_digits;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void setNum_digits(BigInteger newNum_digits)
  {
    BigInteger oldNum_digits = num_digits;
    num_digits = newNum_digits;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, TeslPackage.DOUBLE_CALC_PRAGMA__NUM_DIGITS, oldNum_digits, num_digits));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public boolean isRound()
  {
    return round;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void setRound(boolean newRound)
  {
    boolean oldRound = round;
    round = newRound;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, TeslPackage.DOUBLE_CALC_PRAGMA__ROUND, oldRound, round));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public ROUNDING_MODE getRounding_mode()
  {
    return rounding_mode;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void setRounding_mode(ROUNDING_MODE newRounding_mode)
  {
    ROUNDING_MODE oldRounding_mode = rounding_mode;
    rounding_mode = newRounding_mode == null ? ROUNDING_MODE_EDEFAULT : newRounding_mode;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, TeslPackage.DOUBLE_CALC_PRAGMA__ROUNDING_MODE, oldRounding_mode, rounding_mode));
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
      case TeslPackage.DOUBLE_CALC_PRAGMA__NUM_DIGITS:
        return getNum_digits();
      case TeslPackage.DOUBLE_CALC_PRAGMA__ROUND:
        return isRound();
      case TeslPackage.DOUBLE_CALC_PRAGMA__ROUNDING_MODE:
        return getRounding_mode();
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
      case TeslPackage.DOUBLE_CALC_PRAGMA__NUM_DIGITS:
        setNum_digits((BigInteger)newValue);
        return;
      case TeslPackage.DOUBLE_CALC_PRAGMA__ROUND:
        setRound((Boolean)newValue);
        return;
      case TeslPackage.DOUBLE_CALC_PRAGMA__ROUNDING_MODE:
        setRounding_mode((ROUNDING_MODE)newValue);
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
      case TeslPackage.DOUBLE_CALC_PRAGMA__NUM_DIGITS:
        setNum_digits(NUM_DIGITS_EDEFAULT);
        return;
      case TeslPackage.DOUBLE_CALC_PRAGMA__ROUND:
        setRound(ROUND_EDEFAULT);
        return;
      case TeslPackage.DOUBLE_CALC_PRAGMA__ROUNDING_MODE:
        setRounding_mode(ROUNDING_MODE_EDEFAULT);
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
      case TeslPackage.DOUBLE_CALC_PRAGMA__NUM_DIGITS:
        return NUM_DIGITS_EDEFAULT == null ? num_digits != null : !NUM_DIGITS_EDEFAULT.equals(num_digits);
      case TeslPackage.DOUBLE_CALC_PRAGMA__ROUND:
        return round != ROUND_EDEFAULT;
      case TeslPackage.DOUBLE_CALC_PRAGMA__ROUNDING_MODE:
        return rounding_mode != ROUNDING_MODE_EDEFAULT;
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
    result.append(" (num_digits: ");
    result.append(num_digits);
    result.append(", round: ");
    result.append(round);
    result.append(", rounding_mode: ");
    result.append(rounding_mode);
    result.append(')');
    return result.toString();
  }

} //DoubleCalcPragmaImpl
