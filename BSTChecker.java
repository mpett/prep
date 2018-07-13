package test;

public class BSTChecker {
	public static class Node {
		int data;
		Node left, right;
		
		public Node(int data) {
			this.data = data;
			left = null;
			right = null;
		}
	}
	
	public static void main(String[] args) {
		System.out.println("Hello World");
	}
	
	public boolean checkBST(Node root) {
		return checkBST(root, 0, 10000);
	}

	public boolean checkBST(Node root, int minValue, int maxValue) {
		if (root == null) {
			return true;
		}
		
		if (root.data < minValue || root.data > maxValue) {
			return false;
		}
		
		return (checkBST(root.left, minValue, root.data - 1)
				&& checkBST(root.right, root.data + 1, maxValue));
	}
}
