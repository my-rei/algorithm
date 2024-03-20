import java.io.*;
import java.util.*;

public class Main {
	static int N, K, result=Integer.MAX_VALUE;
	static Set<Integer> set;
	static int[] dd = {-1,1};
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		if(N>=K) result = N-K;
		else {
			result = bfs();
		} 
		
		bw.write(String.valueOf(result));
		bw.flush();
		
	}
	
	static int bfs() {
		Queue<int[]> q= new ArrayDeque<>();
		set = new HashSet<>();
		int s = K-N; 
		q.add(new int[] {N,0});
		
		
		while(!q.isEmpty()) {
			int[] cur = q.poll();
//			System.out.println(Arrays.toString(cur));
			
			for(int n =cur[0];;n*=2) {
//				System.out.println(n);
				if(n > s+K || n > 100000 || n == 0) break;
				if(set.contains(n)) continue;
				if(n == K) return cur[1];
				set.add(n);
				q.add(new int[] {n,cur[1]});
			}
			
			
			for(int d=0;d<dd.length;d++) {
				int nc = cur[0]+dd[d];
				if(nc>-1 && nc<100001 && !set.contains(nc)) {
					if(nc == K) return cur[1]+1;
					set.add(nc);
					q.add(new int[] {nc,cur[1]+1});
				}
			}
			
		}
		
		return result;
		
	}
}