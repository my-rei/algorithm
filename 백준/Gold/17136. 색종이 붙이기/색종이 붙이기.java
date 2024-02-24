import java.io.*;
import java.util.*;

/*
0 0 0 0 0 0 0 0 0 0
0 0 1 1 1 1 1 1 0 0
0 0 1 1 1 1 1 1 0 0
0 0 1 1 1 1 1 1 0 0
0 0 1 1 1 1 1 1 0 0
0 0 1 1 1 1 1 1 0 0
0 0 1 1 1 1 1 1 0 0
0 0 0 0 0 0 0 0 0 0
0 0 0 0 0 0 0 0 0 0
0 0 0 0 0 0 0 0 0 0
 */

public class Main {
	static int N = 10, minCnt = Integer.MAX_VALUE;
	static char[][] map;
	static int[] papers;
	static int[] dr = new int[] { 0, 1, 0, -1 }, dc = new int[] { 1, 0, -1, 0 };
	static List<ColorPaper> cList;

	static class ColorPaper {
		int x, y, w;

		public ColorPaper(int x, int y, int w) {
			super();
			this.x = x;
			this.y = y;
			this.w = w;
		}

		@Override
		public String toString() {
			// TODO Auto-generated method stub
			return "CP(" + this.x + "," + this.y + ")[" + this.w + "]";
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = null;

		map = new char[N][N];
		papers = new int[5];
		cList = new ArrayList<>();
		for (int i = 0; i < N; i++) {
			map[i] = br.readLine().replace(" ", "").toCharArray();
		}
		int cnt = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (map[i][j] == '1') {
					cnt++;
				}
			}
		}
		if (cnt == 0)
			System.out.println(0);
		else {
//		for (int i = 0; i < N; i++) {
//			System.out.println(Arrays.toString(map[i]));
//		}
//		System.out.println();
//		for (int i = 0; i < N; i++) {
//			System.out.println(Arrays.toString(maxMap[i]));
//		}

//		cList.add(new ColorPaper(3,4,3));
//		System.out.println(findMax(3,3));
			dfs(0);
			bw.write(minCnt == Integer.MAX_VALUE ? "-1" : String.valueOf(minCnt));
			bw.flush();
		}
	}

	static void dfs(int cnt) {
//		System.out.println("=====dfs" + cnt + "======");
//		System.out.println(cList.toString());
		int r = -1, c = -1, maxSize = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (map[i][j] == '1' && !isIn(i, j)) {
					r = i;
					c = j;
					break;
				}
			}
			if (r != -1 && c != -1)
				break;
		}
		int s1 = findMax(r, c);
//		System.out.println("go "+r+" "+c+" "+s1);
		for (int s = s1; s > 0; s--) {
			//List<ColorPaper> tmpCp = isOnly(r, c, s);
//		System.out.println(Arrays.toString(papers));
			if (papers[s - 1] + 1 <= 5) {
				cList.add(new ColorPaper(r,c,s));
				papers[s - 1]++;
				dfs(cnt + 1);
				papers[s - 1]--;
				cList.remove(cnt);
			}
//			if (s > 1 && tmpCp.size() > 1) {
//				for (ColorPaper cp : tmpCp) {
//					if (papers[s - 1] + 1 <= 5) {
//						cList.add(cp);
//						papers[s - 1]++;
//						dfs(cnt + 1);
//						papers[s - 1]--;
//						cList.remove(cnt);
//					}
//				}
//			} else if (s > 0) {
////			System.out.println("aa");
//				if (papers[s - 1] + 1 <= 5) {
//					cList.add(new ColorPaper(r, c, s));
//					papers[s - 1]++;
//					dfs(cnt + 1);
//					papers[s - 1]--;
//					cList.remove(cnt);
//				}
//			}
		}

		if (s1 == 0) {
//			System.out.println("maxSize " + cnt);
//			System.out.println(cList.toString());
			minCnt = Math.min(minCnt, cnt);
		} else {
//			System.out.println("cnt "+ cnt+" = "+s1);
		}
	}

	static List<ColorPaper> isOnly(int r, int c, int s) {
		List<ColorPaper> tmpCp = new ArrayList<>();
		for (int i = r; i < r + s; i++) {
			for (int j = c; j < c + s; j++) {
				if (findMax(i, j) == s) {
					tmpCp.add(new ColorPaper(i, j, s));
				}
			}
		}
		return tmpCp;
	}

	static int findMax(int r, int c) {
		if (r == -1 && c == -1)
			return 0;
		int size = 1;
		int cr = r, cc = c;
		while (size <= 5) {
			for (int d = 0; d < 4; d++) {
				for (int s = 0; s < size; s++) {
					cr = cr + dr[d];
					cc = cc + dc[d];
					if (cr < 0 || cr >= N || cc < 0 || cc >= N)
						return size;
					if (map[cr][cc] != '1' || isIn(cr, cc))
						return size;
				}
			}
			size++;
		}
		return 5;
	}

	static boolean isIn(int r, int c) {
		for (int i = 0; i < cList.size(); i++) {
			if (cList.get(i).x <= r && cList.get(i).x + cList.get(i).w > r && cList.get(i).y <= c
					&& cList.get(i).y + cList.get(i).w > c) {
				return true;
			}
		}
//		System.out.println("r:" + r + " c:" + c + " is not in");
		return false;
	}
}