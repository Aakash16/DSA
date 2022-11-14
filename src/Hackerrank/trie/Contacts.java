package Hackerrank.trie;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Scanner;

public class Contacts {

	static class Trie {
		int cnt;
		Trie[] c;
		public Trie() {
			cnt = 0;
			c = new Trie[26];
		}
	}

	/*
	 * Complete the contacts function below.
	 */

	static void contacts(String[][] q, BufferedWriter bufferedWriter)throws IOException {
        Trie contact = new Trie();
        int len = q.length;
        for (int i = 0; i < len; i++) {
            //System.out.println("op " + q[i][0]);
            switch (q[i][0]) {

            case "add":
                //System.out.println("add " + q[i][1]);
                add(q[i][1], contact);
                break;

            case "find":
                int k = find(q[i][1], contact);
                bufferedWriter.write(k+"\n");
                //System.out.println(k);
                break;
            }
        }
    }

    private static void add(String A, Trie root) {

        for (int i = 0; i < A.length(); i++) {
            char ch = A.charAt(i);
            int idx = ch - 'a';
            if (root.c[idx] == null) {
                root.cnt = 1;
                root.c[idx] = new Trie();
                //System.out.println("storing " + ch);
                root = root.c[idx];
            } else {
                //root.cnt++;
                //System.out.println("already presnt " + ch);
            	root.cnt++;
                root = root.c[idx];
                //if(root != null)
                	
            }
        }
        
        
    }

    private static int find(String A, Trie root) {
        if (root == null)
            return 0;

        int l = 0;
        for (int i = 0; i < A.length(); i++) {
            int ch = A.charAt(i) - 'a';
            if (root.c[ch] == null) {
                l = 0;
                break;
            }

            l = root.cnt;
            //System.out.println("found " + ch + " " +root.cnt);
            root = root.c[ch];
           
        }
        return l;
    }

	private static final Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) throws IOException {

		BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

		int queriesRows = Integer.parseInt(scanner.nextLine().trim());

		String[][] queries = new String[queriesRows][2];

		for (int queriesRowItr = 0; queriesRowItr < queriesRows; queriesRowItr++) {
			String[] queriesRowItems = scanner.nextLine().split(" ");

			for (int queriesColumnItr = 0; queriesColumnItr < 2; queriesColumnItr++) {
				String queriesItem = queriesRowItems[queriesColumnItr];
				queries[queriesRowItr][queriesColumnItr] = queriesItem;
			}
		}

		contacts(queries, bufferedWriter);

		bufferedWriter.newLine();

		bufferedWriter.close();
	}
}
