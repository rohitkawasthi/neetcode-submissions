class Solution {
    /*
        climbStairs(n) = climbStairs(n-1) + climbStairs(n-2)
        base case - n = 0 -> 1 , n = 1 -> 1, n = 2 -> 2
        n = 3 --> fn(2) + fn(1) = 2*fn(1) + fn(0) = 2+1 = 3
    */

    private record Pair(int v1, int v2){}

    public int climbStairs(int n) {
        return climbStairsRecursive(n).v1;
    }

    public Pair climbStairsRecursive(int n) {
        if(n <= 1) {
            return new Pair(1,n);
        }
        Pair waysN2 = climbStairsRecursive(n-2);
        Pair waysN1 = new Pair(waysN2.v1 + waysN2.v2, waysN2.v1);
        Pair waysN = new Pair(waysN1.v1 + waysN1.v2, waysN1.v1);
        return waysN;
    }
}
