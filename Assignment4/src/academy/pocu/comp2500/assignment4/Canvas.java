package academy.pocu.comp2500.assignment4;

public class Canvas {
    private char[][] canvas;
    private int width;
    private int height;
    private static final int LOWER_BOUND = 32;
    private static final int UPPER_BOUND = 126;

    public Canvas(int width, int height) {
        this.canvas = new char[height][width];
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                this.canvas[i][j] = ' ';
            }
        }
        this.width = width;
        this.height = height;
    }

    public void drawPixel(int x, int y, char pixelValue) {
        if (LOWER_BOUND <= pixelValue && pixelValue <= UPPER_BOUND) {
            this.canvas[y][x] = pixelValue;
        }
    }

    public char getPixel(int x, int y) {
        return this.canvas[y][x];
    }
    //32부터 126입니다. [32, 126]

    public boolean increasePixel(int x, int y) {
        if (this.canvas[y][x] != UPPER_BOUND) {
            this.canvas[y][x]++;
            return true;
        }
        return false;
    }

    public boolean decreasePixel(int x, int y) {
        if (this.canvas[y][x] != LOWER_BOUND) {
            this.canvas[y][x]--;
            return true;
        }
        return false;
    }

    public void toUpper(int x, int y) {
        this.canvas[y][x] = Character.toUpperCase(this.canvas[y][x]);
    }

    public void toLower(int x, int y) {
        this.canvas[y][x] = Character.toLowerCase(this.canvas[y][x]);
    }

    public void fillHorizontalLine(int y, char pixelValue) {
        if (LOWER_BOUND <= pixelValue && pixelValue <= UPPER_BOUND) {
            for (int i = 0; i < this.width; i++) {
                this.canvas[y][i] = pixelValue;
            }
        }
    }

    public void fillVerticalLine(int x, char pixelValue) {
        if (LOWER_BOUND <= pixelValue && pixelValue <= UPPER_BOUND) {
            for (int i = 0; i < this.height; i++) {
                this.canvas[i][x] = pixelValue;
            }
        }
    }

    public void clear() {
        for (int i = 0; i < this.height; i++) {
            for (int j = 0; j < this.width; j++) {
                this.canvas[i][j] = ' ';
            }
        }
    }

    //+----------+
    //|*         |
    //|&         |
    //| $        |
    //|          |
    //|          |
    //|          |
    //|          |
    //|          |
    //|          |
    //|          |
    //+----------+

    public String getDrawing() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append('+').append("-".repeat(this.width)).append('+').append(System.lineSeparator());
        for (int i = 0; i < this.height; i++) {
            stringBuilder.append('|');
            for (int j = 0; j < this.width; j++) {
                stringBuilder.append(this.canvas[i][j]);
            }
            stringBuilder.append('|').append(System.lineSeparator());
        }
        stringBuilder.append('+').append("-".repeat(this.width)).append('+').append(System.lineSeparator());
        return stringBuilder.toString();
    }
}
