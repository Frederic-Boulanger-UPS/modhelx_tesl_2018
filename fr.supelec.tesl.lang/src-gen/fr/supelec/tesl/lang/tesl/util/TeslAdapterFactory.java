/**
 */
package fr.supelec.tesl.lang.tesl.util;

import fr.supelec.tesl.lang.tesl.*;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notifier;

import org.eclipse.emf.common.notify.impl.AdapterFactoryImpl;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * The <b>Adapter Factory</b> for the model.
 * It provides an adapter <code>createXXX</code> method for each class of the model.
 * <!-- end-user-doc -->
 * @see fr.supelec.tesl.lang.tesl.TeslPackage
 * @generated
 */
public class TeslAdapterFactory extends AdapterFactoryImpl
{
  /**
   * The cached model package.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected static TeslPackage modelPackage;

  /**
   * Creates an instance of the adapter factory.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public TeslAdapterFactory()
  {
    if (modelPackage == null)
    {
      modelPackage = TeslPackage.eINSTANCE;
    }
  }

  /**
   * Returns whether this factory is applicable for the type of the object.
   * <!-- begin-user-doc -->
   * This implementation returns <code>true</code> if the object is either the model's package or is an instance object of the model.
   * <!-- end-user-doc -->
   * @return whether this factory is applicable for the type of the object.
   * @generated
   */
  @Override
  public boolean isFactoryForType(Object object)
  {
    if (object == modelPackage)
    {
      return true;
    }
    if (object instanceof EObject)
    {
      return ((EObject)object).eClass().getEPackage() == modelPackage;
    }
    return false;
  }

