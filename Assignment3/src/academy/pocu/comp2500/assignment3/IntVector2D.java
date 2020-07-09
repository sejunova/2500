package academy.pocu.comp2500.assignment3;

import java.util.Objects;

public class IntVector2D {
    private int x;
    private int y;

    public IntVector2D(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return this.x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return this.y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getDistance(IntVector2D other) {
        return Math.abs(this.x - other.x) + Math.abs(this.y - other.y);
    }

    public double getAtan(IntVector2D other) {
        return Math.atan2(other.x - this.x, other.y - this.y);
    }

    public boolean isInSight(IntVector2D other, int sight) {
        if (Math.abs(this.x - other.x) > sight) {
            return false;
        }

        if (Math.abs(this.y - other.y) > sight) {
            return false;
        }
        return true;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        IntVector2D that = (IntVector2D) o;
        return x == that.x && y == that.y;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }
}