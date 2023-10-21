public class Assignment4 {
    private static void printSolution(int[][] board) {
        for (int[] row : board) {
            for (int value : row) {
                System.out.print(value + " ");
            }
            System.out.println();
        }
        System.out.println();
    }
    private static boolean isSafe(int[][] board, int row, int col, int n) {
        for (int i = 0; i < col; i++) {
            if (board[row][i] == 1) {
                return false;
            }
        }

        for (int i = row, j = col; i >= 0 && j >= 0; i--, j--) {
            if (board[i][j] == 1) {
                return false;
            }
        }
        
        for (int i = row, j = col; i < n && j >= 0; i++, j--) {
            if (board[i][j] == 1) {
                return false;
            }
        }

        return true;
    }

    private static boolean solveNQueensUtil(int[][] board, int col, int n) {
        if (col >= n) {
            printSolution(board);
            return true;
        }

        boolean res = false;
        for (int i = 0; i < n; i++) {
            if (isSafe(board, i, col, n)) {
                board[i][col] = 1;
                res = solveNQueensUtil(board, col + 1, n) || res;
                board[i][col] = 0;
            }
        }

        return res;
    }

    public static void solveNQueens(int firstQueenRow, int n) {
        int[][] board = new int[n][n];
        board[firstQueenRow][0] = 1;
        solveNQueensUtil(board, 1, n);
    }

    public static void main(String[] args) {
        int n = 5; 
        int firstQueenRow = 2;

        solveNQueens(firstQueenRow, n);
    }
}
