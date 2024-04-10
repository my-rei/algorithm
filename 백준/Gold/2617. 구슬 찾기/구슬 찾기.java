import java.io.*;
import java.util.*;

public class Main {
	static int N;
	static boolean[][] gt;
	
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		gt = new boolean[N][N];
		for(int i = 0;i<M;i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken())-1, b = Integer.parseInt(st.nextToken())-1;
			gt[a][b] = true;
		}
		
		for(int k = 0;k<N;k++) {
			for(int i = 0;i<N;i++) {
				if(i == k || !gt[i][k]) continue;
				for(int j = 0;j<N;j++) {
					gt[i][j] |= gt[i][k]&&gt[k][j];
				}
			}
		}
		
		int res = 0;
		for(int i = 0;i<N;i++) {
			int lc = 0, gc = 0; 
			for(int j = 0;j<N;j++) {
				lc += gt[i][j]? 1:0;
				gc += gt[j][i]? 1:0;
			}
			res += lc >= (N+1)/2||gc>=(N+1)/2? 1:0;
		}
		bw.write(String.valueOf(res));
		bw.flush();
	}

}