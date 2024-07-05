class Solution {
    public int solution(int n) {
        if(n%2 == 1) return 0;
        
        long[] dp = new long[n/2+1];
        dp[0] = 1;
        dp[1] = 3;
        for(int i = 2;i<n/2+1;i++){
            dp[i] = (dp[i-1]*4 - dp[i-2])%1000000007;
            if(dp[i] < 0){
                dp[i] += 1000000007;
            }
        }
        
        return (int) dp[n/2];
    }
}