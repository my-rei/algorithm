import java.io.*;
import java.util.*;

public class Solution {
	static final int P=1234567891;
	static int N, R;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = null;
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		
		for(int test = 1;test<=T;test++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken()); R = Integer.parseInt(st.nextToken());
			sb.append("#"+test+" "+nCr(N, R)+"\n");
		}
		bw.write(sb.toString());
		bw.flush();
	}
	
	static long nCr(int n, int r) {
		if (r == 0) return 1L;

		long s = 1, rnr =1, rr =1;
		for(int i = 1;i<=n;i++) {
			s = s*i % P;
			if(i == N-R) rnr = s;
			if(i == R) rr = s;
		}
		return ( s * pow(rnr, P-2, P)%P * pow(rr, P-2, P)%P ) %P;
	}
	
	static long pow(long x, long y, long p) {
		long res = 1L;
		x = x%p;
		
		while(y>0) {
			if(y % 2 == 1)
				res = (res*x) % p;
			y = y >> 1;
			x = (x*x) % p;
		}
		
		return res;
	}
}