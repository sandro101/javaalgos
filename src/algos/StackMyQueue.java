package algos;

import java.util.Stack;

class StackMyQueue {

	//https://leetcode.com/problems/implement-queue-using-stacks/description/
	
	//This does not actually operate like a proper Queue, the push is O(N), wasted a lot of time trying
	//to work out how in the hell you could do an O(1) push queue like behaviour using stacks
	
    Stack<Integer> s1;
    Stack<Integer> s2;
    /** Initialise your data structure here. */
    public StackMyQueue() {
        s1 = new Stack<>();
        s2 = new Stack<>();
    }
    
    /** Push element x to the back of queue. */
    public void push(int x) {
        while(!s1.isEmpty()){
            s2.push(s1.pop());
        }
        s1.push(x);
        while(!s2.isEmpty()){
            s1.push(s2.pop());
        }
    }
    
    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        return s1.pop();
    }
    
    /** Get the front element. */
    public int peek() {
        return s1.peek();
    }
    
    /** Returns whether the queue is empty. */
    public boolean empty() {
        return s1.isEmpty();
    }
}