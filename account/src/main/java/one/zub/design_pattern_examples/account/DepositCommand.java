package one.zub.design_pattern_examples.account;

public class DepositCommand implements Command {

    private final Account account;

    private final double amount;

    public DepositCommand(Account account, double amount) {
        super();
        this.account = account;
        this.amount = amount;
    }

    @Override
    public void execute() {
        account.setBalance(account.getBalance() + amount);
    }

}
