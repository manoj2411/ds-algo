import java.util.*;

public class Test {

    public static void main(String[] args) {
        PreToPost pretoPost = new PreToPost();
        int[] in = {4, 2, 5, 1, 3, 6};
        int[] pre = {1, 2, 4, 5, 3, 6};
        // int[] result = pretoPost.convert(in, pre);
        // System.out.println(Arrays.toString(result));
        // l = (Integer a, Integer b) -> a + b;
        // System.out.println(l(4,5));
        // System.out.println((char)('a' + 25));

        String[] arr =  "/a/./b/../../c/".split("/");
        System.out.println("Split by / : " + Arrays.toString(arr));

        arr = "/a/////./..//b///c/d".split("/");
        System.out.println("Split by / : " + Arrays.toString(arr));


    }

}

class PreToPost {
    int curr;
    int[] inOrder;
    int[] preOrder;
    List<Integer> result;

    int[] convert(int[] in, int[] pre) {
        inOrder = in;
        preOrder = pre;
        curr = 0;
        result = new ArrayList<>();
        helper(0, in.length - 1);

        int[] res = new int[in.length];
        for(int i = 0; i < res.length; i++)
            res[i] = result.get(i);

        return res;
    }
    private void helper(int left, int right) {
        if(left <= right) {
            int i = indexInOrder(preOrder[curr]);
            curr++;
            helper(left, i - 1);
            helper(i + 1, right);
            result.add(inOrder[i]);
        }
    }

    private int indexInOrder(int val) {
        for(int i = 0; i < inOrder.length; i++) {
            if(inOrder[i] == val) return i;
        }
        return -1;
    }
}
