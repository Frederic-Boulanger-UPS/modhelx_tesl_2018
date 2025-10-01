/**
 */
package fr.supelec.tesl.lang.tesl;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see fr.supelec.tesl.lang.tesl.TeslPackage
 * @generated
 */
public interface TeslFactory extends EFactory
{
  /**
   * The singleton instance of the factory.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  TeslFactory eINSTANCE = fr.supelec.tesl.lang.tesl.impl.TeslFactoryImpl.init();

  /**
   * Returns a new object of class '<em>Specification</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Specification</em>'.
   * @generated
   */
  Specification createSpecification();

  /**
   * Returns a new object of class '<em>Clock</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Clock</em>'.
   * @generated
   */
  Clock createClock();

  /**
   * Returns a new object of class '<em>Clock Qualifier</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Clock Qualifier</em>'.
   * @generated
   */
  ClockQualifier createClockQualifier();

  /**
   * Returns a new object of class '<em>Periodic Qualifier</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Periodic Qualifier</em>'.
   * @generated
   */
  PeriodicQualifier createPeriodicQualifier();

  /**
   * Returns a new object of class '<em>Sporadic Qualifier</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Sporadic Qualifier</em>'.
   * @generated
   */
  SporadicQualifier createSporadicQualifier();

  /**
   * Returns a new object of class '<em>Relation</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Relation</em>'.
   * @generated
   */
  Relation createRelation();

  /**
   * Returns a new object of class '<em>Implication Relation</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Implication Relation</em>'.
   * @generated
   */
  ImplicationRelation createImplicationRelation();

  /**
   * Returns a new object of class '<em>Await Implication</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Await Implication</em>'.
   * @generated
   */
  AwaitImplication createAwaitImplication();

  /**
   * Returns a new object of class '<em>Implication Qualifier</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Implication Qualifier</em>'.
   * @generated
   */
  ImplicationQualifier createImplicationQualifier();

  /**
   * Returns a new object of class '<em>Filtered Qualifier</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Filtered Qualifier</em>'.
   * @generated
   */
  FilteredQualifier createFilteredQualifier();

  /**
   * Returns a new object of class '<em>Every Qualifier</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Every Qualifier</em>'.
   * @generated
   */
  EveryQualifier createEveryQualifier();

  /**
   * Returns a new object of class '<em>Delayed Qualifier</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Delayed Qualifier</em>'.
   * @generated
   */
  DelayedQualifier createDelayedQualifier();

  /**
   * Returns a new object of class '<em>Sustained Qualifier</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Sustained Qualifier</em>'.
   * @generated
   */
  SustainedQualifier createSustainedQualifier();

  /**
   * Returns a new object of class '<em>Time Delayed Qualifier</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Time Delayed Qualifier</em>'.
   * @generated
   */
  TimeDelayedQualifier createTimeDelayedQualifier();

  /**
   * Returns a new object of class '<em>Let</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Let</em>'.
   * @generated
   */
  Let createLet();

  /**
   * Returns a new object of class '<em>Value</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Value</em>'.
   * @generated
   */
  Value createValue();

  /**
   * Returns a new object of class '<em>Integer Value</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Integer Value</em>'.
   * @generated
   */
  IntegerValue createIntegerValue();

  /**
   * Returns a new object of class '<em>Decimal Value</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Decimal Value</em>'.
   * @generated
   */
  DecimalValue createDecimalValue();

  /**
   * Returns a new object of class '<em>Float Value</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Float Value</em>'.
   * @generated
   */
  FloatValue createFloatValue();

  /**
   * Returns a new object of class '<em>Rational Value</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Rational Value</em>'.
   * @generated
   */
  RationalValue createRationalValue();

  /**
   * Returns a new object of class '<em>Let Value</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Let Value</em>'.
   * @generated
   */
  LetValue createLetValue();

  /**
   * Returns a new object of class '<em>Expression</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Expression</em>'.
   * @generated
   */
  Expression createExpression();

  /**
   * Returns a new object of class '<em>Cast</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Cast</em>'.
   * @generated
   */
  Cast createCast();

  /**
   * Returns a new object of class '<em>Int Cast</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Int Cast</em>'.
   * @generated
   */
  IntCast createIntCast();

  /**
   * Returns a new object of class '<em>Float Cast</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Float Cast</em>'.
   * @generated
   */
  FloatCast createFloatCast();

  /**
   * Returns a new object of class '<em>Decimal Cast</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Decimal Cast</em>'.
   * @generated
   */
  DecimalCast createDecimalCast();

  /**
   * Returns a new object of class '<em>Rational Cast</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Rational Cast</em>'.
   * @generated
   */
  RationalCast createRationalCast();

  /**
   * Returns a new object of class '<em>When Qualifier</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>When Qualifier</em>'.
   * @generated
   */
  WhenQualifier createWhenQualifier();

  /**
   * Returns a new object of class '<em>Next Qualifier</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Next Qualifier</em>'.
   * @generated
   */
  NextQualifier createNextQualifier();

  /**
   * Returns a new object of class '<em>Pattern</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Pattern</em>'.
   * @generated
   */
  Pattern createPattern();

  /**
   * Returns a new object of class '<em>Tag Relation</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Tag Relation</em>'.
   * @generated
   */
  TagRelation createTagRelation();

  /**
   * Returns a new object of class '<em>Tag Expr</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Tag Expr</em>'.
   * @generated
   */
  TagExpr createTagExpr();

  /**
   * Returns a new object of class '<em>Pragma</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Pragma</em>'.
   * @generated
   */
  Pragma createPragma();

  /**
   * Returns a new object of class '<em>Stop Pragma</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Stop Pragma</em>'.
   * @generated
   */
  StopPragma createStopPragma();

  /**
   * Returns a new object of class '<em>Tagref Pragma</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Tagref Pragma</em>'.
   * @generated
   */
  TagrefPragma createTagrefPragma();

  /**
   * Returns a new object of class '<em>Trace Pragma</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Trace Pragma</em>'.
   * @generated
   */
  TracePragma createTracePragma();

  /**
   * Returns a new object of class '<em>Maxstep Pragma</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Maxstep Pragma</em>'.
   * @generated
   */
  MaxstepPragma createMaxstepPragma();

  /**
   * Returns a new object of class '<em>Output Pragma</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Output Pragma</em>'.
   * @generated
   */
  OutputPragma createOutputPragma();

  /**
   * Returns a new object of class '<em>Clock Item</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Clock Item</em>'.
   * @generated
   */
  ClockItem createClockItem();

  /**
   * Returns a new object of class '<em>Double Calc Pragma</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Double Calc Pragma</em>'.
   * @generated
   */
  DoubleCalcPragma createDoubleCalcPragma();

  /**
   * Returns a new object of class '<em>Dump Result Pragma</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Dump Result Pragma</em>'.
   * @generated
   */
  DumpResultPragma createDumpResultPragma();

  /**
   * Returns a new object of class '<em>Bin Op</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Bin Op</em>'.
   * @generated
   */
  BinOp createBinOp();

  /**
   * Returns the package supported by this factory.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the package supported by this factory.
   * @generated
   */
  TeslPackage getTeslPackage();

} //TeslFactory
