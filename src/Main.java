import java.util.Arrays;
import java.util.Random;

public class Main {
    private static int[] generateArray(int size){
        int[] array = new int[size];
        Random random = new Random();
        for (int i = 0; i < array.length; i++) {
            array[i] = random.nextInt(100_000) + 100_000;
        }
        return array;
    }
    private static void swapElements(int[] arr, int indexA, int indexB) {
        int tmp = arr[indexA];
        arr[indexA] = arr[indexB];
        arr[indexB] = tmp;
    }
    public static void sortBubble(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    swapElements(arr, j, j + 1);
                }
            }
        }
    }

    public static void sortSelection(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            int minElementIndex = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[minElementIndex]) {
                    minElementIndex = j;
                }
            }
            swapElements(arr, i, minElementIndex);
        }
    }

    public static void sortInsertion(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int temp = arr[i];
            int j = i;
            while (j > 0 && arr[j - 1] >= temp) {
                arr[j] = arr[j - 1];
                j--;
            }
            arr[j] = temp;
        }
    }
    public static void main(String[] args) {
        int size = 100_000;
        int[] array = generateArray(size);
        int[] array1 =Arrays.copyOf(array, size);
        int[] array2 =Arrays.copyOf(array, size);

        long start = System.currentTimeMillis();
        sortBubble(array);
        System.out.println("Метод sortBubble: " + (System.currentTimeMillis() - start));

        long start1 = System.currentTimeMillis();
        sortSelection(array1);
        System.out.println("Метод sortSelection: " + (System.currentTimeMillis() - start1));

        long start2 = System.currentTimeMillis();
        sortInsertion(array2);
        System.out.println("Метод sortInsertion: " + (System.currentTimeMillis() - start2));
    }


}