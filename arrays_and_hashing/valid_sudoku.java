class Solution {

    private boolean isValidRows(char[][] board) {
        for (int i = 0; i < board.length; i++) {
            int mask = 0;
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] == '.') {
                    continue;
                }
                int digit = (int) (board[i][j] - '0');
                int shifted = 1 << digit;
                if ((mask & shifted) != 0) {
                    return false;
                }
                mask |= shifted;
            }
        }
        return true;
    }

    private boolean isValidColumns(char[][] board) {
        for (int i = 0; i < board.length; i++) {
            int mask = 0;
            for (int j = 0; j < board[i].length; j++) {
                if (board[j][i] == '.') {
                    continue;
                }
                int digit = (int) (board[j][i] - '0');
                int shifted = 1 << digit;
                if ((mask & shifted) != 0) {
                    return false;
                }
                mask |= shifted;
            }
        }
        return true;
    }

    private boolean isValidBoxes(char[][] board) {
        int size = 3;
        for (int dy = 0; dy < board.length; dy += size) {
            for (int dx = 0; dx < board[dy].length; dx += size) {
                int mask = 0;
                for (int i = 0; i < size; i++) {
                    for (int j = 0; j < size; j++) {
                        if (board[i + dy][j + dx] == '.') {
                            continue;
                        }
                        int digit = (int) (board[i + dy][j + dx] - '0');
                        int shifted = 1 << digit;
                        if ((mask & shifted) != 0) {
                            return false;
                        }
                        mask |= shifted;
                    }
                }
            }
        }
        return true;
    }

    public boolean isValidSudoku(char[][] board) {
        return isValidRows(board) && isValidColumns(board) && isValidBoxes(board);
    }
}

