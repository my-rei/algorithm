import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;
/*
 13
 3 3
1
100
4
// 3
 * 
 * 
 */
public class Main {
	static int N, C;
	static int[] list;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		list = new int[N];
		for(int i = 0;i<N;i++) {
			list[i] = Integer.parseInt(br.readLine());
		}
		Arrays.sort(list);
		
		bw.write(String.valueOf(varBinFind()));
		bw.flush();
	}
	
	static int varBinFind() {
		int s = 1, e = list[N-1]-list[0]+1;
		
		while(s<e) {
			int mid = (s+e)/2;
//			System.out.println(mid+" "+count(mid)+" s="+s+" e="+e);
			if(count(mid) < C) {
				e = mid;
			} else {
				s = mid+1;
			}
		}
		
		return s-1;
	}
	
	static int count(int t) {
		int last = list[0], cnt = 1;
		
		for(int i = 0;i<list.length&&cnt<C;i++) {
			if(list[i] - last >= t) {
				last = list[i];
				cnt++;
			}
		}
		
		
		return cnt;
	}
}