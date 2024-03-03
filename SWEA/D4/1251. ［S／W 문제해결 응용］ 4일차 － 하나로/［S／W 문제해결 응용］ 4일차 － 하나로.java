import java.io.*;
import java.util.*;

public class Solution {
	static int N;
	static double E;
	static int[] parents, ix, iy;
	static PriorityQueue<long[]> pq;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = null;
		StringTokenizer st2 = null;
		int T = Integer.parseInt(br.readLine());
		pq = new PriorityQueue<>(new Comparator<long[]>() {
		@Override
		public int compare(long[] o1, long[] o2) {
			return Long.compare(o1[2], o2[2]);
		}
		});
		
		for(int test = 1;test<=T;test++) {
			N = Integer.parseInt(br.readLine());
			parents = new int[N];
			ix = new int[N];
			iy = new int[N];
			st = new StringTokenizer(br.readLine());
			st2 = new StringTokenizer(br.readLine());
			pq.clear();
			for(int i = 0;i<N;i++) {
				ix[i] = Integer.parseInt(st.nextToken());
				iy[i] = Integer.parseInt(st2.nextToken());
				for(int j = 0;j<i;j++) {
					pq.add(new long[] {i, j, (long) (Math.pow(ix[i]-ix[j], 2)+ Math.pow(iy[i]-iy[j], 2))});
				}
			}
			E = Double.parseDouble(br.readLine());
			
			int count = 0;
			long sum = 0;
			makeset();
			while(!pq.isEmpty()) {
				long[] now = pq.poll();
				if(union((int) now[0], (int) now[1])) {
					count++;
					sum+=now[2];
				}
				if(count == N) break;
			}
			sb.append("#"+test+" "+Math.round(sum*E)+"\n");
		}
		bw.write(sb.toString());
		bw.flush();
	}
	
	static void makeset() {
		for(int i = 0;i<N;i++) parents[i] = i;
	}
	static int find(int a) {
		if(parents[a] == a) return a;
		else return parents[a] = find(parents[a]);
	}
	static boolean union(int a, int b) {
		int pa = find(a), pb = find(b);
		if(pa == pb) return false;
		else {
			parents[pb] = pa;
			return true;
		}
	}
}