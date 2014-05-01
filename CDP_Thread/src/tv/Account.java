package tv;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Account implements Comparable<Account>{
	
	private Lock lock = new ReentrantLock();
	private int balance;
	private int id;
	private AtomicInteger failCounter = new AtomicInteger(0);
	
	public Lock getLock() {
		return lock;
	}

	public Account(int id, int initialBalance){
		this.id = id;
		this.balance = initialBalance;
	}
	public void withdraw(int amount){
		try{
			lock.lock();
			balance -= amount;
		}finally{
			lock.unlock();
		}
	}
	
	public void deposit(int amount){
		try{
			lock.lock();
			balance += amount;
		}finally{
			lock.unlock();
		}
	}
	public synchronized int getBalance() {
		return balance;
	}

	public int getId() {
		return id;
	}

	@Override
	public int compareTo(Account acc2) {
		int idFirst = this.getId();
		int idSecond = acc2.getId();
			if(idFirst < idSecond){
				return -1;
			}else if(idFirst == idSecond){
				return 0;
			}else{
				return 1;
			}
	}

	public AtomicInteger getFailCounter() {
		return failCounter;
	}

	public void setFailCounter(AtomicInteger failCounter) {
		this.failCounter = failCounter;
	}
}
