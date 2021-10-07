package cn.sjtu.model.dp.coinchange_322_0928;

import java.util.Arrays;

/**
 * @author ��linfd
 * @version :$
 * @date ��Created in 2021-09-27 23:16
 * @description����Ǯ�һ�
 */

public class Solution {

    // coins ���ǿ�ѡӲ����ֵ��amount ��Ŀ����
    public int coinChange(int[] coins, int amount) {
        int max = amount + 1;
        int[] dp = new int[amount + 1 ];
        Arrays.fill(dp,max);
        dp[0] = 0;
        //�Ե�����ʹ�� dp table �������ص�������
        // dp[i] = x ��ʾ����Ŀ����Ϊiʱ��������ҪxöӲ�ҡ�
        //[1, 2, 5],11
        for(int i = 1;i<= amount;i++){

            //��֪�����һöӲ�ҵ����Ƕ��٣���Ҫ���еĶ���һ��
            for(int coin : coins){
                //�������⣬���� dp[i-coin] ������
                if(i - coin < 0) continue;
                dp[i] = Math.min(dp[i],dp[i-coin] + 1);
            }
        }
        return dp[amount] > amount ? -1 : dp[amount];
    }

    //�Ӷ����µ�ʹ�� dp table �������ص�������
    public int coinChangeWithTopDown(int[] coins, int amount) {
        if(amount < 1 ){
            return 0;
        }
        return coinChange(coins,amount,new int[amount]);
    }
    //���⿪��һ��ռ�
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
