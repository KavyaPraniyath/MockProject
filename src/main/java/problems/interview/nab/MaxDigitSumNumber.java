package problems.interview.nab;

public class MaxDigitSumNumber {

    public static void main(String[] args) {
        String num = "98";
        System.out.println(solution1(num));
    }

    public static String solution1(String S) {
        int num = Integer.parseInt(S);
        int maxNum = 0;
        int maxSum = 0;
        for (int i = num -1; i>=1; i--) {
            int sum = getSum(i);
            if (sum > maxSum) {
                maxSum = sum;
                maxNum = i;
            }
        }
        return Integer.toString(maxNum);
    }

    private static int getSum(int num) {
        int sum = 0;
        while (num != 0) {
            sum = sum + num % 10;
            num = num/10;
        }

        return sum;
    }

    public static String solution(String S) {

        String best = "";
        int maxSum = -1;

        int n = S.length();
        char[] arr = S.toCharArray();

        for (int i = 0; i < n; i++) {

            if (arr[i] == '0') continue;

            char[] temp = arr.clone();
            temp[i]--;

            for (int j = i + 1; j < n; j++) {
                temp[j] = '9';
            }

            String candidate = removeLeadingZeros(new String(temp));

            int sum = digitSum(candidate);

            if (sum > maxSum ||
                    (sum == maxSum && candidate.compareTo(best) > 0)) {

                maxSum = sum;
                best = candidate;
            }
        }

        return best;
    }

    private static int digitSum(String s) {

        int sum = 0;

        for (char c : s.toCharArray()) {
            sum += c - '0';
        }

        return sum;
    }

    private static String removeLeadingZeros(String s) {

        int i = 0;

        while (i < s.length() && s.charAt(i) == '0') {
            i++;
        }

        return i == s.length() ? "" : s.substring(i);
    }
}
