package org.stelo.gopher;

import java.net.Socket;
import javax.net.SocketFactory;

import java.io.IOException;
import java.io.*;

public class GopherConnection {
	public static int DEFAULT_PORT = 70;

	public String host;
	public int    port;

	public Socket sock = null;

	public BufferedReader in;
	public PrintWriter    out;

	public GopherConnection(String host, int port) {
		this.host = host;
		this.port = port;
	}

	public GopherConnection(String host) {
		this(host, DEFAULT_PORT);
	}

	public GopherConnection(Socket sock) {
		this.sock = sock;
	}

	public void connect() throws IOException {
		if (sock == null) {
			sock = SocketFactory.getDefault().createSocket(host, port);
		}
		in  = new BufferedReader(new InputStreamReader(sock.getInputStream()));
		out = new PrintWriter(sock.getOutputStream());
	}

	public GopherMenu readMenu() throws IOException {
		GopherMenu menu = new GopherMenu();
		String line;

		while(((line = in.readLine()) != null) &&
			(!GopherMenu.isEnd(line))) {
			
			menu.add(line);
		}

		return menu;
	}

	public GopherMenu get(String path) throws IOException {
		out.print(path + "\r\n");
		out.flush();
		return readMenu();
	}		
}
