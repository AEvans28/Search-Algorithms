package sorters;

public class HeapSorter {

	int[] values;
	
	public HeapSorter(int[] values){
		this.values = values;
	}
	
	public void heapSort(){
		
		if(values.length == 0)
			return;
		
		int lastIndex = values.length-1;
		//build heap
		for(int index = values.length/2-1; index >= 0; index--)
			reheapDown(index, lastIndex);
		//sortNodes
		for(int index = lastIndex; index >= 1; index--){
			swap(0, index);
			reheapDown(0, index-1);
		}
	}
	
	private void reheapDown(int currIndex, int lastIndex){
		int left = (currIndex*2)+1;
		int right = (currIndex*2)+2;
		
		if(left > lastIndex)
			return;
		
		int swapIndex = left;
		
		if(right <= lastIndex && values[right] > values[left])
			swapIndex = right;
		
		if(values[currIndex] < values[swapIndex]){
			swap(currIndex, swapIndex);
			reheapDown(swapIndex, lastIndex);
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
