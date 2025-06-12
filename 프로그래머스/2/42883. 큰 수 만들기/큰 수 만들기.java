import java.util.*;

class Solution {
    public String solution(String number, int k) {
        String answer = "";
        int count = 0;
        Stack<Integer> stack = new Stack<>();
        for(char c:number.toCharArray()) {
            int cur = c - '0';
            while(count < k && !stack.isEmpty() && stack.peek() < cur) {
                stack.pop();
                count++;
            }
            stack.push(cur);
        }
        
        StringBuilder sb = new StringBuilder();
        int size = stack.size() - (number.length() - k);
        while(!stack.isEmpty()) {
            if(size-- > 0) {
                stack.pop();
                continue;
            }
            sb.append(stack.pop());
        }
        
        return sb.reverse().toString();
    }
}