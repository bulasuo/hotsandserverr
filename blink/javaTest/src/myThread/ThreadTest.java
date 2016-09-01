package myThread;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


public class ThreadTest {

	static class LiftOff implements Runnable{
		protected int countDown = 10;//Default
		private static int taskCount = 0;
		private final int id = taskCount++;
		public LiftOff(){}
		public LiftOff(int countDown){
			this.countDown = countDown;
			
		}
		public String status(){
			return "#" + id +"(" + (countDown > 0 ? countDown : "LiftOff!") + "),";
		}
		public void run(){
			while(countDown-- > 0){
				System.out.println(status());
				Thread.yield();   //同优先级线程之间对cpu资源的让步
			}
		}
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
//		//ExecutorService exec = Executors.newSingleThreadExecutor();
//		//ExecutorService exec = Executors.newCachedThreadPool();//首选，和下面一种线程池一样  都是会复用已有的线程的
//		ExecutorService exec = Executors.newFixedThreadPool(3); //限定线程数
//		for(int i=0;i<5;i++){
//			exec.execute(new LiftOff());
//		}
//		exec.shutdown();//防止新任务交给exec		
		
		System.out.println("\'");
	}

}
