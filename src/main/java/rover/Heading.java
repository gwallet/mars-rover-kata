package rover;

import lombok.AllArgsConstructor;

import java.util.function.IntUnaryOperator;

@AllArgsConstructor
public enum Heading {
    N( 0,  1),
    E( 1,  0),
    S( 0, -1),
    W(-1,  0);

    private final int deltaX, deltaY;

    public int deltaX() { return deltaX; }

    public int deltaY() { return deltaY; }

    public Heading left() {
        return valueOf(ordinal() - 1);
    }

    public Heading right() {
        return valueOf(ordinal() + 1);
    }

    private static Heading valueOf(int index) {
        int count = Heading.values().length;
        while (index < 0) index += count;
        return Heading.values()[index % count];
    }

}
