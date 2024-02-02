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

		int cnt = 0, startNum = 0, curNum = 0;
		List<Integer> twoList = new ArrayList<>();
		List<Integer> twoTemp = new ArrayList<>();
		while (true) {
			if (curNum == 0) {
				curNum = startNum++;
				for (int i = twoTemp.size() - 1; i > -1; i--) {
					twoList.add(twoTemp.get(i));
				}
				twoTemp.clear();
			}

			twoTemp.add(1 & curNum);
			curNum = curNum >> 1;
			
			if(cnt++ > 5*n) 
				if(curNum == 0)
					break;
		}
		for (int i = twoTemp.size() - 1; i > -1; i--) {
			twoList.add(twoTemp.get(i));
		}

		for (int i = 0; i < 5; i++) {
			System.out.print(twoList.get(i * n + k - 1) + " ");
		}
	}
}
