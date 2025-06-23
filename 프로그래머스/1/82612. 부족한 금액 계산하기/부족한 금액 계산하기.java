class Solution {
    public long solution(int price, int money, int count) {
        // 등차수열의 합 
        // 첫항: price 
        // 항의 개수 count 
        return Math.max((price+(long)price*count) * count / 2-money, 0);
    }
}