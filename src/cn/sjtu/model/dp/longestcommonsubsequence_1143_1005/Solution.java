package cn.sjtu.model.dp.longestcommonsubsequence_1143_1005;

import java.util.Arrays;

/**
 * @author ：linfd
 * @version :中等$
 * @date ：Created in 2021-10-05 16:46
 * @description：最长公共子序列
 */

public class Solution {

    //自顶向下的动态规划
    //备忘录，消除重叠子问题
    int[][] memo;
    public int longestCommonSubsequence(String text1, String text2) {
        int m = text1.length();
        int n = text2.length();
        // 备忘录值为 -1 代表未曾计算
        memo = new int[m][n];
        for(int[] row : memo){
            Arrays.fill(row,-1);
        }
        return dp(text1,0,text2,0);
    }

    //dp(s1,i,s2,j)表示s1[i...]和s2[j...]的最长公共子序列长度
    private int dp(String s1,int i,String s2,int j){
        //s1和s2有一个字符串到结尾了
        if(i == s1.length() || j == s2.length()){
            return 0;
        }
        // 如果之前计算过，则直接返回备忘录中的答案
        if(memo[i][j] != -1){
            return memo[i][j];
        }
        // 根据 s1[i] 和 s2[j] 是否相等做选择
        if(s1.charAt(i) == s2.charAt(j)){
            //s1[i]和s2[j]必然在lcs中
            memo[i][j] = 1+dp(s1,i+1,s2,j+1);
        }else {
            // s1[i] 和 s2[j] 至少有一个不在 lcs 中
            memo[i][j] = Math.max(
                    //s1[i]不在 lcs 中
                    dp(s1,i+1,s2,j),
                    //s2[j]不在 lcs 中
                    dp(s1,i,s2,j+1));
        }

        return memo[i][j];
    }

    //自底向上的动态规划
    public int longestCommonSubsequenceWithTopDown(String text1, String text2) {
        int m = text1.length();
        int n = text2.length();
        int[][] dp = new int[m+1][n+1];
        // 定义：s1[0..i-1] 和 s2[0..j-1] 的 lcs 长度为 dp[i][j]
        // 目标：s1[0..m-1] 和 s2[0..n-1] 的 lcs 长度，即 dp[m][n]
        // base case: dp[0][..] = dp[..][0] = 0

        for(int i=1;i<=m;i++){
            for(int j=1;j<=n;j++){
                // 现在 i 和 j 从 1 开始，所以要减一
                if(text1.charAt(i-1) == text2.charAt(j-1)){
                    // s1[i-1] 和 s2[j-1] 必然在 lcs 中
                    dp[i][j] = 1+dp[i-1][j-1];
                }else {
                    // s1[i-1] 和 s2[j-1] 至少有一个不在 lcs 中
                    dp[i][j] = Math.max(dp[i][j-1],dp[i-1][j]);
                }
            }

        }
        return dp[m][n];
    }


}
