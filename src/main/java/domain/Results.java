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

    public Result get(int index) {
        if (index >= results.size()) {
            throw new IllegalArgumentException("[ERROR] 존재하지않는 결과입니다");
        }

        return results.get(index);
    }
}
