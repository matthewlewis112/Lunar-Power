package server;
import java.net.*;
import java.sql.*;

import java.io.*;

public class Server {
	public static void main(String[] args) throws IOException {
		ServerSocket serverSocket = null;
		try {
			MySQLAccess dao = new MySQLAccess();
			dao.readDataBase();
		} catch (Exception e) {
			System.err.println("Cannot read db");
		}
		try {
			serverSocket = new ServerSocket(8000);
		} catch (IOException e) {
			System.err.println("Could not listen on port: 8000");
			System.exit(1);
		}
		
		Socket clientSocket = null;
		try {
			clientSocket = serverSocket.accept();
		} catch (IOException e) {
			System.err.println("Accept failed.");
			System.exit(1);
		}
		
		PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
		BufferedReader in = new BufferedReader(
				new InputStreamReader(
				clientSocket.getInputStream()));
		String inputLine, outputLine;
		LWebProtocol kkp = new LWebProtocol();
		
		outputLine = kkp.processInput(null);
		out.println(outputLine);
		
		while ((inputLine = in.readLine()) != null ) {
			outputLine = kkp.processInput(inputLine);
			out.println(outputLine);
			if (outputLine.contentEquals("Bye."))
				break;
		}
		out.close();
		in.close();
		clientSocket.close();
		serverSocket.close();
		
	}
}
