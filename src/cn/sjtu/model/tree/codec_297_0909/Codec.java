package cn.sjtu.model.tree.codec_297_0909;

import cn.sjtu.model.tree.TreeNode;

import java.util.LinkedList;

/**
 * @author ：linfd
 * @version :hard$
 * @date ：Created in 2021-10-07 17:19
 * @description： 二叉树的序列化与反序列化
 */

public class Codec {


    //二叉树的题，就那几个框架，枯燥至极  9.09

    /**
     * leetcode 第297题 二叉树的序列化与反序列化
     * @param root
     * @return
     */

    //前序遍历
    // Encodes a tree to a single string.
    String SEP = ",";
    String NULL = "#";
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        serialize(root,sb);
        return sb.toString();
    }
    /* 辅助函数，将二叉树存入 StringBuilder */
    void serialize(TreeNode root,StringBuilder sb){
        if(root == null){
            sb.append(NULL).append(SEP);
            return;
        }
        /****** 前序遍历位置 ******/
        sb.append(root.val).append(SEP);
        /***********************/

        serialize(root.left,sb);
        serialize(root.right,sb);
    }


    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        LinkedList<String> nodes = new LinkedList<>();
        for(String s : data.split(SEP)){
            nodes.addLast(s);
        }
        return deserialize(nodes);
    }

    /* 辅助函数，通过 nodes 列表构造二叉树 */
    TreeNode deserialize(LinkedList<String> nodes) {
        if(nodes.isEmpty()) return null;
        /****** 前序遍历位置 ******/
        // 列表最左侧就是根节点
        String first = nodes.removeFirst();
        if(first.equals(NULL)) return null;
        TreeNode root = new TreeNode(Integer.parseInt(first));
        /***********************/

        root.left = deserialize(nodes);
        root.right = deserialize(nodes);
        return root;
    }



    //后续遍历
    // Encodes a tree to a single string.
    public String serializeLast(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        serializeLast(root,sb);
        return sb.toString();
    }
    /* 辅助函数，将二叉树存入 StringBuilder */
    void serializeLast(TreeNode root,StringBuilder sb){
        if(root == null){
            sb.append(NULL).append(SEP);
            return;
        }
        serialize(root.left,sb);
        serialize(root.right,sb);

        /****** 前序遍历位置 ******/
        sb.append(root.val).append(SEP);
        /***********************/
    }


    // Decodes your encoded data to tree.
    public TreeNode deserializeLast(String data) {
        LinkedList<String> nodes = new LinkedList<>();
        for(String s : data.split(SEP)){
            nodes.addLast(s);
        }
        return deserializeLast(nodes);
    }

    /* 辅助函数，通过 nodes 列表构造二叉树 */
    TreeNode deserializeLast(LinkedList<String> nodes) {
        if(nodes.isEmpty()) return null;

        /****** 前序遍历位置 ******/
        // 列表最右侧就是根节点
        String last = nodes.removeLast();
        if(last.equals(NULL)) return null;
        TreeNode root = new TreeNode(Integer.parseInt(last));
        /***********************/
        // 限构造右子树，后构造左子树
        root.right = deserialize(nodes);
        root.left = deserialize(nodes);

        return root;
    }

}
