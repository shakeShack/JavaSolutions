/*Check if a given binary tree is BST*/
import java.util.*;

public class BinarySearchTree {
  public static void main(String[] args){
    Node root = new Node(50);
    root.left = new Node(45);
    root.right = new Node(55);
    root.left.left = new Node(40);
    root.left.right = new Node(50);

    System.out.println(isBst(root));
  }

  static boolean isBst(Node root){
    if(root == null) return true;

    Stack<Navigator> stack = new Stack<>();
    stack.push(new Navigator(root, Integer.MIN_VALUE, Integer.MAX_VALUE));

    while(!stack.isEmpty()){
      Navigator navigator = stack.pop();
      Node node = navigator.node;
      System.out.println("node="+node.value + " min=" +navigator.min+ " max=" +navigator.max);

      Node left = node.left;
      Node right = node.right;

      if (left != null){
        if(left.value < navigator.min || left.value >= node.value) return false;
        stack.push(new Navigator(left, navigator.min, left.value));
      }
      if (right != null){
        if(right.value > navigator.max || right.value <= node.value) return false;
        stack.push(new Navigator(right, right.value, navigator.max));
      }
    }

    return true;
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

class Navigator {
  Node node;
  int min;
  int max;

  Navigator(Node node, int min, int max){
    this.node = node;
    this.min = min;
    this.max = max;
  }
}
