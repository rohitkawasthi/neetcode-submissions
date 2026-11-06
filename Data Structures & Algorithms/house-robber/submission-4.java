class Solution {

    private int[] maxSumCache;

    public int rob(int[] nums) {
        this.maxSumCache = new int[3];
        this.maxSumCache[0] = nums[0];
        if(nums.length > 1) {
            this.maxSumCache[1] = Math.max(nums[0], nums[1]);
        }
        if(nums.length > 2) {
            this.maxSumCache[2] = Math.max(nums[0]+nums[2], nums[1]);
        }
        for(int i=3; i<nums.length; i++) {
            int maxIncludingLast = nums[i]+maxSumCache[1];
            int maxExcludingLast = nums[i-1]+maxSumCache[0];
            int maxSum = Math.max(maxIncludingLast, maxExcludingLast);
            shiftOldValues(this.maxSumCache, maxSum);

        }
        return this.maxSumCache[Math.min(nums.length-1, 2)];
    }

    private void shiftOldValues(int[] vals, int newVal) {
        for(int i=1; i<vals.length; i++) {
            vals[i-1] = vals[i];
        }
        vals[vals.length-1] = newVal;
    }
}
