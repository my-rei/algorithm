import java.io.*;
import java.math.BigDecimal;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = null;
		
		int N = Integer.parseInt(br.readLine());
		int[][] cor = new int[N][2];
		for(int i = 0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			cor[i][0] = Integer.parseInt(st.nextToken());
			cor[i][1] = Integer.parseInt(st.nextToken());
		}
		
		double res = 0;
		for(int i = 1;i<N-1;i++) {
			res += getTri(cor[0][0], cor[0][1], cor[i][0], cor[i][1], cor[i+1][0], cor[i+1][1]);
		}
		res = Math.abs(res)/2;
		bw.write(String.format("%.1f", res));
		bw.flush();
	}
	
	static long getTri(long x1, long y1, long x2, long y2, long x3, long y3) {
		return x1*y2+x2*y3+x3*y1-y1*x2-y2*x3-y3*x1;
	}
}