package practice;

import java.util.Stack;

public class PallindromLinklist {
	static class Node{
		int data;
		Node next;
		Node(int data){
			this.data = data;
			this.next = null;
		}
	}
	public static void main(String[] args) {
		Node node1 = new Node(1);
		Node node2 = new Node(2);
		Node node3 = new Node(3);
		Node node4 = new Node(6);
		Node node5 = new Node(3);
		Node node6 = new Node(2);
		Node node7 = new Node(1);
		
		node1.next = node2; 
		node2.next = node3; 
		node3.next = node4; 
		node4.next = node5; 
		node5.next = node6; 
        node6.next = node7; 
        boolean condition = isPalindrome(node1); 
        System.out.println("isPalidrome :" + condition);
		
	}
	private static boolean isPalindrome(Node root) {
		Node temp  = root;
		Stack<Integer> stack = new Stack<Integer>();
		boolean flag = false;
		while(root != null) {
			stack.push(root.data);
			root = root.next;
		}
		while(temp != null) {
			if(temp.data == stack.pop()){
				flag = true;
			}else {
				return false;
			}
			temp = temp.next;
		}
		return flag;
	}

}
