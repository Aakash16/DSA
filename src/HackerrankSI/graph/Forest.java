package HackerrankSI.graph;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;

public class Forest {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		int tc = Integer.parseInt(br.readLine());

		for (int t = 0; t < tc; t++) {

			String[] ints = br.readLine().trim().split("\\s+");

			int n = Integer.parseInt(ints[0]);
			int m = Integer.parseInt(ints[1]);

			Graph graph = new Graph(n);
			for (int i = 0; i < m; i++) {
				ints = br.readLine().trim().split("\\s+");
				int fr = Integer.parseInt(ints[0]);
				int to = Integer.parseInt(ints[1]);
				graph.addEdge(fr, to);

			}

			boolean isCyc = graph.isCycle();
			if (isCyc)
				out.write("No\n");
			else
				out.write("Yes\n");
		}

		out.flush();
		br.close();
		out.close();

	}

	static class Graph {
		int v;
		LinkedList<Integer>[] adj;

		public Graph(int v) {
			this.v = v + 1;
			adj = new LinkedList[v + 1];
			for (int i = 0; i <= v; i++) {
				adj[i] = new LinkedList<>();
			}
		}

		public void addEdge(int s, int d) {
			adj[s].add(d);
			adj[d].add(s);
		}

		public boolean isCycle() {
			boolean result = false;

			boolean[] visited = new boolean[v];
			for (int i = 0; i < v; i++) {
				if (visited[i] == false) {
					if (dfs(i, -1, visited)) {
						return true;
					}
				}
			}
			return result;
		}

		boolean dfs(int d, int s, boolean[] visited) {

			visited[d] = true;

			for (int i = 0; i < adj[d].size(); i++) {
				int v = adj[d].get(i);
				if (v != s) {
					if (visited[v]) {
						return true;
					} else {
						if (dfs(v, d, visited)) {
							return true;
						}
					}
				}
			}
			return false;
		}
	}

}
