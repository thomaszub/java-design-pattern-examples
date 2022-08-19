package one.zub.design_pattern_examples.account;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class AccountTest {

    @Test
    public void accountCannotHavePositiveLimit() {
        assertThrows(IllegalArgumentException.class, () -> Account.create(1000.0));
    }

    @Test
    public void depositAndWithdrawWithoutReachingLimit() {
        var account = Account.create(-1000);
        var commands = Arrays.asList(
                new DepositCommand(account, 2000.0),
                new WithdrawCommand(account, 1000.0)
        );
        commands.forEach(Command::execute);
        assertEquals(1000.0, account.getBalance());
    }

    @Test
    public void depositAndWithdrawWithReachingLimit() {
        var account = Account.create(-1000);
        var commands = Arrays.asList(
                new DepositCommand(account, 2000.0),
                new WithdrawCommand(account, 5000.0)
        );
        commands.forEach(Command::execute);
        assertEquals(2000.0, account.getBalance());
    }

    @Test
    public void compositeCommandsWithoutReachingLimit() {
        var account = Account.create(-1000);
        var command = new CompositeCommand(
                new DepositCommand(account, 2000.0),
                new WithdrawCommand(account, 1000.0),
                new WithdrawCommand(account, 500.0),
                new DepositCommand(account, 1000.0)
        );
        command.execute();
        assertEquals(1500.0, account.getBalance());
    }

}
