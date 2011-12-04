package GPFinalProject;

import static org.junit.Assert.*;
import org.junit.Test;

public class GPNodeOperatorTest {

	@Test
	// GP-TST-16
	public void testDivideByZero() {
		GPNodeValue left = new GPNodeValue(5);
		GPNodeValue right = new GPNodeValue(0);
		GPNodeOperator top = new GPNodeOperator("/", left, right);
		assertEquals("Result of against 5 divide by 0", Double.MAX_VALUE, top.evaluateFitnessValue(-5), .01);
	}

	@Test 
	// GP-TST-2
	// GP-TST-3
	// GP-TST-4
	// GP-TST-5
	public void GPNodeOperator() {
		GPNodeValue left = new GPNodeValue(-10);
		GPNodeValue right = new GPNodeValue(7);
		GPNodeOperator top = new GPNodeOperator("+", left, right);
		assertEquals("Result creating plus node with -10 and 7", -3, top.evaluateFitnessValue(-5), .01);

		top = new GPNodeOperator("-", left, right);
		assertEquals("Result creating minus node with -10 and 7", -17, top.evaluateFitnessValue(-5), .01);

		top = new GPNodeOperator("*", left, right);
		assertEquals("Result creating multiply node with -10 and 7", -70, top.evaluateFitnessValue(-5), .01);
		
		top = new GPNodeOperator("/", left, right);
		assertEquals("Result creating divide node with -10 and 7", -1.42857143, top.evaluateFitnessValue(-5), .01);
	}
}
