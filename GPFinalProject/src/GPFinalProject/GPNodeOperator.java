package GPFinalProject;

public class GPNodeOperator extends GPNode 
{
	protected GPNode m_left;
	protected GPNode m_right;
	protected String m_operator;

	public GPNodeOperator(String operator, GPNode left, GPNode right)
	{
		// TODO Auto-generated constructor stub
		m_operator = operator;
		m_left = left;
		m_right = right;
	}

	public double EvaluateFitnessValue(double x)
	{
		double leftValue = m_left.EvaluateFitnessValue(x);
		double rightValue = m_right.EvaluateFitnessValue(x);
		double output = Double.MAX_VALUE;
		if ( m_operator.equals("+") )
		{
			output = leftValue + rightValue;
		}

		if ( m_operator.equals("-") )
		{
			output = leftValue - rightValue;
		}

		if ( m_operator.equals("*") )
		{
			output = leftValue * rightValue;
		}

		if ( m_operator.equals("/") )
		{
			if ( rightValue != 0.0 )
			{
				output = leftValue / rightValue;
			} 
			else
			{
				output = Double.MAX_VALUE;
			}
		}

		return(output);
	}

	public int GetGPDepth()
	{
		int leftDepth = m_left.GetGPDepth();
		int rightDepth = m_right.GetGPDepth();

		if ( leftDepth > rightDepth )
		{
			return(leftDepth + 1);
		} 
		else
		{
			return(rightDepth + 1);
		}
	}

	public int GetGPNodeCount()
	{
		return(m_left.GetGPNodeCount() + m_right.GetGPNodeCount() + 1);
	}

	public String GetGPString()
	{
		return("( " +  m_left.GetGPString() + " " + m_operator + " " + m_right.GetGPString() + " )");
	}   

	public GPNode GetLeftNode()
	{
		return(m_left);
	}

	public GPNode GetRightNode()
	{
		return(m_right);
	}

	public void SetLeftNode(GPNode input)
	{
		m_left = input;
	}

	public void SetRightNode(GPNode input)
	{
		m_right = input;
	}

	public GPNode FindNodeReferenceById(int searchID, int currentCount)
	{
		if ( searchID == currentCount )
		{
			return(m_left);
		}

		int tmp = searchID + m_left.GetGPNodeCount();

		if ( tmp >= searchID )
		{
			return(m_left.FindNodeReferenceById(searchID, currentCount + 1));
		}

		tmp = searchID + m_left.GetGPDepth() + m_right.GetGPNodeCount();

		if ( tmp >= searchID )
		{
			return(m_right.FindNodeReferenceById(searchID, currentCount + m_left.GetGPNodeCount() + 1));
		}

		return(null);

	}
}
