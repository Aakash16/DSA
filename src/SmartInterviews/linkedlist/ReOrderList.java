package SmartInterviews.linkedlist;

import static SmartInterviews.linkedlist.LinkedList.add;
import static SmartInterviews.linkedlist.LinkedList.createNode;
import static SmartInterviews.linkedlist.LinkedList.print;
import static SmartInterviews.linkedlist.LinkedList.rev;

public class ReOrderList {

    public static void main(String[] args) {

        Node h1 = new Node(5);

        Node n = createNode(8);
        add(h1, n);

        n = createNode(1);
        add(h1, n);

        n = createNode(3);
        add(h1, n);

        n = createNode(10);
        add(h1, n);

        n = createNode(2);
        add(h1, n);

        n = createNode(6);
        add(h1, n);

        print(h1);

        solve(h1);


    }

    private static void solve(Node h) {
        Node m = findMid(h, false);
        //Node m = printMiddle(h);


        System.out.println(m.data);
        Node sh = m.next;
        m.next = null;
        join(h, rev(sh));

    }

    private static void join(Node h, Node sh) {

        Node t1 = h.next;
        Node t2 = h.next;

        while (t1 != null && t2 != null) {

            h.next = sh;
            sh.next = t1;
            t1.next = t2;
            h = t1;
            sh = t2;
            t1 = t1.next;
            t2 = t2.next;
        }

        print(h);
    }

    private static Node findMid(Node h, boolean first) {

        if (h == null)
            return null;

        Node f = h;
        Node s = h;
        while (f.next != null && f != null) {
            s = s.next;
            f = f.next.next;
        }

        if (first || f.next == null) {
            return s;
        } else {
            return f;
        }

    }

    private static Node printMiddle(Node h) {
        Node s = h;
        Node f = h;
        if (h != null) {
            while (f != null && f.next != null) {
                f = f.next.next;
                s = s.next;
            }
            System.out.println("The middle element is [" +
                    s.data + "] \n");

            return s;
        }

        return null;
    }

}
