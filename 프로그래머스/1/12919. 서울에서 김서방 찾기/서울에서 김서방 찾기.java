class Solution {
    public String solution(String[] seoul) {
        int check = 0;
        for(int i = 0;i<seoul.length;i++) {
            if(seoul[i].equals("Kim")) {
                check = i;
                break;
            }
        }
        return "김서방은 "+check+"에 있다";
    }
}