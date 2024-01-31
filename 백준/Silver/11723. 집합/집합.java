import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Main {
	// 배열 사용
	static boolean[] map = new boolean[20];

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int M = Integer.parseInt(br.readLine());
		while (M-- > 0) {
			String[] order = br.readLine().split(" ");

			switch (order[0]) {
			case "add":
				map[Integer.parseInt(order[1]) - 1] = true;
				break;
			case "remove":
				map[Integer.parseInt(order[1]) - 1] = false;
				break;
			case "check":
				sb.append((map[Integer.parseInt(order[1]) - 1] ? 1 : 0) + "\n");
				break;
			case "toggle":
				map[Integer.parseInt(order[1]) - 1] = !map[Integer.parseInt(order[1]) - 1];
				break;
			case "all":
				for (int i = 0; i < 20; i++)
					map[i] = true;
				break;
			case "empty":
				for (int i = 0; i < 20; i++)
					map[i] = false;
				break;
			}
		}
		System.out.println(sb);
	}
}