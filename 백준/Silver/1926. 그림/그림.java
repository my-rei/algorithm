
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		Queue<Integer[]> q = new LinkedList<>();

		String[] nm = br.readLine().split(" ");
		int n = Integer.parseInt(nm[0]);
		int m = Integer.parseInt(nm[1]);

		int maxPaint = 0;
		int cntPaint = 0;

		int[][] paper = new int[n][m];
		int[][] paint = new int[n][m];
		StringTokenizer st;

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < m; j++) {
				paper[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		int[][] d = { { 1, 0 }, { 0, 1 }, { -1, 0 }, { 0, -1 } };
		int curI = 0, curJ = 0;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (paper[i][j] == 1 && paint[i][j] == 0) {
					paint[i][j] = 1;
					int cP = 1;
					q.add(new Integer[] { i, j });
					while (!q.isEmpty()) {
						curI = q.peek()[0];
						curJ = q.peek()[1];
						for (int[] dXY : d) {
							if (curI + dXY[0] > -1 && curI + dXY[0] < n && curJ + dXY[1] > -1 && curJ + dXY[1] < m) {
								if (paper[curI + dXY[0]][curJ + dXY[1]] == 1
										&& paint[curI + dXY[0]][curJ + dXY[1]] == 0) {
									q.add(new Integer[] { curI + dXY[0], curJ + dXY[1] });
									paint[curI + dXY[0]][curJ + dXY[1]] = 1;
									cP++;
									//System.out.println("check" + (curI + dXY[0]) + " " + (curJ + dXY[1]));
								}
							}
						}
						//System.out.println(q.peek()[0] + " " + q.peek()[1]);
						q.poll();
					}
					//System.out.println("=======");
					cntPaint++;
					maxPaint = Math.max(maxPaint, cP);
				}
			}
		}

		System.out.println(cntPaint);
		System.out.println(cntPaint != 0 ? maxPaint : 0);

	}
}
