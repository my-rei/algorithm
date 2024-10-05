import java.io.*;
import java.util.*;


public class Main {
	static int N, maxCount;
	static int[] dur, wgt;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		dur = new int[N];
		wgt = new int[N];
		StringTokenizer st = null;
		for(int i = 0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			dur[i] = Integer.parseInt(st.nextToken());
			wgt[i] = Integer.parseInt(st.nextToken());
		}
		
		dfs(0,0,0);
		System.out.println(maxCount);
	}
	
	static void dfs(int cur, int count, int broken) {
		if(count == N) {
			maxCount = Math.max(maxCount, broken);
			return;
		}
		
		if(dur[cur] <= 0 || broken == N-1) {
			dfs(cur+1, count+1, broken);
			return;
		}
		
		for(int i = 0;i<N;i++) {
			// 자기 자신, 깨진 계란
			if(i==cur || dur[i] <= 0) continue;
			//친다
			dur[i] -= wgt[cur];
			dur[cur] -= wgt[i];
			
			int nb = (dur[i]<=0?1:0)+(dur[cur]<=0?1:0);
			dfs(cur+1, count+1, broken+nb);
			
			dur[i] += wgt[cur];
			dur[cur] += wgt[i];
		}
		
		
	}
}