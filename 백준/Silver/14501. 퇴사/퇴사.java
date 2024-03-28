import java.io.*;
import java.util.*;
public class Main {
	static Conf[] cons;
	static class Conf{
		int t, p, s, e;
		Conf(int t, int p, int s, int e){
			this.t = t; this.p = p; this.s = s; this.e = e;
		}
	}
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = null;
		int N = Integer.parseInt(br.readLine());
		cons = new Conf[N];
		int[] dp = new int[N+1];
		for(int i= 0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			int t= Integer.parseInt(st.nextToken());
			cons[i] = new Conf(t, Integer.parseInt(st.nextToken()), i+1, i+t);
			if(i == 0 && t == 1) dp[1] = cons[i].p;
		}
		
		dp[0] = 0;
		int m  = dp[1];
		for(int i = 2;i<=N;i++) {
			for(int j = 0;j<N;j++) {
				if(cons[j].e == i) {
					dp[i] = Math.max(dp[i], cons[j].p +dp[cons[j].s-1]);
					m = Math.max(m, dp[i]);
				}
			}
			dp[i] = Math.max(dp[i-1], dp[i]);
		}
		bw.write(String.valueOf(m));
		bw.flush();
	}
}