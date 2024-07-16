import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int res = -1;
		int N = Integer.parseInt(st.nextToken());
		int T = Integer.parseInt(st.nextToken());
		while(N-->0) {
			st = new StringTokenizer(br.readLine());
			int S = Integer.parseInt(st.nextToken());
			int I = Integer.parseInt(st.nextToken());
			int C = Integer.parseInt(st.nextToken());
//			System.out.println("T="+T+" S="+S+" S+I*(C-1)="+(S+I*(C-1)));
			if(S+I*(C-1) < T) continue;
			else if(T == S) res = 0;
			else if(T < S) {
				int tmp = S-T;
				res = res==-1? tmp:Math.min(res, tmp);
			}
			else {
				int tmp = ((T-S)/I + 1)*I + S - T;
				if((T-S)%I == 0) tmp = ((T-S)/I)*I + S - T;
//				System.out.println("res="+res+" tmp="+tmp);
				res = res==-1? tmp:Math.min(res, tmp);
			}
		}

		bw.write(String.valueOf(res));
		bw.flush();
	}

}