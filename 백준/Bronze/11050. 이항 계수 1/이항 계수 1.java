import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] nk = br.readLine().split(" ");
		int N = Integer.parseInt(nk[0]);
		int K = Integer.parseInt(nk[1]);

		System.out.println(bc(N, K));
	}

	static int bc(int n, int k) {
		if (k == 0 || n == k)
			return 1;
		return bc(n - 1, k - 1) + bc(n - 1, k);
	}
}
