import java.util.Random;

public class sortbenchmark {

    public static void mergeSort(int[] arr, int left, int right) {
        // TODO: Implement Merge Sort
    }

    public static void quickSort(int[] arr, int low, int high) {
        // TODO: Implement Quick Sort
    }

    public static void main(String[] args) {
        int[] sizes = {1000, 5000, 10000};
        Random rand = new Random();

        System.out.printf("%-10s %-20s %-20s%n", "Array Size", "Merge Sort Time (ns)", "Quick Sort Time (ns)");
        System.out.println("-------------------------------------------------------------");

        for (int size : sizes) {
            int[] arr1 = new int[size];
            int[] arr2 = new int[size];

            // Fill both arrays with the same random numbers
            for (int i = 0; i < size; i++) {
                int val = rand.nextInt(100000);
                arr1[i] = val;
                arr2[i] = val;
            }

            // Measure Merge Sort time
            long start = System.nanoTime();
            mergeSort(arr1, 0, arr1.length - 1);
            long end = System.nanoTime();
            long mergeTime = end - start;

            // Measure Quick Sort time
            start = System.nanoTime();
            quickSort(arr2, 0, arr2.length - 1);
            end = System.nanoTime();
            long quickTime = end - start;

            // Print results
            System.out.printf("%-10d %-20d %-20d%n", size, mergeTime, quickTime);
        }
    }
}