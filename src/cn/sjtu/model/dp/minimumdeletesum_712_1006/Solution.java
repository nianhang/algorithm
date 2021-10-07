package cn.sjtu.model.dp.minimumdeletesum_712_1006;

import java.util.Arrays;

/**
 * @author ：linfd
 * @version :中等$
 * @date ：Created in 2021-10-07 1:06
 * @description：两个字符串的最小ASCII删除和
 */

public class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();
        String s1 = "fardfae";
        String s2 = "refaraf";

        System.out.println(solution.minimumDeleteSum(s1,s2));

    }


    //备忘录，消除重叠子问题
    int[][] memo;
    public int minimumDeleteSum(String s1, String s2) {
        int m = s1.length();
        int n = s2.length();
        // 备忘录值为 -1 代表未曾计算
        memo = new int[m][n];
        for(int[] row : memo){
            Arrays.fill(row,-1);
        }
        return dp(s1,0,s2,0);
    }

    // 定义：将 s1[i..] 和 s2[j..] 删除成相同字符串，
    // 最小的 ASCII 码之和为 dp(s1, i, s2, j)。
    private int dp(String s1,int i,String s2,int j){
        int res = 0;
        // base case
        if(i == s1.length()){
            // 如果 s1 到头了，那么 s2 剩下的都得删除
            for(;j<s2.length();j++){
                res += s2.charAt(j);
            }
            return res;
        }

        if(j == s2.length()){
            // 如果 s2 到头了，那么 s1 剩下的都得删除
            for(;i<s1.length();i++){
                res += s1.charAt(i);
            }
            return res;
        }

        // 如果之前计算过，则直接返回备忘录中的答案
        if(memo[i][j] != -1){
            return memo[i][j];
        }
        // 根据 s1[i] 和 s2[j] 是否相等做选择
        if(s1.charAt(i) == s2.charAt(j)){
            // s1[i] 和 s2[j] 都是在 lcs 中的，不用删除
            memo[i][j] = dp(s1,i+1,s2,j+1);
        }else {
            // s1[i] 和 s2[j] 至少有一个不在 lcs 中，删一个
            memo[i][j] = Math.min(
                    //s1[i]不在 lcs 中
                    s1.charAt(i) + dp(s1,i+1,s2,j),
                    //s2[j]不在 lcs 中
                    s2.charAt(j) + dp(s1,i,s2,j+1));
        }
        return memo[i][j];
    }
}
