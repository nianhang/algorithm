package cn.sjtu.model.dp.maxenvelopes_354_1005;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author ��linfd
 * @version :$
 * @date ��Created in 2021-10-05 15:05
 * @description�� ����˹�����ŷ�����
 */

public class Solution {

    //���������������LIS
    //envelopes =[[w1,h1],[w2,h2],[w3,h3]...]
    //�ȶԿ��w�������������������w��ͬ����������ո߶�h��������
    // ֮������е�h��Ϊһ�����飬����������ϼ��� LIS �ĳ��Ⱦ��Ǵ𰸡�
    public int maxEnvelopes(int[][] envelopes) {
        int n = envelopes.length;
        //�������������������һ�����򰴸߶Ƚ�������
        Arrays.sort(envelopes, new Comparator<int[]>() {
            @Override
            public int compare(int[] a, int[] b) {
                return a[0] == b[0] ?
                        b[1] - a[1] : a[0] - b[0];
            }
        });

        //�Ը߶�����Ѱ��LIS
        int[] height = new int[n];
        for(int i =0 ;i<n;i++){
            height[i] = envelopes[i][1];
        }
        return lengthOfLIS(height);
    }
    //����nums��LIS�ĳ���
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
            // û�ҵ����ʵ��ƶѣ��½�һ��
            if(left == piles){
                piles++;
            }
            // �������Ʒŵ��ƶѶ�
            top[left] = poker;
        }
        // �ƶ������� LIS ����
        return piles;
    }

}
