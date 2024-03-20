import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int L = Integer.parseInt(br.readLine()), result = 0, r = 31, M = 1234567891;
		String target = br.readLine();
		
		for(int i = 0;i<L;i++) 
			result += (target.charAt(i)-'a'+1)*Math.pow(r, i)%M;
		
		bw.write(String.valueOf(result%M));
		bw.flush();
	}
}