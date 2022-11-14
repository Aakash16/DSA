package Leetcode;

public class ListSum {

    public static void main(String[] args) {

        ListNode head1;

        ListNode l1 = new ListNode(9);
        head1 = l1;
        l1.next = new ListNode(9);
        l1 = l1.next;
        l1.next = new ListNode(9);
        l1 = l1.next;
        l1.next = new ListNode(9);




        ListNode l2 = new ListNode(9);
        ListNode head2 = l2;
        l2.next = new ListNode(9);
        l2 = l2.next;
        l2.next = new ListNode(9);
        l2 = l2.next;
        l2.next = new ListNode(9);
        l2 = l2.next;
        l2.next = new ListNode(9);
        l2 = l2.next;
        l2.next = new ListNode(9);
        l2 = l2.next;
        l2.next = new ListNode(9);


        ListNode sum = addTwoNumbers(head1, head2);
        printList(sum);

    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode p1 = l1;
        ListNode p2 = l2;

        ListNode head;
        ListNode sum = new ListNode();
        head = sum;

        int carry = 0;
        while (p1 != null && p2 != null) {

            int total = p1.val + p2.val + carry;
            carry = 0;

            int digit = total / 10;
            int remainder = total % 10;

            if (digit > 0) {
                carry = digit;
            }

            sum.val = remainder;

            p1 = p1.next;
            p2 = p2.next;

            if (null != p1 && null != p2) {
                sum.next = new ListNode();
                sum = sum.next;
            }
        }

        printList(head);

        while (p1 != null ) {

            int total = p1.val + carry;
            carry = 0;

            int digit = total / 10;
            int remainder = total % 10;

            if (digit > 0) {
                carry = digit;
            }

            sum.next = new ListNode();
            sum = sum.next;
            sum.val = remainder;
            p1 = p1.next;
        }

        while (p2 != null ) {

            int total = p2.val + carry;
            carry = 0;

            int digit = total / 10;
            int remainder = total % 10;

            if (digit > 0) {
                carry = digit;
            }

            sum.next = new ListNode();
            sum = sum.next;
            sum.val = remainder;
            p2 = p2.next;
        }

        if(carry>0)
        {
            sum.next = new ListNode(carry);
        }

        return head;
    }

    private static void printList(ListNode cur) {
        while (cur != null) {

            System.out.print(cur.val + " ");
            cur = cur.next;
        }
        System.out.println();
    }

    static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }
}
