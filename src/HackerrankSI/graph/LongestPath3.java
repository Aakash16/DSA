package HackerrankSI.graph;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Iterator;
import java.util.LinkedList;

public class LongestPath3 {
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

			for (int i = 1; i <= nc; i++) {
				graph.addEdge(i, 0);
			}

			int k = graph.bfs_getFarthest(1);
			System.out.println(k);
			int d = graph.bfs_getMaxLen(k);
			System.out.println(d);

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
			if (w != 0)
				adj[w].add(v);

		}

		int bfs_getMaxLen(int s) {

			LinkedList<Integer> queue = new LinkedList<Integer>();
			boolean[] visited = new boolean[v];

			queue.add(s);

			int d = 0;
			int max = 0;

			while (queue.size() != 0) {
				s = queue.poll();

				if (visited[s])
					continue;
				else
					visited[s] = true;

				System.out.print(s + " ");

				Iterator<Integer> i = adj[s].listIterator();
				while (i.hasNext()) {
					int n = i.next();
					queue.add(n);
					d++;

					if (n == 0) {
						max = Math.max(d, max);
						d = 0;
					}
				}

			}

			return max;
		}

		int bfs_getFarthest(int s) {

			LinkedList<Integer> queue = new LinkedList<Integer>();
			boolean[] visited = new boolean[v];

			queue.add(s);

			int d = 0;

			while (queue.size() != 0) {
				s = queue.poll();

				if (visited[s])
					continue;
				else
					visited[s] = true;

				d = s;

				// System.out.print(s + " ");

				Iterator<Integer> i = adj[s].listIterator();
				while (i.hasNext()) {
					int n = i.next();
					queue.add(n);

				}

			}

			return d;

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
