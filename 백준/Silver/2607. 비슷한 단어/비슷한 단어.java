import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int N = Integer.parseInt(br.readLine());
		int[] original = new int[26];
		for(char c : br.readLine().toCharArray()) 
			original[c-'A']++;
		
		int similar = 0;
		for(int i = 1;i<N;i++) {
			int[] copy = Arrays.copyOf(original, 26);
			String st = br.readLine();
			for(char c : st.toCharArray()) 
				copy[c-'A']--;
			
			int nonZeroCnt = 0, nonZeroSum = 0, nonZeroVal = 0;
			for(int j = 0;j<26;j++) {
				if(copy[j] != 0) {
					nonZeroCnt++;
					nonZeroSum += copy[j];
					nonZeroVal = Math.max(nonZeroVal, Math.abs(copy[j]));
				}
			}
			if(nonZeroCnt == 0 || nonZeroCnt == 1 && Math.abs(nonZeroVal) == 1 || nonZeroCnt == 2 && nonZeroSum == 0 && Math.abs(nonZeroVal) == 1) {
				similar++;
			}
		}
		
		
		bw.write(String.valueOf(similar));
		bw.flush(); 
	}
	
}