import java.util.*;
import java.io.*;
public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken()), M = Integer.parseInt(st.nextToken());
		List<Integer>[] seq = new List[N+1];
		int[] inDegrees = new int[N+1];
		int cnt = N;
		
		for(int i = 0;i<N+1;i++) seq[i] = new ArrayList<>();
		for(int i = 0;i<M;i++) {
			st = new StringTokenizer(br.readLine());
			int nums = Integer.parseInt(st.nextToken()), prev = Integer.parseInt(st.nextToken());
			for(int k = 0;k<nums-1;k++) {
				int now = Integer.parseInt(st.nextToken());
				seq[prev].add(now);
				inDegrees[now]++;
				prev = now;
			}
		}
		
		
		Queue<Integer> queue = new ArrayDeque<>();
		for(int i = 1;i<N+1;i++)
			if(inDegrees[i] == 0) {
				queue.add(i);
				cnt--;
			}
		while(!queue.isEmpty()) {
			int now = queue.peek();
			for(int i = 0;i<seq[now].size();i++) {
				if(inDegrees[seq[now].get(i)]>0) {
					inDegrees[seq[now].get(i)]--;
					if(inDegrees[seq[now].get(i)] == 0) {queue.add(seq[now].get(i)); cnt--;}
				}
			}
			sb.append(queue.poll()+"\n");
		}
		if(cnt > 0) System.out.println(0);
		else System.out.println(sb);
		
//		System.out.println(cnt);
		
	}
}
