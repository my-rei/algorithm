import java.io.*;
import java.util.Arrays;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		String[] str = br.readLine().split(" ");
		char[] barr = str[1].toCharArray();
		long res = 0, bsum = 0;
		for(char b:barr) {
			bsum += (b-'0');
		}
		for(char a : str[0].toCharArray()) {
			res += (a-'0')*bsum;
		}
		
		
		bw.write(String.valueOf(res));
		bw.flush(); 
	}
	
}