import java.util.*;

class Solution {
    public double solution(int[] arr) {
        double s = 0;
        for(int i:arr)
            s += i;
        return s/arr.length;
    }
}