import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int[] P = new int[N];
        for (int i = 0; i < N; i++) {
            P[i] = Integer.parseInt(st.nextToken());
        }

        int maxStreak = 0;
        int currentStreak = 0;
        int freezeCooldown = 0;  // 스트릭 프리즈를 다시 사용할 수 있는 시점
        
        for (int i = 0; i < N; i++) {
            if (P[i] > 0) {
                // 문제를 풀었을 경우 스트릭 증가
                currentStreak++;
            } else {
                if (freezeCooldown == 0) {
                    // 스트릭 프리즈를 사용할 수 있는 경우
                    freezeCooldown = 2;  // 다음 2일간 스트릭 프리즈 사용 불가
                    // 스트릭 프리즈 사용으로 스트릭이 끊기지 않음
                } else {
                    // 스트릭 프리즈를 사용할 수 없는 경우 (이미 사용됨)
                    maxStreak = Math.max(maxStreak, currentStreak);
                    currentStreak = 0;  // 스트릭 초기화
                    freezeCooldown = 0;  // 다음 날부터 스트릭 프리즈 사용 가능
                }
            }

            // 스트릭 프리즈 사용 가능 시점을 줄여나감
            if (freezeCooldown > 0) {
                freezeCooldown--;
            }

            maxStreak = Math.max(maxStreak, currentStreak);
        }

        System.out.println(maxStreak);
    }
}