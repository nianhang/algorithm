package cn.sjtu.model.tree.convertbst_538_0905;

import cn.sjtu.model.tree.TreeNode;

/**
 * @author ��linfd
 * @version :medium$
 * @date ��Created in 2021-10-07 17:06
 * @description���Ѷ���������ת��Ϊ�ۼ���
 */

public class Solution {

    /**
     * leetcode 538�� �Ѷ���������ת��Ϊ�ۼ���
     * @param root
     * @return
     */
    public TreeNode convertBST(TreeNode root) {
        traverseAddTree(root);
        return root;
    }
    int addTreeSum = 0;
    void traverseAddTree(TreeNode root){
        if(root == null) return;
        traverseAddTree(root.right);

        addTreeSum += root.val;
        root.val = addTreeSum;
        //System.out.println(root.val);

        traverseAddTree(root.left);
    }


}
