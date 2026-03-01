package problems.ms;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LC761SpecialBinaryString {
    public static String makeLargestSpecial(String s) {
        if (s == "" || s == null) {
            return "";
        }
        List<String> list = new ArrayList<>();
        int count = 0;
        int start = 0;

        // Step 1: Split into special substrings
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '1') count++;
            else count--;

            // When balanced, we found one special substring
            if (count == 0) {
                // Recursively process inner substring
                String inner = s.substring(start + 1, i);
                String processed = "1" + makeLargestSpecial(inner) + "0";
                list.add(processed);
                start = i + 1;
            }
        }

        // Step 2: Sort descending
        Collections.sort(list, Collections.reverseOrder());

        // Step 3: Join all substrings
        StringBuilder result = new StringBuilder();
        for (String str : list) {
            result.append(str);
        }

        return result.toString();
    }

    public static void main(String[] args) {
        String s = "11011000";
        System.out.println(makeLargestSpecial(s));
    }
}
