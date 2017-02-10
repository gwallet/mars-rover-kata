package rover;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

public class HeadingTest {
    private static Map<Heading, Heading> lefts = new HashMap<>();
    private static Map<Heading, Heading> rights = new HashMap<>();
    private static Map<Heading, Location> moves = new HashMap<>();
    static {
        lefts.put(Heading.N, Heading.W);
        lefts.put(Heading.E, Heading.N);
        lefts.put(Heading.S, Heading.E);
        lefts.put(Heading.W, Heading.S);

        rights.put(Heading.N, Heading.E);
        rights.put(Heading.E, Heading.S);
        rights.put(Heading.S, Heading.W);
        rights.put(Heading.W, Heading.N);

        moves.put(Heading.N, new Location(0, 1));
        moves.put(Heading.E, new Location(1, 0));
        moves.put(Heading.S, new Location(0, -1));
        moves.put(Heading.W, new Location(-1, 0));
    }

    @Test public void should_rotate_left() throws Exception {
        for (Map.Entry<Heading, Heading> left : lefts.entrySet()) {
            Heading heading = left.getKey();
            assertThat(heading.left())
                    .isEqualTo(left.getValue());
        }
    }

    @Test public void should_rotate_right() throws Exception {
        for (Map.Entry<Heading, Heading> right : rights.entrySet()) {
            Heading heading = right.getKey();
            assertThat(heading.right())
                    .isEqualTo(right.getValue());
        }
    }

    @Test public void should_move_forward() throws Exception {
        for (Map.Entry<Heading, Location> move : moves.entrySet()) {
            Heading heading = move.getKey();
            Location actual = heading.forward(new Location(0, 0));
            assertThat(actual)
                    .isEqualTo(move.getValue());
        }
    }
}
