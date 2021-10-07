package cn.sjtu.model.dp.coinchange_322_0928;

import java.util.Arrays;

/**
 * @author ：linfd
 * @version :$
 * @date ：Created in 2021-09-27 23:16
 * @description：零钱兑换
 */

public class Solution {

    // coins 中是可选硬币面值，amount 是目标金额
    public int coinChange(int[] coins, int amount) {
        int max = amount + 1;
        int[] dp = new int[amount + 1 ];
        Arrays.fill(dp,max);
        dp[0] = 0;
        //自底向上使用 dp table 来消除重叠子问题
        // dp[i] = x 表示，当目标金额为i时，至少需要x枚硬币。
        //[1, 2, 5],11
        for(int i = 1;i<= amount;i++){

            //不知道最后一枚硬币到底是多少，需要所有的都试一遍
            for(int coin : coins){
                //无子问题，跳过 dp[i-coin] 无意义
                if(i - coin < 0) continue;
                dp[i] = Math.min(dp[i],dp[i-coin] + 1);
            }
        }
        return dp[amount] > amount ? -1 : dp[amount];
    }

    //从顶向下的使用 dp table 来消除重叠子问题
    public int coinChangeWithTopDown(int[] coins, int amount) {
        if(amount < 1 ){
            return 0;
        }
        return coinChange(coins,amount,new int[amount]);
    }
    //额外开辟一块空间
    private int coinChange(int[] coins,int rem,int[] count){
        if(rem < 0){
            return -1;
        }
        if(rem == 0){
            return 0;
        }
        if(count[ rem -1] != 0){
            return count[ rem -1];
        }
        int min = Integer.MAX_VALUE;

        for(int coin : coins){
            int res = coinChange(coins,rem-coin,count);
            if(res >= 0 && res < min){
                min = 1 + res;
            }
        }
        count[rem - 1] = (min == Integer.MAX_VALUE) ? -1 : min;
        return count[rem -1];


    }



}
