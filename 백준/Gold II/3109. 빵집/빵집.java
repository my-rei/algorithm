import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	static char[][] map;
	static boolean[][] visited;
	static int[] deltaY = new int[] { -1, 0, 1 };
	static int maxPipe, R, C;
	static boolean flag;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] rc = br.readLine().split(" ");
		R = Integer.parseInt(rc[0]);
		C = Integer.parseInt(rc[1]);
		map = new char[R][C];
		visited = new boolean[R][C];
		maxPipe = 0;
		flag = false;
		for (int i = 0; i < R; i++)
			map[i] = br.readLine().toCharArray();
		findPipe();
		System.out.println(maxPipe);
	}
	
	
	static void findPipe() {
		int cI = 0, cJ=0, tI=0, lastT=tI;
		while(true) {
			flag = false;
			pipe(cI, cJ);
			if(flag) {
				cI++; cJ = 0; lastT = tI; tI++; maxPipe++;
			} else {
				if(tI == R-1) { cI++; tI = lastT;}
				tI ++; cJ=0; 
			}
			if(cI == R) break;
		}
	}
	
	static void pipe(int curI, int curJ) {
		if(flag) return;
		for(int y = 0;y<3;y++) {
			int nextI = curI + deltaY[y];
			int nextJ = curJ +1;
			if (nextI > -1 && nextI < R && nextJ > -1 && nextJ < C && !visited[nextI][nextJ]
					&& map[nextI][nextJ] == '.') {
				if(nextJ == C-1) {
					flag = true;
					return;
				}
				visited[nextI][nextJ] = true;
				pipe(nextI, nextJ);
			}
			if(flag) break;
		}
	}
}
