import java.awt.Dimension;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class MainFrame extends JFrame implements ActionListener {
	private JPanel Paint_Window;
	public MainFrame(){
		
		
		
		setLayout(new GridLayout(1,4));
		
		JButton Blue = new JButton("Blue");
		Blue.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ev) {
				
				
				
			}
		});
		add(Blue);
		
		JButton Yellow = new JButton("Yellow");
		Yellow.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ev) {
				
				
				
			}
		});
		add(Yellow);

		JButton Red = new JButton("Red");
		Red.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ev) {
				
				
				
			}
		});
		add(Red);
	
		JButton Green = new JButton("Green");
		Green.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ev) {
				
				
				
			}
		});
		add(Green);
		
		
		pack();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}
	
	public static void main(String[] args) {
		
		
		MainFrame Window = new MainFrame();
		Window.setVisible(true);
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
}
