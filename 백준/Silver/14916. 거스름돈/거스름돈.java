import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int money = Integer.parseInt(br.readLine());
		int res = -1;
		if(money != 1 && money != 3) 
			res = money%5%2==0? money/5+(money%5/2):(money/5-1)+(money%5+5)/2;
		bw.write(String.valueOf(res));
		bw.flush();
	}

}