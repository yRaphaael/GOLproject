import java.util.Random;
public class Grid {

        protected int w, h, g, s, count=1, countageofcells;
        private String p;
        private String word;
        private char[] value;
        private int[][] grid;
        Random rand = new Random();
        int randGrid;
        String ANSI_CYAN = "\u001B[0;36m";
        String ANSI_RESET = "\u001B[0m";

// constructors of the grid
        public Grid(int w, int h, int g, int s, String p) {
            this.w = w;
            this.h = h;
            this.g = g;
            this.s = s;
            this.p = p;
            this.grid = new int[w][h];
            this.value = p.toCharArray();
            this.word = word;
        }
        public void convert() throws InterruptedException {
            word = p.toLowerCase();
            if (word.equals("rnd")) {
                System.out.println("initial grid: ");
                for (int i = 0; i < w; i++) {
                    for (int j = 0; j < h; j++) {
                        grid[i][j] = (randGrid = rand.nextInt(2));
                        if (grid[i][j] == 0)
                            System.out.print(".\t");
                        else
                            System.out.print(ANSI_CYAN+"*\t"+ANSI_RESET);
                    }
                    System.out.println();
                }
                System.out.print("\n");
                var go = new Rules(w, h, g, s, p);
                go.Start(grid);
            }
                int row = 0;
                int colum = 0;
                for (char val:value) {
                    if (val == '0') {
                        grid[row][colum] = 0;
                        colum++;
                    } else if (val == '1') {
                        grid[row][colum] = 1;
                        colum++;
                    } else if (val == '#') {
                        colum = 0;
                        row++;
                    }
                }
                System.out.println("initial grid: ");
                for (int i = 0; i < w; i++) {
                    for (int j = 0; j < h; j++) {
                        if (grid[i][j] == 0)
                            System.out.print(".\t");
                        else
                            System.out.print(ANSI_CYAN+"*\t"+ANSI_RESET);
                    }
                    System.out.println();
                }
                System.out.print("\n");
                var go  = new Rules(w, h, g, s, p);
                go.Start(grid);
            }
}
