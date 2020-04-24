import java.util.PriorityQueue;

public class WorkOrder implements Comparable {
	private int priority;
	private String description;
	
	public WorkOrder(int priority, String description) {
		this.priority = priority;
		this.description = description;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public int compareTo(Object o) {
		WorkOrder other = (WorkOrder)o;
		if(this.priority > other.priority)
			return 1;
		if(this.priority < other.priority)
			return -1;
		return 0;
	}
	
	public static void main(String[] args) {
		PriorityQueue<WorkOrder> q = new PriorityQueue<WorkOrder>();		//creates empty PriorityQueue
		q.add(new WorkOrder(3, "Shampoo carpets"));
		q.add(new WorkOrder(1, "Fix broken sink"));
		q.add(new WorkOrder(2, "Order cleaning supplies"));					//adds WorkOrders to queue
		
		int size = q.size();
		for(int i = 0; i < size; i++)
			System.out.println(i+1 + " " + q.remove().getDescription());	//prints in order of priority
	}
}
