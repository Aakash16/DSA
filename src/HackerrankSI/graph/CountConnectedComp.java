package HackerrankSI.graph;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;

public class CountConnectedComp {
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));

		int tc = Integer.parseInt(br.readLine());

		for (int t = 0; t < tc; t++) {

			String[] ints = br.readLine().trim().split("\\s+");
			int nc = Integer.parseInt(ints[0]);
			int ec = Integer.parseInt(ints[1]);

			Graph graph = new Graph(nc);

			for (int i = 0; i < ec; i++) {
				ints = br.readLine().trim().split("\\s+");
				int fr = Integer.parseInt(ints[0]);
				int to = Integer.parseInt(ints[1]);
				graph.addEdge(fr, to);
			}

			int c = graph.connectedComponents();
			out.write(c + "\n");
		}

		out.flush();
		br.close();
		out.close();
	}

	static class Graph {
		private int v;
		private LinkedList<Integer> adj[];

		Graph(int c) {
			v = c + 1;
			adj = new LinkedList[c + 1];
			for (int i = 0; i <= c; ++i)
				adj[i] = new LinkedList();
		}

		void addEdge(int v, int w) {

			adj[v].add(w);
			adj[w].add(v);

		}

		void markNodes(int v, boolean[] visited) {
			visited[v] = true;
			for (int n : adj[v]) {
				if (!visited[n])
					markNodes(n, visited);
			}

		}

		int connectedComponents() {
			int c = 0;
			boolean[] visited = new boolean[v];
			for (int i = 1; i < v; ++i) {
				if (!visited[i]) {
					c++;
					markNodes(i, visited);
				}
			}

			return c;
		}
	}

}
