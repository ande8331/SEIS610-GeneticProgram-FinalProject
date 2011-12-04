package GPFinalProject;

import java.text.NumberFormat;
/**
 * Node Value of GP6.
 * @author Anderson-Chow-Liberty-Osborn-Tran
 * @version 0.5
 * @since 11/05/2011
 */
public class GPNodeValue extends GPNode {
    /**
     * Holds the numerical value of the node.
     */
    protected double numericValue;
    /**
     * Holds the decision of the variable, or not.
     */
    protected boolean isVariable;
    /**
     * Holds the variable value as a string.
     */
    protected String variableValue;

    /**
     * Constructor.
     * @param aNumericValue Nodes value.
     */
    public GPNodeValue(final double aNumericValue) {
        numericValue = aNumericValue;
        isVariable = false;
    }

    /**
     * Constructor with parameters.
     * @param aVariableValue Pre-fill
     */
    public GPNodeValue(final String aVariableValue) {
        variableValue = aVariableValue;
        isVariable = true;
    }

    /**
     * @param x Variable tested.
     * @return Either parameter or variable value.
     */
    public double evaluateFitnessValue(final double x) {
        if (isVariable == true) {
            return (x);
        } else {
            return (numericValue);
        }
    }

    /**
     * @return 0
     */
    public int getGPDepth() {
        return (0);
    }

    /**
     * @return 1
     */
    public int getGPNodeCount() {
        return (1);
    }

    /**
     * @return A string of either the variable or converted value.
     */
    public String getGPString() {
        if (isVariable == true) {
            return (variableValue);
        } else {
            NumberFormat nf = NumberFormat.getIntegerInstance();
            return (nf.format(numericValue));
            //return Double.toString(m_numericValue);
        }
    }

}

