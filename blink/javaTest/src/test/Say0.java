package test;

public class Say0 {
	int id = 1;
	String content = "hello word";
	@Override
	public String toString() {
		return "Say [id=" + id + ", content=" + content + "]";
	}
	
	public void sayStr(String s){
		System.out.println("sayStr:"+s);
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
