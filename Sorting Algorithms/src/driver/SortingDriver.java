package driver;

import java.text.DecimalFormat;
import java.util.Random;
import java.util.Scanner;

import sorters.*;

public class SortingDriver {

	static void initializeValues(int[] values, int size){
		
		Random rand = new Random();
		for(int index = 0; index < size; index++){
			values[index] = Math.abs(rand.nextInt()) % 100;
		}
	}

	static public boolean isSorted(int[]  values){
		for(int index = 0; index < values.length-1; index++){
			if(values[index] > values[index+1])
				return false;
		}
		return true;
	}
	
	static public void printValues(int[] values){
		if(values.length <= 250){
			int value;
			DecimalFormat fmt = new DecimalFormat("00");
			System.out.println("the values array is:");
			
			for(int index = 0; index < values.length; index++){
				value = values[index];
				if(((index+1) % 10) == 0)
					System.out.println(fmt.format(value));
				else
					System.out.print(fmt.format(value) + " ");
			}
		}else
			System.err.println("Data > 250, skipping print command");
		
		System.out.println();
	}
	
	static public void testSelectionSorter(int[] values){
		System.err.println("SelectionSorter running...");
		System.err.println();
		
			SelectionSorter selectSort = new SelectionSorter(values);
			long startTime = System.currentTimeMillis();
			selectSort.selectionSort();
			long endTime = System.currentTimeMillis();
			
		printValues(values);
		System.out.println("Sorted: " + isSorted(values));
		System.out.println("Time taken: " + (endTime - startTime) + " milliseconds, or " 
							+ (double)(endTime - startTime)/1000 + " Seconds");
		System.out.println();
	}
	
	static public void testBubbleSorter(int[] values){
		System.err.println("BubbleSorter running...");
		System.err.println();
		
			BubbleSorter bubbleSort = new BubbleSorter(values);
			long startTime = System.currentTimeMillis();
			bubbleSort.bubbleSort();
			long endTime = System.currentTimeMillis();
			
		printValues(values);
		System.out.println("Sorted: " + isSorted(values));
		System.out.println("Time taken: " + (endTime - startTime) + " milliseconds, or " 
				+ (double)(endTime - startTime)/1000 + " Seconds");
		System.out.println();	
	}
	
	static public void testInsertionSorter(int[] values){
		System.err.println("InsertionSorter running...");
		System.err.println();
		
		InsertionSorter insertSort = new InsertionSorter(values);
		long startTime = System.currentTimeMillis();
			insertSort.insertSort();
		long endTime = System.currentTimeMillis();
			
		printValues(values);
		System.out.println("Sorted: " + isSorted(values));
		System.out.println("Time taken: " + (endTime - startTime) + " milliseconds, or " 
				+ (double)(endTime - startTime)/1000 + " Seconds");
		System.out.println();
	}
	
	static public void testMergeSorter(int[] values){
		System.err.println("MergeSorter running...");
		System.err.println();
		
			MergeSorter mergeSort = new MergeSorter(values);
			long startTime = System.currentTimeMillis();
			mergeSort.mergeSort(0,values.length-1);
			long endTime = System.currentTimeMillis();
			
		printValues(values);
		System.out.println("Sorted: " + isSorted(values));
		System.out.println("Time taken: " + (endTime - startTime) + " milliseconds, or " 
				+ (double)(endTime - startTime)/1000 + " Seconds");
		System.out.println();
	}
	static public void testHeapSorter(int[] values){
		System.err.println("HeapSorter running...");
		System.err.println();
		
			HeapSorter heapSort = new HeapSorter(values);
			long startTime = System.currentTimeMillis();
			heapSort.heapSort();
			long endTime = System.currentTimeMillis();
			
		printValues(values);
		System.out.println("Sorted: " + isSorted(values));
		System.out.println("Time taken: " + (endTime - startTime) + " milliseconds, or " 
				+ (double)(endTime - startTime)/1000 + " Seconds");
		System.out.println();
	}
	static public void testQuickSorter(int[] values){
		System.err.println("QuickSorter running...");
		System.err.println();
		
			QuickSorter quickSort = new QuickSorter(values);
			long startTime = System.currentTimeMillis();
			quickSort.quickSort();
			long endTime = System.currentTimeMillis();
			
		printValues(values);
		System.out.println("Sorted: " + isSorted(values));
		System.out.println("Time taken: " + (endTime - startTime) + " milliseconds, or " 
							+ (double)(endTime - startTime)/1000 + " Seconds");
		System.out.println();
	}
	static final void printMessage(){
			System.out.println("Which command would you like to use?");
			System.out.println("1 = Selection Sorter");
			System.out.println("2 = Bubble Sorter");
			System.out.println("3 = Insertion Sorter");
			System.out.println("4 = Merge Sorter");
			System.out.println("5 = Quick Sorter");
			System.out.println("6 = Heap Sorter");
			System.out.println("7 = Initialize New Random Array");
			System.out.println("8 = Print Array");
			System.out.println("0 = Close Program");
			
		}
	
	
	
	public static void main(String[] args){
	
		Scanner scan = new Scanner(System.in);
		int[] values = new int[50];
		
		initializeValues(values, 50);
		printValues(values);
		System.out.println("Sorted: " + isSorted(values));
		System.out.println();
	
		printMessage();
		int cmd = 1;
		while(cmd != 0){
			cmd = scan.nextInt();
			switch(cmd){
				case(0): break;
				case(1): testSelectionSorter(values); break;
				case(2): testBubbleSorter(values); break;
				case(3): testInsertionSorter(values); break;
				case(4): testMergeSorter(values); break;
				case(5): testQuickSorter(values); break;
				case(6): testHeapSorter(values); break;
				case(7): {
					System.out.println("What size would you like the array to be?");
					int size = scan.nextInt();
					int[] newVals = new int[size];
					initializeValues(newVals, size);
					values = newVals;
					printMessage();
					break;
				}
				case(8):{
					printValues(values);
					System.out.println("Sorted: " + isSorted(values));
					System.out.println();
					break;
				}
				default: System.err.println("Please enter a value above");
			}
		}
		scan.close();
	}
}