  /**
   * The switch that delegates to the <code>createXXX</code> methods.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected TeslSwitch<Adapter> modelSwitch =
    new TeslSwitch<Adapter>()
    {
      @Override
      public Adapter caseSpecification(Specification object)
      {
        return createSpecificationAdapter();
      }
      @Override
      public Adapter caseClock(Clock object)
      {
        return createClockAdapter();
      }
      @Override
      public Adapter caseClockQualifier(ClockQualifier object)
      {
        return createClockQualifierAdapter();
      }
      @Override
      public Adapter casePeriodicQualifier(PeriodicQualifier object)
      {
        return createPeriodicQualifierAdapter();
      }
      @Override
      public Adapter caseSporadicQualifier(SporadicQualifier object)
      {
        return createSporadicQualifierAdapter();
      }
      @Override
      public Adapter caseRelation(Relation object)
      {
        return createRelationAdapter();
      }
      @Override
      public Adapter caseImplicationRelation(ImplicationRelation object)
      {
        return createImplicationRelationAdapter();
      }
      @Override
      public Adapter caseAwaitImplication(AwaitImplication object)
      {
        return createAwaitImplicationAdapter();
      }
      @Override
      public Adapter caseImplicationQualifier(ImplicationQualifier object)
      {
        return createImplicationQualifierAdapter();
      }
      @Override
      public Adapter caseFilteredQualifier(FilteredQualifier object)
      {
        return createFilteredQualifierAdapter();
      }
      @Override
      public Adapter caseEveryQualifier(EveryQualifier object)
      {
        return createEveryQualifierAdapter();
      }
      @Override
      public Adapter caseDelayedQualifier(DelayedQualifier object)
      {
        return createDelayedQualifierAdapter();
      }
      @Override
      public Adapter caseSustainedQualifier(SustainedQualifier object)
      {
        return createSustainedQualifierAdapter();
      }
      @Override
      public Adapter caseTimeDelayedQualifier(TimeDelayedQualifier object)
      {
        return createTimeDelayedQualifierAdapter();
      }
      @Override
      public Adapter caseLet(Let object)
      {
        return createLetAdapter();
      }
      @Override
      public Adapter caseValue(Value object)
      {
        return createValueAdapter();
      }
      @Override
      public Adapter caseIntegerValue(IntegerValue object)
      {
        return createIntegerValueAdapter();
      }
      @Override
      public Adapter caseDecimalValue(DecimalValue object)
      {
        return createDecimalValueAdapter();
      }
      @Override
      public Adapter caseFloatValue(FloatValue object)
      {
        return createFloatValueAdapter();
      }
      @Override
      public Adapter caseRationalValue(RationalValue object)
      {
        return createRationalValueAdapter();
      }
      @Override
      public Adapter caseLetValue(LetValue object)
      {
        return createLetValueAdapter();
      }
      @Override
      public Adapter caseExpression(Expression object)
      {
        return createExpressionAdapter();
      }
      @Override
      public Adapter caseCast(Cast object)
      {
        return createCastAdapter();
      }
      @Override
      public Adapter caseIntCast(IntCast object)
      {
        return createIntCastAdapter();
      }
      @Override
      public Adapter caseFloatCast(FloatCast object)
      {
        return createFloatCastAdapter();
      }
      @Override
      public Adapter caseDecimalCast(DecimalCast object)
      {
        return createDecimalCastAdapter();
      }
      @Override
      public Adapter caseRationalCast(RationalCast object)
      {
        return createRationalCastAdapter();
      }
      @Override
      public Adapter caseWhenQualifier(WhenQualifier object)
      {
        return createWhenQualifierAdapter();
      }
      @Override
      public Adapter caseNextQualifier(NextQualifier object)
      {
        return createNextQualifierAdapter();
      }
      @Override
      public Adapter casePattern(Pattern object)
      {
        return createPatternAdapter();
      }
      @Override
      public Adapter caseTagRelation(TagRelation object)
      {
        return createTagRelationAdapter();
      }
      @Override
      public Adapter caseTagExpr(TagExpr object)
      {
        return createTagExprAdapter();
      }
      @Override
      public Adapter casePragma(Pragma object)
      {
        return createPragmaAdapter();
      }
      @Override
      public Adapter caseStopPragma(StopPragma object)
      {
        return createStopPragmaAdapter();
      }
      @Override
      public Adapter caseTagrefPragma(TagrefPragma object)
      {
        return createTagrefPragmaAdapter();
      }
      @Override
      public Adapter caseTracePragma(TracePragma object)
      {
        return createTracePragmaAdapter();
      }
      @Override
      public Adapter caseMaxstepPragma(MaxstepPragma object)
      {
        return createMaxstepPragmaAdapter();
      }
      @Override
      public Adapter caseOutputPragma(OutputPragma object)
      {
        return createOutputPragmaAdapter();
      }
      @Override
      public Adapter caseClockItem(ClockItem object)
      {
        return createClockItemAdapter();
      }
      @Override
      public Adapter caseDoubleCalcPragma(DoubleCalcPragma object)
      {
        return createDoubleCalcPragmaAdapter();
      }
      @Override
      public Adapter caseDumpResultPragma(DumpResultPragma object)
      {
        return createDumpResultPragmaAdapter();
      }
      @Override
      public Adapter caseBinOp(BinOp object)
      {
        return createBinOpAdapter();
      }
      @Override
      public Adapter defaultCase(EObject object)
      {
        return createEObjectAdapter();
      }
    };

  /**
   * Creates an adapter for the <code>target</code>.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param target the object to adapt.
   * @return the adapter for the <code>target</code>.
   * @generated
   */
  @Override
  public Adapter createAdapter(Notifier target)
  {
    return modelSwitch.doSwitch((EObject)target);
  }


