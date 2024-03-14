class Solution {
    public String solution(String X, String Y) {
       StringBuilder sb = new StringBuilder();
		int[] numX = new int[10];
		int[] numY = new int[10];
		
		for(char x:X.toCharArray()) {
			int n = x-'0';
			numX[n]++;
		}
		
		for(char y:Y.toCharArray()) {
			int n = y-'0';
			numY[n]++;
		}
		
		int com = -1;
		for(int i = 9;i>=0;i--) {
			if(numX[i]>0&&numY[i]>0) {
				if(i==0 && sb.length() == 0) {sb.append(i); continue;}
				com = Math.min(numX[i], numY[i]);
				for(int k=0;k<com;k++) {
					sb.append(i);
				}
			}
		}

        
        return sb.length()>0? sb.toString():"-1";
    }
}