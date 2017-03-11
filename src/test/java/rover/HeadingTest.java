package rover;

import org.junit.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

public class HeadingTest {
    private static Map<Heading, Heading> lefts = new HashMap<>();
    private static Map<Heading, Heading> rights = new HashMap<>();
    private static Map<Heading, List<Integer>> moves = new HashMap<>();
    static {
        lefts.put(Heading.N, Heading.W);
        lefts.put(Heading.E, Heading.N);
        lefts.put(Heading.S, Heading.E);
        lefts.put(Heading.W, Heading.S);

        rights.put(Heading.N, Heading.E);
        rights.put(Heading.E, Heading.S);
        rights.put(Heading.S, Heading.W);
        rights.put(Heading.W, Heading.N);

        moves.put(Heading.N, Arrays.asList(0, 1));
        moves.put(Heading.E, Arrays.asList(1, 0));
        moves.put(Heading.S, Arrays.asList(0, -1));
        moves.put(Heading.W, Arrays.asList(-1, 0));
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
        for (Map.Entry<Heading, List<Integer>> move : moves.entrySet()) {
            Heading heading = move.getKey();
            List<Integer> actual = Arrays.asList(heading.x(0), heading.y(0));
            assertThat(actual)
                    .isEqualTo(move.getValue());
        }
    }
}