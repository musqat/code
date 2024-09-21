class Solution {
    public int solution(String[] spell, String[] dic) {
        for (String word : dic) {
            boolean isValid = true;
            for (String s : spell) {
                if (!word.contains(s)) {
                    isValid = false; 
                    break;
                }
            }
            if (isValid && word.length() == spell.length) {
                return 1;
            }
        }
        return 2;

    }
}