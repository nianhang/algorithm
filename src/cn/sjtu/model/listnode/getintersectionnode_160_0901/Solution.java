package cn.sjtu.model.listnode.getintersectionnode_160_0901;

import cn.sjtu.model.listnode.ListNode;

/**
 * @author ：linfd
 * @version :easy$
 * @date ：Created in 2021-10-07 16:33
 * @description：相交链表
 */

public class Solution {

    /**
     * leetcode第160题，相交链表
     * @param headA
     * @param headB
     * @return
     */
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode p1 = headA;
        ListNode p2 = headB;

        while (p1 != p2){
            //让p1遍历完链表A之后开始遍历链表B
            if(p1 == null){
                p1 = headB;
            }else {
                p1 = p1.next;
            }
            //让p2遍历完链表B之后开始遍历链表A
            if(p2 == null){
                p2 = headA;
            }else {
                p2 = p2.next;
            }
        }
        return p1;
    }

    /**
     * 判断链表是否有包含环
     * @param head
     * @return
     */
    boolean hasCycle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        // 快指针走到末尾时停止
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
            if(slow == fast){
                return true;
            }
        }
        return false;
    }

    /**
     * 求环的起点
     * @param head
     * @return
     */
    ListNode detectCycle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;

        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;

            if(slow == fast){
                break;
            }
        }
        //fast 遇到空指针说明没有环
        if(fast == null || fast.next == null){
            return null;
        }
        slow = head;
        while(fast != slow){
            fast = fast.next;
            slow = slow.next;
        }
        return slow;
    }


}
