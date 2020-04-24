import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class StackAndQueueExample {
	public static void main(String[] args) {
		//STACK EXAMPLE
		Stack<Integer> s = new Stack<Integer>();			//constructs empty stack
		s.push(1);
		s.push(2);
		s.push(3);											//adds 1,2,3 to stack
		int top = s.pop();									//removes top of stack, top = 3
		top = s.peek();										//gets top of stack w/o removing it, top = 2
		System.out.println(s.toString());
		
		//QUEUE EXAMPLE
		Queue<Integer> q = new LinkedList<Integer>();		//LinkedList implements Queue
		q.add(1);
		q.add(2);
		q.add(3);											//adds to tail of queue, q now [1,2,3]
		int head = q.remove();								//removes head of queue, head = 1, q now [2,3]
		head = q.peek();									//gets head w/o removing it, head = 2
		System.out.println(q.toString());
	}
}
