import java.util.*;

class Solution {
    public long solution(int n, int[] works) {
        if(Arrays.stream(works).sum() - n <= 0) {
            return 0;
        }
        
        PriorityQueue<Integer> pq = new PriorityQueue<>(new Comparator<Integer>() {
                @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });
        
        for(int i = 0;i<works.length;i++){
            pq.add(works[i]);
        }
        
        int N = n;
        
        while(N-->0)
            pq.add(pq.poll()-1);
        
        long res = 0;
        for(int i = 0;i<works.length;i++){
            res += pq.peek()*pq.poll();
        }
        return res;
    }
}