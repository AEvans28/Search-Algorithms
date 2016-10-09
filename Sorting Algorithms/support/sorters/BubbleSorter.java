package sorters;

public class BubbleSorter {

	int[] values;
	
	/* the constructor for the BubbleSorter class
	   int[] values is the array of values considered for sorting */
	public BubbleSorter(int[] values){
		this.values = values;
	}
	
	/**
	 *A sorter implementing the specifications of bubble sort.
	 *Similar to SelectionSorter, this method is simple but inefficient.
	 *It also runs in approximately O(N^2) run-time complexity.
	 *
	 *ADVANTAGE: can be refined to be slightly faster by knowing when 
	 *to stop sorting as soon as it is sorted.
	 */
	public void bubbleSort(){
		boolean sorted = false;
		if(!sorted){
			for(int index = 0; index < values.length-1; index++){
				sorted = bubbleUp(index, values.length-1);
			}
		}
		/*
		 * int current = 0;
			while(current < values.length-1 && !sorted){
			sorted = bubbleUp(current, values.length-1);
			current++;
			
		}
		 */
	}
	
	/**
	 * A private helper method used to move the smallest element
	 * to the top of the unsorted portion of values. This method
	 * returns a boolean utilized by bubbleSort() to increase 
	 * the efficiency slightly by ending as soon as a swap is not
	 * made, meaning the list is then sorted.
	 * 
	 * @param start
	 * 		the index for the lower constraint of the unsorted portion
	 * @param end
	 * 		the index for the upper constraint of the unsorted portion
	 * @return
	 * 		true iff the a swap was not made (values is sorted)
	 * 		
	 */
	private boolean bubbleUp(int start, int end){
		boolean sorted = true;
		for(int index = end; index > start; index--)
			if(values[index] < values[index-1]){
				swap(index, index-1);
				sorted = false;
			}
		return sorted;
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
