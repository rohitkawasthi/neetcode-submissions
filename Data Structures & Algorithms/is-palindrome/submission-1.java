class Solution {
    public boolean isPalindrome(String s) {
        for(int i=0,j=s.length()-1; i<j; ) {
            char ch1 = s.charAt(i);
            if(!Character.isLetterOrDigit(ch1)){
                i++;
                continue;
            }
            char ch2 = s.charAt(j);
            if(!Character.isLetterOrDigit(ch2)){
                j--;
                continue;
            }
            if(Character.toLowerCase(ch1) != Character.toLowerCase(ch2)) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
}
