package cn.sjtu.model.tree.maxsumbst_1373_0908;

import cn.sjtu.model.tree.TreeNode;

/**
 * @author ：linfd
 * @version :hard$
 * @date ：Created in 2021-10-07 17:17
 * @description：二叉搜索子树的最大键值和
 */

public class Solution {

    // 美团面试后续遍历 9.08

    /**
     * leetcode第1373题 二叉搜索子树的最大键值和
     * @param root
     * @return
     */
    // 二叉搜索子树的最大键值和
    int maxSum = 0;
    public int maxSumBST(TreeNode root) {
        traverseMaxSumBST(root);
        return maxSum;
    }

    /**
     * res[0]记录以root为根的二叉树是否是 BST，若为 1 则说明是 BST，若为 0 则说明不是 BST；
     *
     * res[1]记录以root为根的二叉树所有节点中的最小值；
     *
     * res[2]记录以root为根的二叉树所有节点中的最大值；
     *
     * res[3]记录以root为根的二叉树所有节点值之和。
     * @param root
     * @return
     */

    int[] traverseMaxSumBST(TreeNode root){
        if(root == null){
            return new int[]{
                    1,Integer.MAX_VALUE,Integer.MIN_VALUE,0
            };
        }

        int[] left = traverseMaxSumBST(root.left);
        int[] right = traverseMaxSumBST(root.right);

        int[] res = new int[4];
        // 这个 if 在判断以 root 为根的二叉树是不是 BST
        if(left[0] == 1 && right[0] == 1 &&
                root.val > left[2] && root.val < right[1]){
            //判断是BST树
            res[0] = 1;

            // 计算以 root 为根的这棵 BST 的最小值
            res[1] = Math.min(root.val,left[1]);

            // 计算以 root 为根的这棵 BST 的最大值
            res[2] = Math.max(root.val,right[2]);
            // 计算以 root 为根的这棵 BST 所有节点之和
            res[3] = root.val + left[3] + right[3];
            // 更新全局变量
            maxSum = Math.max(maxSum,res[3]);
        }else {
            res[0] = 0;
        }
        return res;

    }

}
