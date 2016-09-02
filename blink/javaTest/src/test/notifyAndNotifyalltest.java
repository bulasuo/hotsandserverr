package test;

import htmlUnit.myTest01;

public class notifyAndNotifyalltest {
	static byte bb;
	static byte bbb;
	
	static class MyThreadd extends Thread{
		Object o ;
		public MyThreadd(Object o) {
			this.o = o;
		}
		public void mynotify(){
			synchronized (o) {
				o.notify();
			}
		}
		
		public void mynotifyall(){
			synchronized (o) {
				o.notifyAll();
			}
		}

		public void run() {
			while(true){
				synchronized (o) {
					System.out.println("@@@");
					try {
						o.wait();
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		}
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Object o = new Object();
		MyThreadd t1 = new MyThreadd(o);
		MyThreadd t2 = new MyThreadd(o);
		t1.start();
		t2.start();
//		t1.mynotify();
		t1.mynotifyall();

	}

}
