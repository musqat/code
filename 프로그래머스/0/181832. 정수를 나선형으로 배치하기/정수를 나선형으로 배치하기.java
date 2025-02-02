class Solution {
    public int[][] solution(int n) {
        int[][] answer = new int[n][n];

        int[] dx = {0, 1, 0, -1};
        int[] dy = {1, 0, -1, 0};

        int curDirect = 0;
        int row = 0, col = 0;

        for (int i = 1; i <= n * n; i++) {
            answer[row][col] = i;
            int nextRow = row + dx[curDirect];
            int nextCol = col + dy[curDirect];

            if (nextRow < 0 || nextRow >= n || nextCol < 0 || nextCol >= n || answer[nextRow][nextCol] != 0) {
                curDirect = (curDirect + 1) % 4;
                nextRow = row + dx[curDirect];
                nextCol = col + dy[curDirect];

            }

            row = nextRow;
            col = nextCol;

        }
        return answer;
    }
}