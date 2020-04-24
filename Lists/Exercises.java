import java.util.LinkedList;
import java.util.ListIterator;

public class Exercises {
	public static void main(String[] args) {
		LinkedList<String> list = new LinkedList<String>();
		list.add("sup");
		list.add("ergf");
		list.add("cvbfs");
		list.add("rtnddd");
		list.add("sup");
		list.add("ergf");
		list.add("cvbfs");
		list.add("rtnddd");
		list.add("sup");
		list.add("ergf");
		list.add("cvbfs");
		list.add("rtnddd");
		//downsize(list,4);
		//reverse(list);
		System.out.println(list);
	}
	
	public static void downsize(LinkedList<String> employeeNames, int n) {
		ListIterator<String> iter = employeeNames.listIterator();
		int i = 1;
		while(iter.hasNext()) {
			iter.next();
			if(i%n == 0)
				iter.remove();
			i++;
		}
	}
	
	public static void reverse(LinkedList<String> strings) {
		int size = strings.size();
		for(int i = 1; i < strings.size(); i++)
			strings.addLast(strings.remove(size-i-1));
	}
}
