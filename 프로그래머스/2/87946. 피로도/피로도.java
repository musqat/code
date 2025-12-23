class Solution {
    int max = 0;

    public int solution(int k, int[][] dungeons) {
        boolean[] visited = new boolean[dungeons.length];
        
        dfs(k, 0, dungeons, visited);

        return max;
    }
    
    void dfs(int k, int count, int[][] dungeons, boolean[] visited){
        max = Math.max(max, count);

        for (int i = 0; i < dungeons.length; i++) {
            if (!visited[i] && k >= dungeons[i][0]) {
                visited[i] = true;
                dfs(k - dungeons[i][1], count + 1, dungeons, visited);
                visited[i] = false;
            }
        }

    }
}