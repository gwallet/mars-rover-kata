package rover;

import static java.lang.String.format;
import static java.util.Objects.requireNonNull;

public class Rover {

    private Position position;
    private Heading heading;

    public static Rover at(int x, int y) {
        return new Rover(new Position(x, y));
    }

    private Rover(Position position) {
        this.position = position;
    }

    public Rover headingTo(Heading heading) {
        setHeading(heading);
        return this;
    }

    public void setPosition(Position position) {
        this.position = requireNonNull(position);
    }

    public Position getPosition() {
        return position;
    }

    public void setHeading(Heading heading) {
        this.heading = requireNonNull(heading);
    }

    public Heading getHeading() {
        return heading;
    }

    public void execute(Command command) {
        command.apply(this);
    }

    @Override public String toString() {
        return format("%s %s", position, heading);
    }

}
