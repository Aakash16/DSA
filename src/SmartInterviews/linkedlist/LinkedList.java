package SmartInterviews.linkedlist;

public class LinkedList {

	public static void main(String[] args) {

		Node h = new Node(1);
		Node n = createNode(2);
		add(h, n);

		n = createNode(3);
		add(h, n);
		n = createNode(4);
		add(h, n);
		
		n = createNode(5);
		add(h, n);
		
		n = createNode(6);
		add(h, n);

		// print(h);
		// System.out.println(size(h));

		// printR(h);
		// System.out.println();

		// h = insert(h, 20, 3);
		// print(h);

		// h = insert(h, -1);
		// print(h);

		// h = delete(h, 1);

		 //h = RemoveDuplicates(h);
		 //h = RemoveDuplicates(h);
		//h = rev(h);

		//h= revrse(h);
		
		print(h);
		h = rev(h);
		print(h);
	}

	private static Node revrse(Node h) {
		
		if(h == null)
			return null;
		
		Node temp = h;
		Node last = null;
		while(temp!=null) {
			
				Node temp2 = temp.next;
				temp.next = last;
				last = temp;
				temp = temp2;
		}
		
		return last;

	}

	private static void distinct(Node h) {

	}

	public static void print(Node head) {

		while (head != null) {
			System.out.print(head.data + " ");
			head = head.next;
		}

		System.out.println();

	}

	public static  Node RemoveDuplicates(Node head) {
	    Node node = head;
	    if(head == null){
	        return null;
	    }
	    while(head.next != null){
	        if (head.data == head.next.data){
	            head.next = head.next.next;
	        }
	        else {
	            head = head.next;
	        }
	    }
	    return node;
	}
	
	public static Node delete(Node h, int x) {

		if (h == null)
			return h;

		if (h.data == x) {
			h = h.next;
			return h;
		}

		while (h != null) {

			if (h.next.data == x) {
				break;
			}
		}

		h.next = h.next.next;

		return h;
	}

	public static Node deleteAll(Node h, int x) {
		if (h == null) {
			return h;
		}

		Node hd = h;

		while (h.next != null) {

			if (h.data == x) {
				h.next = h.next.next;
			} else {
				h = h.next;
			}
		}

		return hd;

	}
	
	public static Node deleteDup(Node h, int x) {
		if (h == null) {
			return h;
		}

		Node hd = h;

		while (h.next != null) {

			if (h.data == x) {
				h.next = h.next.next;
			} else {
				h = h.next;
			}
		}

		return hd;

	}

	public static Node insert(Node h, int x, int pos) {

		if (pos < 0 || pos > size(h)) {
			return h;
		}

		Node hd = h;
		Node t = new Node(x);

		while (--pos != 0) {
			System.out.println("t:" + h.data);
			h = h.next;

		}

		System.out.println("e: " + h.data);

		t.next = h.next;
		h.next = t;

		return hd;
	}

	public static Node insert(Node h, int x) {
		if (h == null)
			return h;

		Node hd = h;
		Node n = createNode(x);

		if (x < h.data) {
			n.next = h;
			h = n;

			return h;
		}

		while (h.next != null && h.next.data < x) {
			h = h.next;
		}

		n.next = h.next;
		h.next = n;

		return hd;
	}

	public static void printR(Node h) {

		if (h == null) {
			return;
		}

		printR(h.next);
		System.out.print(h.data + " ");

		return;
	}

	public static int size(Node head) {
		int c = 0;

		while (head != null) {
			c++;
			head = head.next;
		}

		return c;
	}

	public static Node add(Node head, Node d) {

		if(head == null) {
			head = d;
			return head;
		}
		
		while (head.next != null) {
			head = head.next;
		}

		head.next = d;
		return head;
	}

	public static Node createNode(int data) {

		Node n = new Node();
		n.data = data;

		return n;
	}

	public static Node rev(Node h) {
		if (h == null) {
			return h;
		}

		Node prev = null;
		Node cur = h;
		Node next = null;
		while (cur != null) {
			next = cur.next;
			cur.next = prev;
			prev = cur;
			cur = next;
		}

		return prev;
	}
	
	 static Node reverse(Node head) { 
	        if(head == null) { 
	            return head; 
	        } 
	  
	        // last node or only one node 
	        if(head.next == null) { 
	            return head; 
	        } 
	  
	        Node newHeadNode = reverse(head.next); 
	  
	        // change references for middle chain 
	        head.next.next = head; 
	        head.next = null; 
	  
	        // send back new head node in every recursion 
	        return newHeadNode; 
	    } 
}
