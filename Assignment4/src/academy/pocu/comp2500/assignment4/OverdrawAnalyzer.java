package academy.pocu.comp2500.assignment4;

import java.util.HashMap;
import java.util.LinkedList;

public class OverdrawAnalyzer extends Canvas {
    private static final int LOWER_BOUND = 32;
    private static final int UPPER_BOUND = 126;

    private HashMap<String, LinkedList<Character>> pixelsHistory;
//    private int[][] pixelsOverdrawCount;

    public OverdrawAnalyzer(int width, int height) {
        super(width, height);
        this.pixelsHistory = new HashMap<>();
        for (int x = 0; x < width; x++) {
            for (int y = 0; y < height; y++) {
                this.pixelsHistory.put(String.format("%d,%d", x, y), new LinkedList<>());
            }
        }
//        this.pixelsOverdrawCount = new int[height][width];
    }

    public LinkedList<Character> getPixelHistory(int x, int y) {
        return this.pixelsHistory.get(String.format("%d,%d", x, y));
    }

    public int getOverdrawCount(int x, int y) {
        return this.pixelsHistory.get(String.format("%d,%d", x, y)).size();
//        return this.pixelsOverdrawCount[y][x];
    }

    @Override
    public void drawPixel(int x, int y, char pixel) {
        char prevChar = this.getPixel(x, y);
        super.drawPixel(x, y, pixel);
        if (this.getPixel(x, y) != prevChar) {
            this.pixelsHistory.get(String.format("%d,%d", x, y)).add(pixel);
//            this.pixelsOverdrawCount[y][x]++;
        }
    }

    @Override
    public boolean increasePixel(int x, int y) {
        if (super.increasePixel(x, y)) {
//            this.pixelsOverdrawCount[y][x]++;
            this.pixelsHistory.get(String.format("%d,%d", x, y)).add(this.getPixel(x, y));
            return true;
        }
        return false;
    }

    @Override
    public boolean decreasePixel(int x, int y) {
        if (super.decreasePixel(x, y)) {
//            this.pixelsOverdrawCount[y][x]++;
            this.pixelsHistory.get(String.format("%d,%d", x, y)).add(this.getPixel(x, y));
            return true;
        }
        return false;
    }

    @Override
    public void toUpper(int x, int y) {
        char prevChar = this.getPixel(x, y);
        super.toUpper(x, y);
        if (this.getPixel(x, y) != prevChar) {
//            this.pixelsOverdrawCount[y][x]++;
            this.pixelsHistory.get(String.format("%d,%d", x, y)).add(this.getPixel(x, y));
        }
    }

    @Override
    public void toLower(int x, int y) {
        char prevChar = this.getPixel(x, y);
        super.toLower(x, y);
        if (this.getPixel(x, y) != prevChar) {
//            this.pixelsOverdrawCount[y][x]++;
            this.pixelsHistory.get(String.format("%d,%d", x, y)).add(this.getPixel(x, y));
        }
    }

    @Override
    public void fillHorizontalLine(int y, char pixel) {
        char[] prevChar = new char[this.getWidth()];
        for (int i = 0; i < this.getWidth(); i++) {
            prevChar[i] = this.getPixel(i, y);
        }
        super.fillHorizontalLine(y, pixel);
        for (int i = 0; i < this.getWidth(); i++) {
            if (prevChar[i] != this.getPixel(i, y)) {
//                this.pixelsOverdrawCount[y][i]++;
                this.pixelsHistory.get(String.format("%d,%d", i, y)).add(this.getPixel(i, y));
            }
        }
    }

    @Override
    public void fillVerticalLine(int x, char pixel) {
        char[] prevChar = new char[this.getHeight()];
        for (int i = 0; i < this.getHeight(); i++) {
            prevChar[i] = this.getPixel(x, i);
        }
        super.fillVerticalLine(x, pixel);
        for (int i = 0; i < this.getHeight(); i++) {
            if (prevChar[i] != this.getPixel(x, i)) {
//                this.pixelsOverdrawCount[i][x]++;
                this.pixelsHistory.get(String.format("%d,%d", x, i)).add(this.getPixel(x, i));
            }
        }
    }

    @Override
    public void clear() {
        char[][] prevChars = new char[this.getWidth()][this.getHeight()];
        for (int x = 0; x < this.getWidth(); x++) {
            for (int y = 0; y < this.getHeight(); y++) {
                prevChars[x][y] = this.getPixel(x, y);
            }
        }

        super.clear();

        for (int x = 0; x < this.getWidth(); x++) {
            for (int y = 0; y < this.getHeight(); y++) {
                if (prevChars[x][y] != this.getPixel(x, y)) {
//                    this.pixelsOverdrawCount[i][j]++;
                    this.pixelsHistory.get(String.format("%d,%d", x, y)).add(this.getPixel(x, y));
                }
            }
        }
    }
}
