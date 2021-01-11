package domain;

import java.util.ArrayList;
import java.util.List;

public class LadderLine {
    private final List<Point> points;

    public LadderLine(List<Point> points) {
        this.points = new ArrayList<>(points);
    }

    public int move(int position) {
        return points.get(position).move();
    }
}
