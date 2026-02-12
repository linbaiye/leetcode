package leetcode;

public class WordSearch {

    private boolean search(char[][] board, char [] word, int idx, int x, int y, boolean[][] visited) {
        if (idx >= word.length)
            return true;
        if (x < 0 || x >= board.length)
            return false;
        if (y < 0 || y >= board[0].length)
            return false;
        if (board[x][y] != word[idx])
            return false;
        if (visited[x][y])
            return false;
        visited[x][y] = true;
        if (search(board, word, idx + 1, x, y - 1, visited))
            return true;
        if (search(board, word, idx + 1, x, y + 1, visited))
            return true;
        if (search(board, word, idx + 1, x - 1, y, visited))
            return true;
        if (search(board, word, idx + 1, x + 1, y, visited))
            return true;
        visited[x][y] = false;
        return false;
    }

    public boolean exist(char[][] board, String word) {
        char[] chars = word.toCharArray();
        boolean[][] visited = new boolean[board.length][board[0].length];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] != chars[0]) {
                    continue;
                }
                if (chars.length == 1)
                    return true;
                visited[i][j] = true;
                if (search(board, chars, 1, i, j - 1, visited))
                    return true;
                if (search(board, chars, 1, i, j + 1, visited))
                    return true;
                if (search(board, chars, 1, i - 1, j, visited))
                    return true;
                if (search(board, chars, 1, i + 1, j, visited))
                    return true;
                visited[i][j] = false;
            }
        }
        return false;
    }
}
