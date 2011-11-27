import static org.junit.Assert.*;

import org.junit.Test;

import GPFinalProject.GPNode;
import GPFinalProject.GPNodeOperator;
import GPFinalProject.GPNodeValue;


public class GPNodeTest {
	@Test
	// GP-TST-13
	// GP-TST-14
	// GP-TST-15
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
	public void testMutation() {
		System.out.println("***Begin Test Mutation***");
		GPNodeValue left1 = new GPNodeValue(1);
		GPNodeValue right1 = new GPNodeValue(2);
		GPNodeOperator top1 = new GPNodeOperator("+", left1, right1);
		
		GPNodeValue left2 = new GPNodeValue(3);
		GPNodeValue right2 = new GPNodeValue(4);
		GPNodeOperator top2 = new GPNodeOperator("*", left2, right2);
		
		GPNodeOperator freeloader = new GPNodeOperator("-", top1, top2);
		
		System.out.println("Before Mutation:" + freeloader.GetGPString());
		GPNode.mutateNodes(freeloader);
		System.out.println("After Mutation :" + freeloader.GetGPString());
		
		System.out.println("***End Test Mutation***");
	}

	@Test
	public void testCrossover() {
		System.out.println("\n***Begin Test Crossover***");
		GPNodeValue left1 = new GPNodeValue("X");
		GPNodeValue right1 = new GPNodeValue("X");
		GPNodeOperator top1 = new GPNodeOperator("+", left1, right1);
		
		GPNodeValue left2 = new GPNodeValue(5);
		GPNodeValue right2 = new GPNodeValue(6);
		GPNodeOperator top2 = new GPNodeOperator("-", left2, right2);
		GPNodeOperator freeloader = new GPNodeOperator("/", top1, top2);
		
		GPNodeValue left1a = new GPNodeValue(1);
		GPNodeValue right1a = new GPNodeValue(2);
		GPNodeOperator top1a = new GPNodeOperator("*", left1a, right1a);
		
		GPNodeValue left2a = new GPNodeValue(8);
		GPNodeValue right2a = new GPNodeValue(9);
		GPNodeOperator top2a = new GPNodeOperator("/", left2a, right2a);
		GPNodeOperator useless = new GPNodeOperator("+", top1a, top2a);
		
		
		System.out.println("Tree 1 Before Crossover:" + freeloader.GetGPString());
		System.out.println("Tree 2 Before Crossover:" + useless.GetGPString());
		GPNode.crossoverNodes(freeloader, useless);
		System.out.println("Tree 1 After Crossover: " + freeloader.GetGPString());
		System.out.println("Tree 2 After Crossover: " + useless.GetGPString());
		
		System.out.println("***End Test Crossover***");
	}

}

