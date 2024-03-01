import java.io.*;
import java.util.*;

public class Main {
	static int V, E;
	static int[] parents;
	static class Line {
		int a, b, c;
		public Line(int a, int b, int c) {
			this.a = a;
			this.b = b;
			this.c = c;
		}
	}
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		V = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());
		PriorityQueue<Line> lq = new PriorityQueue<>(new Comparator<Line>() {
			@Override
			public int compare(Line o1, Line o2) {
				return o1.c - o2.c;
			}
		});
		for(int i = 0;i<E;i++) {
			st = new StringTokenizer(br.readLine());
			lq.add(new Line(Integer.parseInt(st.nextToken())-1, Integer.parseInt(st.nextToken())-1, Integer.parseInt(st.nextToken())));
		}
		
		
		int count = 0, weight = 0;
		Line l = null;
		makeSet();
		while(!lq.isEmpty()) {
			l = lq.poll();
			if(union(l.a, l.b)) {
				weight += l.c;
				count++;
			}
			if(count == V) break;
		}
		
		bw.write(String.valueOf(weight));
		bw.flush();
	}
	
	static void makeSet() {
		parents = new int[V];
		for(int i =0;i<V;i++) parents[i] = i;
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