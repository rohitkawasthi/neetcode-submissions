class Solution {

    private int[] maxSumCache;

    public int rob(int[] nums) {
        this.maxSumCache = new int[nums.length];
        Arrays.setAll(this.maxSumCache, i -> -1);
        return robRecursive(nums, 0);
    }

    private int robRecursive(int[] nums, int index) {
        if(index==nums.length-1) {
            return nums[index];
        }
        if(index==nums.length-2) {
            return Math.max(nums[index], nums[index+1]);
        }
        if(index==nums.length-3) {
            return Math.max(nums[index]+nums[index+2], nums[index+1]);
        }
        if(this.maxSumCache[index] != -1) {
            return this.maxSumCache[index];
        }
        int maxIncludingFirst = nums[index]+(maxSumCache[index+2] = robRecursive(nums, index+2));
        int maxExcludingFirst = nums[index+1]+(maxSumCache[index+3] = robRecursive(nums, index+3));
        return maxSumCache[index] = Math.max(maxIncludingFirst, maxExcludingFirst);
    }
}
