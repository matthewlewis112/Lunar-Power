package server;

import java.net.*;
import java.io.*;

public class LWebProtocol {
	private static final int WAITING = 0;
	private static final int SENT = 2;
	private static final int ANOTHER = 3;
	private static final int DONE = 4;
	
	private int state = WAITING;
	private int current = 0;
	
	public String processInput(String input) {
		String output = null;
		
		if (state == WAITING) {
			output = "Enter name: ";
			state = SENT;
		} else if (state == SENT) {
			output = "Processing";
			state = ANOTHER;
		} else if (state == ANOTHER) {
			output = "Recorded";
			state = DONE;
		} else if (state == DONE) {
			output = "Bye.";
			state = WAITING;
		}
		return output;
	}
}
