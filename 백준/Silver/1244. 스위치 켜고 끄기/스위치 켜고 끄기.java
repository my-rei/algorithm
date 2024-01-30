
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] students;

		int n = Integer.parseInt(br.readLine());

		String[] swList = br.readLine().split(" ");

		int s = Integer.parseInt(br.readLine());
		for (int i = 0; i < s; i++) {
			students = br.readLine().split(" ");
			// System.out.println(students[0].getClass());

			if (students[0].equals("1")) {
				// 남학생
				// System.out.println("boy");
				int temp = Integer.parseInt(students[1]);

				for (int j = 1; j * temp <= swList.length; j++) {
					swList[j * temp - 1] = swList[j * temp - 1].equals("0") ? "1" : "0";
//					 System.out.println("boy change:: " + (j * temp - 1) + swList[j * temp - 1]);
				}
			} else if (students[0].equals("2")) {
				// 여학생

				// System.out.println("girl");
				int temp = Integer.parseInt(students[1]) - 1;

				for (int j = 0; j < swList.length; j++) {
					if (temp + j >= swList.length || temp - j < 0) {
//						 System.out.println((j) + "break");
						break;
					}
					if (j== 0) {
						swList[temp] = swList[temp].equals("0") ? "1" : "0";
						continue;
					}
					if (swList[temp + j].equals(swList[temp - j])) {
						swList[temp + j] = swList[temp + j].equals("0") ? "1" : "0";
						swList[temp - j] = swList[temp - j].equals("0") ? "1" : "0";
//						 System.out.println("girl change:: " + (temp + j) + swList[temp + j]);
					} else {
						break;
					}

				}
			}
		}
//		System.out.println(swList.length);
		for (int i = 0; i < swList.length; i++) {
			System.out.printf(swList[i] + " ");
//			System.out.printf(swList[i] + " "+" : "+i+" / ");
			if ((i+1) % 20 == 0)
				System.out.println();
		}

	}
}