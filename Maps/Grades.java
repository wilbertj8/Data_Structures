import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeMap;

public class Grades {
	public static void main(String[] args) {
		//initializes Map of students and grades
		TreeMap<String, String> studentGrades = new TreeMap<String, String>();
		studentGrades.put("Tom", "A+");
		studentGrades.put("Bill", "C-");
		studentGrades.put("Jack", "B");
		studentGrades.put("Evan", "F");
		Scanner in = new Scanner(System.in);
		//print student and respective grades first
		print(studentGrades);
		boolean run = true;
		while (run) {
			//prompt for input
			System.out.println("1: Add or Modify, 2: Remove, 3: Print, 4: Quit");
			String input = in.next();
			//if input is 1, add or modify grade
			if (input.equals("1")) {
				System.out.println("Name: ");
				String name = in.next();
				System.out.println("Grade: ");
				studentGrades.put(name, in.next());
			}
			//if input is 2, remove selected student
			else if (input.equals("2")) {
				System.out.println("Name: ");
				studentGrades.remove(in.next());
			}
			//if input is 3, print grades
			else if (input.equals("3"))
				print(studentGrades);
			//if input is 4, stop running program
			else if(input.equals("4"))
				run = false;
		}
		System.out.println("Goodbye");
		in.close();
	}

	public static void print(TreeMap<String, String> studentGrades) {
		Set<String> names = studentGrades.keySet();
		Iterator<String> iter = names.iterator();
		//print name and grade, separated with a colon
		while (iter.hasNext()) {
			String name = (String) iter.next();
			System.out.println(name + ": " + studentGrades.get(name));
		}
	}
}
