import java.io.*;
import java.util.*;

public class Solution {
	static int N,M;
	static int[] stu;
	static boolean[][] table;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = null;
		
		int T = Integer.parseInt(br.readLine());
		for(int test = 1;test<=T;test++) {
			N = Integer.parseInt(br.readLine());
			M = Integer.parseInt(br.readLine());
			stu = new int[N];
			table = new boolean[N][N];
			for(int i = 0;i<M;i++) {
				st = new StringTokenizer(br.readLine());
				int a = Integer.parseInt(st.nextToken())-1, b= Integer.parseInt(st.nextToken())-1;
				table[a][b] = true;
				stu[a]++; stu[b]++;
			}
			
			for(int i = 0;i<N;i++) {
				for(int j = 0;j<N;j++) {
					if(i==j || table[i][j]) continue;
					for(int k = 0;k<N;k++) {
						if(table[i][k] && table[k][j]) {
							table[i][j] = true;
							stu[i]++; stu[j]++;
							break;
						}
					}
				}
			}
			

			int count = 0;
			for(int i = 0;i<N;i++) 
				if(stu[i] == N-1)
					count++;

			sb.append("#"+test+" "+count+"\n");	
		}
		bw.write(sb.toString());
		bw.flush();
	}
}