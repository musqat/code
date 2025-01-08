public class Solution {
    public int solution(int[][] dots) {
        if (isParallel(dots[0], dots[1], dots[2], dots[3])) return 1;
        if (isParallel(dots[0], dots[2], dots[1], dots[3])) return 1;
        if (isParallel(dots[0], dots[3], dots[1], dots[2])) return 1;
        return 0;
    }

    private boolean isParallel(int[] dot1, int[] dot2, int[] dot3, int[] dot4) {
        int dx1 = dot2[0] - dot1[0];  
        int dy1 = dot2[1] - dot1[1];  
        int dx2 = dot4[0] - dot3[0];  
        int dy2 = dot4[1] - dot3[1];  

        return dx1 * dy2 == dy1 * dx2;
    }
}
