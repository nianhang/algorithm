package cn.sjtu.model.tree.deletenode_450_0906;

import cn.sjtu.model.tree.TreeNode;

/**
 * @author ：linfd
 * @version :medium$
 * @date ：Created in 2021-10-07 17:11
 * @description：删除二叉搜索树中的节点
 */

public class Solution {

    /**
     * leetcode 450题   删除二叉搜索树(BST)中的节点
     * @param root
     * @param key
     * @return
     */
    public TreeNode deleteNode(TreeNode root, int key) {

        if(root == null) return null;
        if(root.val == key){
            //如果root无子节点，可以直接删除
            if(root.left == null && root.right == null){
                return null;
            }
            //删除的节点只有一个节点，左节点或者右节点
            if(root.left == null) return root.right;
            if(root.right == null) return root.left;
            //两个节点都有值
            if(root.left != null && root.right != null){
                // 找到右子树的最小节点
                TreeNode minNode = getMin(root.right);
                // 把 root 改成 minNode
                root.val = minNode.val;
                // 转而去删除 minNode
                root.right = deleteNode(root.right,minNode.val);
            }
        } else if(root.val > key){
            root.left = deleteNode(root.left,key);
        }else{
            root.right = deleteNode(root.right,key);
        }
        return root;

    }
    //获得二叉搜索树（BST）的最小节点
    TreeNode getMin(TreeNode node){
        while(node.left != null){
            node = node.left;
        }
        return node;
    }

}
