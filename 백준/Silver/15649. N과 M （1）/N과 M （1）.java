import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	static int[] isSelected;
	static int n, m;
	static StringBuilder sb;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		sb = new StringBuilder();
		String[] nm = br.readLine().split(" ");
		n = Integer.parseInt(nm[0]);
		m = Integer.parseInt(nm[1]);

		isSelected = new int[n];

		findSeq(0, "");

		System.out.println(sb);
	}

	static void findSeq(int cnt, String res) {
		if (cnt == m) {
			sb.append(res + "\n");
			return;
		}

		for (int i = 0; i < n; i++) {
			if (isSelected[i] == 0) {
				isSelected[i] = 1;
				findSeq(cnt + 1, res + (i + 1) + " ");
				isSelected[i] = 0;

			}
		}
	}
}
