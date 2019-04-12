package demo;

import java.util.Map;
import java.util.HashMap;

public class FindMode {
	public static void main(String[] args) {
		// test case
		int[] nums = { 0, 4, 2, 7, 2, 4, 2 };
		FindMode test = new FindMode();
		System.out.println(test.findMode(nums));
	}

	public int findMode(int[] numbers) {
		// Instanstiate the HashMap.
		Map<Integer, Integer> myMap = new HashMap<>();
		
		// This tuple will hold our key value pairs for a mode.
		// key is number, and value is number of times it occurs.
		int[] mode = {0,0};

		// Iterate the array and build a hash map to track number of occurrences for
		// values.
		for (int i : numbers) {
			if (!myMap.containsKey(i)) {
				myMap.put(i, 1);
			} else {
				myMap.put(i, myMap.get(i) + 1);
			}
		}
		
		
		// Iterate the map entry set constantly updating the mode tuple.
		for (Map.Entry<Integer, Integer> entry : myMap.entrySet()) {
			if (mode[1] < entry.getValue()) {
				mode[0] = entry.getKey();
				mode[1] = entry.getValue();
			}
		}
		
		// Return the number with highest occurrences.
		return mode[0];
	}

}

