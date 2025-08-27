public class MergeSort {

    public static void main(String[] args) {

        int[] data = new int[1000];

        // Fill the array with random numbers between 0 and 4999
        for (int j = 1; j <= 10; j++) {
            for (int i = 0; i < data.length; i++) {
                data[i] = (int) (Math.random() * 5000);
            }
        }

        System.out.println("Original Array:");
        for (int num : data) {
            System.out.print(num + " ");
        }

        mergeSort(data, 0, data.length - 1);

        System.out.println("\n\nSorted Array:");
        for (int num : data) {
            System.out.print(num + " ");
        }
    }

    //recursion till sorted
    //time complexity O(n*log(n)) worst case scenario
    public static void mergeSort(int[] array, int left, int right) {
        if (left < right) {
            int mid = (left + right) / 2;

            // Sort left half
            mergeSort(array, left, mid);

            // Sort right half
            mergeSort(array, mid + 1, right);

            // Merge both halves
            merge(array, left, mid, right);
        }
    }

    public static void merge(int[] array, int left, int mid, int right) {

        int n1 = mid - left + 1;
        int n2 = right - mid;

        int[] L = new int[n1];
        int[] R = new int[n2];
        for (int i = 0; i < n1; i++)
            L[i] = array[left + i];
        for (int j = 0; j < n2; j++)
            R[j] = array[mid + 1 + j];

        int i = 0, j = 0, k = left;
        while (i < n1 && j < n2) {
            if (L[i] <= R[j]) {
                array[k] = L[i];
                i++;
            } else {
                array[k] = R[j];
                j++;
            }
            k++;
        }
        while (i < n1) {
            array[k] = L[i];
            i++;
            k++;
        }

        while (j < n2) {
            array[k] = R[j];
            j++;
            k++;
        }
    }
}
