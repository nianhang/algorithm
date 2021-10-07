package cn.sjtu.model.array.shipwithindays_1011_0922;

/**
 * @author ��linfd
 * @version :$
 * @date ��Created in 2021-09-22 22:18
 * @description���� D �����ʹ����������
 */

public class Solution {

    public int shipWithinDays(int[] weights, int days) {
        int left =0;
        int right = 1;

        for(int w : weights){
            left = Math.max(left,w);
            right += w;
        }

        while (left < right){
            int mid = left +(right - left)/2;
            if(f(weights,mid) == days){
                //�������߽磬����Ҫ�����Ҳ�߽�
                right = mid;
            }else if(f(weights,mid) < days){
                right = mid;
            }else if(f(weights,mid) > days){
                left = mid +1;
            }
        }
        return left;
    }

    //���壺����������Ϊ x ʱ����Ҫ f(x) ���������л���
    //f(x)����x�����ӵ����ݼ�
    int f(int[] weights,int x){
        int days = 0;
        for(int i =0;i<weights.length;){
            //�����ܶ�װ����
            int cap = x;
            while(i < weights.length){
                if(cap < weights[i]) {
                    break;
                }else {
                    cap  -= weights[i];
                }
                i++;
            }
            days++;
        }
        return days;
    }
}
