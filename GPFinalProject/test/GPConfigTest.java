import static org.junit.Assert.*;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import GPFinalProject.Config;

public class GPConfigTest {
	private static Config _config;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {	
		_config = new Config();
		_config.initializeData("test/GP_Config.txt", "=");
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		_config = null;
	}

	@Test
	public void testGetMaxGenerationCount() {
		assertEquals(3, _config.getMaxGenerationCount(), 0.0001);
	}

	@Test
	public void testGetInitialPopulationSize() {
		assertEquals(50, _config.getInitialPopulationSize(), 0.0001);
	}

	@Test
	public void testGetMaxInitialDepth() {
		assertEquals(2, _config.getMaxInitialDepth());
	}

	@Test
	public void testGetListOfTrainingData() {
		assertEquals(5, _config.getListOfTrainingData());
	}

	@Test
	public void testGetMutationRate() {
		double rate = 3.6;
		assertEquals(rate, _config.getMutationRate(), 0.001);
	}

	@Test
	public void testGetMutationHighProbabilityCrossPoint() {
		assertEquals(95, _config.getMutationHighProbabilityCrossPoint(), 0.0001);
	}

	@Test
	public void testGetMutationHighProbabilityRate() {
		double rate = 2.5;
		assertEquals(rate, _config.getMutationHighProbabilityRate(), 0.0001);
	}

	@Test
	public void testGetCrossOverRate() {
		double rate = 3.2;
		assertEquals(rate, _config.getCrossOverRate(), 0.0001);
	}

	@Test
	public void testGetCrossOverHighProbabilityPoint() {
		assertEquals(55, _config.getCrossOverHighProbabilityPoint(), 0.0001);
	}

	@Test
	public void testGetCrossOverHighProbabilityRate() {
		assertEquals(3.5, _config.getCrossOverHighProbabilityRate(), 0.0001);
	}

	@Test
	public void testGetNaturalSelectionRate() {
		assertEquals(3.8, _config.getNaturalSelectionRate(), 0.0001);
	}

	@Test
	public void testGetNaturalSelectionProbabilityCrossOverPoint() {
		assertEquals(25, _config.getNaturalSelectionProbabilityCrossOverPoint(), 0.0001);
	}

	@Test
	public void testGetNaturalSelectionProbabilityCrossOverRate() {
		double rate = 2.8;
		assertEquals(rate, _config.getNaturalSelectionProbabilityCrossOverRate(), 0.0001);
	}

	@Test
	public void testGetOperatorProbability() {
		assertEquals(6, _config.getOperatorProbability(), 0.0001);
	}

	@Test
	public void testGetVariableXProbability() {
		assertEquals(1, _config.getVariableXProbability(), 0.0001);
	}

	@Test
	public void testGetConstantMinimumValue() {
		assertEquals(13, _config.getConstantMinimumValue(), 0.0001);
	}

	@Test
	public void testGetConstantMaximumValue() {
		assertEquals(-1, _config.getConstantMaximumValue(), 0.0001);
	}

	@Test
	public void testGetGeneticModel() {
		assertEquals("(X+1)/2", _config.getGeneticModel());
	}

	@Test
	public void testGetTimeLimitation() {
		assertEquals(1500, _config.getTimeLimitation(), 0.0001);
	}
}