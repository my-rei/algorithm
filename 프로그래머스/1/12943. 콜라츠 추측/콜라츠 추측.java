class Solution {
    public int solution(int num) {
        int answer = 0;
        int number = num, count = 0;
        while(count < 500 && number > 1) {
            if(number % 2 == 0) {
                number /= 2;
            } else {
                number = number*3 + 1;
            }
            count++;
        }
        return number != 1? -1:count;
    }
}