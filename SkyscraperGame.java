public class SkyscraperGame {
    private final int SIZE;
    private final int [][]VIEWS;
    private int[][]board;
    SkyscraperGame(int[][] views,int SIZE){
        this.SIZE = SIZE;
        this.VIEWS = views;
        this.board = new int[SIZE][SIZE];
    }

    public boolean resolve(){
        return resolve(0,0);
    }
    private boolean resolve(int row, int col){
        if (row == SIZE)return verifyRowColumns();
        int next_row = col == SIZE - 1 ? row + 1 : row;
        int next_col = col == SIZE - 1 ? 0 : col + 1;
        for (int i = 1; i <= SIZE; i++){
            if (repeatNumber(row, col, i)){
                board[row][col] = i;
                if (resolve(next_row, next_col))return true;
                board[row][col] = 0;
            }
        }
        return false;
    }
    private boolean verifyViews(int []line, int start_view, int final_view){
        int[] reverse = new int[line.length];
        for (int i = line.length - 1; i >= 0;i--){
            reverse[line.length - i - 1] = line[i];
        }
        if (countViews(line) != start_view)return false;
        if (countViews(reverse) != final_view)return false;
        return true;
    }
    private boolean verifyRowColumns(){
        for (int i = 0; i < SIZE; i++){
            if(!(verifyViews(board[i], VIEWS[2][i], VIEWS[3][i])))return false;
        }
        for (int i = 0; i < SIZE; i++){
            int[]temp = new int[SIZE];
            for (int j = 0; j < SIZE; j++){
                temp[j] = board[j][i];
            }
            if(!(verifyViews(temp, VIEWS[0][i], VIEWS[1][i])))return false;
        }
        return true;
    }
    private boolean repeatNumber(int row, int col, int height){
        for (int i = 0; i < SIZE; i++){
            if (board[row][i] == height || board[i][col] == height)return false;
        }
        return true;
    }
    private int countViews(int[] line){
        int counter = 0,max_valor = 0;
        for (int i : line){
            if (i > max_valor){
                max_valor = i;
                counter++;
            }
        }
        return counter;
    }
    public void printBoard(){
        for (int i = 0; i < SIZE;i++){
            for (int j = 0; j < SIZE; j++){
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }
}
