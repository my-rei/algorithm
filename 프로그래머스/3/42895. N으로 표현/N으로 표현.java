import java.util.*;
import java.io.*;

class Solution {
    static int n;
    static Map<Integer, Integer> map;
    
    public int solution(int N, int number) {
        map = new HashMap<>();
        n = N;
        
        for(int i = N, digit = 1; digit <= 8 ; i = 10*i + N, digit++) {
            map.put(i, digit);
        }
        
        dfs(0,0);
        
        return map.getOrDefault(number, -1);
    }
    
    void dfs(int cur, int cnt) {
        if(cnt > 8 || (cnt>0 && cur == 0))
            return;
        
        map.put(cur, Math.min(map.getOrDefault(cur, cnt), cnt));
        
        for(int i = n, digit = 1; digit <= 8 ; i = 10*i + n, digit++) {
            dfs(cur+i, cnt+digit);
            dfs(cur-i, cnt+digit);
            dfs(cur*i, cnt+digit);
            dfs(cur/i, cnt+digit);
        }
    }
}