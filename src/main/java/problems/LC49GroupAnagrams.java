package problems;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LC49GroupAnagrams {
    public List<List<String>> groupAnagrams(String[] strs) {

        Map<String, List<String>> map = new HashMap<>();
        for (String str : strs) {
            char[] ch = new char[26];
            for (int i = 0; i< str.length(); i++) {
                ch[str.charAt(i) - 'a'] ++;
            }
            String key = new String(ch);
            map.putIfAbsent(key, new ArrayList<>());
            map.get(key).add(str);
        }
        return new ArrayList<>(map.values());
    }

    public static void main(String[] args) {
        String[] strs = {"eat", "tea", "tan", "ate", "nat", "bat"};
        LC49GroupAnagrams  lc49GroupAnagrams = new LC49GroupAnagrams();
        List<List<String>>  result = lc49GroupAnagrams.groupAnagrams(strs);
        System.out.println(result);
    }
}
