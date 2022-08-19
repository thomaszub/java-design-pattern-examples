package one.zub.design_pattern_examples.account;

import java.util.List;
import java.util.Objects;

public record CompositeCommand(List<Command> commands) implements Command {

    public CompositeCommand {
        Objects.requireNonNull(commands);
    }

    @Override
    public void execute() {
        commands.forEach(Command::execute);
    }
}
