import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {
	static int cur;
	static int[] weights;
	static int m, maxW;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			String[] nm = br.readLine().split(" ");
			cur = 0;
			weights = new int[Integer.parseInt(nm[0])];
			m = Integer.parseInt(nm[1]);
			String[] ins = br.readLine().split(" ");
			for (int i = 0; i < weights.length; i++) {
				weights[i] = Integer.parseInt(ins[i]);
			}
			maxW = -1;
			selectSnack(0, 0);
			sb.append("#"+t+" "+maxW+"\n");
		}
		System.out.println(sb);
	}

	static void selectSnack(int cnt, int curW) {
		if (cnt == 2) {
			maxW = curW > m ? maxW : Math.max(curW, maxW);
			return;
		}

		for (int i = cur; i < weights.length; i++) {
			int temp = cur;
			cur = i + 1;
			selectSnack(cnt + 1, curW + weights[i]);
			cur = temp;
		}
	}
}
