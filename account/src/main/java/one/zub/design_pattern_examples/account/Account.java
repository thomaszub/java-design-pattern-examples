package one.zub.design_pattern_examples.account;

public class Account {

    private double balance;

    private double limit;

    private Account(double limit) {
        this.limit = limit;
        this.balance = 0.0;
    }

    public static Account create(double limit) {
        if (limit > 0.0) throw new IllegalArgumentException("Limit must be negative");
        return new Account(limit);
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public double getLimit() {
        return limit;
    }

    @Override
    public String toString() {
        return "Account{" +
                "balance=" + balance +
                ", limit=" + limit +
                '}';
    }
}
