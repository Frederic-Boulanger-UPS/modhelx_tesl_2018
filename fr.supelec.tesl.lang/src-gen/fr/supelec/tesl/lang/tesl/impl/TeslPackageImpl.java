/**
 */
package fr.supelec.tesl.lang.tesl.impl;

import fr.supelec.tesl.lang.tesl.AwaitImplication;
import fr.supelec.tesl.lang.tesl.BinOp;
import fr.supelec.tesl.lang.tesl.Cast;
import fr.supelec.tesl.lang.tesl.Clock;
import fr.supelec.tesl.lang.tesl.ClockItem;
import fr.supelec.tesl.lang.tesl.ClockQualifier;
import fr.supelec.tesl.lang.tesl.DecimalCast;
import fr.supelec.tesl.lang.tesl.DecimalValue;
import fr.supelec.tesl.lang.tesl.DelayedQualifier;
import fr.supelec.tesl.lang.tesl.DoubleCalcPragma;
import fr.supelec.tesl.lang.tesl.DumpResultPragma;
import fr.supelec.tesl.lang.tesl.EveryQualifier;
import fr.supelec.tesl.lang.tesl.Expression;
import fr.supelec.tesl.lang.tesl.FilteredQualifier;
import fr.supelec.tesl.lang.tesl.FloatCast;
import fr.supelec.tesl.lang.tesl.FloatValue;
import fr.supelec.tesl.lang.tesl.ImplicationQualifier;
import fr.supelec.tesl.lang.tesl.ImplicationRelation;
import fr.supelec.tesl.lang.tesl.IntCast;
import fr.supelec.tesl.lang.tesl.IntegerValue;
import fr.supelec.tesl.lang.tesl.Let;
import fr.supelec.tesl.lang.tesl.LetValue;
import fr.supelec.tesl.lang.tesl.MaxstepPragma;
import fr.supelec.tesl.lang.tesl.NextQualifier;
import fr.supelec.tesl.lang.tesl.Op;
import fr.supelec.tesl.lang.tesl.OutputPragma;
import fr.supelec.tesl.lang.tesl.Pattern;
import fr.supelec.tesl.lang.tesl.PeriodicQualifier;
import fr.supelec.tesl.lang.tesl.Pragma;
import fr.supelec.tesl.lang.tesl.RationalCast;
import fr.supelec.tesl.lang.tesl.RationalValue;
import fr.supelec.tesl.lang.tesl.Relation;
import fr.supelec.tesl.lang.tesl.Specification;
import fr.supelec.tesl.lang.tesl.SporadicQualifier;
import fr.supelec.tesl.lang.tesl.StopPragma;
import fr.supelec.tesl.lang.tesl.SustainedQualifier;
import fr.supelec.tesl.lang.tesl.TagExpr;
import fr.supelec.tesl.lang.tesl.TagRelation;
import fr.supelec.tesl.lang.tesl.TagrefPragma;
import fr.supelec.tesl.lang.tesl.TeslFactory;
import fr.supelec.tesl.lang.tesl.TeslPackage;
import fr.supelec.tesl.lang.tesl.TimeDelayedQualifier;
import fr.supelec.tesl.lang.tesl.TracePragma;
import fr.supelec.tesl.lang.tesl.Type;
import fr.supelec.tesl.lang.tesl.Value;
import fr.supelec.tesl.lang.tesl.ValueType;
import fr.supelec.tesl.lang.tesl.WhenQualifier;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

