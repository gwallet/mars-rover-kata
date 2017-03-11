package rover;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

public class HeadingTest {
    private static Map<Heading, Heading> lefts = new HashMap<>();
    private static Map<Heading, Heading> rights = new HashMap<>();
    private static Map<Heading, Position> moves = new HashMap<>();
    static {
        lefts.put(Heading.N, Heading.W);
        lefts.put(Heading.E, Heading.N);
        lefts.put(Heading.S, Heading.E);
        lefts.put(Heading.W, Heading.S);

        rights.put(Heading.N, Heading.E);
        rights.put(Heading.E, Heading.S);
        rights.put(Heading.S, Heading.W);
        rights.put(Heading.W, Heading.N);

        moves.put(Heading.N, new Position(0, 1));
        moves.put(Heading.E, new Position(1, 0));
        moves.put(Heading.S, new Position(0, -1));
        moves.put(Heading.W, new Position(-1, 0));
    }

    @Test
    public void should_rotate_left() throws Exception {
        for (Map.Entry<Heading, Heading> left : lefts.entrySet()) {
            Heading heading = left.getKey();
            assertThat(heading.left())
                    .isEqualTo(left.getValue());
        }
    }

    @Test
    public void should_rotate_right() throws Exception {
        for (Map.Entry<Heading, Heading> right : rights.entrySet()) {
            Heading heading = right.getKey();
            assertThat(heading.right())
                    .isEqualTo(right.getValue());
        }
    }

    @Test
    public void should_move_forward() throws Exception {
        for (Map.Entry<Heading, Position> move : moves.entrySet()) {
            Heading heading = move.getKey();
            Position actual = new Position(0, 0).next(heading);
            Position expected = move.getValue();
            assertThat(actual)
                    .isEqualTo(expected);
        }
    }
}
