class Solution {
    public int missingNumber(int[] nums) {
        Arrays.sort(nums);
        return missingNumber(nums, nums.length);
    }

    private int missingNumber(int[] nums, int num) {
        if(num ==0 || nums[num-1] != num) {
            return num;
        }
        return missingNumber(nums, num-1);
    }
}
