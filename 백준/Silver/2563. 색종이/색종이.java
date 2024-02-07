import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		boolean[][] paper = new boolean[100][100];
		int c = 0;
		for (int k = 0; k < N; k++) {
			String[] color = br.readLine().split(" ");

			for (int i = 0; i < 10; i++) {
				for (int j = 0; j < 10; j++) {
					if(!paper[Integer.parseInt(color[0])+i][Integer.parseInt(color[1])+j]) {
						c++;
						paper[Integer.parseInt(color[0])+i][Integer.parseInt(color[1])+j] = true;
					}
				}
			}
		}
		System.out.println(c);
	}
}