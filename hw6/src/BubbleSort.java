public class BubbleSort extends SortAlgorithm {

	public BubbleSort(int input_array[]) {
		super(input_array);
	}
	// sort method to perform the bubble sort .
    @Override
    public void sort() {
        boolean swaped;
        // control the number of passes
    	for(int i=0; i<arr.length-1; i++){
            swaped=false;
            for(int j=0 ;j<arr.length-i-1 ;j++){
               comparison_counter++;
                if(arr[j]>arr[j+1]){ // Compare adjacent elements and swap 
                    swap(j,j+1);
                    swaped=true;
                }
            }
            // If no elements were swapped, the array is sorted
            if(swaped==false){
                break;
            }
        }
    }
     // Print method to display the sorted array
    @Override
    public void print() {
    	System.out.print("Bubble Sort\t=>\t");
    	super.print();
    }
}
