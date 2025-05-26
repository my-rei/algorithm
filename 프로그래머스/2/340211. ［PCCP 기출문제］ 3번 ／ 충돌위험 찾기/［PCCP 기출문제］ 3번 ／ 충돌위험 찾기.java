import java.io.*;
import java.util.*;

class Solution {
    static int[][] vst;
    static int[][] pts;
    static Queue<Robot> rbs;  
    
    class Robot {
        int r, c;
        Queue<Integer> targets;
        
        public Robot(int r, int c) {
            this.r = r;
            this.c = c;
            this.targets = new ArrayDeque<>();
        }
        
        public Robot(int r, int c, int[] ts) {
            this.r = r;
            this.c = c;
            this.targets = new ArrayDeque<>();
            for(int i = 0;i<ts.length;i++){
                this.targets.add(ts[i]);
            }
        }
    }
    
    
    public int solution(int[][] points, int[][] routes) {
        // 1) 데이터 입력 
        // r, c 범위 찾고 vts, pts 배열 생성 
        int maxR = 0, maxC = 0;
        for(int i = 0;i<points.length;i++)
            for(int j = 0;j<points[i].length;j++){
                maxR = Math.max(points[i][j], maxR);
                maxC = Math.max(points[i][j], maxC);
            }
        vst = new int[maxR+1][maxC+1];
        pts = new int[points.length+1][];
        pts[0] = new int[points[0].length]; // 버퍼
        for(int i = 0;i<points.length;i++){
            pts[i+1] = points[i]; 
        }
        // 로봇 큐 생성 및 데이터 입력
        rbs = new ArrayDeque<>();
        for (int i = 0;i<routes.length;i++){
            // 시작 포인트
            Robot r = new Robot(pts[routes[i][0]][0], pts[routes[i][0]][1], routes[i]);
            rbs.add(r);
        }
        // 2) 로봇 이동 및 좌표 검증
        int cur = 1; // 이동한 시간
        int cnt = 0; // 충돌 횟수
        while (!rbs.isEmpty()) {
            int N = rbs.size();
            boolean cFlag = false;
            while(N-- > 0) {
                Robot rb = rbs.poll();
                if (rb == null) break; // 안전장치
                
                // (1) 이동할 포인트 확인
                int tr = pts[rb.targets.peek()][0];
                int tc = pts[rb.targets.peek()][1];
                
                // (2) r 좌표 비교 후 c 좌표 비교
                if (rb.r != tr) {
                    rb.r += rb.r > tr? -1 : 1;
                } else if (rb.c != tc) {
                    rb.c += rb.c > tc? -1 : 1;
                } 
                
                // (3) 배열에 현재 위치 기록 및 검증 
                // 같은 위치라면 카운트 X 
                if(vst[rb.r][rb.c] == cur) {
                    cnt++;
                    vst[rb.r][rb.c] = -1 * cur; // 정산 완료는 음수 
                } else if (vst[rb.r][rb.c] == -1 * cur){
                    
                } else {
                    vst[rb.r][rb.c] = cur;
                }
                
                // (4) targer에 도착했는지 확인
                if (rb.r == tr && rb.c == tc) {
                    rb.targets.poll();
                    if (!rb.targets.isEmpty()) {
                        rbs.add(rb);
                    }
                } else {
                    rbs.add(rb);
                }
                
                
            }
            
            cur++;
            // cnt += cFlag? 1:0;
        }
        
        return cnt;
    }
}