import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static boolean[] ingredients;
	static int[] sour, bitter;
	static int N, minDif;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		N = Integer.parseInt(br.readLine());
		minDif = Integer.MAX_VALUE;

		ingredients = new boolean[N];

		sour = new int[N];
		bitter = new int[N];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");

			sour[i] = Integer.parseInt(st.nextToken());
			bitter[i] = Integer.parseInt(st.nextToken());
		}

		cook(0, 1, 0, 0);

		System.out.println(minDif);

	}

	static void cook(int cnt, int s, int b, int selects) {
		if (cnt == N) {
			if (selects != 0)
				minDif = Math.min(minDif, Math.abs(s - b));
			return;
		}

		ingredients[cnt] = true;
		cook(cnt + 1, s * sour[cnt], b + bitter[cnt], selects + 1);
		ingredients[cnt] = false;
		cook(cnt + 1, s, b, selects);

		return;
	}
}
