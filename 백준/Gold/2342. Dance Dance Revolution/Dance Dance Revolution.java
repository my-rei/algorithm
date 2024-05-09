import java.io.*;
import java.util.*;

public class Main {
	static int N=5;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int last = 0, now = -1;
		int[][] foot = new int[N][N];
		initArray(foot);
		foot[0][0] = 0;
		while((now = Integer.parseInt(st.nextToken())) != 0) {
			int[][] newFoot = new int[N][N];
			initArray(newFoot);
			for(int i = 0;i<N;i++) {
				if(i != now) {
					if(last != now && i != 0) {
						newFoot[i][now] = Math.min(foot[last][now]+cal(last, i), newFoot[i][now]);
						newFoot[now][i] = Math.min(foot[now][last]+cal(last, i), newFoot[now][i]);
					}
					if(last == 0 || i != last) {
						newFoot[i][now] = Math.min(foot[i][last]+cal(last, now), newFoot[i][now]);
						newFoot[now][i] = Math.min(foot[last][i]+cal(last, now), newFoot[now][i]);
					}
					
					if(i == last) {
						for(int j = 0;j<N;j++) {
							newFoot[i][now] = Math.min(foot[last][j]+cal(j, now), newFoot[i][now]);
							newFoot[now][i] = Math.min(foot[j][last]+cal(j, now), newFoot[now][i]);
						}
					}
				}
			}
			
			
			foot = newFoot;
			last = now;
		}
		int res = Integer.MAX_VALUE;
		for(int i = 0;i<N;i++) {
			res = Math.min(foot[i][last], res);
			res = Math.min(foot[last][i], res);
			
		}
		
		bw.write(String.valueOf(res));
		bw.flush();
	}
	
	static int cal(int last, int now) {
		if(last == 0) return 2;
		else if (last == now) return 1;
		int dif= Math.abs(last-now);
		if(dif%2 == 1) return 3;
		else if(dif ==2) return 4;
		else {
			return 0;
		}
	}
	
	static void initArray(int[][] arr) {
		for(int i = 0;i<N;i++)
			for(int j = 0;j<N;j++)
				arr[i][j] = 1000000;
	}
}