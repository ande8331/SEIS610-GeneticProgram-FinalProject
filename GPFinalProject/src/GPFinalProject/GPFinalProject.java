package GPFinalProject;

import java.util.ArrayList;

public class GPFinalProject
{

	/**
	 * @param args
	 */

	public static void main(String[] args)
	{
		// TODO Auto-generated method stub

		ArrayList<GPNode> gpCandidates = new ArrayList<GPNode>();

		int numCandidates = 500;

		/* Create the candidates */
		for ( int i = 0; i < numCandidates; i++ )
		{
			gpCandidates.add(GPNode.generateNode());
		}

		/* Print them to console */
		for ( int i = 0; i < numCandidates; i++ )
		{
			System.out.println(i + ":" + gpCandidates.get(i).GetGPString() );
		}

		/* Cross them over in order (just a robustness test, how this works to be changed later)*/
		for ( int i = 0; i < numCandidates; i+=2 )
		{
			GPNode.crossOver(gpCandidates.get(i), gpCandidates.get(i+1));
		}

		/* Print crossed over candidates to console */
		for ( int i = 0; i < numCandidates; i++ )
		{
			System.out.println(i + ":" + gpCandidates.get(i).GetGPString() );
		}

		/* Mutate them (just a robustness test, how this works to be changed later)*/
		for ( int i = 0; i < numCandidates; i++ )
		{
			GPNode.mutate(gpCandidates.get(i));
		}

		/* Print mutated candidates to console */
		for ( int i = 0; i < numCandidates; i++ )
		{
			System.out.println(i + ":" + gpCandidates.get(i).GetGPString() );
		}

		/* Evaluation their fitness for a single value (just a demonstration on how to do it, to be changed later) */
		for ( int i = 0; i < numCandidates; i++ )
		{
			System.out.println(i + ":" + gpCandidates.get(i).EvaluateFitnessValue(20));
		}





/*		
//		Code to manually generate a tree
		GPNodeValue leftBranchLeftValue = new GPNodeValue(5.0);
		GPNodeValue leftBranchRightValue = new GPNodeValue(-7.0);
		GPNodeOperator leftBranch = new GPNodeOperator("/", leftBranchLeftValue, leftBranchRightValue);
		GPNodeValue rightBranchLeftValue = new GPNodeValue("X");
		GPNodeValue rightBranchRightValue = new GPNodeValue(9);
		GPNodeOperator rightBranch = new GPNodeOperator("-", rightBranchLeftValue, rightBranchRightValue);
		GPNodeOperator treeTop = new GPNodeOperator("+", leftBranch, rightBranch);
*/
/*
		// Setup some trees and test the crossover/mutate on them
		GPNode treeTop = GPNode.generateNode();
		
		System.out.println("Depth: " + treeTop.GetGPDepth());
		System.out.println("Node Count: " + treeTop.GetGPNodeCount());
		System.out.println("Print String: " + treeTop.GetGPString());
		System.out.println("Evaluated for X=20: " + treeTop.EvaluateFitnessValue(20));
		GPNode treeTop2 = GPNode.generateNode();
*/      
		/*
		GPNode g1 = treeTop.FindNodeReferenceById(0, treeTop.GetGPNodeCount() >> 1);
		System.out.println(treeTop.GetGPNodeCount() >> 1);
		System.out.println("Found node: " + g1.GetGPString());
		*/


/*		
		// Test Crossover and mutate
		System.out.println("*** Crossover Strings Below ***");
		System.out.println("Print String: " + treeTop.GetGPString());
		System.out.println("Print String: " + treeTop2.GetGPString());		
		GPNode.crossOver(treeTop, treeTop2);		
		System.out.println("Print String: " + treeTop.GetGPString());
		System.out.println("Print String: " + treeTop2.GetGPString());	
		
		
		System.out.println("*** Mutate String Below ***");
		System.out.println("Print String: " + treeTop.GetGPString());
		GPNode.mutate(treeTop);
		System.out.println("Depth: " + treeTop.GetGPDepth());
		System.out.println("Node Count: " + treeTop.GetGPNodeCount());
		System.out.println("Print String: " + treeTop.GetGPString());
*/      
/*		
//		Checkout for the random number generator
		for (int i = 0; i < 20; i++)
		{
			System.out.println(Utilities.GetRandomNumber(6, 14));
		}
*/      
	}

}
