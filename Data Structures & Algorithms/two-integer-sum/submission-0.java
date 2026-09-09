class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer,Integer> numIndexMap = new HashMap<>();
        int firstIndex = 0;
        int secondIndex = 0;
        for(; secondIndex<nums.length ; secondIndex++) {
            if(numIndexMap.containsKey(target-nums[secondIndex])) {
               firstIndex = numIndexMap.get(target-nums[secondIndex]);
               break;
            }
            numIndexMap.putIfAbsent(nums[secondIndex],secondIndex);
        }
        return new int[]{firstIndex,secondIndex};
    }
}
