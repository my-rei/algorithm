import java.util.*;

class Solution {
    public String solution(int n) {
        StringBuilder sb = new StringBuilder();
        int i = 0;
        while(i++<n) {
            if(i%2==1) sb.append("수");
            else sb.append("박");
        }
        return sb.toString();
    }
}