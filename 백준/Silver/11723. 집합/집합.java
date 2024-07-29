import java.io.*;

public class Main {
	static boolean[] map = new boolean[20];
	static int mapBit = 0;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();

		int M = Integer.parseInt(br.readLine());
		while (M-- > 0) {
			String[] order = br.readLine().split(" ");

			switch (order[0]) {
			case "add":
				mapBit = mapBit | (1 << Integer.parseInt(order[1]));
				break;
			case "remove":
				mapBit = mapBit & ~(1 << Integer.parseInt(order[1]));
				break;
			case "check":
				int res = (((1 << Integer.parseInt(order[1]) & mapBit) >> Integer.parseInt(order[1])) & 1);
				sb.append(Integer.toBinaryString(res) + "\n");
				break;
			case "toggle":
				mapBit = mapBit ^ (1 << Integer.parseInt(order[1]));
				break;
			case "all":
				mapBit = mapBit | ~0;
				break;
			case "empty":
				mapBit = 0;
				break;
			}
		}
        bw.write(sb.toString());
        bw.flush();
	}
}