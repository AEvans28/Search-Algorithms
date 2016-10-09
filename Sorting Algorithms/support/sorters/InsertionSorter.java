package sorters;

public class InsertionSorter {
	
	int[] values;
	
	/* the constructor for the InsertionSorter class
	   @param values is the array of values considered for sorting */
	public InsertionSorter(int[] values){
		this.values = values;
	}
	
	/**
	 * A sorter implementing the specifications of insertion sort. 
	 * This sorter runs in O(N^2) run-time complexity in a worst-case 
	 * scenario, and O(N) at best.
	 */
	public void insertSort(){
		for(int index = 1; index < values.length; index++)
			insertElement(0, index);
	}
	
	/**
	 * A private helper method used to insert an element into its 
	 * correct location within the portion sorted relative to the 
	 * contents within it 
	 * 
	 * @param start
	 * @param end
	 * 		Both are indexes defining the range of the "sorted" portion
	 */
	private void insertElement(int start, int end){
		for(int index = end; index > start; index--){
			if(values[index] < values[index -1])
				swap(index, index -1);
			else
				break;
			
		}
	}
	
	/**
	 * A private helper method used to swap the values of two indexes
	 * within the values array.
	 * 
	 * @param index1
	 * @param index2
	 * 		the two indexes considered for swapping
	 */
	private void swap(int index1, int index2){
		int temp = values[index1];
		values[index1] = values[index2];
		values[index2] = temp;
	}
}

