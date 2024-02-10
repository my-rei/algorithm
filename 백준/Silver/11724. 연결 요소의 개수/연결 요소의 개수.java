import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken()), M = Integer.parseInt(st.nextToken());
		boolean[][] graph = new boolean[N + 1][N + 1];
		boolean[] visited = new boolean[N+1];
		
		if(M==0) {System.out.println(N); return;}
		
		while (M-- > 0) {
			st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken()), v = Integer.parseInt(st.nextToken());
			graph[u][v] = true;
			graph[v][u] = true;
		}
		
		int cnt = 0;
		Queue<Integer> queue = new ArrayDeque<Integer>();
		for(int j=1;j<=N;j++) {
			if(!visited[j]) {				
				queue.add(j);
				visited[j] = true;
				
				while(!queue.isEmpty()) {
					for(int i = 1;i<=N;i++) {
						if(!visited[i] && (graph[i][queue.peek()] || graph[queue.peek()][i])) {
							visited[i] = true;
							queue.add(i);
						}
					}
					queue.poll();
				}
				
				cnt++;
			}
		}
		
		System.out.println(cnt);
	}
}
