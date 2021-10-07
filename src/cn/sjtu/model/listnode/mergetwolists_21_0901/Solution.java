package cn.sjtu.model.listnode.mergetwolists_21_0901;

import cn.sjtu.model.listnode.ListNode;

/**
 * @author ��linfd
 * @version :��$
 * @date ��Created in 2021-10-07 16:03
 * @description���ϲ�������������
 */

public class Solution {

    /**
     * leetcode��21�⣬�ϲ�������������
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
        //�趨����ָ�룬һֱ��������
        while(p1 != null && p2 !=null){
            //ѡ��ֵС������
            if(p1.val > p2.val){
                p.next =p2;
                p2 = p2.next;
            }else {
                p.next = p1;
                p1 = p1.next;
            }
            p = p.next;
        }
        //���ܻ�����������û����ȫ������
        if(p1 != null){
            p.next = p1;
        }
        if(p2 != null){
            p.next = p2;
        }
        return dump.next;
    }

}
