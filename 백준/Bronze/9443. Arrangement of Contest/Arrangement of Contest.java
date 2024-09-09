import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int n = Integer.parseInt(br.readLine());
        boolean[] seen = new boolean[26];  // A-Z까지 등장 여부를 기록
        
        // 각 문제 제목의 첫 글자를 확인
        for (int i = 0; i < n; i++) {
            String title = br.readLine();
            char firstChar = title.charAt(0);  // 제목의 첫 글자
            seen[firstChar - 'A'] = true;  // 해당 알파벳 등장 기록
        }
        
        // A부터 Z까지 순차적으로 가능한 만큼 세기
        int maxStreak = 0;
        for (int i = 0; i < 26; i++) {
            if (seen[i]) {
                maxStreak++;
            } else {
                break;  // 연속되지 않는 부분이 나오면 중단
            }
        }
        
        System.out.println(maxStreak);
    }
}