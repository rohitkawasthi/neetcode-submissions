class Solution {
    /*
        [-1,0,1,2,-1,-4]
        [-1,-1,0,1,2,4] - nlog(n), n
        {(-1,2),(0,1),(1,1),(2,1),(4,1)}
        {(-1,0),(0,1),(1,1),(2,0),(4,1)}
    */
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        Map<Integer,Integer> numCountMap = new HashMap<>();
        for(int num : nums)     {
            numCountMap.put(num, numCountMap.getOrDefault(num, 0)+1);
        }
        List<List<Integer>> result = new ArrayList<>();
        for(int i=0; i<nums.length-2; i++) {
            int num1 = nums[i];
            if(num1>0) {
                //all three numbers couldn't be positive
                break;
            }
            if(i>0 && nums[i-1]==num1) {
                //to avoid duplicate triplets
                continue;
            }
            numCountMap.put(num1, numCountMap.getOrDefault(num1, 0)-1);
            for(int j=i+1; j<nums.length-1; j++) {
                int num2 = nums[j];
                int num3 = -(num1+num2);
                if(num3<num2) {
                    //num3 can't be find in the forward direction if it is less than num2
                    break;
                }
                if(j>i+1 && nums[j-1]==num2) {
                    //to avoid duplicate triplets
                    continue;
                }

                int num3Count = numCountMap.getOrDefault(num3,0);
                if(num3Count == 1 && num3==num2) {
                    //the same number can't be considered for triplet 
                    break;
                }
                if(num3Count != 0) {
                    List<Integer> threeSumNumbers = new ArrayList<>();
                    threeSumNumbers.add(num1);
                    threeSumNumbers.add(num2);
                    threeSumNumbers.add(num3);
                    result.add(threeSumNumbers);
                }
            }
        }
        return result;
    }
}
