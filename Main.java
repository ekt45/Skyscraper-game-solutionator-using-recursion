public class Main {
    public static void main(String[] args){
        int[][] views = {{3,4,2,1},{2,1,2,2},{3,2,1,2},{1,2,3,2}};
        SkyscraperGame skyscraperGame = new SkyscraperGame(views, 4);
        if(skyscraperGame.resolve())skyscraperGame.printBoard();
        else{
            System.out.println("No tiene solucion");
        }
    }
}
