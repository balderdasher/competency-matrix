package com.mrdios.competencymatrix.java.readingnotes.JavaConcurrencyInPractice.chapter10;

import javax.naming.InsufficientResourcesException;

/**
 * 动态的锁顺序死锁
 *
 * @author huxiong
 * @date 2016/06/16 17:25
 */
public class DynamicDeadlock {

    /**
     * 转账操作（会发生死锁）
     * 两个账户相互给对方转账时，会发生死锁，相当于简单的锁顺序死锁
     *
     * @param fromAccount 转出账户
     * @param toAccount   转入账户
     * @param amount      转账金额
     */
    public void transferMoney(Account fromAccount, Account toAccount, int amount)
            throws InsufficientResourcesException {
        synchronized (fromAccount) {
            synchronized (toAccount) {
                if (fromAccount.getBalance() < 0) {
                    throw new InsufficientResourcesException();
                } else {
                    fromAccount.debit(amount);
                    toAccount.credit(amount);
                }
            }
        }
    }

    /** 当两个对象拥有相同的散列值时使用的加时赛锁 **/
    private static final Object tieLock = new Object();

    /**
     * 通过锁顺序来避免死锁
     *
     * @param fromAccount
     * @param toAccount
     * @param amount
     * @throws InsufficientResourcesException
     */
    public void transferMoneyRight(final Account fromAccount, final Account toAccount, final int amount)
            throws InsufficientResourcesException {
        class Helper {
            public void transfer() throws InsufficientResourcesException {
                if (fromAccount.getBalance() < 0) {
                    throw new InsufficientResourcesException();
                } else {
                    fromAccount.debit(amount);
                    toAccount.credit(amount);
                }
            }
        }
        int fromHash = System.identityHashCode(fromAccount);
        int toHash = System.identityHashCode(toAccount);

        if (fromHash < toHash) {
            synchronized (fromAccount) {
                synchronized (toAccount) {
                    new Helper().transfer();
                }
            }
        } else if (fromHash > toHash) {
            synchronized (toAccount) {
                synchronized (fromAccount) {
                    new Helper().transfer();
                }
            }
        } else {
            // same hashCode? get the tieLock
            synchronized (tieLock) {
                synchronized (fromAccount) {
                    synchronized (toAccount) {
                        new Helper().transfer();
                    }
                }
            }
        }
    }


    class Account {
        private int balance;

        public int getBalance() {
            return balance;
        }

        public void setBalance(int balance) {
            this.balance = balance;
        }

        /**
         * 转出
         *
         * @param amount
         */        public void debit(int amount) {
            this.setBalance(getBalance() - amount);
        }

        /**
         * 转入
         *
         * @param amount
         */
        public void credit(int amount) {
            this.setBalance(getBalance() + amount);
        }
    }
}
