public class QuickSort extends SortAlgorithm {

	public QuickSort(int input_array[]) {
		super(input_array);
	}
	
    private int partition(int [] arr,int start,int end){
        int pivot=arr[end];
        int i=start-1;
        // Traverse through all elements
        for(int j=start;j<=end-1;j++){
            comparison_counter++;
            if(arr[j]<pivot){ // If current element is smaller than the pivot
                i++;
                swap(i,j);
            }
        }
        i++;
        swap(i,end); // Swap the pivot with the element at i
        return i;
    }
    // Recursive method to perform sort
    private void sort(int [] arr,int start,int end){
        if(end<=start) return;

        int pivot=partition(arr, start, end); // Partition the array and get the pivot index
        sort(arr, start, pivot-1);   // Recursively sort the left array
        sort(arr,pivot+1,end);       // Recursively sort the left array
    }
     // Public method to sort the array
    @Override
    public void sort() {
    	sort(arr,0,arr.length-1);
    }
    // Print method to display the sorted array
    @Override
    public void print() {
    	System.out.print("Quick Sort\t=>\t");
    	super.print();
    }
}
