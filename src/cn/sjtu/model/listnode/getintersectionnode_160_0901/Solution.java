package cn.sjtu.model.listnode.getintersectionnode_160_0901;

import cn.sjtu.model.listnode.ListNode;

/**
 * @author ��linfd
 * @version :easy$
 * @date ��Created in 2021-10-07 16:33
 * @description���ཻ����
 */

public class Solution {

    /**
     * leetcode��160�⣬�ཻ����
     * @param headA
     * @param headB
     * @return
     */
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode p1 = headA;
        ListNode p2 = headB;

        while (p1 != p2){
            //��p1����������A֮��ʼ��������B
            if(p1 == null){
                p1 = headB;
            }else {
                p1 = p1.next;
            }
            //��p2����������B֮��ʼ��������A
            if(p2 == null){
                p2 = headA;
            }else {
                p2 = p2.next;
            }
        }
        return p1;
    }

    /**
     * �ж������Ƿ��а�����
     * @param head
     * @return
     */
    boolean hasCycle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        // ��ָ���ߵ�ĩβʱֹͣ
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
     * �󻷵����
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
        //fast ������ָ��˵��û�л�
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
