package ch.noseryoung;

public class Game {
    // Spielfeld: 0 = Boden, 1 = Wand, 2 = Box, 3 = Box auf Ziel, 4 = Ziel
    private final int[][] level = {
            {1, 1, 1, 1, 1, 1, 1},
            {1, 0, 4, 2, 0, 0, 1},
            {1, 0, 0, 2, 0, 0, 1},
            {1, 0, 0, 3, 2, 4, 1},
            {1, 1, 0, 0, 3, 3, 1},
            {1, 1, 1, 1, 1, 1, 1}
    };

    private int x = 2, y = 1;

    public int[][] getLevel() {
        return level;
    }

    public int getPlayerX() {
        return x;
    }

    public int getPlayerY() {
        return y;
    }

    public void move(int dx, int dy) {
        int next = level[y + dy][x + dx];
        int next2 = level[y + 2 * dy][x + 2 * dx];

        if (next == 0 || next == 4) {
            x += dx;
            y += dy;
        } else if ((next == 2 || next == 5) && (next2 == 0 || next2 == 4)) {
            level[y + dy][x + dx] = next - 2;        // Box-Feld wird leer
            level[y + 2 * dy][x + 2 * dx] = next2 + 2; // neue Position bekommt Box
            x += dx;
            y += dy;
        }
    }
}
