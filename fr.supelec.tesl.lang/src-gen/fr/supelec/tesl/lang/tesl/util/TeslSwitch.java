/**
 */
package fr.supelec.tesl.lang.tesl.util;

import fr.supelec.tesl.lang.tesl.*;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.util.Switch;

/**
 * <!-- begin-user-doc -->
 * The <b>Switch</b> for the model's inheritance hierarchy.
 * It supports the call {@link #doSwitch(EObject) doSwitch(object)}
 * to invoke the <code>caseXXX</code> method for each class of the model,
 * starting with the actual class of the object
 * and proceeding up the inheritance hierarchy
 * until a non-null result is returned,
 * which is the result of the switch.
 * <!-- end-user-doc -->
 * @see fr.supelec.tesl.lang.tesl.TeslPackage
 * @generated
 */
public class TeslSwitch<T> extends Switch<T>
{
  /**
   * The cached model package
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected static TeslPackage modelPackage;

  /**
   * Creates an instance of the switch.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public TeslSwitch()
  {
    if (modelPackage == null)
    {
      modelPackage = TeslPackage.eINSTANCE;
    }
  }

  /**
   * Checks whether this is a switch for the given package.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param ePackage the package in question.
   * @return whether this is a switch for the given package.
   * @generated
   */
  @Override
  protected boolean isSwitchFor(EPackage ePackage)
  {
    return ePackage == modelPackage;
  }

