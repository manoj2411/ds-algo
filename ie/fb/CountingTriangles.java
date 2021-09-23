import java.util.*;

class CountingTriangles {

    public static void main(String[] args) {
        ArrayList<Sides> arr_1 = new ArrayList<>();
        arr_1.add(new Sides(7, 6, 5));
        arr_1.add(new Sides(5, 7, 6));
        arr_1.add(new Sides(8, 2, 9));
        arr_1.add(new Sides(2, 3, 4));
        arr_1.add(new Sides(2, 4, 3));
        System.out.println(countDistinctTriangles(arr_1)); // 3


        ArrayList<Sides> arr_2 = new ArrayList<>();
        arr_2.add(new Sides(3, 4, 5));
        arr_2.add(new Sides(8, 8, 9));
        arr_2.add(new Sides(7, 7, 7));
        System.out.println(countDistinctTriangles(arr_2)); // 3

    }

 static int countDistinctTriangles(ArrayList<Sides> arr) {
    // Write your code here
    Set<List<Integer>> set = new HashSet<>();

    for(Sides s : arr) {
      List<Integer> list = new ArrayList<>();
      list.add(s.a);
      list.add(s.b);
      list.add(s.c);
      Collections.sort(list);
      set.add(list);
    }

    return set.size();
  }

 static class Sides{
    int a;
    int b;
    int c;
    Sides(int a,int b,int c){
      this.a = a;
      this.b = b;
      this.c = c;
    }
  }

}

