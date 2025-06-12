import java.util.*;

class Solution {
    public String solution(String number, int k) {
        String answer = "";
        // stack에 넣으면서
        // 상단보다 크면 -> 상단을 pop하고 push (k개 될 때까지)
        // 상단보다 작거나 같으면 -> push 
        int count = 0;
        Stack<Integer> stack = new Stack<>();
        for(char c:number.toCharArray()) {
            int cur = c - '0';
            if (count >= k || stack.isEmpty() || stack.peek() >= cur) {
                stack.push(cur);
            } else {
                while(count < k && !stack.isEmpty() && stack.peek() < cur) {
                    stack.pop();
                    count++;
                }
                stack.push(cur);
            }
        }
        
        StringBuilder sb = new StringBuilder();
        int size = stack.size() - (number.length() - k);
        System.out.println("size="+size);
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