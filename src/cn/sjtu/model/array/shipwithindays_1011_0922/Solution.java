package cn.sjtu.model.array.shipwithindays_1011_0922;

/**
 * @author ：linfd
 * @version :$
 * @date ：Created in 2021-09-22 22:18
 * @description：在 D 天内送达包裹的能力
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
                //搜索左侧边界，则需要收缩右侧边界
                right = mid;
            }else if(f(weights,mid) < days){
                right = mid;
            }else if(f(weights,mid) > days){
                left = mid +1;
            }
        }
        return left;
    }

    //定义：当运载能力为 x 时，需要 f(x) 天运完所有货物
    //f(x)随着x的增加单调递减
    int f(int[] weights,int x){
        int days = 0;
        for(int i =0;i<weights.length;){
            //尽可能多装货物
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
