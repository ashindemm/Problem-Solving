/**
 * // This is the interface that allows for creating nested lists.
 * // You should not implement it, or speculate about its implementation
 * public interface NestedInteger {
 *     // Constructor initializes an empty nested list.
 *     public NestedInteger();
 *
 *     // Constructor initializes a single integer.
 *     public NestedInteger(int value);
 *
 *     // @return true if this NestedInteger holds a single integer, rather than a nested list.
 *     public boolean isInteger();
 *
 *     // @return the single integer that this NestedInteger holds, if it holds a single integer
 *     // Return null if this NestedInteger holds a nested list
 *     public Integer getInteger();
 *
 *     // Set this NestedInteger to hold a single integer.
 *     public void setInteger(int value);
 *
 *     // Set this NestedInteger to hold a nested list and adds a nested integer to it.
 *     public void add(NestedInteger ni);
 *
 *     // @return the nested list that this NestedInteger holds, if it holds a nested list
 *     // Return empty list if this NestedInteger holds a single integer
 *     public List<NestedInteger> getList();
 * }
 */
class Solution {
    public int maxDepth = 1;

    public int depthSumInverse(List<NestedInteger> nestedList) {
        
        for (NestedInteger ni : nestedList) {
            getMaxDepth(ni, 1);
        }
        int sum = 0;
        for (NestedInteger ni : nestedList) {
            sum += getSum(ni, 1);
        }
        
        return sum;
    }
    
    public void getMaxDepth(NestedInteger ni, int depth) {
        if (ni.isInteger()) {
            System.out.println(ni.getInteger() + " - " + depth);
            maxDepth = Math.max(maxDepth, depth);
        } else {
            int d = depth + 1;
            for (NestedInteger tempNi : ni.getList()) {
                getMaxDepth(tempNi, d);
            }
        }
    }
    
    public int getSum(NestedInteger ni, int currDepth) {
        int sum = 0;
        if (ni.isInteger()) {
            sum =  (maxDepth - currDepth + 1) * ni.getInteger();
        } else {
            int d = currDepth + 1;
            for (NestedInteger tempNi : ni.getList()) {
                sum += getSum(tempNi, d);
            }
        }
        
        return sum;
    }
}