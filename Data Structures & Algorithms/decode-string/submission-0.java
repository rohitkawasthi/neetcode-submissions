class Solution {
    public String decodeString(String s) {
        Stack<Integer> numbers = new Stack<>();
        Stack<String> intermediateDecodedStrings = new Stack<>();
        StringBuilder tempDecodedStr = new StringBuilder();
        Integer number = 0;
        for(int i=0; i<s.length(); i++){
            char ch = s.charAt(i);
            if(ch >= '0' && ch <= '9') {
                number = (number*10) + (ch - '0');
            } else
                if(ch == '[') {
                    numbers.push(number);
                    number = 0;
                    intermediateDecodedStrings.push(tempDecodedStr.toString());
                    tempDecodedStr = new StringBuilder();
                } else
                    if(ch == ']') {
                        int k = numbers.pop();
                        StringBuilder tempSb = new StringBuilder();
                        while(k-->0) {
                            tempSb.append(tempDecodedStr);
                        }
                        tempDecodedStr = new StringBuilder();
                        tempDecodedStr.append(intermediateDecodedStrings.pop());
                        tempDecodedStr.append(tempSb);
                    } else {
                        tempDecodedStr.append(ch);
                    }
        }
        return tempDecodedStr.toString();
    }
}