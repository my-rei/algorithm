import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		String str = "";
		int prev = Integer.parseInt(st.nextToken()), tmp;
		for(int i = 0;i<7;i++) {
			if(Math.abs((tmp=Integer.parseInt(st.nextToken()))-prev)==1)
				prev = tmp;
			else {
				str = "mixed";
				break;
			}
		}
		bw.write(str.length()==0? prev==8? "ascending":"descending":str);
		bw.flush();
	}
}