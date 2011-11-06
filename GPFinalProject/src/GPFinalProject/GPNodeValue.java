package GPFinalProject;

public class GPNodeValue extends GPNode 
{

	protected double m_numericValue;
	protected boolean m_isVariable;
	protected String m_variableValue;

	public GPNodeValue(double numericValue)
	{
		m_numericValue = numericValue;      
		m_isVariable = false;
	}

	public GPNodeValue(String variableValue)
	{
		m_variableValue = variableValue;
		m_isVariable = true;
	}

	public double EvaluateFitnessValue(double x)
	{
		if ( m_isVariable == true )
		{
			return(x);
		} 
		else
		{
			return(m_numericValue);
		}
	}

	public int GetGPDepth()
	{
		return(0);
	}

	public int GetGPNodeCount()
	{
		return(1);
	}

	public String GetGPString()
	{
		if ( m_isVariable == true )
		{
			return(m_variableValue);
		} 
		else
		{
			return(Double.toString(m_numericValue));
		}
	}

}
