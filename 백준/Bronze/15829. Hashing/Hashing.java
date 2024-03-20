import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int L = Integer.parseInt(br.readLine()), r = 31, M = 1234567891;
		long result = 0, cur = 1;
		String target = br.readLine();
		
		for(int i = 0;i<L;i++) {
			result += (target.charAt(i)-'a'+1)*(cur);
			cur = (cur*r)%M;
		}
		
		bw.write(String.valueOf(result%M));
		bw.flush();
	}
}