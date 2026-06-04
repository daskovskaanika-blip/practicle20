import java.time.Duration;
import java.time.LocalTime;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Main {


    static void bubbleSort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }

    static void insertionSort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int key = arr[i];
            int j = i - 1;

            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j--;
            }

            arr[j + 1] = key;
        }
    }

    static void selectionSort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {

            int minIndex = i;

            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[minIndex]) {
                    minIndex = j;
                }
            }

            int temp = arr[i];
            arr[i] = arr[minIndex];
            arr[minIndex] = temp;
        }
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        System.out.print("ведіть розмір масиву: ");
        int size = scanner.nextInt();

        System.out.print("від якого числа генерувати: ");
        int from = scanner.nextInt();

        System.out.print("до якого числа генерувати: ");
        int to = scanner.nextInt();

        int[] original = new int[size];

        for (int i = 0; i < original.length; i++) {
            original[i] = random.nextInt(from, to + 1);
        }

        System.out.println("\nпочатковий масив:");
        System.out.println(Arrays.toString(original));

        int[] bubbleArray = Arrays.copyOf(original, original.length);
        int[] insertionArray = Arrays.copyOf(original, original.length);
        int[] selectionArray = Arrays.copyOf(original, original.length);

        LocalTime start = LocalTime.now();
        bubbleSort(bubbleArray);
        LocalTime finish = LocalTime.now();
        Duration bubbleTime = Duration.between(start, finish);

        start = LocalTime.now();
        insertionSort(insertionArray);
        finish = LocalTime.now();
        Duration insertionTime = Duration.between(start, finish);

        start = LocalTime.now();
        selectionSort(selectionArray);
        finish = LocalTime.now();
        Duration selectionTime = Duration.between(start, finish);

        System.out.println("\nбульбашкове сортування:");
        System.out.println(Arrays.toString(bubbleArray));
        System.out.println("Час: " + bubbleTime.toNanos() + " нс");

        System.out.println("\nсортування вставками:");
        System.out.println(Arrays.toString(insertionArray));
        System.out.println("час: " + insertionTime.toNanos() + " нс");

        System.out.println("\nсортування вибором:");
        System.out.println(Arrays.toString(selectionArray));
        System.out.println("час: " + selectionTime.toNanos() + " нс");
    }
}