package cn.sjtu.model.dp.mindistance_72_1004;

import java.util.HashMap;
import java.util.Map;

/**
 * @author ：linfd
 * @version :$
 * @date ：Created in 2021-10-04 18:20
 * @description：编辑距离
 */

public class Solution {

    /**
     * DP table 是自底向上求解
     * 定义dp[i][j] 代表 word1 到 i 位置转换成 word2 到 j 位置需要最少步数
     *
     * 当 word1[i] == word2[j]，dp[i][j] = dp[i-1][j-1]；
     * 当 word1[i] != word2[j]，dp[i][j] = min(dp[i-1][j-1], dp[i-1][j], dp[i][j-1]) + 1
     * 其中，dp[i-1][j-1] 表示替换操作，dp[i-1][j] 表示删除操作，dp[i][j-1] 表示插入操作。
     * @param word1
     * @param word2
     * @return
     */
    public int minDistance(String word1, String word2) {

        int m = word1.length();
        int n = word2.length();

        int[][] dp = new int[m+1][n+1];

        // 需要考虑 word1 或 word2 一个字母都没有，
        // 即全增加/删除的情况，所以预留 dp[0][j] 和 dp[i][0]
        for(int i = 1;i<=m;i++){
            dp[i][0] = i;
        }

        for(int j = 1;j<= n;j++){
            dp[0][j] = j;
        }

        for(int i = 1;i<= m;i++){

            for(int j = 1;j<=n;j++){
                //相同直接前移
                if(word1.charAt(i-1) == word2.charAt(j-1)){
                    dp[i][j] = dp[i-1][j-1];
                }else {
                    // 删除、插入、替换三种变化
                    dp[i][j] = min(
                            dp[i-1][j] +1,
                            dp[i][j-1] +1,
                            dp[i-1][j-1] +1);
                }
            }
        }
        return dp[m][n];
    }

    int min(int a,int b,int c){
        return Math.min(a,Math.min(b,c));
    }

    /**
     * 自顶向下
     */
    String s1,s2;
    public int minDistanceTopDown(String word1, String word2) {
        s1 = word1;
        s2 = word2;
        Map<String,Integer> map = new HashMap<>();
        return helper(s1.length() -1,s2.length() -1,map);
    }

    private int helper(int i, int j, Map map){
        String s = ""+i+" "+j;
        //map中已有就返回，处理重复子问题
        if(map.containsKey(s)){
            return (int)map.get(s);
        }
        //处理空字符串
        if(i == -1){
            return j+1;
        }
        if(j == -1){
            return i+1;
        }

        if(s1.charAt(i) == s2.charAt(j)){
            map.put(s,helper(i-1,j-1,map));
        }else {
            map.put(s,Math.min(Math.min(helper(i-1,j-1,map),helper(i-1,j,map)),helper(i,j-1,map)) + 1);
        }

        return (int)map.get(s);
    }

}
