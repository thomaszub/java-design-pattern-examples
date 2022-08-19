package one.zub.design_pattern_examples.account;

public class WithdrawCommand implements Command {

    private final Account account;

    private final double amount;

    public WithdrawCommand(Account account, double amount) {
        this.account = account;
        this.amount = amount;
    }

    @Override
    public void execute() {
        var newBalance = account.getBalance() - amount;
        if (newBalance > account.getLimit()) account.setBalance(newBalance);
    }
}
