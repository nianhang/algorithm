package cn.sjtu.binarytree;

import java.util.List;

public class Testbinarytree {

    public static void main(String[] args) {

        TreeNode rootNode = new TreeNode(1);
        TreeNode leftRootNode = new TreeNode(2);
        TreeNode rightRootNode = new TreeNode(3);
        rootNode.left = leftRootNode;
        rootNode.right = rightRootNode;

        TreeNode leftLeftNode = new TreeNode(4);
        TreeNode leftRightNode = new TreeNode(5);
        TreeNode rightLeftNode = new TreeNode(6);
        TreeNode rightRightNode = new TreeNode(7);

        leftRootNode.left = leftLeftNode;
        leftRootNode.right = leftRightNode;

        rightRootNode.left = rightLeftNode;
        rightRootNode.right = rightRightNode;

        PreOrder preOrder = new PreOrder();
        //preOrder.preOrderRecursive(rootNode);
        List<Integer> nodeList = preOrder.preOrderTraversal(rootNode);
        System.out.println(nodeList.toString());

        System.out.println("+++++++++++++++++++++++++++++++++++++++");

        InOrder inOrder = new InOrder();
        inOrder.preOrderRecursive(rootNode);





    }


}
