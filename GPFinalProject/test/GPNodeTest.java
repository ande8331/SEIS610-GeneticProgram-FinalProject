import static org.junit.Assert.*;

import org.junit.Test;

import GPFinalProject.GPNode;
import GPFinalProject.GPNodeOperator;
import GPFinalProject.GPNodeValue;


public class GPNodeTest {

	@Test
	public void testGPNode() {
		fail("Not yet implemented");
	}

	@Test
	// GP-TST-12
	public void testEvaluateFitnessValue() {
		GPNodeValue leftleft = new GPNodeValue(1);
		GPNodeValue leftright = new GPNodeValue(2);
		GPNodeOperator left = new GPNodeOperator("+", leftleft, leftright);
		
		GPNodeValue rightleft = new GPNodeValue(3);
		GPNodeValue rightright = new GPNodeValue(4);
		GPNodeOperator right = new GPNodeOperator("*", rightleft, rightright);
		
		GPNodeOperator topleft = new GPNodeOperator("+", left, right);
		
		GPNodeValue leftleftleft = new GPNodeValue("X");
		GPNodeValue leftleftright = new GPNodeValue(2);
		GPNodeOperator topright = new GPNodeOperator("/", leftleftleft, leftleftright);
		
		GPNodeOperator top = new GPNodeOperator("-", topleft, topright);
		
		double result = top.EvaluateFitnessValue(2);
		assertEquals("Evaluate (1+2) + (3*4) - (X/2) when X=2:", 14, result, 0.0001);
		
		result = top.EvaluateFitnessValue(4);
		assertEquals("Evaluate (1+2) + (3*4) - (X/2) when X=4:", 13, result, 0.0001);
		
		result = top.EvaluateFitnessValue(100);
		assertEquals("Evaluate (1+2) + (3*4) - (X/2) when X100:", -35, result, 0.0001);
	}

	@Test
	// GP-TST-8
	public void testGetGPDepth() {
		GPNodeValue left1 = new GPNodeValue(-10);
		GPNodeValue right1 = new GPNodeValue(7);
		GPNodeOperator top1 = new GPNodeOperator("+", left1, right1);
		assertEquals("Test tree that is a depth of 1.", 1, top1.GetGPDepth());
		
		GPNodeValue left2 = new GPNodeValue("X");
		GPNodeOperator top2 = new GPNodeOperator("*", left2, top1);
		assertEquals("Test tree that is a depth of 2.", 2, top2.GetGPDepth());
		
		GPNodeValue right2 = new GPNodeValue(9);
		GPNodeOperator top3 = new GPNodeOperator("/", top2, right2);
		assertEquals("Test tree that is a depth of 3.", 3, top3.GetGPDepth());
	}
	
	@Test
	// GP-TST-8
	public void testTreeMaxDepth() {
		GPNode temp;
		int maxDepth = 10;
		GPNode.maximum_tree_depth = 10;
		for (int i = 0; i < 1000; i++)
		{
			temp = GPNode.generateNode();
			
			if (temp.GetGPDepth() > 10)
			{
				fail("GPNode depth exceeded maximum configured value of: " + maxDepth + " Depth found: " + temp.GetGPDepth());
			}
		}
	}

	@Test
	// GP-TST-11
	public void testFirstNodeIsOperator() {
	
		GPNode temp;
		for (int i = 0; i < 1000; i ++)
		{
			temp = GPNode.generateNode();
			if (GPNode.class.equals(temp))
			{
				fail("Non-operator first node detected.");
			}
		}
	}
	
	@Test
	public void testGetGPNodeCount() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetGPString() {
		fail("Not yet implemented");
	}

	@Test
	public void testFindNodeReferenceById() {
		fail("Not yet implemented");
	}

	@Test
	public void testGenerateNode() {
		fail("Not yet implemented");
	}

	@Test
	public void testCrossoverNodes() {
		fail("Not yet implemented");
	}

	@Test
	public void testMutateNodes() {
		fail("Not yet implemented");
	}

}

