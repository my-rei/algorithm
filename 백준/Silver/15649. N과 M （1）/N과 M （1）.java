import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	static int[] isSelected;
	static int n, m;
	static int[][] numPrint;
	static int colCnt = 0;
	static StringBuilder sb;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		sb = new StringBuilder();
		String[] nm = br.readLine().split(" ");
		n = Integer.parseInt(nm[0]);
		m = Integer.parseInt(nm[1]);

		isSelected = new int[n];

		numPrint = new int[70][70];
		colCnt = 0;

		findSeq(0, "");

//		for (int i = 0; i < numPrint.length; i++) {
//			if (numPrint[i][0] == 0)
//				break;
//			for (int j = 0; j < numPrint[i].length; j++) {
//				if (numPrint[i][j] == 0) {
//					sb.append("\n");
//					break;
//				}
//				sb.append(numPrint[i][j] + " ");
//			}
//		}

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
//				for (int j = 0; j < 70; j++) {
//					if (numPrint[colCnt][j] == 0) {
//						numPrint[colCnt][j] = i + 1;
//						break;
//					}
//				}
				findSeq(cnt + 1, res + (i + 1) + " ");
				colCnt++;
				isSelected[i] = 0;

			}
		}
	}
}
