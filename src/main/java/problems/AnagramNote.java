package problems;

public class AnagramNote {

    public boolean canFormAnagram(String[] words, String note) {
        int[] noteFrequency = new int[26];
        for (int i = 0; i < note.length(); i++) {
            noteFrequency[note.charAt(i) - 'a'] ++;
        }
        for (String word : words) {
            int[] wordFrequency = new int[26];
            boolean isPossible = true;
            for (int i = 0; i < word.length(); i++) {
                wordFrequency[word.charAt(i) - 'a'] ++;
                if (wordFrequency[word.charAt(i) - 'a'] > noteFrequency[word.charAt(i) - 'a']) {
                    isPossible = false;
                    break;
                }
            }
            if (isPossible) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        String note = "tacxyz";
        String[] words = {"cat", "dog", "bird"};
        System.out.println(new AnagramNote().canFormAnagram(words, note));
    }
}
