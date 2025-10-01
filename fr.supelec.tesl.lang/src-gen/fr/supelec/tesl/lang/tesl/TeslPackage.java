/**
 */
package fr.supelec.tesl.lang.tesl;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

/**
 * <!-- begin-user-doc -->
 * The <b>Package</b> for the model.
 * It contains accessors for the meta objects to represent
 * <ul>
 *   <li>each class,</li>
 *   <li>each feature of each class,</li>
 *   <li>each enum,</li>
 *   <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * @see fr.supelec.tesl.lang.tesl.TeslFactory
 * @model kind="package"
 * @generated
 */
public interface TeslPackage extends EPackage
{
  /**
   * The package name.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  String eNAME = "tesl";

  /**
   * The package namespace URI.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  String eNS_URI = "http://www.supelec.fr/tesl/lang/TESL";

  /**
   * The package namespace name.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  String eNS_PREFIX = "tesl";

  /**
   * The singleton instance of the package.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  TeslPackage eINSTANCE = fr.supelec.tesl.lang.tesl.impl.TeslPackageImpl.init();

  /**
   * The meta object id for the '{@link fr.supelec.tesl.lang.tesl.impl.SpecificationImpl <em>Specification</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see fr.supelec.tesl.lang.tesl.impl.SpecificationImpl
   * @see fr.supelec.tesl.lang.tesl.impl.TeslPackageImpl#getSpecification()
   * @generated
   */
  int SPECIFICATION = 0;

  /**
   * The feature id for the '<em><b>Decl</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SPECIFICATION__DECL = 0;

  /**
   * The feature id for the '<em><b>Rel</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SPECIFICATION__REL = 1;

  /**
   * The feature id for the '<em><b>Let</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SPECIFICATION__LET = 2;

  /**
   * The feature id for the '<em><b>Pragmas</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SPECIFICATION__PRAGMAS = 3;

  /**
   * The number of structural features of the '<em>Specification</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SPECIFICATION_FEATURE_COUNT = 4;

  /**
   * The meta object id for the '{@link fr.supelec.tesl.lang.tesl.impl.ClockImpl <em>Clock</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see fr.supelec.tesl.lang.tesl.impl.ClockImpl
   * @see fr.supelec.tesl.lang.tesl.impl.TeslPackageImpl#getClock()
   * @generated
   */
  int CLOCK = 1;

  /**
   * The feature id for the '<em><b>Nongreedy</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CLOCK__NONGREEDY = 0;

  /**
   * The feature id for the '<em><b>Type</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CLOCK__TYPE = 1;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CLOCK__NAME = 2;

  /**
   * The feature id for the '<em><b>Qual</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CLOCK__QUAL = 3;

  /**
   * The number of structural features of the '<em>Clock</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CLOCK_FEATURE_COUNT = 4;

  /**
   * The meta object id for the '{@link fr.supelec.tesl.lang.tesl.impl.ClockQualifierImpl <em>Clock Qualifier</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see fr.supelec.tesl.lang.tesl.impl.ClockQualifierImpl
   * @see fr.supelec.tesl.lang.tesl.impl.TeslPackageImpl#getClockQualifier()
   * @generated
   */
  int CLOCK_QUALIFIER = 2;

  /**
   * The number of structural features of the '<em>Clock Qualifier</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CLOCK_QUALIFIER_FEATURE_COUNT = 0;

  /**
   * The meta object id for the '{@link fr.supelec.tesl.lang.tesl.impl.PeriodicQualifierImpl <em>Periodic Qualifier</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see fr.supelec.tesl.lang.tesl.impl.PeriodicQualifierImpl
   * @see fr.supelec.tesl.lang.tesl.impl.TeslPackageImpl#getPeriodicQualifier()
   * @generated
   */
  int PERIODIC_QUALIFIER = 3;

  /**
   * The feature id for the '<em><b>Period</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PERIODIC_QUALIFIER__PERIOD = CLOCK_QUALIFIER_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Offset</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PERIODIC_QUALIFIER__OFFSET = CLOCK_QUALIFIER_FEATURE_COUNT + 1;

  /**
   * The number of structural features of the '<em>Periodic Qualifier</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PERIODIC_QUALIFIER_FEATURE_COUNT = CLOCK_QUALIFIER_FEATURE_COUNT + 2;

  /**
   * The meta object id for the '{@link fr.supelec.tesl.lang.tesl.impl.SporadicQualifierImpl <em>Sporadic Qualifier</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see fr.supelec.tesl.lang.tesl.impl.SporadicQualifierImpl
   * @see fr.supelec.tesl.lang.tesl.impl.TeslPackageImpl#getSporadicQualifier()
   * @generated
   */
  int SPORADIC_QUALIFIER = 4;

  /**
   * The feature id for the '<em><b>Instants</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SPORADIC_QUALIFIER__INSTANTS = CLOCK_QUALIFIER_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>Sporadic Qualifier</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SPORADIC_QUALIFIER_FEATURE_COUNT = CLOCK_QUALIFIER_FEATURE_COUNT + 1;

  /**
   * The meta object id for the '{@link fr.supelec.tesl.lang.tesl.impl.RelationImpl <em>Relation</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see fr.supelec.tesl.lang.tesl.impl.RelationImpl
   * @see fr.supelec.tesl.lang.tesl.impl.TeslPackageImpl#getRelation()
   * @generated
   */
  int RELATION = 5;

  /**
   * The number of structural features of the '<em>Relation</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int RELATION_FEATURE_COUNT = 0;

  /**
   * The meta object id for the '{@link fr.supelec.tesl.lang.tesl.impl.ImplicationRelationImpl <em>Implication Relation</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see fr.supelec.tesl.lang.tesl.impl.ImplicationRelationImpl
   * @see fr.supelec.tesl.lang.tesl.impl.TeslPackageImpl#getImplicationRelation()
   * @generated
   */
  int IMPLICATION_RELATION = 6;

  /**
   * The feature id for the '<em><b>Source</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int IMPLICATION_RELATION__SOURCE = RELATION_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Qual</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int IMPLICATION_RELATION__QUAL = RELATION_FEATURE_COUNT + 1;

  /**
   * The feature id for the '<em><b>Target</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int IMPLICATION_RELATION__TARGET = RELATION_FEATURE_COUNT + 2;

  /**
   * The number of structural features of the '<em>Implication Relation</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int IMPLICATION_RELATION_FEATURE_COUNT = RELATION_FEATURE_COUNT + 3;

  /**
   * The meta object id for the '{@link fr.supelec.tesl.lang.tesl.impl.AwaitImplicationImpl <em>Await Implication</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see fr.supelec.tesl.lang.tesl.impl.AwaitImplicationImpl
   * @see fr.supelec.tesl.lang.tesl.impl.TeslPackageImpl#getAwaitImplication()
   * @generated
   */
  int AWAIT_IMPLICATION = 7;

  /**
   * The feature id for the '<em><b>Masters</b></em>' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int AWAIT_IMPLICATION__MASTERS = RELATION_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Weak</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int AWAIT_IMPLICATION__WEAK = RELATION_FEATURE_COUNT + 1;

  /**
   * The feature id for the '<em><b>Strong</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int AWAIT_IMPLICATION__STRONG = RELATION_FEATURE_COUNT + 2;

  /**
   * The feature id for the '<em><b>Reset</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int AWAIT_IMPLICATION__RESET = RELATION_FEATURE_COUNT + 3;

  /**
   * The feature id for the '<em><b>Target</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int AWAIT_IMPLICATION__TARGET = RELATION_FEATURE_COUNT + 4;

  /**
   * The number of structural features of the '<em>Await Implication</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int AWAIT_IMPLICATION_FEATURE_COUNT = RELATION_FEATURE_COUNT + 5;

  /**
   * The meta object id for the '{@link fr.supelec.tesl.lang.tesl.impl.ImplicationQualifierImpl <em>Implication Qualifier</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see fr.supelec.tesl.lang.tesl.impl.ImplicationQualifierImpl
   * @see fr.supelec.tesl.lang.tesl.impl.TeslPackageImpl#getImplicationQualifier()
   * @generated
   */
  int IMPLICATION_QUALIFIER = 8;

  /**
   * The number of structural features of the '<em>Implication Qualifier</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int IMPLICATION_QUALIFIER_FEATURE_COUNT = 0;

  /**
   * The meta object id for the '{@link fr.supelec.tesl.lang.tesl.impl.FilteredQualifierImpl <em>Filtered Qualifier</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see fr.supelec.tesl.lang.tesl.impl.FilteredQualifierImpl
   * @see fr.supelec.tesl.lang.tesl.impl.TeslPackageImpl#getFilteredQualifier()
   * @generated
   */
  int FILTERED_QUALIFIER = 9;

  /**
   * The feature id for the '<em><b>Pattern</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int FILTERED_QUALIFIER__PATTERN = IMPLICATION_QUALIFIER_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>Filtered Qualifier</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int FILTERED_QUALIFIER_FEATURE_COUNT = IMPLICATION_QUALIFIER_FEATURE_COUNT + 1;

  /**
   * The meta object id for the '{@link fr.supelec.tesl.lang.tesl.impl.EveryQualifierImpl <em>Every Qualifier</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see fr.supelec.tesl.lang.tesl.impl.EveryQualifierImpl
   * @see fr.supelec.tesl.lang.tesl.impl.TeslPackageImpl#getEveryQualifier()
   * @generated
   */
  int EVERY_QUALIFIER = 10;

  /**
   * The feature id for the '<em><b>Period</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int EVERY_QUALIFIER__PERIOD = IMPLICATION_QUALIFIER_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Off</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int EVERY_QUALIFIER__OFF = IMPLICATION_QUALIFIER_FEATURE_COUNT + 1;

  /**
   * The feature id for the '<em><b>Offset</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int EVERY_QUALIFIER__OFFSET = IMPLICATION_QUALIFIER_FEATURE_COUNT + 2;

  /**
   * The number of structural features of the '<em>Every Qualifier</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int EVERY_QUALIFIER_FEATURE_COUNT = IMPLICATION_QUALIFIER_FEATURE_COUNT + 3;

  /**
   * The meta object id for the '{@link fr.supelec.tesl.lang.tesl.impl.DelayedQualifierImpl <em>Delayed Qualifier</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see fr.supelec.tesl.lang.tesl.impl.DelayedQualifierImpl
   * @see fr.supelec.tesl.lang.tesl.impl.TeslPackageImpl#getDelayedQualifier()
   * @generated
   */
  int DELAYED_QUALIFIER = 11;

  /**
   * The feature id for the '<em><b>Immediately</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int DELAYED_QUALIFIER__IMMEDIATELY = IMPLICATION_QUALIFIER_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Count</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int DELAYED_QUALIFIER__COUNT = IMPLICATION_QUALIFIER_FEATURE_COUNT + 1;

  /**
   * The feature id for the '<em><b>Reset</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int DELAYED_QUALIFIER__RESET = IMPLICATION_QUALIFIER_FEATURE_COUNT + 2;

  /**
   * The feature id for the '<em><b>Clock</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int DELAYED_QUALIFIER__CLOCK = IMPLICATION_QUALIFIER_FEATURE_COUNT + 3;

  /**
   * The number of structural features of the '<em>Delayed Qualifier</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int DELAYED_QUALIFIER_FEATURE_COUNT = IMPLICATION_QUALIFIER_FEATURE_COUNT + 4;

  /**
   * The meta object id for the '{@link fr.supelec.tesl.lang.tesl.impl.SustainedQualifierImpl <em>Sustained Qualifier</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see fr.supelec.tesl.lang.tesl.impl.SustainedQualifierImpl
   * @see fr.supelec.tesl.lang.tesl.impl.TeslPackageImpl#getSustainedQualifier()
   * @generated
   */
  int SUSTAINED_QUALIFIER = 12;

  /**
   * The feature id for the '<em><b>Immediately</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SUSTAINED_QUALIFIER__IMMEDIATELY = IMPLICATION_QUALIFIER_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Start Clock</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SUSTAINED_QUALIFIER__START_CLOCK = IMPLICATION_QUALIFIER_FEATURE_COUNT + 1;

  /**
   * The feature id for the '<em><b>End Clock</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SUSTAINED_QUALIFIER__END_CLOCK = IMPLICATION_QUALIFIER_FEATURE_COUNT + 2;

  /**
   * The feature id for the '<em><b>Weakly</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SUSTAINED_QUALIFIER__WEAKLY = IMPLICATION_QUALIFIER_FEATURE_COUNT + 3;

  /**
   * The number of structural features of the '<em>Sustained Qualifier</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SUSTAINED_QUALIFIER_FEATURE_COUNT = IMPLICATION_QUALIFIER_FEATURE_COUNT + 4;

  /**
   * The meta object id for the '{@link fr.supelec.tesl.lang.tesl.impl.TimeDelayedQualifierImpl <em>Time Delayed Qualifier</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see fr.supelec.tesl.lang.tesl.impl.TimeDelayedQualifierImpl
   * @see fr.supelec.tesl.lang.tesl.impl.TeslPackageImpl#getTimeDelayedQualifier()
   * @generated
   */
  int TIME_DELAYED_QUALIFIER = 13;

  /**
   * The feature id for the '<em><b>Delay</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TIME_DELAYED_QUALIFIER__DELAY = IMPLICATION_QUALIFIER_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Clock</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TIME_DELAYED_QUALIFIER__CLOCK = IMPLICATION_QUALIFIER_FEATURE_COUNT + 1;

  /**
   * The feature id for the '<em><b>Reset</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TIME_DELAYED_QUALIFIER__RESET = IMPLICATION_QUALIFIER_FEATURE_COUNT + 2;

  /**
   * The feature id for the '<em><b>Imm Reset</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TIME_DELAYED_QUALIFIER__IMM_RESET = IMPLICATION_QUALIFIER_FEATURE_COUNT + 3;

  /**
   * The feature id for the '<em><b>Strong Reset</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TIME_DELAYED_QUALIFIER__STRONG_RESET = IMPLICATION_QUALIFIER_FEATURE_COUNT + 4;

  /**
   * The feature id for the '<em><b>Reset Clock</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TIME_DELAYED_QUALIFIER__RESET_CLOCK = IMPLICATION_QUALIFIER_FEATURE_COUNT + 5;

  /**
   * The number of structural features of the '<em>Time Delayed Qualifier</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TIME_DELAYED_QUALIFIER_FEATURE_COUNT = IMPLICATION_QUALIFIER_FEATURE_COUNT + 6;

  /**
   * The meta object id for the '{@link fr.supelec.tesl.lang.tesl.impl.LetImpl <em>Let</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see fr.supelec.tesl.lang.tesl.impl.LetImpl
   * @see fr.supelec.tesl.lang.tesl.impl.TeslPackageImpl#getLet()
   * @generated
   */
  int LET = 14;

