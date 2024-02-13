import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int N, S, cnt;
	static int[] nums, selected;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		 N = Integer.parseInt(st.nextToken()); S = Integer.parseInt(st.nextToken());
		 cnt = 0;
		nums = new int[N];
		st = new StringTokenizer(br.readLine());
		for(int i = 0;i<N;i++) {
			nums[i] = Integer.parseInt(st.nextToken());
		}
		
		findSum(0, 0, 0);
		System.out.println(cnt);
	}
	
	static void findSum(int cur, int curSum, int now) {
		if(cur == N) {
			if(curSum == S && now > 0) cnt++;
			return;
		}
		
		findSum(cur+1, curSum, now);
		findSum(cur+1, curSum+nums[cur], now+1);
	}
}
