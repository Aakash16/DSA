package Leetcode;

public class MergeKSortedList {
    public static class ListNode {
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

    private static ListNode insert(ListNode list, int[] input) {
        ListNode head = list;
        for (int i = 0; i < input.length; i++) {
            insert(list, input[i]);
            list = list.next;
        }
        head = clean(head);
        return head;
    }

    private static void print(ListNode list) {
        if (list == null)
            return;

        while (list != null) {
            System.out.print(list.val + " ");
            list = list.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        ListNode l1 = null;

      //  ListNode l2 = new ListNode();
      //  ListNode l3 = new ListNode();

       // l1 = insert(l1, new int[]{});
      //  l2 = insert(l2, new int[]{8, 9});
      //  l3 = insert(l3, new int[]{4, 5});

        ListNode[] inp = new ListNode[]{l1, l1};
        ListNode result = mergeKLists(inp);
        print(result);

    }

    public static ListNode mergeKLists(ListNode[] lists) {

        int len = lists.length;
        if(len == 0)
            return null;

        if(isAllParsed(lists) == null)
            return null;

        int[] temp = new int[len];
        ListNode res = new ListNode();
        ListNode head = res;

        while (isAllParsed(lists) != null) {
            for (int i = 0; i < len; i++) {
                if (lists[i] != null)
                    temp[i] = lists[i].val;
                else
                    temp[i] = Integer.MAX_VALUE;
            }
            int smallest = findSmallest(temp);


            insert(res, lists[smallest].val);
            res = res.next;

            lists[smallest] = lists[smallest].next;
        }

        head = clean(head);

        return head;
    }

    private static ListNode isAllParsed(ListNode[] list) {
        for (ListNode node : list) {
            if (node != null)
                return node;
        }
        return null;
    }

    private static int findSmallest(int[] list) {
        int min = 0;
        for (int i = 0; i < list.length; i++) {
            if (list[min] > list[i]) {
                min = i;
            }
        }
        return min;
    }

    private static void insert(ListNode list, int val) {

        list.val = val;
        list.next = new ListNode();
    }

    private static ListNode clean(ListNode list) {
        if(list == null || list.next == null)
            return list;

        ListNode head = list;

        while (list.next.next != null) {
            list = list.next;

        }
        list.next = null;
        return head;
    }
}
