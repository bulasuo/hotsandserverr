package WaxAndBuff;

import java.util.concurrent.TimeUnit;

public class Car {
	private boolean WaxOn = false;
	/**
	 * waxed 上蜡
	 * @throws InterruptedException 
	 */
	public synchronized void wax() throws InterruptedException{
		while(WaxOn == true){ wait(); }
		System.out.println("：我在上蜡");
		TimeUnit.SECONDS.sleep(4);
		WaxOn = true;
		notifyAll();		
	}
	public synchronized void buff() throws InterruptedException{
		while(WaxOn == false){wait(); }
		System.out.println("：我在抛光"); 
		TimeUnit.SECONDS.sleep(2);
		WaxOn = false;
		notifyAll();
	}
	
}
