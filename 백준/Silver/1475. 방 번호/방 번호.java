import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String s1 = br.readLine();
		int[] nums = new int[10];
		int setCnt = 0;
		int target;
		for(int i =0;i<s1.length();i++) {
			target = s1.charAt(i)-'0';
			if (target != 6 && target != 9) {
				nums[target]++;
				setCnt = Math.max(setCnt, nums[target]);
			} else {
				if (nums[6] > nums[9]) {
					nums[9]++;
					setCnt = Math.max(setCnt, nums[9]);
				} else {
					nums[6]++;
					setCnt = Math.max(setCnt, nums[6]);
				}
			}
		}
		System.out.println(setCnt);

	}
}