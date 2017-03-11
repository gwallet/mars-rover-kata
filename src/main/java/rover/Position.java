package rover;

import lombok.extern.slf4j.Slf4j;

import java.io.PrintStream;

@Slf4j
public class Position {
    private int x, y;
    private Heading h;

    public Position(int x, int y, Heading h) {
        this.x = x;
        this.y = y;
        this.h = h;
        log.info("New rover here! " + this);
    }

    public void forward() {
        x = h.x(x);
        y = h.y(y);
        log.info("Hey! I'm moved forward! " + this);
    }

    public void left() {
        h = h.left();
        log.info("Hey! I'm turned left! " + this);
    }

    public void right() {
        h = h.right();
        log.info("Hey! I'm turned right! " + this);
    }

    public void print(PrintStream printer) {
        printer.printf("%d %d %s%n", x, y, h.name());
    }

    @Override
    public String toString() {
        return "Position [" + x + ", " + y + ", " + h + "]";
    }
}
