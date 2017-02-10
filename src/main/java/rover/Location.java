package rover;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;

@Builder
@EqualsAndHashCode
@AllArgsConstructor
public class Location {
    @Getter private int x, y;

    @Override
    public String toString() {
        return x + " " + y;
    }
}
