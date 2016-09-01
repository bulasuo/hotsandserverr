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
				Thread.yield();   //ͬ���ȼ��߳�֮���cpu��Դ���ò�
			}
		}
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
//		//ExecutorService exec = Executors.newSingleThreadExecutor();
//		//ExecutorService exec = Executors.newCachedThreadPool();//��ѡ��������һ���̳߳�һ��  ���ǻḴ�����е��̵߳�
//		ExecutorService exec = Executors.newFixedThreadPool(3); //�޶��߳���
//		for(int i=0;i<5;i++){
//			exec.execute(new LiftOff());
//		}
//		exec.shutdown();//��ֹ�����񽻸�exec		
		
		System.out.println("\'");
	}

}
