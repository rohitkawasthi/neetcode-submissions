class Solution {
    public int hammingWeight(int n) {
        int hammingWeight = 0;
        while(n>0) {
            hammingWeight += (n%2);
            n /= 2;
        }
        return hammingWeight;
    }
}
