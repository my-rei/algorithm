import java.io.*;
import java.util.*;

public class Main {
	static int[][] color;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = null;
		
		int N = Integer.parseInt(br.readLine());

		color = new int[N+1][3];
		for(int i = 1;i<N+1;i++) {
			st = new StringTokenizer(br.readLine());
			color[i][0] = Integer.parseInt(st.nextToken());
			color[i][1] = Integer.parseInt(st.nextToken());
			color[i][2] = Integer.parseInt(st.nextToken());
		}
		
		for(int i = 1;i<=N;i++) {
			color[i][0] += Math.min(color[i-1][1], color[i-1][2]);
			color[i][1] += Math.min(color[i-1][0], color[i-1][2]);
			color[i][2] += Math.min(color[i-1][1], color[i-1][0]);
		}
		
		bw.write(String.valueOf( Math.min(color[N][0], Math.min(color[N][1], color[N][2]))));
		bw.flush();
	}
	
}