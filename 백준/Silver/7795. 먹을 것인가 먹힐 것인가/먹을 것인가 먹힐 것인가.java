import java.io.*;
import java.util.*;

public class Main {
	static int N, M;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = null;
		
		int T = Integer.parseInt(br.readLine());
		
		for(int test=1;test<=T;test++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			int[] nList = new int[N], mList = new int[M];
			st = new StringTokenizer(br.readLine());
			for(int i = 0;i<N;i++) {
				nList[i] = Integer.parseInt(st.nextToken());
			}
			st = new StringTokenizer(br.readLine());
			for(int i = 0;i<M;i++) {
				mList[i] = Integer.parseInt(st.nextToken());
			}
			Arrays.sort(nList); Arrays.sort(mList);
			int sum = 0;
			for(int i = 0;i<N;i++) {
				int t = lb(mList, nList[i]);
				sum += t;
			}
			sb.append(sum+"\n");
		}
		bw.write(sb.toString());
		bw.flush();
	}
	
	static int lb(int[] data, int p) {
		int start = 0, end = data.length;
		while(start < end) {
			int mid = (start+end)/2;
			if(data[mid] >= p) end = mid;
			else start = mid+1;
		}
		return end;
	}
	
	
}