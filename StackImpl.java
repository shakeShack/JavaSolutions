/*implement a stack*/

import java.util.*;

public class StackImpl {
  public static void main(String[] args){
    MyStack stack = new MyStack();

    stack.push("string");
    System.out.println(stack.peek());
    System.out.println(stack.pop());
  }
}

class MyStack {
  List<String> list;

  void push(String s){
    if(list == null) {
      list = new ArrayList<>();
    }
    list.add(s);
  }

  String pop(){
    // if(list == null || list.isEmpty()){
    //   throw new Error("Overflow");
    // }

    String s = this.peek();
    int size = list.size();
    list.remove(size-1);
    return s;
  }

  String peek(){
    if(list == null || list.isEmpty()){
      throw new Error("Overflow");
    }
    return list.get(list.size() - 1);
  }
}
