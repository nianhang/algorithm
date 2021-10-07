package cn.sjtu.model.dp.mindistance_583_1006;

/**
 * @author ：linfd
 * @version :中等$
 * @date ：Created in 2021-10-07 0:58
 * @description：两个字符串的删除操作
 */

public class Solution {

    //删除的结果就是它俩的最长公共子序列
    public int minDistance(String word1, String word2) {
        int m = word1.length();
        int n = word2.length();
        // 复用前文计算 lcs 长度的函数
        int lcs = longestCommonSubsequence(word1,word2);
        return m - lcs + n -lcs;

    }

    //自底向上的动态规划
    public int longestCommonSubsequence(String text1, String text2) {
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
