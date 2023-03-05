public class Rules extends Grid {
    public Rules(int w, int h, int g, int s, String p) {
        super(w, h, g, s, p);
    }

    public void Start(int[][] grid) throws InterruptedException {
        int[][] nextGrid = new int[w][h];
        String ANSI_CYAN = "\033[0;36m";
        String ANSI_RESET = "\u001B[0m";
        countageofcells = 0;
        for (int l = 0; l < w; l++) {
            for (int m = 0; m < h; m++) {
                if (grid[l][m] == 1)
                    countageofcells++;
                int neighbours = 0;
                for (int i = -1; i <= 1; i++)
                    for (int j = -1; j <= 1; j++)
                        if ((l + i >= 0 && l + i < w) && (m + j >= 0 && m + j < h))
                            neighbours += grid[l + i][m + j];
                neighbours -= grid[l][m];
                if ((grid[l][m] == 1) && (neighbours < 2))
                    nextGrid[l][m] = 0;
                else if ((grid[l][m] == 1) && (neighbours > 3))
                    nextGrid[l][m] = 0;
                else if ((grid[l][m] == 0) && (neighbours == 3))
                    nextGrid[l][m] = 1;
                else
                    nextGrid[l][m] = grid[l][m];
            }
        }
        switch (g) {
            case 0:
                Thread.sleep(s);
                System.out.println("\nGeneration " + count + " Cells alive: " + countageofcells + " Time: " + s);
                for (int i = 0; i < w; i++) {
                    for (int l = 0; l < h; l++) {
                        if (nextGrid[i][l] == 0)
                            System.out.print(".\t");
                        else
                            System.out.print(ANSI_CYAN + "*\t" + ANSI_RESET);
                    }
                    System.out.println();
                }
                count++;
                Start(nextGrid);
            default:
                if (count <= g) {
                    Thread.sleep(s);
                    System.out.println("\nGeneration " + count + " Cells alive: " + countageofcells + " Seconds: " + s);
                    for (int i = 0; i < w; i++) {
                        for (int l = 0; l < h; l++) {
                            if (nextGrid[i][l] == 0) {
                                System.out.print(".\t");
                            } else
                                System.out.print(ANSI_CYAN + "*\t" + ANSI_RESET);
                        }
                        System.out.println();
                    }
                    count++;
                    Start(nextGrid);
                }
        }
    }
}