  /**
   * The feature id for the '<em><b>Type</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int LET__TYPE = 0;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int LET__NAME = 1;

  /**
   * The feature id for the '<em><b>Value</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int LET__VALUE = 2;

  /**
   * The number of structural features of the '<em>Let</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int LET_FEATURE_COUNT = 3;

  /**
   * The meta object id for the '{@link fr.supelec.tesl.lang.tesl.impl.ExpressionImpl <em>Expression</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see fr.supelec.tesl.lang.tesl.impl.ExpressionImpl
   * @see fr.supelec.tesl.lang.tesl.impl.TeslPackageImpl#getExpression()
   * @generated
   */
  int EXPRESSION = 21;

  /**
   * The number of structural features of the '<em>Expression</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int EXPRESSION_FEATURE_COUNT = 0;

  /**
   * The meta object id for the '{@link fr.supelec.tesl.lang.tesl.impl.ValueImpl <em>Value</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see fr.supelec.tesl.lang.tesl.impl.ValueImpl
   * @see fr.supelec.tesl.lang.tesl.impl.TeslPackageImpl#getValue()
   * @generated
   */
  int VALUE = 15;

  /**
   * The number of structural features of the '<em>Value</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int VALUE_FEATURE_COUNT = EXPRESSION_FEATURE_COUNT + 0;

  /**
   * The meta object id for the '{@link fr.supelec.tesl.lang.tesl.impl.IntegerValueImpl <em>Integer Value</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see fr.supelec.tesl.lang.tesl.impl.IntegerValueImpl
   * @see fr.supelec.tesl.lang.tesl.impl.TeslPackageImpl#getIntegerValue()
   * @generated
   */
  int INTEGER_VALUE = 16;

  /**
   * The feature id for the '<em><b>Sign</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int INTEGER_VALUE__SIGN = VALUE_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Value</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int INTEGER_VALUE__VALUE = VALUE_FEATURE_COUNT + 1;

  /**
   * The number of structural features of the '<em>Integer Value</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int INTEGER_VALUE_FEATURE_COUNT = VALUE_FEATURE_COUNT + 2;

  /**
   * The meta object id for the '{@link fr.supelec.tesl.lang.tesl.impl.DecimalValueImpl <em>Decimal Value</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see fr.supelec.tesl.lang.tesl.impl.DecimalValueImpl
   * @see fr.supelec.tesl.lang.tesl.impl.TeslPackageImpl#getDecimalValue()
   * @generated
   */
  int DECIMAL_VALUE = 17;

  /**
   * The feature id for the '<em><b>Sign</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int DECIMAL_VALUE__SIGN = VALUE_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Value</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int DECIMAL_VALUE__VALUE = VALUE_FEATURE_COUNT + 1;

  /**
   * The number of structural features of the '<em>Decimal Value</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int DECIMAL_VALUE_FEATURE_COUNT = VALUE_FEATURE_COUNT + 2;

  /**
   * The meta object id for the '{@link fr.supelec.tesl.lang.tesl.impl.FloatValueImpl <em>Float Value</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see fr.supelec.tesl.lang.tesl.impl.FloatValueImpl
   * @see fr.supelec.tesl.lang.tesl.impl.TeslPackageImpl#getFloatValue()
   * @generated
   */
  int FLOAT_VALUE = 18;

  /**
   * The feature id for the '<em><b>Sign</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int FLOAT_VALUE__SIGN = VALUE_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Value</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int FLOAT_VALUE__VALUE = VALUE_FEATURE_COUNT + 1;

  /**
   * The number of structural features of the '<em>Float Value</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int FLOAT_VALUE_FEATURE_COUNT = VALUE_FEATURE_COUNT + 2;

  /**
   * The meta object id for the '{@link fr.supelec.tesl.lang.tesl.impl.RationalValueImpl <em>Rational Value</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see fr.supelec.tesl.lang.tesl.impl.RationalValueImpl
   * @see fr.supelec.tesl.lang.tesl.impl.TeslPackageImpl#getRationalValue()
   * @generated
   */
  int RATIONAL_VALUE = 19;

  /**
   * The feature id for the '<em><b>Sign</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int RATIONAL_VALUE__SIGN = VALUE_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Value</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int RATIONAL_VALUE__VALUE = VALUE_FEATURE_COUNT + 1;

  /**
   * The number of structural features of the '<em>Rational Value</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int RATIONAL_VALUE_FEATURE_COUNT = VALUE_FEATURE_COUNT + 2;

  /**
   * The meta object id for the '{@link fr.supelec.tesl.lang.tesl.impl.LetValueImpl <em>Let Value</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see fr.supelec.tesl.lang.tesl.impl.LetValueImpl
   * @see fr.supelec.tesl.lang.tesl.impl.TeslPackageImpl#getLetValue()
   * @generated
   */
  int LET_VALUE = 20;

  /**
   * The feature id for the '<em><b>Ref</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int LET_VALUE__REF = VALUE_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>Let Value</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int LET_VALUE_FEATURE_COUNT = VALUE_FEATURE_COUNT + 1;

  /**
   * The meta object id for the '{@link fr.supelec.tesl.lang.tesl.impl.CastImpl <em>Cast</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see fr.supelec.tesl.lang.tesl.impl.CastImpl
   * @see fr.supelec.tesl.lang.tesl.impl.TeslPackageImpl#getCast()
   * @generated
   */
  int CAST = 22;

  /**
   * The feature id for the '<em><b>Expr</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CAST__EXPR = EXPRESSION_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>Cast</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CAST_FEATURE_COUNT = EXPRESSION_FEATURE_COUNT + 1;

  /**
   * The meta object id for the '{@link fr.supelec.tesl.lang.tesl.impl.IntCastImpl <em>Int Cast</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see fr.supelec.tesl.lang.tesl.impl.IntCastImpl
   * @see fr.supelec.tesl.lang.tesl.impl.TeslPackageImpl#getIntCast()
   * @generated
   */
  int INT_CAST = 23;

  /**
   * The feature id for the '<em><b>Expr</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int INT_CAST__EXPR = CAST__EXPR;

  /**
   * The number of structural features of the '<em>Int Cast</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int INT_CAST_FEATURE_COUNT = CAST_FEATURE_COUNT + 0;

  /**
   * The meta object id for the '{@link fr.supelec.tesl.lang.tesl.impl.FloatCastImpl <em>Float Cast</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see fr.supelec.tesl.lang.tesl.impl.FloatCastImpl
   * @see fr.supelec.tesl.lang.tesl.impl.TeslPackageImpl#getFloatCast()
   * @generated
   */
  int FLOAT_CAST = 24;

  /**
   * The feature id for the '<em><b>Expr</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int FLOAT_CAST__EXPR = CAST__EXPR;

  /**
   * The number of structural features of the '<em>Float Cast</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int FLOAT_CAST_FEATURE_COUNT = CAST_FEATURE_COUNT + 0;

  /**
   * The meta object id for the '{@link fr.supelec.tesl.lang.tesl.impl.DecimalCastImpl <em>Decimal Cast</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see fr.supelec.tesl.lang.tesl.impl.DecimalCastImpl
   * @see fr.supelec.tesl.lang.tesl.impl.TeslPackageImpl#getDecimalCast()
   * @generated
   */
  int DECIMAL_CAST = 25;

  /**
   * The feature id for the '<em><b>Expr</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int DECIMAL_CAST__EXPR = CAST__EXPR;

  /**
   * The number of structural features of the '<em>Decimal Cast</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int DECIMAL_CAST_FEATURE_COUNT = CAST_FEATURE_COUNT + 0;

  /**
   * The meta object id for the '{@link fr.supelec.tesl.lang.tesl.impl.RationalCastImpl <em>Rational Cast</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see fr.supelec.tesl.lang.tesl.impl.RationalCastImpl
   * @see fr.supelec.tesl.lang.tesl.impl.TeslPackageImpl#getRationalCast()
   * @generated
   */
  int RATIONAL_CAST = 26;

  /**
   * The feature id for the '<em><b>Expr</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int RATIONAL_CAST__EXPR = CAST__EXPR;

  /**
   * The number of structural features of the '<em>Rational Cast</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int RATIONAL_CAST_FEATURE_COUNT = CAST_FEATURE_COUNT + 0;

  /**
   * The meta object id for the '{@link fr.supelec.tesl.lang.tesl.impl.WhenQualifierImpl <em>When Qualifier</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see fr.supelec.tesl.lang.tesl.impl.WhenQualifierImpl
   * @see fr.supelec.tesl.lang.tesl.impl.TeslPackageImpl#getWhenQualifier()
   * @generated
   */
  int WHEN_QUALIFIER = 27;

  /**
   * The feature id for the '<em><b>Not</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int WHEN_QUALIFIER__NOT = IMPLICATION_QUALIFIER_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Clock</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int WHEN_QUALIFIER__CLOCK = IMPLICATION_QUALIFIER_FEATURE_COUNT + 1;

  /**
   * The number of structural features of the '<em>When Qualifier</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int WHEN_QUALIFIER_FEATURE_COUNT = IMPLICATION_QUALIFIER_FEATURE_COUNT + 2;

  /**
   * The meta object id for the '{@link fr.supelec.tesl.lang.tesl.impl.NextQualifierImpl <em>Next Qualifier</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see fr.supelec.tesl.lang.tesl.impl.NextQualifierImpl
   * @see fr.supelec.tesl.lang.tesl.impl.TeslPackageImpl#getNextQualifier()
   * @generated
   */
  int NEXT_QUALIFIER = 28;

  /**
   * The feature id for the '<em><b>Strict</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int NEXT_QUALIFIER__STRICT = IMPLICATION_QUALIFIER_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Clock</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int NEXT_QUALIFIER__CLOCK = IMPLICATION_QUALIFIER_FEATURE_COUNT + 1;

  /**
   * The number of structural features of the '<em>Next Qualifier</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int NEXT_QUALIFIER_FEATURE_COUNT = IMPLICATION_QUALIFIER_FEATURE_COUNT + 2;

  /**
   * The meta object id for the '{@link fr.supelec.tesl.lang.tesl.impl.PatternImpl <em>Pattern</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see fr.supelec.tesl.lang.tesl.impl.PatternImpl
   * @see fr.supelec.tesl.lang.tesl.impl.TeslPackageImpl#getPattern()
   * @generated
   */
  int PATTERN = 29;

  /**
   * The feature id for the '<em><b>Skip</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PATTERN__SKIP = 0;

  /**
   * The feature id for the '<em><b>Keep</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PATTERN__KEEP = 1;

  /**
   * The feature id for the '<em><b>Rep</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PATTERN__REP = 2;

  /**
   * The feature id for the '<em><b>Repskip</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PATTERN__REPSKIP = 3;

  /**
   * The feature id for the '<em><b>Repkeep</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PATTERN__REPKEEP = 4;

  /**
   * The number of structural features of the '<em>Pattern</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PATTERN_FEATURE_COUNT = 5;

  /**
   * The meta object id for the '{@link fr.supelec.tesl.lang.tesl.impl.TagRelationImpl <em>Tag Relation</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see fr.supelec.tesl.lang.tesl.impl.TagRelationImpl
   * @see fr.supelec.tesl.lang.tesl.impl.TeslPackageImpl#getTagRelation()
   * @generated
   */
  int TAG_RELATION = 30;

  /**
   * The feature id for the '<em><b>Expr</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TAG_RELATION__EXPR = RELATION_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>Tag Relation</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TAG_RELATION_FEATURE_COUNT = RELATION_FEATURE_COUNT + 1;

  /**
   * The meta object id for the '{@link fr.supelec.tesl.lang.tesl.impl.TagExprImpl <em>Tag Expr</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see fr.supelec.tesl.lang.tesl.impl.TagExprImpl
   * @see fr.supelec.tesl.lang.tesl.impl.TeslPackageImpl#getTagExpr()
   * @generated
   */
  int TAG_EXPR = 31;

  /**
   * The feature id for the '<em><b>Clock Y</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TAG_EXPR__CLOCK_Y = 0;

  /**
   * The feature id for the '<em><b>Value A</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TAG_EXPR__VALUE_A = 1;

  /**
   * The feature id for the '<em><b>Clock X</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TAG_EXPR__CLOCK_X = 2;

  /**
   * The feature id for the '<em><b>Value N</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TAG_EXPR__VALUE_N = 3;

  /**
   * The feature id for the '<em><b>Value B</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TAG_EXPR__VALUE_B = 4;

  /**
   * The number of structural features of the '<em>Tag Expr</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TAG_EXPR_FEATURE_COUNT = 5;

  /**
   * The meta object id for the '{@link fr.supelec.tesl.lang.tesl.impl.PragmaImpl <em>Pragma</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see fr.supelec.tesl.lang.tesl.impl.PragmaImpl
   * @see fr.supelec.tesl.lang.tesl.impl.TeslPackageImpl#getPragma()
   * @generated
   */
  int PRAGMA = 32;

  /**
   * The number of structural features of the '<em>Pragma</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PRAGMA_FEATURE_COUNT = 0;

  /**
   * The meta object id for the '{@link fr.supelec.tesl.lang.tesl.impl.StopPragmaImpl <em>Stop Pragma</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see fr.supelec.tesl.lang.tesl.impl.StopPragmaImpl
   * @see fr.supelec.tesl.lang.tesl.impl.TeslPackageImpl#getStopPragma()
   * @generated
   */
  int STOP_PRAGMA = 33;

  /**
   * The feature id for the '<em><b>Clock</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int STOP_PRAGMA__CLOCK = PRAGMA_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>Stop Pragma</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int STOP_PRAGMA_FEATURE_COUNT = PRAGMA_FEATURE_COUNT + 1;

  /**
   * The meta object id for the '{@link fr.supelec.tesl.lang.tesl.impl.TagrefPragmaImpl <em>Tagref Pragma</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see fr.supelec.tesl.lang.tesl.impl.TagrefPragmaImpl
   * @see fr.supelec.tesl.lang.tesl.impl.TeslPackageImpl#getTagrefPragma()
   * @generated
   */
  int TAGREF_PRAGMA = 34;

  /**
   * The feature id for the '<em><b>Clock</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TAGREF_PRAGMA__CLOCK = PRAGMA_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>Tagref Pragma</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TAGREF_PRAGMA_FEATURE_COUNT = PRAGMA_FEATURE_COUNT + 1;

  /**
   * The meta object id for the '{@link fr.supelec.tesl.lang.tesl.impl.TracePragmaImpl <em>Trace Pragma</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see fr.supelec.tesl.lang.tesl.impl.TracePragmaImpl
   * @see fr.supelec.tesl.lang.tesl.impl.TeslPackageImpl#getTracePragma()
   * @generated
   */
  int TRACE_PRAGMA = 35;

  /**
   * The feature id for the '<em><b>Kinds</b></em>' attribute list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TRACE_PRAGMA__KINDS = PRAGMA_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>Trace Pragma</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TRACE_PRAGMA_FEATURE_COUNT = PRAGMA_FEATURE_COUNT + 1;

  /**
   * The meta object id for the '{@link fr.supelec.tesl.lang.tesl.impl.MaxstepPragmaImpl <em>Maxstep Pragma</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see fr.supelec.tesl.lang.tesl.impl.MaxstepPragmaImpl
   * @see fr.supelec.tesl.lang.tesl.impl.TeslPackageImpl#getMaxstepPragma()
   * @generated
   */
  int MAXSTEP_PRAGMA = 36;

