package rover;

import lombok.extern.slf4j.Slf4j;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@Slf4j
public class RoversControl {

    public List<String> execute(Reader orders) {
        RoverCommandsParser parser = new RoverCommandsParser(orders);
        try(ByteArrayOutputStream out = new ByteArrayOutputStream()) {
            parser.parse(new PrintStream(out));
            return Arrays.asList(out.toString(StandardCharsets.UTF_8.name()).split("\\n"));
        } catch (Exception e) {
            log.error("Failure happened :(", e);
        }
        return Collections.emptyList();
    }
}
