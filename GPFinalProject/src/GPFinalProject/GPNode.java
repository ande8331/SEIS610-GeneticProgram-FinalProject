package GPFinalProject;

public class GPNode
{
	public static int operator_probability = 15;
	public static int operand_x_probability = 90;
	public static int random_value_minimum = 0;
	public static int random_value_maximum = 26;
	public static int maximum_tree_depth = 2;
	
	public GPNode()
	{
	}

	public double EvaluateFitnessValue(double x)
	{
		return(1.0);
	}

	public int GetGPDepth()
	{
		return(-1);
	}

	public int GetGPNodeCount()
	{
		return(-1);
	}

	public String GetGPString()
	{
		return("Error creating string.");
	}

	public GPNode FindNodeReferenceById(int searchID, int currentCount)
	{
		return(null);
	}

	final static private String operators = "+-/*";
	public static GPNode generateNode()
	{
		return(generateNode(0));
	}
	private static GPNode generateNode(int depth)
	{
		int num = Utilities.GetRandomNumber(0, 99);
		// num < 8 to cause 80% probability of an operator, but don't let the tree get more than 6 levels deep
		// Force the first node to always be an operator

		// TODO: Add requirement to make first node an operator
		if ( ((num < operator_probability) && (depth < maximum_tree_depth)) || (depth == 0) )
		{
			GPNode left = generateNode(depth + 1);
			GPNode right = generateNode(depth + 1);
			num = Utilities.GetRandomNumber(0, 3);
			String operator = operators.substring(num,num+1);
			GPNodeOperator myNode = new GPNodeOperator(operator, left, right);
			return(myNode);
		} 
		else
		{
			num = Utilities.GetRandomNumber(0, 99);

			if ( num < operand_x_probability )
			{
				GPNodeValue myNode = new GPNodeValue("X");
				return(myNode);
			} else
			{
				num = Utilities.GetRandomNumber(random_value_minimum, random_value_maximum);
				GPNodeValue myNode = new GPNodeValue(num);
				return(myNode);
			}
		}
	}    
	public static void crossoverNodes(GPNode g1, GPNode g2)
	{
		// Pull random numbers for each to select which node to move
		int g1NodeID = Utilities.GetRandomNumber(1, g1.GetGPNodeCount());
		int g2NodeID = Utilities.GetRandomNumber(1, g2.GetGPNodeCount());

		int g1Counter = 1;
		boolean g1Left = true;
		GPNodeOperator gpOper1 = (GPNodeOperator) g1;
		while ( true )
		{
			if ( g1.getClass() != GPNodeOperator.class )
			{
				/* This shouldn't happen */
				break;
			}
			gpOper1 = (GPNodeOperator) g1;

			if ( g1Counter == g1NodeID )
			{
				g1Left = true;
				break;
			} 
			else if ( gpOper1.GetLeftNode().GetGPNodeCount() + g1Counter == g1NodeID )
			{
				g1Left = false;
				break;
			} 
			else if ( gpOper1.GetLeftNode().GetGPNodeCount() + g1Counter > g1NodeID )
			{
				g1 = gpOper1.GetLeftNode();
				g1Counter++;
			} 
			else
			{
				g1 = gpOper1.GetRightNode();
				g1Counter += gpOper1.GetLeftNode().GetGPNodeCount() + 1;
			}
		}

		int g2Counter = 1;
		boolean g2Left = true;
		GPNodeOperator gpOper2 = (GPNodeOperator) g2;
		while ( true )
		{
			if ( g2.getClass() != GPNodeOperator.class )
			{
				/* This shouldn't happen */
				break;
			}
			gpOper2 = (GPNodeOperator) g2;

			if ( g2Counter == g2NodeID )
			{
				g2Left = true;
				break;
			} 
			else if ( gpOper2.GetLeftNode().GetGPNodeCount() + g2Counter == g2NodeID )
			{
				g2Left = false;
				break;
			} 
			else if ( gpOper2.GetLeftNode().GetGPNodeCount() + g2Counter > g2NodeID )
			{
				g2 = gpOper2.GetLeftNode();
				g2Counter++;
			} 
			else
			{
				g2 = gpOper2.GetRightNode();
				g2Counter += gpOper2.GetLeftNode().GetGPNodeCount() + 1;
			}
		}

		/* Setup the ones we want to swap */
		GPNode g1Tog2 = gpOper1.GetLeftNode();
		if ( g1Left == false )
		{
			g1Tog2 = gpOper1.GetRightNode();
		}

		GPNode g2Tog1 = gpOper2.GetLeftNode();
		if ( g2Left == false )
		{
			g2Tog1 = gpOper2.GetRightNode();
		}


		/* Do the actual swap */
		if ( g1Left == true )
		{
			gpOper1.SetLeftNode(g2Tog1);
		} 
		else
		{
			gpOper1.SetRightNode(g2Tog1);
		}

		if ( g2Left == true )
		{
			gpOper2.SetLeftNode(g1Tog2);
		} 
		else
		{
			gpOper2.SetRightNode(g1Tog2);
		}           
	}
	
	public static void mutateNodes(GPNode g1)
	{
		int g1NodeID = Utilities.GetRandomNumber(1, g1.GetGPNodeCount());

		int g1Counter = 1;
		boolean g1Left = true;
		GPNodeOperator gpOper1 = (GPNodeOperator) g1;
		int g1Depth = 0;

		while ( true )
		{
			if ( g1.getClass() != GPNodeOperator.class )
			{
				/* This shouldn't happen */
				break;
			}
			gpOper1 = (GPNodeOperator) g1;

			if ( g1Counter == g1NodeID )
			{
				g1Left = true;
				break;
			} 
			else if ( gpOper1.GetLeftNode().GetGPNodeCount() + g1Counter == g1NodeID )
			{
				g1Left = false;
				break;
			} 
			else if ( gpOper1.GetLeftNode().GetGPNodeCount() + g1Counter > g1NodeID )
			{
				g1 = gpOper1.GetLeftNode();
				g1Counter++;
				g1Depth++;
			} 
			else
			{
				g1 = gpOper1.GetRightNode();
				g1Counter += gpOper1.GetLeftNode().GetGPNodeCount() + 1;
				g1Depth++;
			}
		}

		GPNode tempNode = generateNode(g1Depth);
		if ( g1Left == true )
		{
			gpOper1.SetLeftNode(tempNode);
		} 
		else
		{
			gpOper1.SetRightNode(tempNode);
		}
	}
}
