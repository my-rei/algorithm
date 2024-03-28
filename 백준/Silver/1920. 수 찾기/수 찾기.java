import java.io.*;
import java.util.*;
public class Main {
	static int N;
	static int[] nums;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = null;
		StringBuilder sb = new StringBuilder();
		
		N = Integer.parseInt(br.readLine());
		nums = new int[N];
		st = new StringTokenizer(br.readLine());
		for(int i = 0;i<N;i++) {
			nums[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(nums);
		int M = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		for(int i = 0;i<M;i++) {
			int t = Integer.parseInt(st.nextToken());
			sb.append(t < nums[0] || half(t) >= N? "0":"1").append("\n");
		}
		
//		System.out.println(half);
		bw.write(sb.toString());
		bw.flush();
	}
	
	static int half(int target) {
		int s = 0, e = N;
		while(s<e) {
			int mid = (s+e)/2;
			if(nums[mid] == target) {
				return mid;
			}
			if(nums[mid] < target) {
				s = mid+1;
			} else {
				e = mid;
			}
		}
		return N;
	}
}