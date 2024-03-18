import java.util.Scanner;

public class Insertion {
    public static void insertionSort( int[] array ){
        //public insertionSort driver method
        insertionSort(array,0,array.length - 1);
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

        insertionSort(numbers);

        System.out.println("SORTED: ");
        for (i = 0; i < size; ++i) {
            System.out.print(numbers[i] + " ");
        }
        System.out.println();
    }
}
