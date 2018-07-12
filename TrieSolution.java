package test;

import java.util.*;

class TrieNode {
	int count;
	TrieNode[] children;
	
	TrieNode() {
		this.count = 0;
		this.children = new TrieNode[26];
		Arrays.fill(children, null);
	}
	
	public void insert(TrieNode current, String value) {
		for (char c : value.toCharArray()) {
			int index =  c - 'a';
			
			if (current.children[index] == null) {
				current.children[index] = new TrieNode();
			}
			
			current.children[index].count++;
			current = current.children[index];
		}
	}
}

public class TrieSolution {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		TrieNode trie = new TrieNode();
		int n = scan.nextInt();
		
		while (n-- > 0) {
			String operation = scan.next();
			String value = scan.next();
			if (operation.equals("add")) {
				trie.insert(trie, value);
			} else {
				TrieNode currentNode = trie;
				for (char c : value.toCharArray()) {
					currentNode = currentNode.children[c-'a'];
					if (currentNode == null) {
						break;
					}
				}
				System.out.println((currentNode != null) 
						? currentNode.count : 0);
			}
		}
		
		scan.close();
	}
}
