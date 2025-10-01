/**
 */
package fr.supelec.tesl.lang.tesl.impl;

import fr.supelec.tesl.lang.tesl.*;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class TeslFactoryImpl extends EFactoryImpl implements TeslFactory
{
  /**
   * Creates the default factory implementation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public static TeslFactory init()
  {
    try
    {
      TeslFactory theTeslFactory = (TeslFactory)EPackage.Registry.INSTANCE.getEFactory(TeslPackage.eNS_URI);
      if (theTeslFactory != null)
      {
        return theTeslFactory;
      }
    }
    catch (Exception exception)
    {
      EcorePlugin.INSTANCE.log(exception);
    }
    return new TeslFactoryImpl();
  }

  /**
   * Creates an instance of the factory.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public TeslFactoryImpl()
  {
    super();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EObject create(EClass eClass)
  {
    switch (eClass.getClassifierID())
    {
      case TeslPackage.SPECIFICATION: return createSpecification();
      case TeslPackage.CLOCK: return createClock();
      case TeslPackage.CLOCK_QUALIFIER: return createClockQualifier();
      case TeslPackage.PERIODIC_QUALIFIER: return createPeriodicQualifier();
      case TeslPackage.SPORADIC_QUALIFIER: return createSporadicQualifier();
      case TeslPackage.RELATION: return createRelation();
      case TeslPackage.IMPLICATION_RELATION: return createImplicationRelation();
      case TeslPackage.AWAIT_IMPLICATION: return createAwaitImplication();
      case TeslPackage.IMPLICATION_QUALIFIER: return createImplicationQualifier();
      case TeslPackage.FILTERED_QUALIFIER: return createFilteredQualifier();
      case TeslPackage.EVERY_QUALIFIER: return createEveryQualifier();
      case TeslPackage.DELAYED_QUALIFIER: return createDelayedQualifier();
      case TeslPackage.SUSTAINED_QUALIFIER: return createSustainedQualifier();
      case TeslPackage.TIME_DELAYED_QUALIFIER: return createTimeDelayedQualifier();
      case TeslPackage.LET: return createLet();
      case TeslPackage.VALUE: return createValue();
      case TeslPackage.INTEGER_VALUE: return createIntegerValue();
      case TeslPackage.DECIMAL_VALUE: return createDecimalValue();
      case TeslPackage.FLOAT_VALUE: return createFloatValue();
      case TeslPackage.RATIONAL_VALUE: return createRationalValue();
      case TeslPackage.LET_VALUE: return createLetValue();
      case TeslPackage.EXPRESSION: return createExpression();
      case TeslPackage.CAST: return createCast();
      case TeslPackage.INT_CAST: return createIntCast();
      case TeslPackage.FLOAT_CAST: return createFloatCast();
      case TeslPackage.DECIMAL_CAST: return createDecimalCast();
      case TeslPackage.RATIONAL_CAST: return createRationalCast();
      case TeslPackage.WHEN_QUALIFIER: return createWhenQualifier();
      case TeslPackage.NEXT_QUALIFIER: return createNextQualifier();
      case TeslPackage.PATTERN: return createPattern();
      case TeslPackage.TAG_RELATION: return createTagRelation();
      case TeslPackage.TAG_EXPR: return createTagExpr();
      case TeslPackage.PRAGMA: return createPragma();
      case TeslPackage.STOP_PRAGMA: return createStopPragma();
      case TeslPackage.TAGREF_PRAGMA: return createTagrefPragma();
      case TeslPackage.TRACE_PRAGMA: return createTracePragma();
      case TeslPackage.MAXSTEP_PRAGMA: return createMaxstepPragma();
      case TeslPackage.OUTPUT_PRAGMA: return createOutputPragma();
      case TeslPackage.CLOCK_ITEM: return createClockItem();
      case TeslPackage.DOUBLE_CALC_PRAGMA: return createDoubleCalcPragma();
      case TeslPackage.DUMP_RESULT_PRAGMA: return createDumpResultPragma();
      case TeslPackage.BIN_OP: return createBinOp();
      default:
        throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
    }
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public Object createFromString(EDataType eDataType, String initialValue)
  {
    switch (eDataType.getClassifierID())
    {
      case TeslPackage.TYPE:
        return createTypeFromString(eDataType, initialValue);
      case TeslPackage.VALUE_TYPE:
        return createValueTypeFromString(eDataType, initialValue);
      case TeslPackage.OP:
        return createOpFromString(eDataType, initialValue);
      case TeslPackage.ROUNDING_MODE:
        return createROUNDING_MODEFromString(eDataType, initialValue);
      default:
        throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier");
    }
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public String convertToString(EDataType eDataType, Object instanceValue)
  {
    switch (eDataType.getClassifierID())
    {
      case TeslPackage.TYPE:
        return convertTypeToString(eDataType, instanceValue);
      case TeslPackage.VALUE_TYPE:
        return convertValueTypeToString(eDataType, instanceValue);
      case TeslPackage.OP:
        return convertOpToString(eDataType, instanceValue);
      case TeslPackage.ROUNDING_MODE:
        return convertROUNDING_MODEToString(eDataType, instanceValue);
      default:
        throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier");
    }
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public Specification createSpecification()
  {
    SpecificationImpl specification = new SpecificationImpl();
    return specification;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public Clock createClock()
  {
    ClockImpl clock = new ClockImpl();
    return clock;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public ClockQualifier createClockQualifier()
  {
    ClockQualifierImpl clockQualifier = new ClockQualifierImpl();
    return clockQualifier;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public PeriodicQualifier createPeriodicQualifier()
  {
    PeriodicQualifierImpl periodicQualifier = new PeriodicQualifierImpl();
    return periodicQualifier;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public SporadicQualifier createSporadicQualifier()
  {
    SporadicQualifierImpl sporadicQualifier = new SporadicQualifierImpl();
    return sporadicQualifier;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public Relation createRelation()
  {
    RelationImpl relation = new RelationImpl();
    return relation;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public ImplicationRelation createImplicationRelation()
  {
    ImplicationRelationImpl implicationRelation = new ImplicationRelationImpl();
    return implicationRelation;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public AwaitImplication createAwaitImplication()
  {
    AwaitImplicationImpl awaitImplication = new AwaitImplicationImpl();
    return awaitImplication;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public ImplicationQualifier createImplicationQualifier()
  {
    ImplicationQualifierImpl implicationQualifier = new ImplicationQualifierImpl();
    return implicationQualifier;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public FilteredQualifier createFilteredQualifier()
  {
    FilteredQualifierImpl filteredQualifier = new FilteredQualifierImpl();
    return filteredQualifier;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EveryQualifier createEveryQualifier()
  {
    EveryQualifierImpl everyQualifier = new EveryQualifierImpl();
    return everyQualifier;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public DelayedQualifier createDelayedQualifier()
  {
    DelayedQualifierImpl delayedQualifier = new DelayedQualifierImpl();
    return delayedQualifier;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public SustainedQualifier createSustainedQualifier()
  {
    SustainedQualifierImpl sustainedQualifier = new SustainedQualifierImpl();
    return sustainedQualifier;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public TimeDelayedQualifier createTimeDelayedQualifier()
  {
    TimeDelayedQualifierImpl timeDelayedQualifier = new TimeDelayedQualifierImpl();
    return timeDelayedQualifier;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public Let createLet()
  {
    LetImpl let = new LetImpl();
    return let;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public Value createValue()
  {
    ValueImpl value = new ValueImpl();
    return value;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public IntegerValue createIntegerValue()
  {
    IntegerValueImpl integerValue = new IntegerValueImpl();
    return integerValue;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public DecimalValue createDecimalValue()
  {
    DecimalValueImpl decimalValue = new DecimalValueImpl();
    return decimalValue;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public FloatValue createFloatValue()
  {
    FloatValueImpl floatValue = new FloatValueImpl();
    return floatValue;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public RationalValue createRationalValue()
  {
    RationalValueImpl rationalValue = new RationalValueImpl();
    return rationalValue;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public LetValue createLetValue()
  {
    LetValueImpl letValue = new LetValueImpl();
    return letValue;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public Expression createExpression()
  {
    ExpressionImpl expression = new ExpressionImpl();
    return expression;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public Cast createCast()
  {
    CastImpl cast = new CastImpl();
    return cast;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public IntCast createIntCast()
  {
    IntCastImpl intCast = new IntCastImpl();
    return intCast;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public FloatCast createFloatCast()
  {
    FloatCastImpl floatCast = new FloatCastImpl();
    return floatCast;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public DecimalCast createDecimalCast()
  {
    DecimalCastImpl decimalCast = new DecimalCastImpl();
    return decimalCast;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public RationalCast createRationalCast()
  {
    RationalCastImpl rationalCast = new RationalCastImpl();
    return rationalCast;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public WhenQualifier createWhenQualifier()
  {
    WhenQualifierImpl whenQualifier = new WhenQualifierImpl();
    return whenQualifier;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public NextQualifier createNextQualifier()
  {
    NextQualifierImpl nextQualifier = new NextQualifierImpl();
    return nextQualifier;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public Pattern createPattern()
  {
    PatternImpl pattern = new PatternImpl();
    return pattern;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public TagRelation createTagRelation()
  {
    TagRelationImpl tagRelation = new TagRelationImpl();
    return tagRelation;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public TagExpr createTagExpr()
  {
    TagExprImpl tagExpr = new TagExprImpl();
    return tagExpr;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public Pragma createPragma()
  {
    PragmaImpl pragma = new PragmaImpl();
    return pragma;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public StopPragma createStopPragma()
  {
    StopPragmaImpl stopPragma = new StopPragmaImpl();
    return stopPragma;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public TagrefPragma createTagrefPragma()
  {
    TagrefPragmaImpl tagrefPragma = new TagrefPragmaImpl();
    return tagrefPragma;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public TracePragma createTracePragma()
  {
    TracePragmaImpl tracePragma = new TracePragmaImpl();
    return tracePragma;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public MaxstepPragma createMaxstepPragma()
  {
    MaxstepPragmaImpl maxstepPragma = new MaxstepPragmaImpl();
    return maxstepPragma;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public OutputPragma createOutputPragma()
  {
    OutputPragmaImpl outputPragma = new OutputPragmaImpl();
    return outputPragma;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public ClockItem createClockItem()
  {
    ClockItemImpl clockItem = new ClockItemImpl();
    return clockItem;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public DoubleCalcPragma createDoubleCalcPragma()
  {
    DoubleCalcPragmaImpl doubleCalcPragma = new DoubleCalcPragmaImpl();
    return doubleCalcPragma;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public DumpResultPragma createDumpResultPragma()
  {
    DumpResultPragmaImpl dumpResultPragma = new DumpResultPragmaImpl();
    return dumpResultPragma;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public BinOp createBinOp()
  {
    BinOpImpl binOp = new BinOpImpl();
    return binOp;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Type createTypeFromString(EDataType eDataType, String initialValue)
  {
    Type result = Type.get(initialValue);
    if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
    return result;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String convertTypeToString(EDataType eDataType, Object instanceValue)
  {
    return instanceValue == null ? null : instanceValue.toString();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ValueType createValueTypeFromString(EDataType eDataType, String initialValue)
  {
    ValueType result = ValueType.get(initialValue);
    if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
    return result;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String convertValueTypeToString(EDataType eDataType, Object instanceValue)
  {
    return instanceValue == null ? null : instanceValue.toString();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Op createOpFromString(EDataType eDataType, String initialValue)
  {
    Op result = Op.get(initialValue);
    if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
    return result;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String convertOpToString(EDataType eDataType, Object instanceValue)
  {
    return instanceValue == null ? null : instanceValue.toString();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ROUNDING_MODE createROUNDING_MODEFromString(EDataType eDataType, String initialValue)
  {
    ROUNDING_MODE result = ROUNDING_MODE.get(initialValue);
    if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
    return result;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String convertROUNDING_MODEToString(EDataType eDataType, Object instanceValue)
  {
    return instanceValue == null ? null : instanceValue.toString();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public TeslPackage getTeslPackage()
  {
    return (TeslPackage)getEPackage();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @deprecated
   * @generated
   */
  @Deprecated
  public static TeslPackage getPackage()
  {
    return TeslPackage.eINSTANCE;
  }

} //TeslFactoryImpl
