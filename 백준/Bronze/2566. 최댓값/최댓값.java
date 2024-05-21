import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = null;
		int m = -1, r = -1, c = -1, n = 0;
		for(int i = 1;i<10;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 1;j<10;j++) {
				if((n=Integer.parseInt(st.nextToken())) > m) {
					m = n;
					r = i;
					c = j;
				}
			}
		}
		
		bw.write(m+"\n"+r+" "+c);
		bw.flush(); 
	}
	
}