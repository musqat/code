class Solution {
    public String solution(String s) {
        StringBuilder answer = new StringBuilder();
        boolean isStart = true;

        for (char c : s.toCharArray()) {
            if (isStart && Character.isLetter(c)) {
                answer.append(Character.toUpperCase(c));
                isStart = false;
            } else {
                answer.append(Character.toLowerCase(c));
                isStart = (c == ' ');
            }
            if (c == ' ') isStart = true;
        }
        return answer.toString();
    }

}