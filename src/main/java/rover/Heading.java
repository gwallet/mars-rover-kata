package rover;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;

import java.util.function.IntUnaryOperator;

import static kjss.lang.PreConditions.when;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
public enum Heading {
    N(x -> x, y -> y + 1),
    E(x -> x + 1, y -> y),
    S(x -> x, y -> y - 1),
    W(x -> x - 1, y -> y);

    private IntUnaryOperator nextX, nextY;

    public Location forward(Location from) {
        return Location.builder()
                .x(nextX.applyAsInt(from.getX()))
                .y(nextY.applyAsInt(from.getY()))
                .build();
    }

    public Heading left() {
        return Heading.at(previous(ordinal()));
    }

    public Heading right() {
        return Heading.at(next(ordinal()));
    }

    private static Heading at(int index) {
        when(index).isLowerThan(0)
            .or(when(index).isGreaterThanOrEqualTo(values().length))
            .throwIllegalArgument("No heading value at index %d", index);
        return Heading.values()[index];
    }

    private static int previous(int index) {
        return (index + Heading.values().length - 1) % Heading.values().length;
    }

    private static int next(int index) {
        return (index + 1) % Heading.values().length;
    }
}
