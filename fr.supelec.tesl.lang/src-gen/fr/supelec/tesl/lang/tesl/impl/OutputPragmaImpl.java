/**
 */
package fr.supelec.tesl.lang.tesl.impl;

import fr.supelec.tesl.lang.tesl.Clock;
import fr.supelec.tesl.lang.tesl.ClockItem;
import fr.supelec.tesl.lang.tesl.Expression;
import fr.supelec.tesl.lang.tesl.OutputPragma;
import fr.supelec.tesl.lang.tesl.TeslPackage;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.EObjectResolvingEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Output Pragma</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link fr.supelec.tesl.lang.tesl.impl.OutputPragmaImpl#getType <em>Type</em>}</li>
 *   <li>{@link fr.supelec.tesl.lang.tesl.impl.OutputPragmaImpl#isSelection <em>Selection</em>}</li>
 *   <li>{@link fr.supelec.tesl.lang.tesl.impl.OutputPragmaImpl#getSelectedClocks <em>Selected Clocks</em>}</li>
 *   <li>{@link fr.supelec.tesl.lang.tesl.impl.OutputPragmaImpl#isWindow <em>Window</em>}</li>
 *   <li>{@link fr.supelec.tesl.lang.tesl.impl.OutputPragmaImpl#getFrom <em>From</em>}</li>
 *   <li>{@link fr.supelec.tesl.lang.tesl.impl.OutputPragmaImpl#getTo <em>To</em>}</li>
 *   <li>{@link fr.supelec.tesl.lang.tesl.impl.OutputPragmaImpl#getLabelif <em>Labelif</em>}</li>
 *   <li>{@link fr.supelec.tesl.lang.tesl.impl.OutputPragmaImpl#isXscaled <em>Xscaled</em>}</li>
 *   <li>{@link fr.supelec.tesl.lang.tesl.impl.OutputPragmaImpl#getXscale <em>Xscale</em>}</li>
 *   <li>{@link fr.supelec.tesl.lang.tesl.impl.OutputPragmaImpl#getBorder <em>Border</em>}</li>
 *   <li>{@link fr.supelec.tesl.lang.tesl.impl.OutputPragmaImpl#getCss <em>Css</em>}</li>
 *   <li>{@link fr.supelec.tesl.lang.tesl.impl.OutputPragmaImpl#isNodefcss <em>Nodefcss</em>}</li>
 *   <li>{@link fr.supelec.tesl.lang.tesl.impl.OutputPragmaImpl#getJvs <em>Jvs</em>}</li>
 *   <li>{@link fr.supelec.tesl.lang.tesl.impl.OutputPragmaImpl#isStandalone <em>Standalone</em>}</li>
 *   <li>{@link fr.supelec.tesl.lang.tesl.impl.OutputPragmaImpl#isOverwrite <em>Overwrite</em>}</li>
 * </ul>
 *
 * @generated
 */
public class OutputPragmaImpl extends PragmaImpl implements OutputPragma
{
  /**
   * The default value of the '{@link #getType() <em>Type</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getType()
   * @generated
   * @ordered
   */
  protected static final String TYPE_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getType() <em>Type</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getType()
   * @generated
   * @ordered
   */
  protected String type = TYPE_EDEFAULT;

  /**
   * The default value of the '{@link #isSelection() <em>Selection</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isSelection()
   * @generated
   * @ordered
   */
  protected static final boolean SELECTION_EDEFAULT = false;

  /**
   * The cached value of the '{@link #isSelection() <em>Selection</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isSelection()
   * @generated
   * @ordered
   */
  protected boolean selection = SELECTION_EDEFAULT;

  /**
   * The cached value of the '{@link #getSelectedClocks() <em>Selected Clocks</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getSelectedClocks()
   * @generated
   * @ordered
   */
  protected EList<ClockItem> selectedClocks;

  /**
   * The default value of the '{@link #isWindow() <em>Window</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isWindow()
   * @generated
   * @ordered
   */
  protected static final boolean WINDOW_EDEFAULT = false;

  /**
   * The cached value of the '{@link #isWindow() <em>Window</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isWindow()
   * @generated
   * @ordered
   */
  protected boolean window = WINDOW_EDEFAULT;

  /**
   * The cached value of the '{@link #getFrom() <em>From</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getFrom()
   * @generated
   * @ordered
   */
  protected Expression from;

  /**
   * The cached value of the '{@link #getTo() <em>To</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getTo()
   * @generated
   * @ordered
   */
  protected Expression to;

  /**
   * The cached value of the '{@link #getLabelif() <em>Labelif</em>}' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getLabelif()
   * @generated
   * @ordered
   */
  protected EList<Clock> labelif;

  /**
   * The default value of the '{@link #isXscaled() <em>Xscaled</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isXscaled()
   * @generated
   * @ordered
   */
  protected static final boolean XSCALED_EDEFAULT = false;

  /**
   * The cached value of the '{@link #isXscaled() <em>Xscaled</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isXscaled()
   * @generated
   * @ordered
   */
  protected boolean xscaled = XSCALED_EDEFAULT;

  /**
   * The cached value of the '{@link #getXscale() <em>Xscale</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getXscale()
   * @generated
   * @ordered
   */
  protected Expression xscale;

  /**
   * The default value of the '{@link #getBorder() <em>Border</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getBorder()
   * @generated
   * @ordered
   */
  protected static final String BORDER_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getBorder() <em>Border</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getBorder()
   * @generated
   * @ordered
   */
  protected String border = BORDER_EDEFAULT;

  /**
   * The default value of the '{@link #getCss() <em>Css</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getCss()
   * @generated
   * @ordered
   */
  protected static final String CSS_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getCss() <em>Css</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getCss()
   * @generated
   * @ordered
   */
  protected String css = CSS_EDEFAULT;

  /**
   * The default value of the '{@link #isNodefcss() <em>Nodefcss</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isNodefcss()
   * @generated
   * @ordered
   */
  protected static final boolean NODEFCSS_EDEFAULT = false;

  /**
   * The cached value of the '{@link #isNodefcss() <em>Nodefcss</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isNodefcss()
   * @generated
   * @ordered
   */
  protected boolean nodefcss = NODEFCSS_EDEFAULT;

  /**
   * The default value of the '{@link #getJvs() <em>Jvs</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getJvs()
   * @generated
   * @ordered
   */
  protected static final String JVS_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getJvs() <em>Jvs</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getJvs()
   * @generated
   * @ordered
   */
  protected String jvs = JVS_EDEFAULT;

  /**
   * The default value of the '{@link #isStandalone() <em>Standalone</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isStandalone()
   * @generated
   * @ordered
   */
  protected static final boolean STANDALONE_EDEFAULT = false;

  /**
   * The cached value of the '{@link #isStandalone() <em>Standalone</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isStandalone()
   * @generated
   * @ordered
   */
  protected boolean standalone = STANDALONE_EDEFAULT;

  /**
   * The default value of the '{@link #isOverwrite() <em>Overwrite</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isOverwrite()
   * @generated
   * @ordered
   */
  protected static final boolean OVERWRITE_EDEFAULT = false;

  /**
   * The cached value of the '{@link #isOverwrite() <em>Overwrite</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isOverwrite()
   * @generated
   * @ordered
   */
  protected boolean overwrite = OVERWRITE_EDEFAULT;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected OutputPragmaImpl()
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
    return TeslPackage.Literals.OUTPUT_PRAGMA;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public String getType()
  {
    return type;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void setType(String newType)
  {
    String oldType = type;
    type = newType;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, TeslPackage.OUTPUT_PRAGMA__TYPE, oldType, type));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public boolean isSelection()
  {
    return selection;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void setSelection(boolean newSelection)
  {
    boolean oldSelection = selection;
    selection = newSelection;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, TeslPackage.OUTPUT_PRAGMA__SELECTION, oldSelection, selection));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EList<ClockItem> getSelectedClocks()
  {
    if (selectedClocks == null)
    {
      selectedClocks = new EObjectContainmentEList<ClockItem>(ClockItem.class, this, TeslPackage.OUTPUT_PRAGMA__SELECTED_CLOCKS);
    }
    return selectedClocks;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public boolean isWindow()
  {
    return window;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void setWindow(boolean newWindow)
  {
    boolean oldWindow = window;
    window = newWindow;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, TeslPackage.OUTPUT_PRAGMA__WINDOW, oldWindow, window));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public Expression getFrom()
  {
    return from;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetFrom(Expression newFrom, NotificationChain msgs)
  {
    Expression oldFrom = from;
    from = newFrom;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, TeslPackage.OUTPUT_PRAGMA__FROM, oldFrom, newFrom);
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
  public void setFrom(Expression newFrom)
  {
    if (newFrom != from)
    {
      NotificationChain msgs = null;
      if (from != null)
        msgs = ((InternalEObject)from).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - TeslPackage.OUTPUT_PRAGMA__FROM, null, msgs);
      if (newFrom != null)
        msgs = ((InternalEObject)newFrom).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - TeslPackage.OUTPUT_PRAGMA__FROM, null, msgs);
      msgs = basicSetFrom(newFrom, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, TeslPackage.OUTPUT_PRAGMA__FROM, newFrom, newFrom));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public Expression getTo()
  {
    return to;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetTo(Expression newTo, NotificationChain msgs)
  {
    Expression oldTo = to;
    to = newTo;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, TeslPackage.OUTPUT_PRAGMA__TO, oldTo, newTo);
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
  public void setTo(Expression newTo)
  {
    if (newTo != to)
    {
      NotificationChain msgs = null;
      if (to != null)
        msgs = ((InternalEObject)to).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - TeslPackage.OUTPUT_PRAGMA__TO, null, msgs);
      if (newTo != null)
        msgs = ((InternalEObject)newTo).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - TeslPackage.OUTPUT_PRAGMA__TO, null, msgs);
      msgs = basicSetTo(newTo, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, TeslPackage.OUTPUT_PRAGMA__TO, newTo, newTo));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EList<Clock> getLabelif()
  {
    if (labelif == null)
    {
      labelif = new EObjectResolvingEList<Clock>(Clock.class, this, TeslPackage.OUTPUT_PRAGMA__LABELIF);
    }
    return labelif;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public boolean isXscaled()
  {
    return xscaled;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void setXscaled(boolean newXscaled)
  {
    boolean oldXscaled = xscaled;
    xscaled = newXscaled;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, TeslPackage.OUTPUT_PRAGMA__XSCALED, oldXscaled, xscaled));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public Expression getXscale()
  {
    return xscale;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetXscale(Expression newXscale, NotificationChain msgs)
  {
    Expression oldXscale = xscale;
    xscale = newXscale;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, TeslPackage.OUTPUT_PRAGMA__XSCALE, oldXscale, newXscale);
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
  public void setXscale(Expression newXscale)
  {
    if (newXscale != xscale)
    {
      NotificationChain msgs = null;
      if (xscale != null)
        msgs = ((InternalEObject)xscale).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - TeslPackage.OUTPUT_PRAGMA__XSCALE, null, msgs);
      if (newXscale != null)
        msgs = ((InternalEObject)newXscale).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - TeslPackage.OUTPUT_PRAGMA__XSCALE, null, msgs);
      msgs = basicSetXscale(newXscale, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, TeslPackage.OUTPUT_PRAGMA__XSCALE, newXscale, newXscale));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public String getBorder()
  {
    return border;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void setBorder(String newBorder)
  {
    String oldBorder = border;
    border = newBorder;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, TeslPackage.OUTPUT_PRAGMA__BORDER, oldBorder, border));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public String getCss()
  {
    return css;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void setCss(String newCss)
  {
    String oldCss = css;
    css = newCss;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, TeslPackage.OUTPUT_PRAGMA__CSS, oldCss, css));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public boolean isNodefcss()
  {
    return nodefcss;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void setNodefcss(boolean newNodefcss)
  {
    boolean oldNodefcss = nodefcss;
    nodefcss = newNodefcss;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, TeslPackage.OUTPUT_PRAGMA__NODEFCSS, oldNodefcss, nodefcss));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public String getJvs()
  {
    return jvs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void setJvs(String newJvs)
  {
    String oldJvs = jvs;
    jvs = newJvs;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, TeslPackage.OUTPUT_PRAGMA__JVS, oldJvs, jvs));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public boolean isStandalone()
  {
    return standalone;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void setStandalone(boolean newStandalone)
  {
    boolean oldStandalone = standalone;
    standalone = newStandalone;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, TeslPackage.OUTPUT_PRAGMA__STANDALONE, oldStandalone, standalone));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public boolean isOverwrite()
  {
    return overwrite;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void setOverwrite(boolean newOverwrite)
  {
    boolean oldOverwrite = overwrite;
    overwrite = newOverwrite;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, TeslPackage.OUTPUT_PRAGMA__OVERWRITE, oldOverwrite, overwrite));
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
      case TeslPackage.OUTPUT_PRAGMA__SELECTED_CLOCKS:
        return ((InternalEList<?>)getSelectedClocks()).basicRemove(otherEnd, msgs);
      case TeslPackage.OUTPUT_PRAGMA__FROM:
        return basicSetFrom(null, msgs);
      case TeslPackage.OUTPUT_PRAGMA__TO:
        return basicSetTo(null, msgs);
      case TeslPackage.OUTPUT_PRAGMA__XSCALE:
        return basicSetXscale(null, msgs);
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
      case TeslPackage.OUTPUT_PRAGMA__TYPE:
        return getType();
      case TeslPackage.OUTPUT_PRAGMA__SELECTION:
        return isSelection();
      case TeslPackage.OUTPUT_PRAGMA__SELECTED_CLOCKS:
        return getSelectedClocks();
      case TeslPackage.OUTPUT_PRAGMA__WINDOW:
        return isWindow();
      case TeslPackage.OUTPUT_PRAGMA__FROM:
        return getFrom();
      case TeslPackage.OUTPUT_PRAGMA__TO:
        return getTo();
      case TeslPackage.OUTPUT_PRAGMA__LABELIF:
        return getLabelif();
      case TeslPackage.OUTPUT_PRAGMA__XSCALED:
        return isXscaled();
      case TeslPackage.OUTPUT_PRAGMA__XSCALE:
        return getXscale();
      case TeslPackage.OUTPUT_PRAGMA__BORDER:
        return getBorder();
      case TeslPackage.OUTPUT_PRAGMA__CSS:
        return getCss();
      case TeslPackage.OUTPUT_PRAGMA__NODEFCSS:
        return isNodefcss();
      case TeslPackage.OUTPUT_PRAGMA__JVS:
        return getJvs();
      case TeslPackage.OUTPUT_PRAGMA__STANDALONE:
        return isStandalone();
      case TeslPackage.OUTPUT_PRAGMA__OVERWRITE:
        return isOverwrite();
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
      case TeslPackage.OUTPUT_PRAGMA__TYPE:
        setType((String)newValue);
        return;
      case TeslPackage.OUTPUT_PRAGMA__SELECTION:
        setSelection((Boolean)newValue);
        return;
      case TeslPackage.OUTPUT_PRAGMA__SELECTED_CLOCKS:
        getSelectedClocks().clear();
        getSelectedClocks().addAll((Collection<? extends ClockItem>)newValue);
        return;
      case TeslPackage.OUTPUT_PRAGMA__WINDOW:
        setWindow((Boolean)newValue);
        return;
      case TeslPackage.OUTPUT_PRAGMA__FROM:
        setFrom((Expression)newValue);
        return;
      case TeslPackage.OUTPUT_PRAGMA__TO:
        setTo((Expression)newValue);
        return;
      case TeslPackage.OUTPUT_PRAGMA__LABELIF:
        getLabelif().clear();
        getLabelif().addAll((Collection<? extends Clock>)newValue);
        return;
      case TeslPackage.OUTPUT_PRAGMA__XSCALED:
        setXscaled((Boolean)newValue);
        return;
      case TeslPackage.OUTPUT_PRAGMA__XSCALE:
        setXscale((Expression)newValue);
        return;
      case TeslPackage.OUTPUT_PRAGMA__BORDER:
        setBorder((String)newValue);
        return;
      case TeslPackage.OUTPUT_PRAGMA__CSS:
        setCss((String)newValue);
        return;
      case TeslPackage.OUTPUT_PRAGMA__NODEFCSS:
        setNodefcss((Boolean)newValue);
        return;
      case TeslPackage.OUTPUT_PRAGMA__JVS:
        setJvs((String)newValue);
        return;
      case TeslPackage.OUTPUT_PRAGMA__STANDALONE:
        setStandalone((Boolean)newValue);
        return;
      case TeslPackage.OUTPUT_PRAGMA__OVERWRITE:
        setOverwrite((Boolean)newValue);
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
      case TeslPackage.OUTPUT_PRAGMA__TYPE:
        setType(TYPE_EDEFAULT);
        return;
      case TeslPackage.OUTPUT_PRAGMA__SELECTION:
        setSelection(SELECTION_EDEFAULT);
        return;
      case TeslPackage.OUTPUT_PRAGMA__SELECTED_CLOCKS:
        getSelectedClocks().clear();
        return;
      case TeslPackage.OUTPUT_PRAGMA__WINDOW:
        setWindow(WINDOW_EDEFAULT);
        return;
      case TeslPackage.OUTPUT_PRAGMA__FROM:
        setFrom((Expression)null);
        return;
      case TeslPackage.OUTPUT_PRAGMA__TO:
        setTo((Expression)null);
        return;
      case TeslPackage.OUTPUT_PRAGMA__LABELIF:
        getLabelif().clear();
        return;
      case TeslPackage.OUTPUT_PRAGMA__XSCALED:
        setXscaled(XSCALED_EDEFAULT);
        return;
      case TeslPackage.OUTPUT_PRAGMA__XSCALE:
        setXscale((Expression)null);
        return;
      case TeslPackage.OUTPUT_PRAGMA__BORDER:
        setBorder(BORDER_EDEFAULT);
        return;
      case TeslPackage.OUTPUT_PRAGMA__CSS:
        setCss(CSS_EDEFAULT);
        return;
      case TeslPackage.OUTPUT_PRAGMA__NODEFCSS:
        setNodefcss(NODEFCSS_EDEFAULT);
        return;
      case TeslPackage.OUTPUT_PRAGMA__JVS:
        setJvs(JVS_EDEFAULT);
        return;
      case TeslPackage.OUTPUT_PRAGMA__STANDALONE:
        setStandalone(STANDALONE_EDEFAULT);
        return;
      case TeslPackage.OUTPUT_PRAGMA__OVERWRITE:
        setOverwrite(OVERWRITE_EDEFAULT);
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
      case TeslPackage.OUTPUT_PRAGMA__TYPE:
        return TYPE_EDEFAULT == null ? type != null : !TYPE_EDEFAULT.equals(type);
      case TeslPackage.OUTPUT_PRAGMA__SELECTION:
        return selection != SELECTION_EDEFAULT;
      case TeslPackage.OUTPUT_PRAGMA__SELECTED_CLOCKS:
        return selectedClocks != null && !selectedClocks.isEmpty();
      case TeslPackage.OUTPUT_PRAGMA__WINDOW:
        return window != WINDOW_EDEFAULT;
      case TeslPackage.OUTPUT_PRAGMA__FROM:
        return from != null;
      case TeslPackage.OUTPUT_PRAGMA__TO:
        return to != null;
      case TeslPackage.OUTPUT_PRAGMA__LABELIF:
        return labelif != null && !labelif.isEmpty();
      case TeslPackage.OUTPUT_PRAGMA__XSCALED:
        return xscaled != XSCALED_EDEFAULT;
      case TeslPackage.OUTPUT_PRAGMA__XSCALE:
        return xscale != null;
      case TeslPackage.OUTPUT_PRAGMA__BORDER:
        return BORDER_EDEFAULT == null ? border != null : !BORDER_EDEFAULT.equals(border);
      case TeslPackage.OUTPUT_PRAGMA__CSS:
        return CSS_EDEFAULT == null ? css != null : !CSS_EDEFAULT.equals(css);
      case TeslPackage.OUTPUT_PRAGMA__NODEFCSS:
        return nodefcss != NODEFCSS_EDEFAULT;
      case TeslPackage.OUTPUT_PRAGMA__JVS:
        return JVS_EDEFAULT == null ? jvs != null : !JVS_EDEFAULT.equals(jvs);
      case TeslPackage.OUTPUT_PRAGMA__STANDALONE:
        return standalone != STANDALONE_EDEFAULT;
      case TeslPackage.OUTPUT_PRAGMA__OVERWRITE:
        return overwrite != OVERWRITE_EDEFAULT;
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
    result.append(" (type: ");
    result.append(type);
    result.append(", selection: ");
    result.append(selection);
    result.append(", window: ");
    result.append(window);
    result.append(", xscaled: ");
    result.append(xscaled);
    result.append(", border: ");
    result.append(border);
    result.append(", css: ");
    result.append(css);
    result.append(", nodefcss: ");
    result.append(nodefcss);
    result.append(", jvs: ");
    result.append(jvs);
    result.append(", standalone: ");
    result.append(standalone);
    result.append(", overwrite: ");
    result.append(overwrite);
    result.append(')');
    return result.toString();
  }

} //OutputPragmaImpl
