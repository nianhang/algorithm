package cn.sjtu.model.tree.lowestcommonancestor_236_0910;

import cn.sjtu.model.tree.TreeNode;

/**
 * @author ：linfd
 * @version :medium$
 * @date ：Created in 2021-10-07 17:24
 * @description：二叉树的最近公共祖先
 */

public class Solution {

    /**
     * leetCode 第236题，二叉树的最近公共祖先
     * @param root
     * @param p
     * @param q
     * @return
     */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        //两种情况的base case
        if(root == null) return null;
        if(root == p || root == q) return root;

        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        //情况 1，如果p和q都在以root为根的树中，那么left和right一定分别是p和q（从 base case 看出来的）。
        if(left != null && right !=null){
            return root;
        }
        //情况 2，如果p和q都不在以root为根的树中，直接返回null。
        if(left == null && right == null){
            return null;
        }
        //情况 3，如果p和q只有一个存在于root为根的树中，函数返回该节点。
        return left == null ? right : left;
    }

}
