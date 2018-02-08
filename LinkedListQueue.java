import java.util.*;

public class LinkedListQueue{
  public static void main (String args[]){
    MyQueue queue = new MyQueue(new Node(10));
    queue.enqueue(new Node(11));
    queue.enqueue(new Node(12));
    queue.enqueue(new Node(13));
    queue.enqueue(new Node(14));

    System.out.println(queue.dequeue().value);
    System.out.println(queue.dequeue().value);
    System.out.println(queue.dequeue().value);
    System.out.println(queue.dequeue().value);
    System.out.println(queue.dequeue().value);
    System.out.println(queue.dequeue().value);
  }
}

class Node {
  int value;
  Node next;

  Node (int value){
    this.value = value;
  }
}

class MyQueue {
  Node head;

  MyQueue(Node node){
    this.head = node;
  }

  void enqueue(Node node) {
    if(node == null) throw new NullPointerException();

    node.next = head;
    head = node;
  }

  Node dequeue() {
    if(head == null) throw new NullPointerException();
    if(head.next == null) {
      Node n = head;
      head = null;
      return n;
    }

    Node n_1 = head;
    Node n = head.next;

    while(n.next != null){
      n_1 = n;
      n = n.next;
    }

    n_1.next = null;
    return n;
  }
}
