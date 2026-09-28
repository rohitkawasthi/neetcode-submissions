class Solution {
    public boolean isValid(String s) {
        Stack stack = new Stack();
        Map<Character,Character> bracesMapping = Map.of('[',']','{','}','(',')');
        for(int i=0; i<s.length(); i++) {
            char ch = s.charAt(i);
            if(bracesMapping.containsKey(ch)) {
                stack.push(ch);
            } else {
                if(stack.isEmpty()) {
                    return false;
                }
                Character openingBrace = (Character)stack.pop();
                if( bracesMapping.getOrDefault(openingBrace,Character.valueOf((char)(ch+1))) != ch) {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }
}
