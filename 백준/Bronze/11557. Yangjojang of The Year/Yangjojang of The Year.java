import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        
        int T = Integer.parseInt(br.readLine());
        while(T-->0) {
        	int N = Integer.parseInt(br.readLine());
        	int max = 0; String sc = "";
        	while(N-->0) {
        		String[] str = br.readLine().split(" ");
        		if(Integer.parseInt(str[1]) > max) {
        			max = Integer.parseInt(str[1]);
        			sc = str[0];
        		}
        	}
        	sb.append(sc).append("\n");
        }
        
        
        bw.write(sb.toString());
        bw.flush();
    }
}