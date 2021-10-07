package cn.sjtu.model.other.medianfinder_295_0919;

import java.util.PriorityQueue;

/**
 * @author ��linfd
 * @version :$
 * @date ��Created in 2021-09-19 17:05
 * @description������������λ��
 */

public class MedianFinder {

    private PriorityQueue<Integer> large;
    private PriorityQueue<Integer> small;

    public MedianFinder() {
        //С���� Ԫ����Խ��Խ��
        large = new PriorityQueue<>();
        //�󶥶� Ԫ����Խ��ԽС
        small = new PriorityQueue<>((a,b)->{
            return b - a;
        });
    }

    //��֤С�����е�Ԫ�غʹ󶥶��е�Ԫ�ظ�����ֵ<=1;
    //��Ҫ��֤С�����еĶѶ���Ԫ�ش��ڵ��ڴ󶥶��жѶ���Ԫ��
    public void addNum(int num) {
        if(small.size() >= large.size()){
            small.offer(num);
            large.offer(small.poll());
        }else {
            large.offer(num);
            small.offer(large.poll());
        }
    }

    public double findMedian() {
        if(large.size() < small.size()){
            return small.peek();
        }else if(large.size() > small.size()) {
            return large.peek();
        }
        return (large.peek() + small.peek())/2.0;
    }

}
