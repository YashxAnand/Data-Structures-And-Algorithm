import java.util.Scanner;

class NQueenProblem{
    private int numberOfQueens;
    private int [][] chessBoard;
    public NQueenProblem(int numberOfQueens){
        this.numberOfQueens = numberOfQueens;
        this.chessBoard = new int [numberOfQueens][numberOfQueens];
    }

    void solve(){
        if(setQueen(0)){
            printQueen();
        }else{
            System.out.println("There is no solution");
        }
    }

    boolean setQueen(int colIndex){
        if(colIndex == numberOfQueens){
            return true;
        }

        for(int i = 0; i<numberOfQueens; i++){
            if(validPlace(colIndex, i)){
                chessBoard[i][colIndex] = 1;
                if(!setQueen(colIndex+1)){
                    chessBoard[i][colIndex] = 0;
                    continue;
                }
                return true;
            }
        }
        return false;
    }

    boolean validPlace(int col, int row){
        for(int i = 0; i<col; i++){
            if(chessBoard[row][i] == 1)
                return false;
        }

        for(int i = col, j = row; i>=0 && j>=0; i--, j--){
            if(chessBoard[j][i] == 1){
                return false;
            }
        }

        for(int i = col, j = row; i>=0 && j<numberOfQueens; i--, j++){
            if(chessBoard[j][i] == 1){
                return false;
            }
        }

        return true;
    }

    void printQueen(){
        for(int i = 0; i<numberOfQueens; i++){
            for(int j = 0; j<numberOfQueens; j++){
                if(chessBoard[i][j] == 1){
                    System.out.print(" * ");
                    continue;
                }
                System.out.print(" - ");
            }
            System.out.println();
        }
    }
    public static void main(String [] args){
        int n = new Scanner(System.in).nextInt();
        NQueenProblem problem = new NQueenProblem(n);
        problem.solve();
    }
}