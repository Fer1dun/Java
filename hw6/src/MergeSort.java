public class MergeSort extends SortAlgorithm {
	
	public MergeSort(int input_array[]) {
		super(input_array);
	}
	// Helper method to merge two halves of an array.
	private void merge(int arr[],int left,int mid,int right ){
        int size_1=mid-left+1;
        int size_2=right-mid;

        int ar_left[]=new int[size_1];
        int ar_right[]=new int[size_2];
        // Copying data to temp array
        for(int i=0;i<size_1;i++){
            ar_left[i]=arr[left+i];
        }
        for(int i=0;i<size_2;i++){
            ar_right[i]=arr[mid+i+1];
        }

        int i=0,j=0;
        int k=left;
        // Merge the temp arrays back into original array
        while (i < size_1 && j < size_2) {
            comparison_counter++;
            if (ar_left[i] <= ar_right[j]) {
                arr[k] = ar_left[i];
                i++;
            } else {
                arr[k] = ar_right[j];
                j++;
            }
            k++;
        }
        // Copy  elements of left arrray
        while (i < size_1) {
            arr[k] = ar_left[i];
            i++;
            k++;
        }
        // Copy  elements of right arrray
        while (j < size_2) {
            arr[k] = ar_right[j];
            j++;
            k++;
        }


    }
     // Main function that sorts array with recursivly
    private void sort(int arr[],int left,int right){
        if(left<right){
            int mid=(left+right)/2; // Find the middle point
            sort(arr,left,mid); // Sort first half
            sort(arr,mid+1,right);// Sort second half
            merge(arr,left,mid,right);
        }
        
    }
    // Public method to sort the array
    @Override
    public void sort() {
    	sort(arr,0,arr.length-1);
    }
    // Print method to display the sorted array
    @Override
    public void print() {
    	System.out.print("Merge Sort\t=>\t");
    	super.print();
    }
}
