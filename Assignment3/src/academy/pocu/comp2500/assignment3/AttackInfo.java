package academy.pocu.comp2500.assignment3;

public class AttackInfo {
    public IntVector2D area;
    public int ap;

    public AttackInfo(IntVector2D area, int ap) {
        this.area = area;
        this.ap = ap;
    }

    @Override
    public String toString() {
        return "AttackInfo{" +
                "area=" + area +
                ", ap=" + ap +
                '}';
    }
}
