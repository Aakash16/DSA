package HackerrankSI.graph;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class LongestPath {

	ArrayList<Integer> al[];

	public LongestPath(int v) {

		al = new ArrayList[v + 1];
		for (int i = 0; i <= v; i++) {
			al[i] = new ArrayList<Integer>();
		}
	}

	public void add( int u, int v) {
		al[u].add(v);
		al[v].add(u);
	}

	public static void main(String[] arg) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int T = Integer.parseInt(br.readLine());
		for (int t = 0; t < T; t++) {
			String[] inp = br.readLine().split("\\s+");
			int vertics = Integer.parseInt(inp[0]);
			int edge = Integer.parseInt(inp[1]);
			LongestPath g = new LongestPath(vertics);
			for (int i = 0; i < edge; i++) {
				inp = br.readLine().split("\\s+");
				int u = Integer.parseInt(inp[0]);
				int v = Integer.parseInt(inp[1]);
				g.add(u, v);
			}
			Pair p = BFS(g, 1);
			Pair ans = BFS(g, p.vertex);
			bw.write(ans.distance + "\n");
		}
		br.close();
		bw.close();
	}

	public static Pair BFS(LongestPath g, int src) {
		Queue<Integer> q = new LinkedList<Integer>();
		int maxVal = Integer.MIN_VALUE;
		int len = g.al.length;
		int[] distance = new int[len];
		Arrays.fill(distance, Integer.MIN_VALUE);
		q.add(src);
		distance[src] = 0;
		while (!q.isEmpty()) {
			int n = q.poll();

			for (Integer i : g.al[n]) {

				if (distance[i] == Integer.MIN_VALUE) {
					q.add(i);
					distance[i] = distance[n] + 1;
				}
			}
		}
		int ver = 0;
		for (int j = 0; j < len; j++) {
			if (distance[j] > maxVal) {
				maxVal = distance[j];
				ver = j;
			}
		}
		return new Pair(ver, maxVal);
	}

}

class Pair {

	int vertex;
	int distance;

	public Pair(int v, int d) {
		vertex = v;
		distance = d;
	}

}
