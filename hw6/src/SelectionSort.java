public class SelectionSort extends SortAlgorithm {

	public SelectionSort(int input_array[]) {
		super(input_array);
	}

    @Override
    public void sort() {
        int min; // Variable to store the index of the smallest element
        //control the number of passes needed for sorting
        for(int i=0;i<arr.length-1;i++){
            min=i;
            for(int j=i+1; j<arr.length;j++){
                comparison_counter++;
                if(arr[min]>arr[j]){ // If a smaller element is found,
                    min=j;
                }
            }
            swap(min,i); //swap it with the first unsorted element.

        }
        
    }
    // Print method to display the sorted array
    @Override
    public void print() {
    	System.out.print("Selection Sort\t=>\t");
    	super.print();
    }
}
