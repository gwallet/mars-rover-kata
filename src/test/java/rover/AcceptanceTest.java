package rover;

import org.junit.jupiter.api.Test;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class AcceptanceTest {

    @Test public void should_produce_expected_output() throws Exception {
        String input = Files.readString(Paths.get("src", "test", "resources", "input.txt"));
        List<String> output = Files.readAllLines(Paths.get("src", "test", "resources", "output.txt"));
        assertThat(new RoversControl(input).execute()).isEqualTo(output);
    }

}
