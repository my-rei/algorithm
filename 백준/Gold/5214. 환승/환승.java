import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int N, K, M;
//	static boolean[][] map;
	static int[][] tube;
	static List<Integer>[] graph;
	static boolean[] vs, tvs;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st= new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken()); K =  Integer.parseInt(st.nextToken()); M = Integer.parseInt(st.nextToken());
//		map = new boolean[N+1][N+1];
		tube = new int[M][K];
		graph = new List[N+1];
		vs = new boolean[N+1];
		tvs = new boolean[M];
		for(int i = 0;i<M;i++) {
			st= new StringTokenizer(br.readLine());
			int[] list = new int[K];
			for(int k = 0;k<K;k++) {
				list[k] = Integer.parseInt(st.nextToken());
			}
//			Arrays.sort(list);
			tube[i] = list;
			for(int k = 0;k<K;k++) {
				if(graph[list[k]] == null) graph[list[k]] = new ArrayList<>();
				graph[list[k]].add(i);
			}
		}
		bw.write(String.valueOf(bfs()));
		bw.flush();
	}
	
	static int bfs() {
		Queue<Integer> q = new ArrayDeque<>();
		q.add(1); vs[1] = true; int level = 1;
		if(N==1) return 1;
		while(!q.isEmpty()) {
			int size = q.size();
			while(size-->0) {
				int now = q.poll();
				if(graph[now] == null) continue;
				for(int i = 0;i<graph[now].size();i++) {
					int t = graph[now].get(i);
					if(tvs[t]) continue;
					tvs[t] = true;
					for(int j = 0;j<K;j++) {
						int tg = tube[t][j];
						if(!vs[tg]) {
							if(tg == N) return level+1;
							vs[tg] = true;
							q.add(tg);
						}
					}
				}
//				for(int i = 1;i<=N;i++) {
//					if(i != now) {
//						if(map[now][i] && !vs[i]) {
//							if(i == N) return level+1;
//							vs[i] = true;
//							q.add(i);
//						}
//					}
//				}
			}
			level++;
		}
		
		return -1;
	}

}