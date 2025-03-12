package queens;

/**class Operation , used to perform methods like isSafe, placeQueen, nQueen
 * and finally return  the 2d array having 1 where queens should be placed */
public class Operation {
    
    /** isSafe, return the whether it is safe to put queen here or not
     * @ param board, row and col as indexes in integer type
     */
    public boolean isSafe(int[][] board, int row,int col){

        for(int index = 0; index < row; index++){
            if(board[index][col] == 1) return false;
        }
        for (int index = row - 1, j = col - 1; index >= 0 && j >= 0; index--, j--){
            if (board[index][j] == 1) return false;
            }

        for (int index = row - 1, j = col + 1; j < board.length && index >= 0; index--, j++){
            if (board[index][j] == 1) return false;
        }
        return true;
    }

     /** placeQueen, check that it is safe to put queen or not and
      * if it is safe than put the queen at that index
     * @ param board, row in integer type
     */
    public boolean placeQueen(int[][] board, int row){
        if(row == board.length){
            return true;
        }
        for (int index = 0; index < board.length; index++) {
            if (isSafe(board, row, index)) {
                board[row][index] = 1;
                if (placeQueen(board, row + 1))
                    return true;
                board[row][index] = 0;
            }
        }
        return false;
    }

     /** nQueen, return the board showing where queen is placed
     * @ param numQueen in integer type
     */
    public int[][] nQueen(int numQueens) {
        int[][] board = new int[numQueens][numQueens];

        if(numQueens == 2 || numQueens == 3 || numQueens == 0){
            throw new AssertionError("Not possible to place queens, in this case");
        }
        if (placeQueen(board, 0)) {
            return board;
        } 
        return board;
    }
}
