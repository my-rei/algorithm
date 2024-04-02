import java.io.*;
import java.util.*;

public class Solution {
	static final int F = 10;
	static long A,B;
	static int[] sets = new int[] {0,0,1,3,6,10,15,21,28,36,45};
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = null;
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		for(int test = 1;test<=T;test++) {
			st = new StringTokenizer(br.readLine());
			A = Long.parseLong(st.nextToken()); B = Long.parseLong(st.nextToken());
			sb.append("#"+test+" "+(getSum(B)-getSum(A-1))+"\n");
		}
		bw.write(sb.toString());
		bw.flush();
	}
	
	static long getSum(long N) {
		if(N<10) return sets[(int)(N+1)];
		long res = 0L;  String strN = String.valueOf(N);
		int v = strN.length(), now = 0, d = 0;
		
		while(--v > -1) {
			now = strN.charAt(v)-'0';
			d = strN.length()-v-1;
			
			res += now * (1+Long.parseLong(v==strN.length()-1? "0":strN.substring(v+1, strN.length())));
			res += now==0? 0:sets[now]*Math.pow(10, d);
			res += sets[F] * (long) Math.pow(10, d-1)*(now)*d;
		}
		return res;
	}
}