import java.io.*;
import java.util.*;

public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int[] length = new int[N-1];
		for(int i = 0;i<N-1;i++)
			length[i] = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		int curmin = Integer.parseInt(st.nextToken());
		long sum = 0;
		for(int i = 0;i<N-1;i++) {
			sum += (long)curmin * length[i];
			curmin = Math.min(curmin, Integer.parseInt(st.nextToken()));
		}
		

		bw.write(String.valueOf(sum));
		bw.flush();
	}

}