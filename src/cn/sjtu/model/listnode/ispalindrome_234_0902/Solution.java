package cn.sjtu.model.listnode.ispalindrome_234_0902;

import cn.sjtu.model.listnode.ListNode;

/**
 * @author ：linfd
 * @version :easy$
 * @date ：Created in 2021-10-07 16:49
 * @description：回文链表
 */

public class Solution {

    /**
     *leetcode 第234题 判断回文链表
     * @param head
     * @return
     */
    //递归
    ListNode left;
    public boolean isPalindrome(ListNode head) {
        left = head;
        return traverse(head);
    }
    boolean traverse(ListNode right){
        if(right == null) return true;

        boolean res = traverse(right.next);
        res = res && (right.val == left.val);
        left = left.next;
        return res;
    }



    //非递归 迭代
    public boolean isPalindromeWithInteration(ListNode head) {
        ListNode slow, fast;
        slow = fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        if (fast != null){
            slow = slow.next;
        }
        ListNode left = head;
        ListNode right = reverse(slow);

        while (right != null) {
            if (left.val != right.val)
                return false;
            left = left.next;
            right = right.next;
        }
        return true;
    }

    /**
     * 反转链表
     * @param head
     * @return
     */
    ListNode reverse(ListNode head) {
        ListNode pre = null, cur = head;
        while (cur != null) {
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return pre;
    }

}
