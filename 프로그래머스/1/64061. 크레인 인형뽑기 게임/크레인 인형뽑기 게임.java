import java.util.Stack;

class Solution {
    public int solution(int[][] board, int[] moves) {
        int result = 0;
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < moves.length; i++) {
            int doll = pick(board, moves[i] -1);
            if (doll == 0) continue;
            if (!stack.isEmpty() && stack.peek() == doll){
                stack.pop();
                result += 2;
            }else {
                stack.push(doll);
            }
        }


        return result;
    }

    private int pick(int[][] board, int col){
        for (int row = 0; row < board.length; row++) {
            if (board[row][col] != 0){
                int doll = board[row][col];
                board[row][col] = 0;
                return doll;
            }

        }
        return 0;
    }



}