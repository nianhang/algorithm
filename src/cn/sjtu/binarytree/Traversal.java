package cn.sjtu.binarytree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Traversal {

	public static void main(String[] args) {
		
		TreeNode t1 = new TreeNode(1);
		TreeNode t2 = new TreeNode(2);
		TreeNode t3 = new TreeNode(3);
		TreeNode t4 = new TreeNode(4);
		TreeNode t5 = new TreeNode(5);
		TreeNode t6 = new TreeNode(6);
		TreeNode t7 = new TreeNode(7);
		
		t1.left = t2;
		t1.right = t3;
		t2.left = t4;
		t2.right = t5;
		t3.left = t6;
		t3.right = t7;
		
		/*preOrderTraverse1(t1);
		System.out.println();
		preOrderTraverse2(t1);
		System.out.println();
		
		inOrderTraverse1(t1);
		System.out.println();
		inOrderTraverse2(t1);
		System.out.println();*/
		
		
		postOrderTraverse1(t1);
		System.out.println();
		postOrderTraverse2(t1);
		System.out.println();
		
		/*levelOrder1(t1);
		System.out.println();
		levelOrder2(t1);*/
		//System.out.println(depth(t1));
		//System.out.println(depth1(t1));
		
		
	}
	
	
	
	//递归版本的遍历
	
	public static void preOrderTraverse1(TreeNode root){
		
		if(root == null){
			return ;
		}
		System.out.print(root.val+" ");
		preOrderTraverse1(root.left);
		preOrderTraverse1(root.right);
		
	}
	
	public static void inOrderTraverse1(TreeNode root){
		
		if(root == null){
			return ;
		}
		inOrderTraverse1(root.left);
		System.out.print(root.val+" ");
		inOrderTraverse1(root.right);
		
	}
	
	public static void postOrderTraverse1(TreeNode root){
		if(root == null){
			return ;
		}
		postOrderTraverse1(root.left);
		postOrderTraverse1(root.right);
		System.out.print(root.val+" ");
	}
	
	//层次遍历
	public static void levelOrder1(TreeNode root){
		
		if(root == null){
			return;
		}
		
		int depth = depth(root);
		
		for(int i = 0;i <= depth;i++){
			levelOrder(root, i);
		}
			
	}
	
	public static void levelOrder(TreeNode root,int level){
		
		if(root == null || level < 1){
			return;
		}
		if(level == 1){
			System.out.print(root.val+" ");
			return;
		}
		levelOrder(root.left, level-1);
		levelOrder(root.right, level-1);
	}
	
	//求高度
	public static int depth(TreeNode root){
		
		if(root == null){
			return 0;
		}
		int left = depth(root.left);
		int right = depth(root.right);
		return (left>right)?left+1:right+1;
	}
	

	//非递归遍历
		
    //前序遍历就是压入栈中的打印顺序；
	public static void preOrderTraverse2(TreeNode root){
		
		if(root == null){
			return;
		}
		
		TreeNode pNode = root;
		Stack<TreeNode> stack = new Stack<TreeNode>();
		
		while(pNode != null || !stack.isEmpty()){

			if(pNode != null){
				stack.add(pNode);
				System.out.print(pNode.val+" ");
				pNode = pNode.left;
			}else{
				TreeNode node = stack.pop();
				pNode = node.right;
			}
		
		}
		
	}
	
	//中序遍历就是弹出栈的顺序
	public static void inOrderTraverse2(TreeNode root){
		
		if(root == null){
			return;
		}
		
		TreeNode pNode = root;
		Stack<TreeNode> stack = new Stack<TreeNode>();
		
		while(pNode != null || !stack.isEmpty()){
			
			if(pNode != null){
				stack.add(pNode);
				pNode = pNode.left;
			}else{
				TreeNode  node = stack.pop();
				System.out.print(node.val+" ");
				pNode = node.right;
			}
	
		}

	}
	
	//后续遍历用两个栈来表示，然后向右遍历，一个栈表示打印的顺序，一个栈表示操作顺序
	public static void postOrderTraverse2(TreeNode root){
		
		if(root == null){
			return ;
		}
		
		Stack<TreeNode> stack1 = new Stack<TreeNode>();
		Stack<TreeNode> stack2 = new Stack<TreeNode>();
		
		TreeNode pNode = root;
		
		while(pNode != null || !stack1.isEmpty()){
			
			if(pNode != null){
				stack1.push(pNode);
				stack2.push(pNode);
				pNode = pNode.right;//先把右边的压人栈中
			}else{
			    TreeNode node = stack1.pop();
				pNode = node.left;//而后是左边的压人栈中
			}
		
		}
		
		while(!stack2.isEmpty()){
			System.out.print(stack2.pop().val+" ");
		}
		
	
	}
	
	//层次遍历
	public static void levelOrder2(TreeNode root){
		
		if(root == null){
			return;
		}
		
		Queue<TreeNode> queue = new LinkedList<TreeNode>();
		
		queue.add(root);
		
		while(!queue.isEmpty()){
			
			TreeNode pNode = queue.poll();//获取并移除此队列的头
			System.out.print(pNode.val + " ");
			
			if(pNode.left != null){//左节点不为空
				queue.offer(pNode.left);//将指定的元素插入此队列（如果立即可行且不会违反容量限制），
										//当使用有容量限制的队列时，此方法通常要优于 add(E)，后者可能无法插入元素，而只是抛出一个异常。
			}
			
			if(pNode.right != null){//右节点不为空
				queue.offer(pNode.right);
			}
			
		}

	}
	
	//非递归求高度
	//利用层次遍历的算法，设置变量level记录当前节点所在的层数，设置变量last指向当前层的最后一个节点，
	//当处理完当前层的最后一个节点，让level指向+1操作。设置变量cur记录当前层已经访问的节点的个数，当cur等于last时，表示该层访问结束。
	public static int depth1(TreeNode root){
		
		if(root == null){
			return 0;
		}
		
		int level = 0;
		int cur,last;
		
		Queue<TreeNode> queue = new LinkedList<TreeNode>();
		queue.offer(root);
		
		while(!queue.isEmpty()){
			
			cur = 0;//记录本层已经遍历的节点个数 
			last = queue.size();//当遍历完当前层以后，队列里元素全是下一层的元素，队列的长度是这一层的节点的个数  
			
			while(cur < last){//当还没有遍历到本层最后一个节点时循环  
				TreeNode pNode = queue.poll();//出队一个元素  
				cur++;
				//把当前节点的左右节点入队（如果存在的话） 
				if(pNode.left != null){
					queue.offer(pNode.left);
					
				}
				
				if(pNode.right != null){
					queue.offer(pNode.right);
				}
			}
			level++;

		}
		
		return level;
	}
	


}
