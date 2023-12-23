package medium;

public class SimpleBankSystem {
    public static void main(String[] args) {
        new Test().test();
    }

    private static class Test {
        public void test() {
            Bank bank = new Bank(new long[]{10, 100, 20, 50, 30});
            bank.withdraw(3, 10);    // return true, account 3 has a balance of $20, so it is valid to withdraw $10.
            // Account 3 has $20 - $10 = $10.
            bank.transfer(5, 1, 20); // return true, account 5 has a balance of $30, so it is valid to transfer $20.
            // Account 5 has $30 - $20 = $10, and account 1 has $10 + $20 = $30.
            bank.deposit(5, 20);     // return true, it is valid to deposit $20 to account 5.
            // Account 5 has $10 + $20 = $30.
            bank.transfer(3, 4, 15); // return false, the current balance of account 3 is $10,
            // so it is invalid to transfer $15 from it.
            bank.withdraw(10, 50);   // return false, it is invalid because account 10 does not exist.
        }

        class Bank {

            private long[] balance;

            public Bank(long[] balance) {
                this.balance = balance;
            }

            public boolean transfer(int account1, int account2, long money) {
                int idx1 = getIndex(account1);
                if(!isValidAccount(idx1) || !hasSufficientFunds(idx1, money)) return false;

                int idx2 = getIndex(account2);
                if(!isValidAccount(idx2)) return false;

                balance[idx1]-=money;
                balance[idx2]+=money;

                return true;
            }

            public boolean deposit(int account, long money) {
                int idx = getIndex(account);
                if(!isValidAccount(idx)) return false;

                balance[idx]+=money;

                return true;
            }

            public boolean withdraw(int account, long money) {
                int idx = getIndex(account);
                if(!isValidAccount(idx) || !hasSufficientFunds(idx, money)) return false;

                balance[idx]-=money;

                return true;
            }

            private boolean hasSufficientFunds(int idx, long amount){
                return balance[idx]>=amount;
            }

            private boolean isValidAccount(int idx) {
                return idx >= 0 && idx < balance.length;
            }

            private int getIndex(int account){
                return account -1;
            }
        }
    }

}
