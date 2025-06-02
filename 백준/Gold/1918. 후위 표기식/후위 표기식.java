import java.io.*;
import java.util.*;

public class Main{
  static StringBuilder sb;
  static Stack<Character> stack;
  static Stack<Integer> levStack;
  
  public static void main(String args[]) throws IOException{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    sb = new StringBuilder();
    stack = new Stack<>();
    levStack = new Stack<>();

    int curLevel = 0;
    for(char c:br.readLine().toCharArray()) {
      if(c >= 'A' && c <= 'Z') {
        sb.append(c);
      } else if (c == '(') {
        curLevel++;
      } else if (c == ')') {
        while(!levStack.isEmpty() && levStack.peek() == curLevel) {
          popStack();
        }
        curLevel--;
      } else {
        while (!stack.isEmpty() && isPrior(stack.peek(), c, levStack.peek(), curLevel)) {
          popStack();
        }
        stack.push(c);
        levStack.push(curLevel);
      }
    }
    
    while (!stack.isEmpty()) {
      popStack();
    }
    
    bw.write(sb.toString());
    bw.flush();
  }

  static boolean isPrior(char c1, char c2, int l1, int l2) {
    if (l1 != l2) return l1 > l2;
    if ((c1 == '+' || c1 == '-') && (c2 == '*' || c2 == '/')) {
      return false;
    } else {
      return true;
    }
  }

  static void popStack() {
    sb.append(stack.pop());
    levStack.pop();
  }
}
