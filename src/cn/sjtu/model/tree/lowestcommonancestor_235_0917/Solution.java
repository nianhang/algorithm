package cn.sjtu.model.tree.lowestcommonancestor_235_0917;

import cn.sjtu.model.tree.TreeNode;

import java.util.LinkedList;
import java.util.List;

/**
 * @author ：linfd
 * @version :$
 * @date ：Created in 2021-09-17 11:44
 * @description：二叉搜索树的最近公共祖先
 */

public class Solution {

    /**
     *一次遍历迭代
     * @param root
     * @param p
     * @param q
     * @return
     */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        TreeNode ancestor = root;
        //如果两个节点值都比当前节点小，最近公共祖先在左子树上
        //如果两个节点值都比当前节点大，最近工作祖先在右子树上
        //如果不是，就是当前节点
        while(true){
            if(p.val < ancestor.val && q.val < ancestor.val){
                ancestor = ancestor.left;
            }else if(p.val > ancestor.val && q.val > ancestor.val){
                ancestor = ancestor.right;
            }else {
                break;
            }
        }
        return ancestor;
    }

    /**
     * 递归调用
     * @param root
     * @param p
     * @param q
     * @return
     */
    public TreeNode lowestCommonAncestorWithRecursion(TreeNode root, TreeNode p, TreeNode q){

        if(root.val > p.val && root.val > q.val){
            return lowestCommonAncestorWithRecursion(root.left,p,q);
        }
        if(root.val < p.val && root.val < q.val){
            return lowestCommonAncestorWithRecursion(root.right,p,q);
        }
        return root;
    }


    /**
     * 两次遍历，把两个目标节点的路径全部找出来
     * @param root
     * @param p
     * @param q
     * @return
     */
    public TreeNode lowestCommonAncestorWithTwo(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null) return null;
        TreeNode ancestor = root;

        List<TreeNode> pPathList = getPathTreeNode(root, p);
        List<TreeNode> qPathList = getPathTreeNode(root,q);

        for(int i = 0;i<Math.min(pPathList.size(),qPathList.size());i++){
            if(pPathList.get(i) == qPathList.get(i)){
                ancestor = pPathList.get(i);
            }else {
                break;
            }
        }
        return ancestor;
    }

    public List<TreeNode> getPathTreeNode(TreeNode node,TreeNode targetNode){
        List<TreeNode> treeNodeList = new LinkedList<>();
        if(node.val == targetNode.val){
            treeNodeList.add(node);
            return treeNodeList;
        }
        while(true){
            treeNodeList.add(node);
            if(node.val > targetNode.val){
                node = node.left;
            }else if(node.val < targetNode.val){
                node = node.right;
            }else {
                break;
            }
        }
        return treeNodeList;
    }



}
