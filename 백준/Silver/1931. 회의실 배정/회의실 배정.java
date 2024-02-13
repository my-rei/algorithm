import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main {
	static class Conference {
		int start;
		int end;

		public Conference(int s, int e) {
			this.start = s;
			this.end = e;
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		Conference[] cons = new Conference[N];
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			cons[i] = new Conference(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
		}

		Arrays.sort(cons, new Comparator<Conference>() {
			@Override
			public int compare(Conference o1, Conference o2) {
				return o1.end == o2.end ? o1.start - o2.start : o1.end - o2.end;
			}
		});
		
		int cnt = 0, curTime = 0;
		for(int i = 0;i<N;i++) {
			if (curTime <= cons[i].start) {
				curTime = cons[i].end;
				cnt++;
			}
		}
		
		System.out.println(cnt);
	}
}
