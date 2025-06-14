public class Accounts {
    private Account[] accts;
    private int current;

    public Accounts() {
        accts = new Account[5];
        current = 0;
    }

    public void add(Account acct) {
        accts[current] = acct;
        current++;
    }

    public Account getAccount(String creditCardNum) throws InvalidCreditCardException, AccountNotFoundException {
        if (creditCardNum.length() != 16)
            throw new InvalidCreditCardException();
        for (int i = 0; i < 5; i++) {
            if (accts[i].getCreditCardNum().equals(creditCardNum))
                return accts[i];
        }
        throw new AccountNotFoundException();
    }

    public void reset() {
        current = 0;
    }

    public boolean hasNext() {
        if (accts.length - (current + 1) != 0 && accts[current] != null)
            return true;
        return false;
    }

    public Account getNext() {
        Account c = accts[current];
        current++;
        return c;
    }
}
