package niit.ten.ui;

import java.awt.BorderLayout;
import java.awt.Dialog;
import java.awt.EventQueue;
import java.awt.Image;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;

import niit.ten.util.swing.CutImage;

import javax.swing.JLabel;

public class CutImageDialog extends JDialog {

	private JPanel contentPane;
	
	CutImage ciCutImage=null;
	/**
	 * Launch the application.
	 */
/*	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					//CutImageDialog ui = new CutImageDialog(null,new File("image/timgcopy.jpg"));
					CutImageDialog ui = new CutImageDialog(null,new File("image/Penguins.jpg"));
					ui.setVisible(true);
					Image image=ui.getImage();
					System.out.println(image);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}*/

	/**
	 * Create the ui.
	 */
	public BufferedImage  getImage(){
		if(this.ciCutImage.hasPrevious()){
			return this.ciCutImage.getImage();			
		}else{
			return null;
		}
	}
	public CutImageDialog(JFrame frame,File file) {
		
		super(frame, true);
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		}catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		SwingUtilities.updateComponentTreeUI(this); 
		BufferedImage input = null;
		try {
			input = ImageIO.read(file);
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		
		double y=input.getHeight()/384.0;
		double x=input.getWidth()/512.0;
		double re=Math.max(y, x);
		
		int h=(int) (input.getHeight()/re);
		int w=(int) (input.getWidth()/re);
		Image scaledImage = input.getScaledInstance(w,h,Image.SCALE_DEFAULT);
		
		//BufferedImage output = new BufferedImage(w,h,BufferedImage.TYPE_BYTE_INDEXED);
		BufferedImage output = new BufferedImage(w,h,BufferedImage.TYPE_INT_BGR);
		output.createGraphics().drawImage(scaledImage, 0, 0, null); //画图
		setTitle("图片剪切");
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		
		setBounds(100, 100, w+18, h+36);
		this.setResizable(false);
		this.setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		ciCutImage=new CutImage(this,output);
		contentPane.add(ciCutImage, BorderLayout.CENTER);
		this.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if((e.isControlDown() == true) &&
						e.getKeyCode() ==KeyEvent.VK_Z){
					if(ciCutImage.hasPrevious()){
						ciCutImage.previous();
					}
				}
				if((e.isControlDown() == true) &&
						e.getKeyCode() ==KeyEvent.VK_Y){
					if(ciCutImage.hasNext()){
						ciCutImage.next();
					}
				}
			}
		});
	}
}
