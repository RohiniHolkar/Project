package tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinaryTree {
	Node root;
	static class Node{
		int data;
		Node left;
		Node right;
		Node(int data){
			this.data= data;
			this.left = null;
			this.right = null;
		}
	}
	public static void main(String args[]) {
		BinaryTree tree = new BinaryTree();
		int a[] = { 1, 2, 3, 4, 5, 6, 6, 6, 6, 6};
		tree.root = crateBinaryTree(a, tree.root, 0);
		//displayUsingInOrder(tree.root);
		//displayUsinPreOrder(tree.root);
		List<Integer> largestValueatlvlLst = new ArrayList<Integer>();
		//largestValueatlvlLst = largestValues(tree.root);
		//System.err.println("Larget value at level : " + largestValueatlvlLst);
		
		tree.boundryTraversal(tree.root);
		
	}
	 
	private void boundryTraversal(Node node) {
		
		if(node == null)
			return;
		System.out.println(node.data + "");
		
		leftBoundry(node.left);
		leaveNodes(node.left);
		leaveNodes(node.right);
		rightBoundry(node.right);
		
		
	}

	private static void rightBoundry(Node node) {
		if(node == null)
			return;
		if(node.right != null) {
			rightBoundry(node.right);
			System.out.println(node.data);
		}
		/*
		 * else if(node.left != null) { rightBoundry(node.left);
		 * System.out.println(node.data); }
		 */
	}

	private static void leaveNodes(Node node) {
		if(node == null)
			return;
		leaveNodes(node.left);
		if(node.left == null && node.right == null)
			System.out.println(node.data);
		leaveNodes(node.right);
	}

	private static void leftBoundry(Node root) {
		if(root == null)
			return;
		if(root.left != null) {
			System.out.println(root.data);
			leftBoundry(root.left);
		}
		/*
		 * else if(root.right != null) { System.out.println(root.data);
		 * leftBoundry(root.right); }
		 */
	}

	private static List<Integer> largestValues(Node root) {
		
		if(root == null) {
			return null;
		}
		List<Integer> largetsValList = new ArrayList<Integer>();
		Queue<Node> q = new LinkedList<Node>();
		int max = Integer.MIN_VALUE;
		int nodeCount;
		q.add(root);
		while(true) {
			nodeCount = q.size();
			if(nodeCount == 0) {
				break;
			}
			while(nodeCount != 0) {
				Node front = q.peek();
				q.remove();
				if(max < front.data)
					max = front.data;
				if(front.left != null)
					q.add(front.left);
				if(front.right != null)
					q.add(front.right);
				nodeCount--;
			}
			largetsValList.add(max);
		}
		
		return largetsValList;
	}

	private static Node crateBinaryTree(int[] a, Node root, int i) {
		if(i < a.length) {
			Node temp = new Node(a[i]);
			root = temp;
			root.left = crateBinaryTree(a, root.left, 2 * i + 1);
			root.right = crateBinaryTree(a, root.right, 2 * i +2);
		}
		return root;
	}
	private static void displayUsingInOrder(Node root) {
		if(root != null) {
			displayUsingInOrder(root.left);
			System.err.println(root.data);
			displayUsingInOrder(root.right);
		}
	}
	private static void displayUsinPreOrder(Node root) {
		if(root != null) {
			System.err.println(root.data);
			displayUsinPreOrder(root.left);
			displayUsinPreOrder(root.right);
		}
	}
	
}
