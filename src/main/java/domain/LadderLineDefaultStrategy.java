package domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class LadderLineDefaultStrategy implements LadderLineGenerateStrategy {
    @Override
    public LadderLine generateLine(int sizeOfPerson) {
        return new LadderLine(init(sizeOfPerson));
    }

    public List<Point> init(int sizeOfPerson) {
        List<Point> points = new ArrayList<>();
        Point point = initFirst(points);
        points.addAll(initBody(sizeOfPerson, point));
        initLast(points, points.get(sizeOfPerson - 2));
        return points;
    }

    private Point initFirst(List<Point> points) {
        Point point = Point.first(generatePoint());
        points.add(point);
        return point;
    }

    private List<Point> initBody(int sizeOfPerson, Point point) {
        List<Point> points = new ArrayList<>();
        for (int i = 1; i < sizeOfPerson - 1; i++) {
            point = point.next();
            points.add(point);
        }
        return points;
    }

    private void initLast(List<Point> points, Point point) {
        point = point.last();
        points.add(point);
    }

    private Boolean generatePoint() {
        Random random = new Random();
        return random.nextBoolean();
    }
}
