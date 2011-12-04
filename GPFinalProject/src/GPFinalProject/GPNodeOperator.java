package GPFinalProject;

/**
 * Node Operators.
 * @author Anderson-Chow-Liberty-Osborn-Tran
 * @version 0.5
 * @since 11/05/2011
 */
public class GPNodeOperator extends GPNode {
    /**
     * Operator's left-hand value.
     */
    protected GPNode left;
    /**
     * Operator's right-hand value.
     */
    protected GPNode right;
    /**
     * Unknown value.
     */
    protected String operator;

    /**
     * @param aOperator List of {+,-,*,/}.
     * @param aLeft     Each side of operator.
     * @param aRight    Each side of operator.
     */
    public GPNodeOperator(final String aOperator, final GPNode aLeft, final GPNode aRight) {
        // TODO Auto-generated constructor stub
        operator = aOperator;
        left = aLeft;
        right = aRight;
    }

    /**
     * Fitness value.
     * @param x      Comparison value to target values.
     * @return Output Result
     */
    public double evaluateFitnessValue(final double x) {
        double leftValue = left.evaluateFitnessValue(x);
        double rightValue = right.evaluateFitnessValue(x);
        double output = Double.MAX_VALUE;
        if (operator.equals("+")) {
            output = leftValue + rightValue;
        }

        if (operator.equals("-")) {
            output = leftValue - rightValue;
        }

        if (operator.equals("*")) {
            output = leftValue * rightValue;
        }

        if (operator.equals("/")) {
            if (rightValue != 0.0) {
                output = leftValue / rightValue;
            } else {
                output = Double.MAX_VALUE;
            }
        }

        return (output);
    }

    /**
     * How deep?
     * @return size of the depth.
     */
    public int getGPDepth() {
        int leftDepth = left.getGPDepth();
        int rightDepth = right.getGPDepth();

        if (leftDepth > rightDepth) {
            return (leftDepth + 1);
        } else {
            return (rightDepth + 1);
        }
    }

    /**
     * Number of nodes.
     * @return Number of nodes on either side of the operator.
     */
    public int getGPNodeCount() {
        return (left.getGPNodeCount() + right.getGPNodeCount() + 1);
    }

    /**
     * Get string?
     * @return String?
     */
    public String getGPString() {
        return ("( " +  left.getGPString() + " " + operator + " " + right.getGPString() + " )");
    }

    /**
     * Access to the left-hand of operator node.
     * @return Retrieve the left-hand value.
     */
    public GPNode getLeftNode() {
        return (left);
    }

    /**
     * Access to the right-hand of operator node.
     * @return Retrieve the right-hand value.
     */
    public GPNode getRightNode() {
        return (right);
    }

    /**
     * Mutator access to the left-hand of operator node.
     * @param input Set the left-hand of the operator.
     */
    public void setLeftNode(final GPNode input) {
        left = input;
    }

    /**
     * Mutator access to the right-hand of operator node.
     * @param input Set the right-hand of the operator.
     */
    public void setRightNode(final GPNode input) {
        right = input;
    }

    /**
     * Find the nodes reference.
     * @param searchID Searching Identity.
     * @param currentCount Count within the search.
     * @return Operator's left-hand, or null.
     */
    public GPNode findNodeReferenceById(final int searchID, final int currentCount) {
        if (searchID == currentCount) {
            return (left);
        }

        int tmp = searchID + left.getGPNodeCount();

        if (tmp >= searchID) {
            return (left.findNodeReferenceById(searchID, currentCount + 1));
        }

        tmp = searchID + left.getGPDepth() + right.getGPNodeCount();

        if (tmp >= searchID) {
            return (right.findNodeReferenceById(searchID, (currentCount + left.getGPNodeCount()) + 1));
        }

        return (null);
    }
}
