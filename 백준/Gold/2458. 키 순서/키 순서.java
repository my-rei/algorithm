import java.io.*;
import java.util.*;

public class Main {
	static int N,M;
	static int[] stu;
	static boolean[][] table;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		stu = new int[N];
		table = new boolean[N][N];
		for(int i = 0;i<M;i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken())-1, b= Integer.parseInt(st.nextToken())-1;
			table[a][b] = true;
			stu[a]++; stu[b]++;
		}

		
		//플로이드워샬
		for(int k = 0;k<N;k++) {
			for(int i = 0;i<N;i++) {
				for(int j = 0;j<N;j++) {
					if(i==j||table[i][j]) continue;
					if(table[i][k] && table[k][j]) {
						table[i][j] = true;
						stu[i]++; stu[j]++;
					}
				}
			}
		}
		
//		System.out.println(Arrays.toString(stu));
		int count = 0;
		for(int i = 0;i<N;i++) 
			if(stu[i] >= N-1)
				count++;

		bw.write(String.valueOf(count));
		bw.flush();
	}
}