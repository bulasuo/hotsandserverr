package myThread;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.InputStreamReader;
import java.io.RandomAccessFile;


public class HelloWord {
	
	 public static boolean createFile(File fileName)throws Exception{  
		  boolean flag=false;  
		  try{  
		   if(!fileName.exists()){  
		    fileName.createNewFile();  
		    flag=true;  
		   }  
		  }catch(Exception e){  
		   e.printStackTrace();  
		  }  
		  return true;  
		 }   
		   
		 /** 
		  * ��TXT�ļ����� 
		  * @param fileName 
		  * @return 
		  */  
		 public static String readTxtFile(File fileName)throws Exception{  
		  String result=null;  
		  FileReader fileReader=null;  
		  BufferedReader bufferedReader=null;  
		  try{  
		   fileReader=new FileReader(fileName);  
		   bufferedReader=new BufferedReader(fileReader);  
		   try{  
		    String read=null;  
		    while((read=bufferedReader.readLine())!=null){  
		     result=result+read+"\r\n";  
		    }  
		   }catch(Exception e){  
		    e.printStackTrace();  
		   }  
		  }catch(Exception e){  
		   e.printStackTrace();  
		  }finally{  
		   if(bufferedReader!=null){  
		    bufferedReader.close();  
		   }  
		   if(fileReader!=null){  
		    fileReader.close();  
		   }  
		  }  
		  System.out.println("��ȡ�������ļ������ǣ�"+"\r\n"+result);  
		  return result;  
		 }  
		   
		 public static void contentToTxt(String filePath, String content) {  
		        String str = new String(); //ԭ��txt����  
		        String s1 = new String();//���ݸ���  
		        try {  
		            File f = new File(filePath);  
		            if (f.exists()) {  
		                System.out.print("�ļ�����");  
		            } else {  
		                System.out.print("�ļ�������");  
		                f.createNewFile();// �������򴴽�  
		            }  
		            BufferedReader input = new BufferedReader(new FileReader(f));  
		  
		            while ((str = input.readLine()) != null) {  
		                s1 += str + "\n";  
		            }  
		            System.out.println(s1);  
		            input.close();  
		            s1 += content;  
		  
		            BufferedWriter output = new BufferedWriter(new FileWriter(f));  
		            output.write(s1);  
		            output.close();  
		        } catch (Exception e) {  
		            e.printStackTrace();  
		  
		        }  
		    }  
		   
		 public static boolean writeTxtFile(String content,File  fileName)throws Exception{  
			 createFile(fileName);
		  RandomAccessFile mm=null;  
		  boolean flag=false;  
		  FileOutputStream o=null;  
		  FileWriter ww=null;
		  
		  
		
		  
		  
		  try {  
		   o = new FileOutputStream(fileName,true);  
		      o.write(content.getBytes("GBK"));  
		      o.close();  
		//   mm=new RandomAccessFile(fileName,"rw");  
		//   mm.writeBytes(content);  
		   flag=true;  
		  } catch (Exception e) {  
		   // TODO: handle exception  
		   e.printStackTrace();  
		  }finally{  
		   if(mm!=null){  
		    mm.close();  
		   }  
		  }  
		  return flag;  
		 }  