  /**
   * The feature id for the '<em><b>Value</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MAXSTEP_PRAGMA__VALUE = PRAGMA_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>Maxstep Pragma</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MAXSTEP_PRAGMA_FEATURE_COUNT = PRAGMA_FEATURE_COUNT + 1;

  /**
   * The meta object id for the '{@link fr.supelec.tesl.lang.tesl.impl.OutputPragmaImpl <em>Output Pragma</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see fr.supelec.tesl.lang.tesl.impl.OutputPragmaImpl
   * @see fr.supelec.tesl.lang.tesl.impl.TeslPackageImpl#getOutputPragma()
   * @generated
   */
  int OUTPUT_PRAGMA = 37;

  /**
   * The feature id for the '<em><b>Type</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int OUTPUT_PRAGMA__TYPE = PRAGMA_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Selection</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int OUTPUT_PRAGMA__SELECTION = PRAGMA_FEATURE_COUNT + 1;

  /**
   * The feature id for the '<em><b>Selected Clocks</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int OUTPUT_PRAGMA__SELECTED_CLOCKS = PRAGMA_FEATURE_COUNT + 2;

  /**
   * The feature id for the '<em><b>Window</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int OUTPUT_PRAGMA__WINDOW = PRAGMA_FEATURE_COUNT + 3;

  /**
   * The feature id for the '<em><b>From</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int OUTPUT_PRAGMA__FROM = PRAGMA_FEATURE_COUNT + 4;

  /**
   * The feature id for the '<em><b>To</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int OUTPUT_PRAGMA__TO = PRAGMA_FEATURE_COUNT + 5;

  /**
   * The feature id for the '<em><b>Labelif</b></em>' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int OUTPUT_PRAGMA__LABELIF = PRAGMA_FEATURE_COUNT + 6;

  /**
   * The feature id for the '<em><b>Xscaled</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int OUTPUT_PRAGMA__XSCALED = PRAGMA_FEATURE_COUNT + 7;

  /**
   * The feature id for the '<em><b>Xscale</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int OUTPUT_PRAGMA__XSCALE = PRAGMA_FEATURE_COUNT + 8;

  /**
   * The feature id for the '<em><b>Border</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int OUTPUT_PRAGMA__BORDER = PRAGMA_FEATURE_COUNT + 9;

  /**
   * The feature id for the '<em><b>Css</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int OUTPUT_PRAGMA__CSS = PRAGMA_FEATURE_COUNT + 10;

  /**
   * The feature id for the '<em><b>Nodefcss</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int OUTPUT_PRAGMA__NODEFCSS = PRAGMA_FEATURE_COUNT + 11;

  /**
   * The feature id for the '<em><b>Jvs</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int OUTPUT_PRAGMA__JVS = PRAGMA_FEATURE_COUNT + 12;

  /**
   * The feature id for the '<em><b>Standalone</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int OUTPUT_PRAGMA__STANDALONE = PRAGMA_FEATURE_COUNT + 13;

  /**
   * The feature id for the '<em><b>Overwrite</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int OUTPUT_PRAGMA__OVERWRITE = PRAGMA_FEATURE_COUNT + 14;

  /**
   * The number of structural features of the '<em>Output Pragma</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int OUTPUT_PRAGMA_FEATURE_COUNT = PRAGMA_FEATURE_COUNT + 15;

  /**
   * The meta object id for the '{@link fr.supelec.tesl.lang.tesl.impl.ClockItemImpl <em>Clock Item</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see fr.supelec.tesl.lang.tesl.impl.ClockItemImpl
   * @see fr.supelec.tesl.lang.tesl.impl.TeslPackageImpl#getClockItem()
   * @generated
   */
  int CLOCK_ITEM = 38;

  /**
   * The feature id for the '<em><b>Clock</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CLOCK_ITEM__CLOCK = 0;

  /**
   * The feature id for the '<em><b>New Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CLOCK_ITEM__NEW_NAME = 1;

  /**
   * The number of structural features of the '<em>Clock Item</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CLOCK_ITEM_FEATURE_COUNT = 2;

  /**
   * The meta object id for the '{@link fr.supelec.tesl.lang.tesl.impl.DoubleCalcPragmaImpl <em>Double Calc Pragma</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see fr.supelec.tesl.lang.tesl.impl.DoubleCalcPragmaImpl
   * @see fr.supelec.tesl.lang.tesl.impl.TeslPackageImpl#getDoubleCalcPragma()
   * @generated
   */
  int DOUBLE_CALC_PRAGMA = 39;

  /**
   * The feature id for the '<em><b>Num digits</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int DOUBLE_CALC_PRAGMA__NUM_DIGITS = PRAGMA_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Round</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int DOUBLE_CALC_PRAGMA__ROUND = PRAGMA_FEATURE_COUNT + 1;

  /**
   * The feature id for the '<em><b>Rounding mode</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int DOUBLE_CALC_PRAGMA__ROUNDING_MODE = PRAGMA_FEATURE_COUNT + 2;

  /**
   * The number of structural features of the '<em>Double Calc Pragma</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int DOUBLE_CALC_PRAGMA_FEATURE_COUNT = PRAGMA_FEATURE_COUNT + 3;

  /**
   * The meta object id for the '{@link fr.supelec.tesl.lang.tesl.impl.DumpResultPragmaImpl <em>Dump Result Pragma</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see fr.supelec.tesl.lang.tesl.impl.DumpResultPragmaImpl
   * @see fr.supelec.tesl.lang.tesl.impl.TeslPackageImpl#getDumpResultPragma()
   * @generated
   */
  int DUMP_RESULT_PRAGMA = 40;

  /**
   * The number of structural features of the '<em>Dump Result Pragma</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int DUMP_RESULT_PRAGMA_FEATURE_COUNT = PRAGMA_FEATURE_COUNT + 0;

  /**
   * The meta object id for the '{@link fr.supelec.tesl.lang.tesl.impl.BinOpImpl <em>Bin Op</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see fr.supelec.tesl.lang.tesl.impl.BinOpImpl
   * @see fr.supelec.tesl.lang.tesl.impl.TeslPackageImpl#getBinOp()
   * @generated
   */
  int BIN_OP = 41;

  /**
   * The feature id for the '<em><b>Left</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int BIN_OP__LEFT = EXPRESSION_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Op</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int BIN_OP__OP = EXPRESSION_FEATURE_COUNT + 1;

  /**
   * The feature id for the '<em><b>Right</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int BIN_OP__RIGHT = EXPRESSION_FEATURE_COUNT + 2;

  /**
   * The number of structural features of the '<em>Bin Op</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int BIN_OP_FEATURE_COUNT = EXPRESSION_FEATURE_COUNT + 3;

  /**
   * The meta object id for the '{@link fr.supelec.tesl.lang.tesl.Type <em>Type</em>}' enum.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see fr.supelec.tesl.lang.tesl.Type
   * @see fr.supelec.tesl.lang.tesl.impl.TeslPackageImpl#getType()
   * @generated
   */
  int TYPE = 42;

  /**
   * The meta object id for the '{@link fr.supelec.tesl.lang.tesl.ValueType <em>Value Type</em>}' enum.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see fr.supelec.tesl.lang.tesl.ValueType
   * @see fr.supelec.tesl.lang.tesl.impl.TeslPackageImpl#getValueType()
   * @generated
   */
  int VALUE_TYPE = 43;

  /**
   * The meta object id for the '{@link fr.supelec.tesl.lang.tesl.Op <em>Op</em>}' enum.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see fr.supelec.tesl.lang.tesl.Op
   * @see fr.supelec.tesl.lang.tesl.impl.TeslPackageImpl#getOp()
   * @generated
   */
  int OP = 44;

  /**
   * The meta object id for the '{@link fr.supelec.tesl.lang.tesl.ROUNDING_MODE <em>ROUNDING MODE</em>}' enum.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see fr.supelec.tesl.lang.tesl.ROUNDING_MODE
   * @see fr.supelec.tesl.lang.tesl.impl.TeslPackageImpl#getROUNDING_MODE()
   * @generated
   */
  int ROUNDING_MODE = 45;


  /**
   * Returns the meta object for class '{@link fr.supelec.tesl.lang.tesl.Specification <em>Specification</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Specification</em>'.
   * @see fr.supelec.tesl.lang.tesl.Specification
   * @generated
   */
  EClass getSpecification();

  /**
   * Returns the meta object for the containment reference list '{@link fr.supelec.tesl.lang.tesl.Specification#getDecl <em>Decl</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Decl</em>'.
   * @see fr.supelec.tesl.lang.tesl.Specification#getDecl()
   * @see #getSpecification()
   * @generated
   */
  EReference getSpecification_Decl();

  /**
   * Returns the meta object for the containment reference list '{@link fr.supelec.tesl.lang.tesl.Specification#getRel <em>Rel</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Rel</em>'.
   * @see fr.supelec.tesl.lang.tesl.Specification#getRel()
   * @see #getSpecification()
   * @generated
   */
  EReference getSpecification_Rel();

  /**
   * Returns the meta object for the containment reference list '{@link fr.supelec.tesl.lang.tesl.Specification#getLet <em>Let</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Let</em>'.
   * @see fr.supelec.tesl.lang.tesl.Specification#getLet()
   * @see #getSpecification()
   * @generated
   */
  EReference getSpecification_Let();

  /**
   * Returns the meta object for the containment reference list '{@link fr.supelec.tesl.lang.tesl.Specification#getPragmas <em>Pragmas</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Pragmas</em>'.
   * @see fr.supelec.tesl.lang.tesl.Specification#getPragmas()
   * @see #getSpecification()
   * @generated
   */
  EReference getSpecification_Pragmas();

  /**
   * Returns the meta object for class '{@link fr.supelec.tesl.lang.tesl.Clock <em>Clock</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Clock</em>'.
   * @see fr.supelec.tesl.lang.tesl.Clock
   * @generated
   */
  EClass getClock();

  /**
   * Returns the meta object for the attribute '{@link fr.supelec.tesl.lang.tesl.Clock#isNongreedy <em>Nongreedy</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Nongreedy</em>'.
   * @see fr.supelec.tesl.lang.tesl.Clock#isNongreedy()
   * @see #getClock()
   * @generated
   */
  EAttribute getClock_Nongreedy();

  /**
   * Returns the meta object for the attribute '{@link fr.supelec.tesl.lang.tesl.Clock#getType <em>Type</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Type</em>'.
   * @see fr.supelec.tesl.lang.tesl.Clock#getType()
   * @see #getClock()
   * @generated
   */
  EAttribute getClock_Type();

  /**
   * Returns the meta object for the attribute '{@link fr.supelec.tesl.lang.tesl.Clock#getName <em>Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Name</em>'.
   * @see fr.supelec.tesl.lang.tesl.Clock#getName()
   * @see #getClock()
   * @generated
   */
  EAttribute getClock_Name();

  /**
   * Returns the meta object for the containment reference '{@link fr.supelec.tesl.lang.tesl.Clock#getQual <em>Qual</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Qual</em>'.
   * @see fr.supelec.tesl.lang.tesl.Clock#getQual()
   * @see #getClock()
   * @generated
   */
  EReference getClock_Qual();

  /**
   * Returns the meta object for class '{@link fr.supelec.tesl.lang.tesl.ClockQualifier <em>Clock Qualifier</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Clock Qualifier</em>'.
   * @see fr.supelec.tesl.lang.tesl.ClockQualifier
   * @generated
   */
  EClass getClockQualifier();

  /**
   * Returns the meta object for class '{@link fr.supelec.tesl.lang.tesl.PeriodicQualifier <em>Periodic Qualifier</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Periodic Qualifier</em>'.
   * @see fr.supelec.tesl.lang.tesl.PeriodicQualifier
   * @generated
   */
  EClass getPeriodicQualifier();

  /**
   * Returns the meta object for the containment reference '{@link fr.supelec.tesl.lang.tesl.PeriodicQualifier#getPeriod <em>Period</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Period</em>'.
   * @see fr.supelec.tesl.lang.tesl.PeriodicQualifier#getPeriod()
   * @see #getPeriodicQualifier()
   * @generated
   */
  EReference getPeriodicQualifier_Period();

  /**
   * Returns the meta object for the containment reference '{@link fr.supelec.tesl.lang.tesl.PeriodicQualifier#getOffset <em>Offset</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Offset</em>'.
   * @see fr.supelec.tesl.lang.tesl.PeriodicQualifier#getOffset()
   * @see #getPeriodicQualifier()
   * @generated
   */
  EReference getPeriodicQualifier_Offset();

  /**
   * Returns the meta object for class '{@link fr.supelec.tesl.lang.tesl.SporadicQualifier <em>Sporadic Qualifier</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Sporadic Qualifier</em>'.
   * @see fr.supelec.tesl.lang.tesl.SporadicQualifier
   * @generated
   */
  EClass getSporadicQualifier();

  /**
   * Returns the meta object for the containment reference list '{@link fr.supelec.tesl.lang.tesl.SporadicQualifier#getInstants <em>Instants</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Instants</em>'.
   * @see fr.supelec.tesl.lang.tesl.SporadicQualifier#getInstants()
   * @see #getSporadicQualifier()
   * @generated
   */
  EReference getSporadicQualifier_Instants();

  /**
   * Returns the meta object for class '{@link fr.supelec.tesl.lang.tesl.Relation <em>Relation</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Relation</em>'.
   * @see fr.supelec.tesl.lang.tesl.Relation
   * @generated
   */
  EClass getRelation();

  /**
   * Returns the meta object for class '{@link fr.supelec.tesl.lang.tesl.ImplicationRelation <em>Implication Relation</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Implication Relation</em>'.
   * @see fr.supelec.tesl.lang.tesl.ImplicationRelation
   * @generated
   */
  EClass getImplicationRelation();

  /**
   * Returns the meta object for the reference '{@link fr.supelec.tesl.lang.tesl.ImplicationRelation#getSource <em>Source</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference '<em>Source</em>'.
   * @see fr.supelec.tesl.lang.tesl.ImplicationRelation#getSource()
   * @see #getImplicationRelation()
   * @generated
   */
  EReference getImplicationRelation_Source();

  /**
   * Returns the meta object for the containment reference '{@link fr.supelec.tesl.lang.tesl.ImplicationRelation#getQual <em>Qual</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Qual</em>'.
   * @see fr.supelec.tesl.lang.tesl.ImplicationRelation#getQual()
   * @see #getImplicationRelation()
   * @generated
   */
  EReference getImplicationRelation_Qual();

  /**
   * Returns the meta object for the reference '{@link fr.supelec.tesl.lang.tesl.ImplicationRelation#getTarget <em>Target</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference '<em>Target</em>'.
   * @see fr.supelec.tesl.lang.tesl.ImplicationRelation#getTarget()
   * @see #getImplicationRelation()
   * @generated
   */
  EReference getImplicationRelation_Target();

