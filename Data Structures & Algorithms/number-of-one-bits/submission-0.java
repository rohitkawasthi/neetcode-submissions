class Solution {
    public int hammingWeight(int n) {
        int hammingWeight = 0;
        for(int i=0; i<=30; i++) {
            hammingWeight += ((n >> i) & 1);
        }
        return hammingWeight;
    }
}
