import java.util.*;

public class FibonacciReverse {
  public static void main(String[] args){
    System.out.println(reverseFib(13, 8));
    System.out.println(reverseFib(80, 50));
    System.out.println(reverseFib(50, 80));
    System.out.println(reverseFib(1, 2));
    System.out.println(reverseFib(0, 0));
  }
  static List<Integer> reverseFib(int a, int b){
    List<Integer> res = new ArrayList<>();
    if(a < b){
      int temp = b;
      b = a;
      a = temp;
    }
    res.add(a);
    res.add(b);

    for(int next= getNextVal(a,b); next > 0; next = getNextVal(a,b)){
      res.add(next);
      a = b;
      b = next;
    }

    if(res.get(res.size()-1) != 0){
      res.add(0);
    }
    return res;
  }

  static int getNextVal (int a, int b){
    if(a > b){
      return a-b;
    }
    return b-a;
  }
}
