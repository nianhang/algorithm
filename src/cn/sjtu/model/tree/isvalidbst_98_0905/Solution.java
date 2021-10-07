package cn.sjtu.model.tree.isvalidbst_98_0905;

import cn.sjtu.model.tree.TreeNode;

/**
 * @author ��linfd
 * @version :medium$
 * @date ��Created in 2021-10-07 17:07
 * @description����֤����������
 */

public class Solution {

    //�������������ڶ��ڣ�
    /**
     * leetcode 98�� ��֤������������BST��
     * @param root
     * @return
     */
    public boolean isValidBST(TreeNode root) {
        return isValidBSTWithTreeParam(root,null,null);
    }

    /* �޶��� root Ϊ���������ڵ�������� max.val > root.val > min.val */
    boolean isValidBSTWithTreeParam(TreeNode root,TreeNode min,TreeNode max){
        if(root == null) return true;
        // �� root.val ������ max �� min �����ƣ�˵�����ǺϷ� BST
        if(min != null && root.val <= min.val) return false;
        if(max != null && root.val >= max.val) return false;
        // �޶������������ֵ�� root.val������������Сֵ�� root.val
        return isValidBSTWithTreeParam(root.left,min,root)
                && isValidBSTWithTreeParam(root.right,root,max);
    }
}
