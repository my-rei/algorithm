import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = null;
		
		int A=0,B=0,C=0; String s = "";
		String[] result = new String[] {"Equilateral", "Isosceles", "Scalene", "Invalid"};
		while (true) {
			st = new StringTokenizer(br.readLine());
			A = Integer.parseInt(st.nextToken()); B = Integer.parseInt(st.nextToken()); C = Integer.parseInt(st.nextToken());
			
			if(A+B+C==0) break;
			int m = Math.max(A, Math.max(B, C));
			if((m==A&&(m>=B+C))||(m==B&&(m>=A+C))||(m==C&&(m>=A+B))) {
				sb.append(result[3]+"\n"); continue;
			}
			sb.append((A==B? B==C? result[0]:result[1]:B==C? result[1]: A==C? result[1]:result[2])+"\n");
		} 
		bw.write(sb.toString());
		bw.flush();
	}
}