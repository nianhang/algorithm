package cn.sjtu.model.array.splitarray_410_0923;

/**
 * @author ��linfd
 * @version :$
 * @date ��Created in 2021-09-23 21:50
 * @description���ָ���������ֵ
 */

public class Solution {

    public int splitArray(int[] nums, int m) {
        // һ���������������ұյģ����� hi Ҫ�����һ
        int lo = getMax(nums);
        int hi = getSum(nums)+1;

        while(lo < hi){
            int mid = lo +(hi - lo)/2;
            // ���ݷָ�������ĸ���������������
            int n = split(nums,mid);
            if(n == m){
                // �����ұ߽磬�ﵽ������߽��Ŀ��
                hi = mid;
            }else if(n < m){
                // �������������޸��ˣ���СһЩ
                hi = mid;
            }else if(n > m){
                // �������������޵��ˣ�����һЩ
                lo = mid + 1;
            }
        }
        return lo;
        /**for(int max = lo;max <=hi;max++){
            // ��������������� max��
            // ���ٿ��԰� nums �ָ�� n ��������
            int n =split(nums,max);
            if( n <= m){
                return max;
            }
        }
        return -1;*/
    }

    /* ��������������������������Ϊ max��
    ���� nums ���ٿ��Ա��ָ�ɼ��������� */
    int split(int[] nums,int max){
        //���ٿ��Էָ������������
        int count = 1;
        //��¼ÿ���������Ԫ�غ�
        int sum = 0;

        for(int i = 0; i<nums.length;i++){

            if(sum + nums[i] > max){
                // �����ǰ������ʹ��� max ����
                // ����������鲻�������Ԫ����
                count++;
                sum = nums[i];
            }else {
                // ��ǰ������ͻ�û�ﵽ max ����
                // ���������Ԫ��
                sum += nums[i];
            }
        }
        return count;
    }

    int getMax(int[] nums){
        int res = 0;
        for(int n : nums){
            res = Math.max(n,res);
        }
        return res;
    }

    int getSum(int[] nums){
        int res = 0;
        for(int n : nums){
            res += n;
        }
        return res;
    }
}
