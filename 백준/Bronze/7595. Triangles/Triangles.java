import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringBuilder sb = new StringBuilder();
		
		int N = 0;
		while((N=Integer.parseInt(br.readLine())) != 0) {
			for(int i = 1;i<=N;i++) {
				for(int j = 0;j<i;j++) {
					sb.append("*");
				}
				sb.append("\n");
			}
		}
		bw.write(sb.toString());
		bw.flush();
	}
}