package cn.sjtu.model.dp.canpartition_416_1007;

/**
 * @author ：linfd
 * @version :中等$
 * @date ：Created in 2021-10-07 15:28
 * @description：分割等和子集
 */

public class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = {1,2,3,6};

        System.out.println(solution.canPartition(nums));

    }

    public boolean canPartition(int[] nums) {
        int sum = 0;
        for(int num : nums){
            sum += num;
        }
        if(sum % 2 != 0){
            return false;
        }
        int n = nums.length;
        sum = sum/2;
        boolean[][] dp = new boolean[n+1][sum+1];

        for(int i = 0;i<= n;i++){
            dp[i][0] = true;
        }

        for(int i =1;i<= n;i++){
            for(int j = 1;j<= sum;j++){

                if(j - nums[i-1] < 0){
                    //背包容量不足，不能装入第 i 个物品
                    dp[i][j] = dp[i-1][j];
                }else {
                    // 装入或不装入背包
                    dp[i][j] = dp[i -1][j] | dp[i-1][j-nums[i-1]];
                }
            }

        }

        return dp[n][sum];
    }


}
