package cn.sjtu.model.tree.constructmaximumbinarytree_654_0904;

import cn.sjtu.model.tree.TreeNode;

/**
 * @author ��linfd
 * @version :medium$
 * @date ��Created in 2021-10-07 16:58
 * @description����������
 */

public class Solution {

    /**
     * leetcode 654�� ������������
     * @param nums
     * @return
     */
    public TreeNode constructMaximumBinaryTree(int[] nums) {

        return buildBinaryTree(nums,0,nums.length-1);
    }
    TreeNode buildBinaryTree(int[] nums,int start,int end){
        if(start > end){
            return null;
        }

        int index = -1;
        int maxVal = Integer.MIN_VALUE;
        for(int i = start;i<= end;i++){
            if(nums[i] > maxVal){
                maxVal = nums[i];
                index = i;
            }
        }

        TreeNode root = new TreeNode(maxVal);
        //�ݹ���ù�����������
        root.left = buildBinaryTree(nums, start, index - 1);
        root.right = buildBinaryTree(nums,index+1,end);

        return root;
    }

}
