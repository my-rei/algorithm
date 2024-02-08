import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int[][] paper;
	static long[] nCnt = new long[3];

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		paper = new int[N][N];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++)
				paper[i][j] = Integer.parseInt(st.nextToken());
		}
		cut((int) Math.round(Math.log(N) / Math.log(3)), 0, 0);
		for (long c : nCnt)
			System.out.println(c);
	}

	static void cut(int depth, int opI, int opJ) {
		int f = paper[opI][opJ];

		if (depth == 0) {
			nCnt[f + 1]++;
			return;
		}

		int nowW = (int) Math.pow(3, depth);
		int cutW = (int) Math.pow(3, depth - 1);
		boolean flg = false;
		for (int i = opI; i < opI + nowW; i++) {
			for (int j = opJ; j < opJ + nowW; j++) {
				if (f != paper[i][j]) {
					flg = true;
					break;
				}
			}
			if (flg)
				break;
		}

		if (flg) {
			for (int i = opI; i < opI + nowW; i += cutW) {
				for (int j = opJ; j < opJ + nowW; j += cutW) {
					cut(depth - 1, i, j);
				}
			}
		} else 
			nCnt[f + 1]++;
	}
}