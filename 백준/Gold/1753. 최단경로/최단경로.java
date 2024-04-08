import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());

		int V = Integer.parseInt(st.nextToken()), E = Integer.parseInt(st.nextToken());

		int K = Integer.parseInt(br.readLine());
		int[] dis = new int[V+1];
		int[] fromK = new int[V + 1];
		Arrays.fill(fromK, Integer.MAX_VALUE);
		fromK[K] = 0;
		dis[K] = 0;
		PriorityQueue<Integer> pq = new PriorityQueue<>(new Comparator<Integer>() {
			@Override
			public int compare(Integer o1, Integer o2) {
//				return o1[0] - o2[0];
				return dis[o1] - dis[o2];
			}
		});
		List<int[]>[] edge = new List[V + 1];
		for (int i = 0; i < V + 1; i++)
			edge[i] = new ArrayList<>();
		for (int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken()), v = Integer.parseInt(st.nextToken()),
					w = Integer.parseInt(st.nextToken());
			edge[u].add(new int[] { v, w });
		}
		
		
		
		pq.add(K);

		while (!pq.isEmpty()) {
			int curV = pq.poll();

			for (int i = 0; i < edge[curV].size(); i++) {
				int nextV = edge[curV].get(i)[0];
				int nextW = edge[curV].get(i)[1] + fromK[curV] ;
				if (fromK[nextV] > nextW) {
					fromK[nextV] = nextW;
					dis[nextV] = nextW;
					pq.add(nextV);
				}
			}
		}

		for (int i = 1; i < V + 1; i++) {
			sb.append((fromK[i] == Integer.MAX_VALUE ? "INF" : fromK[i]) + "\n");
		}

		bw.write(sb.toString());
		bw.flush();
	}
}