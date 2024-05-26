import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int N = Integer.parseInt(br.readLine());
		int yes = 0, no = 0;
		while(N-- > 0) {
			if((Integer.parseInt(br.readLine()))==0) 
				no++;
			else 
				yes++;
		}
		bw.write(yes>no? "Junhee is cute!":"Junhee is not cute!");
		bw.flush(); 
	}
	
}