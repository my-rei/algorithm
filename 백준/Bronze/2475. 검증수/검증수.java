import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int res = 0;
		for(int i = 0;i<5;i++) {
			res += Math.pow(Integer.parseInt(st.nextToken()), 2);
		}
		bw.write(String.valueOf(res%10));
		bw.flush();
	}
}