  /**
   * Returns the meta object for class '{@link fr.supelec.tesl.lang.tesl.AwaitImplication <em>Await Implication</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Await Implication</em>'.
   * @see fr.supelec.tesl.lang.tesl.AwaitImplication
   * @generated
   */
  EClass getAwaitImplication();

  /**
   * Returns the meta object for the reference list '{@link fr.supelec.tesl.lang.tesl.AwaitImplication#getMasters <em>Masters</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference list '<em>Masters</em>'.
   * @see fr.supelec.tesl.lang.tesl.AwaitImplication#getMasters()
   * @see #getAwaitImplication()
   * @generated
   */
  EReference getAwaitImplication_Masters();

  /**
   * Returns the meta object for the attribute '{@link fr.supelec.tesl.lang.tesl.AwaitImplication#isWeak <em>Weak</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Weak</em>'.
   * @see fr.supelec.tesl.lang.tesl.AwaitImplication#isWeak()
   * @see #getAwaitImplication()
   * @generated
   */
  EAttribute getAwaitImplication_Weak();

  /**
   * Returns the meta object for the attribute '{@link fr.supelec.tesl.lang.tesl.AwaitImplication#isStrong <em>Strong</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Strong</em>'.
   * @see fr.supelec.tesl.lang.tesl.AwaitImplication#isStrong()
   * @see #getAwaitImplication()
   * @generated
   */
  EAttribute getAwaitImplication_Strong();

  /**
   * Returns the meta object for the reference '{@link fr.supelec.tesl.lang.tesl.AwaitImplication#getReset <em>Reset</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference '<em>Reset</em>'.
   * @see fr.supelec.tesl.lang.tesl.AwaitImplication#getReset()
   * @see #getAwaitImplication()
   * @generated
   */
  EReference getAwaitImplication_Reset();

  /**
   * Returns the meta object for the reference '{@link fr.supelec.tesl.lang.tesl.AwaitImplication#getTarget <em>Target</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference '<em>Target</em>'.
   * @see fr.supelec.tesl.lang.tesl.AwaitImplication#getTarget()
   * @see #getAwaitImplication()
   * @generated
   */
  EReference getAwaitImplication_Target();

  /**
   * Returns the meta object for class '{@link fr.supelec.tesl.lang.tesl.ImplicationQualifier <em>Implication Qualifier</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Implication Qualifier</em>'.
   * @see fr.supelec.tesl.lang.tesl.ImplicationQualifier
   * @generated
   */
  EClass getImplicationQualifier();

  /**
   * Returns the meta object for class '{@link fr.supelec.tesl.lang.tesl.FilteredQualifier <em>Filtered Qualifier</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Filtered Qualifier</em>'.
   * @see fr.supelec.tesl.lang.tesl.FilteredQualifier
   * @generated
   */
  EClass getFilteredQualifier();

  /**
   * Returns the meta object for the containment reference '{@link fr.supelec.tesl.lang.tesl.FilteredQualifier#getPattern <em>Pattern</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Pattern</em>'.
   * @see fr.supelec.tesl.lang.tesl.FilteredQualifier#getPattern()
   * @see #getFilteredQualifier()
   * @generated
   */
  EReference getFilteredQualifier_Pattern();

  /**
   * Returns the meta object for class '{@link fr.supelec.tesl.lang.tesl.EveryQualifier <em>Every Qualifier</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Every Qualifier</em>'.
   * @see fr.supelec.tesl.lang.tesl.EveryQualifier
   * @generated
   */
  EClass getEveryQualifier();

  /**
   * Returns the meta object for the containment reference '{@link fr.supelec.tesl.lang.tesl.EveryQualifier#getPeriod <em>Period</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Period</em>'.
   * @see fr.supelec.tesl.lang.tesl.EveryQualifier#getPeriod()
   * @see #getEveryQualifier()
   * @generated
   */
  EReference getEveryQualifier_Period();

  /**
   * Returns the meta object for the attribute '{@link fr.supelec.tesl.lang.tesl.EveryQualifier#isOff <em>Off</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Off</em>'.
   * @see fr.supelec.tesl.lang.tesl.EveryQualifier#isOff()
   * @see #getEveryQualifier()
   * @generated
   */
  EAttribute getEveryQualifier_Off();

  /**
   * Returns the meta object for the containment reference '{@link fr.supelec.tesl.lang.tesl.EveryQualifier#getOffset <em>Offset</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Offset</em>'.
   * @see fr.supelec.tesl.lang.tesl.EveryQualifier#getOffset()
   * @see #getEveryQualifier()
   * @generated
   */
  EReference getEveryQualifier_Offset();

  /**
   * Returns the meta object for class '{@link fr.supelec.tesl.lang.tesl.DelayedQualifier <em>Delayed Qualifier</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Delayed Qualifier</em>'.
   * @see fr.supelec.tesl.lang.tesl.DelayedQualifier
   * @generated
   */
  EClass getDelayedQualifier();

  /**
   * Returns the meta object for the attribute '{@link fr.supelec.tesl.lang.tesl.DelayedQualifier#isImmediately <em>Immediately</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Immediately</em>'.
   * @see fr.supelec.tesl.lang.tesl.DelayedQualifier#isImmediately()
   * @see #getDelayedQualifier()
   * @generated
   */
  EAttribute getDelayedQualifier_Immediately();

  /**
   * Returns the meta object for the containment reference '{@link fr.supelec.tesl.lang.tesl.DelayedQualifier#getCount <em>Count</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Count</em>'.
   * @see fr.supelec.tesl.lang.tesl.DelayedQualifier#getCount()
   * @see #getDelayedQualifier()
   * @generated
   */
  EReference getDelayedQualifier_Count();

  /**
   * Returns the meta object for the attribute '{@link fr.supelec.tesl.lang.tesl.DelayedQualifier#isReset <em>Reset</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Reset</em>'.
   * @see fr.supelec.tesl.lang.tesl.DelayedQualifier#isReset()
   * @see #getDelayedQualifier()
   * @generated
   */
  EAttribute getDelayedQualifier_Reset();

  /**
   * Returns the meta object for the reference '{@link fr.supelec.tesl.lang.tesl.DelayedQualifier#getClock <em>Clock</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference '<em>Clock</em>'.
   * @see fr.supelec.tesl.lang.tesl.DelayedQualifier#getClock()
   * @see #getDelayedQualifier()
   * @generated
   */
  EReference getDelayedQualifier_Clock();

  /**
   * Returns the meta object for class '{@link fr.supelec.tesl.lang.tesl.SustainedQualifier <em>Sustained Qualifier</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Sustained Qualifier</em>'.
   * @see fr.supelec.tesl.lang.tesl.SustainedQualifier
   * @generated
   */
  EClass getSustainedQualifier();

  /**
   * Returns the meta object for the attribute '{@link fr.supelec.tesl.lang.tesl.SustainedQualifier#isImmediately <em>Immediately</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Immediately</em>'.
   * @see fr.supelec.tesl.lang.tesl.SustainedQualifier#isImmediately()
   * @see #getSustainedQualifier()
   * @generated
   */
  EAttribute getSustainedQualifier_Immediately();

  /**
   * Returns the meta object for the reference '{@link fr.supelec.tesl.lang.tesl.SustainedQualifier#getStartClock <em>Start Clock</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference '<em>Start Clock</em>'.
   * @see fr.supelec.tesl.lang.tesl.SustainedQualifier#getStartClock()
   * @see #getSustainedQualifier()
   * @generated
   */
  EReference getSustainedQualifier_StartClock();

  /**
   * Returns the meta object for the reference '{@link fr.supelec.tesl.lang.tesl.SustainedQualifier#getEndClock <em>End Clock</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference '<em>End Clock</em>'.
   * @see fr.supelec.tesl.lang.tesl.SustainedQualifier#getEndClock()
   * @see #getSustainedQualifier()
   * @generated
   */
  EReference getSustainedQualifier_EndClock();

  /**
   * Returns the meta object for the attribute '{@link fr.supelec.tesl.lang.tesl.SustainedQualifier#isWeakly <em>Weakly</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Weakly</em>'.
   * @see fr.supelec.tesl.lang.tesl.SustainedQualifier#isWeakly()
   * @see #getSustainedQualifier()
   * @generated
   */
  EAttribute getSustainedQualifier_Weakly();

  /**
   * Returns the meta object for class '{@link fr.supelec.tesl.lang.tesl.TimeDelayedQualifier <em>Time Delayed Qualifier</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Time Delayed Qualifier</em>'.
   * @see fr.supelec.tesl.lang.tesl.TimeDelayedQualifier
   * @generated
   */
  EClass getTimeDelayedQualifier();

  /**
   * Returns the meta object for the containment reference '{@link fr.supelec.tesl.lang.tesl.TimeDelayedQualifier#getDelay <em>Delay</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Delay</em>'.
   * @see fr.supelec.tesl.lang.tesl.TimeDelayedQualifier#getDelay()
   * @see #getTimeDelayedQualifier()
   * @generated
   */
  EReference getTimeDelayedQualifier_Delay();

  /**
   * Returns the meta object for the reference '{@link fr.supelec.tesl.lang.tesl.TimeDelayedQualifier#getClock <em>Clock</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference '<em>Clock</em>'.
   * @see fr.supelec.tesl.lang.tesl.TimeDelayedQualifier#getClock()
   * @see #getTimeDelayedQualifier()
   * @generated
   */
  EReference getTimeDelayedQualifier_Clock();

  /**
   * Returns the meta object for the attribute '{@link fr.supelec.tesl.lang.tesl.TimeDelayedQualifier#isReset <em>Reset</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Reset</em>'.
   * @see fr.supelec.tesl.lang.tesl.TimeDelayedQualifier#isReset()
   * @see #getTimeDelayedQualifier()
   * @generated
   */
  EAttribute getTimeDelayedQualifier_Reset();

  /**
   * Returns the meta object for the attribute '{@link fr.supelec.tesl.lang.tesl.TimeDelayedQualifier#isImmReset <em>Imm Reset</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Imm Reset</em>'.
   * @see fr.supelec.tesl.lang.tesl.TimeDelayedQualifier#isImmReset()
   * @see #getTimeDelayedQualifier()
   * @generated
   */
  EAttribute getTimeDelayedQualifier_ImmReset();

  /**
   * Returns the meta object for the attribute '{@link fr.supelec.tesl.lang.tesl.TimeDelayedQualifier#isStrongReset <em>Strong Reset</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Strong Reset</em>'.
   * @see fr.supelec.tesl.lang.tesl.TimeDelayedQualifier#isStrongReset()
   * @see #getTimeDelayedQualifier()
   * @generated
   */
  EAttribute getTimeDelayedQualifier_StrongReset();

  /**
   * Returns the meta object for the reference '{@link fr.supelec.tesl.lang.tesl.TimeDelayedQualifier#getResetClock <em>Reset Clock</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference '<em>Reset Clock</em>'.
   * @see fr.supelec.tesl.lang.tesl.TimeDelayedQualifier#getResetClock()
   * @see #getTimeDelayedQualifier()
   * @generated
   */
  EReference getTimeDelayedQualifier_ResetClock();

  /**
   * Returns the meta object for class '{@link fr.supelec.tesl.lang.tesl.Let <em>Let</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Let</em>'.
   * @see fr.supelec.tesl.lang.tesl.Let
   * @generated
   */
  EClass getLet();

  /**
   * Returns the meta object for the attribute '{@link fr.supelec.tesl.lang.tesl.Let#getType <em>Type</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Type</em>'.
   * @see fr.supelec.tesl.lang.tesl.Let#getType()
   * @see #getLet()
   * @generated
   */
  EAttribute getLet_Type();

  /**
   * Returns the meta object for the attribute '{@link fr.supelec.tesl.lang.tesl.Let#getName <em>Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Name</em>'.
   * @see fr.supelec.tesl.lang.tesl.Let#getName()
   * @see #getLet()
   * @generated
   */
  EAttribute getLet_Name();

  /**
   * Returns the meta object for the containment reference '{@link fr.supelec.tesl.lang.tesl.Let#getValue <em>Value</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Value</em>'.
   * @see fr.supelec.tesl.lang.tesl.Let#getValue()
   * @see #getLet()
   * @generated
   */
  EReference getLet_Value();

  /**
   * Returns the meta object for class '{@link fr.supelec.tesl.lang.tesl.Value <em>Value</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Value</em>'.
   * @see fr.supelec.tesl.lang.tesl.Value
   * @generated
   */
  EClass getValue();

  /**
   * Returns the meta object for class '{@link fr.supelec.tesl.lang.tesl.IntegerValue <em>Integer Value</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Integer Value</em>'.
   * @see fr.supelec.tesl.lang.tesl.IntegerValue
   * @generated
   */
  EClass getIntegerValue();

  /**
   * Returns the meta object for the attribute '{@link fr.supelec.tesl.lang.tesl.IntegerValue#getSign <em>Sign</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Sign</em>'.
   * @see fr.supelec.tesl.lang.tesl.IntegerValue#getSign()
   * @see #getIntegerValue()
   * @generated
   */
  EAttribute getIntegerValue_Sign();

  /**
   * Returns the meta object for the attribute '{@link fr.supelec.tesl.lang.tesl.IntegerValue#getValue <em>Value</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Value</em>'.
   * @see fr.supelec.tesl.lang.tesl.IntegerValue#getValue()
   * @see #getIntegerValue()
   * @generated
   */
  EAttribute getIntegerValue_Value();

  /**
   * Returns the meta object for class '{@link fr.supelec.tesl.lang.tesl.DecimalValue <em>Decimal Value</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Decimal Value</em>'.
   * @see fr.supelec.tesl.lang.tesl.DecimalValue
   * @generated
   */
  EClass getDecimalValue();

  /**
   * Returns the meta object for the attribute '{@link fr.supelec.tesl.lang.tesl.DecimalValue#getSign <em>Sign</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Sign</em>'.
   * @see fr.supelec.tesl.lang.tesl.DecimalValue#getSign()
   * @see #getDecimalValue()
   * @generated
   */
  EAttribute getDecimalValue_Sign();

  /**
   * Returns the meta object for the attribute '{@link fr.supelec.tesl.lang.tesl.DecimalValue#getValue <em>Value</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Value</em>'.
   * @see fr.supelec.tesl.lang.tesl.DecimalValue#getValue()
   * @see #getDecimalValue()
   * @generated
   */
  EAttribute getDecimalValue_Value();

  /**
   * Returns the meta object for class '{@link fr.supelec.tesl.lang.tesl.FloatValue <em>Float Value</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Float Value</em>'.
   * @see fr.supelec.tesl.lang.tesl.FloatValue
   * @generated
   */
  EClass getFloatValue();

