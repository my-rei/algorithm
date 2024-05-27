import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = null;
		
		int N = 20, pg = 0; double sum =  0;
		Map<String, Double> set = Map.of("A+", 4.5, "A0", 4.0, "B+", 3.5, "B0", 3.0, 
				"C+", 2.5, "C0", 2.0, "D+", 1.5, "D0", 1.0,
				"F", 0.0);
		
		while(N-->0) {
			st = new StringTokenizer(br.readLine());
			st.nextToken();
			int d= (int) Double.parseDouble(st.nextToken());
			String s = st.nextToken();
			if(set.containsKey(s)) {
				sum += set.get(s) * d;
				pg += d;
			}
		}
		
		
		bw.write(String.format("%.6f", sum/pg));
		bw.flush(); 
	}
	
}