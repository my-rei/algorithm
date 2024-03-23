import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		bw.write(String.valueOf(getNum(Integer.parseInt(br.readLine()))));
		bw.flush();
	}
	
	static int getNum(int N) {
		int i = 0, count = 0;
		while(count <= N) {
			if(String.valueOf(i++).contains("666")) {
				count++;
				if(count == N) return i-1;
			}
		}
		return 0;
	}
	
}