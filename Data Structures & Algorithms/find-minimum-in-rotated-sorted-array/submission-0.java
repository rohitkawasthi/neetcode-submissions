class Solution {
    public int findMin(int[] nums) {
        int l=0;
        int h=nums.length-1;
        while(l<h){
            int mid = (h+l)/2;
            if(nums[mid]<=nums[h]) {
                h = mid;
            } else {
                if(h-l==1) {
                   mid+=1; 
                }
                l = mid;
            }
        }
        return nums[l];
    }
}
