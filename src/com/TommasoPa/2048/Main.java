public class Main {
    public static void main(String[] args) {
        // init game and display
        Board game = new Board();
        Graphycs display = new Graphycs();

        // used to check for available moves
        Board BackGame = new Board();

        // generate initial 3 tiles
        for (int i = 0; i < 3; i++) {
            game.rand_gen();
        }

        display.update(game.grid, game.score, false);

        int[][] old_grid;

        // main game cicle
        while (true) {

            // duplicate board to later check if there was a move
            old_grid = game.grid;

                // check key pressed
        }
    }
}
