

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Tela extends JFrame {

	public ArrayList<BufferedImage> imagens = new ArrayList<BufferedImage>();

	public Tela(){
		super("Concorrencia");
		setSize(200, 200);
		setLayout(new GridLayout());
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);	
		repaint();
	}
		
	public void setImageView(Color color, String title){
		JPanel jpanel = new JPanel();
		//ImageIcon icon = new ImageIcon(image);
		//JLabel label = new JLabel(icon);
		
		JLabel legend = new JLabel(title);
		
		jpanel.setLayout(new FlowLayout());		
		
		//label.setVisible(true);
		legend.setVisible(true);
				
		jpanel.add(legend);
		
		//jpanel.add(label);			
		
		jpanel.repaint();
		jpanel.setBackground(color);
		add(jpanel);
		repaint();
	}
	
	public void setColor(String title, Color color){
		
		JPanel jpanel = new JPanel();
		//ImageIcon icon = new ImageIcon(image);
		//JLabel label = new JLabel(icon);
		
		JLabel legend = new JLabel(title);
		
		jpanel.setLayout(new FlowLayout());		
		
		//label.setVisible(true);
		legend.setVisible(true);
				
		jpanel.add(legend);
		
		//jpanel.add(label);			
		
		jpanel.repaint();
		jpanel.setBackground(color);
		this.getContentPane().removeAll();
		this.getContentPane().invalidate();

		this.getContentPane().add(jpanel);
		this.getContentPane().revalidate();
		repaint();
	}
	
	public void updateCanvas() {
	   
	}
}

