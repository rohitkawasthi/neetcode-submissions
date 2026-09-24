class Solution {
    public int hammingWeight(int n) {
        int hammingWeight = (n & 1);
        int temp = n;
        for(int i=1; i<=30; i++) {
            temp >>= 1;
            hammingWeight += (temp & 1);
        }
        return hammingWeight;
    }
}
