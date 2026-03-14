package problems.interview.microsoft;

import java.util.ArrayList;
import java.util.List;

public class FindAllPeaks {

    public static List<Integer> findPeaks(int[] arr) {
        List<Integer> peaks = new ArrayList<>();
        int n = arr.length;

        if (n == 0) return peaks;

        // Check first element
        if (n > 1 && arr[0] >= arr[1]) {
            peaks.add(arr[0]);
        }

        // Check middle elements
        for (int i = 1; i < n - 1; i++) {
            if (arr[i] >= arr[i - 1] && arr[i] >= arr[i + 1]) {
                peaks.add(arr[i]);
            }
        }

        // Check last element
        if (n > 1 && arr[n - 1] >= arr[n - 2]) {
            peaks.add(arr[n - 1]);
        }

        return peaks;
    }

    public static void main(String[] args) {
        int[] arr = {1, 3, 2, 5, 4, 6, 3};

        List<Integer> peaks = findPeaks(arr);

        System.out.println("Peak elements are: " + peaks);
    }
}
