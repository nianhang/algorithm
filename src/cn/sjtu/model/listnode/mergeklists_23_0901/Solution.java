package cn.sjtu.model.listnode.mergeklists_23_0901;

import cn.sjtu.model.listnode.ListNode;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @author ：linfd
 * @version :hard$
 * @date ：Created in 2021-10-07 16:13
 * @description：合并K个升序链表
 */

public class Solution {

    /**
     * leetcode第23题，合并K个有序链表
     * @param lists
     * @return
     */
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists == null || lists.length == 0){
            return null;
        }
        ListNode p = new ListNode();
        ListNode dump = p;
        //使用优先级队列，其原理是构造一个小顶堆
        PriorityQueue<ListNode> pq = new PriorityQueue<>(lists.length, new Comparator<ListNode>() {
            @Override
            public int compare(ListNode o1, ListNode o2) {
                return o1.val - o2.val;
            }
        });

        for(ListNode head:lists){
            if(head != null){
                pq.add(head);
            }
        }

        while (!pq.isEmpty()){
            ListNode poll = pq.poll();
            p.next = poll;
            if(poll.next != null){
                pq.add(poll.next);
            }
            p = p.next;
        }
        return dump.next;
    }

}
