import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Solution {
	static int maxRes, minRes, N;
	static int[] cal, nums;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = null;
		
		int T = Integer.parseInt(br.readLine());
		for(int test = 1;test<=T;test++) {
			// 변수 초기화
			maxRes = Integer.MIN_VALUE;
			minRes = Integer.MAX_VALUE;
			
			N = Integer.parseInt(br.readLine());
			cal = new int[4];
			st = new StringTokenizer(br.readLine());
			for(int j = 0;j<4;j++) cal[j] = Integer.parseInt(st.nextToken());
			
			nums = new int[N];
			st = new StringTokenizer(br.readLine());
			for(int i = 0;i<N;i++) nums[i] = Integer.parseInt(st.nextToken());
			
			dfs(0,nums[0]);
			
			sb.append("#"+test+" "+(maxRes-minRes)+"\n");
		}
		bw.write(sb.toString());
		bw.flush();
	}
	
	static void dfs(int cur, int res) {
		if(cur == N-1) {
			maxRes = Math.max(maxRes, res);
			minRes = Math.min(minRes, res);
			return;
		}
		
		for(int i = 0;i<4;i++) {
			if(cal[i] > 0) {
				cal[i]--;
				int newRes = i==0? res+nums[cur+1]: i==1? res-nums[cur+1]:i==2? res*nums[cur+1]:res/nums[cur+1];
				dfs(cur+1, newRes);
				cal[i]++;
			}
			
		}
	}
}
