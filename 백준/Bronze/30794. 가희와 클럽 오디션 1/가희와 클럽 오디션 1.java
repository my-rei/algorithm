import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        try {
            // 한 줄에서 n과 a를 입력받음
            String[] input = br.readLine().split(" ");
            int n = Integer.parseInt(input[0]);
            String a = input[1];
            int score = 0;

            if (a.equals("miss")) {
                score = 0;
            } else if (a.equals("bad")) {
                score = n * 200;
            } else if (a.equals("cool")) {
                score = n * 400;
            } else if (a.equals("great")) {
                score = n * 600;
            } else if (a.equals("perfect")) {
                score = n * 1000;
            }

            System.out.println(score);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                br.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}