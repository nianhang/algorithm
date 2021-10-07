package cn.sjtu.model.listnode.mergeklists_23_0901;

import cn.sjtu.model.listnode.ListNode;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @author ��linfd
 * @version :hard$
 * @date ��Created in 2021-10-07 16:13
 * @description���ϲ�K����������
 */

public class Solution {

    /**
     * leetcode��23�⣬�ϲ�K����������
     * @param lists
     * @return
     */
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists == null || lists.length == 0){
            return null;
        }
        ListNode p = new ListNode();
        ListNode dump = p;
        //ʹ�����ȼ����У���ԭ���ǹ���һ��С����
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
