package cn.sjtu.model.listnode.addtwonumbers_2_0902;

import cn.sjtu.model.listnode.ListNode;

/**
 * @author ：linfd
 * @version :medium$
 * @date ：Created in 2021-10-07 16:51
 * @description：两数相加
 */

public class Solution {

    /**
     * leetcode 第2题 链表两个数相加
     * @param l1
     * @param l2
     * @return
     */
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dumpy = new ListNode(-1);
        ListNode p = dumpy;
        ListNode p1 =l1;
        ListNode p2 =l2;
        int nodeNum,tmp ;
        boolean flag = false;
        while(p1 != null){
            if(flag){
                nodeNum = 1;
            }else {
                nodeNum = 0;
            }
            if(p2 != null){
                tmp = p1.val + p2.val + nodeNum;
            }else {
                tmp = p1.val + nodeNum;
            }
            if(tmp >= 10){
                nodeNum = tmp - 10;
                p.next = new ListNode(nodeNum);
                flag = true;
            }else {
                nodeNum = tmp;
                p.next = new ListNode(nodeNum);
                flag = false;
            }
            p1 = p1.next;
            if(p2 != null){
                p2 = p2.next;
            }
            p = p.next;
        }

        while(p2 != null){
            if(flag){
                nodeNum = 1;
            }else {
                nodeNum = 0;
            }
            int p2tmp = p2.val + nodeNum;
            if(p2tmp >= 10){
                nodeNum = p2tmp - 10;
                p.next = new ListNode(nodeNum);
                flag = true;
            }else {
                nodeNum = p2tmp;
                p.next = new ListNode(nodeNum);
                flag = false;
            }
            p2 = p2.next;
            p = p.next;
        }

        if(flag){
            p.next = new ListNode(1);
        }
        return dumpy.next;
    }

}
