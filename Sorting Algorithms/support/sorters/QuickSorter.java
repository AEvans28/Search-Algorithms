package sorters;

public class QuickSorter {
	
	int[] values;
	
	/* the constructor for the QuickSorter class
	   int[] values is the array of values considered for sorting */
	public QuickSorter(int[] values){
		this.values = values;
	}
	
	/**
	 *A sorter implementing the specifications of quick sort.
	 *This sorter has a worst case run-time complexity of O(N^2)
	 *but has an average run-time complexity of O(Nlog(N))
	 *
	 *@param start
	 *@param end
	 *		The indexes defining the range of the values to be sorted
	 */
	
	public int[] quickSort(){
		return quickSortHelper(0, values.length-1);
	}
	
	public int[] quickSortHelper(int start, int end){
		if(start < end){
			int pivotPoint = getPivotPoint(start, end);
			quickSortHelper(start, pivotPoint-1);
			quickSortHelper(pivotPoint+1, end);
		}
			return values;
	}
	/**
	 * A helper method which "splits" the array at a value determined as
	 * the middle of the array
	 * 
	 * @param start
	 * @param end
	 * 		The indexes defining the range of the array to be split
	 * @return
	 * 		The index of the split point
	 */
	private int getPivotPoint(int left, int right){
		int pivotIndex = (left+right)/2;
		swap(pivotIndex, right);
		pivotIndex = right;
		
		int nextSwap = left;
		for(int index = left; index < right; index++){
			if(values[index] < values[pivotIndex]){
				swap(index, nextSwap);
				nextSwap++;
			}
		}
		swap(nextSwap, pivotIndex);
		pivotIndex = nextSwap;
		return pivotIndex;
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
