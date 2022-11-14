package HackerrankSI.graph;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.PriorityQueue;

public class Dijkstra {

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
				int wt = Integer.parseInt(ints[2]);
				graph.addEdge(fr, to, wt);
			}

			// graph.printAll();
			int src = Integer.parseInt(br.readLine());

			int[] d = graph.dijkstra(src);
			/*
			 * for (int i = 1; i <= nc; i++) { if (i != src) { int min = out.write(min +
			 * " "); } }
			 */
			
			for(int i=1;i<src;i++)
				out.write(d[i] + " ");
			   out.write("\n");

		}

		out.flush();
		br.close();
		out.close();
	}

	static class Graph {

		private ArrayList<Paiir> adj[];

		static class Paiir implements Comparable<Paiir> {
			int u;
			int wt;

			public Paiir(int u, int wt) {
				this.u = u;
				this.wt = wt;
			}

			@Override
			public int compareTo(Paiir o) {
				// TODO Auto-generated method stub
				return o.wt;
			}
		}

		Graph(int count) {
			adj = new ArrayList[count + 1];
			for (int i = 0; i < (count + 1); ++i)
				adj[i] = new ArrayList<Paiir>();
		}

		void addEdge(int v, int w, int wt) {

			adj[v].add(new Paiir(w, wt));
			adj[w].add(new Paiir(v, wt));

		}

		private void printAll() {

			for (int j = 0; j < adj.length; j++) {
				ArrayList<Paiir> list = adj[j];
				for (int i = 0; i < list.size(); i++) {
					Paiir n = list.get(i);
					System.out.print(n.u + " " + n.wt + " ");
				}
				System.out.println();
			}
		}

		private int[] dijkstra(int src) {
			int[] d = new int[adj.length];
			for (int i = 0; i < d.length; i++) {
				d[i] = Integer.MAX_VALUE;
			}
			d[src] = 0;
			PriorityQueue<Paiir> pq = new PriorityQueue<Paiir>();
			pq.add(new Paiir(src, 0));

			while (!pq.isEmpty()) {
				Paiir p = pq.poll();

				//System.out.println("popped: " + p.u + " wight:" + p.wt);
				int dis = p.wt;
				int u = p.u;

				if (dis == d[u]) {

					//System.out.println("for " + u + " " + adj[u].size());
					for (Paiir q : adj[u]) {
						int v = q.u;
						int w = q.wt;
						int nd = dis + w;

						//System.out.println("loop " + v + " " + w + " " + nd);
						if (nd < d[v]) {
							Paiir pp = new Paiir(v, nd);
							pq.add(pp);
							//System.out.println("added " + v);
							d[v] = nd;
						}
					}
				}
			}

			/*
			 * if (d[des] == Integer.MAX_VALUE) { return -1; } else { return d[des]; }
			 */
			return d;
		}
	}

}
