package cn.sjtu.model.tree;

/**
 * @author ��linfd
 * @version :$
 * @date ��Created in 2021-09-03 22:30
 * @description��
 */

public class TreeNode {

    public int val;
    public TreeNode left;
    public TreeNode right;
    public TreeNode() {}
    public TreeNode(int val) { this.val = val; }
    public TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }

}
