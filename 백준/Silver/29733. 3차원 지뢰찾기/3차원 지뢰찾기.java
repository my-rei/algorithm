import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        
        int R = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());
        int H = Integer.parseInt(st.nextToken());
        
        int[][][] map = new int[H][R][C];
        int[] dh = {1,1,1, 1,1,1, 1,1,1,
        		0,0,0, 0,0, 0,0,0,
        		-1,-1,-1, -1,-1,-1, -1,-1,-1};
        int[] dr = {1,1,1, 0,0,0, -1,-1,-1,
        		1,1,1, 0,0, -1,-1,-1,
        		1,1,1, 0,0,0, -1,-1,-1};
        int[] dc = {1,0,-1, 1,0,-1, 1,0,-1,
        		1,0,-1, 1,-1, 1,0,-1,
        		1,0,-1, 1,0,-1, 1,0,-1};
        for(int i = 0;i<H;i++) {
        	for(int j = 0;j<R;j++) {
        		char[] arr = br.readLine().toCharArray();
        		for(int h = 0;h<C;h++){
        			if(arr[h] == '*') {
        				map[i][j][h] = Integer.MIN_VALUE;
        				for(int d=0;d<26;d++) {
        					int nh = i+dh[d];
        					int nr = j+dr[d];
        					int nc = h+dc[d];
        					if(nh<0 || nh>=H || nr<0 || nr>=R || nc<0 || nc>=C) continue;
//        					System.out.println(nh+" "+nr+" "+nc);
        					map[nh][nr][nc]++;
        				}
        			}
        		}
        	}
        }
        
        for(int i = 0;i<H;i++) {
        	for(int j = 0;j<R;j++) {
        		for(int h = 0;h<C;h++){
        			sb.append(map[i][j][h]<0? "*":(map[i][j][h]%10));
        		}
        		sb.append("\n");
        	}
        }
        
        bw.write(sb.toString());
        bw.flush();
    }
}