package cn.sjtu.model.tree.deletenode_450_0906;

import cn.sjtu.model.tree.TreeNode;

/**
 * @author ��linfd
 * @version :medium$
 * @date ��Created in 2021-10-07 17:11
 * @description��ɾ�������������еĽڵ�
 */

public class Solution {

    /**
     * leetcode 450��   ɾ������������(BST)�еĽڵ�
     * @param root
     * @param key
     * @return
     */
    public TreeNode deleteNode(TreeNode root, int key) {

        if(root == null) return null;
        if(root.val == key){
            //���root���ӽڵ㣬����ֱ��ɾ��
            if(root.left == null && root.right == null){
                return null;
            }
            //ɾ���Ľڵ�ֻ��һ���ڵ㣬��ڵ�����ҽڵ�
            if(root.left == null) return root.right;
            if(root.right == null) return root.left;
            //�����ڵ㶼��ֵ
            if(root.left != null && root.right != null){
                // �ҵ�����������С�ڵ�
                TreeNode minNode = getMin(root.right);
                // �� root �ĳ� minNode
                root.val = minNode.val;
                // ת��ȥɾ�� minNode
                root.right = deleteNode(root.right,minNode.val);
            }
        } else if(root.val > key){
            root.left = deleteNode(root.left,key);
        }else{
            root.right = deleteNode(root.right,key);
        }
        return root;

    }
    //��ö�����������BST������С�ڵ�
    TreeNode getMin(TreeNode node){
        while(node.left != null){
            node = node.left;
        }
        return node;
    }

}
