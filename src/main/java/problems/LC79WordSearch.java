package problems;

public class LC79WordSearch {

    public boolean exist(char[][] board, String word) {
        int n = board.length;
        int m = board[0].length;
        for (int i = 0 ;i < n; i++) {
            for (int j = 0; j< m; j++) {
                if (board[i][j] == word.charAt(0)) {
                    if (isPossible(board, word, i, j, n, m, 0)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    private boolean isPossible(char[][] board, String word, int i, int j, int n, int m, int k) {
        if (k == word.length()) {
            return true;
        }
        if (i < 0 || i >= n || j< 0 || j>=m ||board[i][j] != word.charAt(k)) {
            return false;
        }
        char c = board[i][j];
        board[i][j] = '#';
        boolean right = isPossible(board, word, i+1, j, n, m, k+1);
        boolean left = isPossible(board, word, i-1, j, n, m, k+1);
        boolean up = isPossible(board, word, i, j-1, n, m, k+1);
        boolean down = isPossible(board, word, i, j+1, n, m, k+1);
        board[i][j] = c;
        return right || left || up || down;
    }

    public static void main(String[] args) {
        char[][] board = {{'A', 'B', 'C', 'E'}, {'S', 'F', 'C', 'S'}, {'A', 'D', 'E', 'E'}};
        String word = "ABCCED";
        LC79WordSearch lc79WordSearch = new LC79WordSearch();
        System.out.println(lc79WordSearch.exist(board, word));
    }
}
