import java.util.Scanner;

public class Shell {
    public static void shellSort( int[] array ) {
        int temp;
        int h =1;
        while(h <= array.length){
            h = h * 3 + 1;
        }
        while (h > 0){
            for (int outer = h; outer < array.length; outer++){
                temp = array[outer];
                int inner = outer;
                while (inner > h-1 && array[inner-h] >= temp){
                    array[inner] = array[inner-h];
                    inner -= h;
                }
                array[inner] = temp;
            }
            h = (h-1)/3;
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

        shellSort(numbers);

        System.out.println("SORTED: ");
        for (i = 0; i < size; ++i) {
            System.out.print(numbers[i] + " ");
        }
        System.out.println();
    }
}
