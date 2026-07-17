class string {
    public int myAtoi(String s) {
        s = s.trim();
        if (s.isEmpty()) return 0;

        int i = 0, sign = 1;
        long ans = 0;

        if (s.charAt(i) == '-' || s.charAt(i) == '+')
            sign = s.charAt(i++) == '-' ? -1 : 1;

        while (i < s.length() && Character.isDigit(s.charAt(i))) {
            ans = ans * 10 + s.charAt(i++) - '0';
            if (ans * sign > Integer.MAX_VALUE) return Integer.MAX_VALUE;
            if (ans * sign < Integer.MIN_VALUE) return Integer.MIN_VALUE;
        }

        return (int)(ans * sign);
    }
}
