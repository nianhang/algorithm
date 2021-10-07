package cn.sjtu.model.tree.connect_116_0903;

import cn.sjtu.model.tree.Node;

/**
 * @author ：linfd
 * @version :medium$
 * @date ：Created in 2021-10-07 16:55
 * @description：填充每个节点的下一个右侧节点指针
 */

public class Solution {

    /**
     * leetcode 116题 填充每一个节点的下一个右侧节点指针
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
        //公共父节点
        connectTwoNode(node1.left,node1.right);
        connectTwoNode(node2.left,node2.right);
        //无公共父节点
        connectTwoNode(node1.right,node2.left);

    }

}