  /**
   * Returns the meta object for the attribute '{@link fr.supelec.tesl.lang.tesl.FloatValue#getSign <em>Sign</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Sign</em>'.
   * @see fr.supelec.tesl.lang.tesl.FloatValue#getSign()
   * @see #getFloatValue()
   * @generated
   */
  EAttribute getFloatValue_Sign();

  /**
   * Returns the meta object for the attribute '{@link fr.supelec.tesl.lang.tesl.FloatValue#getValue <em>Value</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Value</em>'.
   * @see fr.supelec.tesl.lang.tesl.FloatValue#getValue()
   * @see #getFloatValue()
   * @generated
   */
  EAttribute getFloatValue_Value();

  /**
   * Returns the meta object for class '{@link fr.supelec.tesl.lang.tesl.RationalValue <em>Rational Value</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Rational Value</em>'.
   * @see fr.supelec.tesl.lang.tesl.RationalValue
   * @generated
   */
  EClass getRationalValue();

  /**
   * Returns the meta object for the attribute '{@link fr.supelec.tesl.lang.tesl.RationalValue#getSign <em>Sign</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Sign</em>'.
   * @see fr.supelec.tesl.lang.tesl.RationalValue#getSign()
   * @see #getRationalValue()
   * @generated
   */
  EAttribute getRationalValue_Sign();

  /**
   * Returns the meta object for the attribute '{@link fr.supelec.tesl.lang.tesl.RationalValue#getValue <em>Value</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Value</em>'.
   * @see fr.supelec.tesl.lang.tesl.RationalValue#getValue()
   * @see #getRationalValue()
   * @generated
   */
  EAttribute getRationalValue_Value();

  /**
   * Returns the meta object for class '{@link fr.supelec.tesl.lang.tesl.LetValue <em>Let Value</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Let Value</em>'.
   * @see fr.supelec.tesl.lang.tesl.LetValue
   * @generated
   */
  EClass getLetValue();

  /**
   * Returns the meta object for the reference '{@link fr.supelec.tesl.lang.tesl.LetValue#getRef <em>Ref</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference '<em>Ref</em>'.
   * @see fr.supelec.tesl.lang.tesl.LetValue#getRef()
   * @see #getLetValue()
   * @generated
   */
  EReference getLetValue_Ref();

  /**
   * Returns the meta object for class '{@link fr.supelec.tesl.lang.tesl.Expression <em>Expression</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Expression</em>'.
   * @see fr.supelec.tesl.lang.tesl.Expression
   * @generated
   */
  EClass getExpression();

  /**
   * Returns the meta object for class '{@link fr.supelec.tesl.lang.tesl.Cast <em>Cast</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Cast</em>'.
   * @see fr.supelec.tesl.lang.tesl.Cast
   * @generated
   */
  EClass getCast();

  /**
   * Returns the meta object for the containment reference '{@link fr.supelec.tesl.lang.tesl.Cast#getExpr <em>Expr</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Expr</em>'.
   * @see fr.supelec.tesl.lang.tesl.Cast#getExpr()
   * @see #getCast()
   * @generated
   */
  EReference getCast_Expr();

  /**
   * Returns the meta object for class '{@link fr.supelec.tesl.lang.tesl.IntCast <em>Int Cast</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Int Cast</em>'.
   * @see fr.supelec.tesl.lang.tesl.IntCast
   * @generated
   */
  EClass getIntCast();

  /**
   * Returns the meta object for class '{@link fr.supelec.tesl.lang.tesl.FloatCast <em>Float Cast</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Float Cast</em>'.
   * @see fr.supelec.tesl.lang.tesl.FloatCast
   * @generated
   */
  EClass getFloatCast();

  /**
   * Returns the meta object for class '{@link fr.supelec.tesl.lang.tesl.DecimalCast <em>Decimal Cast</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Decimal Cast</em>'.
   * @see fr.supelec.tesl.lang.tesl.DecimalCast
   * @generated
   */
  EClass getDecimalCast();

  /**
   * Returns the meta object for class '{@link fr.supelec.tesl.lang.tesl.RationalCast <em>Rational Cast</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Rational Cast</em>'.
   * @see fr.supelec.tesl.lang.tesl.RationalCast
   * @generated
   */
  EClass getRationalCast();

  /**
   * Returns the meta object for class '{@link fr.supelec.tesl.lang.tesl.WhenQualifier <em>When Qualifier</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>When Qualifier</em>'.
   * @see fr.supelec.tesl.lang.tesl.WhenQualifier
   * @generated
   */
  EClass getWhenQualifier();

  /**
   * Returns the meta object for the attribute '{@link fr.supelec.tesl.lang.tesl.WhenQualifier#isNot <em>Not</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Not</em>'.
   * @see fr.supelec.tesl.lang.tesl.WhenQualifier#isNot()
   * @see #getWhenQualifier()
   * @generated
   */
  EAttribute getWhenQualifier_Not();

  /**
   * Returns the meta object for the reference '{@link fr.supelec.tesl.lang.tesl.WhenQualifier#getClock <em>Clock</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference '<em>Clock</em>'.
   * @see fr.supelec.tesl.lang.tesl.WhenQualifier#getClock()
   * @see #getWhenQualifier()
   * @generated
   */
  EReference getWhenQualifier_Clock();

  /**
   * Returns the meta object for class '{@link fr.supelec.tesl.lang.tesl.NextQualifier <em>Next Qualifier</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Next Qualifier</em>'.
   * @see fr.supelec.tesl.lang.tesl.NextQualifier
   * @generated
   */
  EClass getNextQualifier();

  /**
   * Returns the meta object for the attribute '{@link fr.supelec.tesl.lang.tesl.NextQualifier#isStrict <em>Strict</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Strict</em>'.
   * @see fr.supelec.tesl.lang.tesl.NextQualifier#isStrict()
   * @see #getNextQualifier()
   * @generated
   */
  EAttribute getNextQualifier_Strict();

  /**
   * Returns the meta object for the reference '{@link fr.supelec.tesl.lang.tesl.NextQualifier#getClock <em>Clock</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference '<em>Clock</em>'.
   * @see fr.supelec.tesl.lang.tesl.NextQualifier#getClock()
   * @see #getNextQualifier()
   * @generated
   */
  EReference getNextQualifier_Clock();

  /**
   * Returns the meta object for class '{@link fr.supelec.tesl.lang.tesl.Pattern <em>Pattern</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Pattern</em>'.
   * @see fr.supelec.tesl.lang.tesl.Pattern
   * @generated
   */
  EClass getPattern();

  /**
   * Returns the meta object for the containment reference '{@link fr.supelec.tesl.lang.tesl.Pattern#getSkip <em>Skip</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Skip</em>'.
   * @see fr.supelec.tesl.lang.tesl.Pattern#getSkip()
   * @see #getPattern()
   * @generated
   */
  EReference getPattern_Skip();

  /**
   * Returns the meta object for the containment reference '{@link fr.supelec.tesl.lang.tesl.Pattern#getKeep <em>Keep</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Keep</em>'.
   * @see fr.supelec.tesl.lang.tesl.Pattern#getKeep()
   * @see #getPattern()
   * @generated
   */
  EReference getPattern_Keep();

  /**
   * Returns the meta object for the attribute '{@link fr.supelec.tesl.lang.tesl.Pattern#isRep <em>Rep</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Rep</em>'.
   * @see fr.supelec.tesl.lang.tesl.Pattern#isRep()
   * @see #getPattern()
   * @generated
   */
  EAttribute getPattern_Rep();

  /**
   * Returns the meta object for the containment reference '{@link fr.supelec.tesl.lang.tesl.Pattern#getRepskip <em>Repskip</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Repskip</em>'.
   * @see fr.supelec.tesl.lang.tesl.Pattern#getRepskip()
   * @see #getPattern()
   * @generated
   */
  EReference getPattern_Repskip();

  /**
   * Returns the meta object for the containment reference '{@link fr.supelec.tesl.lang.tesl.Pattern#getRepkeep <em>Repkeep</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Repkeep</em>'.
   * @see fr.supelec.tesl.lang.tesl.Pattern#getRepkeep()
   * @see #getPattern()
   * @generated
   */
  EReference getPattern_Repkeep();

  /**
   * Returns the meta object for class '{@link fr.supelec.tesl.lang.tesl.TagRelation <em>Tag Relation</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Tag Relation</em>'.
   * @see fr.supelec.tesl.lang.tesl.TagRelation
   * @generated
   */
  EClass getTagRelation();

  /**
   * Returns the meta object for the containment reference '{@link fr.supelec.tesl.lang.tesl.TagRelation#getExpr <em>Expr</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Expr</em>'.
   * @see fr.supelec.tesl.lang.tesl.TagRelation#getExpr()
   * @see #getTagRelation()
   * @generated
   */
  EReference getTagRelation_Expr();

  /**
   * Returns the meta object for class '{@link fr.supelec.tesl.lang.tesl.TagExpr <em>Tag Expr</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Tag Expr</em>'.
   * @see fr.supelec.tesl.lang.tesl.TagExpr
   * @generated
   */
  EClass getTagExpr();

  /**
   * Returns the meta object for the reference '{@link fr.supelec.tesl.lang.tesl.TagExpr#getClockY <em>Clock Y</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference '<em>Clock Y</em>'.
   * @see fr.supelec.tesl.lang.tesl.TagExpr#getClockY()
   * @see #getTagExpr()
   * @generated
   */
  EReference getTagExpr_ClockY();

  /**
   * Returns the meta object for the containment reference '{@link fr.supelec.tesl.lang.tesl.TagExpr#getValueA <em>Value A</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Value A</em>'.
   * @see fr.supelec.tesl.lang.tesl.TagExpr#getValueA()
   * @see #getTagExpr()
   * @generated
   */
  EReference getTagExpr_ValueA();

  /**
   * Returns the meta object for the reference '{@link fr.supelec.tesl.lang.tesl.TagExpr#getClockX <em>Clock X</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference '<em>Clock X</em>'.
   * @see fr.supelec.tesl.lang.tesl.TagExpr#getClockX()
   * @see #getTagExpr()
   * @generated
   */
  EReference getTagExpr_ClockX();

  /**
   * Returns the meta object for the containment reference '{@link fr.supelec.tesl.lang.tesl.TagExpr#getValueN <em>Value N</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Value N</em>'.
   * @see fr.supelec.tesl.lang.tesl.TagExpr#getValueN()
   * @see #getTagExpr()
   * @generated
   */
  EReference getTagExpr_ValueN();

  /**
   * Returns the meta object for the containment reference '{@link fr.supelec.tesl.lang.tesl.TagExpr#getValueB <em>Value B</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Value B</em>'.
   * @see fr.supelec.tesl.lang.tesl.TagExpr#getValueB()
   * @see #getTagExpr()
   * @generated
   */
  EReference getTagExpr_ValueB();

  /**
   * Returns the meta object for class '{@link fr.supelec.tesl.lang.tesl.Pragma <em>Pragma</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Pragma</em>'.
   * @see fr.supelec.tesl.lang.tesl.Pragma
   * @generated
   */
  EClass getPragma();

  /**
   * Returns the meta object for class '{@link fr.supelec.tesl.lang.tesl.StopPragma <em>Stop Pragma</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Stop Pragma</em>'.
   * @see fr.supelec.tesl.lang.tesl.StopPragma
   * @generated
   */
  EClass getStopPragma();

  /**
   * Returns the meta object for the reference '{@link fr.supelec.tesl.lang.tesl.StopPragma#getClock <em>Clock</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference '<em>Clock</em>'.
   * @see fr.supelec.tesl.lang.tesl.StopPragma#getClock()
   * @see #getStopPragma()
   * @generated
   */
  EReference getStopPragma_Clock();

  /**
   * Returns the meta object for class '{@link fr.supelec.tesl.lang.tesl.TagrefPragma <em>Tagref Pragma</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Tagref Pragma</em>'.
   * @see fr.supelec.tesl.lang.tesl.TagrefPragma
   * @generated
   */
  EClass getTagrefPragma();

  /**
   * Returns the meta object for the reference '{@link fr.supelec.tesl.lang.tesl.TagrefPragma#getClock <em>Clock</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference '<em>Clock</em>'.
   * @see fr.supelec.tesl.lang.tesl.TagrefPragma#getClock()
   * @see #getTagrefPragma()
   * @generated
   */
  EReference getTagrefPragma_Clock();

  /**
   * Returns the meta object for class '{@link fr.supelec.tesl.lang.tesl.TracePragma <em>Trace Pragma</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Trace Pragma</em>'.
   * @see fr.supelec.tesl.lang.tesl.TracePragma
   * @generated
   */
  EClass getTracePragma();

  /**
   * Returns the meta object for the attribute list '{@link fr.supelec.tesl.lang.tesl.TracePragma#getKinds <em>Kinds</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute list '<em>Kinds</em>'.
   * @see fr.supelec.tesl.lang.tesl.TracePragma#getKinds()
   * @see #getTracePragma()
   * @generated
   */
  EAttribute getTracePragma_Kinds();

  /**
   * Returns the meta object for class '{@link fr.supelec.tesl.lang.tesl.MaxstepPragma <em>Maxstep Pragma</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Maxstep Pragma</em>'.
   * @see fr.supelec.tesl.lang.tesl.MaxstepPragma
   * @generated
   */
  EClass getMaxstepPragma();

  /**
   * Returns the meta object for the containment reference '{@link fr.supelec.tesl.lang.tesl.MaxstepPragma#getValue <em>Value</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Value</em>'.
   * @see fr.supelec.tesl.lang.tesl.MaxstepPragma#getValue()
   * @see #getMaxstepPragma()
   * @generated
   */
  EReference getMaxstepPragma_Value();

  /**
   * Returns the meta object for class '{@link fr.supelec.tesl.lang.tesl.OutputPragma <em>Output Pragma</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Output Pragma</em>'.
   * @see fr.supelec.tesl.lang.tesl.OutputPragma
   * @generated
   */
  EClass getOutputPragma();

  /**
   * Returns the meta object for the attribute '{@link fr.supelec.tesl.lang.tesl.OutputPragma#getType <em>Type</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Type</em>'.
   * @see fr.supelec.tesl.lang.tesl.OutputPragma#getType()
   * @see #getOutputPragma()
   * @generated
   */
  EAttribute getOutputPragma_Type();

  /**
   * Returns the meta object for the attribute '{@link fr.supelec.tesl.lang.tesl.OutputPragma#isSelection <em>Selection</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Selection</em>'.
   * @see fr.supelec.tesl.lang.tesl.OutputPragma#isSelection()
   * @see #getOutputPragma()
   * @generated
   */
  EAttribute getOutputPragma_Selection();

  /**
   * Returns the meta object for the containment reference list '{@link fr.supelec.tesl.lang.tesl.OutputPragma#getSelectedClocks <em>Selected Clocks</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Selected Clocks</em>'.
   * @see fr.supelec.tesl.lang.tesl.OutputPragma#getSelectedClocks()
   * @see #getOutputPragma()
   * @generated
   */
  EReference getOutputPragma_SelectedClocks();

