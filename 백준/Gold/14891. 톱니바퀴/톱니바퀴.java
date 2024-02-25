import java.io.*;
import java.util.*;

public class Main {
	static int[][] magnet;
	static int[] pivot;
	static int M = 4, L = 8;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = null;

		magnet = new int[M][L];
		for (int i = 0; i < M; i++) {
			String str = br.readLine();
			for (int j = 0; j < L; j++) {
				magnet[i][j] = str.charAt(j)-'0';
			}
		}

		pivot = new int[M];
		int K = Integer.parseInt(br.readLine());
		while (K-- > 0) {
			st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken()) - 1, spin = Integer.parseInt(st.nextToken());

			int ls = spin * -1, rs = spin * -1;
			int lPrev = getM(n, 6), rPrev = getM(n, 2);
			spinM(n, spin);
			for (int t = n - 1; t > -1; t--) {
				// 이전 자석 값과 비교
				if (lPrev != getM(t, 2)) {
					// 다르다면 회전, 회전 전 값 저장해둠
					lPrev = getM(t, 6);
					spinM(t, ls);
					// 다음 회전 방향 전환
					ls *= -1;
				} else {
					break;
				}
			}

			for (int t = n + 1; t < M; t++) {
				if (rPrev != getM(t, 6)) {
					rPrev = getM(t, 2);
					spinM(t, rs);
					rs *= -1;
				} else {
					break;
				}
			}
		}

		int res = 0;
		for (int i = 0; i < M; i++) {
			res += getM(i, 0) == 1 ? (int) Math.pow(2, i) : 0;
		}
		sb.append(res + "\n");

		bw.write(sb.toString());
		bw.flush();
	}

	static int getM(int number, int pos) {
		// 0: 빨간색 화살표 2: 오른쪽과 맞닿음 6: 왼쪽과 맞닿음
		return magnet[number][(pos + pivot[number]) % L];
	}

	static void spinM(int number, int s) {
		// 회전
		if (s == 1) // 시계방향이면 인덱스를 한 칸 감소
			pivot[number] = (pivot[number] + 7) % L;
		else if (s == -1) // 반시계 방향이면 인덱스를 한 칸 증가
			pivot[number] = (pivot[number] + 1) % L;
	}
}