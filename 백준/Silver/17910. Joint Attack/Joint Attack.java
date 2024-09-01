import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int N = Integer.parseInt(br.readLine());
	
		String[] str = br.readLine().split(" ");
		long top = Integer.parseInt(str[N-1]), bottom = 1;
		for(int i = N-1;i>0;i--) {
			long temp = bottom;
			bottom = top;
			top = temp;
			top += Integer.parseInt(str[i-1]) * bottom;
		}
		
		bw.write(top+"/"+bottom);	
		bw.flush();
	}
}