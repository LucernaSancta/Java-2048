import java.util.Arrays;
import java.util.Random;

public class Board {
    int[][] grid;
    int score;
    Random rand = new Random();

    // construct the board
    public Board() {
        grid = new int[][]{{0,0,0,0},{0,0,0,0},{0,0,0,0},{0,0,0,0}};
        score = 0;
    }

    // rotate matrix 90 deg to the right (totaly copyed)
    public void rot90r() {
        final int M = grid.length;
        final int N = grid[0].length;
        int[][] ret = new int[N][M];
        for (int r = 0; r < M; r++) {
            for (int c = 0; c < N; c++) {
                ret[c][M-1-r] = grid[r][c];
            }
        }
        grid = ret;
    }

    // rotate matrix 90 deg to the left (270 to the right)
    public void rot90l() {
        rot90l();
        rot90l();
        rot90l();
    }

    // rotate matrix 180 deg
    public void rot180() {
        rot90l();
        rot90l();
    }

    // sum each column of the matrix with the 2048 rules
    public void summer() {
        for (int i = 0; i < 4; i++){
            if (grid[2][i] == grid[3][i]) {
                grid[3][i] *= 2;
                grid[2][i] = 0;
                score += grid[3][i];
            }
            if (grid[1][i] == grid[2][i]) {
                grid[2][i] *= 2;
                grid[1][i] = 0;
                score += grid[2][i];
            }

            if (grid[0][i] == grid[1][i]) {
                grid[1][i] *= 2;
                grid[0][i] = 0;
                score += grid[1][i];
            }
        }
    }

    // prints the 2d matrix (only for debugging)
    public void print_grid() {
        for (int x = 0; x < grid.length; x++) {
            for (int y = 0; y < grid[0].length; y++) {
                System.out.print(grid[x][y]);
                System.out.print(" ");
            }
            System.out.println();
        }
    }

    // generate random tile to random empty space in matrix
    public void rand_gen() {
        int[] numbers = {2,2,2,2,2,2,2,2,2,4};
        int randomNumber = numbers[rand.nextInt(numbers.length)];

        int[][] disp = new int[16][2];
        int j = 0;

        for (int x = 0; x < 4; x++) {
            for (int y = 0; y < 4; y++) {
                
                if (grid[x][y] == 0) {
                    
                    int[] value = {x,y};
                    disp[j] = value;
                    j++;
                }
            }
        }

        int[] choice = disp[rand.nextInt(j)];
        grid[choice[0]][choice[1]] = randomNumber;
    }

    // compress the matrix so that there are no empty tiles under not empty tiles
    public void gravity_compress() {
        for (int collumn = 0; collumn < 4; collumn++) {
            int[] m = {0,0,0,0};
            for (int y = 0, i = 0; y < 4; y++) {
                if (grid[y][collumn] != 0) {
                    m[i] = grid[y][collumn];
                    i++;
                }
            }
            grid[0][collumn] = m [0];
            grid[1][collumn] = m [1];
            grid[2][collumn] = m [2];
            grid[3][collumn] = m [3];

        }
    }

    // compress sum compress, used for conveniency
    public void gsg() {
        gravity_compress();
        summer();
        gravity_compress();
    }


}
