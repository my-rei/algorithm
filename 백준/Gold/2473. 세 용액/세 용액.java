import java.io.*;
import java.util.*;

public class Main {
	static int N; static long curMax=Long.MAX_VALUE;
	static String str;
	static int[] nums;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		N = Integer.parseInt(br.readLine());
		nums = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 0;i<N;i++) {
			nums[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(nums);
		
		int s = 0, e = N-1;
		while(s+1 < e) {
			int s1 = s, e1 = e, m1=(s+e)/2; long cur1 = Long.MAX_VALUE;
			while(s1+1 < e1) {
				int mid = (s1+e1)/2; long cur = (long)nums[s]+(long)nums[mid]+(long)nums[e];
				if(Math.abs(cur) < Math.abs(cur1)) {
//					System.out.println(nums[s]+"+"+nums[mid]+"+"+nums[e]+"="+cur);
					cur1 = cur;
					m1 = mid;
				}
				if(cur > 0) {
					e1 = mid;
				} else {
					s1 = mid;
				}
			}
//			System.out.println(nums[s]+" "+nums[m1]+" "+nums[e]);
			if(Math.abs(cur1) < Math.abs(curMax)) {
//				System.out.println("****    "+cur1+" < "+curMax);
				curMax = cur1;
				str = nums[s]+" "+nums[m1]+" "+nums[e];
			}
//			System.out.println(s+" "+m1+" "+e);
			if(e-2 > s) {
				e--;
			} else {
//				System.out.println("------");
				s++;
				e = N-1;
			}
//			System.out.println("==================");
		}

		
		bw.write(str);
		bw.flush();
		
	}
	
	
}