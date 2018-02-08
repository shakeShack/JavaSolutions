import java.util.*;

/*
Algorithm explanation:

We can keep finding subtree roots by iterating over the preorder array elements.
Inorder array helps locate whether the child of root obtained in preorder goes to the left or right of a given subtree-root.

Using a recursive approach since this logic is repeated till a tree is constructed.
*/

public class InorderPreorderToBinaryTree{
  public static void main (String[] args){

  }

  public Node buildTree(int[] preorder, int[] inorder) {
      if(preorder == null || inorder == null) return null;
      if(preorder.length != inorder.length) throw new IllegalArgumentException("");

      int preorderStart = 0;
      int preorderEnd = preorder.length-1;

      int inorderStart = 0;
      int inorderEnd = inorder.length-1;

      return construct(preorder, inorder, preorderStart, preorderEnd, inorderStart, inorderEnd);
  }

  public Node construct(int[] preorder, int[] inorder, int preorderStart, int preorderEnd, int inorderStart, int inorderEnd){
      if(preorderStart > preorderEnd || inorderStart > inorderEnd){
        return null;
      }

      int currentRoot = preorder[preorderStart];
      Node node = new Node(currentRoot);

      //find root index from inorder array for this iteration
      int index=0;
      for(int i=inorderStart; i <= inorderEnd; i++){
          if(currentRoot == inorder[i]){
            index=i;
            break;
          }
      }

      node.left = construct(preorder, inorder, preorderStart+1, preorderStart+(index-inorderStart), inorderStart, index-1);
      node.right= construct(preorder, inorder, preorderStart+(index-inorderStart)+1, preorderEnd, index+1 , inorderEnd);

      return node;
  }
}

class Node {
  int val;
  Node left, right;

  public Node(int val) {
      this.val = val;
  }
}
