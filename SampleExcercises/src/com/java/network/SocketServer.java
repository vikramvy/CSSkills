package com.java.network;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.TimeUnit;
class RequestHandler extends Thread{
	private Socket clientSocket;
	public RequestHandler(Socket socket) {
		this.clientSocket = socket;
	}
	@Override
	public void run() {
		try {
			System.out.println( "Receive the connection..");
			BufferedReader reader = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
			PrintWriter out = new PrintWriter(clientSocket.getOutputStream());
			out.println("Echo Server 1.0");
			out.flush();
			String line = reader.readLine();
			while(line!=null & line.length() >0)
			{
				out.println("Echo "+line);
				out.flush();
				line = reader.readLine();
			}
			reader.close();out.close();clientSocket.close();
			System.out.println("Connections Closed");
		}catch (IOException e)
		{
			e.printStackTrace();
		}
		
		
	}
}
public class SocketServer extends Thread{
	
	private ServerSocket serverSocket;
	private Socket clientSocket;
	private PrintWriter out;
	private BufferedReader in;
	private boolean running = false;
	private int port;
	public SocketServer(int port)
	{
		this.port = port;
	}
	public void startServer()
	{
		try {
			serverSocket = new ServerSocket(port);
			this.start();
		}catch (IOException e)
		{
			e.printStackTrace();
		}
	}
	public void stopServer()
	{
		running = false;
		this.interrupt();
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		//super.run();
		running = true;
		while(running)
		{
			try {
					System.out.println("Listening for Connections ...");
					Socket socket = serverSocket.accept();
					RequestHandler handler = new RequestHandler(socket);
					handler.start();
			}catch(IOException e)
			{
				e.printStackTrace();
			}
		}
		
	}
	
	

	
	public void start(int port) throws IOException
	{
		serverSocket = new ServerSocket(port);
		clientSocket = serverSocket.accept();
		
		out = new PrintWriter(clientSocket.getOutputStream(),true);
		in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
		String greeting = in.readLine();
		if("hello server".equals(greeting))
		{
			out.println("hello Client");
			
		}else
		{
			out.println("Not recognized client - greeting");
		}
	}
	
	/*public void stop() throws IOException
	{
		in.close(); out.close();clientSocket.close();serverSocket.close();
	}*/
	public static void main(String[] args) {
		SocketServer server = new SocketServer(6666);
		server.startServer();
		
		try {
			TimeUnit.MILLISECONDS.sleep(1000);
			
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		server.stopServer();
		
		
		/*try {
			server.start(6666);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
	}
}

	