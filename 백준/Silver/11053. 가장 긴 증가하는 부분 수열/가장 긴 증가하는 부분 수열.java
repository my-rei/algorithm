import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = null;
		
		int N = Integer.parseInt(br.readLine());
		int[] nums = new int[N];
		st = new StringTokenizer(br.readLine());
		for(int i = 0;i<N;i++) nums[i] = Integer.parseInt(st.nextToken());
		
		int[] dp = new int[N];
		dp[0] = 1;
		for(int i = 0;i<N;i++) {
			dp[i] = 1;
			for(int j = 0;j<i;j++) {
				if(nums[i] > nums[j]) dp[i] = Math.max(dp[i], dp[j]+1);
			}
		}
		int max =dp[0];
		for(int i = 0;i<N;i++)  max = Math.max(max, dp[i]);
		System.out.println(max);
	}
}
