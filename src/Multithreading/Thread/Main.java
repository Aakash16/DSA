package Multithreading.Thread;

public class Main {

    public static void main(String[] args) throws InterruptedException {


        int[] a = new int[]{1, 1, 1, 2, 2, 2, 3, 3, 3};
        int k = binsearch2(a, 2);
        System.out.println("k:" + k);

        Integer I = new Integer(10);
        Number N = (Number) I;
        Object O = (Object) N;

        System.out.println(I == N);
        System.out.println(N == O);
        System.out.println(I == O);

        ParentThread parentThread1 = new ParentThread();
        //B b1 = (B) new A();
        //b1.print();
        ParentThread parentThread2 = new ChildThread();
        parentThread2.print();
        ChildThread childThread2 = new ChildThread();
        childThread2.print();

    }


    private static int binsearch2(int[] ar, int k) {

        int start = 0;
        int end = ar.length - 1;
        int ans = Integer.MIN_VALUE;

        while (start <= end) {

            int middle = (start + end) / 2;

            if (k > ar[middle]) {
                start = middle + 1;
            } else {
                ans = middle;
                end = middle - 1;
            }

        }
        return ans;

    }

    private static void print(String o) {
        System.out.println(o);
    }

}
