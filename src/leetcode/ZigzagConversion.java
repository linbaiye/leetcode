package leetcode;

public class ZigzagConversion {
    public String convert(String s, int numRows) {
        if (numRows == 1 || s.length() <= numRows)
            return s;
        int column = 0;
        int sub = numRows;
        for (int len = s.length(); len > 0;) {
            len -= sub;
            if (sub == numRows) {
                sub = numRows - 2;
                column += 1;
            }
            else {
                column += numRows - 2;
                sub = numRows;
            }
        }
        char[][] board = new char[numRows][column];
        char[] chars = s.toCharArray();
        int x = 0;
        int y = 0;
        boolean v = true;
        for (int i = 0; i < chars.length;){
            if (v) {
                board[x++][y] = chars[i++];
                if (x >= numRows) {
                    v = false;
                    x = numRows - 2;
                    y++;
                }
            } else {
                if (x > 0) {
                    board[x--][y++] = chars[i++];
                } else {
                    v = true;
                    x = 0;
                }
            }
        }
        StringBuilder stringBuilder = new StringBuilder();
        for (x = 0; x < board.length; x++) {
            for (y = 0; y < board[0].length; y++) {
                if (board[x][y] != 0) {
                    stringBuilder.append(board[x][y]);
                }
            }
        }
        return stringBuilder.toString();
    }

}
