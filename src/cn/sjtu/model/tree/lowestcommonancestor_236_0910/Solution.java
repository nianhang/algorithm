package cn.sjtu.model.tree.lowestcommonancestor_236_0910;

import cn.sjtu.model.tree.TreeNode;

/**
 * @author ��linfd
 * @version :medium$
 * @date ��Created in 2021-10-07 17:24
 * @description���������������������
 */

public class Solution {

    /**
     * leetCode ��236�⣬�������������������
     * @param root
     * @param p
     * @param q
     * @return
     */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        //���������base case
        if(root == null) return null;
        if(root == p || root == q) return root;

        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        //��� 1�����p��q������rootΪ�������У���ôleft��rightһ���ֱ���p��q���� base case �������ģ���
        if(left != null && right !=null){
            return root;
        }
        //��� 2�����p��q��������rootΪ�������У�ֱ�ӷ���null��
        if(left == null && right == null){
            return null;
        }
        //��� 3�����p��qֻ��һ��������rootΪ�������У��������ظýڵ㡣
        return left == null ? right : left;
    }

}
