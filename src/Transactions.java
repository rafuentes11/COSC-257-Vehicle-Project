public class Transactions {
    private Transaction[] transactions;
    private int current;

    public Transactions() {
        transactions = new Transaction[5];
        current = 0;
    }

    public void add(Transaction tran) {
        transactions[current] = tran;
        current++;

    }

    public void reset() {
        current = 0;
    }

    public boolean hasNext() {
        if (transactions.length - (current + 1) != 0 && transactions[current] != null)
            return true;
        return false;
    }

    public Transaction getNext() {
        Transaction t = transactions[current];
        current++;
        return t;
    }
}
