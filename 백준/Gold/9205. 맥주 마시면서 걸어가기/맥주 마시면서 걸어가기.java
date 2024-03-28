import java.io.*;
import java.util.*;

public class Main {
	static int N;
	static Point fest;
	static Point[] points;
	static Queue<Point> q;
	static class Point {
		int x, y;
		public Point(int x, int y) {
			this.x = x; this.y = y;
		}
	}
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = null;
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		while(T-- > 0) {
			N = Integer.parseInt(br.readLine());
			points = new Point[N];
			st = new StringTokenizer(br.readLine());
			q = new ArrayDeque<>();
			q.add(new Point(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
			for(int i = 0;i<N;i++) {
				st = new StringTokenizer(br.readLine());
				points[i] = new Point(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
			}
			st = new StringTokenizer(br.readLine());
			fest = new Point(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
			
			sb.append(bfs()? "happy\n":"sad\n");
		}
		bw.write(sb.toString());
		bw.flush();
	}
	
	static boolean bfs() {
		while(!q.isEmpty()) {
			Point p = q.poll();
			if(getDis(p, fest) <= 1000) return true;
			for(int i = 0;i<N;i++) {
				if(getDis(p, points[i])<=1000) {
					q.add(points[i]);
					points[i] = null;
				}
			}
		}
		return false;
	}
	
	static int getDis(Point p1, Point p2) {
		if(p1 == null || p2 == null) return 10000;
		else return Math.abs(p1.x - p2.x) + Math.abs(p1.y-p2.y);
	}
}