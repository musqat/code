class Solution {
    public String solution(String new_id) {
        StringBuilder sb = new StringBuilder();

        sb.append(new_id.toLowerCase().replaceAll("[^a-z0-9\\-_.]", ""));

        String tmp = sb.toString().replaceAll("\\.{2,}", ".");
        sb = new StringBuilder(tmp);

        if (sb.length() > 0 && sb.charAt(0) == '.') sb.deleteCharAt(0);
        if (sb.length() > 0 && sb.charAt(sb.length() - 1) == '.') sb.deleteCharAt(sb.length() - 1);


        if (sb.length() == 0) sb.append("a");

        if (sb.length() >= 16) {
            sb.delete(15, sb.length());
            if (sb.charAt(sb.length() - 1) == '.') sb.deleteCharAt(sb.length() - 1);
        }


        while (sb.length() <= 2) {
            sb.append(sb.charAt(sb.length() - 1));
        }


        return sb.toString();
    }
}