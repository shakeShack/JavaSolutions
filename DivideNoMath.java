/*Divide two integers without using math operators*/

import java.util.*;

public class DivideNoMath {

  public static void main(String[] args) {
    divide(0, -1);
    divide(0, 1);
    divide(-1, -1);
    divide(1, -1);
    divide(-1, 1);
    divide(1, 1);
    divide(10,5);
    divide(10,2);
    divide(13,2);
    divide(13,5);
    divide(1,5);
    divide(Integer.MAX_VALUE, 2);
    divide(Integer.MIN_VALUE, 2);
    // divide(1, 0);
  }

  static void divide(int num1, int num2) {
    if (num2 == 0) throw new Error("DivideByZeroError");

    if (num1 == 0) {
      System.out.println(num1 +"\t"+ num2 +"\t0");
      return;
    }

    if(num1 > 0 && num2 > 0){
      System.out.println(num1 +"\t"+ num2 +"\t"+ divideIterative(num1, num2, true));
      return;
    }

    if(num1 < 0) {
      if(num1 == Integer.MIN_VALUE) {
        System.out.println("Overflow situation");
        return;
      }

      if(num2 < 0){
        if(num2 == Integer.MIN_VALUE) {
          System.out.println("Overflow situation");
          return;
        }

        System.out.println(num1 +"\t"+ num2 +"\t"+ divideIterative(-num1, -num2, true));
        return;
      }
      System.out.println(num1 +"\t"+ num2 +"\t"+ divideIterative(-num1, num2, false));
      return;
    }

    if(num2 == Integer.MIN_VALUE) {
      System.out.println("Overflow situation");
      return;
    }

    System.out.println(num1 +"\t"+ num2 +"\t"+ divideIterative(num1, -num2, false));
  }

  private static int divideIterative(int num1, int num2, boolean positive){
    int result = 0;
    while(num1 >= num2){
      num1 = num1 - num2;
      result++;
    }
    return positive ? result : 0 - result;
  }

  /*The following gives stackoverflow error on larger numbers dues to recursion stack*/
  // private static int divideRecursive(int num1, int num2, int result, boolean positive) {
  //   if(num1 < num2) return positive ? result : 0 - result;
  //   int passValue = num1 - num2;
  //   return divideRecursive (passValue, num2, result+1, positive);
  // }
}
