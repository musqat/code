import java.util.HashMap;

class Solution {
    public String solution(String polynomial) {
        HashMap<String, Integer> terms = new HashMap<>();
        String[] parts = polynomial.split(" \\+ "); 
        for (String part : parts) {
            if (part.contains("x")) {
                String coefficient = part.replace("x", "").trim();
                int num = coefficient.isEmpty() ? 1 : Integer.parseInt(coefficient); 
                terms.put("x", terms.getOrDefault("x", 0) + num);
            } else {
                int num = Integer.parseInt(part.trim());
                terms.put("const", terms.getOrDefault("const", 0) + num);
            }
        }

        StringBuilder result = new StringBuilder();
        if (terms.containsKey("x")) {
            int xCoefficient = terms.get("x");
            if (xCoefficient > 1) {
                result.append(xCoefficient).append("x");
            } else {
                result.append("x");
            }
        }
        if (terms.containsKey("const")) {
            int constTerm = terms.get("const");
            if (result.length() > 0) {
                result.append(" + ");
            }
            result.append(constTerm);
        }

        return result.toString();
    }
}