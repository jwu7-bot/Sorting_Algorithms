import java.util.Scanner;

public class Merge {
    public static void mergeSort( int[] array) {
        //public driver mergeSort method
        int temp[] = new int[array.length];
        mergeSort(array,0,array.length,temp);
    }
    private static void mergeSort( int[] array, int start, int end, int[] temp) {
        //private recursive helper mergeSort method
        int mid;
        if (1 < end - start) {
            //recursive case: if > 1 item
            mid = start + (end - start) / 2;
            mergeSort(array, start, mid, temp);
            mergeSort(array, mid, end, temp);
            merge(array, start, mid, end, temp);
        }
        //Base case: if < 2 items, do nothing
    }
    public static void merge(int[] array, int start, int mid, int end, int[] temp){
        //non-recursive helper merge method
        int currL = start; //index of current item in left half
        int currR = mid;    //index of current item in the right half
        int currT;  //index in temp

        for (currT = start; currT < end; currT++){
            if(currL < mid && (currR >= end || array[currL] < array[currR])) {
                //copy from the left half if that value is smaller
                // or if no value remain in the right half
                temp[currT] = array[currL];
                currL++;
            }
            else {
                //copy from the right half
                temp[currT] = array[currR];
                currR++;
            }
        }
        //combine into temp
        for (currT = start; currT < end; currT++)
            array[currT] = temp[currT];
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

        mergeSort(numbers);

        System.out.println("SORTED: ");
        for (i = 0; i < size; ++i) {
            System.out.print(numbers[i] + " ");
        }
        System.out.println();
    }
}
