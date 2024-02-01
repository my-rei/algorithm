import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] nk = br.readLine().split(" ");
		int n = Integer.parseInt(nk[0]);
		int k = Integer.parseInt(nk[1]);

		List<Integer> numList = new ArrayList<>();

		int curNum = 0;
		int curNumLim = 1;
		int curCnt = 0;
		int maxLim = 5 * n;

		for (int i = 0; i < maxLim; i++) {
			curNumLim = curNum == 0 ? 0 : (int) Math.floor(Math.log(curNum) / Math.log(2));

			numList.add((curNum & (int) (Math.pow(2, curCnt))) >> (curCnt));
			// System.out.println("curNum " + curNum + " curNumLim " + curNumLim + " curCnt
			// " + curCnt + " res "
			// + ((curNum & (int) (Math.pow(2, curCnt))) >> (curCnt)));
			if (curCnt <= 0) {
				curNum++;
				curCnt = curNum == 0 ? 0 : (int) Math.floor(Math.log(curNum) / Math.log(2));
			} else
				curCnt--;
		}
		for (int i = 0;i<5;i++) {
			
			System.out.print(numList.get(i*n+k-1)+" ");
		}
		// System.out.println(numList);
	}
}
