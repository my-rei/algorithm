import java.util.*;

class Solution {
    public int solution(int[] d, int budget) {
        int answer = 0, current = budget;
        Arrays.sort(d);
        for(int i = 0;i<d.length;i++) {
            if(current >= d[i]) {
                current -= d[i];
                answer++;
            } else {
                break;
            }
        }
        return answer;
    }
}