package Hackerrank.trie;

import java.util.HashMap;
import java.util.Scanner;

public class Contacts2 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		Trie trie = new Trie();
		for (int i = 0; i < n; i++) {
			String operation = scan.next();
			String contact = scan.next();
			if (operation.equals("add")) {
				trie.add(contact);
			} else if (operation.equals("find")) {
				System.out.println(trie.find(contact));
			}
		}
		scan.close();
	}
}

class TrieNode {
	private HashMap<Character, TrieNode> children = new HashMap<>();
	public int size = 0;

	public void putChildIfAbsent(char ch) {
		children.putIfAbsent(ch, new TrieNode());
	}

	public TrieNode getChild(char ch) {
		return children.get(ch);
	}
}

class Trie {
	TrieNode root = new TrieNode();

	public void add(String str) {
		TrieNode curr = root;
		for (char ch : str.toCharArray()) {
			curr.putChildIfAbsent(ch);
			curr = curr.getChild(ch);
			curr.size++;
		}
	}

	public int find(String prefix) {
		TrieNode curr = root;
		for (char ch : prefix.toCharArray()) {
			curr = curr.getChild(ch);
			if (curr == null) {
				return 0;
			}
		}
		return curr.size;
	}
}