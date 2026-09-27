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
[2,-1,4,2,4,5,4,8]
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

-2,1
-2,-1

[2,-3,4,-2,2,1,-1,4]

3,4
4,4
6,6
4,6
8,8

*/
class Solution {



    public int maxSubArray(int[] nums) {
        // max = [maxIncludingEnd, actualMax]
        int[] max = new int[]{nums[0], nums[0]};
        for(int i=1; i<nums.length; i++){
            if(max[0] > 0) {
                max[0] = nums[i]+max[0];
            } else {
                max[0] = nums[i];
            }
            if(max[0] > max[1]) {
                max[1] = max[0];
            }
        }
        return max[1];
    }
}