package cn.sjtu.model.listnode.reversebetween_92_0902;

import cn.sjtu.model.listnode.ListNode;

/**
 * @author ：linfd
 * @version :medium$
 * @date ：Created in 2021-10-07 16:45
 * @description：反转链表 II
 */

public class Solution {

    /**
     *  leetcode 第92题 反转链表中第m到N个
     * @param head
     * @param m
     * @param n
     * @return
     */
    ListNode reverseBetween(ListNode head, int m, int n) {
        if(m ==1 ){
            return reverseN(head,n);
        }else {
            // 前进到反转的起点触发 base case
            head.next = reverseBetween(head.next,m-1,n-1);
        }

        return head;
    }

    /**
     * 反转链表前N个节点
     * @param head
     * @return
     */
    ListNode successor = null;
    ListNode reverseN(ListNode head, int n){
        if(n == 1){
            // 记录第 n + 1 个节点
            successor = head.next;
            return head;
        }
        // 以 head.next 为起点，需要反转前 n - 1 个节点
        ListNode last = reverseN(head.next,n-1);
        head.next.next = head;
        head.next = successor;
        return last;
    }

}
