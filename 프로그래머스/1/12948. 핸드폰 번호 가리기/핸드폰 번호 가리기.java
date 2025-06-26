class Solution {
    public String solution(String phone_number) {
        int l = phone_number.length();
        return "********************".substring(0, l-4)+phone_number.substring(l-4, l);
    }
}