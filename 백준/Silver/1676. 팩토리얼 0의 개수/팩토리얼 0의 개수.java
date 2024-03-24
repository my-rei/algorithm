import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int N = Integer.parseInt(br.readLine()), cnt = 0;
		int ten = 0, two = 0, five= 0;
		for(int i = N;i>0;i--) {
			int tmp = i;
			while(tmp%10 == 0) {
				tmp /= 10;
				ten++;
			}
			while(tmp%2 == 0) {
				tmp /= 2;
				two++;
			}
			while(tmp%5 == 0) {
				tmp /= 5;
				five++;
			}
		}
		bw.write(String.valueOf(ten+Math.min(two, five)));
		bw.flush();
	}
	
	
}