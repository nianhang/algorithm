package cn.sjtu.model.tree.connect_116_0903;

import cn.sjtu.model.tree.Node;

/**
 * @author ��linfd
 * @version :medium$
 * @date ��Created in 2021-10-07 16:55
 * @description�����ÿ���ڵ����һ���Ҳ�ڵ�ָ��
 */

public class Solution {

    /**
     * leetcode 116�� ���ÿһ���ڵ����һ���Ҳ�ڵ�ָ��
     * @param root
     * @return
     */
    public Node connect(Node root) {
        if(root == null ) return null;
        connectTwoNode(root.left,root.right);
        return root;
    }

    void connectTwoNode(Node node1,Node node2) {
        if(node1 == null || node2 == null) return;

        node1.next = node2;
        //�������ڵ�
        connectTwoNode(node1.left,node1.right);
        connectTwoNode(node2.left,node2.right);
        //�޹������ڵ�
        connectTwoNode(node1.right,node2.left);

    }

}
