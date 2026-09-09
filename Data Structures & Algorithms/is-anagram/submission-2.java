class Solution {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        Map<Character, Integer> sCharCountMap = new HashMap<>();
        Map<Character, Integer> tCharCountMap = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            int sCharCount = sCharCountMap.getOrDefault(s.charAt(i), 0);
            sCharCountMap.put(s.charAt(i), sCharCount + 1);
            int tCharCount = tCharCountMap.getOrDefault(t.charAt(i), 0);
            tCharCountMap.put(t.charAt(i), tCharCount + 1);
        }
        for (Map.Entry<Character, Integer> sCharCountEntry : sCharCountMap.entrySet()) {
            if (tCharCountMap.getOrDefault(sCharCountEntry.getKey(), 0).intValue() != sCharCountEntry.getValue().intValue()) {
                return false;
            }
        }
        return true;
    }
}
