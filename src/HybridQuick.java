import java.util.Scanner;

public class HybridQuick {

    private static final int BREAKPOINT = 50;

    public static void hybridQuickSort( int[] array ){
        hybridQuickSort(array,0,array.length-1);
    }

    private static void swap( int[] array, int i, int j ) {
        int temp = array[ i ];
        array[ i ] = array[ j ];
        array[ j ] = temp;
    } // end swap

    private static void insertionSort( int[] array, int start, int end) {
        //private insertionSort helper method
        for (start = 0; start < end; start++){
            int smallest = start; //start is sorted already
            for (int toCompare = start; toCompare < array.length; toCompare++){
                if (array[toCompare] < array[smallest]){    //compare if smaller
                    smallest = toCompare; //update
                }
            }
            swap(array,smallest,start); //swap
        }
    }

    private static void medianOfThree(int[] array, int start, int end){
        //choose the pivot and swap with start
        int midPoint = start + (end - start) / 2;
        start = array[midPoint];
    }

    private static void hybridQuickSort( int[] array, int start, int end ) {
        int pivotPos;
        if (BREAKPOINT > end - start) {
            insertionSort(array, start, end);
        }
        else{
            medianOfThree(array,start,end);
            pivotPos = partition(array,start,end);
            hybridQuickSort(array, start, pivotPos);
            hybridQuickSort(array, pivotPos + 1, end);
        }
    }
    private static int partition(int[] array, int start, int end){
        int bigStart =start + 1;
        int pivot = array[start];
        for (int curr = start + 1; curr < end; curr++){
            if (array[curr] < pivot) { //if belongs to smalls
                swap(array,bigStart,curr);  //swap
                bigStart++;
            }
            //do nothing if it belongs in the big
        }
        swap(array,start,bigStart-1); //put pivot in place
        return bigStart-1; //return pivot's position
    }

    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        System.out.println("Insert size of array: ");
        int size = input.nextByte();
        int numbers[] = new int[size];
        for (int i = 0; i < size; ++i) {
            numbers[i] = (int)(Math.random() * 100);
        }
        int i = 0;

        System.out.println("UNSORTED: ");
        for (i = 0; i < size; ++i) {
            System.out.print(numbers[i] + " ");
        }
        System.out.println();

        hybridQuickSort(numbers);

        System.out.println("SORTED: ");
        for (i = 0; i < size; ++i) {
            System.out.print(numbers[i] + " ");
        }
        System.out.println();
    }
}
