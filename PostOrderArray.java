/*
{5, 7, 6, 9, 11, 10, 8}
Figure if an array is post traversal order of a binary search tree
*/
import java.util.*;

public class PostOrderArray{
  public static void main (String[] args){
    int[] array1 = new int[]{5, 7, 6, 9, 11, 10, 8};
    System.out.println(isBstPostOrder(array1, 0, 6));
    int[] array2 = new int[]{7, 5, 6, 9, 11, 10, 8};
    System.out.println(isBstPostOrder(array2, 0, 6));
    int[] array3 = new int[]{8};
    System.out.println(isBstPostOrder(array3, 0, 0));
    int[] array4 = new int[]{5,6,7,8}; //todo need to add check for it being balanced. // also maybe complete
    System.out.println(isBstPostOrder(array4, 0, 3));
  }

  static boolean isBstPostOrder(int[] array, int startIndex, int endIndex){
    if(array == null || array.length == 0) return true;

    int thisRoot = array[endIndex];

    int nextStopIndex = -1;
    int nextStartIndex = -1;

    for(int i=endIndex-1; i >= startIndex; i--){
      if(array[i] < thisRoot) {
        nextStopIndex = i;
        break;
      }
    }

    if(nextStopIndex != -1 && nextStopIndex != endIndex) nextStartIndex = nextStopIndex+1;

    if(nextStopIndex != -1){
      for(int i=startIndex; i<nextStopIndex; i++){
        if(array[i] >= thisRoot) {
          // System.out.println("startloop " + i);
          return false;
        }
      }
    }

    if(nextStartIndex != -1){
      for(int i=nextStartIndex+1; i < endIndex; i++){
        if(array[i] <= thisRoot) {
          // System.out.println("stoploop " + i);
          return false;
        }
      }
    }

    boolean returnBool = true;

    if(nextStopIndex != -1)
      returnBool = isBstPostOrder(array, startIndex, nextStopIndex);

    if(nextStartIndex != -1 && returnBool)
      returnBool = isBstPostOrder(array, nextStartIndex, endIndex-1);

    return returnBool;
  }
}
