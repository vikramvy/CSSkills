package com.java.network;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class SocketClient {
	private Socket clientSocket;
	private PrintWriter out;
	private BufferedReader in;

	public void startConnection(String ip, int port) throws IOException{
		clientSocket = new Socket(ip, port);
		out = new PrintWriter(clientSocket.getOutputStream(),true);
		in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
		
	}
	public String sendMessage(String msg) throws IOException
	{
		out.println(msg);
		String response = in.readLine();
		return response;
	}
	public void stopConnection() throws IOException
	{
		in.close();out.close();clientSocket.close();
	}
	
	public static void main(String[] args) {
		SocketClient client = new SocketClient();
		String response="";
		try {
			client.startConnection("127.0.0.1",6666 );
			response= client.sendMessage("hello server");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(response!=null && !(response.isEmpty()))
				{
					System.out.println("Response from Server is "+response);
				}
	}
}
