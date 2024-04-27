import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
	static int A, B, C;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		A = Integer.parseInt(st.nextToken()); B = Integer.parseInt(st.nextToken()); C = Integer.parseInt(st.nextToken());
		bw.write(String.valueOf(cal()));
		bw.flush();
	}
	
	static int cal() {
		if(A==B && B==C) return 10000+A*1000;
		if(A==B) return 1000+A*100;
		if(B==C) return 1000+B*100;
		if(A==C) return 1000+C*100;
		return Math.max(A, Math.max(B, C))*100;
	}
}