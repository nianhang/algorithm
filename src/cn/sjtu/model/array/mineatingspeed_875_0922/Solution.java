package cn.sjtu.model.array.mineatingspeed_875_0922;

/**
 * @author ：linfd
 * @version :$
 * @date ：Created in 2021-09-22 22:16
 * @description：爱吃香蕉的珂珂
 */

public class Solution {

    //用二分查找算法计算
    public int minEatingSpeed(int[] piles, int h) {
        int left = 1;
        int right = 1000000000 + 1;

        while(left < right){
            int mid = left + (right - left)/2;
            if(f(piles,mid) <= h){
                right = mid;
            }else {
                left = mid +1;
            }
        }
        return left;

    }
    //f(x)随着X的增加单调递减
    int f(int[] piles,int x){
        int hours = 0;
        for(int i= 0;i<piles.length;i++){
            hours += piles[i] / x;
            if(piles[i] % x > 0){
                hours++;
            }
        }
        return hours;
    }


}
