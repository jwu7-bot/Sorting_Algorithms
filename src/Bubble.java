import java.util.Scanner;

public class Bubble {
    public static void bubbleSort( int[] array){
        for (int i = 0; i < array.length - 1; i++) {
            for (int j = 0; j < array.length - i - 1; j++) {
                if (array[j] > array[j + 1]) {
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
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

        bubbleSort(numbers);

        System.out.println("SORTED: ");
        for (i = 0; i < size; ++i) {
            System.out.print(numbers[i] + " ");
        }
        System.out.println();
    }
}
