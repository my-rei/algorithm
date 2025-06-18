class Solution {
    static int result = 0, N;
    static int[] student;
    
    public int solution(int[] number) {
        N = number.length;
        student = number;
        dfs(0, 0, 0);
        return result;
    }
    
    void dfs(int index, int sum, int count) {
        if(count == 3) {
            result += sum == 0? 1:0;
            return;
        }
        
        for(int i = index; i<N; i++) {
            dfs(i+1, sum+student[i], count+1);
        }
    }
}