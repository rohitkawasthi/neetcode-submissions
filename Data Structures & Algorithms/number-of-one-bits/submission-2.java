class Solution {
    public int hammingWeight(int n) {
        if(n==0 || n==1) {
            return n;
        }
        return (n & 1) + hammingWeight(n >> 1);
    }
}
