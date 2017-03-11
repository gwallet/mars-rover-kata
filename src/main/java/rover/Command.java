package rover;

@FunctionalInterface
public interface Command {

    Command MOVE_FORWARD = rover -> rover.setPosition(rover.getPosition().next(rover.getHeading()));
    Command TURN_LEFT    = rover -> rover.setHeading(rover.getHeading().left());
    Command TURN_RIGHT   = rover -> rover.setHeading(rover.getHeading().right());

    void apply(Rover rover);

    static Command valueOf(String string) {
        return switch (string) {
            case "M" -> MOVE_FORWARD;
            case "L" -> TURN_LEFT;
            case "R" -> TURN_RIGHT;
            default -> throw new IllegalArgumentException("Unknown command " + string);
        };
    }

}
