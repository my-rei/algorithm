import java.io.*;
import java.util.Arrays;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		String input= "";
		char[] clist =br.readLine().toCharArray();
		int[] nlist = new int[clist.length];
		for(int i =0;i<nlist.length;i++) {
			nlist[i] = (nlist[i]+(clist[i]-'0'))%10;
		}
		while((input = br.readLine()) != null) {
			clist = input.toCharArray();
			for(int i =0;i<nlist.length;i++) {
				nlist[i] = (nlist[i]+(clist[i]-'0'))%10;
			}
			//System.out.println(Arrays.toString(nlist).replaceAll("[\\[\\], ]", ""));
		}
		
		bw.write(Arrays.toString(nlist).replaceAll("[\\[\\], ]", ""));
		bw.flush(); 
	}
	
}