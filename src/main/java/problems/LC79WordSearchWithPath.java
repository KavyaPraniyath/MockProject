package problems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LC79WordSearchWithPath {

    public List<int[]> exist(char[][] board, String word) {
        int n = board.length;
        int m = board[0].length;
        List<int[]> paths = new ArrayList<>();
        for (int i = 0 ;i < n; i++) {
            for (int j = 0; j< m; j++) {
                if (board[i][j] == word.charAt(0)) {
                    if (isPossible(board, word, i, j, n, m, 0, paths)) {
                        return paths;
                    }
                }
            }
        }
        return new ArrayList<>();
    }

    private boolean isPossible(char[][] board, String word, int i, int j, int n, int m, int k, List<int[]> paths) {
        if (k == word.length()) {
            return true;
        }
        if (i < 0 || i >= n || j< 0 || j>=m ||board[i][j] != word.charAt(k)) {
            return false;
        }
        paths.add(new int[] {i, j});
        char c = board[i][j];
        board[i][j] = '#';
        boolean right = isPossible(board, word, i+1, j, n, m, k+1, paths);
        boolean left = isPossible(board, word, i-1, j, n, m, k+1, paths);
        boolean up = isPossible(board, word, i, j-1, n, m, k+1, paths);
        boolean down = isPossible(board, word, i, j+1, n, m, k+1, paths);
        board[i][j] = c;
        boolean found = right || left || up || down;
        if (!found) {
            paths.remove(paths.size() - 1);
        }
        return found;
    }

    public static void main(String[] args) {
        char[][] board = {{'A', 'B', 'C', 'E'}, {'S', 'F', 'C', 'S'}, {'A', 'D', 'E', 'E'}};
        String word = "ABCCED";
        LC79WordSearchWithPath lc79WordSearchWithPath = new LC79WordSearchWithPath();
        List<int[]> paths = lc79WordSearchWithPath.exist(board, word);
        for (int[] path : paths) {
            System.out.println(Arrays.toString(path));
        }
    }
}
