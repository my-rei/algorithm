import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine());
		while(N-- > 0){
			StringTokenizer st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken()) % 10;
			int b = Integer.parseInt(st.nextToken());
			double res = a;

			if (a == 0) res = 10;
			else if(a==4 || a == 9) res = Math.pow(a, b%2+2) % 10;
			else if(a==2 || a==3 || a==7 || a==8) res = Math.pow(a, b%4+4) % 10;

			sb.append((int) res).append("\n");
		}
		bw.write(sb.toString());
		bw.flush();
		
	}
}