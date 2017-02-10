package rover;

import java.util.HashMap;
import java.util.Map;

public abstract class Command {

    public static final Command ROTATE_LEFT = new RotateLeftCommand();
    public static final Command ROTATE_RIGHT = new RotateRightCommand();
    public static final Command MOVE_FORWARD = new MoveForwardCommand();

    public abstract void apply(Rover rover);

    private static final Map<Character, Command> commands = new HashMap<>();

    static {
        commands.put('L', ROTATE_LEFT);
        commands.put('R', ROTATE_RIGHT);
        commands.put('M', MOVE_FORWARD);
    }

    public static Command fromChar(char order) {
        return commands.get(order);
    }

    public static Command fromCharAsInt(int charAsInt) {
        return fromChar((char) charAsInt);
    }

    private static final class RotateLeftCommand extends Command {
        public void apply(Rover rover) {
            rover.rotateLeft();
        }
    }

    private static final class RotateRightCommand extends Command {
        public void apply(Rover rover) {
            rover.rotateRight();
        }
    }

    private static final class MoveForwardCommand extends Command {
        public void apply(Rover rover) {
            rover.moveForward();
        }
    }
}
