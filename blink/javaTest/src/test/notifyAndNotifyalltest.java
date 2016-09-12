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
		
		public void say(){
			synchronized(this){
			System.out.println("1111");
			try {
				this.wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("0000");
			}
		}

		public void run() {
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
	static class MyThreadd11 extends Thread{
		Object o ;
		public MyThreadd11(Object o) {
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
		
		public void say(){
			synchronized(this){
			System.out.println("1111");
			try {
				this.wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("0000");
			}
		}

		public void run() {
				synchronized (o) {
					System.out.println("5000start");
					try {
						Thread.sleep(5000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					System.out.println("5000end");
					try {
						o.wait();
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
		}
	}
	
	static class MyThreadc extends Thread{
		public static int ii = 0;

		public void run() {
			
			synchronized(this){
				System.out.println("MyThreadc@@@");
				try {
					Thread.sleep(5000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				System.out.println("MyThreadc@@@end");
			}
		}
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Object o = new Object();
		MyThreadc tc = new MyThreadc();
		tc.start();
		/*MyThreadd11 t111 = new MyThreadd11(MyThreadc.ii);
		t111.start();*/
		MyThreadd t1 = new MyThreadd(tc);
		MyThreadd t2 = new MyThreadd(tc);
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		t1.start();
		t2.start();
		/*tc.start();
		tc2.start();*/
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		/*synchronized(t1){
			t1.notifyAll();
//			t1.notify();
		}*/
//		t1.mynotify();
		t1.mynotifyall();

	}

}
