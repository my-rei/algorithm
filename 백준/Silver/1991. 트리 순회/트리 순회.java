import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static StringBuilder sb;
	static int[][] node;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st = null;
		int N = Integer.parseInt(br.readLine());
		sb = new StringBuilder();
		node = new int[N][2];
		
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			int r = st.nextToken().charAt(0)-'A';
			node[r][0] = st.nextToken().charAt(0)-'A';
			node[r][1] = st.nextToken().charAt(0)-'A';
		}
		preorder(0);
		sb.append("\n");
		inorder(0);
		sb.append("\n");
		postorder(0);
		bw.write(sb.toString());
		bw.flush();
	}

	
	public static void preorder(int now) {
		if(now < 0) return;
		sb.append((char) (now+'A'));
		preorder(node[now][0]);
		preorder(node[now][1]);
	}
	public static void inorder(int now) {
		if(now < 0) return;
		inorder(node[now][0]);
		sb.append((char) (now+'A'));
		inorder(node[now][1]);
	}
	public static void postorder(int now) {
		if(now < 0) return;
		postorder(node[now][0]);
		postorder(node[now][1]);
		sb.append((char) (now+'A'));
	}
}