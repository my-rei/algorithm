import java.util.*;
class Solution {
    public int[] solution(int n, String[] words) {
        int[] answer = {};
        Set<String> sets = new HashSet<>();
        char last = words[0].charAt(0);

        for(int i = 0;i<words.length;i++){
            String str = words[i];
            if(sets.contains(str)) return new int[]{i%n+1, i/n+1};
            if(last != str.charAt(0)) return new int[]{i%n+1, i/n+1};
            sets.add(str);
            last = str.charAt(str.length()-1);
           // System.out.println(str+" "+i+" "+last);
        }

        return new int[]{0,0};
    }
}