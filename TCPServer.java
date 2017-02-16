package client_server;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class TCPServer {

	@SuppressWarnings("resource")
	public static void main(String[] args) throws IOException {
		ServerSocket server = new ServerSocket(6789);
		Socket socket = server.accept();
		
		InputStream in = socket.getInputStream();
		OutputStream out = socket.getOutputStream();
		
		BufferedReader br = new BufferedReader(new InputStreamReader(in));
		//PrintWriter pw = new PrintWriter(out);
		DataOutputStream output = new DataOutputStream(out);
		while(true){
			String word = br.readLine();
			String reversed = "";
		
			for(int i = word.length()-1; i>= 0; i--){
				reversed = reversed + word.charAt(i);
			}
			
			output.writeBytes(reversed +"\n");
		
		}
	}

}
