import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine());

		for(int i = 1;i<=N;i++) {
			int M = Integer.parseInt(br.readLine());
			String str = br.readLine();
			boolean f2 = false, f3 = false, f4 = false, f5 = false;
			for(int j = 0;j<M;j++) {
				char c = str.charAt(j);
				if(c >= 'A' && c <= 'Z')
					f2 = true;
				else if(c>='a' && c<='z')
					f3 = true;
				else if(c >= '0' && c<='9')
					f4 = true;
				else if(c=='#' || c=='@' || c=='*' || c=='&')
					f5 = true;
			}
			
			sb.append("Case #"+i+": ");
			if(!f2) str += 'A';
			if(!f3) str += 'a';
			if(!f4) str += '1';
			if(!f5) str += '#';
			if(str.length() < 7) 
				for(int k=7-str.length();k>0;k--)
					str += '1';
			sb.append(str+"\n");
		}
			
		
		bw.write(sb.toString());
		bw.flush();
		
	}
}