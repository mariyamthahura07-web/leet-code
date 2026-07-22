class Solution {
    public String mergeAlternately(String word1, String word2) {
        StringBuilder sum = new StringBuilder();
        int min = Math.min(word1.length(), word2.length());
        for (int i = 0; i < min; i++) {
            sum.append(word1.charAt(i));
            sum.append(word2.charAt(i));
        }
        sum.append(word1.substring(min));
        sum.append(word2.substring(min));

        return sum.toString();
    }
}
