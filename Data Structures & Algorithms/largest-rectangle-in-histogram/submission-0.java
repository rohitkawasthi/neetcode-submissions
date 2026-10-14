class Solution {

    /*
    [7,1,7,2,2,4]
    [1,5,1,3,2,1]
    [1,2,1,2,3,1]
    [1,6,1,4,4,1]
    [7,6,7,8,8,4]
    */
    public int largestRectangleArea(int[] heights) {
        //monotonically decreasing stack from left to right
        //to calculate the difference from next smaller
        int[] leftToRightDiff = leftToRightDiff(heights);

        //monotonically decreasing stack from right to left
        //to calculate the difference from next smaller
        int[] rightToLeftDiff = rightToLeftDiff(heights);

        //based on the above two results, find the maxium rectangular area
        return largestRectangleArea(heights, leftToRightDiff, rightToLeftDiff);
    }

    private int[] leftToRightDiff(int[] heights) {
        int[] result = new int[heights.length];
        Stack<Integer> stack = new Stack<>();
        for(int i=0; i<heights.length; i++) {
            while(!stack.isEmpty() && heights[i] < heights[stack.peek()]) {
                int idx = stack.pop();
                result[idx] = i-idx;
            }
            stack.push(i);
            result[i] = heights.length-i;
        }
        return result;
    }

    private int[] rightToLeftDiff(int[] heights) {
        int[] result = new int[heights.length];
        Stack<Integer> stack = new Stack<>();
        for(int i=heights.length-1; i>=0; i--) {
            while(!stack.isEmpty() && heights[i] < heights[stack.peek()]) {
                int idx = stack.pop();
                result[idx] = idx-i;
            }
            stack.push(i);
            result[i] = i+1;
        }
        return result;
    }

    private int largestRectangleArea(int[] heights, int[] leftToRightDiff, int[] rightToLeftDiff) {
        int max = 0;
        for(int i=0; i<leftToRightDiff.length; i++) {
            max = Math.max(max,(leftToRightDiff[i]+rightToLeftDiff[i]-1)*heights[i]);
        }
        return max;
    }
}
