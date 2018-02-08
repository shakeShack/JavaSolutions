import java.util.*;

public class LinkedListNMinusOne {
  public static void main(String[] args){
    Node head = null;
    System.out.println("element: " + findNMinusOneElement(head));
    head = new Node(10);
    System.out.println("element: " + findNMinusOneElement(head));
    head.next = new Node(11);
    System.out.println("element: " + findNMinusOneElement(head));
    head.next.next = new Node(12);
    System.out.println("element: " + findNMinusOneElement(head));
    head.next.next.next = new Node(13);
    System.out.println("element: " + findNMinusOneElement(head));
    head.next.next.next.next = new Node(14);
    System.out.println("element: " + findNMinusOneElement(head));
    head.next.next.next.next.next = new Node(15);
    System.out.println("element: " + findNMinusOneElement(head));
  }

  static int findNMinusOneElement(Node head){
    if (head == null || head.next == null) return 0;

    Node n_1 = head;
    Node n = head.next;

    while(n.next != null){
      n_1 = n;
      n = n.next;
    }

    return n_1.value;
  }
}

class Node {
  int value;
  Node next;

  Node (int value){
    this.value = value;
  }
}
