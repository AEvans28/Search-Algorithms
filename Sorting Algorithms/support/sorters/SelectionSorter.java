package sorters;

public class SelectionSorter {

	int[] values;
	
	/* the constructor for the SelectionSorter class
	   int[] values is the array of values considered for sorting */
	public SelectionSorter(int[] values){
		this.values = values;
	}
	
	/**
	 * A sorter implementing the specifications of selection sort.
	 * This sorter is simple yet moderately inefficient, running in 
	 * approximately O(N^2) run-time complexity.
	 */
	public void selectionSort(){
		
		for(int index = 0; index < values.length; index++){
			swap(index, minIndex(index, values.length));
		}
	}
	
	/**
	 * A private helper method used to get the minimum element from 
	 * an unsorted array of values.
	 * 
	 * @param values
	 * 		the unsorted array of values to be considered
	 * @return
	 * 		the minimum element in the array
	 */
	private int minIndex(int start, int end){
		int indexOfMin = start;
		
		for(int index = start+1; index < end; index++)
			if(values[index] < values[indexOfMin])
				indexOfMin = index;
		
		return indexOfMin;
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
