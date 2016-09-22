package test;

/**
 * throw 只是告诉调用者要进行异常捕获,就算,没有throw 遇到异常还是一层层向上传递,最多传递到进程导致进程错误退出
 * @author Administrator
 *
 */
public class exceptionTest {

	public static void say1(String s){
		System.out.println(s.equals("--"));
	}
	
	public static void say0(String s) throws Exception{
		say1(s);
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
int i = 10;
		try{
			switch(i){
			case 10:
				say0(null);
				break;
			}
			
		}catch(Exception e){
			System.out.println("::"+e);
		}
	}

}
