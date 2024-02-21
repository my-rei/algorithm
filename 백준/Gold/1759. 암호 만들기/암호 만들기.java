import java.util.*;
import java.io.*;

public class Main {
	static char[] alphaList;
	static int L;
	static StringBuilder sb;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());

		L = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());

		alphaList = br.readLine().replace(" ", "").toCharArray();

		Arrays.sort(alphaList);
		dfs(0, 0, "", 0, 0);
		System.out.println(sb);
	}

	static void dfs(int cur, int cnt, String str, int con, int vo) {
		if (cnt == L) {
			if (con >= 2 && vo >= 1)
				sb.append(str + "\n");
			return;
		}

		// 모음은 최대 L-1, 자음은 최대 L-2개 가능
        		if (vo == L - 1)
			return;

		for (int i = cur; i < alphaList.length; i++) {
			if (isVowel(alphaList[i]))
				dfs(i + 1, cnt + 1, str + alphaList[i], con, vo + 1);
			else
				dfs(i + 1, cnt + 1, str + alphaList[i], con + 1, vo);
		}
	}

	static boolean isVowel(char c) {
		if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u')
			return true;
		return false;
	}
}
