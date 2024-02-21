import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();

		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		int[] nums = new int[N];
		for (int i = 0; i < N; i++) {
			nums[i] = Integer.parseInt(st.nextToken());
		}

		int pivot = -1;
		// pivot 찾기(nums[p] > nums[p+1])
		for (int i = N - 1; i > 0; i--) {
			if (nums[i - 1] > nums[i]) {
				pivot = i - 1;
				break;
			}
		}
		if (pivot == -1) {
			System.out.println(-1);
			return;
		}
		int swap = pivot + 1;
		// pivot 바로 다음 작은 수(=작은 수 중 최댓값) 찾기
		for (int i = pivot + 1; i < N; i++) {
			swap = nums[i] < nums[pivot]? nums[swap] < nums[i] ? i : swap: swap;
		}

		// 교환
		int tmp = nums[swap];
		nums[swap] = nums[pivot];
		nums[pivot] = tmp;

		// 내림차순 정렬
		int[] tmpL = new int[N - pivot - 1];
		for (int i = N - 1, t = 0; i > pivot; i--, t++) {
			tmpL[t] = nums[i];
		}
		for (int i = pivot + 1, t = 0; i < N; i++, t++) {
			nums[i] = tmpL[t];
		}

		System.out.println(Arrays.toString(nums).replaceAll("[\\[\\],]", ""));
	}
}
