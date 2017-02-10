package rover;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import static kjss.lang.PreConditions.when;

public class RoversControl {
    private static final String OVER = "==========";

    public List<String> execute(List<String> script) {
        when(script).isNull()
                .throwIllegalArgument("expects script as list of strings, got '%s'", script);
        Iterator<String> iterator = script.iterator();
        iterator.next(); // skip plateau's dimension
        List<String> output = new ArrayList<>();
        while (iterator.hasNext()) {
            Rover.at(Position.fromString(iterator.next()))
                    .execute(Commands.fromString(iterator.next()))
                    .logPosition(output);
        }
        output.add(OVER);
        return output;
    }
}
