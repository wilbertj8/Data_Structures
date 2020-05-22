package Heaps;

import java.util.List;
import java.util.ArrayList;
import static java.lang.System.*;

public class Heap {
	private List<Integer> list;

	public Heap() {
		list = new ArrayList<Integer>();
	}

	public void add(int value) {
		list.add(value);
		swapUp(list.size() - 1);
	}

	public void swapUp(int bot) {
		int parent;
		if (bot % 2 == 0)
			parent = (bot - 2) / 2;
		else
			parent = (bot - 1) / 2;
		if (bot != 0 && list.get(bot) > list.get(parent)) {
			swap(bot, parent);
			swapUp(parent);
		}
	}

	public void remove() {
		list.set(0, list.get(list.size() - 1));
		list.remove(list.size() - 1);
		swapDown(0);
	}

	public void swapDown(int top) {
		if (list.size() == 2 && list.get(1) > list.get(0))
			swap(0, 1);
		if (top * 2 + 1 < list.size() - 1) {
			int larger = list.indexOf(Math.max(list.get(top * 2 + 1), list.get(top * 2 + 2)));
			if (list.get(top) < list.get(larger)) {
				swap(larger, top);
				swapDown(larger);
			}
		}
	}

	private void swap(int start, int finish) {
		int temp = list.get(start);
		list.set(start, list.get(finish));
		list.set(finish, temp);
	}

	public void print() {
		out.println("PRINTING THE HEAP!\n" + toString() + "\n");
	}

	public String toString() {
		return list.toString();
	}

	public static void main(String[] args) {
		Heap heap = new Heap();

		heap.add(1);
		heap.add(2);
		heap.add(8);
		heap.add(9);
		heap.add(10);
		heap.add(7);
		heap.add(75);
		heap.add(17);
		heap.add(5);

		heap.print();
		heap.remove();
		heap.print();
		heap.remove();
		heap.print();
		heap.remove();
		heap.print();
		heap.remove();
		heap.print();
		heap.remove();
		heap.print();
		heap.remove();
		heap.print();
		heap.remove();

		heap.print();
		heap.add(25);
		heap.print();
		heap.add(35);
		heap.print();
		heap.remove();
		heap.print();
	}
}