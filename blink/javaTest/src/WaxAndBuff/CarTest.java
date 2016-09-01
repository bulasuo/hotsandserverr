package WaxAndBuff;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class CarTest {	
	//�����һ��ȫ�ֵ�exec�����߳��жϺ� ���������ָ�
	static ExecutorService exec = Executors.newCachedThreadPool();
	static class WaxThread implements Runnable{
		private Car car;
		public WaxThread(Car car){this.car=car;}		
		public void run() {
			try {
				//�߳��ﶼҪ��һ�飨�ж��ж�-�ж��쳣��ָ����Ļ����Լ�д
				while(!Thread.interrupted()){car.wax();}
			} catch (InterruptedException e) {
				System.out.println(":1�жϻָ�����");
				//����ط��ǻָ����� 
				exec = Executors.newCachedThreadPool();
				exec.execute(this);
				e.printStackTrace();
			}
		}	
	}
	static class BuffThread implements Runnable{
		private Car car;
		public BuffThread(Car car){this.car = car;}
		public void run() {
			try {
				//�߳��ﶼҪ��һ�飨�ж��ж�-�ж��쳣��ָ����Ļ����Լ�д
				while(!Thread.interrupted()){car.buff();}
			} catch (InterruptedException e) {
				System.out.println(":2�жϻָ�����");
				exec = Executors.newCachedThreadPool();
				exec.execute(this);
				e.printStackTrace();
			}
			
		}
		
	}
	/**
	 * @param args
	 * @throws InterruptedException 
	 */
	public static void main(String[] args) throws InterruptedException {
		Car car = new Car();
		//�߳��ﶼҪ��һ�飨�ж��ж�-�ж��쳣��ָ����Ļ����Լ�д
		exec.execute(new BuffThread(car));
		exec.execute(new WaxThread(car));
		System.out.println("Start:");
		TimeUnit.SECONDS.sleep(10);
		exec.shutdownNow();
	}

}
