package src.edx.DataStructures.Homework1;

import java.util.LinkedList;

public class LinkedListUtilsRunner {

	public static void main(String[] args) {
		LinkedList<Integer> one = new LinkedList<Integer>();
		one.clear();
		one.add(1);
		one.add(1);
		one.add(2);
		one.add(3);
		one.add(4);

		LinkedList<Integer> two = new LinkedList<Integer>();
		two.clear();
		two.add(1);
//		two.add(1);
//		two.add(2);
//		two.add(3);
//		two.add(4);

		LinkedList<String> strList = new LinkedList<String>();
		strList.clear();
		strList.add("Cat");
		strList.add("Bird");
		strList.add("Mouse");
		strList.add("Kangaroo");
		strList.add("Clams");

//		LinkedListUtils.insertSorted(one, 3);
//		System.out.println(one);

//		LinkedListUtils.removeMaximumValues(strList, 1);
//		System.out.println(strList);

		System.out.println(LinkedListUtils.containsSubsequence(one, two));
	}

}
