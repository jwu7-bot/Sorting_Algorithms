import java.util.Scanner;

public class Selection {
    public static void selectionSort(int[] array){
        //public driver selectionSort method
        findMin(array,0,array.length);
    }
    private static void swap( int[] array, int i, int j ) {
        int temp = array[ i ];
        array[ i ] = array[ j ];
        array[ j ] = temp;
    } // end swap

    private static int findMin( int[] array, int start, int end){
        //private findMin helper method
        int j = 0;
        int indexSmallest = 0;

        for (start = 0; start < end - 1; ++start) {

            // Find index of smallest remaining element
            indexSmallest = start;
            for (j = start + 1; j < end; ++j) {

                if (array[j] < array[indexSmallest]) {
                    indexSmallest = j;
                }
            }
            // Swap numbers[i] and numbers[indexSmallest]
            swap(array,start,indexSmallest);
        }
        return indexSmallest;

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

        selectionSort(numbers);

        System.out.println("SORTED: ");
        for (i = 0; i < size; ++i) {
            System.out.print(numbers[i] + " ");
        }
        System.out.println();
    }
}

