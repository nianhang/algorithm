package cn.sjtu.model.dp.longestpalindromesubseq_516_1007;

import java.util.Arrays;

/**
 * @author ：linfd
 * @version :中等$
 * @date ：Created in 2021-10-07 12:14
 * @description：最长回文子序列
 */

public class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();
        String test = "bbbab";

        System.out.println(solution.longestPalindromeSubseq(test));

    }


    public int longestPalindromeSubseq(String s) {

        int n = s.length();
        //在子串s[i..j]中，最长回文子序列的长度为dp[i][j]
        int[][] dp = new int[n][n];
        //全部初始化为0
        /*for(int[] row : dp){
            Arrays.fill(row,0);
        }*/
        // base case
        for(int i = 0; i < n; i++){
            dp[i][i] = 1;
        }

        for(int i = n-1;i >= 0;i--){
            for (int j = i+1; j<n; j++){
                // 状态转移方程
                if(s.charAt(i) == s.charAt(j)){
                    dp[i][j] = dp[i+1][j-1] + 2;
                }else {
                    dp[i][j] = Math.max(dp[i][j-1],dp[i+1][j]);
                }
            }
        }
        // 整个 s 的最长回文子串长度
        return dp[0][n-1];
    }


}