	/**
	 * @param args
	 * @throws Exception 
	 */
	public static void main(String[] args) throws Exception {
		System.out.println("myTestStart");
//		writeTxtFile("������&&С����",new File("D:/00bulasuo/�ҵı���/������.txt"));
//		readTxtFile(new File("D:/00bulasuo/�ҵı���/������.txt"));
		
//		for(int i=0;i<100;i++){
//		FileOutputStream out = new FileOutputStream(new File("D:/00bulasuo/�ҵı���/������.txt"),true);
//		out.write("������������".getBytes("utf-8"), 0, 9);//gbk:һ��������2���ֽڣ�
//														  //utf-8:һ������3���ֽ�
//		out.close();}
		
		//��ȡ
//		BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream("D:/00bulasuo/�ҵı���/������.txt"),"utf-8"));
//		System.out.println(reader.readLine());
//		BufferedReader reader = new BufferedReader(new FileReader("D:/00bulasuo/�ҵı���/������.txt"));
//		System.out.println(new String(reader.readLine().getBytes(),"utf-8"));
						//������
				//		ObjectOutputStream ois = new ObjectOutputStream(currentSocket.getOutputStream());
				//		ois.writeObject(weatherlist);
				//		ois.flush();
		
		//д��
//		FileOutputStream out = new FileOutputStream(new File("D:/00bulasuo/�ҵı���/������.txt"),true);
//		out.write("yy���⼦������ddddddd������".getBytes("utf-8"));
//		out.close();
		
		//FileinputStream��ȡ
//		@SuppressWarnings("resource")
//		FileInputStream in = new FileInputStream(new File("D:/00bulasuo/�ҵı���/������.txt"));
//		byte[] b = new byte[9999];
//		
//		for(int i=0;i<30;i++)System.out.println(":"+in.read(b));
//		while((in.read(b)) > 0 ){
//		System.out.println("::\n"+new String(b,"utf-8"));
//		}
//		in.close();
		
		//BufferedReader��ȡ
//		BufferedReader read = new BufferedReader(new FileReader("D:/00bulasuo/�ҵı���/������.txt"));
//		System.out.println(new String(read.readLine().getBytes(),"utf-8"));
//		read.close();
		
////////////////////////////////////////////////////////////////////////////////////
		//�ļ��Ĵ�ȡ   ��json
//		FileOutputStream out = new FileOutputStream(new File("D:/00bulasuo/�ҵı���/������.txt"),true);
//		for(int i=0;i<12;i++)
//			out.write("[<ʱ��><�ص�><����><��ʽ><����>]".getBytes("utf-8"));
//		out.close();
//		
//		BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream("D:/00bulasuo/�ҵı���/������.txt"),"utf-8"));
////		System.out.println(":\n"+reader.readLine().substring(1));//ȥ��utf-8������һ���ʺŵ����� ��substring����//json��װ�������ʺ�
//		String sbuf[] = reader.readLine().substring(1).split("\\]\\[");
//		for(int i=0;i<sbuf.length;i++){
//			String s[] = sbuf[i].split("\\>\\<");
//			System.out.println(s.length);
//			for(int j=0;j<s.length;j++)
//				System.out.print("::"+s[j].replace("[", "").replace("<", "").replace(">", "").replace("]", ""));
//		}
//////////////////////////////////////////////////////////////////////////////////////////
//		//����json����
//		String json1 = "{data:[{name:'Wallace'},{name:'Grommit'}]}";
//		jsonObjSplit = new JSONObject(json1);
//		JSONArray ja = jsonObjSplit.getJSONArray("data");
//		for (int i = 0; i < ja.length(); i++) {
//		JSONObject jo = (JSONObject) ja.get(i);
//		System.out.println(jo.get("name"));
//		}
		//�ļ��Ĵ�ȡ  json
//		FileOutputStream out = new FileOutputStream(new File("D:/00bulasuo/�ҵı���/������.txt"));
//		JSONArray jsonList = new JSONArray();
//		JSONObject json = new JSONObject();
//		json.put("address", "�Ͼ�");
//		json.put("time", "2015");
//		json.put("method", "positive");
//		json.put("plot", "null");
//		json.put("name", "����");
//		for(int i=0;i<5;i++){
//			jsonList.put(json);
//		}
//		//		JSONObject json1 = new JSONObject();
//		//		json1.put("myList", jsonList);
//		//		System.out.println(json1.toString());
//		out.write(jsonList.toString().getBytes("utf-8"));
//		out.close();
//		
//		BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream("D:/00bulasuo/�ҵı���/������.txt"),"utf-8"));
//		String s = reader.readLine();
////		System.out.println(":"+s);
//		jsonList = new JSONArray(s);
//		for(int i=0;i<jsonList.length();i++){
//			System.out.println(((JSONObject)jsonList.get(i)).get("address"));
//		}
//		
//		System.out.println(jsonList.toString());
		
//////////////////////////////////////////////////////////////////////////////////////////	
       //Ĭд��
		
		
		
		
		
		
		
		
//////////////////////////////////////////////////////////////////////////////////////////
		
		
		
		
		
		System.out.println("myTestEnd");

	}

}