  /**
   * Returns the meta object for the attribute '{@link fr.supelec.tesl.lang.tesl.OutputPragma#isWindow <em>Window</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Window</em>'.
   * @see fr.supelec.tesl.lang.tesl.OutputPragma#isWindow()
   * @see #getOutputPragma()
   * @generated
   */
  EAttribute getOutputPragma_Window();

  /**
   * Returns the meta object for the containment reference '{@link fr.supelec.tesl.lang.tesl.OutputPragma#getFrom <em>From</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>From</em>'.
   * @see fr.supelec.tesl.lang.tesl.OutputPragma#getFrom()
   * @see #getOutputPragma()
   * @generated
   */
  EReference getOutputPragma_From();

  /**
   * Returns the meta object for the containment reference '{@link fr.supelec.tesl.lang.tesl.OutputPragma#getTo <em>To</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>To</em>'.
   * @see fr.supelec.tesl.lang.tesl.OutputPragma#getTo()
   * @see #getOutputPragma()
   * @generated
   */
  EReference getOutputPragma_To();

  /**
   * Returns the meta object for the reference list '{@link fr.supelec.tesl.lang.tesl.OutputPragma#getLabelif <em>Labelif</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference list '<em>Labelif</em>'.
   * @see fr.supelec.tesl.lang.tesl.OutputPragma#getLabelif()
   * @see #getOutputPragma()
   * @generated
   */
  EReference getOutputPragma_Labelif();

  /**
   * Returns the meta object for the attribute '{@link fr.supelec.tesl.lang.tesl.OutputPragma#isXscaled <em>Xscaled</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Xscaled</em>'.
   * @see fr.supelec.tesl.lang.tesl.OutputPragma#isXscaled()
   * @see #getOutputPragma()
   * @generated
   */
  EAttribute getOutputPragma_Xscaled();

  /**
   * Returns the meta object for the containment reference '{@link fr.supelec.tesl.lang.tesl.OutputPragma#getXscale <em>Xscale</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Xscale</em>'.
   * @see fr.supelec.tesl.lang.tesl.OutputPragma#getXscale()
   * @see #getOutputPragma()
   * @generated
   */
  EReference getOutputPragma_Xscale();

  /**
   * Returns the meta object for the attribute '{@link fr.supelec.tesl.lang.tesl.OutputPragma#getBorder <em>Border</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Border</em>'.
   * @see fr.supelec.tesl.lang.tesl.OutputPragma#getBorder()
   * @see #getOutputPragma()
   * @generated
   */
  EAttribute getOutputPragma_Border();

  /**
   * Returns the meta object for the attribute '{@link fr.supelec.tesl.lang.tesl.OutputPragma#getCss <em>Css</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Css</em>'.
   * @see fr.supelec.tesl.lang.tesl.OutputPragma#getCss()
   * @see #getOutputPragma()
   * @generated
   */
  EAttribute getOutputPragma_Css();

  /**
   * Returns the meta object for the attribute '{@link fr.supelec.tesl.lang.tesl.OutputPragma#isNodefcss <em>Nodefcss</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Nodefcss</em>'.
   * @see fr.supelec.tesl.lang.tesl.OutputPragma#isNodefcss()
   * @see #getOutputPragma()
   * @generated
   */
  EAttribute getOutputPragma_Nodefcss();

  /**
   * Returns the meta object for the attribute '{@link fr.supelec.tesl.lang.tesl.OutputPragma#getJvs <em>Jvs</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Jvs</em>'.
   * @see fr.supelec.tesl.lang.tesl.OutputPragma#getJvs()
   * @see #getOutputPragma()
   * @generated
   */
  EAttribute getOutputPragma_Jvs();

  /**
   * Returns the meta object for the attribute '{@link fr.supelec.tesl.lang.tesl.OutputPragma#isStandalone <em>Standalone</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Standalone</em>'.
   * @see fr.supelec.tesl.lang.tesl.OutputPragma#isStandalone()
   * @see #getOutputPragma()
   * @generated
   */
  EAttribute getOutputPragma_Standalone();

  /**
   * Returns the meta object for the attribute '{@link fr.supelec.tesl.lang.tesl.OutputPragma#isOverwrite <em>Overwrite</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Overwrite</em>'.
   * @see fr.supelec.tesl.lang.tesl.OutputPragma#isOverwrite()
   * @see #getOutputPragma()
   * @generated
   */
  EAttribute getOutputPragma_Overwrite();

  /**
   * Returns the meta object for class '{@link fr.supelec.tesl.lang.tesl.ClockItem <em>Clock Item</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Clock Item</em>'.
   * @see fr.supelec.tesl.lang.tesl.ClockItem
   * @generated
   */
  EClass getClockItem();

  /**
   * Returns the meta object for the reference '{@link fr.supelec.tesl.lang.tesl.ClockItem#getClock <em>Clock</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference '<em>Clock</em>'.
   * @see fr.supelec.tesl.lang.tesl.ClockItem#getClock()
   * @see #getClockItem()
   * @generated
   */
  EReference getClockItem_Clock();

  /**
   * Returns the meta object for the attribute '{@link fr.supelec.tesl.lang.tesl.ClockItem#getNewName <em>New Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>New Name</em>'.
   * @see fr.supelec.tesl.lang.tesl.ClockItem#getNewName()
   * @see #getClockItem()
   * @generated
   */
  EAttribute getClockItem_NewName();

  /**
   * Returns the meta object for class '{@link fr.supelec.tesl.lang.tesl.DoubleCalcPragma <em>Double Calc Pragma</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Double Calc Pragma</em>'.
   * @see fr.supelec.tesl.lang.tesl.DoubleCalcPragma
   * @generated
   */
  EClass getDoubleCalcPragma();

  /**
   * Returns the meta object for the attribute '{@link fr.supelec.tesl.lang.tesl.DoubleCalcPragma#getNum_digits <em>Num digits</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Num digits</em>'.
   * @see fr.supelec.tesl.lang.tesl.DoubleCalcPragma#getNum_digits()
   * @see #getDoubleCalcPragma()
   * @generated
   */
  EAttribute getDoubleCalcPragma_Num_digits();

  /**
   * Returns the meta object for the attribute '{@link fr.supelec.tesl.lang.tesl.DoubleCalcPragma#isRound <em>Round</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Round</em>'.
   * @see fr.supelec.tesl.lang.tesl.DoubleCalcPragma#isRound()
   * @see #getDoubleCalcPragma()
   * @generated
   */
  EAttribute getDoubleCalcPragma_Round();

  /**
   * Returns the meta object for the attribute '{@link fr.supelec.tesl.lang.tesl.DoubleCalcPragma#getRounding_mode <em>Rounding mode</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Rounding mode</em>'.
   * @see fr.supelec.tesl.lang.tesl.DoubleCalcPragma#getRounding_mode()
   * @see #getDoubleCalcPragma()
   * @generated
   */
  EAttribute getDoubleCalcPragma_Rounding_mode();

  /**
   * Returns the meta object for class '{@link fr.supelec.tesl.lang.tesl.DumpResultPragma <em>Dump Result Pragma</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Dump Result Pragma</em>'.
   * @see fr.supelec.tesl.lang.tesl.DumpResultPragma
   * @generated
   */
  EClass getDumpResultPragma();

  /**
   * Returns the meta object for class '{@link fr.supelec.tesl.lang.tesl.BinOp <em>Bin Op</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Bin Op</em>'.
   * @see fr.supelec.tesl.lang.tesl.BinOp
   * @generated
   */
  EClass getBinOp();

  /**
   * Returns the meta object for the containment reference '{@link fr.supelec.tesl.lang.tesl.BinOp#getLeft <em>Left</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Left</em>'.
   * @see fr.supelec.tesl.lang.tesl.BinOp#getLeft()
   * @see #getBinOp()
   * @generated
   */
  EReference getBinOp_Left();

  /**
   * Returns the meta object for the attribute '{@link fr.supelec.tesl.lang.tesl.BinOp#getOp <em>Op</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Op</em>'.
   * @see fr.supelec.tesl.lang.tesl.BinOp#getOp()
   * @see #getBinOp()
   * @generated
   */
  EAttribute getBinOp_Op();

  /**
   * Returns the meta object for the containment reference '{@link fr.supelec.tesl.lang.tesl.BinOp#getRight <em>Right</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Right</em>'.
   * @see fr.supelec.tesl.lang.tesl.BinOp#getRight()
   * @see #getBinOp()
   * @generated
   */
  EReference getBinOp_Right();

  /**
   * Returns the meta object for enum '{@link fr.supelec.tesl.lang.tesl.Type <em>Type</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for enum '<em>Type</em>'.
   * @see fr.supelec.tesl.lang.tesl.Type
   * @generated
   */
  EEnum getType();

  /**
   * Returns the meta object for enum '{@link fr.supelec.tesl.lang.tesl.ValueType <em>Value Type</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for enum '<em>Value Type</em>'.
   * @see fr.supelec.tesl.lang.tesl.ValueType
   * @generated
   */
  EEnum getValueType();

  /**
   * Returns the meta object for enum '{@link fr.supelec.tesl.lang.tesl.Op <em>Op</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for enum '<em>Op</em>'.
   * @see fr.supelec.tesl.lang.tesl.Op
   * @generated
   */
  EEnum getOp();

  /**
   * Returns the meta object for enum '{@link fr.supelec.tesl.lang.tesl.ROUNDING_MODE <em>ROUNDING MODE</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for enum '<em>ROUNDING MODE</em>'.
   * @see fr.supelec.tesl.lang.tesl.ROUNDING_MODE
   * @generated
   */
  EEnum getROUNDING_MODE();

  /**
   * Returns the factory that creates the instances of the model.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the factory that creates the instances of the model.
   * @generated
   */
  TeslFactory getTeslFactory();

  /**
   * <!-- begin-user-doc -->
   * Defines literals for the meta objects that represent
   * <ul>
   *   <li>each class,</li>
   *   <li>each feature of each class,</li>
   *   <li>each enum,</li>
   *   <li>and each data type</li>
   * </ul>
   * <!-- end-user-doc -->
   * @generated
   */
  interface Literals
  {
    /**
     * The meta object literal for the '{@link fr.supelec.tesl.lang.tesl.impl.SpecificationImpl <em>Specification</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see fr.supelec.tesl.lang.tesl.impl.SpecificationImpl
     * @see fr.supelec.tesl.lang.tesl.impl.TeslPackageImpl#getSpecification()
     * @generated
     */
    EClass SPECIFICATION = eINSTANCE.getSpecification();

    /**
     * The meta object literal for the '<em><b>Decl</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference SPECIFICATION__DECL = eINSTANCE.getSpecification_Decl();

    /**
     * The meta object literal for the '<em><b>Rel</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference SPECIFICATION__REL = eINSTANCE.getSpecification_Rel();

    /**
     * The meta object literal for the '<em><b>Let</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference SPECIFICATION__LET = eINSTANCE.getSpecification_Let();

    /**
     * The meta object literal for the '<em><b>Pragmas</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference SPECIFICATION__PRAGMAS = eINSTANCE.getSpecification_Pragmas();

    /**
     * The meta object literal for the '{@link fr.supelec.tesl.lang.tesl.impl.ClockImpl <em>Clock</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see fr.supelec.tesl.lang.tesl.impl.ClockImpl
     * @see fr.supelec.tesl.lang.tesl.impl.TeslPackageImpl#getClock()
     * @generated
     */
    EClass CLOCK = eINSTANCE.getClock();

    /**
     * The meta object literal for the '<em><b>Nongreedy</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute CLOCK__NONGREEDY = eINSTANCE.getClock_Nongreedy();

    /**
     * The meta object literal for the '<em><b>Type</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute CLOCK__TYPE = eINSTANCE.getClock_Type();

    /**
     * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute CLOCK__NAME = eINSTANCE.getClock_Name();

    /**
     * The meta object literal for the '<em><b>Qual</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference CLOCK__QUAL = eINSTANCE.getClock_Qual();

    /**
     * The meta object literal for the '{@link fr.supelec.tesl.lang.tesl.impl.ClockQualifierImpl <em>Clock Qualifier</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see fr.supelec.tesl.lang.tesl.impl.ClockQualifierImpl
     * @see fr.supelec.tesl.lang.tesl.impl.TeslPackageImpl#getClockQualifier()
     * @generated
     */
    EClass CLOCK_QUALIFIER = eINSTANCE.getClockQualifier();

    /**
     * The meta object literal for the '{@link fr.supelec.tesl.lang.tesl.impl.PeriodicQualifierImpl <em>Periodic Qualifier</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see fr.supelec.tesl.lang.tesl.impl.PeriodicQualifierImpl
     * @see fr.supelec.tesl.lang.tesl.impl.TeslPackageImpl#getPeriodicQualifier()
     * @generated
     */
    EClass PERIODIC_QUALIFIER = eINSTANCE.getPeriodicQualifier();

    /**
     * The meta object literal for the '<em><b>Period</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference PERIODIC_QUALIFIER__PERIOD = eINSTANCE.getPeriodicQualifier_Period();

    /**
     * The meta object literal for the '<em><b>Offset</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference PERIODIC_QUALIFIER__OFFSET = eINSTANCE.getPeriodicQualifier_Offset();

    /**
     * The meta object literal for the '{@link fr.supelec.tesl.lang.tesl.impl.SporadicQualifierImpl <em>Sporadic Qualifier</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see fr.supelec.tesl.lang.tesl.impl.SporadicQualifierImpl
     * @see fr.supelec.tesl.lang.tesl.impl.TeslPackageImpl#getSporadicQualifier()
     * @generated
     */
    EClass SPORADIC_QUALIFIER = eINSTANCE.getSporadicQualifier();

    /**
     * The meta object literal for the '<em><b>Instants</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference SPORADIC_QUALIFIER__INSTANTS = eINSTANCE.getSporadicQualifier_Instants();

    /**
     * The meta object literal for the '{@link fr.supelec.tesl.lang.tesl.impl.RelationImpl <em>Relation</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see fr.supelec.tesl.lang.tesl.impl.RelationImpl
     * @see fr.supelec.tesl.lang.tesl.impl.TeslPackageImpl#getRelation()
     * @generated
     */
    EClass RELATION = eINSTANCE.getRelation();

    /**
     * The meta object literal for the '{@link fr.supelec.tesl.lang.tesl.impl.ImplicationRelationImpl <em>Implication Relation</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see fr.supelec.tesl.lang.tesl.impl.ImplicationRelationImpl
     * @see fr.supelec.tesl.lang.tesl.impl.TeslPackageImpl#getImplicationRelation()
     * @generated
     */
    EClass IMPLICATION_RELATION = eINSTANCE.getImplicationRelation();

