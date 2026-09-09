class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> anagramsList = new LinkedList<>();
        List<Map<Character,Integer>> charCountMapList = new ArrayList<>();
        for(String str : strs) {
            charCountMapList.add(getCharCountMap(str));
        }
        Set<Integer> done = new HashSet<>();
        for(int i=0; i<strs.length; i++) {
            if(done.contains(i)) {
                continue;
            }
            List<String> subList = new LinkedList<>();
            anagramsList.add(subList);
            subList.add(strs[i]);
            for(int j=i+1; j<strs.length; j++) {
                boolean isSame = compare(charCountMapList.get(i),charCountMapList.get(j));
                if(isSame) {
                    done.add(j);
                    subList.add(strs[j]);
                }
            }
        }
        return anagramsList;
    }

    private boolean compare(Map<Character,Integer> map1, Map<Character,Integer> map2) {
        if(map1.size() != map2.size()) {
            return false;
        }
        for(Character ch : map1.keySet()) {
            if(map1.getOrDefault(ch,0).intValue() != map2.getOrDefault(ch,0).intValue()) {
                return false;
            }
        }
        return true;
    }

    private Map<Character,Integer> getCharCountMap(String str) {
        Map<Character,Integer> charCountMap = new HashMap<>();
        for(int i=0; i<str.length(); i++) {
            int count = charCountMap.getOrDefault(str.charAt(i),0);
            charCountMap.put(str.charAt(i), count+1);
        }
        return charCountMap;
    }
}
