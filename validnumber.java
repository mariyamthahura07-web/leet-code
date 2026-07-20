class validnumber {
    public boolean isNumber(String s) {

        boolean digit = false;
        boolean dot = false;
        boolean e = false;

        for (int i = 0; i < s.length(); i++) {

            char ch = s.charAt(i);

            if (Character.isDigit(ch)) {
                digit = true;
            }

            else if (ch == '.') {
                if (dot || e) return false;
                dot = true;
            }

            else if (ch == 'e' || ch == 'E') {
                if (e || !digit) return false;
                e = true;
                digit = false;
            }

            else if (ch == '+' || ch == '-') {
                if (i > 0 && s.charAt(i - 1) != 'e' && s.charAt(i - 1) != 'E')
                    return false;
            }

            else {
                return false;
            }
        }

        return digit;
    }
}
