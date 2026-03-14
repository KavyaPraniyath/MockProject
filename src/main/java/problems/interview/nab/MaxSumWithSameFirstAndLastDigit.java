package problems.interview.nab;

import java.util.HashMap;
import java.util.Map;

public class MaxSumWithSameFirstAndLastDigit {
    public static void main(String[] args) {
        int[] nums = {405, 45, 300, 300};
        System.out.println(solution(nums));

    }

    public static int solution(int[] A) {
        Map<Integer, Integer> map = new HashMap<>();
        int maxSum = -1;

        for (int num : A) {

            int last = num % 10;

            int first = num;
            while (first >= 10) {
                first /= 10;
            }

            int key = first * 10 + last;

            if (map.containsKey(key)) {

                maxSum = Math.max(maxSum, num + map.get(key));

                map.put(key, Math.max(map.get(key), num));

            } else {

                map.put(key, num);
            }
        }

        return maxSum;
    }
}
