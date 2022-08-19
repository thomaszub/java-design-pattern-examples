package one.zub.design_pattern_examples.account;

import java.util.Objects;

public record DepositCommand(Account account, double amount) implements Command {

    public DepositCommand {
        Objects.requireNonNull(account);
    }

    @Override
    public void execute() {
        account.setBalance(account.getBalance() + amount);
    }
}
