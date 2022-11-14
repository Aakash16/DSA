package HackerrankSI.tree;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Full {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(
                System.out));

        int l = Integer.parseInt(br.readLine());

        for (int tc = 0; tc < l; tc++) {
            int len = Integer.parseInt(br.readLine());
            String[] s = br.readLine().split("\\s+");

            int[] ar = new int[len];

            Node root = new Node(Integer.parseInt(s[0]));
            
            for (int i = 1; i < len; i++) {
                ar[i] = Integer.parseInt(s[i]);
                insert(root, ar[i]);
            }

        }

        br.close();
        out.close();

    }


    private static boolean isFull(Node root) {
    	return false;
    }
    
    private static Node insert(Node root, int x) {

        if (root == null) {
            root = new Node(x);
            return root;
        }

        if (x > root.data) {
            root.right = insert(root.right, x);
        } else if (x < root.data) {
            root.left = insert(root.left, x);
        } else {
            return root;
        }

        return root;
    }

    static class Node {

        int data;
        Node left;
        Node right;

        public Node() {
        }

        public Node(int data) {
            super();
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

}
