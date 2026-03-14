package problems.interview.nab;

public class MaxDigitSumNumber {

    public static void main(String[] args) {
        String num = "98";
        System.out.println(solution("489"));
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
