class Solution {
    public String solution(String s, String skip, int index) {
        StringBuilder answer = new StringBuilder();
        
        for (char ch : s.toCharArray()) {
            char cur = ch;
            int move = 0;
            
            while (move < index){
                cur++;
                
                if (cur > 'z'){
                    cur = 'a';
                }
                
                if (skip.indexOf(cur) == -1){
                    move++;
                }
            }
            
            answer.append(cur);
        }
        
        return answer.toString();
    }
}