  /**
   * Calls <code>caseXXX</code> for each class of the model until one returns a non null result; it yields that result.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the first non-null result returned by a <code>caseXXX</code> call.
   * @generated
   */
  @Override
  protected T doSwitch(int classifierID, EObject theEObject)
  {
    switch (classifierID)
    {
      case TeslPackage.SPECIFICATION:
      {
        Specification specification = (Specification)theEObject;
        T result = caseSpecification(specification);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case TeslPackage.CLOCK:
      {
        Clock clock = (Clock)theEObject;
        T result = caseClock(clock);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case TeslPackage.CLOCK_QUALIFIER:
      {
        ClockQualifier clockQualifier = (ClockQualifier)theEObject;
        T result = caseClockQualifier(clockQualifier);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case TeslPackage.PERIODIC_QUALIFIER:
      {
        PeriodicQualifier periodicQualifier = (PeriodicQualifier)theEObject;
        T result = casePeriodicQualifier(periodicQualifier);
        if (result == null) result = caseClockQualifier(periodicQualifier);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case TeslPackage.SPORADIC_QUALIFIER:
      {
        SporadicQualifier sporadicQualifier = (SporadicQualifier)theEObject;
        T result = caseSporadicQualifier(sporadicQualifier);
        if (result == null) result = caseClockQualifier(sporadicQualifier);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case TeslPackage.RELATION:
      {
        Relation relation = (Relation)theEObject;
        T result = caseRelation(relation);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case TeslPackage.IMPLICATION_RELATION:
      {
        ImplicationRelation implicationRelation = (ImplicationRelation)theEObject;
        T result = caseImplicationRelation(implicationRelation);
        if (result == null) result = caseRelation(implicationRelation);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case TeslPackage.AWAIT_IMPLICATION:
      {
        AwaitImplication awaitImplication = (AwaitImplication)theEObject;
        T result = caseAwaitImplication(awaitImplication);
        if (result == null) result = caseRelation(awaitImplication);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case TeslPackage.IMPLICATION_QUALIFIER:
      {
        ImplicationQualifier implicationQualifier = (ImplicationQualifier)theEObject;
        T result = caseImplicationQualifier(implicationQualifier);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case TeslPackage.FILTERED_QUALIFIER:
      {
        FilteredQualifier filteredQualifier = (FilteredQualifier)theEObject;
        T result = caseFilteredQualifier(filteredQualifier);
        if (result == null) result = caseImplicationQualifier(filteredQualifier);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case TeslPackage.EVERY_QUALIFIER:
      {
        EveryQualifier everyQualifier = (EveryQualifier)theEObject;
        T result = caseEveryQualifier(everyQualifier);
        if (result == null) result = caseImplicationQualifier(everyQualifier);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case TeslPackage.DELAYED_QUALIFIER:
      {
        DelayedQualifier delayedQualifier = (DelayedQualifier)theEObject;
        T result = caseDelayedQualifier(delayedQualifier);
        if (result == null) result = caseImplicationQualifier(delayedQualifier);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case TeslPackage.SUSTAINED_QUALIFIER:
      {
        SustainedQualifier sustainedQualifier = (SustainedQualifier)theEObject;
        T result = caseSustainedQualifier(sustainedQualifier);
        if (result == null) result = caseImplicationQualifier(sustainedQualifier);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case TeslPackage.TIME_DELAYED_QUALIFIER:
      {
        TimeDelayedQualifier timeDelayedQualifier = (TimeDelayedQualifier)theEObject;
        T result = caseTimeDelayedQualifier(timeDelayedQualifier);
        if (result == null) result = caseImplicationQualifier(timeDelayedQualifier);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case TeslPackage.LET:
      {
        Let let = (Let)theEObject;
        T result = caseLet(let);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case TeslPackage.VALUE:
      {
        Value value = (Value)theEObject;
        T result = caseValue(value);
        if (result == null) result = caseExpression(value);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case TeslPackage.INTEGER_VALUE:
      {
        IntegerValue integerValue = (IntegerValue)theEObject;
        T result = caseIntegerValue(integerValue);
        if (result == null) result = caseValue(integerValue);
        if (result == null) result = caseExpression(integerValue);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case TeslPackage.DECIMAL_VALUE:
      {
        DecimalValue decimalValue = (DecimalValue)theEObject;
        T result = caseDecimalValue(decimalValue);
        if (result == null) result = caseValue(decimalValue);
        if (result == null) result = caseExpression(decimalValue);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case TeslPackage.FLOAT_VALUE:
      {
        FloatValue floatValue = (FloatValue)theEObject;
        T result = caseFloatValue(floatValue);
        if (result == null) result = caseValue(floatValue);
        if (result == null) result = caseExpression(floatValue);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case TeslPackage.RATIONAL_VALUE:
      {
        RationalValue rationalValue = (RationalValue)theEObject;
        T result = caseRationalValue(rationalValue);
        if (result == null) result = caseValue(rationalValue);
        if (result == null) result = caseExpression(rationalValue);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case TeslPackage.LET_VALUE:
      {
        LetValue letValue = (LetValue)theEObject;
        T result = caseLetValue(letValue);
        if (result == null) result = caseValue(letValue);
        if (result == null) result = caseExpression(letValue);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case TeslPackage.EXPRESSION:
      {
        Expression expression = (Expression)theEObject;
        T result = caseExpression(expression);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case TeslPackage.CAST:
      {
        Cast cast = (Cast)theEObject;
        T result = caseCast(cast);
        if (result == null) result = caseExpression(cast);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case TeslPackage.INT_CAST:
      {
        IntCast intCast = (IntCast)theEObject;
        T result = caseIntCast(intCast);
        if (result == null) result = caseCast(intCast);
        if (result == null) result = caseExpression(intCast);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case TeslPackage.FLOAT_CAST:
      {
        FloatCast floatCast = (FloatCast)theEObject;
        T result = caseFloatCast(floatCast);
        if (result == null) result = caseCast(floatCast);
        if (result == null) result = caseExpression(floatCast);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case TeslPackage.DECIMAL_CAST:
      {
        DecimalCast decimalCast = (DecimalCast)theEObject;
        T result = caseDecimalCast(decimalCast);
        if (result == null) result = caseCast(decimalCast);
        if (result == null) result = caseExpression(decimalCast);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case TeslPackage.RATIONAL_CAST:
      {
        RationalCast rationalCast = (RationalCast)theEObject;
        T result = caseRationalCast(rationalCast);
        if (result == null) result = caseCast(rationalCast);
        if (result == null) result = caseExpression(rationalCast);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case TeslPackage.WHEN_QUALIFIER:
      {
        WhenQualifier whenQualifier = (WhenQualifier)theEObject;
        T result = caseWhenQualifier(whenQualifier);
        if (result == null) result = caseImplicationQualifier(whenQualifier);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case TeslPackage.NEXT_QUALIFIER:
      {
        NextQualifier nextQualifier = (NextQualifier)theEObject;
        T result = caseNextQualifier(nextQualifier);
        if (result == null) result = caseImplicationQualifier(nextQualifier);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case TeslPackage.PATTERN:
      {
        Pattern pattern = (Pattern)theEObject;
        T result = casePattern(pattern);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case TeslPackage.TAG_RELATION:
      {
        TagRelation tagRelation = (TagRelation)theEObject;
        T result = caseTagRelation(tagRelation);
        if (result == null) result = caseRelation(tagRelation);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case TeslPackage.TAG_EXPR:
      {
        TagExpr tagExpr = (TagExpr)theEObject;
        T result = caseTagExpr(tagExpr);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case TeslPackage.PRAGMA:
      {
        Pragma pragma = (Pragma)theEObject;
        T result = casePragma(pragma);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case TeslPackage.STOP_PRAGMA:
      {
        StopPragma stopPragma = (StopPragma)theEObject;
        T result = caseStopPragma(stopPragma);
        if (result == null) result = casePragma(stopPragma);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case TeslPackage.TAGREF_PRAGMA:
      {
        TagrefPragma tagrefPragma = (TagrefPragma)theEObject;
        T result = caseTagrefPragma(tagrefPragma);
        if (result == null) result = casePragma(tagrefPragma);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case TeslPackage.TRACE_PRAGMA:
      {
        TracePragma tracePragma = (TracePragma)theEObject;
        T result = caseTracePragma(tracePragma);
        if (result == null) result = casePragma(tracePragma);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case TeslPackage.MAXSTEP_PRAGMA:
      {
        MaxstepPragma maxstepPragma = (MaxstepPragma)theEObject;
        T result = caseMaxstepPragma(maxstepPragma);
        if (result == null) result = casePragma(maxstepPragma);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case TeslPackage.OUTPUT_PRAGMA:
      {
        OutputPragma outputPragma = (OutputPragma)theEObject;
        T result = caseOutputPragma(outputPragma);
        if (result == null) result = casePragma(outputPragma);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case TeslPackage.CLOCK_ITEM:
      {
        ClockItem clockItem = (ClockItem)theEObject;
        T result = caseClockItem(clockItem);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case TeslPackage.DOUBLE_CALC_PRAGMA:
      {
        DoubleCalcPragma doubleCalcPragma = (DoubleCalcPragma)theEObject;
        T result = caseDoubleCalcPragma(doubleCalcPragma);
        if (result == null) result = casePragma(doubleCalcPragma);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case TeslPackage.DUMP_RESULT_PRAGMA:
      {
        DumpResultPragma dumpResultPragma = (DumpResultPragma)theEObject;
        T result = caseDumpResultPragma(dumpResultPragma);
        if (result == null) result = casePragma(dumpResultPragma);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case TeslPackage.BIN_OP:
      {
        BinOp binOp = (BinOp)theEObject;
        T result = caseBinOp(binOp);
        if (result == null) result = caseExpression(binOp);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      default: return defaultCase(theEObject);
    }
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Specification</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Specification</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseSpecification(Specification object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Clock</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Clock</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseClock(Clock object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Clock Qualifier</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Clock Qualifier</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseClockQualifier(ClockQualifier object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Periodic Qualifier</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Periodic Qualifier</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T casePeriodicQualifier(PeriodicQualifier object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Sporadic Qualifier</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Sporadic Qualifier</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseSporadicQualifier(SporadicQualifier object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Relation</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Relation</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseRelation(Relation object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Implication Relation</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Implication Relation</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseImplicationRelation(ImplicationRelation object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Await Implication</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Await Implication</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseAwaitImplication(AwaitImplication object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Implication Qualifier</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Implication Qualifier</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseImplicationQualifier(ImplicationQualifier object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Filtered Qualifier</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Filtered Qualifier</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseFilteredQualifier(FilteredQualifier object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Every Qualifier</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Every Qualifier</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseEveryQualifier(EveryQualifier object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Delayed Qualifier</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Delayed Qualifier</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseDelayedQualifier(DelayedQualifier object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Sustained Qualifier</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Sustained Qualifier</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseSustainedQualifier(SustainedQualifier object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Time Delayed Qualifier</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Time Delayed Qualifier</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseTimeDelayedQualifier(TimeDelayedQualifier object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Let</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Let</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseLet(Let object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Value</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Value</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseValue(Value object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Integer Value</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Integer Value</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseIntegerValue(IntegerValue object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Decimal Value</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Decimal Value</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseDecimalValue(DecimalValue object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Float Value</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Float Value</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseFloatValue(FloatValue object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Rational Value</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Rational Value</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseRationalValue(RationalValue object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Let Value</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Let Value</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseLetValue(LetValue object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Expression</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Expression</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseExpression(Expression object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Cast</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Cast</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseCast(Cast object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Int Cast</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Int Cast</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseIntCast(IntCast object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Float Cast</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Float Cast</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseFloatCast(FloatCast object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Decimal Cast</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Decimal Cast</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseDecimalCast(DecimalCast object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Rational Cast</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Rational Cast</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseRationalCast(RationalCast object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>When Qualifier</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>When Qualifier</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseWhenQualifier(WhenQualifier object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Next Qualifier</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Next Qualifier</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseNextQualifier(NextQualifier object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Pattern</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Pattern</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T casePattern(Pattern object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Tag Relation</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Tag Relation</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseTagRelation(TagRelation object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Tag Expr</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Tag Expr</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseTagExpr(TagExpr object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Pragma</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Pragma</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T casePragma(Pragma object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Stop Pragma</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Stop Pragma</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseStopPragma(StopPragma object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Tagref Pragma</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Tagref Pragma</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseTagrefPragma(TagrefPragma object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Trace Pragma</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Trace Pragma</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseTracePragma(TracePragma object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Maxstep Pragma</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Maxstep Pragma</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseMaxstepPragma(MaxstepPragma object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Output Pragma</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Output Pragma</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseOutputPragma(OutputPragma object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Clock Item</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Clock Item</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseClockItem(ClockItem object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Double Calc Pragma</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Double Calc Pragma</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseDoubleCalcPragma(DoubleCalcPragma object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Dump Result Pragma</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Dump Result Pragma</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseDumpResultPragma(DumpResultPragma object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Bin Op</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Bin Op</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseBinOp(BinOp object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>EObject</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch, but this is the last case anyway.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>EObject</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject)
   * @generated
   */
  @Override
  public T defaultCase(EObject object)
  {
    return null;
  }

} //TeslSwitch
