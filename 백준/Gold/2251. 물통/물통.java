import java.io.*;
import java.util.*;

public class Main {
	static int[] ABC = new int[3];
	static boolean[][] ac;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		ABC[0] = Integer.parseInt(st.nextToken()); ABC[1] = Integer.parseInt(st.nextToken()); ABC[2] = Integer.parseInt(st.nextToken());
		ac = new boolean[ABC[0]+1][ABC[2]+1];
		
		dfs(new int[] {0,0,ABC[2]});
		for(int i = 0;i<ABC[2]+1;i++) 
			if(ac[0][i]) sb.append(i+" ");
		bw.write(sb.toString());
		bw.flush();
	}
	
	static void dfs(int[] bottle) {
		if(ac[bottle[0]][bottle[2]]) return;
		ac[bottle[0]][bottle[2]] = true;
		
		for(int i = 0;i<3;i++) {
			if(bottle[i] > 0) {
				int j = (i+1)%3, k = (i+2)%3;
				if(bottle[j] < ABC[j]) {
					int[] tmp = new int[3];
					tmp[i] = bottle[i]+bottle[j] < ABC[j]? 0:bottle[i] - ABC[j] + bottle[j]; 
					tmp[j] = bottle[i]+bottle[j] < ABC[j]? bottle[i]+bottle[j]:ABC[j]; 
					tmp[k] = bottle[k];
					dfs(tmp);	
				}
				if(bottle[k] < ABC[k]) {
					int[] tmp = new int[3];
					tmp[i] = bottle[i]+bottle[k] < ABC[k]? 0:bottle[i] - ABC[k] + bottle[k]; 
					tmp[k] = bottle[i]+bottle[k] < ABC[k]? bottle[i]+bottle[k]: ABC[k]; tmp[j] = bottle[j]; 
					dfs(tmp);
				}
			}
		}
	}

}