import java.util.*;

public class Test {

    public static void main(String[] args) {
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
