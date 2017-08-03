import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

//taken from class example
public class server {
	
	public static void main(String[] args){
	ServerSocket integerServersocket;
	try {
		
		System.out.println("Creating socket...");
		
		integerServersocket = new ServerSocket(9000);
		
		System.out.println("Waiting for connection...");
		
		Socket integerSocket = integerServersocket.accept();
		
		System.out.println("Connected");
		
		ObjectOutputStream stream = new ObjectOutputStream(integerSocket.getOutputStream());
		stream.writeUTF("hi");
		
		System.out.println("Message sent");
		
		stream.flush();
		//stream.close();
		
		//integerSocket.close();
		
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		
		System.out.println("Server shutting down");
	}

}


}
