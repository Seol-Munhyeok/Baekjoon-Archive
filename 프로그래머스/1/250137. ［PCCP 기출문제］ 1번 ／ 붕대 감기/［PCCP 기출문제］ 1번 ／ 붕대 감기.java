class Solution {
    
    public int solution(int[] bandage, int health, int[][] attacks) {
        int t = bandage[0];  // 붕대 감기 시전 시간
        int x = bandage[1];  // 초당 회복량
        int y = bandage[2];  // 추가 회복량
        int curHealth = health;
        int maxHealth = health;
        
        int mIdx = 0;
        int curTime = 0;
        int successTime = 0;
        
        while (mIdx < attacks.length) {
            curTime++;
            if (curTime == attacks[mIdx][0]) {
                curHealth = curHealth - attacks[mIdx][1];
                if (curHealth <= 0) return -1;
                successTime = 0;
                mIdx++;
            } else {
                successTime++;
                curHealth = Math.min(curHealth + x, maxHealth);
                if (successTime >= t) {
                    curHealth = Math.min(curHealth + y, maxHealth);
                    successTime = 0;
                }
            }
        }
        
        return curHealth;
    }
}