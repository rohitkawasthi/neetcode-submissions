class Solution {
    public boolean isPalindrome(String s) {
        for(int i=0,j=s.length()-1; i<j; ) {
            char ch1 = s.charAt(i);
            if(!isAlphaNumeric(ch1)){
                i++;
                continue;
            }
            char ch2 = s.charAt(j);
            if(!isAlphaNumeric(ch2)){
                j--;
                continue;
            }
            if(!equalsIgnoreCase(ch1, ch2)) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
    
    private boolean isAlphaNumeric(char ch) {
        return (ch >= 'A' && ch <= 'Z') || (ch >= 'a' && ch <= 'z') || (ch >= '0' && ch <= '9');
    }

    private boolean equalsIgnoreCase(char ch1, char ch2) {
        return lowerCase(ch1) == lowerCase(ch2);
    }

    private char lowerCase(char ch) {
        if(ch >= 'A' && ch <= 'Z') {
            return (char)(ch - 'A' + 'a');
        }
        return ch;
    }
}
