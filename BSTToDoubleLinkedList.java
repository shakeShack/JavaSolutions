import java.util.*;

public class BSTToDoubleLinkedList {
  public static void main(String[] args){
    Node root = new Node(50);
    root.left = new Node(45);
    root.right = new Node(55);
    root.left.left = new Node(40);
    root.left.right = new Node(48);

    convertBstToDoubleLinkedList(root);

    Node root2 = new Node(10);
    convertBstToDoubleLinkedList(root2);
  }

  static Node convertBstToDoubleLinkedList(Node root){
    if(root == null) return null;

    Stack<Node> stack = new Stack<>();
    stack.push(root);
    List<Node> visited = new ArrayList<>();

    while(!stack.isEmpty()){
      Node n = stack.pop();

      Node left = n.left;
      if(left != null && !visited.contains(left)){
        stack.push(n);
        stack.push(left);
        continue;
      }

      visited.add(n);
      Node right = n.right;
      if(right != null){
        stack.push(right);
      }
    }

    int size = visited.size();
    if(size == 1) {
      System.out.println(root.value);
      return root;
    }

    visited.get(0).left = null;
    visited.get(0).right = visited.get(1);
    for(int i = 1; i < size - 1; i++){
      visited.get(i).left = visited.get(i-1);
      visited.get(i).right = visited.get(i+1);
    }
    visited.get(size - 1).left = visited.get(size - 2);
    visited.get(size - 1).right = null;

    Node head = visited.get(0);
    while(head != null){
      System.out.print(head.value + " ");
      head = head.right;
    }
    System.out.println();
    Node tail = visited.get(size-1);
    while(tail != null){
      System.out.print(tail.value + " ");
      tail = tail.left;
    }

    return visited.get(0);
  }
}

class Node {
  int value;
  Node left;
  Node right;

  Node(int value){
    this.value = value;
  }
}
