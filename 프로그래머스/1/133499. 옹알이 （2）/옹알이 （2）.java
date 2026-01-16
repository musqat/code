class Solution {
    public int solution(String[] babbling) {
        int answer = 0;
        for(String word : babbling){
            word = word.replace("aya", "1");
            word = word.replace("ye", "2");
            word = word.replace("woo", "3");
            word = word.replace("ma", "4");

            boolean isContinue = false;

            for (int i = 0; i < word.length()-1; i++) {
                if (word.charAt(i) == word.charAt(i+1)){
                    isContinue = true;
                    break;
                }
                
            }
            if (!isContinue && word.matches("[1-4]+")){
                answer++;
            }
        }

        return answer;
    }
}