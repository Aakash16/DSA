package HackerrankSI.graph;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LongestPath2 {

	public static void main(String[] arg) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int T = Integer.parseInt(br.readLine());
		for (int t = 0; t < T; t++) {
			
			String[] inp = br.readLine().split("\\s+");
			int vertics = Integer.parseInt(inp[0]);
			int edge = Integer.parseInt(inp[1]);
			
			HashMap<Integer, Node> map = new HashMap<Integer, Node>();
			
			Node tt = null;
			for (int i = 0; i < edge; i++) {
				inp = br.readLine().split("\\s+");
				int u = Integer.parseInt(inp[0]);
				int v = Integer.parseInt(inp[1]);
				
				Node node1 = new Node(u);
				if(!map.containsKey(u)) {
					map.put(u, node1);
				}else {
					node1 = map.get(u);
				}
				
				Node node2 = new Node(v);
				if(!map.containsKey(v)) {
					map.put(v, node2);
				}else {
					node2 = map.get(v);
				}
				
				//System.out.println("adding " + node2.data + " to " + node1.data);
				node1.addneighbours(node2);
				
				tt= node1;
				
			}
			
			//bw.write("srch " + tt.data + "\n");
			Graph gr = new Graph();
			gr.bfs(tt);
			
			//bw.write(ans.distance + "\n");
		}
		br.close();
		bw.close();
	}

	public static class Node
	{
		int data;
		boolean visited;
		List<Node> neighbours;
 
		Node(int data)
		{
			this.data=data;
			this.neighbours=new ArrayList<>();
 
		}
		public void addneighbours(Node neighbourNode)
		{
			this.neighbours.add(neighbourNode);
		}
		public List<Node> getNeighbours() {
			return neighbours;
		}
		public void setNeighbours(List<Node> neighbours) {
			this.neighbours = neighbours;
		}
	}
	public static class Graph
	{ 
	 
		private Queue<Node> queue;
		static ArrayList<Node> nodes=new ArrayList<Node>();
		
	 
		public Graph()
		{
			queue = new LinkedList<Node>();
		}
	 
		public void bfs(Node node)
		{
			queue.add(node);
			node.visited=true;
			while (!queue.isEmpty())
			{
	 
				Node element=queue.remove();
				System.out.print(element.data + " ");
				List<Node> neighbours=element.getNeighbours();
				for (int i = 0; i < neighbours.size(); i++) {
					
					System.out.println("neigbor of " + element.data + " " + neighbours.get(i).data);
					Node n=neighbours.get(i);
					if(n!=null && !n.visited)
					{
						queue.add(n);
						n.visited=true;
					}
				}
				
				System.out.println();
	 
			}
		}
	}
}

