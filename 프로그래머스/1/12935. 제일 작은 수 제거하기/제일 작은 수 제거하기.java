class Solution {
    public int[] solution(int[] arr) {
        if(arr.length == 1) return new int[]{-1};
        int min = Integer.MAX_VALUE;
        for(int a:arr) 
            min = Math.min(a, min);
        int[] answer = new int[arr.length-1];
        for(int i = 0, j = 0;i<arr.length;i++){
            if(arr[i] != min){
                answer[j++] = arr[i];
            }
        }
        return answer;
    }
}