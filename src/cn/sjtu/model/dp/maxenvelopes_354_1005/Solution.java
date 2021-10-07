package cn.sjtu.model.dp.maxenvelopes_354_1005;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author ：linfd
 * @version :$
 * @date ：Created in 2021-10-05 15:05
 * @description： 俄罗斯套娃信封问题
 */

public class Solution {

    //类似最长递增子序列LIS
    //envelopes =[[w1,h1],[w2,h2],[w3,h3]...]
    //先对宽度w进行升序排序，如果遇到w相同的情况，则按照高度h降序排序。
    // 之后把所有的h作为一个数组，在这个数组上计算 LIS 的长度就是答案。
    public int maxEnvelopes(int[][] envelopes) {
        int n = envelopes.length;
        //按宽度升序排序，如果宽度一样，则按高度降序排序
        Arrays.sort(envelopes, new Comparator<int[]>() {
            @Override
            public int compare(int[] a, int[] b) {
                return a[0] == b[0] ?
                        b[1] - a[1] : a[0] - b[0];
            }
        });

        //对高度数组寻找LIS
        int[] height = new int[n];
        for(int i =0 ;i<n;i++){
            height[i] = envelopes[i][1];
        }
        return lengthOfLIS(height);
    }
    //返回nums中LIS的长度
    public int lengthOfLIS(int[] nums){
        int n = nums.length;
        int piles = 0;
        int[] top = new int[n];

        for(int i =0;i<n;i++){
            int poker = nums[i];
            int left = 0;
            int right = piles;

            while(left < right){
                int mid = (left+right)/2;
                if(top[mid] >= poker){
                    right = mid;
                }else {
                    left = mid+1;
                }
            }
            // 没找到合适的牌堆，新建一堆
            if(left == piles){
                piles++;
            }
            // 把这张牌放到牌堆顶
            top[left] = poker;
        }
        // 牌堆数就是 LIS 长度
        return piles;
    }

}
