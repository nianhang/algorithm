package cn.sjtu.model.tree.insertintobst_701_0906;

import cn.sjtu.model.tree.TreeNode;

/**
 * @author ��linfd
 * @version :medium$
 * @date ��Created in 2021-10-07 17:10
 * @description�������������еĲ������
 */

public class Solution {

    /**
     * leetcode 701��  ������������BST���еĲ������,����һ������
     * @param root
     * @param val
     * @return
     */
    public TreeNode insertIntoBST(TreeNode root, int val) {
        // �ҵ���λ�ò����½ڵ�
        if(root == null) return new TreeNode(val);

        if(root.val < val){
            root.right = insertIntoBST(root.right,val);
        }else if(root.val > val){
            root.left = insertIntoBST(root.left,val);
        }
        return root;
    }

}
