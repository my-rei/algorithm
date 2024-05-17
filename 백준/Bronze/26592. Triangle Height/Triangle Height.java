import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = null;
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine());
		
		for(int i = 0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			double h = (Double.parseDouble(st.nextToken()) * 2) / Double.parseDouble(st.nextToken());
			sb.append(String.format("The height of the triangle is %.2f units", h)).append("\n");
		}
		
		bw.write(sb.toString());
		bw.flush(); 
	}
	
}