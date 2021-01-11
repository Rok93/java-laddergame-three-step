package domain;

@FunctionalInterface
public interface LadderLineGenerateStrategy {
    LadderLine generateLine(int sizeOfPerson);
}
