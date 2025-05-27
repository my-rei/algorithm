import java.io.*;
import java.util.*;

class Solution {
    public String solution(String video_len, String pos, String op_start, String op_end, String[] commands) {
        // 1. 초로 변환
        int video = stringToSecond(video_len);
        int position = stringToSecond(pos);
        int opS = stringToSecond(op_start);
        int opE = stringToSecond(op_end);
        // position 보정
        if (opS <= position && position < opE) {
            position = opE;
        }
        
        // 2. 이동
        for (String c:commands) {
            if (c.equals("prev")) {
                position = Math.max(position-10, 0);    
            } else {
                position = Math.min(position+10, video);
            }
            
            if (opS <= position && position < opE) {
                position = opE;
            }
        }
        
        return secondToString(position);
    }
    
    public int stringToSecond(String s) {
        return Integer.parseInt(s.substring(0,2)) * 60 + Integer.parseInt(s.substring(3));
    }
    
    public String secondToString(int i) {
        return String.format("%02d:%02d", i/60, i%60);
    }
}