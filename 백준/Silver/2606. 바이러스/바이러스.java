import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int T = Integer.parseInt(br.readLine());
		boolean[][] coms = new boolean[N+1][N+1];
		boolean[] visited = new boolean[N+1];
		while(T-->0) {
			st = new StringTokenizer(br.readLine());
			int i = Integer.parseInt(st.nextToken()), j = Integer.parseInt(st.nextToken());
			coms[i][j] = true;
			coms[j][i] = true;
		}
		
		Queue<Integer> q = new ArrayDeque<>();
		q.add(1);
		visited[1]= true;
		int cnt = 0;
		
		while(!q.isEmpty()) {
			int cur = q.peek();
			for(int i = 1; i<=N;i++) {
				if(!visited[i] && coms[cur][i]) {
					visited[i] = true;
					q.add(i);
					cnt++;
				}
			}
			q.poll();
		}
		
		System.out.println(cnt);
	}
}
