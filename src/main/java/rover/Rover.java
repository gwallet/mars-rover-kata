package rover;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.List;

import static kjss.lang.PreConditions.when;

@Slf4j
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class Rover {
    private Position position;

    public static Rover at(Position position) {
        return new Rover(position);
    }

    public void logPosition(List<String> output) {
        output.add(position.toString());
    }

    public Rover execute(Command command) {
        when(command).isNull()
                .throwIllegalArgument("need command to execute, got '%s'", command);
        command.apply(this);
        return this;
    }

    Rover moveForward() {
        log.info("{} - moving forward 1 unit ...", this);
        setPosition(position.forward());
        return this;
    }

    Rover rotateRight() {
        log.info("{} - heading right 90° ...", this);
        setPosition(position.right());
        return this;
    }

    Rover rotateLeft() {
        log.info("{} - heading left 90° ...", this);
        setPosition(position.left());
        return this;
    }

    private void setPosition(Position newPosition) {
        position = newPosition;
        log.info("{} - new position reached.", this);
    }

    @Override
    public String toString() {
        return "Rover @ " + position;
    }
}
