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
        int K = 26;
        int N = Integer.parseInt(br.readLine());
        boolean[][] map = new boolean[K][K];
        while(N-->0) {
        	String str = br.readLine();
        	int a = str.charAt(0)-'a', b = str.charAt(5) - 'a';
        	map[a][b] = true;
        }
        
        for(int i = 0;i<K;i++) {
        	for(int j = 0;j<K;j++) {
        		if(!map[j][i]) continue;
        		for(int k = 0;k<K;k++) {
        			map[j][k] = map[j][k] || map[j][i] && map[i][k];
        		}
        	}
        }
        

        
        int M = Integer.parseInt(br.readLine());
        while(M-->0) {
        	String str = br.readLine();
        	int a = str.charAt(0)-'a', b = str.charAt(5) - 'a';
          	sb.append(map[a][b]? "T\n":"F\n");
        }
        bw.write(sb.toString());
        bw.flush();
    }
}