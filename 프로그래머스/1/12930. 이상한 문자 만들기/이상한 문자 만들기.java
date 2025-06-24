class Solution {
    public String solution(String s) {
        StringBuilder sb = new StringBuilder();
        boolean upper = true;
        
        for (char c : s.toCharArray()) {
            if (c == ' '){
                sb.append(' ');
                upper = true;
            }else {
                sb.append(upper ? Character.toUpperCase(c) : Character.toLowerCase(c));
                upper = !upper;
            }
        }

        return sb.toString();
    }
}