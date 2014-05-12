package tv;

import java.util.Random;
import java.util.TreeSet;
import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;

public class Transfer implements Callable<Boolean> {
	private Account accountFrom;
	private Account accountTo;
	private int amount;
	private int id;
	
	
	public Transfer(Account accountFrom, Account accountTo, int amount, int id) {
		this.accountFrom = accountFrom;
		this.accountTo = accountTo;
		this.amount = amount;
		this.id = id; 
	}

	@Override
	public Boolean call() throws IFException, InterruptedException {
		Random random = new Random(48);
		TreeSet<Account> accounts = new TreeSet<Account>();
		accounts.add(accountFrom);
		accounts.add(accountTo);
		
		if (accounts.first().getBalance() < amount)
			throw new IFException();
		System.out.println("Trying to lock Acount 1... , process " + id);
		if (accounts.first().getLock().tryLock(3000,TimeUnit.MILLISECONDS)) {
			System.out.println("Locked Account 1");

			System.out.println("Trying to lock Account 2... , process " + id);
			if (accounts.last().getLock().tryLock(3000,TimeUnit.MILLISECONDS)) {
				System.out.println("Locked Account 2");

				accountFrom.withdraw(amount);
				accountTo.deposit(amount);
				Thread.sleep(random.nextInt(4000)+1000);
				accounts.first().getLock().unlock();
				accounts.last().getLock().unlock();
				System.out.println("Transfer has done succesfull, process " + id);
				
			}else{
				System.out.println("Failed to lock Account 2, process " + id);
				incFailedTransferCount(accounts.last());
				return false;
			}
				
		}else{
			System.out.println("Failed to lock Account 1, process " + id);
			incFailedTransferCount(accounts.first());
			return false;
		}
		Operation2.countdown.countDown();
		Operation2.countdown.await();
		return true;
	}
	
	private static void incFailedTransferCount(Account acc) {
		acc.getFailCounter().getAndAdd(1);
	}

}
