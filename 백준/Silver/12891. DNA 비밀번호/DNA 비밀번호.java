import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	// 슬라이딩 윈도우 사용
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		int s = Integer.parseInt(st.nextToken());
		int p = Integer.parseInt(st.nextToken());

		char[] chars = br.readLine().toCharArray();

		st = new StringTokenizer(br.readLine(), " ");

		int[] acgt = new int[4];
		for (int i = 0; i < acgt.length; i++)
			acgt[i] = Integer.parseInt(st.nextToken());

		int sIndex = 0;
		int fIndex = p;

		for (int i = sIndex; i < fIndex; i++)
			acgt[chars[i] == 'A' ? 0 : chars[i] == 'C' ? 1 : chars[i] == 'G' ? 2 : 3]--;

		int pwCnt = 0;
		if ((Arrays.stream(acgt).filter(i -> i > 0).count()) == 0)
			pwCnt++;

		for (int j = 0; j < s-p; j++) {
			// 이동
			acgt[chars[sIndex] == 'A' ? 0 : chars[sIndex] == 'C' ? 1 : chars[sIndex] == 'G' ? 2 : 3]++;
			sIndex++;
			fIndex++;
			acgt[chars[fIndex - 1] == 'A' ? 0 : chars[fIndex - 1] == 'C' ? 1 : chars[fIndex - 1] == 'G' ? 2 : 3]--;
			// 검사
			if ((Arrays.stream(acgt).filter(i -> i > 0).count()) == 0)
				pwCnt++;
		}

		System.out.println(pwCnt);
	}
}
