import java.io.*;
import java.util.*;

public class Main {
	static int M,N;
	static int[] nums;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		M=Integer.parseInt(st.nextToken()); N=Integer.parseInt(st.nextToken());
		nums = new int[N];
		st = new StringTokenizer(br.readLine());
		for(int i = 0;i<N;i++)
			nums[i] = Integer.parseInt(st.nextToken());
		Arrays.sort(nums);
		bw.write(String.valueOf(findCookie()));
		bw.flush();
	}
	
	static int findCookie() {
		int s= 1, e = nums[N-1], maxC = 0;
		while(s<=e) {
			int mid = (s+e)/2;
			int c = countCookie(mid);
			if(c > 0) {
				s = mid+1;
				maxC = mid;
			} else {
				e = mid-1;
			}
		}
		return maxC;
	}
	
	static int countCookie(int target) {
		int cnt = 0;
		for(int i=0;i<nums.length;i++) {
			cnt += nums[i]/target;
		}
		if(cnt >= M)
			return target;
		return 0;
	}
}