import java.util.*;

public class BSTNextLargest {
  public static void main(String[] args){
    Node root = new Node(50);
    root.left = new Node(45);
    root.right = new Node(55);
    root.left.left = new Node(40);
    root.left.right = new Node(43);

    System.out.println(findNextLargestInBst(root, 10));
    System.out.println(findNextLargestInBst(root, 50));
    System.out.println(findNextLargestInBst(root, 43));
    System.out.println(findNextLargestInBst(root, 45));
    System.out.println(findNextLargestInBst(root, 100));
  }

  static int findNextLargestInBst (Node root, int target){
    if(root == null) return -1;

    Queue<Node> queue = new LinkedList<>();
    Set<Node> visitedNodes = new HashSet<>();

    queue.add(root);

    while(!queue.isEmpty()){
      Node node = queue.remove();

      if(node.left == null || visitedNodes.contains(node.left)){
        if(node.right != null) queue.add(node.right);
        visitedNodes.add(node);
        if(node.value > target) return node.value;
      } else {
        queue.add(node.left);
        queue.add(node);
      }
    }

    return -1;
  }
}

class Node {
  int value;
  Node left;
  Node right;

  Node (int value){
    this.value = value;
  }
}
