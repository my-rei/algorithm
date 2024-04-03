import java.io.*;
import java.util.*;
 
public class Main {
    static int N;
    static int[][] dis;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = null;
        StringBuilder sb = new StringBuilder();
        N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());
        dis = new int[N][N];
        for(int i = 0;i<M;i++) {
        	st = new StringTokenizer(br.readLine());
        	int a= Integer.parseInt(st.nextToken())-1, b = Integer.parseInt(st.nextToken())-1;
        	int c = Integer.parseInt(st.nextToken());
        	dis[a][b] = dis[a][b] == 0? c:Math.min(c, dis[a][b]);
        }

        for(int k = 0;k<N;k++) {
            for(int i = 0;i<N;i++) {
                for(int j = 0;j<N;j++) {
                    if(k == i || k == j || i==j) continue;
                    if(dis[i][k] == 0 || dis[k][j] == 0) continue;
                    dis[i][j] = dis[i][j] == 0? dis[i][k]+dis[k][j]:Math.min(dis[i][j], dis[i][k]+dis[k][j]);
                }
            }
        }
        

        for(int i = 0;i<N;i++) {
            for(int j = 0;j<N;j++) {
                bw.append(String.valueOf(dis[i][j])+" ");
            }
            bw.append("\n");
        }
             

        bw.flush();
    }
}