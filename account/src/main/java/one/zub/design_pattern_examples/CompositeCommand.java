package one.zub.design_pattern_examples;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CompositeCommand implements Command {

    private final List<Command> commands = new ArrayList<>();

    public CompositeCommand(Command... commands) {
        this.commands.addAll(Arrays.asList(commands));
    }

    @Override
    public void execute() {
        commands.forEach(Command::execute);
    }

}
