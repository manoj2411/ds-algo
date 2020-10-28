import java.util.*;

class PreorderToPostorderBST {
    int i;
    void printPostOrder(int[] a) {
        i = 0;
        printHelper(a, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    void printHelper(int[] a, int min, int max) {
        if(i == a.length || a[i] < min || a[i] > max) {
            // System.out.println("a[i]: " + a[i] + " min: " + min + " max: " + max);
            return;
        }

        int curr = a[i];
        i++;
        printHelper(a, min, curr);// go left
        printHelper(a, curr, max);// go right
        System.out.print(curr + " ");
    }

    public static void main(String[] args) {

        int[][] input = {
            {40,30,35,80,100}, // 35 30 100 80 40
            {40,30,32,35,80,90,100,120} // 35 32 30 120 100 90 80 40
        };
        PreorderToPostorderBST sol = new PreorderToPostorderBST();
        for(int[] a : input) {
            System.out.println("Inorder: " + Arrays.toString(a));
            System.out.print("PostOrder: ");
            sol.printPostOrder(a);
            System.out.println("\n");
        }
    }
}
