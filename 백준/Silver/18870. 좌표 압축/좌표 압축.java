import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main {
	static class Cor {
		int x;
		int n;
		public Cor(int x, int n) {
			this.x = x;
			this.n = n;
		}
	}
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		Cor[] corList = new Cor[N];
		int[] resList = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 0;i<N;i++) {
			int t = Integer.parseInt(st.nextToken());
			corList[i] = new Cor(t, i);
		}
		
		Arrays.sort(corList, new Comparator<Cor>() {
			@Override
			public int compare(Cor o1, Cor o2) {
				return o1.x - o2.x;
			}
		});
		
		int cnt = 0;
		resList[corList[0].n] = cnt;
		for(int i = 1;i<N;i++) {
			resList[corList[i].n] = corList[i].x == corList[i-1].x? cnt:++cnt;
		}
		
		StringBuilder sb = new StringBuilder();
		for(int i = 0;i<N;i++) {
			sb.append(resList[i]+" ");
		}
		
		System.out.println(sb);
	}
}
