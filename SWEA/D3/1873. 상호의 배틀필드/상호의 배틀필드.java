import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	static char[][] map;
	static char[] order;
	static int ci, cj, H, W, dir;
	static int[] dI = { -1, 1, 0, 0 }, dJ = { 0, 0, -1, 1 };

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = null;
		int T = Integer.parseInt(br.readLine());
		for (int test = 1; test <= T; test++) {
			st = new StringTokenizer(br.readLine());
			H = Integer.parseInt(st.nextToken());
			W = Integer.parseInt(st.nextToken());
			map = new char[H][W];
			for (int i = 0; i < H; i++)
				map[i] = br.readLine().toCharArray();
			int N = Integer.parseInt(br.readLine());
			order = br.readLine().toCharArray();

			for (int i = 0; i < H; i++)
				for (int j = 0; j < W; j++)
					if (map[i][j] == '^' || map[i][j] == 'v' || map[i][j] == '<' || map[i][j] == '>') {
						dir = map[i][j] == '^' ? 0 : map[i][j] == 'v' ? 1 : map[i][j] == '<' ? 2 : 3;
						ci = i;
						cj = j;
						break;
					}

			for (int i = 0; i < N; i++) {
				switch (order[i]) {
				case 'U': 
				case 'D': 
				case 'L': 
				case 'R':
					dir = order[i] == 'U' ? 0 : order[i] == 'D' ? 1 : order[i] == 'L' ? 2 : 3;
					move();
					break;
				case 'S':
					shoot();
					break;
				}
			}
			
			sb.append("#"+test+" ");
			for (int i = 0; i < H; i++) {
				for (int j = 0; j < W; j++)
					sb.append(map[i][j]);
				sb.append("\n");
			}
		}
		
		System.out.println(sb);
	}

	static void move() {
		char[] shape = { '^', 'v', '<', '>' };
		int ei = ci + dI[dir];
		int ej = cj + dJ[dir];
		map[ci][cj] = shape[dir];
		if (ei > -1 && ei < H && ej > -1 && ej < W && map[ei][ej] == '.') {
			map[ei][ej] = shape[dir];
			map[ci][cj] = '.';
			ci = ei;
			cj = ej;
		}
	}
	
	static void shoot() {
		int ni =ci, nj = cj;
		while(true) {
			ni = ni + dI[dir];
			nj = nj + dJ[dir]; 
			if(ni < 0 || ni >= H || nj < 0 || nj >= W) break;
			if(map[ni][nj] == '#') break;
			if(map[ni][nj] == '*') {
				map[ni][nj] = '.';
				break;
			}
		}
	}
}
