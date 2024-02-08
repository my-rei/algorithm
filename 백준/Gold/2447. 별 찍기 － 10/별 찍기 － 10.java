import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	static char[][] starMap;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();

		starMap = new char[N][N];
		star(N, 0, 0);
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) { 
				if (starMap[i][j] == '*')
					sb.append('*');
				else
					sb.append(' ');
			}
			sb.append('\n');
		}

		System.out.println(sb);
	}

	static void star(int width, int ci, int cj) {
		if (width == 1) {
			starMap[ci][cj] = '*';
			return;
		}

		int cnt = 0;
		for (int i = ci; i < ci + width; i += width / 3) 
			for (int j = cj; j < cj + width; j += width / 3) 
				if (++cnt != 5)
					star(width / 3, i, j);

	}
}
