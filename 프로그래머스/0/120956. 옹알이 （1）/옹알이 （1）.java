class Solution {
    public int solution(String[] babbling) {
        int answer = 0;
        String[] pronunciation = {"aya", "ye", "woo", "ma"};

        for(String word : babbling){
            for (String p : pronunciation){
                word = word.replace(p, " ");
            }
            if (word.trim().isEmpty()){
                answer++;
            }
        }

        return answer;
    }
}