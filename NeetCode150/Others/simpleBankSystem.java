public class simpleBankSystem {

    /* Leetocode #2043: Simple Bank System
     * Implement the Bank class:

        Bank(long[] balance) Initializes the object with the 0-indexed integer array balance.
        boolean transfer(int account1, int account2, long money) Transfers money dollars from the account numbered account1 to the account numbered account2. Return true if the transaction was successful, false otherwise.
        boolean deposit(int account, long money) Deposit money dollars into the account numbered account. Return true if the transaction was successful, false otherwise.
        boolean withdraw(int account, long money) Withdraw money dollars from the account numbered account. Return true if the transaction was successful, false otherwise.
    */

    private long[] balance;

    public simpleBankSystem(long[] balance) {
        this.balance = balance;
    }
    
    public boolean transfer(int account1, int account2, long money) {
        if (account1 < 1 || account1 > balance.length) return false;
        if (account2 < 1 || account2 > balance.length) return false;
        if (balance[account1 - 1] >= money) {
            balance[account1 - 1] = balance[account1 - 1] - money;
            balance[account2 - 1] = balance[account2 - 1] + money;
            return true;
        }
        return false;
    }
    
    public boolean deposit(int account, long money) {
        if (account < 1 || account > balance.length) return false;
        balance[account - 1] = balance[account - 1] + money;
        return true;
    }
    
    public boolean withdraw(int account, long money) {
        if (account < 1 || account > balance.length) return false;
        if (balance[account - 1] >= money) {
            balance[account - 1] = balance[account - 1] - money;
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        simpleBankSystem bank = new simpleBankSystem(new long[]{10,100,20,50,30});
        System.out.println("Should be T, T, T, F, F");
        System.out.println(bank.withdraw(3,10));
        System.out.println(bank.transfer(5,1,20));
        System.out.println(bank.deposit(5,20));
        System.out.println(bank.transfer(3,4,15));
        System.out.println(bank.withdraw(10, 50));


    }
}

/**
 * Your Bank object will be instantiated and called as such:
 * Bank obj = new Bank(balance);
 * boolean param_1 = obj.transfer(account1,account2,money);
 * boolean param_2 = obj.deposit(account,money);
 * boolean param_3 = obj.withdraw(account,money);
 */
    