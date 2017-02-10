package rover;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.extern.slf4j.Slf4j;

import static java.lang.String.format;
import static kjss.lang.PreConditions.when;

/**
 * Immutable {@link Position} of the {@link Rover}.
 */
@Slf4j
@Builder
@AllArgsConstructor
@EqualsAndHashCode
public class Position {
    private Location location;
    private Heading heading;

    public static Position fromString(String string) {
        when(string).isNull()
                .throwIllegalArgument("Expected string format 'x y h' like '0 0 N' but was '%s'", string);
        String[] parts = string.split("\\s");
        when(parts.length != 3)
                .throwIllegalArgument("Expected string format 'x y h' like '0 0 N' but was '%s'", string);
        return Position.builder()
                .location(new Location(Integer.parseInt(parts[0]), Integer.parseInt(parts[1])))
                .heading(Heading.valueOf(parts[2]))
                .build();
    }

    @Override
    public String toString() {
        return format("%s %s", location, heading.name());
    }

    /**
     * @return Return the new position by moving forward from the current position.
     */
    public Position forward() {
        return Position.builder()
                .location(heading.forward(location))
                .heading(heading)
                .build();
    }

    /**
     * @return Return the new position by heading right for 90° from the current position.
     */
    public Position right() {
        return Position.builder()
                .location(location)
                .heading(heading.right())
                .build();
    }

    /**
     * @return Return the new position by heading left for 90° from the current position.
     */
    public Position left() {
        return Position.builder()
                .location(location)
                .heading(heading.left())
                .build();
    }
}
