import java.util.*;

public class MissingNumber {
  public static void main(String[] args){
    System.out.println(findMissingNumber(new int[]{1,2,2}));
    System.out.println(findMissingNumber(new int[]{4,1,2,5,3}));
    System.out.println(findMissingNumber(new int[]{}));
    System.out.println(findMissingNumber(new int[]{2,3,4,3}));
    System.out.println(findMissingNumber(null));
  }

  static int findMissingNumber(int[] array){
    if(array == null || array.length == 0) return -1;

    int length = array.length;
    boolean[] boolArray = new boolean[length];

    for(int i : array){
      boolArray[i-1] = true;
    }

    for(int i=0; i < length; i++){
      if(!boolArray[i]) return i+1;
    }

    return -1;
  }
}
