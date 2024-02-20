import java.io.*;
import java.util.*;

public class Main {
	static Queue<Integer> queue;
	static List<Integer>[] isTall;
	static boolean[] selected;
	static int[] inCnt;
	static int N, M;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		isTall = new List[N];
		inCnt = new int[N];
		selected = new boolean[N];
		for(int i = 0;i<N;i++) {
			if (isTall[i] == null)
				isTall[i] = new ArrayList<>();
		}
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken())-1, b = Integer.parseInt(st.nextToken())-1;
			isTall[a].add(b);
			inCnt[b]++;
		}

		queue = new ArrayDeque<>();
		getZero();
		while (!queue.isEmpty()) {
			int cr = queue.peek();
//			System.out.println(cr);
			for (int j = 0; j < isTall[cr].size(); j++) {
				if(inCnt[isTall[cr].get(j)]>0) {
//					System.out.println(cr+"=>"+isTall[cr].get(j));
					inCnt[isTall[cr].get(j)]--;
					if(inCnt[isTall[cr].get(j)] == 0) queue.add(isTall[cr].get(j));
				}
			}
			sb.append((queue.poll() + 1) + " ");
		}

		System.out.println(sb);
	}

	static void getZero() {
		for (int i = 0; i < N; i++) {
			if (inCnt[i] == 0) {
				queue.add(i);
			}
		}
	}

}
