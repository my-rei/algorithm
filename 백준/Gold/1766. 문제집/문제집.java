import java.io.*;
import java.util.*;

public class Main {
	static int N, M;
	static int[] preCount;
	static List<Integer>[] preList;
	static PriorityQueue<Integer> pq;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		pq = new PriorityQueue<>();
		preCount = new int[N+1];
		preList = new List[N+1];
		for(int i = 0;i<M;i++) {
			st = new StringTokenizer(br.readLine());	
			int A = Integer.parseInt(st.nextToken()), B = Integer.parseInt(st.nextToken());
			preCount[B]++;
			if(preList[A] == null) preList[A] = new ArrayList<>();
			preList[A].add(B);
		}
		
		for(int i = 1;i<N+1;i++) {
			if(preCount[i] == 0)
				pq.add(i);
		}
		
		while(!pq.isEmpty()) {
			int a = pq.poll();
			sb.append(a+" ");
			if(preList[a] == null) continue;
			for(int b : preList[a]) {
				preCount[b]--;
				if(preCount[b] == 0) {
					pq.add(b);
				}
			}
		}
		bw.write(sb.toString());
		bw.flush();
	}
}