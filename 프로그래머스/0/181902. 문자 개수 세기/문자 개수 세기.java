class Solution {
    public int[] solution(String my_string) {
        int[] answer = new int[52];

        for (int i = 0; i < my_string.length(); i++) {
            int word = my_string.charAt(i);
            if (word > 96) {
                word = word- 97 + 26;
                answer[word]++;
            }else{
                word = word - 65;
                answer[word]++;
            }

        }

        return answer;
    }
}