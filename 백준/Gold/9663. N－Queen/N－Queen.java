import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	static int N, qCnt;
	static int[] queens;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		queens = new int[N];
		qCnt = 0;
		for(int i = 0;i<N;i++)
			queens[i] = -1;
		findNQ(0);
		System.out.println(qCnt);
	}
	
	static void findNQ(int cur) {
		if(cur == N) {
			qCnt++;
			return;
		}
		
		for(int i = 0; i<N;i++) {
			if(isQueen(cur, i)) {
				queens[cur] = i;
				findNQ(cur+1);
			}
		}
	}
	
	static boolean isQueen(int cur, int curValue) {
		for(int i = 0; i<cur;i++) {
		//	if(queens[i] == -1) continue;
			if (queens[i] == curValue) return false;
			if (Math.abs(queens[i] - curValue) == Math.abs(i - cur)) return false;
		}
		return true;
	}
}
