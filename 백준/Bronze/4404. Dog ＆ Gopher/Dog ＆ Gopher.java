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
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		double gx = Double.parseDouble(st.nextToken());
		double gy = Double.parseDouble(st.nextToken());
		double dx = Double.parseDouble(st.nextToken());
		double dy = Double.parseDouble(st.nextToken());
		
		String ans = "";
		String str = "";
		while ((str = br.readLine()) != null && !str.equals("")) {
			st = new StringTokenizer(str);
			double hx = Double.parseDouble(st.nextToken());
			double hy = Double.parseDouble(st.nextToken());
			
			double gd = Math.sqrt(Math.pow(gx-hx,2)+Math.pow(gy-hy,2));
			double dd = Math.sqrt(Math.pow(dx-hx,2)+Math.pow(dy-hy,2));
			
			if(gd*2 <= dd) {
				ans = String.format("(%.3f,%.3f)", hx, hy);
				break;
			}
		}

		bw.write(ans.equals("")?"The gopher cannot escape.":"The gopher can escape through the hole at "+ans+".");
		bw.flush();
	}

}