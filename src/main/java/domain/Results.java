package domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Results {

    private final List<Result> results;

    public Results(List<Result> results) {
        this.results = new ArrayList<>(results);
    }

    public List<Result> getValues() {
        return Collections.unmodifiableList(results);
    }
}
