import java.io.*;
import java.util.*;

public class Main {
	static final int P=1000000007;
	static int N, R, last=1;
	static long[] nums;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = null;
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		nums = new long[4000001];
		nums[0] = 1;
		for(int test = 1;test<=T;test++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken()); R = Integer.parseInt(st.nextToken());
			sb.append(nCr(N, R)+"\n");
		}
		bw.write(sb.toString());
		bw.flush();
	}
	
	static long nCr(int n, int r) {
		if (r == 0) return 1L;

		for(int i = last;i<=n;i++) {
			nums[i] = (nums[i-1]*i) %P;
		}
		last = Math.max(n, last);
		return ( nums[n] * pow(nums[N-R], P-2)%P * pow(nums[R], P-2)%P ) %P;
	}
	
	static long pow(long x, long y) {
		long res = 1L;
		x = x%P;
		
		while(y>0) {
			if((y&1) == 1)
				res = (res*x) % P;
			y = y >> 1;
			x = (x*x) % P;
		}
		
		return res;
	}
}