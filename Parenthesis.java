/* Check if parentheses are balanced in an expression*/
import java.util.*;

public class Parenthesis {
  public static void main(String[] args){
    String test1 = "";
    String test2 = null;
    String test3 = "{}[]()";
    String test4 = "[abd{d()}]";
    String test5 = "[]}";
    String test6 = "[]}{";
    String test7 = " ";

    System.out.println(isValidParenthesis(test1));
    System.out.println(isValidParenthesis(test2));
    System.out.println(isValidParenthesis(test3));
    System.out.println(isValidParenthesis(test4));
    System.out.println(isValidParenthesis(test5));
    System.out.println(isValidParenthesis(test6));
    System.out.println(isValidParenthesis(test7));
  }

  static boolean isValidParenthesis(String input){
    if(input == null || input.isEmpty()) return true;

    String[] array = input.split("");
    Map<String, Integer> map = new HashMap<>();
    map.put("[", 0);
    map.put("{", 0);
    map.put("(", 0);

    List<String> closingBraces = new ArrayList<>();
    closingBraces.add("]");
    closingBraces.add("}");
    closingBraces.add(")");

    for(String s : array) {
      Integer count = map.get(s);
      if(count != null) {
        map.put(s, ++count);
        continue;
      }

      if("]".equals(s)){
        count = map.get("[");
        map.put("[", count - 1);
      } else if("}".equals(s)){
        count = map.get("{");
        map.put("{", count - 1);
      } else if(")".equals(s)){
        count = map.get("(");
        map.put("(", count - 1);
      }

      if(count == null) continue;

      if(count == 0) return false;
    }

    for(int i : map.values()){
      if(i > 0) return false;
    }

    return true;
  }
}
