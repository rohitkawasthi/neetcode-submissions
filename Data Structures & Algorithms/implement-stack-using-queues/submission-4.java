class MyStack {

    Queue queue;

    public MyStack() {
        queue = new LinkedList<Object>();
    }
    
    public void push(int x) {
        Queue newQueue = new LinkedList<Object>();
        newQueue.offer(x);
        if(!queue.isEmpty()) {
            newQueue.offer(queue);
        }
        queue = newQueue;
    }
    
    public int pop() {
        top();
        int top = (int)queue.poll();
        if(!queue.isEmpty()) {
            queue = (Queue)queue.poll();
        }
        return top;
    }
    
    public int top() {
        Object obj = queue.peek();
        if(obj instanceof Queue) {
            queue = (Queue)obj;
        }
        return (int)queue.peek();
    }
    
    public boolean empty() {
        return queue.isEmpty();
    }
}

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */