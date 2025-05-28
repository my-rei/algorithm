class Solution {
    static int n;
    static long lmt;
    static int[] dffs, tms;
    
    public int solution(int[] diffs, int[] times, long limit) {
        dffs = diffs; tms = times; 
        lmt = limit;
        n = diffs.length;
        
        int s = 1, e = 0;
        for(int i = 0;i<n;i++){
            e = Math.max(dffs[i], e);
        }
        
        while(s<e) {
            int mid = (s+e)/2;
            // System.out.printf("[시작] s=%d mid=%d e=%d\n", s, mid, e);
            if(underLimit(mid)) {
                e = mid;
            } else {
                s = mid+1;
            }
            // System.out.printf("[종료] s=%d mid=%d e=%d\n", s, mid, e);
        }
        
        return s;
    }
    
    // 이진탐색(매개변수)
    // 소요시간 계산 
    // limit 초과면 -> 오른쪽으로 이동 (mid+end/2)
    // limit 이하면 -> 왼쪽으로 이동 (start+mid/2)
    // start < end일 때까지 반복
    
    public boolean underLimit(int level) {
        long sum = 0L;
        for(int i = 0;i<n;i++) {
            if (dffs[i] <= level) {
                sum += tms[i];
            } else {
                sum += (tms[i-1]+tms[i])*(dffs[i]-level) + tms[i];
            }
            // System.out.printf("dff[%d]=%d  cur sum = %d\n", i, dffs[i], sum);
        }
        
        // System.out.printf("숙련도 %d, 소요시간 %d "+(sum<=lmt)+"\n", level, sum);
        
        return sum <= lmt;
    }
    
}