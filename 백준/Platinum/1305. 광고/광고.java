import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int N = Integer.parseInt(br.readLine()), j = 0, lastOne = 0, res = N;
		char[] screen = br.readLine().toCharArray();
		int[] table = new int[N];
		for(int i = 1;i<N;i++) {
			while(j>0 && screen[i] != screen[j]) {
				if(table[j-1] != 0) lastOne = i-1;
				j = table[j-1];
			}
			if(screen[i] == screen[j]) {
				table[i] = ++j;
//				System.out.println(i+" "+j);
				if(j == 1) lastOne = i;
				if(i == N-1) res = lastOne;
//				if(i == N-1 && table[i] == table[i-1]+1) res = lastOne;
			}
		}
//		System.out.println(Arrays.toString(table));
		bw.write(String.valueOf(res));
		bw.flush();
	}
}