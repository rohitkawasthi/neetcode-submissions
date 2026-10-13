class Solution {
    /*
    [30,38,30,36,35,40,28]
    [0, 1,  2, 3, 4, 5, 6]
    [1, 5,  3, 5, 5, 5, 6]
    [38,40,36,40,40,40,28]
    [1, 4,  1, 2, 1, 0, 0]

    [30,40,30,36,35,37,36,39]
    [0, 1,  2, 3, 4, 5, 6, 7]
    [1, 1,  3, 5, 5, 5, 6, 7]
    [38,40,36,37,37,37,36, 7]
    [1, 4,  1, 2, 1, 0, 0]
    */
    public int[] dailyTemperatures(int[] temperatures) {
        int[] result = new int[temperatures.length];
        Stack<Integer> decreasingStack = new Stack<>();
        result[temperatures.length-1] = 0;
        for(int i=0; i<temperatures.length-1; i++) {
            if(temperatures[i+1] > temperatures[i]) {
                result[i] = i+1;
                //check olders as well
                while(!decreasingStack.isEmpty() && temperatures[i+1] > temperatures[decreasingStack.peek()]) {
                    result[decreasingStack.pop()] = i+1;
                }
            } else {
                result[i] = i;
                decreasingStack.push(i);
            }
        }
        for(int i=0; i<temperatures.length-1; i++) {
            result[i] = result[i] - i;
        }
        return result;
    }
}
