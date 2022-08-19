package one.zub.design_pattern_examples.account;

import java.util.Objects;

public record WithdrawCommand(Account account, double amount) implements Command {

    public WithdrawCommand {
        Objects.requireNonNull(account);
    }

    @Override
    public void execute() {
        var newBalance = account.getBalance() - amount;
        if (newBalance > account.getLimit()) account.setBalance(newBalance);
    }
}
