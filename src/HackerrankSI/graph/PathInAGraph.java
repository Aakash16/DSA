package HackerrankSI.graph;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Iterator;
import java.util.LinkedList;

public class PathInAGraph {

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

			// graph.printAll();
			int qc = Integer.parseInt(br.readLine());
			out.write("Test Case #" + (t + 1) + ":\n");
			for (int i = 0; i < qc; i++) {
				ints = br.readLine().trim().split("\\s+");
				int fr = Integer.parseInt(ints[0]);
				int to = Integer.parseInt(ints[1]);
				boolean is = graph.bfs(fr, to);
				if (is) {
					out.write("Yes\n");
				} else {
					out.write("No\n");
				}
			}
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

		boolean bfs(int s, int d) {

			boolean visited[] = new boolean[v];

			LinkedList<Integer> queue = new LinkedList<Integer>();

			visited[s] = true;
			queue.add(s);

			while (queue.size() != 0) {
				s = queue.poll();
				if (s == d) {
					return true;
				}
				// System.out.print(s+" ");

				Iterator<Integer> i = adj[s].listIterator();
				while (i.hasNext()) {
					int n = i.next();
					if (n < visited.length && !visited[n]) {
						visited[n] = true;
						queue.add(n);
					}
				}
			}

			return false;
		}

		private void printAll() {

			for (int j = 0; j < adj.length; j++) {
				Iterator<Integer> i = adj[j].listIterator();
				while (i.hasNext()) {
					int n = i.next();
					System.out.print(n + " ");
				}
				System.out.println();
			}

		}
	}

}
