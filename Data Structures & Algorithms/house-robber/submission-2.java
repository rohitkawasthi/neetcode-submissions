class Solution {

    private int[] maxSumCache;

    public int rob(int[] nums) {
        this.maxSumCache = new int[nums.length];
        this.maxSumCache[0] = nums[0];
        if(nums.length > 1) {
            this.maxSumCache[1] = Math.max(nums[0], nums[1]);
        }
        if(nums.length > 2) {
            this.maxSumCache[2] = Math.max(nums[0]+nums[2], nums[1]);
        }
        for(int i=3; i<nums.length; i++) {
            int maxIncludingLast = nums[i]+maxSumCache[i-2];
            int maxExcludingLast = nums[i-1]+maxSumCache[i-3];
            maxSumCache[i] = Math.max(maxIncludingLast, maxExcludingLast);
        }
        return this.maxSumCache[nums.length-1];
    }
}
