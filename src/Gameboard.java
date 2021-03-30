public class Gameboard {
    public char[][] board;

    public Gameboard (boolean setup) {
        board = new char[8][8];

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                board[i][j] = '-';
            }
        }

        if (setup) {
            for (int i = 0; i < board[0].length; i++) {
                if (i % 2 == 0) {
                    board[1][i] = 'r';
                    board[5][i] = 'w';
                    board[7][i] = 'w';
                } else if (i % 2 == 1) {
                    board[0][i] = 'r';
                    board[2][i] = 'r';
                    board[6][i] = 'w';
                }
            }
        }
    }

    public boolean move (int x, int y, boolean left) {
        char cur = board[x][y];

        if (jump(x, y)) {
            return true;
        } else if (left) {
            if (cur == 'r') {
                if (board[x + 1][y + 1] == '-') {
                    board[x][y] = '-';
                    board[x + 1][y + 1] = 'r';
                    return true;
                }
            } else if (cur == 'w') {
                if (board[x - 1][y - 1] == '-') {
                    board[x][y] = '-';
                    board[x - 1][y - 1] = 'w';
                    return true;
                }
            }
        } else {
            if (cur == 'r') {
                if (x - 1 > -1 && y + 1 < board[0].length && board[x + 1][y - 1] == '-') {
                    board[x][y] = '-';
                    board[x - 1][y - 1] = 'r';
                    return true;
                }
            } else if (cur == 'w') {
                if (x + 1 < board.length && y - 1 > -1 && board[x - 1][y + 1] == '-') {
                    board[x][y] = '-';
                    board[x - 1][y + 1] = 'w';
                    return true;
                }
            }
        }

        return false;
    }

    public boolean jump (int x, int y) {
        char cur = board[x][y];
        if (cur == 'r') {
            if ((x > 1 && x < 6) && (y > 1 && y < 6)) {
                if ((board[x + 1][y + 1] == 'w') && (board[x + 2][y + 2] == '-')) {
                    board[x + 2][y + 2] = 'r';
                    board[x][y] = '-';
                    board[x + 1][y + 1] = '-';
                    jump(x + 2, y + 2);
                    return true;
                } else if ((board[x + 1][y - 1] == 'w') && (board[x + 2][y = 2] == '-')) {
                    board[x + 2][y - 2] = 'r';
                    board[x][y] = '-';
                    board[x + 1][y - 1] = '-';
                    jump(x + 2, y - 2);
                    return true;
                }
            }
        } else if (cur == 'w') {
            if ((x > 1 && x < 6) && (y > 1 && y < 6)) {
                if ((board[x - 1][y - 1] == 'r') && (board[x - 2][y - 2] == '-')) {
                    board[x - 2][y - 2] = 'w';
                    board[x][y] = '-';
                    board[x - 1][y - 1] = '-';
                    jump(x - 2, y - 2);
                    return true;
                } else if ((board[x - 1][y + 1] == 'r') && (board[x - 2][y + 2] == '-')) {
                    board[x - 2][y + 2] = 'w';
                    board[x][y] = '-';
                    board[x - 1][y + 1] = '-';
                    jump(x - 2, y + 2);
                    return true;
                }
            }
        }

        return false;
    }

    public boolean kingMe(int x, int y) {
        if (board[x][y] == 'r' && x == 7) {
            board[x][y] = 'R';
            return true;
        } else if (board[x][y] == 'w' && x == 0) {
            board[x][y] = 'W';
            return true;
        }

        return false;
    }

    public String toString() {
        String result = "";

        for (char[] C: board) {
            for (char c: C) {
                result += c + " ";
            }
            result += "\n";
        }

        return result;
    }

}
