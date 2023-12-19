import java.util.Scanner;

public class QuickSort {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the number of elements: ");
        int n = scanner.nextInt();

        int[] arr = new int[n];

        System.out.println("Enter element:");
        for (int i = 0; i < n; i++) {

            arr[i] = scanner.nextInt();
        }

        // Sort the array
        sort(arr, 0, n - 1);

        // Print the sorted array
        System.out.println("\nSorted array:");
        for (int element : arr) {
            System.out.print(element + " ");
        }
        System.out.println();
    }

    public static void sort(int[] arr, int low, int high) {
        if (low < high) {
            // Partition the array around the pivot element
            int pivot = partition(arr, low, high);

            // Sort the sub-arrays recursively
            sort(arr, low, pivot - 1);
            sort(arr, pivot + 1, high);
        }
    }

    private static int partition(int[] arr, int low, int high) {
        // Choose the first element as the pivot
        int pivot = arr[low];
        int i = low + 1;
        int j = high;

        while (i <= j) {
            // Move i forward until it encounters an element greater than the pivot
            while (i <= high && arr[i] <= pivot) {
                i++;
            }

            // Move j backward until it encounters an element less than the pivot
            while (j > low && arr[j] >= pivot) {
                j--;
            }

            // Swap elements if i and j haven't crossed
            if (i < j) {
                swap(arr, i, j);
            }
        }

        // Swap the pivot element with the element at j
        swap(arr, low, j);

        // Return the index of the pivot element
        return j;
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
