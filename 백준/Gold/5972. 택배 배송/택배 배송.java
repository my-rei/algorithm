import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		int[] fromZero = new int[N];
		PriorityQueue<Integer> pq = new PriorityQueue<>((o1, o2) -> Integer.compare(fromZero[o1], fromZero[o2]));
		Map<Integer, Integer>[] roads = (Map<Integer, Integer>[]) new HashMap[N];
		for (int i = 0; i < N; i++)
			roads[i] = new HashMap<>();

		while (M-- > 0) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken()) - 1;
			int b = Integer.parseInt(st.nextToken()) - 1;
			int c = Integer.parseInt(st.nextToken());
			int temp = roads[a].getOrDefault(b, c);
			roads[a].put(b, Math.min(c, temp));
			roads[b].put(a, Math.min(c, temp));
		}

		fromZero[0] = 0;
		pq.add(0);
		while (!pq.isEmpty()) {
			int cur = pq.poll();
			for (int b : roads[cur].keySet()) {
				int toB = fromZero[cur] + roads[cur].get(b);
				if(fromZero[b] == 0 || toB < fromZero[b]) {
					fromZero[b] = toB;
					pq.add(b);
				}
			}
		}

		bw.write(String.valueOf(fromZero[N-1]));
		bw.flush();
	}

}

/// 다익스트라 
//static int[] roads;
//public static void main(String[] args) throws IOException {
//	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//	BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
//	
//	StringTokenizer st = new StringTokenizer(br.readLine());
//	int N = Integer.parseInt(st.nextToken());
//	int M = Integer.parseInt(st.nextToken());
//	
//	PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> Integer.compare(o1[2], o2[2]));
//	while(M-->0) {
//		st = new StringTokenizer(br.readLine());
//		pq.add(new int[] {Integer.parseInt(st.nextToken())-1, Integer.parseInt(st.nextToken())-1, Integer.parseInt(st.nextToken())});
//	}
//	
//
//	roads = new int[N];
//	for(int i = 0;i<N;i++) roads[i] = i;
//	
//	int cost = 0;
//	System.out.println(Arrays.toString(roads));
//	
//	while(!pq.isEmpty()) {
//		int[] road = pq.poll();
//		if(find(road[0]) == find(road[1])) continue;
//		
//		sum(road[0], road[1]);
//		cost += road[2];
//		System.out.println(Arrays.toString(road)+" "+Arrays.toString(roads));
//		System.out.println(find(N-1)+" "+find(0));
//		if(find(N-1)==find(0)) break;
//	}
//	
//	bw.write(String.valueOf(cost));
//	bw.flush();
//}
//
//static void sum(int a, int b) {
//	int pa = find(a), pb = find(b);
//	roads[pa] = pb;
//}
//
//static int find(int v) {
//	if(v == roads[v]) return v;
//	else return roads[v] = find(roads[v]); 
//}
///

/// dfs

//static Map<Integer, Integer>[] roads;
//static int curMin = Integer.MAX_VALUE, N;
//static boolean[] vs;
//public static void main(String[] args) throws IOException {
//	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//	BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
//
//	StringTokenizer st = new StringTokenizer(br.readLine());
//	N = Integer.parseInt(st.nextToken());
//	int M = Integer.parseInt(st.nextToken());
//	
//	roads = (Map<Integer, Integer>[]) new HashMap[N];
//	for(int i = 0;i<N;i++) roads[i] = new HashMap<>();
//	vs = new boolean[N];
//	while (M-- > 0) {
//		st = new StringTokenizer(br.readLine());
//		int a = Integer.parseInt(st.nextToken())-1;
//		int b = Integer.parseInt(st.nextToken())-1;
//		int c = Integer.parseInt(st.nextToken());
//		
//		roads[a].put(b, Math.min(c, roads[a].getOrDefault(b, c)));
//		roads[b].put(a, Math.min(c, roads[b].getOrDefault(a, c)));
//	}
//	
//	dfs(0, 0);
//	bw.write(String.valueOf(curMin));
//	bw.flush();
//}
//
//static void dfs(int cur, int cost) {
//	if(cur == N-1) {
////		System.out.println("end = "+cost);
//		curMin = Math.min(cost, curMin);
//	}
//	
//	if(cost > curMin) return;
//	
//	for(int b : roads[cur].keySet()) {
//		if(!vs[b]) {
//			vs[b] = true;
//			dfs(b, cost+roads[cur].get(b));
//			vs[b] = false;
//		}
//	}
//}