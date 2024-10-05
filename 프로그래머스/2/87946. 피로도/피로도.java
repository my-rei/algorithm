class Solution {
    static int N, maxD;
    static int[][] dg;
    static boolean[] visited;
    public int solution(int k, int[][] dungeons) {
        maxD = -1;
        N = dungeons.length;
        dg = dungeons;
        visited = new boolean[N];
        dfs(k,0);
        
        return maxD;
    }
    
    public void dfs(int curTired, int count){
        maxD = Math.max(maxD, count);
        
        for(int i = 0;i<N;i++){
            if(!visited[i] && dg[i][0] <= curTired) {
                visited[i] = true;
                dfs(curTired-dg[i][1], count+1);
                visited[i] = false;
            }
        }
        
        
    }
}