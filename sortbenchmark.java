
import java.util.Random;

public class sortbenchmark {

    public static void merge(int[] arr, int i, int m, int f) {
        int n1 = (m - i) + 1;
        int n2 = (f - m);
        int[] half1 = new int[n1 + 1];
        int[] half2 = new int[n2 + 1];
        for (int v = 0; v < n1; v++) {
            half1[v] = arr[i + v];
        }
        for (int p = 0; p < n2; p++) {
            half2[p] = arr[p + m + 1];
        }
        half1[n1] = Integer.MAX_VALUE;
        half2[n2] = Integer.MAX_VALUE;
        for (int r = i, m1 = 0, m2 = 0; r <= f; r++) {
            if (half1[m1] <= half2[m2]) {
                arr[r] = half1[m1];
                m1++;
            } else {
                arr[r] = half2[m2];
                m2++;
            }
        }
    }

    public static void mergeSort(int[] arr, int left, int right) {
        if (right > left) {
            int middle = ((left + right) / 2);
            mergeSort(arr, left, middle);
            mergeSort(arr, middle + 1, right);
            merge(arr, left, middle, right);
        }
    }

    public static int partition(int a[], int low, int high) {
        int pivot = a[high];
        int i = (low - 1);
        for (int j = low; j < high; j++) {

            if (a[j] <= pivot) {
                i++;

                int temp = a[i];
                a[i] = a[j];
                a[j] = temp;
            }
        }

        int temp = a[i + 1];
        a[i + 1] = a[high];
        a[high] = temp;

        return i + 1;
    }

    public static void quickSort(int[] arr, int low, int high) {
        if (low < high){
            int pi = partition(arr, low, high);

            quickSort(arr, low, pi-1);
            quickSort(arr, pi+1, high);
        }
    }

    public static void main(String[] args) {
        int[] sizes = { 1000, 5000, 10000 };
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
