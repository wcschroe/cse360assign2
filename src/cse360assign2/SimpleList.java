package cse360assign2;

public class SimpleList {
	private int list[];
	private int size;
	private int count;
	
	//Simple List class constructor
	public SimpleList() {
		size = 10;
		list = new int[size]; //initialize list
		count = 0; //initialize count
	}
	
	/**
	 * Private function to increase the size of the list and copy old values
	 */
	private void adjustListSize(int byAmount) {
		int tempList[] = list;
		size += byAmount;
		list = new int[size];
		for (int index = 0; index < count; index++) list[index] = tempList[index]; // Copy the list elementwise
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
		if (count < size) count++;
		if (count == size) adjustListSize(size / 2); // increase by 50%
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
			list[count - 1] = 0;
			if (count > 0) count--; //don't decrement if list is empty
			if (count < size * .75 && size > 1) adjustListSize(-1); // decrease by one entry
		}
	}
	
	/**
	 * Return the number of elements stored in the list.
	 */
	public int count() { return count; }
	
	public void append(int num) {
		if (size == count) adjustListSize(1);
		list[count] = num;
		count ++;
	}
	
	public int first() { 
		if (this.count() != 0) return list[0];
		else return -1;
	}
	
	public int last() {
		if (this.count() != 0) return list[count - 1];
		else return -1;
	}
	
	public int size() { 
		return size; 
	}
	
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
