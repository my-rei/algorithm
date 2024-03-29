import java.io.*;
import java.util.*;
 
public class Solution {
    static int N, W, H, minCount, total;
    static int[] topIndex;
    static char[][] map;
    static int[] dr = {1, 0, -1, 0}, dc  = {0,1,0,-1};
    static Queue<Character> cQueue;
    static Queue<int[]> iQueue;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = null;
         
        int T = Integer.parseInt(br.readLine());
        cQueue = new ArrayDeque<>();
        iQueue = new ArrayDeque<>();
        for(int test = 1;test<=T;test++) {
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            W = Integer.parseInt(st.nextToken());
            H = Integer.parseInt(st.nextToken());
             
            map = new char[H][W];
            topIndex = new int[W];
            for(int i = 0;i<H;i++)
                map[i] = br.readLine().replace(" ", "").toCharArray();
 
            total = countB();
            minCount = Integer.MAX_VALUE;
            dfs(0,0);
            sb.append("#"+test+" "+minCount+"\n");
        }
        bw.write(sb.toString());
        bw.flush();
    }
     
    static void dfs(int cnt, int broken) {
        if(cnt == N) {
            minCount = Math.min(total-broken, minCount);
            return;
        }
         
        for(int i = 0;i<W;i++) {
            char[][] cMap = deepCopy(map);
            dfs(cnt+1, broken+drop(i));
            map=cMap;
        }
    }
     
    static char[][] deepCopy(char[][] target){
        char[][] newMap = new char[H][W];
        for(int i = 0;i<H;i++) 
            newMap[i] = Arrays.copyOf(target[i], W);
        return newMap;
    }
     
    static int countB() {
        int count = 0;
        for(int i = 0;i<H;i++) 
            for(int j = 0;j<W;j++) 
                if(map[i][j] != '0')
                    count++;
        return count;
    }
     
    static int drop(int wi) {
        down();
        iQueue.clear();
        int count = 0;
         
        if(topIndex[wi] == H) {
            // 블럭 없음
            return 0;
        }
        iQueue.add(new int[] {topIndex[wi], wi, map[topIndex[wi]][wi]-'0'});
        map[topIndex[wi]][wi] = '0';
        count++;
         
        while(!iQueue.isEmpty()) {
            int level = iQueue.peek()[2];
             
            for(int d = 0;d<4;d++) {
                int cr = iQueue.peek()[0], cc = iQueue.peek()[1];
                for(int l = 1;l<level;l++) {
                    cr += dr[d]; cc += dc[d];
                    if(cr<0||cr>=H||cc<0||cc>=W) break;
                    if(map[cr][cc] == '0') continue;
                    if(map[cr][cc] != '1') iQueue.add(new int[] {cr, cc, map[cr][cc]-'0'});
                    map[cr][cc] = '0';
                    count++;
                }
            }
             
            iQueue.poll();
        }
         
        down();
        return count;
    }
     
    static void down() {
        for(int j = 0;j<W;j++) {
            cQueue.clear();
            for(int i = H-1;i>-1;i--) {
                if(map[i][j] != '0')
                    cQueue.add(map[i][j]);
                map[i][j] = '0';
            }
            int count = H;
            while(!cQueue.isEmpty()) {
                map[--count][j] = cQueue.poll();
            }
            topIndex[j] = count;
        }
    }
}