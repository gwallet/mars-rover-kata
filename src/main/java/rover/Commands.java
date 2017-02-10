package rover;

import lombok.AllArgsConstructor;

import java.util.Iterator;
import java.util.List;

import static java.util.stream.Collectors.toList;

@AllArgsConstructor
public class Commands extends Command implements Iterable<Command> {
    private List<Command> commands;

    public static Commands fromString(String commands) {
        return new Commands(commands.chars().mapToObj(Command::fromCharAsInt).collect(toList()));
    }

    @Override
    public Iterator<Command> iterator() {
        return commands.iterator();
    }

    @Override
    public void apply(Rover rover) {
        for (Command command : this) {
            rover.execute(command);
        }
    }
}
