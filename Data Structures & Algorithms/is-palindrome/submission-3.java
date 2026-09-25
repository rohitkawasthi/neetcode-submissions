class Solution {
    public boolean isPalindrome(String s) {
        if(s.length()==0 || s.length()==1) {
            return true;
        }
        char ch1 = s.charAt(0);
        if(!Character.isLetterOrDigit(ch1)) {
            return isPalindrome(s.substring(1));
        }
        char ch2 = s.charAt(s.length()-1);
        if(!Character.isLetterOrDigit(ch2)) {
            return isPalindrome(s.substring(0,s.length()-1));
        }
        if(Character.toLowerCase(ch1) != Character.toLowerCase(ch2)) {
            return false;
        }
        return isPalindrome(s.substring(1,s.length()-1));
    }
}
