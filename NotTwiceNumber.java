/*Given an array of integers, every element appears twice except for one. Find that single one.Hint: Use XOR*/
import java.util.*;

public class NotTwiceNumber {
  public static void main(String[] args){
    int[] array = new int[]{2,3,4,8,2,3,4};
    System.out.println(findNonTwiceNumber(array));
  }

  static int findNonTwiceNumber (int[] array){
    if(array.length == 0) return -1;
    if(array.length == 1) return array[0];

    int xor = 0;
    for(int i : array){
      xor = xor ^ i;
    }

    return xor;
  }
}
