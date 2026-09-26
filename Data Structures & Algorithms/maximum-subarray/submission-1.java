/*
--------- brute force  -------
compute sum for all pairs

time - O(n^2)
space - O(1)

------- top-down - recursion -------
boundary
i==j -> return a[i]

memoization
return dp[i][j] if not -1

subproblem
max(a[i], a[i]+maxSubArray(i,j));

time - O(n^2)
space - O(1)

------- bottom-up - tabulation -------
boundary
i==j -> return a[i]

memoization
return dp[i][j] if not -1

subproblem
max(a[i], a[i]+maxSubArray(i,j));

time - O(n^2)
space - O(1)

--------- greedy --------------------
[2,-3,4,-2,2,1,-1,4]
max = 2,4,5,8
i = 0,2
j = 1,2,3,4
k = 0,2,2,2,2
l = 0,2,4,5,7
temp = 2,0,4,4,5,4,8
j=1 -> -3+2 >= 2 ---- -1 < 0
j=2 -> 4+0 >= 2 ---- 4 < 0
j=3 -> -2+4 >= 4 ---- 2 < 0
j=4 -> 2+2 >= 4 --- 4 < 0
j=5 -> 1+4 >= 4 --- 5 < 0
j=6 -> -1+5 >= 5 --- 4 < 0
j=7 -> 4+4 > = 5 --- 8 < 0

time - O(n)
space - O(1)

*/
class Solution {
    public int maxSubArray(int[] nums) {
        int max = nums[0];
        int temp = 0;
        int i=0, j=0;
        int k=0, l=0;
        for(; j<nums.length; j++){
            temp += nums[j];
            if( temp >= max) {
                max = temp;
                k = i;
                l = j;
            }
            if(temp < 0) {
                temp = 0;
                i++;
            }
        }
        return max;
    }
}
