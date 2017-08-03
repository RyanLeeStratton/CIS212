import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;


public class display {
	
	JFrame Frame = new JFrame();
	
	public display(){
		JPanel Example = new JPanel(new BorderLayout());
		Frame.add(Example);
		JButton click = new JButton("click");
		Example.add(click);
		click.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ev){
				
			}
		});
		
	
		Frame.setVisible(true);
		Frame.pack();
		Frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	
	public static void main(String[] args){
		
		display Art_Window = new display();
		
		
	}
	
}
