import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.StringTokenizer;

public class Solution {
	static Cell[][] map;

	static class BC {
		int num;
		int p;

		public BC(int n, int p1) {
			this.num = n;
			this.p = p1;
		}
	}

	static class Cell {
		int bcC = 0;
		List<BC> bcList = new ArrayList<>();

	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = null;

		int T = Integer.parseInt(br.readLine());

		int[] delI = { 0, -1, 0, 1, 0 }, delJ = { 0, 0, 1, 0, -1 };
		for (int test = 1; test <= T; test++) {
			st = new StringTokenizer(br.readLine());
			int M = Integer.parseInt(st.nextToken()), A = Integer.parseInt(st.nextToken());
			char[] mA = br.readLine().replace(" ", "").toCharArray(), mB = br.readLine().replace(" ", "").toCharArray();
			map = new Cell[10][10];
			for (int b = 0; b < A; b++) {
				st = new StringTokenizer(br.readLine());
				int cj = Integer.parseInt(st.nextToken()) - 1, ci = Integer.parseInt(st.nextToken()) - 1,
						c = Integer.parseInt(st.nextToken()), p = Integer.parseInt(st.nextToken());
				BC nBC = new BC(b + 1, p);
				for (int i = 0; i < 10; i++) {
					for (int j = 0; j < 10; j++) {
						if (map[i][j] == null)
							map[i][j] = new Cell();
						if ((Math.abs(i - ci) + Math.abs(j - cj)) <= c) {
							map[i][j].bcC++;
							map[i][j].bcList.add(nBC);
						}
					}
				}
			}

			for (int i = 0; i < 10; i++) {
				for (int j = 0; j < 10; j++) {
					Collections.sort(map[i][j].bcList, new Comparator<BC>() {
						@Override
						public int compare(BC o1, BC o2) {
							return o2.p - o1.p;
						}
					});
				}
			}

			int chargeA = 0, chargeB = 0, tmpCA = 0, tmpCB = 0;
			BC bcA, bcB;
			int ai = 0, aj = 0, bi = 9, bj = 9;
			// 0초일 때
			Cell aCell = map[ai][aj];
			chargeA += aCell.bcC > 0 ? aCell.bcList.get(0).p : 0;
			Cell bCell = map[bi][bj];
			chargeB += bCell.bcC > 0 ? bCell.bcList.get(0).p : 0;

			for (int t = 0; t < M; t++) {
				// a 이동
				ai = ai + delI[mA[t] - '0'];
				aj = aj + delJ[mA[t] - '0'];
				aCell = map[ai][aj];
				bcA = aCell.bcC > 0 ? aCell.bcList.get(0) : null;

				// b 이동
				bi += delI[mB[t] - '0'];
				bj += delJ[mB[t] - '0'];
				bCell = map[bi][bj];
				bcB = bCell.bcC > 0 ? bCell.bcList.get(0) : null;

				if (aCell.bcC > 0) {
					if (bcB == null || bcA.num != bcB.num) { // 송신기 다름
						tmpCA = bcA.p;
					} else {
						if (aCell.bcC == 1) {
							if (bCell.bcC == 1) // 송신기 공유
								tmpCA = bcA.p / 2;
							else // b 양보
								tmpCA = bcA.p;

						} else {
							if (bCell.bcC == 1) // a 양보
								tmpCA = aCell.bcList.get(1).p;
							else {
								if (aCell.bcList.get(1).p > bCell.bcList.get(1).p) // a 양보
									tmpCA = aCell.bcList.get(1).p;
								else // b 양보
									tmpCA = bcA.p;

							}
						}
					}
					chargeA += tmpCA;
				}
				if (bCell.bcC > 0) {
					if (bcA == null || bcA.num != bcB.num) { // 송신기 다름
						tmpCB = bcB.p;
					} else {
						if (bCell.bcC == 1) {
							if (aCell.bcC == 1) // 송신기 공유
								tmpCB = bcB.p / 2;
							else // a 양보
								tmpCB = bcB.p;
						} else {
							if (aCell.bcC == 1) // b 양보
								tmpCB = bCell.bcList.get(1).p;
							else {
								if (aCell.bcList.get(1).p > bCell.bcList.get(1).p) // a 양보
									tmpCB = bcB.p;
								else // b 양보
									tmpCB = bCell.bcList.get(1).p;
							}
						}
					}
					chargeB += tmpCB;
				}
			}
			sb.append("#" + test + " " + (chargeA + chargeB) + "\n");
		}
		System.out.println(sb);
	}
}
