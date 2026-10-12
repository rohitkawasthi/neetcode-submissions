class Solution {
    public int evalRPN(String[] tokens) {
        Set<String> opSet = Set.of("+","-","*","/");
        List<Integer> operands = new LinkedList<>();
        int result = 0;
        for(int i=0; i<tokens.length; i++) {
            String str = tokens[i];
            if(!opSet.contains(str)) {
                operands.add(Integer.parseInt(str));
                continue;
            }
            if(operands.size()<2) {
                throw new RuntimeException("expression is invalid");
            }
            result = applyOperation(str, operands);
            operands.add(result);
        }
        return operands.removeFirst();
    }

    private int applyOperation(String operation, List<Integer> operands) {
        int result = operands.removeLast();
        while(!operands.isEmpty()) {
            switch(operation) {
                case "+":
                    result += operands.removeLast();
                    break;
                case "-":
                    result = operands.removeLast() - result;
                    break;
                case "*":
                    result *= operands.removeLast();
                    break;
                case "/":
                    result = operands.removeLast() / result;
                    break;
                default:
                    throw new RuntimeException("operation is not supported");
            }
            break;
        }
        return result;
    }
}
