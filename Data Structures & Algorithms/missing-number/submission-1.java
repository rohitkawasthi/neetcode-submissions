class Solution {
    public int missingNumber(int[] nums) {
        Arrays.sort(nums);
        int prev = -1;
        for(int num : nums) {
            if(num != ++prev) {
                return num-1;
            }
        }
        return prev+1;
    }
}
