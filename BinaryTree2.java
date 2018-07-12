package test;

import java.util.LinkedList;
import java.util.Queue;

public class BinaryTree2 {
	static class Node {
		int value;
		Node left, right;
		
		public Node(int value) {
			this.value = value;
		}
	}
	
	private static Node root;
	
	public static void main(String[] args) {
		BinaryTree2 bt = new BinaryTree2();
		bt.add(6);
		bt.add(4);
		bt.add(234);
		bt.add(8);
		bt.add(3);
		bt.add(5);
		bt.add(7);
		bt.add(9);
		System.out.println(contains(234));
		bt.delete(234);
		System.out.println(contains(234));
		inOrderTraversal(bt.root);
		System.out.println();
		preOrderTraversal(bt.root);
		System.out.println();
		postOrderTraversal(bt.root);
		System.out.println();
		levelOrderTraversal();
	}
	
	public static Node addRecursive(Node current, int value) {
		if (current == null) {
			return new Node(value);
		}
		
		if (value < current.value) {
			current.left = addRecursive(current.left, value);
		} else if (value > current.value) {
			current.right = addRecursive(current.right, value);
		} else {
			return current;
		}
		
		return current;
	}
	
	public static void add(int value) {
		root = addRecursive(root, value);
	}
	
	public static boolean containsRecursive(Node current, int value) {
		if (current == null) {
			return false;
		}
		
		if (current.value == value) {
			return true;
		}
		
		return value < current.value ? containsRecursive(current.left, value) 
				: containsRecursive(current.right, value);
	}
	
	public static boolean contains(int value) {
		return containsRecursive(root, value);
	}
	
	public static Node deleteRecursive(Node current, int value) {
		if (current == null) {
			return null;
		}
		
		if (current.value == value) {
			if (current.left == null && current.right == null) {
				return null;
			}
			
			if (current.right == null) {
				return current.left;
			}
			
			if (current.left == null) {
				return current.right;
			}
			
			int smallestValue = findSmallestValue(current.right);
			current.value = smallestValue;
			current.right = deleteRecursive(current.right, smallestValue);
			return current;
		}
		
		if (value < current.value) {
			current.left = deleteRecursive(current.left, value);
			return current;
		}
		
		current.right = deleteRecursive(current.right, value);
		return current;
	}
	
	public static int findSmallestValue(Node current) {
		return root.left == null ? root.value : findSmallestValue(current.left);
	}
	
	public static void delete(int value) {
		root = deleteRecursive(root, value);
	}
	
	public static void inOrderTraversal(Node node) {
		if (node != null) {
			inOrderTraversal(node.left);
			System.out.print(node.value + " ");
			inOrderTraversal(node.right);
		}
	}
	
	public static void preOrderTraversal(Node node) {
		if (node != null) {
			System.out.print(node.value + " ");
			preOrderTraversal(node.left);
			preOrderTraversal(node.right);
		}
	}
	
	public static void postOrderTraversal(Node node) {
		if (node != null) {
			postOrderTraversal(node.left);
			postOrderTraversal(node.right);
			System.out.print(node.value + " ");
		}
	}
	
	public static void levelOrderTraversal() {
		if (root == null) {
			return;
		}
		
		Queue<Node> nodes = new LinkedList<>();
		nodes.add(root);
		
		while (!nodes.isEmpty()) {
			Node node = nodes.remove();
			System.out.print(node.value + " ");
			
			if (node.left != null) {
				nodes.add(node.left);
			}
			
			if (node.right != null) {
				nodes.add(node.right);
			}
		}
	}
}