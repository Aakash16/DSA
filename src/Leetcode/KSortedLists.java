package Leetcode;

import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.PriorityQueue;

public class KSortedLists {

	public static void main(String[] args) {

		LinkedList<Integer> list1 = new LinkedList<Integer>(Arrays.asList(10, 52, 30, 56, 78));
		LinkedList<Integer> list2 = new LinkedList<Integer>(Arrays.asList(5, 23));
		LinkedList<Integer> list3 = new LinkedList<Integer>(Arrays.asList(1, 28, 0));
		LinkedList<Integer> list4 = new LinkedList<Integer>(Arrays.asList(105, 2, 3, 67, 21, 45, 6, 7, 8));

		LinkedList<Integer>[] lists = new LinkedList[]{list1,list2,list3,list4};

	}

	public static Node mergeKLists(Node[] lists) {
	    if(lists==null||lists.length==0)
	        return null;
	 
	    PriorityQueue<Node> queue = new PriorityQueue<Node>(new Comparator<Node>(){
	        public int compare(Node l1, Node l2){
	            return l1.val - l2.val;
	        }
	    });
	 
	    Node head = new Node(0);
	    Node p = head;
	 
	    for(Node list: lists){
	        if(list!=null)
	            queue.offer(list);
	    }    
	 
	    while(!queue.isEmpty()){
	    	Node n = queue.poll();
	        p.next = n;
	        p=p.next;
	 
	        if(n.next!=null)
	            queue.offer(n.next);
	    }    
	 
	    return head.next;
	 
	}

	static class Node {
		int val;
		Node next;

		public Node(int val) {
			this.val = val;
		}

		public int getData() {
			return val;
		}
	}

}
