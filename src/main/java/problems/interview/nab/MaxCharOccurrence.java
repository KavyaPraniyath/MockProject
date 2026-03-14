package problems.interview.nab;

public class MaxCharOccurrence {
    private static String solution(String S) {

        int[] occurrences = new int[26];

        for (char ch : S.toCharArray()) {
            occurrences[ch - 'a']++;
        }

        char best_char = 'a';
        int best_res = 0;

        for (int i = 0; i < 26; i++) {
            if (occurrences[i] > best_res) {
                best_char = (char) ('a' + i);
                best_res = occurrences[i];
            }
        }

        return Character.toString(best_char);
    }

    public static void main(String[] args) {
        String s = "aabbdddccc";
        System.out.println(solution(s));
    }
}
