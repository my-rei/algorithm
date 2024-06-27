import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = null;
        StringBuilder sb = new StringBuilder();
        
        int T = Integer.parseInt(br.readLine());
        while(T-->0) {
        	st = new StringTokenizer(br.readLine());
        	int N = Integer.parseInt(st.nextToken());
        	int S = Integer.parseInt(st.nextToken());
        	int E = Integer.parseInt(st.nextToken());
        	int res = 2;
        	if((S==N && E == 1) || (E==N && S==1)) res = 0;
        	else if((S==1) || (S==N) || (Math.abs(S-E) == 1)) res = 1;
        	sb.append(res+"\n");
        }
        
        bw.write(sb.toString());
        bw.flush();
    }
}