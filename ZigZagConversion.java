/*
The string "PAYPALISHIRING" is written in a zigzag pattern on a
given number of rows like this: (you may want to display this
pattern in a fixed font for better legibility)

P   A   H   N
A P L S I I G
Y   I   R

And then read line by line: "PAHNAPLSIIGYIR"
Write the code that will take a string and make this conversion given a number of rows:

convert("PAYPALISHIRING", 3) should return "PAHNAPLSIIGYIR".
*/

public class ZigZagConversion {
  public static void main(String[] args){

  }

  static String convert(String text, int nRows){
    if(text == null || text.length() <= nRows || nRows == 1) return text;

    // index of row to string cancatenated by next letter in it.
    Map<Integer, String> map = new HashMap<>();

    for(int i=0; i < nRows; i++){
      map.put(i, "");
    }

    int index = 0; //string index
    int i = 0; //row index
    boolean back = false; // adding stuff forward or backwards in zigzag pattern.

    while(index < text.length()){
      map.put(i, map.get(i) + text.charAt(index));
      index++;
      if(back){
        i--;
      } else {
        i++;
      }

      if(i < 0) {
        back = false;
        i = i+2;
      } else if (i >= nRows) {
        back = true;
        i = i-2;
      }
    }

    String returnString = "";
    for(i=0; i < nRows; i++){
      returnString += map.get(i);
    }

    return returnString;
  }
}
