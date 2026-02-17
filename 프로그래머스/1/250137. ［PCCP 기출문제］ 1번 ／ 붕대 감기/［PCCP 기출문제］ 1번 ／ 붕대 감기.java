class Solution {
    public int solution(int[] bandage, int health, int[][] attacks) {
        int loading = bandage[0];
        int TTH = bandage[1];
        int fullLoading = bandage[2];
        int attackTime = 0;
        int maxHealth = health;
        int gap = 0;

        for (int i = 0; i < attacks.length; i++) {
            int aTime = attacks[i][0];
            int aDmg = attacks[i][1];

            if (attackTime != 0){
                gap = aTime - attackTime - 1;

                if (gap >= loading){
                    health += (gap / loading) * fullLoading + gap * TTH;
                    health = Math.min(health, maxHealth);

                }else   {
                    health += gap * TTH;
                    health = Math.min(health, maxHealth);
                }
            }


            attackTime = aTime;
            health -= aDmg;

            if (health <= 0){
                return -1;
            }

        }

        return health;
    }
}