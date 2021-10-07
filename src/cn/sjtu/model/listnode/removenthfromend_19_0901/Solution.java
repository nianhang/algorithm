package cn.sjtu.model.listnode.removenthfromend_19_0901;

import cn.sjtu.model.listnode.ListNode;

/**
 * @author ：linfd
 * @version :medium$
 * @date ：Created in 2021-10-07 16:20
 * @description：删除链表的倒数第 N 个结点
 */

public class Solution {

    /**
     * leetcode第19题，删除链表的倒数第N个节点
     * @param head
     * @param n
     * @return
     */
    public ListNode removeNthFromEnd(ListNode head, int n) {
        // 虚拟头节点
        ListNode dump = new ListNode();
        dump.next = head;
        // 删除倒数第 n 个，要先找倒数第 n + 1 个节点
        ListNode x = findFromEnd(head, n + 1);
        // 删掉倒数第 n 个节点
        x.next = x.next.next;
        return dump.next;
    }

    ListNode findFromEnd(ListNode head,int k){
        ListNode p1 = head;
        for(int i=0;i<k;i++){
            p1 = p1.next;
        }
        ListNode p2 = head;
        while(p1 != null){
            p1 = p1.next;
            p2 = p2.next;
        }
        return p2;
    }


}
