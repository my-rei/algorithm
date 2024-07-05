import java.util.*;

class Solution {
    int R, C;
    boolean[][] vs;
    char[][] map;
    int[] dr = {0,0,1,-1}, dc={1,-1,0,0};
    public int[] solution(String[] maps) {
        ArrayList<Integer> list = new ArrayList<>();
        R = maps.length; C = maps[0].length();
        vs = new boolean[R][C];
        map = new char[R][C];
        
        for(int i = 0;i<R;i++)
            map[i] = maps[i].toCharArray();
        
        for(int i = 0;i<R;i++){
            for(int j = 0;j<C;j++){
                if(map[i][j] != 'X' && !vs[i][j]){
                    list.add(bfs(i,j));
                }
            }
        }
        Collections.sort(list);
        if(list.size() == 0) list.add(-1);
        int[] answer = new int[list.size()];
        for(int i = 0;i<list.size();i++) answer[i] = list.get(i);
        return answer;
    }
    
    int bfs(int i, int j){
        int sum = map[i][j] - '0';
        Queue<int[]> q = new LinkedList<>();
        
        q.add(new int[]{i,j});
        vs[i][j] = true;
        while(!q.isEmpty()){
            int[] cur = q.poll();
            int ci = cur[0], cj = cur[1];
            for(int d=0;d<4;d++){
                int ni = ci+dr[d], nj = cj+dc[d];
                if(ni < 0 || ni>=R || nj<0||nj>=C) continue;
                if(map[ni][nj] == 'X' || vs[ni][nj]) continue;
                vs[ni][nj] = true;
                sum += map[ni][nj] - '0';
                q.add(new int[]{ni, nj});
            }
        }
        
        return sum;
    }
}