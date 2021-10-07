package cn.sjtu.model.array.advantagecount_870_0912;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * @author ：linfd
 * @version :$
 * @date ：Created in 2021-09-12 12:16
 * @description：
 */

public class AdvantageCount {
    public static void main(String[] args) {

        AdvantageCount ad= new AdvantageCount();
        int[] A = {12,24,8,32};
        int[] B = {13,25,32,11};

        int[] test = ad.advantageCount(A, B);

        for(int res : test){
            System.out.println(res+",");
        }


    }

    /**
     * leetcode 第870题，优势洗牌（类似田忌赛马）
     * @param nums1
     * @param nums2
     * @return
     */
    public int[] advantageCount(int[] nums1, int[] nums2) {
        if(nums1 == null || nums2 == null) return null;
        int n = nums1.length;
        //给num2进行倒叙排序
        PriorityQueue<int[]> maxPq = new PriorityQueue<>(
                (int[] pair1,int[] pair2)->{
                    return pair2[1] - pair1[1];
                });

        for(int i = 0;i<n ;i++){
            maxPq.offer(new int[]{i,nums2[i]});
        }
        // 给 nums1 升序排序
        Arrays.sort(nums1);

        int left = 0;
        int right = n -1;
        int[] res = new int[n];
        while(!maxPq.isEmpty()){
            int[] poll = maxPq.poll();
            // maxVal 是 nums2 中的最大值，index 是对应索引
            int index = poll[0];
            int maxVal =poll[1];

            if(maxVal < nums1[right]){
                // 如果 nums1[right] 能胜过 maxval，那就自己上
                res[index] = nums1[right];
                right --;
            }else {
                // 否则用最小值混一下，养精蓄锐
                res[index] = nums1[left];
                left ++;
            }
        }
        return res;
    }







}
