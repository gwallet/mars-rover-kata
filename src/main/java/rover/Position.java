package rover;

import java.util.Objects;

public class Position {

    private final int x, y;

    public Position(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override public int hashCode() {
        return Objects.hash(x, y);
    }

    @Override public boolean equals(Object obj) {
        if (! ( obj instanceof Position )) return false;

        Position other = (Position) obj;
        return Objects.equals(x, other.x)
            && Objects.equals(y, other.y);
    }

    @Override public String toString() {
        return x + " " + y;
    }

    public Position next(Heading heading) {
        return new Position(x + heading.deltaX(), y + heading.deltaY());
    }

}
