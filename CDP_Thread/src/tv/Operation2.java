package tv;

import java.util.Random;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

public class Operation2 {
	static Random rnd = new Random(48);
	static Listener listener = new Listener();
	private final static ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);
	static public Account acc1 = new Account(1, rnd.nextInt(2000));
	static public Account acc2 = new Account(2, rnd.nextInt(2000));
	public static final CountDownLatch countdown = new CountDownLatch(9);
	public static void main(String[] args) throws InterruptedException, IFException {
		

		ExecutorService service = Executors.newFixedThreadPool(3);
		for (int id = 0; id < 10; id++) {
			
			service.submit(new Transfer(acc1, acc2, rnd.nextInt(400), id));
		}

		final ScheduledFuture<?> beeperHandle = scheduler.scheduleAtFixedRate(listener, 1, 1, TimeUnit.SECONDS);
		
		service.shutdown();
		service.awaitTermination(20, TimeUnit.SECONDS);
		beeperHandle.cancel(true);


		System.out.println("Accaunt 1 = " + acc1.getBalance() + ",  Accaunt 2 = " + acc2.getBalance());
		 System.out.println("Accaunt 1, failed transactions = " + acc1.getFailCounter() + ",  Accaunt 2, failed transactions = " + acc2.getFailCounter());
	}

}
