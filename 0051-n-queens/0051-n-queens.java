class Solution {
    List<List<String>> ans = new ArrayList<>();

    public List<List<String>> solveNQueens(int n) {
        char[][] b = new char[n][n];

        for (char[] r : b)
            Arrays.fill(r, '.');

        solve(b, 0, n);
        return ans;
    }

    void solve(char[][] b, int r, int n) {
        if (r == n) {
            List<String> temp = new ArrayList<>();
            for (char[] row : b)
                temp.add(new String(row));
            ans.add(temp);
            return;
        }

        for (int c = 0; c < n; c++) {

            if (safe(b, r, c, n)) {

                b[r][c] = 'Q';

                solve(b, r + 1, n);

                b[r][c] = '.';
            }
        }
    }

    boolean safe(char[][] b, int r, int c, int n) {

        
        for (int i = 0; i < r; i++)
            if (b[i][c] == 'Q')
                return false;

      
        for (int i = r - 1, j = c - 1; i >= 0 && j >= 0; i--, j--)
            if (b[i][j] == 'Q')
                return false;

   
        for (int i = r - 1, j = c + 1; i >= 0 && j < n; i--, j++)
            if (b[i][j] == 'Q')
                return false;

        return true;
    }
}