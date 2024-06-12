import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int A = Integer.parseInt(st.nextToken());
		int B = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());
		
		int max = Math.max(A, Math.max(B, C));
		int rest = 0;
		if(max == A) rest = B+C;
		else if (max==B) rest = A+C;
		else rest = A+B;
		
		int result = 0;
		if(rest > max) result = rest+max;
		else result = rest * 2-1;

		bw.write(String.valueOf(result));
		bw.flush();
	}
}