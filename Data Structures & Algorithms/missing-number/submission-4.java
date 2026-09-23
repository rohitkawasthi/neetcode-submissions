class Solution {
    public int missingNumber(int[] nums) {
        int expectedSum = ((nums.length)*(nums.length+1))/2;
        int actualSum = Arrays.stream(nums).sum();
        return expectedSum-actualSum;
    }
}