import org.eclipse.emf.ecore.impl.EPackageImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class TeslPackageImpl extends EPackageImpl implements TeslPackage
{
  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass specificationEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass clockEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass clockQualifierEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass periodicQualifierEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass sporadicQualifierEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass relationEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass implicationRelationEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass awaitImplicationEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass implicationQualifierEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass filteredQualifierEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass everyQualifierEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass delayedQualifierEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass sustainedQualifierEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass timeDelayedQualifierEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass letEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass valueEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass integerValueEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass decimalValueEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass floatValueEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass rationalValueEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass letValueEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass expressionEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass castEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass intCastEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass floatCastEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass decimalCastEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass rationalCastEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass whenQualifierEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass nextQualifierEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass patternEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass tagRelationEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass tagExprEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass pragmaEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass stopPragmaEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass tagrefPragmaEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass tracePragmaEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass maxstepPragmaEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass outputPragmaEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass clockItemEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass doubleCalcPragmaEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass dumpResultPragmaEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass binOpEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EEnum typeEEnum = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EEnum valueTypeEEnum = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EEnum opEEnum = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EEnum roundinG_MODEEEnum = null;

  /**
   * Creates an instance of the model <b>Package</b>, registered with
   * {@link org.eclipse.emf.ecore.EPackage.Registry EPackage.Registry} by the package
   * package URI value.
   * <p>Note: the correct way to create the package is via the static
   * factory method {@link #init init()}, which also performs
   * initialization of the package, or returns the registered package,
   * if one already exists.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.emf.ecore.EPackage.Registry
   * @see fr.supelec.tesl.lang.tesl.TeslPackage#eNS_URI
   * @see #init()
   * @generated
   */
  private TeslPackageImpl()
  {
    super(eNS_URI, TeslFactory.eINSTANCE);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private static boolean isInited = false;

  /**
   * Creates, registers, and initializes the <b>Package</b> for this model, and for any others upon which it depends.
   *
   * <p>This method is used to initialize {@link TeslPackage#eINSTANCE} when that field is accessed.
   * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #eNS_URI
   * @see #createPackageContents()
   * @see #initializePackageContents()
   * @generated
   */
  public static TeslPackage init()
  {
    if (isInited) return (TeslPackage)EPackage.Registry.INSTANCE.getEPackage(TeslPackage.eNS_URI);

    // Obtain or create and register package
    Object registeredTeslPackage = EPackage.Registry.INSTANCE.get(eNS_URI);
    TeslPackageImpl theTeslPackage = registeredTeslPackage instanceof TeslPackageImpl ? (TeslPackageImpl)registeredTeslPackage : new TeslPackageImpl();

    isInited = true;

    // Create package meta-data objects
    theTeslPackage.createPackageContents();

    // Initialize created meta-data
    theTeslPackage.initializePackageContents();

    // Mark meta-data to indicate it can't be changed
    theTeslPackage.freeze();

    // Update the registry and return the package
    EPackage.Registry.INSTANCE.put(TeslPackage.eNS_URI, theTeslPackage);
    return theTeslPackage;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EClass getSpecification()
  {
    return specificationEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EReference getSpecification_Decl()
  {
    return (EReference)specificationEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EReference getSpecification_Rel()
  {
    return (EReference)specificationEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EReference getSpecification_Let()
  {
    return (EReference)specificationEClass.getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EReference getSpecification_Pragmas()
  {
    return (EReference)specificationEClass.getEStructuralFeatures().get(3);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EClass getClock()
  {
    return clockEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EAttribute getClock_Nongreedy()
  {
    return (EAttribute)clockEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EAttribute getClock_Type()
  {
    return (EAttribute)clockEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EAttribute getClock_Name()
  {
    return (EAttribute)clockEClass.getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EReference getClock_Qual()
  {
    return (EReference)clockEClass.getEStructuralFeatures().get(3);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EClass getClockQualifier()
  {
    return clockQualifierEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EClass getPeriodicQualifier()
  {
    return periodicQualifierEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EReference getPeriodicQualifier_Period()
  {
    return (EReference)periodicQualifierEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EReference getPeriodicQualifier_Offset()
  {
    return (EReference)periodicQualifierEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EClass getSporadicQualifier()
  {
    return sporadicQualifierEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EReference getSporadicQualifier_Instants()
  {
    return (EReference)sporadicQualifierEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EClass getRelation()
  {
    return relationEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EClass getImplicationRelation()
  {
    return implicationRelationEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EReference getImplicationRelation_Source()
  {
    return (EReference)implicationRelationEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EReference getImplicationRelation_Qual()
  {
    return (EReference)implicationRelationEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EReference getImplicationRelation_Target()
  {
    return (EReference)implicationRelationEClass.getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EClass getAwaitImplication()
  {
    return awaitImplicationEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EReference getAwaitImplication_Masters()
  {
    return (EReference)awaitImplicationEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EAttribute getAwaitImplication_Weak()
  {
    return (EAttribute)awaitImplicationEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EAttribute getAwaitImplication_Strong()
  {
    return (EAttribute)awaitImplicationEClass.getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EReference getAwaitImplication_Reset()
  {
    return (EReference)awaitImplicationEClass.getEStructuralFeatures().get(3);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EReference getAwaitImplication_Target()
  {
    return (EReference)awaitImplicationEClass.getEStructuralFeatures().get(4);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EClass getImplicationQualifier()
  {
    return implicationQualifierEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EClass getFilteredQualifier()
  {
    return filteredQualifierEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EReference getFilteredQualifier_Pattern()
  {
    return (EReference)filteredQualifierEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EClass getEveryQualifier()
  {
    return everyQualifierEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EReference getEveryQualifier_Period()
  {
    return (EReference)everyQualifierEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EAttribute getEveryQualifier_Off()
  {
    return (EAttribute)everyQualifierEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EReference getEveryQualifier_Offset()
  {
    return (EReference)everyQualifierEClass.getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EClass getDelayedQualifier()
  {
    return delayedQualifierEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EAttribute getDelayedQualifier_Immediately()
  {
    return (EAttribute)delayedQualifierEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EReference getDelayedQualifier_Count()
  {
    return (EReference)delayedQualifierEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EAttribute getDelayedQualifier_Reset()
  {
    return (EAttribute)delayedQualifierEClass.getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EReference getDelayedQualifier_Clock()
  {
    return (EReference)delayedQualifierEClass.getEStructuralFeatures().get(3);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EClass getSustainedQualifier()
  {
    return sustainedQualifierEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EAttribute getSustainedQualifier_Immediately()
  {
    return (EAttribute)sustainedQualifierEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EReference getSustainedQualifier_StartClock()
  {
    return (EReference)sustainedQualifierEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EReference getSustainedQualifier_EndClock()
  {
    return (EReference)sustainedQualifierEClass.getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EAttribute getSustainedQualifier_Weakly()
  {
    return (EAttribute)sustainedQualifierEClass.getEStructuralFeatures().get(3);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EClass getTimeDelayedQualifier()
  {
    return timeDelayedQualifierEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EReference getTimeDelayedQualifier_Delay()
  {
    return (EReference)timeDelayedQualifierEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EReference getTimeDelayedQualifier_Clock()
  {
    return (EReference)timeDelayedQualifierEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EAttribute getTimeDelayedQualifier_Reset()
  {
    return (EAttribute)timeDelayedQualifierEClass.getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EAttribute getTimeDelayedQualifier_ImmReset()
  {
    return (EAttribute)timeDelayedQualifierEClass.getEStructuralFeatures().get(3);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EAttribute getTimeDelayedQualifier_StrongReset()
  {
    return (EAttribute)timeDelayedQualifierEClass.getEStructuralFeatures().get(4);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EReference getTimeDelayedQualifier_ResetClock()
  {
    return (EReference)timeDelayedQualifierEClass.getEStructuralFeatures().get(5);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EClass getLet()
  {
    return letEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EAttribute getLet_Type()
  {
    return (EAttribute)letEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EAttribute getLet_Name()
  {
    return (EAttribute)letEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EReference getLet_Value()
  {
    return (EReference)letEClass.getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EClass getValue()
  {
    return valueEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EClass getIntegerValue()
  {
    return integerValueEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EAttribute getIntegerValue_Sign()
  {
    return (EAttribute)integerValueEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EAttribute getIntegerValue_Value()
  {
    return (EAttribute)integerValueEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EClass getDecimalValue()
  {
    return decimalValueEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EAttribute getDecimalValue_Sign()
  {
    return (EAttribute)decimalValueEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EAttribute getDecimalValue_Value()
  {
    return (EAttribute)decimalValueEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EClass getFloatValue()
  {
    return floatValueEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EAttribute getFloatValue_Sign()
  {
    return (EAttribute)floatValueEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EAttribute getFloatValue_Value()
  {
    return (EAttribute)floatValueEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EClass getRationalValue()
  {
    return rationalValueEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EAttribute getRationalValue_Sign()
  {
    return (EAttribute)rationalValueEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EAttribute getRationalValue_Value()
  {
    return (EAttribute)rationalValueEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EClass getLetValue()
  {
    return letValueEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EReference getLetValue_Ref()
  {
    return (EReference)letValueEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EClass getExpression()
  {
    return expressionEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EClass getCast()
  {
    return castEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EReference getCast_Expr()
  {
    return (EReference)castEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EClass getIntCast()
  {
    return intCastEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EClass getFloatCast()
  {
    return floatCastEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EClass getDecimalCast()
  {
    return decimalCastEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EClass getRationalCast()
  {
    return rationalCastEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EClass getWhenQualifier()
  {
    return whenQualifierEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EAttribute getWhenQualifier_Not()
  {
    return (EAttribute)whenQualifierEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EReference getWhenQualifier_Clock()
  {
    return (EReference)whenQualifierEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EClass getNextQualifier()
  {
    return nextQualifierEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EAttribute getNextQualifier_Strict()
  {
    return (EAttribute)nextQualifierEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EReference getNextQualifier_Clock()
  {
    return (EReference)nextQualifierEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EClass getPattern()
  {
    return patternEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EReference getPattern_Skip()
  {
    return (EReference)patternEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EReference getPattern_Keep()
  {
    return (EReference)patternEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EAttribute getPattern_Rep()
  {
    return (EAttribute)patternEClass.getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EReference getPattern_Repskip()
  {
    return (EReference)patternEClass.getEStructuralFeatures().get(3);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EReference getPattern_Repkeep()
  {
    return (EReference)patternEClass.getEStructuralFeatures().get(4);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EClass getTagRelation()
  {
    return tagRelationEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EReference getTagRelation_Expr()
  {
    return (EReference)tagRelationEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EClass getTagExpr()
  {
    return tagExprEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EReference getTagExpr_ClockY()
  {
    return (EReference)tagExprEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EReference getTagExpr_ValueA()
  {
    return (EReference)tagExprEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EReference getTagExpr_ClockX()
  {
    return (EReference)tagExprEClass.getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EReference getTagExpr_ValueN()
  {
    return (EReference)tagExprEClass.getEStructuralFeatures().get(3);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EReference getTagExpr_ValueB()
  {
    return (EReference)tagExprEClass.getEStructuralFeatures().get(4);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EClass getPragma()
  {
    return pragmaEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EClass getStopPragma()
  {
    return stopPragmaEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EReference getStopPragma_Clock()
  {
    return (EReference)stopPragmaEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EClass getTagrefPragma()
  {
    return tagrefPragmaEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EReference getTagrefPragma_Clock()
  {
    return (EReference)tagrefPragmaEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EClass getTracePragma()
  {
    return tracePragmaEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EAttribute getTracePragma_Kinds()
  {
    return (EAttribute)tracePragmaEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EClass getMaxstepPragma()
  {
    return maxstepPragmaEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EReference getMaxstepPragma_Value()
  {
    return (EReference)maxstepPragmaEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EClass getOutputPragma()
  {
    return outputPragmaEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EAttribute getOutputPragma_Type()
  {
    return (EAttribute)outputPragmaEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EAttribute getOutputPragma_Selection()
  {
    return (EAttribute)outputPragmaEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EReference getOutputPragma_SelectedClocks()
  {
    return (EReference)outputPragmaEClass.getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EAttribute getOutputPragma_Window()
  {
    return (EAttribute)outputPragmaEClass.getEStructuralFeatures().get(3);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EReference getOutputPragma_From()
  {
    return (EReference)outputPragmaEClass.getEStructuralFeatures().get(4);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EReference getOutputPragma_To()
  {
    return (EReference)outputPragmaEClass.getEStructuralFeatures().get(5);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EReference getOutputPragma_Labelif()
  {
    return (EReference)outputPragmaEClass.getEStructuralFeatures().get(6);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EAttribute getOutputPragma_Xscaled()
  {
    return (EAttribute)outputPragmaEClass.getEStructuralFeatures().get(7);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EReference getOutputPragma_Xscale()
  {
    return (EReference)outputPragmaEClass.getEStructuralFeatures().get(8);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EAttribute getOutputPragma_Border()
  {
    return (EAttribute)outputPragmaEClass.getEStructuralFeatures().get(9);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EAttribute getOutputPragma_Css()
  {
    return (EAttribute)outputPragmaEClass.getEStructuralFeatures().get(10);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EAttribute getOutputPragma_Nodefcss()
  {
    return (EAttribute)outputPragmaEClass.getEStructuralFeatures().get(11);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EAttribute getOutputPragma_Jvs()
  {
    return (EAttribute)outputPragmaEClass.getEStructuralFeatures().get(12);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EAttribute getOutputPragma_Standalone()
  {
    return (EAttribute)outputPragmaEClass.getEStructuralFeatures().get(13);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EAttribute getOutputPragma_Overwrite()
  {
    return (EAttribute)outputPragmaEClass.getEStructuralFeatures().get(14);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EClass getClockItem()
  {
    return clockItemEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EReference getClockItem_Clock()
  {
    return (EReference)clockItemEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EAttribute getClockItem_NewName()
  {
    return (EAttribute)clockItemEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EClass getDoubleCalcPragma()
  {
    return doubleCalcPragmaEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EAttribute getDoubleCalcPragma_Num_digits()
  {
    return (EAttribute)doubleCalcPragmaEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EAttribute getDoubleCalcPragma_Round()
  {
    return (EAttribute)doubleCalcPragmaEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EAttribute getDoubleCalcPragma_Rounding_mode()
  {
    return (EAttribute)doubleCalcPragmaEClass.getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EClass getDumpResultPragma()
  {
    return dumpResultPragmaEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EClass getBinOp()
  {
    return binOpEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EReference getBinOp_Left()
  {
    return (EReference)binOpEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EAttribute getBinOp_Op()
  {
    return (EAttribute)binOpEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EReference getBinOp_Right()
  {
    return (EReference)binOpEClass.getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EEnum getType()
  {
    return typeEEnum;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EEnum getValueType()
  {
    return valueTypeEEnum;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EEnum getOp()
  {
    return opEEnum;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EEnum getROUNDING_MODE()
  {
    return roundinG_MODEEEnum;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public TeslFactory getTeslFactory()
  {
    return (TeslFactory)getEFactoryInstance();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private boolean isCreated = false;

  /**
   * Creates the meta-model objects for the package.  This method is
   * guarded to have no affect on any invocation but its first.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void createPackageContents()
  {
    if (isCreated) return;
    isCreated = true;

    // Create classes and their features
    specificationEClass = createEClass(SPECIFICATION);
    createEReference(specificationEClass, SPECIFICATION__DECL);
    createEReference(specificationEClass, SPECIFICATION__REL);
    createEReference(specificationEClass, SPECIFICATION__LET);
    createEReference(specificationEClass, SPECIFICATION__PRAGMAS);

    clockEClass = createEClass(CLOCK);
    createEAttribute(clockEClass, CLOCK__NONGREEDY);
    createEAttribute(clockEClass, CLOCK__TYPE);
    createEAttribute(clockEClass, CLOCK__NAME);
    createEReference(clockEClass, CLOCK__QUAL);

    clockQualifierEClass = createEClass(CLOCK_QUALIFIER);

    periodicQualifierEClass = createEClass(PERIODIC_QUALIFIER);
    createEReference(periodicQualifierEClass, PERIODIC_QUALIFIER__PERIOD);
    createEReference(periodicQualifierEClass, PERIODIC_QUALIFIER__OFFSET);

    sporadicQualifierEClass = createEClass(SPORADIC_QUALIFIER);
    createEReference(sporadicQualifierEClass, SPORADIC_QUALIFIER__INSTANTS);

    relationEClass = createEClass(RELATION);

    implicationRelationEClass = createEClass(IMPLICATION_RELATION);
    createEReference(implicationRelationEClass, IMPLICATION_RELATION__SOURCE);
    createEReference(implicationRelationEClass, IMPLICATION_RELATION__QUAL);
    createEReference(implicationRelationEClass, IMPLICATION_RELATION__TARGET);

    awaitImplicationEClass = createEClass(AWAIT_IMPLICATION);
    createEReference(awaitImplicationEClass, AWAIT_IMPLICATION__MASTERS);
    createEAttribute(awaitImplicationEClass, AWAIT_IMPLICATION__WEAK);
    createEAttribute(awaitImplicationEClass, AWAIT_IMPLICATION__STRONG);
    createEReference(awaitImplicationEClass, AWAIT_IMPLICATION__RESET);
    createEReference(awaitImplicationEClass, AWAIT_IMPLICATION__TARGET);

    implicationQualifierEClass = createEClass(IMPLICATION_QUALIFIER);

    filteredQualifierEClass = createEClass(FILTERED_QUALIFIER);
    createEReference(filteredQualifierEClass, FILTERED_QUALIFIER__PATTERN);

    everyQualifierEClass = createEClass(EVERY_QUALIFIER);
    createEReference(everyQualifierEClass, EVERY_QUALIFIER__PERIOD);
    createEAttribute(everyQualifierEClass, EVERY_QUALIFIER__OFF);
    createEReference(everyQualifierEClass, EVERY_QUALIFIER__OFFSET);

    delayedQualifierEClass = createEClass(DELAYED_QUALIFIER);
    createEAttribute(delayedQualifierEClass, DELAYED_QUALIFIER__IMMEDIATELY);
    createEReference(delayedQualifierEClass, DELAYED_QUALIFIER__COUNT);
    createEAttribute(delayedQualifierEClass, DELAYED_QUALIFIER__RESET);
    createEReference(delayedQualifierEClass, DELAYED_QUALIFIER__CLOCK);

    sustainedQualifierEClass = createEClass(SUSTAINED_QUALIFIER);
    createEAttribute(sustainedQualifierEClass, SUSTAINED_QUALIFIER__IMMEDIATELY);
    createEReference(sustainedQualifierEClass, SUSTAINED_QUALIFIER__START_CLOCK);
    createEReference(sustainedQualifierEClass, SUSTAINED_QUALIFIER__END_CLOCK);
    createEAttribute(sustainedQualifierEClass, SUSTAINED_QUALIFIER__WEAKLY);

    timeDelayedQualifierEClass = createEClass(TIME_DELAYED_QUALIFIER);
    createEReference(timeDelayedQualifierEClass, TIME_DELAYED_QUALIFIER__DELAY);
    createEReference(timeDelayedQualifierEClass, TIME_DELAYED_QUALIFIER__CLOCK);
    createEAttribute(timeDelayedQualifierEClass, TIME_DELAYED_QUALIFIER__RESET);
    createEAttribute(timeDelayedQualifierEClass, TIME_DELAYED_QUALIFIER__IMM_RESET);
    createEAttribute(timeDelayedQualifierEClass, TIME_DELAYED_QUALIFIER__STRONG_RESET);
    createEReference(timeDelayedQualifierEClass, TIME_DELAYED_QUALIFIER__RESET_CLOCK);

    letEClass = createEClass(LET);
    createEAttribute(letEClass, LET__TYPE);
    createEAttribute(letEClass, LET__NAME);
    createEReference(letEClass, LET__VALUE);

    valueEClass = createEClass(VALUE);

    integerValueEClass = createEClass(INTEGER_VALUE);
    createEAttribute(integerValueEClass, INTEGER_VALUE__SIGN);
    createEAttribute(integerValueEClass, INTEGER_VALUE__VALUE);

    decimalValueEClass = createEClass(DECIMAL_VALUE);
    createEAttribute(decimalValueEClass, DECIMAL_VALUE__SIGN);
    createEAttribute(decimalValueEClass, DECIMAL_VALUE__VALUE);

    floatValueEClass = createEClass(FLOAT_VALUE);
    createEAttribute(floatValueEClass, FLOAT_VALUE__SIGN);
    createEAttribute(floatValueEClass, FLOAT_VALUE__VALUE);

    rationalValueEClass = createEClass(RATIONAL_VALUE);
    createEAttribute(rationalValueEClass, RATIONAL_VALUE__SIGN);
    createEAttribute(rationalValueEClass, RATIONAL_VALUE__VALUE);

    letValueEClass = createEClass(LET_VALUE);
    createEReference(letValueEClass, LET_VALUE__REF);

    expressionEClass = createEClass(EXPRESSION);

    castEClass = createEClass(CAST);
    createEReference(castEClass, CAST__EXPR);

    intCastEClass = createEClass(INT_CAST);

    floatCastEClass = createEClass(FLOAT_CAST);

    decimalCastEClass = createEClass(DECIMAL_CAST);

    rationalCastEClass = createEClass(RATIONAL_CAST);

    whenQualifierEClass = createEClass(WHEN_QUALIFIER);
    createEAttribute(whenQualifierEClass, WHEN_QUALIFIER__NOT);
    createEReference(whenQualifierEClass, WHEN_QUALIFIER__CLOCK);

    nextQualifierEClass = createEClass(NEXT_QUALIFIER);
    createEAttribute(nextQualifierEClass, NEXT_QUALIFIER__STRICT);
    createEReference(nextQualifierEClass, NEXT_QUALIFIER__CLOCK);

    patternEClass = createEClass(PATTERN);
    createEReference(patternEClass, PATTERN__SKIP);
    createEReference(patternEClass, PATTERN__KEEP);
    createEAttribute(patternEClass, PATTERN__REP);
    createEReference(patternEClass, PATTERN__REPSKIP);
    createEReference(patternEClass, PATTERN__REPKEEP);

    tagRelationEClass = createEClass(TAG_RELATION);
    createEReference(tagRelationEClass, TAG_RELATION__EXPR);

    tagExprEClass = createEClass(TAG_EXPR);
    createEReference(tagExprEClass, TAG_EXPR__CLOCK_Y);
    createEReference(tagExprEClass, TAG_EXPR__VALUE_A);
    createEReference(tagExprEClass, TAG_EXPR__CLOCK_X);
    createEReference(tagExprEClass, TAG_EXPR__VALUE_N);
    createEReference(tagExprEClass, TAG_EXPR__VALUE_B);

    pragmaEClass = createEClass(PRAGMA);

    stopPragmaEClass = createEClass(STOP_PRAGMA);
    createEReference(stopPragmaEClass, STOP_PRAGMA__CLOCK);

    tagrefPragmaEClass = createEClass(TAGREF_PRAGMA);
    createEReference(tagrefPragmaEClass, TAGREF_PRAGMA__CLOCK);

    tracePragmaEClass = createEClass(TRACE_PRAGMA);
    createEAttribute(tracePragmaEClass, TRACE_PRAGMA__KINDS);

    maxstepPragmaEClass = createEClass(MAXSTEP_PRAGMA);
    createEReference(maxstepPragmaEClass, MAXSTEP_PRAGMA__VALUE);

    outputPragmaEClass = createEClass(OUTPUT_PRAGMA);
    createEAttribute(outputPragmaEClass, OUTPUT_PRAGMA__TYPE);
    createEAttribute(outputPragmaEClass, OUTPUT_PRAGMA__SELECTION);
    createEReference(outputPragmaEClass, OUTPUT_PRAGMA__SELECTED_CLOCKS);
    createEAttribute(outputPragmaEClass, OUTPUT_PRAGMA__WINDOW);
    createEReference(outputPragmaEClass, OUTPUT_PRAGMA__FROM);
    createEReference(outputPragmaEClass, OUTPUT_PRAGMA__TO);
    createEReference(outputPragmaEClass, OUTPUT_PRAGMA__LABELIF);
    createEAttribute(outputPragmaEClass, OUTPUT_PRAGMA__XSCALED);
    createEReference(outputPragmaEClass, OUTPUT_PRAGMA__XSCALE);
    createEAttribute(outputPragmaEClass, OUTPUT_PRAGMA__BORDER);
    createEAttribute(outputPragmaEClass, OUTPUT_PRAGMA__CSS);
    createEAttribute(outputPragmaEClass, OUTPUT_PRAGMA__NODEFCSS);
    createEAttribute(outputPragmaEClass, OUTPUT_PRAGMA__JVS);
    createEAttribute(outputPragmaEClass, OUTPUT_PRAGMA__STANDALONE);
    createEAttribute(outputPragmaEClass, OUTPUT_PRAGMA__OVERWRITE);

    clockItemEClass = createEClass(CLOCK_ITEM);
    createEReference(clockItemEClass, CLOCK_ITEM__CLOCK);
    createEAttribute(clockItemEClass, CLOCK_ITEM__NEW_NAME);

    doubleCalcPragmaEClass = createEClass(DOUBLE_CALC_PRAGMA);
    createEAttribute(doubleCalcPragmaEClass, DOUBLE_CALC_PRAGMA__NUM_DIGITS);
    createEAttribute(doubleCalcPragmaEClass, DOUBLE_CALC_PRAGMA__ROUND);
    createEAttribute(doubleCalcPragmaEClass, DOUBLE_CALC_PRAGMA__ROUNDING_MODE);

    dumpResultPragmaEClass = createEClass(DUMP_RESULT_PRAGMA);

    binOpEClass = createEClass(BIN_OP);
    createEReference(binOpEClass, BIN_OP__LEFT);
    createEAttribute(binOpEClass, BIN_OP__OP);
    createEReference(binOpEClass, BIN_OP__RIGHT);

    // Create enums
    typeEEnum = createEEnum(TYPE);
    valueTypeEEnum = createEEnum(VALUE_TYPE);
    opEEnum = createEEnum(OP);
    roundinG_MODEEEnum = createEEnum(ROUNDING_MODE);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private boolean isInitialized = false;

  /**
   * Complete the initialization of the package and its meta-model.  This
   * method is guarded to have no affect on any invocation but its first.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void initializePackageContents()
  {
    if (isInitialized) return;
    isInitialized = true;

    // Initialize package
    setName(eNAME);
    setNsPrefix(eNS_PREFIX);
    setNsURI(eNS_URI);

    // Create type parameters

    // Set bounds for type parameters

    // Add supertypes to classes
    periodicQualifierEClass.getESuperTypes().add(this.getClockQualifier());
    sporadicQualifierEClass.getESuperTypes().add(this.getClockQualifier());
    implicationRelationEClass.getESuperTypes().add(this.getRelation());
    awaitImplicationEClass.getESuperTypes().add(this.getRelation());
    filteredQualifierEClass.getESuperTypes().add(this.getImplicationQualifier());
    everyQualifierEClass.getESuperTypes().add(this.getImplicationQualifier());
    delayedQualifierEClass.getESuperTypes().add(this.getImplicationQualifier());
    sustainedQualifierEClass.getESuperTypes().add(this.getImplicationQualifier());
    timeDelayedQualifierEClass.getESuperTypes().add(this.getImplicationQualifier());
    valueEClass.getESuperTypes().add(this.getExpression());
    integerValueEClass.getESuperTypes().add(this.getValue());
    decimalValueEClass.getESuperTypes().add(this.getValue());
    floatValueEClass.getESuperTypes().add(this.getValue());
    rationalValueEClass.getESuperTypes().add(this.getValue());
    letValueEClass.getESuperTypes().add(this.getValue());
    castEClass.getESuperTypes().add(this.getExpression());
    intCastEClass.getESuperTypes().add(this.getCast());
    floatCastEClass.getESuperTypes().add(this.getCast());
    decimalCastEClass.getESuperTypes().add(this.getCast());
    rationalCastEClass.getESuperTypes().add(this.getCast());
    whenQualifierEClass.getESuperTypes().add(this.getImplicationQualifier());
    nextQualifierEClass.getESuperTypes().add(this.getImplicationQualifier());
    tagRelationEClass.getESuperTypes().add(this.getRelation());
    stopPragmaEClass.getESuperTypes().add(this.getPragma());
    tagrefPragmaEClass.getESuperTypes().add(this.getPragma());
    tracePragmaEClass.getESuperTypes().add(this.getPragma());
    maxstepPragmaEClass.getESuperTypes().add(this.getPragma());
    outputPragmaEClass.getESuperTypes().add(this.getPragma());
    doubleCalcPragmaEClass.getESuperTypes().add(this.getPragma());
    dumpResultPragmaEClass.getESuperTypes().add(this.getPragma());
    binOpEClass.getESuperTypes().add(this.getExpression());

    // Initialize classes and features; add operations and parameters
    initEClass(specificationEClass, Specification.class, "Specification", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getSpecification_Decl(), this.getClock(), null, "decl", null, 0, -1, Specification.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getSpecification_Rel(), this.getRelation(), null, "rel", null, 0, -1, Specification.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getSpecification_Let(), this.getLet(), null, "let", null, 0, -1, Specification.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getSpecification_Pragmas(), this.getPragma(), null, "pragmas", null, 0, -1, Specification.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(clockEClass, Clock.class, "Clock", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getClock_Nongreedy(), ecorePackage.getEBoolean(), "nongreedy", null, 0, 1, Clock.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getClock_Type(), this.getType(), "type", null, 0, 1, Clock.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getClock_Name(), ecorePackage.getEString(), "name", null, 0, 1, Clock.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getClock_Qual(), this.getClockQualifier(), null, "qual", null, 0, 1, Clock.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(clockQualifierEClass, ClockQualifier.class, "ClockQualifier", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

    initEClass(periodicQualifierEClass, PeriodicQualifier.class, "PeriodicQualifier", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getPeriodicQualifier_Period(), this.getExpression(), null, "period", null, 0, 1, PeriodicQualifier.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getPeriodicQualifier_Offset(), this.getExpression(), null, "offset", null, 0, 1, PeriodicQualifier.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(sporadicQualifierEClass, SporadicQualifier.class, "SporadicQualifier", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getSporadicQualifier_Instants(), this.getExpression(), null, "instants", null, 0, -1, SporadicQualifier.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(relationEClass, Relation.class, "Relation", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

    initEClass(implicationRelationEClass, ImplicationRelation.class, "ImplicationRelation", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getImplicationRelation_Source(), this.getClock(), null, "source", null, 0, 1, ImplicationRelation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getImplicationRelation_Qual(), this.getImplicationQualifier(), null, "qual", null, 0, 1, ImplicationRelation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getImplicationRelation_Target(), this.getClock(), null, "target", null, 0, 1, ImplicationRelation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(awaitImplicationEClass, AwaitImplication.class, "AwaitImplication", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getAwaitImplication_Masters(), this.getClock(), null, "masters", null, 0, -1, AwaitImplication.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getAwaitImplication_Weak(), ecorePackage.getEBoolean(), "weak", null, 0, 1, AwaitImplication.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getAwaitImplication_Strong(), ecorePackage.getEBoolean(), "strong", null, 0, 1, AwaitImplication.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getAwaitImplication_Reset(), this.getClock(), null, "reset", null, 0, 1, AwaitImplication.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getAwaitImplication_Target(), this.getClock(), null, "target", null, 0, 1, AwaitImplication.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(implicationQualifierEClass, ImplicationQualifier.class, "ImplicationQualifier", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

    initEClass(filteredQualifierEClass, FilteredQualifier.class, "FilteredQualifier", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getFilteredQualifier_Pattern(), this.getPattern(), null, "pattern", null, 0, 1, FilteredQualifier.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(everyQualifierEClass, EveryQualifier.class, "EveryQualifier", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getEveryQualifier_Period(), this.getExpression(), null, "period", null, 0, 1, EveryQualifier.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getEveryQualifier_Off(), ecorePackage.getEBoolean(), "off", null, 0, 1, EveryQualifier.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getEveryQualifier_Offset(), this.getExpression(), null, "offset", null, 0, 1, EveryQualifier.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(delayedQualifierEClass, DelayedQualifier.class, "DelayedQualifier", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getDelayedQualifier_Immediately(), ecorePackage.getEBoolean(), "immediately", null, 0, 1, DelayedQualifier.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getDelayedQualifier_Count(), this.getExpression(), null, "count", null, 0, 1, DelayedQualifier.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getDelayedQualifier_Reset(), ecorePackage.getEBoolean(), "reset", null, 0, 1, DelayedQualifier.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getDelayedQualifier_Clock(), this.getClock(), null, "clock", null, 0, 1, DelayedQualifier.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(sustainedQualifierEClass, SustainedQualifier.class, "SustainedQualifier", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getSustainedQualifier_Immediately(), ecorePackage.getEBoolean(), "immediately", null, 0, 1, SustainedQualifier.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getSustainedQualifier_StartClock(), this.getClock(), null, "startClock", null, 0, 1, SustainedQualifier.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getSustainedQualifier_EndClock(), this.getClock(), null, "endClock", null, 0, 1, SustainedQualifier.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getSustainedQualifier_Weakly(), ecorePackage.getEBoolean(), "weakly", null, 0, 1, SustainedQualifier.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(timeDelayedQualifierEClass, TimeDelayedQualifier.class, "TimeDelayedQualifier", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getTimeDelayedQualifier_Delay(), this.getExpression(), null, "delay", null, 0, 1, TimeDelayedQualifier.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getTimeDelayedQualifier_Clock(), this.getClock(), null, "clock", null, 0, 1, TimeDelayedQualifier.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getTimeDelayedQualifier_Reset(), ecorePackage.getEBoolean(), "reset", null, 0, 1, TimeDelayedQualifier.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getTimeDelayedQualifier_ImmReset(), ecorePackage.getEBoolean(), "immReset", null, 0, 1, TimeDelayedQualifier.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getTimeDelayedQualifier_StrongReset(), ecorePackage.getEBoolean(), "strongReset", null, 0, 1, TimeDelayedQualifier.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getTimeDelayedQualifier_ResetClock(), this.getClock(), null, "resetClock", null, 0, 1, TimeDelayedQualifier.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(letEClass, Let.class, "Let", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getLet_Type(), this.getValueType(), "type", null, 0, 1, Let.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getLet_Name(), ecorePackage.getEString(), "name", null, 0, 1, Let.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getLet_Value(), this.getExpression(), null, "value", null, 0, 1, Let.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(valueEClass, Value.class, "Value", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

    initEClass(integerValueEClass, IntegerValue.class, "IntegerValue", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getIntegerValue_Sign(), this.getOp(), "sign", null, 0, 1, IntegerValue.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getIntegerValue_Value(), ecorePackage.getEBigInteger(), "value", null, 0, 1, IntegerValue.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(decimalValueEClass, DecimalValue.class, "DecimalValue", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getDecimalValue_Sign(), this.getOp(), "sign", null, 0, 1, DecimalValue.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getDecimalValue_Value(), ecorePackage.getEBigDecimal(), "value", null, 0, 1, DecimalValue.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(floatValueEClass, FloatValue.class, "FloatValue", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getFloatValue_Sign(), this.getOp(), "sign", null, 0, 1, FloatValue.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getFloatValue_Value(), ecorePackage.getEDouble(), "value", null, 0, 1, FloatValue.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(rationalValueEClass, RationalValue.class, "RationalValue", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getRationalValue_Sign(), this.getOp(), "sign", null, 0, 1, RationalValue.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getRationalValue_Value(), ecorePackage.getEJavaObject(), "value", null, 0, 1, RationalValue.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(letValueEClass, LetValue.class, "LetValue", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getLetValue_Ref(), this.getLet(), null, "ref", null, 0, 1, LetValue.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(expressionEClass, Expression.class, "Expression", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

    initEClass(castEClass, Cast.class, "Cast", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getCast_Expr(), this.getExpression(), null, "expr", null, 0, 1, Cast.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(intCastEClass, IntCast.class, "IntCast", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

    initEClass(floatCastEClass, FloatCast.class, "FloatCast", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

    initEClass(decimalCastEClass, DecimalCast.class, "DecimalCast", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

    initEClass(rationalCastEClass, RationalCast.class, "RationalCast", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

    initEClass(whenQualifierEClass, WhenQualifier.class, "WhenQualifier", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getWhenQualifier_Not(), ecorePackage.getEBoolean(), "not", null, 0, 1, WhenQualifier.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getWhenQualifier_Clock(), this.getClock(), null, "clock", null, 0, 1, WhenQualifier.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(nextQualifierEClass, NextQualifier.class, "NextQualifier", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getNextQualifier_Strict(), ecorePackage.getEBoolean(), "strict", null, 0, 1, NextQualifier.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getNextQualifier_Clock(), this.getClock(), null, "clock", null, 0, 1, NextQualifier.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(patternEClass, Pattern.class, "Pattern", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getPattern_Skip(), this.getExpression(), null, "skip", null, 0, 1, Pattern.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getPattern_Keep(), this.getExpression(), null, "keep", null, 0, 1, Pattern.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getPattern_Rep(), ecorePackage.getEBoolean(), "rep", null, 0, 1, Pattern.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getPattern_Repskip(), this.getExpression(), null, "repskip", null, 0, 1, Pattern.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getPattern_Repkeep(), this.getExpression(), null, "repkeep", null, 0, 1, Pattern.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(tagRelationEClass, TagRelation.class, "TagRelation", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getTagRelation_Expr(), this.getTagExpr(), null, "expr", null, 0, 1, TagRelation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(tagExprEClass, TagExpr.class, "TagExpr", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getTagExpr_ClockY(), this.getClock(), null, "clockY", null, 0, 1, TagExpr.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getTagExpr_ValueA(), this.getExpression(), null, "valueA", null, 0, 1, TagExpr.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getTagExpr_ClockX(), this.getClock(), null, "clockX", null, 0, 1, TagExpr.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getTagExpr_ValueN(), this.getExpression(), null, "valueN", null, 0, 1, TagExpr.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getTagExpr_ValueB(), this.getExpression(), null, "valueB", null, 0, 1, TagExpr.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(pragmaEClass, Pragma.class, "Pragma", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

    initEClass(stopPragmaEClass, StopPragma.class, "StopPragma", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getStopPragma_Clock(), this.getClock(), null, "clock", null, 0, 1, StopPragma.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(tagrefPragmaEClass, TagrefPragma.class, "TagrefPragma", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getTagrefPragma_Clock(), this.getClock(), null, "clock", null, 0, 1, TagrefPragma.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(tracePragmaEClass, TracePragma.class, "TracePragma", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getTracePragma_Kinds(), ecorePackage.getEString(), "kinds", null, 0, -1, TracePragma.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(maxstepPragmaEClass, MaxstepPragma.class, "MaxstepPragma", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getMaxstepPragma_Value(), this.getExpression(), null, "value", null, 0, 1, MaxstepPragma.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(outputPragmaEClass, OutputPragma.class, "OutputPragma", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getOutputPragma_Type(), ecorePackage.getEString(), "type", null, 0, 1, OutputPragma.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getOutputPragma_Selection(), ecorePackage.getEBoolean(), "selection", null, 0, 1, OutputPragma.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getOutputPragma_SelectedClocks(), this.getClockItem(), null, "selectedClocks", null, 0, -1, OutputPragma.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getOutputPragma_Window(), ecorePackage.getEBoolean(), "window", null, 0, 1, OutputPragma.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getOutputPragma_From(), this.getExpression(), null, "from", null, 0, 1, OutputPragma.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getOutputPragma_To(), this.getExpression(), null, "to", null, 0, 1, OutputPragma.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getOutputPragma_Labelif(), this.getClock(), null, "labelif", null, 0, -1, OutputPragma.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getOutputPragma_Xscaled(), ecorePackage.getEBoolean(), "xscaled", null, 0, 1, OutputPragma.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getOutputPragma_Xscale(), this.getExpression(), null, "xscale", null, 0, 1, OutputPragma.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getOutputPragma_Border(), ecorePackage.getEString(), "border", null, 0, 1, OutputPragma.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getOutputPragma_Css(), ecorePackage.getEString(), "css", null, 0, 1, OutputPragma.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getOutputPragma_Nodefcss(), ecorePackage.getEBoolean(), "nodefcss", null, 0, 1, OutputPragma.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getOutputPragma_Jvs(), ecorePackage.getEString(), "jvs", null, 0, 1, OutputPragma.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getOutputPragma_Standalone(), ecorePackage.getEBoolean(), "standalone", null, 0, 1, OutputPragma.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getOutputPragma_Overwrite(), ecorePackage.getEBoolean(), "overwrite", null, 0, 1, OutputPragma.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(clockItemEClass, ClockItem.class, "ClockItem", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getClockItem_Clock(), this.getClock(), null, "clock", null, 0, 1, ClockItem.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getClockItem_NewName(), ecorePackage.getEString(), "newName", null, 0, 1, ClockItem.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(doubleCalcPragmaEClass, DoubleCalcPragma.class, "DoubleCalcPragma", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getDoubleCalcPragma_Num_digits(), ecorePackage.getEBigInteger(), "num_digits", null, 0, 1, DoubleCalcPragma.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getDoubleCalcPragma_Round(), ecorePackage.getEBoolean(), "round", null, 0, 1, DoubleCalcPragma.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getDoubleCalcPragma_Rounding_mode(), this.getROUNDING_MODE(), "rounding_mode", null, 0, 1, DoubleCalcPragma.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(dumpResultPragmaEClass, DumpResultPragma.class, "DumpResultPragma", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

    initEClass(binOpEClass, BinOp.class, "BinOp", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getBinOp_Left(), this.getExpression(), null, "left", null, 0, 1, BinOp.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getBinOp_Op(), this.getOp(), "op", null, 0, 1, BinOp.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getBinOp_Right(), this.getExpression(), null, "right", null, 0, 1, BinOp.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    // Initialize enums and add enum literals
    initEEnum(typeEEnum, Type.class, "Type");
    addEEnumLiteral(typeEEnum, Type.TUNIT);
    addEEnumLiteral(typeEEnum, Type.TINT);
    addEEnumLiteral(typeEEnum, Type.TDEC);
    addEEnumLiteral(typeEEnum, Type.TRAT);
    addEEnumLiteral(typeEEnum, Type.TFLOAT);

    initEEnum(valueTypeEEnum, ValueType.class, "ValueType");
    addEEnumLiteral(valueTypeEEnum, ValueType.TINT);
    addEEnumLiteral(valueTypeEEnum, ValueType.TDEC);
    addEEnumLiteral(valueTypeEEnum, ValueType.TRAT);
    addEEnumLiteral(valueTypeEEnum, ValueType.TFLOAT);

    initEEnum(opEEnum, Op.class, "Op");
    addEEnumLiteral(opEEnum, Op.PLUS);
    addEEnumLiteral(opEEnum, Op.MINUS);
    addEEnumLiteral(opEEnum, Op.TIMES);
    addEEnumLiteral(opEEnum, Op.DIV);

    initEEnum(roundinG_MODEEEnum, fr.supelec.tesl.lang.tesl.ROUNDING_MODE.class, "ROUNDING_MODE");
    addEEnumLiteral(roundinG_MODEEEnum, fr.supelec.tesl.lang.tesl.ROUNDING_MODE.ROUND_UP);
    addEEnumLiteral(roundinG_MODEEEnum, fr.supelec.tesl.lang.tesl.ROUNDING_MODE.ROUND_DOWN);
    addEEnumLiteral(roundinG_MODEEEnum, fr.supelec.tesl.lang.tesl.ROUNDING_MODE.ROUND_CEILING);
    addEEnumLiteral(roundinG_MODEEEnum, fr.supelec.tesl.lang.tesl.ROUNDING_MODE.ROUND_FLOOR);
    addEEnumLiteral(roundinG_MODEEEnum, fr.supelec.tesl.lang.tesl.ROUNDING_MODE.ROUND_HALF_UP);
    addEEnumLiteral(roundinG_MODEEEnum, fr.supelec.tesl.lang.tesl.ROUNDING_MODE.ROUND_HALF_DOWN);
    addEEnumLiteral(roundinG_MODEEEnum, fr.supelec.tesl.lang.tesl.ROUNDING_MODE.ROUND_HALF_EVEN);

    // Create resource
    createResource(eNS_URI);
  }

} //TeslPackageImpl