  /**
   * Creates a new adapter for an object of class '{@link fr.supelec.tesl.lang.tesl.Specification <em>Specification</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see fr.supelec.tesl.lang.tesl.Specification
   * @generated
   */
  public Adapter createSpecificationAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link fr.supelec.tesl.lang.tesl.Clock <em>Clock</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see fr.supelec.tesl.lang.tesl.Clock
   * @generated
   */
  public Adapter createClockAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link fr.supelec.tesl.lang.tesl.ClockQualifier <em>Clock Qualifier</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see fr.supelec.tesl.lang.tesl.ClockQualifier
   * @generated
   */
  public Adapter createClockQualifierAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link fr.supelec.tesl.lang.tesl.PeriodicQualifier <em>Periodic Qualifier</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see fr.supelec.tesl.lang.tesl.PeriodicQualifier
   * @generated
   */
  public Adapter createPeriodicQualifierAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link fr.supelec.tesl.lang.tesl.SporadicQualifier <em>Sporadic Qualifier</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see fr.supelec.tesl.lang.tesl.SporadicQualifier
   * @generated
   */
  public Adapter createSporadicQualifierAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link fr.supelec.tesl.lang.tesl.Relation <em>Relation</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see fr.supelec.tesl.lang.tesl.Relation
   * @generated
   */
  public Adapter createRelationAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link fr.supelec.tesl.lang.tesl.ImplicationRelation <em>Implication Relation</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see fr.supelec.tesl.lang.tesl.ImplicationRelation
   * @generated
   */
  public Adapter createImplicationRelationAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link fr.supelec.tesl.lang.tesl.AwaitImplication <em>Await Implication</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see fr.supelec.tesl.lang.tesl.AwaitImplication
   * @generated
   */
  public Adapter createAwaitImplicationAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link fr.supelec.tesl.lang.tesl.ImplicationQualifier <em>Implication Qualifier</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see fr.supelec.tesl.lang.tesl.ImplicationQualifier
   * @generated
   */
  public Adapter createImplicationQualifierAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link fr.supelec.tesl.lang.tesl.FilteredQualifier <em>Filtered Qualifier</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see fr.supelec.tesl.lang.tesl.FilteredQualifier
   * @generated
   */
  public Adapter createFilteredQualifierAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link fr.supelec.tesl.lang.tesl.EveryQualifier <em>Every Qualifier</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see fr.supelec.tesl.lang.tesl.EveryQualifier
   * @generated
   */
  public Adapter createEveryQualifierAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link fr.supelec.tesl.lang.tesl.DelayedQualifier <em>Delayed Qualifier</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see fr.supelec.tesl.lang.tesl.DelayedQualifier
   * @generated
   */
  public Adapter createDelayedQualifierAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link fr.supelec.tesl.lang.tesl.SustainedQualifier <em>Sustained Qualifier</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see fr.supelec.tesl.lang.tesl.SustainedQualifier
   * @generated
   */
  public Adapter createSustainedQualifierAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link fr.supelec.tesl.lang.tesl.TimeDelayedQualifier <em>Time Delayed Qualifier</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see fr.supelec.tesl.lang.tesl.TimeDelayedQualifier
   * @generated
   */
  public Adapter createTimeDelayedQualifierAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link fr.supelec.tesl.lang.tesl.Let <em>Let</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see fr.supelec.tesl.lang.tesl.Let
   * @generated
   */
  public Adapter createLetAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link fr.supelec.tesl.lang.tesl.Value <em>Value</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see fr.supelec.tesl.lang.tesl.Value
   * @generated
   */
  public Adapter createValueAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link fr.supelec.tesl.lang.tesl.IntegerValue <em>Integer Value</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see fr.supelec.tesl.lang.tesl.IntegerValue
   * @generated
   */
  public Adapter createIntegerValueAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link fr.supelec.tesl.lang.tesl.DecimalValue <em>Decimal Value</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see fr.supelec.tesl.lang.tesl.DecimalValue
   * @generated
   */
  public Adapter createDecimalValueAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link fr.supelec.tesl.lang.tesl.FloatValue <em>Float Value</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see fr.supelec.tesl.lang.tesl.FloatValue
   * @generated
   */
  public Adapter createFloatValueAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link fr.supelec.tesl.lang.tesl.RationalValue <em>Rational Value</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see fr.supelec.tesl.lang.tesl.RationalValue
   * @generated
   */
  public Adapter createRationalValueAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link fr.supelec.tesl.lang.tesl.LetValue <em>Let Value</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see fr.supelec.tesl.lang.tesl.LetValue
   * @generated
   */
  public Adapter createLetValueAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link fr.supelec.tesl.lang.tesl.Expression <em>Expression</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see fr.supelec.tesl.lang.tesl.Expression
   * @generated
   */
  public Adapter createExpressionAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link fr.supelec.tesl.lang.tesl.Cast <em>Cast</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see fr.supelec.tesl.lang.tesl.Cast
   * @generated
   */
  public Adapter createCastAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link fr.supelec.tesl.lang.tesl.IntCast <em>Int Cast</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see fr.supelec.tesl.lang.tesl.IntCast
   * @generated
   */
  public Adapter createIntCastAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link fr.supelec.tesl.lang.tesl.FloatCast <em>Float Cast</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see fr.supelec.tesl.lang.tesl.FloatCast
   * @generated
   */
  public Adapter createFloatCastAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link fr.supelec.tesl.lang.tesl.DecimalCast <em>Decimal Cast</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see fr.supelec.tesl.lang.tesl.DecimalCast
   * @generated
   */
  public Adapter createDecimalCastAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link fr.supelec.tesl.lang.tesl.RationalCast <em>Rational Cast</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see fr.supelec.tesl.lang.tesl.RationalCast
   * @generated
   */
  public Adapter createRationalCastAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link fr.supelec.tesl.lang.tesl.WhenQualifier <em>When Qualifier</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see fr.supelec.tesl.lang.tesl.WhenQualifier
   * @generated
   */
  public Adapter createWhenQualifierAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link fr.supelec.tesl.lang.tesl.NextQualifier <em>Next Qualifier</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see fr.supelec.tesl.lang.tesl.NextQualifier
   * @generated
   */
  public Adapter createNextQualifierAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link fr.supelec.tesl.lang.tesl.Pattern <em>Pattern</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see fr.supelec.tesl.lang.tesl.Pattern
   * @generated
   */
  public Adapter createPatternAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link fr.supelec.tesl.lang.tesl.TagRelation <em>Tag Relation</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see fr.supelec.tesl.lang.tesl.TagRelation
   * @generated
   */
  public Adapter createTagRelationAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link fr.supelec.tesl.lang.tesl.TagExpr <em>Tag Expr</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see fr.supelec.tesl.lang.tesl.TagExpr
   * @generated
   */
  public Adapter createTagExprAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link fr.supelec.tesl.lang.tesl.Pragma <em>Pragma</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see fr.supelec.tesl.lang.tesl.Pragma
   * @generated
   */
  public Adapter createPragmaAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link fr.supelec.tesl.lang.tesl.StopPragma <em>Stop Pragma</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see fr.supelec.tesl.lang.tesl.StopPragma
   * @generated
   */
  public Adapter createStopPragmaAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link fr.supelec.tesl.lang.tesl.TagrefPragma <em>Tagref Pragma</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see fr.supelec.tesl.lang.tesl.TagrefPragma
   * @generated
   */
  public Adapter createTagrefPragmaAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link fr.supelec.tesl.lang.tesl.TracePragma <em>Trace Pragma</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see fr.supelec.tesl.lang.tesl.TracePragma
   * @generated
   */
  public Adapter createTracePragmaAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link fr.supelec.tesl.lang.tesl.MaxstepPragma <em>Maxstep Pragma</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see fr.supelec.tesl.lang.tesl.MaxstepPragma
   * @generated
   */
  public Adapter createMaxstepPragmaAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link fr.supelec.tesl.lang.tesl.OutputPragma <em>Output Pragma</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see fr.supelec.tesl.lang.tesl.OutputPragma
   * @generated
   */
  public Adapter createOutputPragmaAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link fr.supelec.tesl.lang.tesl.ClockItem <em>Clock Item</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see fr.supelec.tesl.lang.tesl.ClockItem
   * @generated
   */
  public Adapter createClockItemAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link fr.supelec.tesl.lang.tesl.DoubleCalcPragma <em>Double Calc Pragma</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see fr.supelec.tesl.lang.tesl.DoubleCalcPragma
   * @generated
   */
  public Adapter createDoubleCalcPragmaAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link fr.supelec.tesl.lang.tesl.DumpResultPragma <em>Dump Result Pragma</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see fr.supelec.tesl.lang.tesl.DumpResultPragma
   * @generated
   */
  public Adapter createDumpResultPragmaAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link fr.supelec.tesl.lang.tesl.BinOp <em>Bin Op</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see fr.supelec.tesl.lang.tesl.BinOp
   * @generated
   */
  public Adapter createBinOpAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for the default case.
   * <!-- begin-user-doc -->
   * This default implementation returns null.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @generated
   */
  public Adapter createEObjectAdapter()
  {
    return null;
  }

} //TeslAdapterFactory
