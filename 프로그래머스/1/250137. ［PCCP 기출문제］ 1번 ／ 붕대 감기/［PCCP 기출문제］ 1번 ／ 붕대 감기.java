class Solution {
    public int solution(int[] bandage, int health, int[][] attacks) {
        // 상수
        int lastTime = attacks[attacks.length-1][0];
        // 변수
        int hp = health, atkP = 0, bdgP = 0;
        boolean deadFlag = false;
        for(int i = 0;i<lastTime;i++) {
            // 공격이 있으면 공격을 받는다
            if(attacks[atkP][0] == i+1) {
                if(hp-attacks[atkP][1] <= 0) {
                    deadFlag = true;
                    break;
                } else {
                    hp -= attacks[atkP][1];
                    bdgP = 0;
                    atkP++;
                }
            } 
            // 공격이 없으면 기술을 사용한다
            else {
                int newHp = hp+bandage[1];
                bdgP++;
                if(bdgP == bandage[0]) {
                    newHp += bandage[2];
                    bdgP = 0;
                } 
                hp = Math.min(newHp, health);
            }
            // System.out.printf("%dT 체력=%d 연속=%d\n", i, hp, bdgP);
        }
        
        
        return deadFlag? -1:hp;
    }
}