package tv;

public class Listener implements Runnable {

	@Override
	public void run() {
		System.out.println("Accaunt 1 = " + Operation2.acc1.getBalance() + ",  Accaunt 2 = " + Operation2.acc2.getBalance());
		 System.out.println("Accaunt 1, failed transactions = " + Operation2.acc1.getFailCounter() + ",  Accaunt 2, failed transactions = " + Operation2.acc2.getFailCounter());
	}

}
