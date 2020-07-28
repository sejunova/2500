package academy.pocu.comp2500.lab11;

import academy.pocu.comp2500.lab11.pocu.User;
import academy.pocu.comp2500.lab11.pocu.Wallet;

public class SafeWallet extends Wallet {
    public SafeWallet(final User user) throws IllegalAccessException {
        super(user);
    }

    @Override
    public boolean deposit(int amount) {
        int beforeDeposit = super.getAmount();
        if (!super.deposit(amount)) {
            return false;
        }
        if (super.getAmount() < beforeDeposit) {
            throw new OverflowException("Deposit Overflow");
        }
        return true;
    }
}
