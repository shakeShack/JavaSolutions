/* Delete alternate node in link list. */
import java.util.*;

public class LinkedListAlternatingNode {
  public static void main (String[] args){
    List<String> test1 = new LinkedList<>();
    test1.add("a");
    test1.add("b");
    test1.add("c");
    test1.add("d");
    test1.add("e");
    test1.add("f");
    test1.add("g");

    deleteAlternatingNode(test1);
  }

  static void deleteAlternatingNode(List<String> linkedList) {
    if(linkedList == null || linkedList.size() == 1) return;

    int size = linkedList.size();
    size = size % 2 == 0 ? size : size-1;
    // boolean alternate = size % 2 == 1;

    for(int i=size-1; i >= 0; i-=2){
      // if (alternate){
        linkedList.remove(i);
      // }
      // alternate = !alternate;
    }

    for(String s : linkedList){
      System.out.print(s + " ");
    }
  }
}
