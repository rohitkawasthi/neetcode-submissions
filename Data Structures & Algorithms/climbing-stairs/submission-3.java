class Solution {
    /*
        climbStairs(n) = climbStairs(n-1) + climbStairs(n-2)
        base case - n = 0 -> 1 , n = 1 -> 1, n = 2 -> 2
        n = 3 --> fn(2) + fn(1) = 2*fn(1) + fn(0) = 2+1 = 3
    */

    public int climbStairs(int n) {
        int prevToPrev = 1;
        int prev = 1;
        int result = 1;
        for(int i=2; i<=n; i++) {
            result = prev + prevToPrev;
            prevToPrev = prev;
            prev = result;
        }
        return result;
    }

}
