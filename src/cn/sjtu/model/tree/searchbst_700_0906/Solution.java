package cn.sjtu.model.tree.searchbst_700_0906;

import cn.sjtu.model.tree.TreeNode;

/**
 * @author ��linfd
 * @version :easy$
 * @date ��Created in 2021-10-07 17:08
 * @description�������������е�����
 */

public class Solution {

    //�ڶ��� 9.06

    /**
     * leetcode 700��  ������������BST���е�����,�� BST ������һ����
     * @param root
     * @param val
     * @return
     */
    //�ݹ�
    public TreeNode searchBST(TreeNode root, int val) {
        if(root == null) return null;

        if(root.val > val) {
            return searchBST(root.left,val);
        }else if(root.val < val){
            return searchBST(root.right,val);
        }else {
            return root;
        }
    }
}
