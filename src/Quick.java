import java.util.Scanner;

public class Quick {
    public static void quickSort(int[] array){
        //public quickSort driver method
        quickSort(array,0, array.length);
    }

    private static void swap( int[] array, int i, int j ) {
        int temp = array[ i ];
        array[ i ] = array[ j ];
        array[ j ] = temp;
    } // end swap

    private static void quickSort(int[] array, int start, int end){
        int pivotPos;
        if (2 == end - start) {   //2 items
            if (array[start + 1] < array[start])
                swap(array, start, start + 1);
        }
        else if(2 < end -start){ //recursive case
            medianOfThree(array,start,end);
            pivotPos = partition(array,start,end);
            quickSort(array,start,pivotPos);
            quickSort(array,pivotPos+1,end);
        }
        //Base case 0 ot 1 item - already sorted
    }

    private static void medianOfThree(int[] array, int start, int end){
        //choose the pivot and swap with start
        int midPoint = start + (end - start) / 2;
        start = array[midPoint];
    }
    private static int partition(int[] array, int start, int end){
        int bigStart =start + 1;
        int pivot = array[start];
        for (int curr = start + 1; curr < end; curr++){
            if (array[curr] < pivot) { //belongs to smalls
                swap(array,bigStart,curr);
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

        quickSort(numbers);

        System.out.println("SORTED: ");
        for (i = 0; i < size; ++i) {
            System.out.print(numbers[i] + " ");
        }
        System.out.println();
    }
}
