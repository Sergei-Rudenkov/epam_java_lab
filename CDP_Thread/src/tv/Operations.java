package tv;

import java.util.TreeSet;
import java.util.concurrent.TimeUnit;

public class Operations {
	
	public static void transfer(Account acc1, Account acc2, int amount)
			throws IFException, InterruptedException {
		TreeSet<Account> accounts = new TreeSet<Account>();
		accounts.add(acc1);
		accounts.add(acc2);
		
		if (accounts.first().getBalance() < amount)
			throw new IFException();
		System.out.println("Trying to lock Acount 1...");
		if (accounts.first().getLock().tryLock(10,TimeUnit.MILLISECONDS)) {
			System.out.println("Locked Account 1");

			System.out.println("Trying to lock Account 2...");
			if (accounts.last().getLock().tryLock(10,TimeUnit.MILLISECONDS)) {
				System.out.println("Locked Account 2");

				acc1.withdraw(amount);
				acc2.deposit(amount);
				accounts.first().getLock().unlock();
				accounts.last().getLock().unlock();
				System.out.println("Transfer has done succesfull");
				
			}else{
				System.out.println("Failed to lock Account 2");
				incFailedTransferCount(accounts.last());
			}
				
		}else{
			System.out.println("Failed to lock Account 1");
			incFailedTransferCount(accounts.first());
		}
	}
	public static void incFailedTransferCount(Account acc) {
		acc.getFailCounter().getAndAdd(1);
	}

	public static void main(String[] args) throws IFException,
			InterruptedException {
		final Account acc1 = new Account(1, 1000);
		final Account acc2 = new Account(2, 2000);

		new Thread(new Runnable() {
			public void run() {
				try {
					transfer(acc1, acc2, 500);
				} catch (IFException | InterruptedException e) {
					e.printStackTrace();
				}
			}
		}).start();
		transfer(acc2, acc1, 300);
		Thread.sleep(100);
		 System.out.println("Accaunt 1 = " + acc1.getBalance() + ",  Accaunt 2 = " + acc2.getBalance());
		 System.out.println("Accaunt 1, failed transactions = " + acc1.getFailCounter() + ",  Accaunt 2, failed transactions = " + acc2.getFailCounter());
	}
}
