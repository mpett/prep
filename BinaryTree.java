package test;

import java.util.LinkedList;
import java.util.Queue;

public class BinaryTree {
	static Node root;
	
	public static void main(String[] args) {
		BinaryTree bt = createBinaryTree();
		System.out.println(bt.containsNode(9));
		//bt.delete(9);
		//System.out.println(bt.containsNode(9));
		traverseInOrder(bt.root);
		System.out.println();
		traversePreOrder(bt.root);
		System.out.println();
		traversePostOrder(bt.root);
		System.out.println();
		traverseLevelOrder();
		System.out.println();
	}
	
	private static Node addRecursive(Node current, int value) {
		if (current == null) {
			return new Node(value);
		}
		
		if (value < current.value) {
			current.left = addRecursive(current.left, value);
		} else if (value > current.value) {
			current.right = addRecursive(current.right, value);
		} else {
			// value already exists
			return current;
		}
		return current;
	}
	
	public static void add(int value) {
		root = addRecursive(root, value);
	}
	
	private static BinaryTree createBinaryTree() {
		BinaryTree bt = new BinaryTree();
		
		bt.add(6);
	    bt.add(4);
	    bt.add(8);
	    bt.add(3);
	    bt.add(5);
	    bt.add(7);
	    bt.add(9);
		
		return bt;
	}
	
	public static boolean containsNodeRecursive(Node current, int value) {
		if (current == null) {
			return false;
		}
		
		if (value == current.value) {
			return true;
		}
		
		return value < current.value 
				? containsNodeRecursive(current.left, value) 
						: containsNodeRecursive(current.right, value);
		
	}
	
	public static boolean containsNode(int value) {
		return containsNodeRecursive(root, value);
	}
	
	private static Node deleteRecursive(Node current, int value) {
		if (current == null) {
			return null;
		}
		
		if (value == current.value) {
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
	
	private static int findSmallestValue(Node root) {
		return root.left == null ? root.value : findSmallestValue(root.left);
	}
	
	public static void delete(int value) {
		deleteRecursive(root, value);
	}
	
	// DFS starts here
	
	public static void traverseInOrder(Node node) {
		if (node != null) {
			traverseInOrder(node.left);
			System.out.print(" " + node.value);
			traverseInOrder(node.right);
		}
	}
	
	public static void traversePreOrder(Node node) {
		if (node != null) {
			System.out.print(" " + node.value);
			traversePreOrder(node.left);
			traversePreOrder(node.right);
		}
	}
	
	public static void traversePostOrder(Node node) {
		if (node != null) {
			traversePostOrder(node.left);
			traversePostOrder(node.right);
			System.out.print(" " + node.value);
		}
	}
	
	// BFS starts here
	
	public static void traverseLevelOrder() {
		if (root == null) {
			return;
		}
		
		Queue<Node> nodes = new LinkedList<>();
		nodes.add(root);
		
		while (!nodes.isEmpty()) {
			Node node = nodes.remove();
			
			System.out.print(" " + node.value);
			
			if (node.left != null) {
				nodes.add(node.left);
			}
			
			if (node.right != null) {
				nodes.add(node.right);
			}
		}
	}
	
	static class Node {
		int value;
		Node left;
		Node right;
		
		Node (int value) {
			this.value = value;
			right = null;
			left = null;
		}	
	}
}
