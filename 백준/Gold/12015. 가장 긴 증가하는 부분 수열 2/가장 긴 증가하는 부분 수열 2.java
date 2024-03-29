import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		int[] nums = new int[N];
		for(int i = 0;i<N;i++) {
			nums[i] = Integer.parseInt(st.nextToken());
		}
		int[] dp = new int[N];
		dp[0] = nums[0];
		int mL = 0;
		for(int i = 1;i<N;i++) {
			if(dp[mL] < nums[i]) dp[++mL] = nums[i];
			else {
				int ind = binarySearch(dp, 0, mL+1, nums[i]);
				dp[ind] = nums[i];
			}
		}
		bw.write(String.valueOf(mL+1));
		bw.flush();
	}
	
	static int binarySearch(int[] nums, int s, int e, int t) {
		while(s < e) {
			int mid = (s+e)/2;
			if(nums[mid] < t) {
				s = mid+1;
			} else {
				e = mid;
			}
		}
		return e;
	}
}