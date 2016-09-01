package htmlUnit;

import java.net.MalformedURLException;
import java.net.URL;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class DisplayImageIcon extends JFrame {

private JLabel lblImg;
private Icon icon;

public DisplayImageIcon(String myurl) {

setTitle("swing显示图片");
setSize(1200, 750);
setDefaultCloseOperation(DISPOSE_ON_CLOSE);

lblImg = new JLabel();
add(lblImg);
setVisible(true);





	try {
		icon = new ImageIcon(new URL(myurl));
		} catch (MalformedURLException e) {
		e.printStackTrace();
		}
	lblImg.setIcon(icon);





//new Thread(new Runnable(){
//	
//@Override
//public void run() {
//	try {
//		icon = new ImageIcon(new URL(myurl));
//		} catch (MalformedURLException e) {
//		e.printStackTrace();
//		}
//	lblImg.setIcon(icon);
//}
//
//}).start();
}




}