    /**
     * The meta object literal for the '<em><b>Source</b></em>' reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference IMPLICATION_RELATION__SOURCE = eINSTANCE.getImplicationRelation_Source();

    /**
     * The meta object literal for the '<em><b>Qual</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference IMPLICATION_RELATION__QUAL = eINSTANCE.getImplicationRelation_Qual();

    /**
     * The meta object literal for the '<em><b>Target</b></em>' reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference IMPLICATION_RELATION__TARGET = eINSTANCE.getImplicationRelation_Target();

    /**
     * The meta object literal for the '{@link fr.supelec.tesl.lang.tesl.impl.AwaitImplicationImpl <em>Await Implication</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see fr.supelec.tesl.lang.tesl.impl.AwaitImplicationImpl
     * @see fr.supelec.tesl.lang.tesl.impl.TeslPackageImpl#getAwaitImplication()
     * @generated
     */
    EClass AWAIT_IMPLICATION = eINSTANCE.getAwaitImplication();

    /**
     * The meta object literal for the '<em><b>Masters</b></em>' reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference AWAIT_IMPLICATION__MASTERS = eINSTANCE.getAwaitImplication_Masters();

    /**
     * The meta object literal for the '<em><b>Weak</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute AWAIT_IMPLICATION__WEAK = eINSTANCE.getAwaitImplication_Weak();

    /**
     * The meta object literal for the '<em><b>Strong</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute AWAIT_IMPLICATION__STRONG = eINSTANCE.getAwaitImplication_Strong();

    /**
     * The meta object literal for the '<em><b>Reset</b></em>' reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference AWAIT_IMPLICATION__RESET = eINSTANCE.getAwaitImplication_Reset();

    /**
     * The meta object literal for the '<em><b>Target</b></em>' reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference AWAIT_IMPLICATION__TARGET = eINSTANCE.getAwaitImplication_Target();

    /**
     * The meta object literal for the '{@link fr.supelec.tesl.lang.tesl.impl.ImplicationQualifierImpl <em>Implication Qualifier</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see fr.supelec.tesl.lang.tesl.impl.ImplicationQualifierImpl
     * @see fr.supelec.tesl.lang.tesl.impl.TeslPackageImpl#getImplicationQualifier()
     * @generated
     */
    EClass IMPLICATION_QUALIFIER = eINSTANCE.getImplicationQualifier();

    /**
     * The meta object literal for the '{@link fr.supelec.tesl.lang.tesl.impl.FilteredQualifierImpl <em>Filtered Qualifier</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see fr.supelec.tesl.lang.tesl.impl.FilteredQualifierImpl
     * @see fr.supelec.tesl.lang.tesl.impl.TeslPackageImpl#getFilteredQualifier()
     * @generated
     */
    EClass FILTERED_QUALIFIER = eINSTANCE.getFilteredQualifier();

    /**
     * The meta object literal for the '<em><b>Pattern</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference FILTERED_QUALIFIER__PATTERN = eINSTANCE.getFilteredQualifier_Pattern();

    /**
     * The meta object literal for the '{@link fr.supelec.tesl.lang.tesl.impl.EveryQualifierImpl <em>Every Qualifier</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see fr.supelec.tesl.lang.tesl.impl.EveryQualifierImpl
     * @see fr.supelec.tesl.lang.tesl.impl.TeslPackageImpl#getEveryQualifier()
     * @generated
     */
    EClass EVERY_QUALIFIER = eINSTANCE.getEveryQualifier();

    /**
     * The meta object literal for the '<em><b>Period</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference EVERY_QUALIFIER__PERIOD = eINSTANCE.getEveryQualifier_Period();

    /**
     * The meta object literal for the '<em><b>Off</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute EVERY_QUALIFIER__OFF = eINSTANCE.getEveryQualifier_Off();

    /**
     * The meta object literal for the '<em><b>Offset</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference EVERY_QUALIFIER__OFFSET = eINSTANCE.getEveryQualifier_Offset();

    /**
     * The meta object literal for the '{@link fr.supelec.tesl.lang.tesl.impl.DelayedQualifierImpl <em>Delayed Qualifier</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see fr.supelec.tesl.lang.tesl.impl.DelayedQualifierImpl
     * @see fr.supelec.tesl.lang.tesl.impl.TeslPackageImpl#getDelayedQualifier()
     * @generated
     */
    EClass DELAYED_QUALIFIER = eINSTANCE.getDelayedQualifier();

    /**
     * The meta object literal for the '<em><b>Immediately</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute DELAYED_QUALIFIER__IMMEDIATELY = eINSTANCE.getDelayedQualifier_Immediately();

    /**
     * The meta object literal for the '<em><b>Count</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference DELAYED_QUALIFIER__COUNT = eINSTANCE.getDelayedQualifier_Count();

    /**
     * The meta object literal for the '<em><b>Reset</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute DELAYED_QUALIFIER__RESET = eINSTANCE.getDelayedQualifier_Reset();

    /**
     * The meta object literal for the '<em><b>Clock</b></em>' reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference DELAYED_QUALIFIER__CLOCK = eINSTANCE.getDelayedQualifier_Clock();

    /**
     * The meta object literal for the '{@link fr.supelec.tesl.lang.tesl.impl.SustainedQualifierImpl <em>Sustained Qualifier</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see fr.supelec.tesl.lang.tesl.impl.SustainedQualifierImpl
     * @see fr.supelec.tesl.lang.tesl.impl.TeslPackageImpl#getSustainedQualifier()
     * @generated
     */
    EClass SUSTAINED_QUALIFIER = eINSTANCE.getSustainedQualifier();

    /**
     * The meta object literal for the '<em><b>Immediately</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute SUSTAINED_QUALIFIER__IMMEDIATELY = eINSTANCE.getSustainedQualifier_Immediately();

    /**
     * The meta object literal for the '<em><b>Start Clock</b></em>' reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference SUSTAINED_QUALIFIER__START_CLOCK = eINSTANCE.getSustainedQualifier_StartClock();

    /**
     * The meta object literal for the '<em><b>End Clock</b></em>' reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference SUSTAINED_QUALIFIER__END_CLOCK = eINSTANCE.getSustainedQualifier_EndClock();

    /**
     * The meta object literal for the '<em><b>Weakly</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute SUSTAINED_QUALIFIER__WEAKLY = eINSTANCE.getSustainedQualifier_Weakly();

    /**
     * The meta object literal for the '{@link fr.supelec.tesl.lang.tesl.impl.TimeDelayedQualifierImpl <em>Time Delayed Qualifier</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see fr.supelec.tesl.lang.tesl.impl.TimeDelayedQualifierImpl
     * @see fr.supelec.tesl.lang.tesl.impl.TeslPackageImpl#getTimeDelayedQualifier()
     * @generated
     */
    EClass TIME_DELAYED_QUALIFIER = eINSTANCE.getTimeDelayedQualifier();

    /**
     * The meta object literal for the '<em><b>Delay</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference TIME_DELAYED_QUALIFIER__DELAY = eINSTANCE.getTimeDelayedQualifier_Delay();

    /**
     * The meta object literal for the '<em><b>Clock</b></em>' reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference TIME_DELAYED_QUALIFIER__CLOCK = eINSTANCE.getTimeDelayedQualifier_Clock();

    /**
     * The meta object literal for the '<em><b>Reset</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute TIME_DELAYED_QUALIFIER__RESET = eINSTANCE.getTimeDelayedQualifier_Reset();

    /**
     * The meta object literal for the '<em><b>Imm Reset</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute TIME_DELAYED_QUALIFIER__IMM_RESET = eINSTANCE.getTimeDelayedQualifier_ImmReset();

    /**
     * The meta object literal for the '<em><b>Strong Reset</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute TIME_DELAYED_QUALIFIER__STRONG_RESET = eINSTANCE.getTimeDelayedQualifier_StrongReset();

    /**
     * The meta object literal for the '<em><b>Reset Clock</b></em>' reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference TIME_DELAYED_QUALIFIER__RESET_CLOCK = eINSTANCE.getTimeDelayedQualifier_ResetClock();

    /**
     * The meta object literal for the '{@link fr.supelec.tesl.lang.tesl.impl.LetImpl <em>Let</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see fr.supelec.tesl.lang.tesl.impl.LetImpl
     * @see fr.supelec.tesl.lang.tesl.impl.TeslPackageImpl#getLet()
     * @generated
     */
    EClass LET = eINSTANCE.getLet();

    /**
     * The meta object literal for the '<em><b>Type</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute LET__TYPE = eINSTANCE.getLet_Type();

    /**
     * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute LET__NAME = eINSTANCE.getLet_Name();

    /**
     * The meta object literal for the '<em><b>Value</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference LET__VALUE = eINSTANCE.getLet_Value();

    /**
     * The meta object literal for the '{@link fr.supelec.tesl.lang.tesl.impl.ValueImpl <em>Value</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see fr.supelec.tesl.lang.tesl.impl.ValueImpl
     * @see fr.supelec.tesl.lang.tesl.impl.TeslPackageImpl#getValue()
     * @generated
     */
    EClass VALUE = eINSTANCE.getValue();

    /**
     * The meta object literal for the '{@link fr.supelec.tesl.lang.tesl.impl.IntegerValueImpl <em>Integer Value</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see fr.supelec.tesl.lang.tesl.impl.IntegerValueImpl
     * @see fr.supelec.tesl.lang.tesl.impl.TeslPackageImpl#getIntegerValue()
     * @generated
     */
    EClass INTEGER_VALUE = eINSTANCE.getIntegerValue();

    /**
     * The meta object literal for the '<em><b>Sign</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute INTEGER_VALUE__SIGN = eINSTANCE.getIntegerValue_Sign();

    /**
     * The meta object literal for the '<em><b>Value</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute INTEGER_VALUE__VALUE = eINSTANCE.getIntegerValue_Value();

    /**
     * The meta object literal for the '{@link fr.supelec.tesl.lang.tesl.impl.DecimalValueImpl <em>Decimal Value</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see fr.supelec.tesl.lang.tesl.impl.DecimalValueImpl
     * @see fr.supelec.tesl.lang.tesl.impl.TeslPackageImpl#getDecimalValue()
     * @generated
     */
    EClass DECIMAL_VALUE = eINSTANCE.getDecimalValue();

    /**
     * The meta object literal for the '<em><b>Sign</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute DECIMAL_VALUE__SIGN = eINSTANCE.getDecimalValue_Sign();

    /**
     * The meta object literal for the '<em><b>Value</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute DECIMAL_VALUE__VALUE = eINSTANCE.getDecimalValue_Value();

    /**
     * The meta object literal for the '{@link fr.supelec.tesl.lang.tesl.impl.FloatValueImpl <em>Float Value</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see fr.supelec.tesl.lang.tesl.impl.FloatValueImpl
     * @see fr.supelec.tesl.lang.tesl.impl.TeslPackageImpl#getFloatValue()
     * @generated
     */
    EClass FLOAT_VALUE = eINSTANCE.getFloatValue();

    /**
     * The meta object literal for the '<em><b>Sign</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute FLOAT_VALUE__SIGN = eINSTANCE.getFloatValue_Sign();

    /**
     * The meta object literal for the '<em><b>Value</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute FLOAT_VALUE__VALUE = eINSTANCE.getFloatValue_Value();

    /**
     * The meta object literal for the '{@link fr.supelec.tesl.lang.tesl.impl.RationalValueImpl <em>Rational Value</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see fr.supelec.tesl.lang.tesl.impl.RationalValueImpl
     * @see fr.supelec.tesl.lang.tesl.impl.TeslPackageImpl#getRationalValue()
     * @generated
     */
    EClass RATIONAL_VALUE = eINSTANCE.getRationalValue();

    /**
     * The meta object literal for the '<em><b>Sign</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute RATIONAL_VALUE__SIGN = eINSTANCE.getRationalValue_Sign();

    /**
     * The meta object literal for the '<em><b>Value</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute RATIONAL_VALUE__VALUE = eINSTANCE.getRationalValue_Value();

    /**
     * The meta object literal for the '{@link fr.supelec.tesl.lang.tesl.impl.LetValueImpl <em>Let Value</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see fr.supelec.tesl.lang.tesl.impl.LetValueImpl
     * @see fr.supelec.tesl.lang.tesl.impl.TeslPackageImpl#getLetValue()
     * @generated
     */
    EClass LET_VALUE = eINSTANCE.getLetValue();

    /**
     * The meta object literal for the '<em><b>Ref</b></em>' reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference LET_VALUE__REF = eINSTANCE.getLetValue_Ref();

    /**
     * The meta object literal for the '{@link fr.supelec.tesl.lang.tesl.impl.ExpressionImpl <em>Expression</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see fr.supelec.tesl.lang.tesl.impl.ExpressionImpl
     * @see fr.supelec.tesl.lang.tesl.impl.TeslPackageImpl#getExpression()
     * @generated
     */
    EClass EXPRESSION = eINSTANCE.getExpression();

    /**
     * The meta object literal for the '{@link fr.supelec.tesl.lang.tesl.impl.CastImpl <em>Cast</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see fr.supelec.tesl.lang.tesl.impl.CastImpl
     * @see fr.supelec.tesl.lang.tesl.impl.TeslPackageImpl#getCast()
     * @generated
     */
    EClass CAST = eINSTANCE.getCast();

    /**
     * The meta object literal for the '<em><b>Expr</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference CAST__EXPR = eINSTANCE.getCast_Expr();

    /**
     * The meta object literal for the '{@link fr.supelec.tesl.lang.tesl.impl.IntCastImpl <em>Int Cast</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see fr.supelec.tesl.lang.tesl.impl.IntCastImpl
     * @see fr.supelec.tesl.lang.tesl.impl.TeslPackageImpl#getIntCast()
     * @generated
     */
    EClass INT_CAST = eINSTANCE.getIntCast();

    /**
     * The meta object literal for the '{@link fr.supelec.tesl.lang.tesl.impl.FloatCastImpl <em>Float Cast</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see fr.supelec.tesl.lang.tesl.impl.FloatCastImpl
     * @see fr.supelec.tesl.lang.tesl.impl.TeslPackageImpl#getFloatCast()
     * @generated
     */
    EClass FLOAT_CAST = eINSTANCE.getFloatCast();

    /**
     * The meta object literal for the '{@link fr.supelec.tesl.lang.tesl.impl.DecimalCastImpl <em>Decimal Cast</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see fr.supelec.tesl.lang.tesl.impl.DecimalCastImpl
     * @see fr.supelec.tesl.lang.tesl.impl.TeslPackageImpl#getDecimalCast()
     * @generated
     */
    EClass DECIMAL_CAST = eINSTANCE.getDecimalCast();

    /**
     * The meta object literal for the '{@link fr.supelec.tesl.lang.tesl.impl.RationalCastImpl <em>Rational Cast</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see fr.supelec.tesl.lang.tesl.impl.RationalCastImpl
     * @see fr.supelec.tesl.lang.tesl.impl.TeslPackageImpl#getRationalCast()
     * @generated
     */
    EClass RATIONAL_CAST = eINSTANCE.getRationalCast();

