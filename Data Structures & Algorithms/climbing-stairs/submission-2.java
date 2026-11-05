class Solution {
    /*
        climbStairs(n) = climbStairs(n-1) + climbStairs(n-2)
        base case - n = 0 -> 1 , n = 1 -> 1, n = 2 -> 2
        n = 3 --> fn(2) + fn(1) = 2*fn(1) + fn(0) = 2+1 = 3
    */

    public int climbStairs(int n) {
        int[] ways = new int[n+1];
        ways[0] = 1;
        ways[1] = 1;
        for(int i=2; i<=n; i++) {
            ways[i] = ways[i-1]+ways[i-2];
        }
        return ways[n];
    }

}
