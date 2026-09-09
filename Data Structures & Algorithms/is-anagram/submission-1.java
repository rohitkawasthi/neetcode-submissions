class Solution {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        int[] charCountDiffs = new int[26]; 
        for (int i = 0; i < s.length(); i++) {
            charCountDiffs[s.charAt(i) - 'a']++;
            charCountDiffs[t.charAt(i) - 'a']--;

        }
        for (int diff : charCountDiffs) {
            if (diff != 0) {
                return false;
            }
        }
        return true;
    }
}
