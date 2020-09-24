package src.edx.DataStructures.Homework1;

import java.util.LinkedList;

public class LinkedListUtils {

	/*
	 * insertSorted: Assumes the input LinkedList is already sorted in
	 * non-descending order (i.e.,such that each element is greater than or equal to
	 * the one that is before it), and inserts the input int value into the correct
	 * location of the list. If the input LinkedList is null, this method should
	 * simply terminate.
	 * 
	 * removeMaximumValues: Removes all instances of the N largest values in the
	 * LinkedList. If the input LinkedList is null or if N is non-positive, return
	 * without any modifications. If any of the N largest values appear more than
	 * once in the LinkedList, this method should return remove all instances, so it
	 * may remove more than N elements overall. The other elements in the LinkedList
	 * should not be modified and their order must not be changed.
	 * 
	 * containsSubsequence: Determines whether any part of the first LinkedList
	 * contains all elements of the second in the same order with no other elements
	 * in the sequence, i.e. it should return true if the second LinkedList is a
	 * subsequence of the first, and false if it is not. The method should return
	 * false if either input is null or empty.
	 */

	public static void insertSorted(LinkedList<Integer> list, int value) {

		if (list == null) {
			return;
		}
		// loop to check all entries for null
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i) == null) {
				return;
			}
		}

		// adding value in for empty list
		if (list.isEmpty()) {
			list.add(value);
			return;
		}

		// loop to add value in after value equals or exceeds index i value
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i) >= value) {
				list.add(i, value);
				return;
			}

			// tail edge case
			if (i + 1 >= list.size()) {
				list.add(value);
				return;
			}
		}

	}

	public static void removeMaximumValues(LinkedList<String> list, int N) {

		if (list == null) {
			return;
		}

		// return if LinkedList is null or if N is non-positive
		if (list.peek() == null || N < 0) {
			return;
		}
		// check for null entries
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i) == null || N < 0) {
				return;
			}
		}

		// if N is larger than list; return empty list
		if (N > list.size()) {
			list.clear();
		}

		// logic to control the number of elements removed
		while (N > 0) {
			// LinkedList to store the largest element's index position (in case of multiple
			// elements)
			LinkedList<Integer> index = new LinkedList<Integer>();

			// loop to find the first largest element index
			int largest = list.get(0).compareTo("");
			for (int i = 0; i < list.size(); i++) {
				if (largest <= list.get(i).compareTo("")) {
					largest = list.get(i).compareTo("");
				}
			}

			// loop to record index locations of the largest elements
			for (int i = 0; i < list.size(); i++) {
				int current = list.get(i).compareTo("");
				if (current == largest) {
					index.add(i);
				}
			}

			// removing the largest entry or entries
			for (int j = index.size() - 1; j >= 0; j--) {
				int remove = index.remove(j);
				list.remove(remove);
			}
			// updating logic control
			N--;
		}
	}

	public static boolean containsSubsequence(LinkedList<Integer> one, LinkedList<Integer> two) {

		// if one slot or two slot is null return false
		if (one == null || two == null) {
			return false;
		}
		// false if entry in one contains null
		for (int i = 0; i < one.size(); i++) {
			if (one.get(i) == null) {
				return false;
			}
		}
		// false if entry in two contains null
		for (int i = 0; i < two.size(); i++) {
			if (two.get(i) == null) {
				return false;
			}
		}
		// cannot compare with an empty list
		if (two.isEmpty()) {
			return false;
		}
		// subsequence cannot be larger than main sequence
		if (two.size() > one.size()) {
			return false;
		}

		// default boolean for match is false
		boolean match = false;

		// LinkedList to store index values of "one" that match initial index value of
		// "two"
		LinkedList<Integer> matchIndex = new LinkedList<Integer>();

		// loop to find matching index values of "one" that match initial index value of
		// "two"
		for (int i = 0; i < one.size(); i++) {
			if (two.peek() == one.get(i)) {
				matchIndex.add(i);
			}
		}
		// iterating through the matchIndex (and removing to control the number of
		// iterations)
		for (int i = matchIndex.remove(); i < one.size();) {
			// loop through every value of the subsequence
			for (int j = 0; j < two.size(); j++) {
				// if the values at each index match
				if (one.get(i) == two.get(j)) {
					match = true;
					// increment to the next sequence index that matches
					i++;
				} else {
					// if they don't match, break out of the loop
					match = false;
					break;
				}
			}
			// logic to control if a match is found early (match is true) but there are
			// still possible iterations
			if (matchIndex.size() == 0 || match) {
				break;
			}
		}
		return match;
	}
}
