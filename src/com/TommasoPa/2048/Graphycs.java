import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.stream.IntStream;

public class Graphycs extends Frame {
    Font font = new Font("FreeSansBold", Font.PLAIN, 32);
    int[][] paint_grid = new int[4][4];
    boolean endVar = false;

    public Graphycs() {
        setVisible(true);
        setSize(800, 800);
        setBackground(Color.decode("12299680"));
    }

    public void update(int[][] grid, int score, boolean end) {
        endVar = end;
        paint_grid = grid;
        int max_tile = 0;

        for (int x = 0; x < 4; x++) {
            for (int y = 0; y < 4; y++) {
                if (grid[x][y] > max_tile) {
                    max_tile = grid[x][y];
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
                Color box_color;
                Color text_color;

                if (endVar) {
                    int box_color_avarage = Math.round(IntStream.of(colors[0]).sum() / 3);
                    int text_color_avarage = Math.round(IntStream.of(colors[1]).sum() / 3);
                    box_color = new Color(box_color_avarage, box_color_avarage, box_color_avarage);
                    text_color = new Color(text_color_avarage, text_color_avarage, text_color_avarage);
                } else {
                    box_color = new Color(colors[0][0], colors[0][1], colors[0][2]);
                    text_color = new Color(colors[1][0], colors[1][1], colors[1][2]);
                }

                g.setColor(box_color);
                g.fillRect(x*200, y*200, 200, 200);

                int TextWidth = g.getFontMetrics().stringWidth(Integer.toString(current_value));
                int TextHeight = g.getFontMetrics().getHeight();
                g.setColor(text_color);
                g.drawString(Integer.toString(current_value), (200*x) + (200-TextWidth)/2, (200*y) + (200-TextHeight)/2 + TextHeight);
            }
        }
    }

    @Override
    public int KeyPressed(KeyEvent e) {
        int key = e.getKeyCode();

        switch (key) {
            case KeyEvent.VK_LEFT:  return 1;
            case KeyEvent.VK_RIGHT: return 2;
            case KeyEvent.VK_UP:    return -1;
            case KeyEvent.VK_DOWN:  return -2;
            case KeyEvent.VK_ESCAPE:return 10;
            default:                return 0;
        }
    }
}