package sorters;

public class MergeSorter {

	int[] values;
	int[] temp;
	
	/* the constructor for the MergeSorter class
	   int[] values is the array of values considered for sorting */
	public MergeSorter(int[] values){
		this.values = values;
		temp = new int[values.length];
	}
	/**
	 * A sorter implementing the specifications of merge sort.
	 * This method takes advantage of the simplicity of recursion,
	 * with the bulk of the work coming from the helper method merge.
	 * It is a bit more complex, but runs more efficiently,
	 * at approximately O(n log(n)) run-time complexity. 
	 * 
	 * DISADVANTAGE: uses more memory as it requires an auxillary
	 * array to store the final merge of values.
	 * 
	 * @param start
	 * @param end
	 * 		The indexes defining the range of the values to be sorted.
	 */
	public void mergeSort(int start, int end){
		if(start < end){
			int mid = (start + end)/2;
			mergeSort(start, mid);
			mergeSort(mid+1, end);
			merge(start, mid, mid+1, end);
		}
	}
	
	/**
	 * A private helper method which serves to merge one sublist into another.
	 * 
	 * @param startL
	 * @param endL
	 * 		The indexes defining the range of the left sublist.
	 * @param startR
	 * @param endR
	 * 		The indexes defining the range of the right sublist.
	 */
	private void merge(int startL, int endL, int startR, int endR){
		int index = startL;
		final int start = startL;
		
		while(startL <= endL && startR <= endR){
			if(values[startL] < values[startR]){
				temp[index] = values[startL];
				startL++;
			}else{
				temp[index] = values[startR];
				startR++;
			}
			index++;
		}
		while(startL <= endL){
			temp[index] = values[startL];
			startL++;
			index++;
		}
		while(startR <= endR){
			temp[index] = values[startR];
			startR++;
			index++;
		}
		for(index = start; index <= endR; index++)
			values[index] = temp[index];
	}
}
