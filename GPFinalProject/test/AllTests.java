import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;


@RunWith(Suite.class)
@SuiteClasses({ GPNodeValueTest.class, GPNodeOperatorTest.class, GPConfigTest.class, GPUtilitiesTest.class })
public class AllTests {

}
