import java.io.*;
import java.util.*;

public class Main {
	static int N, maxL=1, last=0;
	static int[] nums, table, path;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		N = Integer.parseInt(br.readLine());
		nums = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 0;i<N;i++)
			nums[i] = Integer.parseInt(st.nextToken());
		
		table = new int[N];
		path = new int[N];
		table[0] = 0;
		path[0] = -1;
		for(int i = 1;i<N;i++) {
			if(nums[table[maxL-1]] < nums[i]) {
				table[maxL] = i;
				path[i] = table[maxL-1];
				maxL++; last = i;
				continue;
			}
			int ind = find(nums[i]);
//			System.out.println(Arrays.toString(table));
//			System.out.println(i+" "+nums[i]+" => "+ind);
			table[ind] = i;
			path[i] = ind==0? -1: table[ind-1];
		}
		
//		System.out.println(Arrays.toString(table));
//		System.out.println(Arrays.toString(path));
		while(last != -1) {
			sb.insert(0, nums[last]+" ");
			last = path[last];
		}
		bw.write(maxL+"\n"+sb.toString());
		bw.flush();
	}
	
	static int find(int t) {
		int s= 0, e= maxL;
//		System.out.println("======"+t+"========");
		while(s<e) {
			int mid = (s+e)/2;
//			System.out.println(s+" "+mid+" "+e+" / "+nums[table[mid]]);
			if(nums[table[mid]] < t) {
				s = mid+1;
			} else {
				e = mid;
			}
		}
		return e;
	}
}