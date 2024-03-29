import java.io.*;
import java.util.*;

public class Main {
	static char[] T, P;
	static int[] pt;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		T = br.readLine().toCharArray();
		P = br.readLine().toCharArray();
		
		//전처리
		pt = new int[P.length];
		int tj = 0;
		for(int i = 1;i<P.length;i++) {
			while(tj > 0) {
				if(P[i] == P[tj]) break;
				tj = pt[tj-1];
			}
			if(P[i] == P[tj])
				pt[i] = ++tj;
		}
		
		//KMP
		int kj = 0, count = 0;
		for(int i = 0;i<T.length;i++) {
			while(kj > 0) {
				if(T[i] == P[kj]) break;
				kj = pt[kj-1];
			}
			if(T[i] == P[kj]) {
				kj++;
				if(kj == P.length) {
					count ++;
					sb.append((i-P.length+2)+" ");
					kj = pt[kj-1];
				}
			}
		}
		
		bw.write(String.valueOf(count)+"\n"+sb.toString());
		bw.flush();
		
	}
}