import java.io.*;
import java.util.*;

public class Main {
	static int n;
	static int[] parent;
	static double[][] cor;
	static PriorityQueue<double[]> q;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = null;
		
		n = Integer.parseInt(br.readLine());
		cor = new double[n][2];
		for(int i = 0;i<n;i++) {
			st = new StringTokenizer(br.readLine());
			cor[i][0] = Double.parseDouble(st.nextToken());
			cor[i][1] = Double.parseDouble(st.nextToken());
		}
		
		q = new PriorityQueue<>(new Comparator<double[]>() {
			@Override
			public int compare(double[] o1, double[] o2) {
				return Double.compare(o1[2], o2[2]);
			}
		});
		int count = 0; double sum = 0;
		makeset();
		for(int i = 0;i<n;i++) {
			if(find(0) != find(i)) {
				q.add(new double[] {0, i, getDis(cor[0][0], cor[0][1], cor[i][0], cor[i][1])});
			}
		}
		while(!q.isEmpty()) {
			double[] now = q.poll();
			if(union((int) now[0], (int) now[1])) {
				// T-T' 사이 최소 간선 연결 
				count++;
				sum += now[2];
				// 새로 들어온 점과 T' 사이의 간선을 추가
				for(int i = 0;i<n;i++) {
					if(find((int) now[1]) != find(i)) {
						q.add(new double[] {now[1], i, getDis(cor[(int)now[1]][0], cor[(int)now[1]][1], cor[i][0], cor[i][1])});
					}
				}
			}
			if(count == n) break;
		}
		
		bw.write(String.format("%.2f", sum));
		bw.flush();
		
		
	}
	
	static double getDis(double x1, double y1, double x2, double y2) {
		return Math.sqrt(Math.pow(x1-x2, 2) + Math.pow(y1-y2, 2));
	}
	
	static boolean union(int a, int b) {
		int pa = find(a), pb = find(b);
		if(pa == pb) return false;
		else {
			parent[pb] = pa;
			return true;
		}
	}
	
	static int find(int a) {
		if(parent[a] == a) return a;
		else return parent[a] = find(parent[a]);
	}
	
	static void makeset() {
		parent = new int[n];
		for(int i = 0;i<n;i++) parent[i] = i;
	}
}