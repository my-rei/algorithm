import java.io.*;
import java.util.*;

public class Main{
  public static void main(String args[]) throws IOException{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    StringBuilder sb = new StringBuilder();
    Stack<Character> stack = new Stack<>();
    Stack<Integer> levStack = new Stack<>();

    int curLevel = 0;
    for(char c:br.readLine().toCharArray()) {
      if(c >= 'A' && c <= 'Z') {
        // 알파벳
        sb.append(c);
      } else if (c == '(') {
        curLevel++;
      } else if (c == ')') {
        // 괄호가 닫힐 때 해당 레벨의 수식을 다 빼준다
        while(!levStack.isEmpty() && levStack.peek() == curLevel) {
          sb.append(stack.pop());
          levStack.pop();
        }
        curLevel--;
      } else {
        // 수식 
        // 우선순위가 낮으면 계속 pop 
        while (!stack.isEmpty() && calPri(stack.peek(), c, levStack.peek(), curLevel)) {
          sb.append(stack.pop());
          levStack.pop();
        }
        stack.push(c);
        levStack.push(curLevel);
      }

      // System.out.println(stack.toString());
    }
    
    while (!stack.isEmpty()) {
      sb.append(stack.pop());
    }
    
    bw.write(sb.toString());
    bw.flush();
  }

  static boolean calPri(char c1, char c2, int l1, int l2) {
    // 첫번째가 두번째보다 우선순위 높은지 여부 
    // 1. c1이 곱 c2가 곱  ==> c1
    // 2. c1이 곱 c2가 덧  ==> c1
    // 3. c1이 덧 c2가 곱  ==> c2
    // 4. c1이 덧 c2가 덧  ==> c1 
    if (l1 != l2) return l1 > l2;
    if ((c1 == '+' || c1 == '-') && (c2 == '*' || c2 == '/')) {
      return false;
    } else {
      return true;
    }
  }
}
