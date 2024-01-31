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


import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;



class Result {

    /*
     * Complete the 'minimumTimeSpent' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER_ARRAY comedyReleaseTime
     *  2. INTEGER_ARRAY comedyDuration
     *  3. INTEGER_ARRAY dramaReleaseTime
     *  4. INTEGER_ARRAY dramaDuration
     */

    static class Movie {
        int releaseTime;
        int duration;
        Movie(int r, int d) {
            releaseTime = r;
            duration = d;
        }
    }
    public static int minimumTimeSpent(List<Integer> comedyReleaseTime, List<Integer> comedyDuration, List<Integer> dramaReleaseTime, List<Integer> dramaDuration) {
    // Write your code here

        List<Movie> comedyMovies = new ArrayList<>();
        for (int i = 0; i < comedyReleaseTime.size(); i++) {
            comedyMovies.add(new Movie(comedyReleaseTime.get(i), comedyDuration.get(i)));
        }
        Collections.sort(comedyMovies, (a, b) -> Integer.compare(a.releaseTime, b.releaseTime));

        List<Movie> dramaMovies = new ArrayList<>();
        for (int i = 0; i < dramaReleaseTime.size(); i++) {
            dramaMovies.add(new Movie(dramaReleaseTime.get(i), dramaDuration.get(i)));
        }
        Collections.sort(dramaMovies, (a, b) -> Integer.compare(a.releaseTime, b.releaseTime));

        int minTime = Integer.MAX_VALUE;




        return minTime;

    }

}




public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int comedyReleaseTimeCount = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> comedyReleaseTime = IntStream.range(0, comedyReleaseTimeCount).mapToObj(i -> {
            try {
                return bufferedReader.readLine().replaceAll("\\s+$", "");
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        })
            .map(String::trim)
            .map(Integer::parseInt)
            .collect(toList());

        int comedyDurationCount = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> comedyDuration = IntStream.range(0, comedyDurationCount).mapToObj(i -> {
            try {
                return bufferedReader.readLine().replaceAll("\\s+$", "");
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        })
            .map(String::trim)
            .map(Integer::parseInt)
            .collect(toList());

        int dramaReleaseTimeCount = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> dramaReleaseTime = IntStream.range(0, dramaReleaseTimeCount).mapToObj(i -> {
            try {
                return bufferedReader.readLine().replaceAll("\\s+$", "");
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        })
            .map(String::trim)
            .map(Integer::parseInt)
            .collect(toList());

        int dramaDurationCount = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> dramaDuration = IntStream.range(0, dramaDurationCount).mapToObj(i -> {
            try {
                return bufferedReader.readLine().replaceAll("\\s+$", "");
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        })
            .map(String::trim)
            .map(Integer::parseInt)
            .collect(toList());

        int result = Result.minimumTimeSpent(comedyReleaseTime, comedyDuration, dramaReleaseTime, dramaDuration);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
