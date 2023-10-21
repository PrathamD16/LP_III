public class Assignment5 {
    static void print(int arr[]) {
        for (int x : arr) {
            System.out.print(x + " ");
        }
        System.out.println();
    }

    static void swap(int i, int j, int arr[]) {
        if (i != j) {
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
        }
    }

    static int paritionInd(int arr[], int start, int end) {
        int pivot = arr[start];
        int i = start + 1;
        int j = end;
        while (i < j) {
            while (pivot >= arr[i] && i <= end - 1) {
                i++;
            }
            while (pivot < arr[j] && j >= start + 1) {
                j--;
            }
            if (i < j) {
                swap(i, j, arr);
            }
        }
        swap(start, j, arr);
        return j;
    }

    static void quickSort(int arr[], int start, int end) {
        if (start < end) {
            int pi = paritionInd(arr, start, end);
            // print(arr);
            quickSort(arr, start, pi - 1);
            quickSort(arr, pi + 1, end);
        }
    }

    public static void main(String[] args) {
        int arr[] = { 6, 3, 5, 0, 1, 10, 3, -3 };
        quickSort(arr, 0, arr.length - 1);
        print(arr);
    }
}
