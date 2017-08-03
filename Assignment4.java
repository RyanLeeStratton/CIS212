/**
 * Ryan Stratton
 * CIS212 
 * Assignment 4
 *
 */

//I hated this assignment, I didn't learn anything and we were still covering it on Monday.
//I was mindlessly copying random bits of code from stackoverflow,java 7 docs and your examples until something worked.
//I have no idea why anything does what they do.
//no idea if you even read this but I would greatly appreciate seeing a functional example(of this assignment) to 
//learn from at some point.



import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Main{
	
	JFrame Frame = new JFrame("Paint Window");
	private Paint Paint_Area;
	
	int SIZE = 20;
	
	int COLOR = 1;
	
	public Main(){
		JPanel Button_Window = new JPanel(new GridBagLayout());
		
		GridBagConstraints Alignments = new GridBagConstraints();
		Button_Window.setPreferredSize(new Dimension(650,335));
		
		Alignments.gridx = 1;
		Alignments.gridy = 0;
		Alignments.ipadx = 50;
		Alignments.ipady = 50;
		Alignments.anchor = GridBagConstraints.WEST;
		JButton Blue_Color = new JButton("  Blue  ");
		Button_Window.add(Blue_Color, Alignments);
		Blue_Color.setBackground(new Color(200, 200, 200));
		Blue_Color.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ev){
				COLOR = 3;
			}
		});
		Alignments.weightx = 0.1;
		Alignments.weighty = 0.1;
		Alignments.gridx = 1;
		Alignments.gridy = 1;
		JButton Green_Color = new JButton("Green ");
		Button_Window.add(Green_Color, Alignments);
		Green_Color.setBackground(new Color(200, 200, 200));
		Green_Color.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ev){
				COLOR = 5;
			}
		});
		
		Alignments.gridx = 1;
		Alignments.gridy = 2;
		JButton Yellow_Color = new JButton("Yellow");
		Button_Window.add(Yellow_Color, Alignments);
		Yellow_Color.setBackground(new Color(200, 200, 200));
		Yellow_Color.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ev){
				COLOR = 4;
			}
		});
		
		Alignments.gridx = 1;
		Alignments.gridy = 3;
		JButton Red_Color = new JButton("  Red   ");
		Button_Window.add(Red_Color, Alignments);
		Red_Color.setBackground(new Color(200, 200, 200));
		Red_Color.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ev){
				COLOR = 2;
			}
		});
		
		Alignments.gridx = 1;
		Alignments.gridy = 4;
		Alignments.ipadx = 52;
		JButton Black_Color = new JButton("Black ");
		Button_Window.add(Black_Color, Alignments);
		Black_Color.setBackground(new Color(200, 200, 200));
		Black_Color.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ev){
			
				COLOR = 1;
			}
		});
		
		Alignments.gridx = 3;
		Alignments.gridy = 0;
		Alignments.ipadx = 58;
		Alignments.anchor = GridBagConstraints.EAST;
		JButton Tiny = new JButton(" Tiny ");
		Button_Window.add(Tiny, Alignments);
		Tiny.setBackground(new Color(200, 200, 200));
		Tiny.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ev){
				SIZE = 5;
			}
		});
		
		Alignments.gridx = 3;
		Alignments.gridy = 1;
		Alignments.ipadx = 52;
		Alignments.anchor = GridBagConstraints.EAST;
		JButton Small = new JButton("Small ");
		Button_Window.add(Small, Alignments);
		Small.setBackground(new Color(200, 200, 200));
		Small.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ev){
				SIZE = 10;
			}
		});
		
		Alignments.gridx = 3;
		Alignments.gridy = 2;
		Alignments.ipadx = 46;
		Alignments.anchor = GridBagConstraints.EAST;
		JButton Normal = new JButton("Normal");
		Button_Window.add(Normal, Alignments);
		Normal.setBackground(new Color(200, 200, 200));
		Normal.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ev){
				SIZE = 20;
			}
		});
		
		Alignments.gridx = 3;
		Alignments.gridy = 3;
		Alignments.ipadx = 51;
		Alignments.anchor = GridBagConstraints.EAST;
		JButton Large = new JButton("Large ");
		Button_Window.add(Large, Alignments);
		Large.setBackground(new Color(200, 200, 200));
		Large.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ev){
				SIZE = 40;
			}
		});
		
		Alignments.gridx = 3;
		Alignments.gridy = 4;
		Alignments.ipadx = 54;
		Alignments.anchor = GridBagConstraints.EAST;
		JButton Clear = new JButton("Clear ");
		Button_Window.add(Clear, Alignments);
		Clear.setBackground(new Color(200, 200, 200));
		Clear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ev){
				
				
			}
		});
		
		
		Alignments.gridx = 2;
		Alignments.gridy = 0;
		Alignments.ipadx = 350;
		Alignments.ipady = 380;
		Alignments.gridheight = 5;
		Alignments.fill = GridBagConstraints.CENTER;
		Paint Paint_Area = new Paint();
		
		Paint_Area.setBackground(new Color(255, 255, 255));
		Button_Window.add(Paint_Area, Alignments);
		

		Frame.setResizable(false);
		Frame.add(Button_Window);
		Frame.setVisible(true);
		Frame.pack();
		
	}
	
	//Was never able to change size or color independent of other points. Honestly have no idea why this code
	//below (the code you provided in class) even works.
		private class Paint extends JPanel{
		private ArrayList<Point> Location;
		
		public Paint(){
			
			Location = new ArrayList();
			addMouseMotionListener(new MouseMotionAdapter() {
				public void mouseDragged(MouseEvent ev) {
					Location.add(ev.getPoint());
					
					repaint();
						
					}
			});
		}
		
		@Override
		public void paintComponent(Graphics g) {
			super.paintComponent(g);
			
			if(COLOR ==1 )
			g.setColor(Color.BLACK);
			if(COLOR ==2 )
			g.setColor(Color.RED);
			if(COLOR ==3 )
			g.setColor(Color.BLUE);
			if(COLOR ==4 )
			g.setColor(Color.YELLOW);
			if(COLOR ==5 )
			g.setColor(Color.GREEN);
			
			
			for (Point point : Location){
				g.fillOval((int)point.getX(), (int)point.getY(), SIZE, SIZE);
			}
		}
		//Doesn't work, breaks shit
		public void clear() {
			//Location.clear();
			
			repaint();
		}
	}
	//main program that runs at compile
	public static void main(String[] args){
		
		Main Art_Window = new Main();
		
		
	}

	}

	
