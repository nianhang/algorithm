package cn.sjtu.model.listnode.reverselist_206_0902;

import cn.sjtu.model.listnode.ListNode;

/**
 * @author ：linfd
 * @version :easy$
 * @date ：Created in 2021-10-07 16:40
 * @description：反转链表
 */

public class Solution {

    /**
     * leetcode第206题，反转链表
     * @param head
     * @return
     */
    //递归
    public ListNode reverseList(ListNode head) {
        if(head== null || head.next == null) return head;
        ListNode last = reverseList(head.next);
        head.next.next = head;
        head.next = null;
        return last;
    }

    //非递归 迭代法
    public ListNode reverseListWithoutRecur(ListNode head) {
        if(head ==null || head.next == null){
            return head;
        }
        ListNode pre = null;
        ListNode cur = head;
        ListNode next = head;

        while(cur != null){
            next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return pre;
    }

}
