class Solution {
    /*
        climbStairs(n) = climbStairs(n-1) + climbStairs(n-2)
        base case - n = 0 -> 1 , n = 1 -> 1, n = 2 -> 2
        n = 3 --> fn(2) + fn(1) = 2*fn(1) + fn(0) = 2+1 = 3
    */

    private int[] ways = null;

    public int climbStairs(int n) {
        ways = new int[n+1];
        return climbStairsRecursive(n);
    }

    public int climbStairsRecursive(int n) {
        if(n <= 1) {
            return 1;
        }
        if(ways[n] != 0) {
            return ways[n];
        }
        ways[n-1] = climbStairsRecursive(n-1);
        ways[n-2] = climbStairsRecursive(n-2);
        ways[n] = ways[n-1]+ways[n-2];
        return ways[n];
    }
}
