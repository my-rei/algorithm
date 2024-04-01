import java.io.*;
import java.util.*;

public class Solution {
	static final int P=1234567891;
	static int N, R;
	static long rnr, rr;
	static long[] fac;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = null;
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		
		for(int test = 1;test<=T;test++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken()); R = Integer.parseInt(st.nextToken());
			sb.append("#"+test+" "+nCr(N, R, P)+"\n");
		}
		bw.write(sb.toString());
		bw.flush();
	}
	
	static long nCr(int n, int r, int p) {
		if (r == 0) return 1L;
//		return ( fact(n) * pow(rnr, p-2, p)%p * pow(rr, p-2, p)%p ) %p;
		
		fac = new long[n+1];
		long s = 1; rnr = 1; rr = 1;
		for(int i = 1;i<=n;i++) {
			s = s*i % p;
			if(i == N-R) rnr = s;
			if(i == R) rr = s;
		}
		return ( s * pow(rnr, p-2, p)%p * pow(rr, p-2, p)%p ) %p;
		
		
//		fac = new long[n+1];
//		fac[0] = 1;
//		for(int i = 1;i<=n;i++)
//			fac[i] = fac[i-1] * i % p;
//		return ( fac[n] * pow(fac[n-r], p-2, p)%p * pow(fac[r], p-2, p)%p ) %p;
	}
	
//	static long fact(int cur) {
//		long res = cur == 0? 1:fact(cur-1)*cur%P;
//		if(cur == N-R) rnr = res;
//		if(cur == R) rr = res;
//		return res;
//	}
	
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