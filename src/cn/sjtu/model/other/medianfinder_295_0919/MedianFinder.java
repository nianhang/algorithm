package cn.sjtu.model.other.medianfinder_295_0919;

import java.util.PriorityQueue;

/**
 * @author ：linfd
 * @version :$
 * @date ：Created in 2021-09-19 17:05
 * @description：数据流的中位数
 */

public class MedianFinder {

    private PriorityQueue<Integer> large;
    private PriorityQueue<Integer> small;

    public MedianFinder() {
        //小顶堆 元素是越来越大
        large = new PriorityQueue<>();
        //大顶堆 元素是越来越小
        small = new PriorityQueue<>((a,b)->{
            return b - a;
        });
    }

    //保证小顶堆中的元素和大顶堆中的元素个数差值<=1;
    //还要保证小顶堆中的堆顶的元素大于等于大顶堆中堆顶的元素
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
