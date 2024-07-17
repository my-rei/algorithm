import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int money = Integer.parseInt(br.readLine());
		int res = -1;
		if(money != 1 && money != 3) {
			res = money%5%2==0? money/5+(money%5/2):(money/5-1)+(money%5+5)/2;
		}
		bw.write(String.valueOf(res));
		bw.flush();
	}

}