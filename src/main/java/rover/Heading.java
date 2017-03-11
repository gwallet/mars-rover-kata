package rover;

import lombok.AllArgsConstructor;

import java.util.function.IntUnaryOperator;

@AllArgsConstructor
public enum Heading {
    N(x -> x, y -> y + 1),
    E(x -> x + 1, y -> y),
    S(x -> x, y -> y - 1),
    W(x -> x - 1, y -> y);

    private IntUnaryOperator fx, fy;

    public int x(int x) {
        return fx.applyAsInt(x);
    }

    public int y(int y) {
        return fy.applyAsInt(y);
    }

    public Heading left() {
        return valueOf(ordinal() - 1);
    }

    public Heading right() {
        return valueOf(ordinal() + 1);
    }

    private static Heading valueOf(int index) {
        int count = Heading.values().length;
        if (index < 0) index += count;
        return Heading.values()[index % count];
    }
}
