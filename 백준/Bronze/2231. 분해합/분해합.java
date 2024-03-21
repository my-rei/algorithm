import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int N = Integer.parseInt(br.readLine());
		bw.write(String.valueOf(getCon(N)));
		bw.flush();
	}
	
	static int getCon(int N) {
		for(int i = 1;i<=N;i++) {
			if(getSum(i) == N) {
				return i;
			}
		}
		return 0;
	}
	
	static int getSum(int n) {
		int res = n;
		while(n>0) {
			res += n%10;
			n /= 10;
		}
		return res;
	}
}