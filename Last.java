public class Last {
    public int lengthOfLastWord(String s) {
        String[] words = s.trim().split("\\s+");

        if (words.length > 0) {
            return words[words.length - 1].length();
        } else {
            return 0;

        }

    }
}