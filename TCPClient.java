package client_server;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;



public class TCPClient {

	@SuppressWarnings("resource")
	public static void main(String[] args) {
		Socket socket;
		InputStream in = null;
		OutputStream out = null;
		try {
			socket = new Socket("127.0.0.1",6789);
			
			in = socket.getInputStream();
			out = socket.getOutputStream();
			BufferedReader br = new BufferedReader(new InputStreamReader(in));
			//PrintWriter pw = new PrintWriter(out);
			DataOutputStream outPut = new DataOutputStream(out)	;		
			Scanner sc = new Scanner(System.in);
			boolean cont = true;//cont means continue
			
			while(cont){
				System.out.print("\n Enter a word to be reversed by server or END to terminate program \n");
				String array = sc.nextLine();
				outPut.writeBytes(array +"\n");
				
				String fromServer = br.readLine();
				
				System.out.print("\n reversed word: " + fromServer);
				
				if( array.equalsIgnoreCase("END") ){
					cont = false;
					System.out.print("\n Program terminating \n");
				}
			}
			
			
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			try {
				out.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				in.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}	
	}
}
