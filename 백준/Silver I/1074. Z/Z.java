import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	static int zCnt = 0, r, c;
	static boolean flg = false;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String[] Nrc = br.readLine().split(" ");
		int N = Integer.parseInt(Nrc[0]);
		r = Integer.parseInt(Nrc[1]) + 1;
		c = Integer.parseInt(Nrc[2]) + 1;

		findZ(1, 1, (int) Math.pow(2, N), (int) Math.pow(2, N));
		System.out.println(zCnt);
	}

	static void findZ(int si, int sj, int ei, int ej) {
		//System.out.println(si + " " + sj + " " + ei + " " + ej +" :: "+r+" "+c);
		if (ei - si == 0 && ej - sj == 0) {
			if (si == r && sj == c)
				flg = true;
			else
				zCnt++;
			return;
		}

		if (!flg)
			if (r >= si && c >= sj && r <= ei && c <= ej) {
				findZ(si, sj, si + (ei - si + 1) / 2 - 1, sj + (ej - sj + 1) / 2 - 1);
			} else {
				zCnt += (si + (ei - si + 1) / 2 - 1 - si + 1) * (sj + (ej - sj + 1) / 2 - 1 - sj + 1);
			}

		if (!flg)
			if (r >= si && c >= sj && r <= ei && c <= ej) {
				findZ(si, sj + (ej - sj + 1) / 2, si + (ei - si + 1) / 2 - 1, ej);
			} else {
				zCnt += (si + (ei - si + 1) / 2 - 1 - si + 1) * (ej - (sj + (ej - sj + 1) / 2) + 1);
			}

		if (!flg)
			if (r >= si && c >= sj && r <= ei && c <= ej) {
				findZ(si + (ei - si + 1) / 2, sj, ei, sj + (ej - sj + 1) / 2 - 1);
			} else {
				zCnt += (ei - (si + (ei - si + 1) / 2) + 1) * (sj + (ej - sj + 1) / 2 - 1 - sj + 1);
			}

		if (!flg)
			if (r >= si && c >= sj && r <= ei && c <= ej) {
				findZ(si + (ei - si + 1) / 2, sj + (ej - sj + 1) / 2, ei, ej);
			} else {
				zCnt += (ei - (si + (ei - si + 1) / 2) + 1) * (ej - (sj + (ej - sj + 1) / 2) + 1);
			}

	}
}
