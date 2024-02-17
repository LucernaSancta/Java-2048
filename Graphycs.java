import java.awt.*;

public class Graphycs extends Frame {
    Font font = new Font("FreeSansBold", Font.PLAIN, 32);
    int[][] paint_grid;

    public Graphycs() {
        setVisible(true);
        setSize(800, 800);
        setBackground(Color.decode("12299680"));
    }

    public void update(int[][] grid, int score) {
        paint_grid = grid;
        int max_tile = 0;

        for (int x = 0; x < 4; x++) {
            for (int y = 0; y < 4; y++) {
                if (grid[x][y] > max_tile) {
                    max_tile = grid[x][y];
                    System.out.println(max_tile);
                }
            }
        }
        setTitle("Max tile: " + Integer.toString(max_tile) + " Score: " + Integer.toString(score));
        repaint();
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        g.setFont(font);

        for (int x = 0; x < 4; x++) {
            for (int y = 0; y < 4; y++) {

                int current_value = paint_grid[y][x];
                int[][] colors = utils.colorDic(current_value);

                Color box_color = new Color(colors[0][0], colors[0][1], colors[0][2]);
                Color text_color = new Color(colors[1][0], colors[1][1], colors[1][2]);

                g.setColor(box_color);
                g.fillRect(x*200, y*200, 200, 200);

                int TextWidth = g.getFontMetrics().stringWidth(Integer.toString(current_value));
                int TextHeight = g.getFontMetrics().getHeight();
                g.setColor(text_color);
                g.drawString(Integer.toString(current_value), (200*x) + (200-TextWidth)/2, (200*y) + (200-TextHeight)/2 + TextHeight);
            }
        }
    }
}