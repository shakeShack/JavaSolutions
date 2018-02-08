import java.util.*;

public class MedianTwoSortedArraysLogTime {
  public static void main(String[] args){
    System.out.println(findMedian(new int[]{1,3}, new int[]{2}));
    System.out.println(findMedian(new int[]{1,2,3}, new int[]{4,5}));
    System.out.println(findMedian(new int[]{1,3}, new int[]{2,4,5}));
    System.out.println(findMedian(new int[]{1,3,7,9}, new int[]{2,4,5}));
    System.out.println(findMedian(new int[]{1,3,7,9,11}, new int[]{2,4,5,21}));

    // the even elements need to be worked on by resolving todos
    System.out.println(findMedian(new int[]{1,2,3}, new int[]{0,4,5}));
    System.out.println(findMedian(new int[]{1,2,3}, new int[]{4,5,6}));
    System.out.println(findMedian(new int[]{1,2,4}, new int[]{3,5,6}));
    System.out.println(findMedian(new int[]{0,2,4,6}, new int[]{8,10}));
  }

  // assume only odd lengths total found so far.
  static double findMedian(int[] arr1, int[] arr2){
    if(arr1 == null && arr2 == null) return -1;

    if(arr1 == null || arr1.length == 0){
      return arr2.length == 0 ? -1 : arr2[arr2.length / 2];
    }
    if(arr2 == null || arr2.length == 0){
      return arr1.length == 0 ? -1 : arr1[arr1.length / 2];
    }

    return median(arr1, arr2, 0, arr1.length, 0, arr2.length, (arr1.length+arr2.length)%2 == 0);
  }

  static double median(int[] arr1, int[] arr2, int start1, int end1, int start2, int end2, boolean even){
    int mIndex = (arr1.length + arr2.length)/2;

    // Following covers cases when there are no areas of overlap in arrays.
    if(arr1[arr1.length-1] < arr2[0]){
      int m2 = mIndex-arr1.length;
      if(m2 >= 0) {
        if(even) return -2; //TODO enter logic to pick the previous number and find the median of two.
        return arr2[m2];
      }
      if(even) return -2; //TODO enter logic to pick the previous number and find the median of two.
      return arr1[mIndex];
    }
    if(arr2[arr2.length-1] < arr1[0]){
      int m1 = mIndex-arr2.length;
      if(m1 >= 0) {
        if(even) return -2; //TODO enter logic to pick the previous number and find the median of two.
        return arr1[m1];
      }
      if(even) return -2; //TODO enter logic to pick the previous number and find the median of two.
      return arr2[mIndex];
    }

    int m1 = (start1 + end1)/2;
    int m2 = (start2 + end2)/2;

    // When we have exhausted one of the arrays completely.
    if(m1 == -1){
      if(even) {
        return (arr2[mIndex-1] + arr2[mIndex]) / 2.0;
      }
      return arr2[mIndex];
    }
    if(m2 == -1){
      if(even) {
        return (arr1[mIndex-1] + arr1[mIndex]) / 2.0;
      }
      return arr1[mIndex];
    }
    if(m1 >= arr1.length){
      if(even) return -2; //TODO enter logic to pick the previous number and find the median of two.
      return arr2[mIndex - arr1.length];
    }
    if(m2 >= arr2.length){
      if(even) return -2; //TODO enter logic to pick the previous number and find the median of two.
      return arr1[mIndex - arr2.length];
    }

    if(m1 + m2 == mIndex){
      if(arr1[m1] > arr2[m2]){
        if(even) return -2; //TODO enter logic to pick the previous number and find the median of two.
        return arr2[m2];
      } else {
        if(even) return -2; //TODO enter logic to pick the previous number and find the median of two.
        return arr1[m1];
      }
    }

    if(m1 + m2 > mIndex){
      if(arr1[m1] > arr2[m2]){
        return median(arr1, arr2, start1, m1, start2, end2, even);
      } else {
        return median(arr1, arr2, start1, end1, start2, m2, even);
      }
    }

    if(m1 + m2 < mIndex){
      if(arr1[m1] > arr2[m2]){
        return median(arr1, arr2, start1, end1, m2, end2, even);
      } else {
        return median(arr1, arr2, m1, end1, start2, end2, even);
      }
    }

    return -1;
  }
}
