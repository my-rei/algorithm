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

		int[] fromK = new int[V + 1];
		Arrays.fill(fromK, Integer.MAX_VALUE);
		fromK[K] = 0;
		PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				// TODO Auto-generated method stub
				return o1[0] - o2[0];
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

		pq.add(new int[] { 0, K });
//		boolean[] visited = new boolean[V + 1];
//		int count = 1;
		while (!pq.isEmpty()) {
//		while(count < V && !pq.isEmpty()) {
			int[] now = pq.poll();
			int curW = now[0], curV = now[1];

			for (int i = 0; i < edge[curV].size(); i++) {
				int nextV = edge[curV].get(i)[0];
				int nextW = edge[curV].get(i)[1] + fromK[curV] ;
				if (fromK[nextV] > nextW) {
					fromK[nextV] = nextW;
					pq.add(new int[] { nextW, nextV });
				}
			}
			// System.out.println("=====");
//				if(!visited[now[2]]) {
//					visited[now[2]] = true;
//					count++;
//				}

		}

		for (int i = 1; i < V + 1; i++) {
			sb.append((fromK[i] == Integer.MAX_VALUE ? "INF" : fromK[i]) + "\n");
		}

		bw.write(sb.toString());
		bw.flush();
	}
}