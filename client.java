import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

//taken from class example
public class client extends JFrame{
	
	private ObjectOutputStream _stream;
	private JTextField _text;
	
	public client(){
		super();
		
		_text = new JTextField();
		
		JButton Send = new JButton("Send");
		
		Send.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				String Message = _text.getText();
				
				System.out.println(Message);
				
				try{
					_stream.writeUTF(Message);
					_stream.flush();
				}
				catch (IOException ex){
					System.err.println("Error 1");
				}
				_text.setText("");
			}
			
		});
		
		JPanel southPanel = new JPanel(new BorderLayout());
		southPanel.add(_text, BorderLayout.CENTER);
		southPanel.add(Send, BorderLayout.EAST);
		
		JTextArea area = new JTextArea(20,100);
		area.setEditable(false);
		
		setLayout(new BorderLayout());
		add(new JScrollPane(area), BorderLayout.CENTER);
		add(southPanel,BorderLayout.SOUTH);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		pack();
		setVisible(true);
	
	try{
	System.out.println("Connecting...");	
		
	Socket integerSocket = new Socket(InetAddress.getLocalHost(), 9000);
	
	System.out.println("Connecting...");
	System.out.println("Please enter multiple different integers.");
	Scanner scan = new Scanner(System.in);
	
	ArrayList integerlist = new ArrayList();

	String intSize = scan.nextLine();
	
	
	
	_stream = new ObjectOutputStream(integerSocket.getOutputStream());
	_stream.flush();
	
	ObjectInputStream input = new ObjectInputStream(integerSocket.getInputStream());
	
		try{
			
			while (true) {
				String Datainput = input.readUTF();
				
				System.out.println(Datainput);
				
				area.append(Datainput + "\n");
			}
		}				
		finally {
			// Clean up when app exits.
			_stream.close();
			input.close();
			
			integerSocket.close();
		}
		}
		catch (IOException ex) { 
		System.err.println("Error 2");
		}
	
	System.out.println("CLIENT TERMINATING");
	}
	
	public static void main(String[] args) {
		new client();
	}
}

