class Solution {
    public int[] solution(String[] keyinput, int[] board) {
        int[] answer = {0,0};
        int sizeX = (board[0] - 1) / 2 ;
        int sizeY = (board[1] - 1) / 2 ;

        for (String key : keyinput) {
            if (key.equals("left") && answer[0] > -sizeX) {
                answer[0]--;
            } else if (key.equals("right") && answer[0] < sizeX) {
                answer[0]++;
            } else if (key.equals("up") && answer[1] < sizeY) {
                answer[1]++;
            } else if (key.equals("down") && answer[1] > -sizeY) {
                answer[1]--;
            }
        }
        return answer;
    }
}