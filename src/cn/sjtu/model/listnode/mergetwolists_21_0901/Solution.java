package cn.sjtu.model.listnode.mergetwolists_21_0901;

import cn.sjtu.model.listnode.ListNode;

/**
 * @author ：linfd
 * @version :简单$
 * @date ：Created in 2021-10-07 16:03
 * @description：合并两个有序链表
 */

public class Solution {

    /**
     * leetcode第21题，合并两个有序链表
     * @param l1
     * @param l2
     * @return
     */
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode p = new ListNode();
        ListNode dump =p;
        ListNode p1 = l1;
        ListNode p2 = l2;
        if(p1 == null && p2 == null){
            return null;
        }
        //设定三个指针，一直在向下走
        while(p1 != null && p2 !=null){
            //选择值小的链表
            if(p1.val > p2.val){
                p.next =p2;
                p2 = p2.next;
            }else {
                p.next = p1;
                p1 = p1.next;
            }
            p = p.next;
        }
        //可能还有两个链表没有完全遍历完
        if(p1 != null){
            p.next = p1;
        }
        if(p2 != null){
            p.next = p2;
        }
        return dump.next;
    }

}
