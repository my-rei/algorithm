import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;
/*
 * 백준 15686 치킨배달
 */
public class Main {
	
	static int N, M, C, minC = Integer.MAX_VALUE;
	static int[][] map;
	static List<Point> hList, cList;
	static boolean[] selected;
	
	static class Point{
		int x;
		int y;
		public Point(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		hList = new ArrayList<>();
		cList = new ArrayList<>();
		map = new int[N][N];
		
		for(int i = 0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0;j<N;j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j] == 1) hList.add(new Point(i, j));
				else if(map[i][j] == 2) cList.add(new Point(i,j));
			}
		}
		selected = new boolean[cList.size()];
		getC(0,0);
		System.out.println(minC);
	}
	
	static void getC(int cur, int cnt) {
//		System.out.println("cur: "+cur+" cnt: "+cnt);
		if(cur == cList.size() || cnt == M) {
			if(cnt != 0)
				minC = Math.min(minC, getCdis());
			return;
		}
		
		for(int i = cur;i<cList.size();i++) {
			selected[i] = true;
			getC(i+1, cnt+1);
			selected[i] = false;
		}
		getC(cur+1, cnt);
	}
	
	static int getCdis() {
		int res = 0;
		for(int h = 0;h<hList.size();h++) {
			int min = Integer.MAX_VALUE;
			for(int c = 0; c<cList.size();c++) {
				if(selected[c]) {
//					System.out.println(cList.get(c).x+" "+cList.get(c).y);
					min = Math.min(Math.abs(hList.get(h).x-cList.get(c).x) + Math.abs(hList.get(h).y-cList.get(c).y), min);
				}
			}
//			System.out.println(min);
			if(min != Integer.MAX_VALUE) res += min;
		}
		return res;
	}
}
