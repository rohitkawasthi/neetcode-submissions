class MyQueue {
    /*
    queue - [2,6,8 9]
    stack1 - []
    stack2 - [8,6]
    push 2 in stack1 [2]
    peek - pop all elements from stack1 [] and push in stack2 [2]
    push - 6 in stack1 [6]
    peek - pop all elements from stack1 [6] and push in stack2 [2] if stack2 is empty otherwise top from stack2 [2]
    pop - pop all elements from stack1 [6] and push in stack2 [2] if stack2 is empty otherwise pop from stack2 [2]
    push - 8 in stack1 [6,8]
    peek - pop all elements from stack1 [] and push in stack2 [8,6]  if stack2 is empty  otherwise top from stack2
    push - 9 in stack1 [9]
    pop - pop all elements from stack1 [9] and push in stack2 [8,6]  if stack2 is empty  otherwise top from stack2
    pop - pop all elements from stack1 [9] and push in stack2 [8]  if stack2 is empty  otherwise top from stack2
    pop - pop all elements from stack1 [] and push in stack2 [6]  if stack2 is empty  otherwise top from stack2


    */
    Stack stack1;
    Stack stack2;

    public MyQueue() {
        stack1 = new Stack();
        stack2 = new Stack();
    }
    
    public void push(int x) {
        stack1.push(x);
    }
    
    public int pop() {
        if(!empty()) {
            return (int)stack2.pop();
        }
        return -1;
    }
    
    public int peek() {
        if(stack2.isEmpty()) {
            while(!stack1.isEmpty()) {
                stack2.push(stack1.pop());
            }
        }
        if(stack2.isEmpty()) {
            return -1;
        }
        return (int)stack2.peek();        
    }
    
    public boolean empty() {
        peek();
        return stack2.isEmpty();
    }
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */