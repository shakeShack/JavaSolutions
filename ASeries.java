/**
An arithmetic series consists of a sequence of terms such that each term minus its immediate predecessor gives the same result. For example, the sequence 3,7,11,15 is the terms of the arithmetic series 3+7+11+15; each term minus its predecessor equals 4. (Of course there is no requirement on the first term since it has no predecessor.)
Given a collection of integers, we want to find the longest arithmetic series that can be formed by choosing a sub-collection (possibly the entire collection). Create a class ASeries that contains a method longest that is given a values and returns the length of the longest arithmetic series that can be formed from values.
**/

import java.util.*;

public class ASeries{
    public int longest (int[] input){
        if(input == null || input.length == 0) return 0;
        if(input.length == 1) return 1;

        Arrays.sort(input);
        int currentInterval = -1;
        int longestCount = 0;
        int currentCount = 0;

        for(int i=1; i < input.length; i++){
            int interval = input[i]-input[i-1];

            if(longestCount == 0){
              currentCount = 1;
              longestCount = 1;
              currentInterval = interval;
              continue;
            }

            if(interval == currentInterval){
                currentCount++;
            } else {
                longestCount = longestCount > currentCount ? longestCount : currentCount;
                currentInterval = interval;
                currentCount = 1;
            }
        }
        longestCount = longestCount > currentCount ? longestCount : currentCount;
        return ++longestCount;
    }
}
