class Solution {
    public String[] solution(String[] quiz) {
        String[] answer = new String[quiz.length];

        for (int i = 0; i < quiz.length; i++) {
            String[] split = quiz[i].split(" ");
            int a = Integer.parseInt(split[0]);
            int b = Integer.parseInt(split[2]);
            int c = Integer.parseInt(split[4]);
            if (split[1].equals("+")) {
                answer[i] = a + b == c ? "O" : "X";
            }else if (split[1].equals("-")) {
                answer[i] = a - b == c ? "O" : "X";
            }
        }



        return answer;

    }
}
