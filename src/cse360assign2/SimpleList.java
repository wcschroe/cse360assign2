package cse360assign2;

public class SimpleList {
	private int list[];
	private int count;
	
	//Simple List class constructor
	public SimpleList() {
		list = new int[10]; //initialize list
		count = 0; //initialize count
	}
	
	/**
	 * Return the index of the parameter 'num' in the list.
	 */
	public int search(int num) {
		int location = -1;
		for (int index = 0; index < count; index++) {
			if (list[index] == num) {
				location = index;
				break;
			}
		}
		return location;
	}
	
	/**
	 * Add the parameter to the list at the beginning (index = 0). Move all the
	 * other integers in the list over.
	 */
	public void add(int num) {
		if (count == 0) list[0] = num;
		else {
			for (int index = count; index > 0; index--) {
				if (index != 10) list[index] = list[index - 1];
			}
			list[0] = num;
		}
		if (count < 10) count++;
	}
	
	/**
	 * If the parameter 'num' is in the list, then it is removed.
	 * Decrements count
	 */
	public void remove(int num) {
		int removeLocation = search(num);
		if (removeLocation == -1) return;
		else {
			list[removeLocation] = 0;
			for (int index = removeLocation; index < count - 1; index++) {
				list[index] = list[index + 1];
			}
			list[count] = 0;
			if (count > 0) count--; //don't decrement if list is empty
		}
	}
	
	/**
	 * Return the number of elements stored in the list.
	 */
	public int count() { return count; }
	
	/**
	 * Return the list as a String. The elements are separated by a space
	 */
	public String toString() {
		String output = "";
		for (int index = 0; index < count; index++) {
			output += Integer.toString(list[index]);
			if (index != count - 1) output += " ";
		}
		return output;
	}
	
	
}
