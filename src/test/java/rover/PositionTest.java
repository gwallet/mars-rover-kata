package rover;


import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class PositionTest {

    @Test public void should_read_position_from_string() throws Exception {
        Position position = Position.fromString("0 0 N");
        assertThat(position).isEqualTo(new Position(new Location(0, 0), Heading.N));
    }

}
