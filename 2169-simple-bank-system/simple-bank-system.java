class Bank {
    long[] bal;

    public Bank(long[] balance) {
        bal = balance;
    }
    
    public boolean transfer(int account1, int account2, long money) {
        if (account1 < 1 || account1 > bal.length || account2 < 1 || account2 > bal.length) return false;
        if (bal[account1 - 1] < money) return false;
        bal[account1 - 1] -= money;
        bal[account2 - 1] += money;
        return true;
    }
    
    public boolean deposit(int account, long money) {
        if (account < 1 || account > bal.length) return false;
        bal[account - 1] += money;
        return true;
    }
    
    public boolean withdraw(int account, long money) {
        if (account < 1 || account > bal.length || bal[account - 1] < money) return false;
        bal[account - 1] -= money;
        return true;
    }
}
