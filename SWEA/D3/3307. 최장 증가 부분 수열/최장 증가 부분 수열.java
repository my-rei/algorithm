import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Solution {
	static int[] lis;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = null;
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		
		for(int t = 1;t<=T;t++) {
			int N = Integer.parseInt(br.readLine());
			int[] numbers = new int[N];
			st = new StringTokenizer(br.readLine());
			for(int i = 0;i<N;i++) {
				numbers[i] = Integer.parseInt(st.nextToken());
			}
			
			
			int curMax = 0;
			lis = new int[N];
			lis[0] = numbers[0];
			for(int i = 1;i<N;i++) {
				if(lis[curMax] < numbers[i]) {
					curMax++;
					lis[curMax] = numbers[i];
				} else {
					int ind = lb(0,curMax,numbers[i]);
					lis[ind] = numbers[i];
				}
			}
			sb.append("#"+t+" "+(curMax+1)+"\n");
		}
		bw.write(sb.toString());
		bw.flush();
	}
	
	static int lb(int s, int e, int target) {
		int mid = 0;
		while(s<e) {
			mid = (s+e)/2;
			if(lis[mid] < target) {
				s = mid+1;
			} else {
				e = mid;
			}
		}
		return e;
	}
}