    /**
     * The meta object literal for the '{@link fr.supelec.tesl.lang.tesl.impl.WhenQualifierImpl <em>When Qualifier</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see fr.supelec.tesl.lang.tesl.impl.WhenQualifierImpl
     * @see fr.supelec.tesl.lang.tesl.impl.TeslPackageImpl#getWhenQualifier()
     * @generated
     */
    EClass WHEN_QUALIFIER = eINSTANCE.getWhenQualifier();

    /**
     * The meta object literal for the '<em><b>Not</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute WHEN_QUALIFIER__NOT = eINSTANCE.getWhenQualifier_Not();

    /**
     * The meta object literal for the '<em><b>Clock</b></em>' reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference WHEN_QUALIFIER__CLOCK = eINSTANCE.getWhenQualifier_Clock();

    /**
     * The meta object literal for the '{@link fr.supelec.tesl.lang.tesl.impl.NextQualifierImpl <em>Next Qualifier</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see fr.supelec.tesl.lang.tesl.impl.NextQualifierImpl
     * @see fr.supelec.tesl.lang.tesl.impl.TeslPackageImpl#getNextQualifier()
     * @generated
     */
    EClass NEXT_QUALIFIER = eINSTANCE.getNextQualifier();

    /**
     * The meta object literal for the '<em><b>Strict</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute NEXT_QUALIFIER__STRICT = eINSTANCE.getNextQualifier_Strict();

    /**
     * The meta object literal for the '<em><b>Clock</b></em>' reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference NEXT_QUALIFIER__CLOCK = eINSTANCE.getNextQualifier_Clock();

    /**
     * The meta object literal for the '{@link fr.supelec.tesl.lang.tesl.impl.PatternImpl <em>Pattern</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see fr.supelec.tesl.lang.tesl.impl.PatternImpl
     * @see fr.supelec.tesl.lang.tesl.impl.TeslPackageImpl#getPattern()
     * @generated
     */
    EClass PATTERN = eINSTANCE.getPattern();

    /**
     * The meta object literal for the '<em><b>Skip</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference PATTERN__SKIP = eINSTANCE.getPattern_Skip();

    /**
     * The meta object literal for the '<em><b>Keep</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference PATTERN__KEEP = eINSTANCE.getPattern_Keep();

    /**
     * The meta object literal for the '<em><b>Rep</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute PATTERN__REP = eINSTANCE.getPattern_Rep();

    /**
     * The meta object literal for the '<em><b>Repskip</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference PATTERN__REPSKIP = eINSTANCE.getPattern_Repskip();

    /**
     * The meta object literal for the '<em><b>Repkeep</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference PATTERN__REPKEEP = eINSTANCE.getPattern_Repkeep();

    /**
     * The meta object literal for the '{@link fr.supelec.tesl.lang.tesl.impl.TagRelationImpl <em>Tag Relation</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see fr.supelec.tesl.lang.tesl.impl.TagRelationImpl
     * @see fr.supelec.tesl.lang.tesl.impl.TeslPackageImpl#getTagRelation()
     * @generated
     */
    EClass TAG_RELATION = eINSTANCE.getTagRelation();

    /**
     * The meta object literal for the '<em><b>Expr</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference TAG_RELATION__EXPR = eINSTANCE.getTagRelation_Expr();

    /**
     * The meta object literal for the '{@link fr.supelec.tesl.lang.tesl.impl.TagExprImpl <em>Tag Expr</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see fr.supelec.tesl.lang.tesl.impl.TagExprImpl
     * @see fr.supelec.tesl.lang.tesl.impl.TeslPackageImpl#getTagExpr()
     * @generated
     */
    EClass TAG_EXPR = eINSTANCE.getTagExpr();

    /**
     * The meta object literal for the '<em><b>Clock Y</b></em>' reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference TAG_EXPR__CLOCK_Y = eINSTANCE.getTagExpr_ClockY();

    /**
     * The meta object literal for the '<em><b>Value A</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference TAG_EXPR__VALUE_A = eINSTANCE.getTagExpr_ValueA();

    /**
     * The meta object literal for the '<em><b>Clock X</b></em>' reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference TAG_EXPR__CLOCK_X = eINSTANCE.getTagExpr_ClockX();

    /**
     * The meta object literal for the '<em><b>Value N</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference TAG_EXPR__VALUE_N = eINSTANCE.getTagExpr_ValueN();

    /**
     * The meta object literal for the '<em><b>Value B</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference TAG_EXPR__VALUE_B = eINSTANCE.getTagExpr_ValueB();

    /**
     * The meta object literal for the '{@link fr.supelec.tesl.lang.tesl.impl.PragmaImpl <em>Pragma</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see fr.supelec.tesl.lang.tesl.impl.PragmaImpl
     * @see fr.supelec.tesl.lang.tesl.impl.TeslPackageImpl#getPragma()
     * @generated
     */
    EClass PRAGMA = eINSTANCE.getPragma();

    /**
     * The meta object literal for the '{@link fr.supelec.tesl.lang.tesl.impl.StopPragmaImpl <em>Stop Pragma</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see fr.supelec.tesl.lang.tesl.impl.StopPragmaImpl
     * @see fr.supelec.tesl.lang.tesl.impl.TeslPackageImpl#getStopPragma()
     * @generated
     */
    EClass STOP_PRAGMA = eINSTANCE.getStopPragma();

    /**
     * The meta object literal for the '<em><b>Clock</b></em>' reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference STOP_PRAGMA__CLOCK = eINSTANCE.getStopPragma_Clock();

    /**
     * The meta object literal for the '{@link fr.supelec.tesl.lang.tesl.impl.TagrefPragmaImpl <em>Tagref Pragma</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see fr.supelec.tesl.lang.tesl.impl.TagrefPragmaImpl
     * @see fr.supelec.tesl.lang.tesl.impl.TeslPackageImpl#getTagrefPragma()
     * @generated
     */
    EClass TAGREF_PRAGMA = eINSTANCE.getTagrefPragma();

    /**
     * The meta object literal for the '<em><b>Clock</b></em>' reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference TAGREF_PRAGMA__CLOCK = eINSTANCE.getTagrefPragma_Clock();

    /**
     * The meta object literal for the '{@link fr.supelec.tesl.lang.tesl.impl.TracePragmaImpl <em>Trace Pragma</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see fr.supelec.tesl.lang.tesl.impl.TracePragmaImpl
     * @see fr.supelec.tesl.lang.tesl.impl.TeslPackageImpl#getTracePragma()
     * @generated
     */
    EClass TRACE_PRAGMA = eINSTANCE.getTracePragma();

    /**
     * The meta object literal for the '<em><b>Kinds</b></em>' attribute list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute TRACE_PRAGMA__KINDS = eINSTANCE.getTracePragma_Kinds();

    /**
     * The meta object literal for the '{@link fr.supelec.tesl.lang.tesl.impl.MaxstepPragmaImpl <em>Maxstep Pragma</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see fr.supelec.tesl.lang.tesl.impl.MaxstepPragmaImpl
     * @see fr.supelec.tesl.lang.tesl.impl.TeslPackageImpl#getMaxstepPragma()
     * @generated
     */
    EClass MAXSTEP_PRAGMA = eINSTANCE.getMaxstepPragma();

    /**
     * The meta object literal for the '<em><b>Value</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference MAXSTEP_PRAGMA__VALUE = eINSTANCE.getMaxstepPragma_Value();

    /**
     * The meta object literal for the '{@link fr.supelec.tesl.lang.tesl.impl.OutputPragmaImpl <em>Output Pragma</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see fr.supelec.tesl.lang.tesl.impl.OutputPragmaImpl
     * @see fr.supelec.tesl.lang.tesl.impl.TeslPackageImpl#getOutputPragma()
     * @generated
     */
    EClass OUTPUT_PRAGMA = eINSTANCE.getOutputPragma();

    /**
     * The meta object literal for the '<em><b>Type</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute OUTPUT_PRAGMA__TYPE = eINSTANCE.getOutputPragma_Type();

    /**
     * The meta object literal for the '<em><b>Selection</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute OUTPUT_PRAGMA__SELECTION = eINSTANCE.getOutputPragma_Selection();

    /**
     * The meta object literal for the '<em><b>Selected Clocks</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference OUTPUT_PRAGMA__SELECTED_CLOCKS = eINSTANCE.getOutputPragma_SelectedClocks();

    /**
     * The meta object literal for the '<em><b>Window</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute OUTPUT_PRAGMA__WINDOW = eINSTANCE.getOutputPragma_Window();

    /**
     * The meta object literal for the '<em><b>From</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference OUTPUT_PRAGMA__FROM = eINSTANCE.getOutputPragma_From();

    /**
     * The meta object literal for the '<em><b>To</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference OUTPUT_PRAGMA__TO = eINSTANCE.getOutputPragma_To();

    /**
     * The meta object literal for the '<em><b>Labelif</b></em>' reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference OUTPUT_PRAGMA__LABELIF = eINSTANCE.getOutputPragma_Labelif();

    /**
     * The meta object literal for the '<em><b>Xscaled</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute OUTPUT_PRAGMA__XSCALED = eINSTANCE.getOutputPragma_Xscaled();

    /**
     * The meta object literal for the '<em><b>Xscale</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference OUTPUT_PRAGMA__XSCALE = eINSTANCE.getOutputPragma_Xscale();

    /**
     * The meta object literal for the '<em><b>Border</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute OUTPUT_PRAGMA__BORDER = eINSTANCE.getOutputPragma_Border();

    /**
     * The meta object literal for the '<em><b>Css</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute OUTPUT_PRAGMA__CSS = eINSTANCE.getOutputPragma_Css();

    /**
     * The meta object literal for the '<em><b>Nodefcss</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute OUTPUT_PRAGMA__NODEFCSS = eINSTANCE.getOutputPragma_Nodefcss();

    /**
     * The meta object literal for the '<em><b>Jvs</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute OUTPUT_PRAGMA__JVS = eINSTANCE.getOutputPragma_Jvs();

    /**
     * The meta object literal for the '<em><b>Standalone</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute OUTPUT_PRAGMA__STANDALONE = eINSTANCE.getOutputPragma_Standalone();

    /**
     * The meta object literal for the '<em><b>Overwrite</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute OUTPUT_PRAGMA__OVERWRITE = eINSTANCE.getOutputPragma_Overwrite();

    /**
     * The meta object literal for the '{@link fr.supelec.tesl.lang.tesl.impl.ClockItemImpl <em>Clock Item</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see fr.supelec.tesl.lang.tesl.impl.ClockItemImpl
     * @see fr.supelec.tesl.lang.tesl.impl.TeslPackageImpl#getClockItem()
     * @generated
     */
    EClass CLOCK_ITEM = eINSTANCE.getClockItem();

    /**
     * The meta object literal for the '<em><b>Clock</b></em>' reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference CLOCK_ITEM__CLOCK = eINSTANCE.getClockItem_Clock();

    /**
     * The meta object literal for the '<em><b>New Name</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute CLOCK_ITEM__NEW_NAME = eINSTANCE.getClockItem_NewName();

    /**
     * The meta object literal for the '{@link fr.supelec.tesl.lang.tesl.impl.DoubleCalcPragmaImpl <em>Double Calc Pragma</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see fr.supelec.tesl.lang.tesl.impl.DoubleCalcPragmaImpl
     * @see fr.supelec.tesl.lang.tesl.impl.TeslPackageImpl#getDoubleCalcPragma()
     * @generated
     */
    EClass DOUBLE_CALC_PRAGMA = eINSTANCE.getDoubleCalcPragma();

    /**
     * The meta object literal for the '<em><b>Num digits</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute DOUBLE_CALC_PRAGMA__NUM_DIGITS = eINSTANCE.getDoubleCalcPragma_Num_digits();

    /**
     * The meta object literal for the '<em><b>Round</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute DOUBLE_CALC_PRAGMA__ROUND = eINSTANCE.getDoubleCalcPragma_Round();

    /**
     * The meta object literal for the '<em><b>Rounding mode</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute DOUBLE_CALC_PRAGMA__ROUNDING_MODE = eINSTANCE.getDoubleCalcPragma_Rounding_mode();

    /**
     * The meta object literal for the '{@link fr.supelec.tesl.lang.tesl.impl.DumpResultPragmaImpl <em>Dump Result Pragma</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see fr.supelec.tesl.lang.tesl.impl.DumpResultPragmaImpl
     * @see fr.supelec.tesl.lang.tesl.impl.TeslPackageImpl#getDumpResultPragma()
     * @generated
     */
    EClass DUMP_RESULT_PRAGMA = eINSTANCE.getDumpResultPragma();

    /**
     * The meta object literal for the '{@link fr.supelec.tesl.lang.tesl.impl.BinOpImpl <em>Bin Op</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see fr.supelec.tesl.lang.tesl.impl.BinOpImpl
     * @see fr.supelec.tesl.lang.tesl.impl.TeslPackageImpl#getBinOp()
     * @generated
     */
    EClass BIN_OP = eINSTANCE.getBinOp();

    /**
     * The meta object literal for the '<em><b>Left</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference BIN_OP__LEFT = eINSTANCE.getBinOp_Left();

    /**
     * The meta object literal for the '<em><b>Op</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute BIN_OP__OP = eINSTANCE.getBinOp_Op();

    /**
     * The meta object literal for the '<em><b>Right</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference BIN_OP__RIGHT = eINSTANCE.getBinOp_Right();

    /**
     * The meta object literal for the '{@link fr.supelec.tesl.lang.tesl.Type <em>Type</em>}' enum.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see fr.supelec.tesl.lang.tesl.Type
     * @see fr.supelec.tesl.lang.tesl.impl.TeslPackageImpl#getType()
     * @generated
     */
    EEnum TYPE = eINSTANCE.getType();

    /**
     * The meta object literal for the '{@link fr.supelec.tesl.lang.tesl.ValueType <em>Value Type</em>}' enum.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see fr.supelec.tesl.lang.tesl.ValueType
     * @see fr.supelec.tesl.lang.tesl.impl.TeslPackageImpl#getValueType()
     * @generated
     */
    EEnum VALUE_TYPE = eINSTANCE.getValueType();

    /**
     * The meta object literal for the '{@link fr.supelec.tesl.lang.tesl.Op <em>Op</em>}' enum.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see fr.supelec.tesl.lang.tesl.Op
     * @see fr.supelec.tesl.lang.tesl.impl.TeslPackageImpl#getOp()
     * @generated
     */
    EEnum OP = eINSTANCE.getOp();

    /**
     * The meta object literal for the '{@link fr.supelec.tesl.lang.tesl.ROUNDING_MODE <em>ROUNDING MODE</em>}' enum.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see fr.supelec.tesl.lang.tesl.ROUNDING_MODE
     * @see fr.supelec.tesl.lang.tesl.impl.TeslPackageImpl#getROUNDING_MODE()
     * @generated
     */
    EEnum ROUNDING_MODE = eINSTANCE.getROUNDING_MODE();

  }

} //TeslPackage
