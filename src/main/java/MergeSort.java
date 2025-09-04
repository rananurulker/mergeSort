public class MergeSort {

    public static void main(String[] args) {

        int[] data =createRandomIntegerArray(10,1000,2000);

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

        int n1 = mid - left + 1;//Calculate subarray size
        int n2 = right - mid;

        int[] L = new int[n1];//Temporary arrays
        int[] R = new int[n2];

        for (int i = 0; i < n1; i++)//copies the elements from the original array into these temporary arrays
            L[i] = array[left + i];
        for (int j = 0; j < n2; j++)
            R[j] = array[mid + 1 + j];

        int i = 0, j = 0, k = left;//merging while loop i-L(index) j-R k-main array
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

    public static int[] createRandomIntegerArray (int elementCount, int startValue, int endValue){
        int[] data = new int[elementCount];
        for (int i = 0; i < data.length; i++) {
            data[i] = (int) (Math.random() * (endValue-startValue+1))+1000;//0.0 - 4999.999
        }
        return data;
    }
}
