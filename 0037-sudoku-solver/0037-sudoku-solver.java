class Solution {
    public void solveSudoku(char[][] b) {
        solve(b);
    }

    boolean solve(char[][] b) {
        for (int r = 0; r < 9; r++) {
            for (int c = 0; c < 9; c++) {

                if (b[r][c] == '.') {

                    for (char n = '1'; n <= '9'; n++) {

                        if (valid(b, r, c, n)) {
                            b[r][c] = n;

                            if (solve(b))
                                return true;

                            b[r][c] = '.';
                        }
                    }

                    return false;
                }
            }
        }

        return true;
    }

    boolean valid(char[][] b, int r, int c, char n) {

        for (int i = 0; i < 9; i++) {
            if (b[r][i] == n) return false;
            if (b[i][c] == n) return false;
        }

        int sr = (r / 3) * 3;
        int sc = (c / 3) * 3;

        for (int i = sr; i < sr + 3; i++) {
            for (int j = sc; j < sc + 3; j++) {
                if (b[i][j] == n) return false;
            }
        }

        return true;
    }
}