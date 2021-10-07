package cn.sjtu.model.tree.sortedarraytobst_108_0915;

import cn.sjtu.model.tree.TreeNode;

/**
 * @author ：linfd
 * @version :$
 * @date ：Created in 2021-09-15 20:19
 * @description：将有序数组转换为二叉搜索树
 */

public class SortedArrayToBST {


    /**
     * 递归
     * @param nums
     * @return
     */
    public TreeNode sortedArrayToBSTRecursion(int[] nums) {

        if(nums == null ) return null;

        return dfs(nums,0,nums.length-1);

    }

    private TreeNode dfs(int[] nums,int start,int end){
        if(nums == null || start > end) return null;
        //注意mid 是动态变化的，需要从start开始为开始；
        int mid = start + (end - start)/2;
        TreeNode root = new TreeNode(nums[mid]);

        TreeNode left = dfs(nums, start,mid-1);

        TreeNode  right= dfs(nums,mid+1,end);

        root.left = left;
        root.right = right;
        return root;
    }
}
